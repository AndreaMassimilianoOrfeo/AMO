
package it.gov.mef.noipa.postemissione.parser.autogenerated.cedolino.depcon.types;



public class DettaglioRitenuteCompetenzeType {

    protected String recordValue;

    public DettaglioRitenuteCompetenzeType(String recordValue) {
		super();
		this.recordValue = recordValue;
	}

	public String getRecordValue() {
        return recordValue;
    }

    public void setRecordValue(String value) {
        this.recordValue = value;
    }

    public String getCodice(){
    	int startingPosition = 0;
    	int length = 10;
    	if(startingPosition<recordValue.length()){
    		return recordValue.substring(startingPosition,Math.min(startingPosition+length, recordValue.length()));
    	}else{
    		return null;
    	}
    	
    }
    
    public String getImporto(){
    	int startingPosition = 10;
    	int length = 12;
    	if(startingPosition<recordValue.length()){
    		return recordValue.substring(startingPosition,Math.min(startingPosition+length, recordValue.length()));
    	}else{
    		return null;
    	}
    	
    }
    
    public String getRitenuteCompetenze(){
    	int startingPosition = 22;
    	int length = 1;
    	if(startingPosition<recordValue.length()){
    		return recordValue.substring(startingPosition,Math.min(startingPosition+length, recordValue.length()));
    	}else{
    		return null;
    	}
    	
    }
    
    public boolean isRitenuta(){
    	
    	if(getRitenuteCompetenze()!=null && !getRitenuteCompetenze().trim().equals("")){
    		return getRitenuteCompetenze().trim().equalsIgnoreCase("N");
    	}
    	return false;
    }
    
    public String getDescrizione(){
    	int startingPosition = 23;
    	int length = 100;
    	if(startingPosition<recordValue.length()){
    		return recordValue.substring(startingPosition,Math.min(startingPosition+length, recordValue.length()));
    	}else{
    		return null;
    	}
    	
    }
   
}