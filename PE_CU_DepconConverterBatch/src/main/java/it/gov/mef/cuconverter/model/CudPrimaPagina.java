package it.gov.mef.cuconverter.model;

import java.util.Date;

import org.coury.jfilehelpers.annotations.FieldConverter;
import org.coury.jfilehelpers.annotations.FieldFixedLength;
import org.coury.jfilehelpers.annotations.FieldOptional;
import org.coury.jfilehelpers.annotations.FieldTrim;
import org.coury.jfilehelpers.annotations.FixedLengthRecord;
import org.coury.jfilehelpers.enums.ConverterKind;
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
	@FieldOptional
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
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio3;

	@FieldFixedLength(3)
	public String dg2;
	
	@FieldFixedLength(69)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String descDpt;

	@FieldFixedLength(11)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String codFisSosImposta;
	
	//DG3 
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio4;

	@FieldFixedLength(3)
	public String dg3;

	@FieldFixedLength(110)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String indirizzoSosImposta;
	
	//DG4
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio5;

	@FieldFixedLength(3)
	public String dg4;
	
	@FieldFixedLength(16)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String codiceFiscale;

	@FieldFixedLength(35)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String cognome;
	
	@FieldFixedLength(35)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String nome;
	
	//DG5
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio6;

	@FieldFixedLength(3)
	public String dg5;

	@FieldFixedLength(1)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String sesso;
	
	@FieldFixedLength(10)
	@FieldOptional
	@FieldConverter(converter=ConverterKind.Date,format="dd/MM/yyyy")
	public Date dataNascita; 
	
	@FieldFixedLength(40)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String comuneNascita;

	@FieldFixedLength(1)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String eventiEccezionali;
	
	//DG6
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio7;

	@FieldFixedLength(3)
	public String dg6;
	
	@FieldFixedLength(40)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String comuneFiscaleResidenzaAnnoRedditi;

	@FieldFixedLength(2)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String codiceProvinciaResidenzaAnnoRedditi;

	@FieldFixedLength(4)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String codiceComuneResidenzaAnnoRedditi;
	
	@FieldFixedLength(40)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String comuneResidenaAnnoDichiarazione;
	
	@FieldFixedLength(2)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String codiceProvinciaResidenzaAnnoDichiarazione;
	
	@FieldFixedLength(4)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String codiceComuneResidenzaAnnoDichiarazione;
	
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
