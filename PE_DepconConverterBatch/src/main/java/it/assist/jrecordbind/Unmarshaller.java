/*
 * JRecordBind, fixed-length file (un)marshaller
 * Copyright 2009, Assist s.r.l., and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package it.assist.jrecordbind;

import it.assist.jrecordbind.RecordDefinition.Property;

import java.io.BufferedReader;
import java.io.File;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.xml.sax.InputSource;

/**
 * Unmarshalls an input reader into beans. The constructor takes the .xsd
 * definition, while the {@link #unmarshall(Reader)} takes the fixed length
 * file. You'll get back an Iterator instance: call {@link Iterator#hasNext()}
 * to start fetching from the input reader and then call {@link Iterator#next()}
 * to get the next bean
 * 
 * @author Federico Fissore
 */
public class Unmarshaller<E> extends AbstractUnMarshaller {

  private final class UnmarshallerIterator<T> implements Iterator<T> {

    private final Logger logger = Logger.getLogger(UnmarshallerIterator.class.getName());

    //private StringBuilder buffer;
    private final ConvertersCache converters;
    private final Pattern globalPattern;
    private final LineReader lineReader;
    private final BufferedReader reader;
    private final RegexGenerator regexGenerator;
    private Object currentRecord;

    public UnmarshallerIterator(ConvertersCache converters, StringBuffer buffer, LineReader lineReader,
        BufferedReader reader) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
      //this.lineReader = lineReader;
    	
//    	this.lineReader = new CedolinoReader();
			this.lineReader = (LineReader) Class.forName(className).getConstructor().newInstance();
    	
    	this.reader = reader;
     // this.buffer = buffer;
      this.converters = converters;
      this.regexGenerator = new RegexGenerator();
      this.globalPattern = regexGenerator.deepPattern(definition);
    }

    private void readNext() {
     if (currentRecord != null) {
        return;
      }
     long foundmillis = System.currentTimeMillis();
  	 
      String current = null;
      Matcher matcher = null;
      boolean found = false;
      
       
      
//      // Try to match a record on the current buffer.
//      // As long as there is no match, or the match ends completely at the
//      // buffer's end
//      // And there is one more line, read a new line, and add it to the buffer,
//      // then try again
//      long whilemillis = System.currentTimeMillis();
//      while ((!(found = (matcher = globalPattern.matcher(buffer)).find()) || matcher.end() == (buffer.length() - 1))
//          && (current = lineReader.readLine(reader)) != null) {        
//        buffer.append(current).append("\n");
//        
//      }
//      logger.log(Level.FINE,"While in "+(System.currentTimeMillis()-whilemillis));
      
      
      
      current = lineReader.readLine(reader);
      if(current !=null){
    	  matcher = globalPattern.matcher(current);
    	  found = matcher.find();
      }
      else{
    	  logger.log(Level.FINE,"No more records.");
      }
      if (found) {
        try {
          Object record = Utils.newInstanceOf(definition.getClassLoader(), definition.getClassName());
          //StringBuilder currentBuffer = new StringBuilder(buffer.substring(matcher.start(), matcher.end()));
          StringBuffer currentBuffer = new StringBuffer(current.substring(matcher.start(), matcher.end()));
          
         // long recmillis = System.currentTimeMillis();
          // Parse the data from currentBuffer to record according to definition
          recursive(record, definition, currentBuffer);

          //buffer =  buffer.delete(0, matcher.end() + 1);
          //System.out.println("recursive in "+(System.currentTimeMillis()-recmillis));
          
          currentRecord = record;
          
          
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
      }
      else{
    	  if(current !=null){
	    	  Error error = new Error("Record not matched with pattern:\n" + matcher.pattern() );
	    	  StackTraceElement[] ste = {new StackTraceElement(this.getClass().toString(), "readNext()", current, 1)};
	    	  error.setStackTrace(ste);
	    	  throw error;
    	  }
      }
      logger.log(Level.FINE,"Found in "+(System.currentTimeMillis()-foundmillis));
      
      if (logger.isLoggable(Level.FINE)) {
        logger.log(Level.FINE, "A new record has been read");
      }
    }

    public boolean hasNext() {
      readNext();
      return currentRecord != null;
    }

    @SuppressWarnings("unchecked")
    public T next() {
      readNext();
      if (currentRecord == null) {
        throw new NoSuchElementException();
      }
      T current = (T) currentRecord;
      currentRecord = null;
      return current;
    }

    @SuppressWarnings("unchecked")
    private void recursive(Object record, RecordDefinition currentDefinition, StringBuffer currentBuffer)
        throws Exception {

      //If the current definition has direct properties, match and read them
      Matcher matcher = regexGenerator.localPattern(currentDefinition).matcher(currentBuffer);
      matcher.find();
      int groupCount = 1;
      Object convert = null;
      Property property;
      for (Iterator<Property> iter = currentDefinition.getProperties().iterator(); iter.hasNext();) {
        property = iter.next();
        convert = converters.get(property.getConverter()).convert(matcher.group(groupCount));
        propertyUtils.setProperty(record, property.getName(), convert);
        groupCount++;
      }
      // Then delete the matched section
      currentBuffer.delete(matcher.start(), matcher.end());

      // If the current definition has subrecords, handle them
      Matcher subMatcher;
      StringBuffer subBuffer;
      Object oProperty;
      Object subRecord;
      for (RecordDefinition subDefinition : currentDefinition.getSubRecords()) {
        int matchedRows = 0;
        while ((subMatcher = regexGenerator.deepPattern(subDefinition).matcher(currentBuffer)).find()
            && (subDefinition.getMaxOccurs() == -1 || matchedRows < subDefinition.getMaxOccurs())) {

          // Recurursively call this function for the found subrecord
          subBuffer = new StringBuffer(currentBuffer.substring(subMatcher.start(), subMatcher.end()));
          subRecord = Utils.newInstanceOf(subDefinition.getClassLoader(), subDefinition.getClassName());
          recursive(subRecord, subDefinition, subBuffer);
          currentBuffer.delete(subMatcher.start(), subMatcher.end());

          // Set, or add to the collection the property found above
          oProperty = propertyUtils.getProperty(record, subDefinition.getSetterName());
          if (oProperty instanceof Collection) {
            Collection<Object> collection = (Collection<Object>) oProperty;
            collection.add(subRecord);
          } else {
            propertyUtils.setProperty(record, subDefinition.getSetterName(), subRecord);
          }
          matchedRows++;
        }
      }
    }

    public void remove() {
    }

  }

  private final StringBuffer buffer;
  private final LineReader lineReader;
private String className;

  /**
   * Creates a new unmarshaller, reading the configuration specified in the
   * given definition and using the default LineReader implementation (that does
   * alter the current line) <br/>
   * This is the most convenient way to init the Marshaller since it will
   * resolve local XSDs
   *
   * @param definition
   *          the .xsd definition
   */
  public Unmarshaller(File definition) {
    this(Unmarshaller.class.getClassLoader(), definition, new SimpleLineReader());
  }

  /**
   * Creates a new unmarshaller, reading the configuration specified in the
   * given definition and using the default LineReader implementation (that does
   * alter the current line) <br/>
   * This is the most convenient way to init the Marshaller since it will
   * resolve local XSDs
   *
   * @param loader
   *          the classLoader
   * @param definition
   *          the .xsd definition
   */
  public Unmarshaller(ClassLoader loader, File definition) {
    this(loader, definition, new SimpleLineReader());
  }

  /**
   * Creates a new unmarshaller, reading the configuration specified in the
   * given definition and using the default LineReader implementation (that does
   * alter the current line) <br/>
   * Use this constructor only if your XSD is self contained (no
   * included/imported XSDs)
   *
   * @param definition
   *          the .xsd definition
   */
  public Unmarshaller(Reader definition, String className) {
    this(Unmarshaller.class.getClassLoader(), definition, new SimpleLineReader());
    this.className = className;
  }

  /**
   * Creates a new unmarshaller, reading the configuration specified in the
   * given definition and using the default LineReader implementation (that does
   * alter the current line) <br/>
   * Use this constructor only if your XSD is self contained (no
   * included/imported XSDs)
   *
   * @param loader
   *          the classLoader
   * @param definition
   *          the .xsd definition
   */
  public Unmarshaller(ClassLoader loader, Reader definition) {
    this(loader, definition, new SimpleLineReader());
  }

  /**
   * Creates a new unmarshaller, reading the configuration specified in the
   * given definition and using the default LineReader implementation (that does
   * alter the current line) <br/>
   * Use this constructor only if you know how to handle an InputSource
   *
   * @param definition
   *          the .xsd definition
   */
  public Unmarshaller(InputSource definition) {
    this(Unmarshaller.class.getClassLoader(), definition, new SimpleLineReader());
  }

  /**
   * Creates a new unmarshaller, reading the configuration specified in the
   * given definition and using the default LineReader implementation (that does
   * alter the current line) <br/>
   * Use this constructor only if you know how to handle an InputSource
   *
   * @param loader
   *          the classLoader
   * @param definition
   *          the .xsd definition
   */
  public Unmarshaller(ClassLoader loader, InputSource definition) {
    this(loader, definition, new SimpleLineReader());
  }

  /**
   * Creates a new unmarshaller, reading the configuration specified in the
   * given definition and using the given LineReader implementation
   *
   * @param definition
   *          the .xsd definition
   * @param lineReader
   *          a custom implementation of the LineReader
   */
  public Unmarshaller(File definition, LineReader lineReader) {
    this(Unmarshaller.class.getClassLoader(), Utils.toInputSource(definition), lineReader);
  }

  /**
   * Creates a new unmarshaller, reading the configuration specified in the
   * given definition and using the given LineReader implementation
   *
   * @param loader
   *          the classLoader
   * @param definition
   *          the .xsd definition
   * @param lineReader
   *          a custom implementation of the LineReader
   */
  public Unmarshaller(ClassLoader loader, File definition, LineReader lineReader) {
    this(loader, Utils.toInputSource(definition), lineReader);
  }

  /**
   * Creates a new unmarshaller, reading the configuration specified in the
   * given definition and using the given LineReader implementation
   *
   * @param definition
   *          the .xsd definition
   * @param lineReader
   *          a custom implementation of the LineReader
   */
  public Unmarshaller(Reader definition, LineReader lineReader) {
    this(Unmarshaller.class.getClassLoader(), Utils.toInputSource(definition), lineReader);
  }

  /**
   * Creates a new unmarshaller, reading the configuration specified in the
   * given definition and using the given LineReader implementation
   *
   * @param loader
   *          the classLoader
   * @param definition
   *          the .xsd definition
   * @param lineReader
   *          a custom implementation of the LineReader
   */
  public Unmarshaller(ClassLoader loader, Reader definition, LineReader lineReader) {
    this(loader, Utils.toInputSource(definition), lineReader);
  }

  public Unmarshaller(InputSource definition, LineReader lineReader) {
    this(Unmarshaller.class.getClassLoader(), definition, lineReader);
  }

  public Unmarshaller(ClassLoader classLoader, InputSource definition, LineReader lineReader) {
    super(classLoader, definition);
    this.lineReader = lineReader;
    this.lineReader.setRecordLength(this.definition.getLength());
    this.lineReader.setPropertyDelimiter(this.definition.getPropertyDelimiter());
    this.lineReader.setGlobalPadder(padders.get(this.definition.getGlobalPadder()));
    this.lineReader.setLineSeparator(this.definition.getLineSeparator());
    this.buffer = new StringBuffer();
  }

  /**
   * Returns the current internal buffer content. If called right after a
   * {@link Iterator#next()} call, it will return what JRecordBind wasn't able
   * to unmarshall. Usually called after the {@link Iterator#hasNext()} has
   * returned <code>false</code> to report the user about the "junk" found in
   * the text file
   * 
   * @return the current "junk" stored in the internal buffer
   */
  public String getCurrentJunk() {
    return buffer.toString();
  }

  /**
   * Unmarshalls the input fixed length file, a bean at a time
   * 
   * @param input
   *          the input fixed length file
   * @return an Iterator: each next() call will give back the next bean
   */
  public Iterator<E> unmarshall(Reader input) {
	    try {
			return new UnmarshallerIterator<E>(converters, buffer, lineReader, new BufferedReader(input));
		} catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
  }

  /**
   * Unmarshalls the whole file and give back a list of bean. <strong>USE WITH
   * CAUTION</strong>: for big files, this will lead to "out of memory" errors
   * 
   * @param input
   *          the input fixed length file
   * @return a list of beans
   */
  public List<E> unmarshallAll(Reader input) {
    List<E> result = new LinkedList<E>();
    for (Iterator<E> iter = unmarshall(input); iter.hasNext();) {
      result.add(iter.next());
    }
    return result;
  }

}
