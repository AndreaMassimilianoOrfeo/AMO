package it.gov.mef.cuconverter.model;

import org.coury.jfilehelpers.annotations.FieldFixedLength;
import org.coury.jfilehelpers.annotations.FieldOptional;
import org.coury.jfilehelpers.annotations.FieldTrim;
import org.coury.jfilehelpers.annotations.FixedLengthRecord;
import org.coury.jfilehelpers.enums.FixedMode;
import org.coury.jfilehelpers.enums.TrimMode;

@FixedLengthRecord(fixedMode=FixedMode.AllowLessChars)
public class CudPrimaPagina {

	//DG1
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio1;

	@FieldFixedLength(3)
	public String dg1;
	
	@FieldFixedLength(3)
	public String codiceDpt;

	@FieldFixedLength(6)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio2;

	@FieldFixedLength(4)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String uffResp;
	
	@FieldFixedLength(8)
	@FieldOptional
	public String iscrizione;

	@FieldFixedLength(7)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String sedeMae;

	@FieldFixedLength(15)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String descMae;
	
	//DG2
	//DG3
	//DG4
	//DG5
	//DG6
	//DF1
	//DF2
	//DF3
	//DF4
	//DF5
	//DF6
	//DF7
	//DF8
	//DF9
	//DFA
	//DFB
	//DFC
	//DFD
	//OND
	//DFE
	//DFF
	//DFG
	//DGG
	//DFH
	//DFI
	//DFL
	//DFM
	//DFN
	//CAM
	//DFO
	//DFP
	//TS1
	//TO1
	//TO2
	//TO3
	//PAG
	//BRC

}
