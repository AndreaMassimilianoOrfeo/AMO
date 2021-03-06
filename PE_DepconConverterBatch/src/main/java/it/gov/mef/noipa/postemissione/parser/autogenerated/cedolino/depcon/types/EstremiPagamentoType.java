
package it.gov.mef.noipa.postemissione.parser.autogenerated.cedolino.depcon.types;


public class EstremiPagamentoType {

	protected String recordValue;

	
	public EstremiPagamentoType(String recordValue) {
		super();
		this.recordValue = recordValue;
	}

  
    public String getRecordValue() {
        return recordValue;
    }

     public void setRecordValue(String value) {
        this.recordValue = value;
    }

   
    
    public String getModalita(){
    	int startingPosition = 0;
    	int length = 100;
    	if(startingPosition<recordValue.length()){
    		return recordValue.substring(startingPosition,Math.min(startingPosition+length, recordValue.length()));
    	}else{
    		return null;
    	}
    	
    }
    
    public String getLabelValuta(){
    	int startingPosition = 100;
    	int length = 35;
    	if(startingPosition<recordValue.length()){
    		return recordValue.substring(startingPosition,Math.min(startingPosition+length, recordValue.length()));
    	}else{
    		return null;
    	}
    	
    }
    
    public String getDataValuta(){
    	int startingPosition = 135;
    	int length = 20;
    	if(startingPosition<recordValue.length()){
    		return recordValue.substring(startingPosition,Math.min(startingPosition+length, recordValue.length()));
    	}else{
    		return null;
    	}
    	
    }
   
    public String getLabelIBAN(){
    	int startingPosition = 155;
    	int length = 20;
    	if(startingPosition<recordValue.length()){
    		return recordValue.substring(startingPosition,Math.min(startingPosition+length, recordValue.length()));
    	}else{
    		return null;
    	}
    	
    }
    
    public String getIBAN(){
    	int startingPosition = 175;
    	int length = 35;
    	//Modificato da 27 a 35 da GS. Mail di Giustiniani (IBAN Europeo) del lunedì 04/04/2016 11:53
    	if(startingPosition<recordValue.length()){
    		return recordValue.substring(startingPosition,Math.min(startingPosition+length, recordValue.length()));
    	}else{
    		return null;
    	}
    	
    }
    
    public String getNomeIstituto(){
    	int startingPosition = 210;
    	int length = 60;
    	if(startingPosition<recordValue.length()){
    		return recordValue.substring(startingPosition,Math.min(startingPosition+length, recordValue.length()));
    	}else{
    		return null;
    	}
    	
    }


}
