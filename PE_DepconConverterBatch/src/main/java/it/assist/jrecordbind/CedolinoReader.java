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



import java.io.BufferedReader;
import java.util.logging.Level;

import org.apache.log4j.Logger;

public class CedolinoReader implements LineReader {

	private Logger logger = Logger.getLogger(CedolinoReader.class);

  
  public void setGlobalPadder(Padder globalPadder) {
  }

  public void setPropertyDelimiter(String propertyDelimiter) {
  }

  public void setRecordLength(int recordLength) {
  }

  
   /* New code*/

	public String readLine(BufferedReader reader) {
		
		StringBuffer buffer = new StringBuffer("");
		try {
		String firstLine = reader.readLine();
		if(firstLine==null){
			logger.debug("EOF reached");
			return null;
		}
		if(!firstLine.equals("$CED1$")){
			throw new Error("No Match!");
			
		}
		String current = "$CED1$";
		buffer.append(current).append("\n");
		while(current!=null){
			reader.mark(100);
			current = reader.readLine();
			if(current==null || current.equals("$CED1$")) break;
			buffer.append(current).append("\n");
			
		}
		reader.reset();
			
		} catch (Exception e) {
			logger.error("Errore durante il metodo read line del file Depcon", e);
		}
		return buffer.toString();
	}
	public void setLineSeparator(String lineSeparator) {}
	  /* New code*/
}
