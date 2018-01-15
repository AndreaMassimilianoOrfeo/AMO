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
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio8;

	@FieldFixedLength(3)
	public String df1;

	@FieldFixedLength(13)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String redditoTotTempoIndeterminato;
	
	@FieldFixedLength(13)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String redditoTotTempoDeterminato;
		
	//DF2
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio9;

	@FieldFixedLength(3)
	public String df2;
	
	@FieldFixedLength(13)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String altriRedditiAssimiliati;
	
	@FieldFixedLength(13)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String assegniConiuge;

	@FieldFixedLength(3)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String giorni;
		
	//DF3
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio10;

	@FieldFixedLength(3)
	public String df3;

	@FieldFixedLength(13)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String ritenuteSospeseIrpef;
	
	@FieldFixedLength(13)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String ritenuteTotaliIrpef;

	//DF4
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio11;

	@FieldFixedLength(3)
	public String df4;
	
	@FieldFixedLength(13)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String addizionaleRegionaleDovuta;

	@FieldFixedLength(13)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String addizionaleComunalePagata;

	@FieldFixedLength(13)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String addizionaleComunaleDovuta;

	@FieldFixedLength(13)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String accontoAddizionaleComunalePagata;
	
	//DF5
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio12;

	@FieldFixedLength(3)
	public String df5;

	@FieldFixedLength(13)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String primoAccontoIrpefDichiarato;

	//DF6
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio13;

	@FieldFixedLength(3)
	public String df6;

	@FieldFixedLength(13)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String secondoAccontoIrpef;

	@FieldFixedLength(13)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String accontiIrpefSospesi;

	//DF7
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio14;

	@FieldFixedLength(3)
	public String df7;

	@FieldFixedLength(13)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String accontoAddizionaleComunale;

	@FieldFixedLength(13)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String accontoAddizionaleComunaleSospeso;

	//DF8
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio15;

	@FieldFixedLength(3)
	public String df8;

	@FieldFixedLength(13)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String primoAccontoCedolareSecca;

	@FieldFixedLength(13)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String secondoAccontoCedolareSecca;

	//DF9
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio16;

	@FieldFixedLength(3)
	public String df9;

	@FieldFixedLength(13)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String primoAccontoIrpefConiuge;
	
	//DFA
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio17;

	@FieldFixedLength(3)
	public String dfa;

	@FieldFixedLength(13)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String secondoAccontoIrpefConiuge;

	@FieldFixedLength(13)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String accontiIrpefSospesiConiuge;

	//DFB
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio18;

	@FieldFixedLength(3)
	public String dfb;

	@FieldFixedLength(13)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String accontoAddizionaleComunaleConiuge;

	@FieldFixedLength(13)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String accontoAddizionaleComunaleSospesoConiuge;
	
	//DFC
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio19;

	@FieldFixedLength(3)
	public String dfc;

	@FieldFixedLength(13)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String primoAccontoCedolareSeccaConiuge;

	@FieldFixedLength(13)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String secondoAccontoCedolareSeccaConiuge;
	
	//DFD
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio20;

	@FieldFixedLength(3)
	public String dfd;

	@FieldFixedLength(13)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String impostaLorda;

	@FieldFixedLength(13)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String detrazioneFamigliaACarico;	
	
	//OND
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio21;

	@FieldFixedLength(3)
	public String ond;

	@FieldFixedLength(2)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String codiceOnere;

	@FieldFixedLength(13)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String importoOnere;	
		
	//DFE
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio22;

	@FieldFixedLength(3)
	public String dfe;

	@FieldFixedLength(13)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String detrazioneFamiglieNumerose;

	@FieldFixedLength(13)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String creditoNonRiconosciutoFamiglieNumerose;	
	
	//DFF
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio23;

	@FieldFixedLength(3)
	public String dff;

	@FieldFixedLength(13)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String detrazioneLavoroDipendentePensioneRedditi;

	@FieldFixedLength(13)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String totaleDetrazioniOneri;	

	//DFG
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio24;

	@FieldFixedLength(3)
	public String dfg;

	@FieldFixedLength(13)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String detrazioneCanoniLocazione;

	@FieldFixedLength(13)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String creditoNonRiconosciutoCanoneLocazione;	
	
	//DGG
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio25;

	@FieldFixedLength(3)
	public String dgg;

	@FieldFixedLength(13)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String totaleDetrazioni;


	//DFH
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio26;

	@FieldFixedLength(3)
	public String dfh;

	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String codiceBonus;
	
	@FieldFixedLength(13)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String bonusErogato;

	@FieldFixedLength(13)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String bonusNonErogato;	
	
	//DFI
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio27;

	@FieldFixedLength(3)
	public String dfi;

	@FieldFixedLength(1)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String previdenzaComplementare;

	@FieldFixedLength(13)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String contributiPrevidenzaDedottiDaiRedditi;	
		
	//DFL
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio28;

	@FieldFixedLength(3)
	public String dfl;

	@FieldFixedLength(13)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String contributiNonDedottiDaiRedditi;

	@FieldFixedLength(13)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String tfrPerFondo;	

	//DFM
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio29;

	@FieldFixedLength(3)
	public String dfm;

	@FieldFixedLength(13)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String oneriEsclusi;

	@FieldFixedLength(13)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String contributiVersati;	

	//DFN
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio30;

	@FieldFixedLength(3)
	public String dfn;
	
	@FieldFixedLength(2)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String dfnCodiceOnere1;	

	@FieldFixedLength(13)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String dfnImportoOnere1;	

	@FieldFixedLength(2)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String dfnCodiceOnere2;	

	@FieldFixedLength(13)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String dfnImportoOnere2;	

	@FieldFixedLength(2)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String dfnCodiceOnere3;	

	@FieldFixedLength(13)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String dfnImportoOnere3;	
	
	@FieldFixedLength(1)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String assicurazioniSanitarie;
	
	//CAM
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio31;

	@FieldFixedLength(3)
	public String cam;
	
	@FieldFixedLength(13)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String imponibileTempoIndeterminato;	

	@FieldFixedLength(13)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String imponibileTempoDdeterminato;	
	
	@FieldFixedLength(1)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String codiceRedditiEsenti;

	@FieldFixedLength(13)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String importoRedditiEsenti;	

	//DFO
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio32;

	@FieldFixedLength(3)
	public String dfo;

	@FieldFixedLength(13)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String irpefDaTrattenerDopo28Febbrario;

	@FieldFixedLength(13)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String irpefDaVersareErario;	
	
	//DFP
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio33;

	@FieldFixedLength(3)
	public String dfp;
	
	@FieldFixedLength(1)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String applicazioneMaggioreRitenuta;

	@FieldFixedLength(1)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String casiParticolari;
	
	//TS1
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio34;

	@FieldFixedLength(3)
	public String ts1;

	@FieldFixedLength(13)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String totaleCompensiArretratiDetraibili;

	@FieldFixedLength(13)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String totaleRitenuteSospese;	
	
	@FieldFixedLength(13)
	@FieldOptional
	@FieldTrim(trimMode=TrimMode.Both)
	public String totaleRitenuteOperate;	

	//TO1
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio35;

	@FieldFixedLength(3)
	public String to1;
	
	//TO2
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio36;

	@FieldFixedLength(3)
	public String to2;
	
	//TO3
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio37;

	@FieldFixedLength(3)
	public String to3;
	
	//PAG
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio38;

	@FieldFixedLength(3)
	public String pag;
	
	//PAG
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String numerazionePagina;

	//BRC
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio39;

	@FieldFixedLength(3)
	public String brc;
	
	@FieldFixedLength(3)
	@FieldOptional
	public String brcCodiceDpt;

	@FieldFixedLength(1)
	@FieldOptional
	public String brcTipo;

	@FieldFixedLength(1)
	@FieldOptional
	public String brcRata;

	@FieldFixedLength(1)
	@FieldOptional
	public String brcAnno;

	@FieldFixedLength(1)
	@FieldOptional
	public String brcTipoEmis;
	
	@FieldFixedLength(8)
	@FieldOptional
	public String brcIscrizione;
	
	@FieldFixedLength(2)
	@FieldOptional
	public String st;

	@FieldFixedLength(1)
	public String spazio40;
	
	@FieldFixedLength(4)
	@FieldOptional
	public String brcCodiEnte;
	
	@FieldFixedLength(1)
	public String spazio41;
	
	@FieldFixedLength(4)
	@FieldOptional
	public String brcCodiUffi;
	
	
	@FieldFixedLength(1)
	public String spazio42;
	
	@FieldFixedLength(1)
	@FieldOptional
	public String brcVersione;
	
	@FieldFixedLength(1)
	@FieldOptional
	public String brcFlagCessati;

}
