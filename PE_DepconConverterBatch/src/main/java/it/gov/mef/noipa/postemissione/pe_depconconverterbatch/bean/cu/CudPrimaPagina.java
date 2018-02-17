package it.gov.mef.noipa.postemissione.pe_depconconverterbatch.bean.cu;

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
	public String uffResp;
	
	@FieldFixedLength(8)
	public String iscrizione;

	@FieldFixedLength(7)
	@FieldOptional
	public String sedeMae;

	@FieldFixedLength(15)
	@FieldOptional
	public String descMae;
	
	//DG2 
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio3;

	@FieldFixedLength(3)
	public String dg2;
	
	@FieldFixedLength(69)
	public String descDpt;

	@FieldFixedLength(11)
	public String codFisSosImposta;
	
	//DG3 
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio4;

	@FieldFixedLength(3)
	public String dg3;

	@FieldFixedLength(110)
	public String indirizzoSosImposta;
	
	//DG4
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio5;

	@FieldFixedLength(3)
	public String dg4;
	
	@FieldFixedLength(16)
	public String codiceFiscale;

	@FieldFixedLength(35)
	public String cognome;
	
	@FieldFixedLength(35)
	public String nome;
	
	//DG5
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio6;

	@FieldFixedLength(3)
	public String dg5;

	@FieldFixedLength(1)
	public String sesso;
	
	@FieldFixedLength(10)
	public String dataNascita; 
	
	@FieldFixedLength(40)
	public String comuneNascita;
	
	@FieldFixedLength(2)
	public String provinciaNascita;

	@FieldFixedLength(1)
	@FieldOptional
	public String eventiEccezionali;
	
	@FieldFixedLength(2)
	@FieldOptional
	public String casiDiEsclusione;
	
	//DG6
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio7;

	@FieldFixedLength(3)
	public String dg6;
	
	@FieldFixedLength(40)
	public String comuneFiscaleResidenzaAnnoRedditi;

	@FieldFixedLength(2)
	public String codiceProvinciaResidenzaAnnoRedditi;

	@FieldFixedLength(4)
	public String codiceComuneResidenzaAnnoRedditi;
	
	@FieldFixedLength(40)
	@FieldOptional
	public String comuneResidenaAnnoDichiarazione;
	
	@FieldFixedLength(2)
	@FieldOptional
	public String codiceProvinciaResidenzaAnnoDichiarazione;
	
	@FieldFixedLength(4)
	@FieldOptional
	public String codiceComuneResidenzaAnnoDichiarazione;
	
	//DF1
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio8;

	@FieldFixedLength(3)
	public String df1;

	@FieldFixedLength(13)
	@FieldOptional
	public String redditoTotTempoIndeterminato;
	
	@FieldFixedLength(13)
	@FieldOptional
	public String redditoTotTempoDeterminato;
		
	//DF2
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio9;

	@FieldFixedLength(3)
	public String df2;
	
	@FieldFixedLength(13)
	@FieldOptional
	public String altriRedditiAssimiliati;
	
	@FieldFixedLength(13)
	@FieldOptional
	public String assegniConiuge;

	@FieldFixedLength(3)
	@FieldOptional
	public String giorni;
		
	//DF3
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio10;

	@FieldFixedLength(3)
	public String df3;

	@FieldFixedLength(13)
	@FieldOptional
	public String ritenuteSospeseIrpef;
	
	@FieldFixedLength(13)
	@FieldOptional
	public String ritenuteTotaliIrpef;

	//DF4
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio11;

	@FieldFixedLength(3)
	public String df4;
	
	@FieldFixedLength(13)
	@FieldOptional
	public String addizionaleRegionaleDovuta;

	@FieldFixedLength(13)
	@FieldOptional
	public String addizionaleComunalePagata;

	@FieldFixedLength(13)
	@FieldOptional
	public String addizionaleComunaleDovuta;

	@FieldFixedLength(13)
	@FieldOptional
	public String accontoAddizionaleComunalePagata;
	
	//DF5
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio12;

	@FieldFixedLength(3)
	public String df5;

	@FieldFixedLength(13)
	@FieldOptional
	public String primoAccontoIrpefDichiarato;

	//DF6
	@FieldFixedLength(1)
	public String spazio13;

	@FieldFixedLength(3)
	public String df6;

	@FieldFixedLength(13)
	@FieldOptional
	public String secondoAccontoIrpef;

	@FieldFixedLength(13)
	@FieldOptional
	public String accontiIrpefSospesi;

	//DF7
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio14;

	@FieldFixedLength(3)
	public String df7;

	@FieldFixedLength(13)
	@FieldOptional
	public String accontoAddizionaleComunale;

	@FieldFixedLength(13)
	@FieldOptional
	public String accontoAddizionaleComunaleSospeso;

	//DF8
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio15;

	@FieldFixedLength(3)
	public String df8;

	@FieldFixedLength(13)
	@FieldOptional
	public String primoAccontoCedolareSecca;

	@FieldFixedLength(13)
	@FieldOptional
	public String secondoAccontoCedolareSecca;

	//DF9
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio16;

	@FieldFixedLength(3)
	public String df9;

	@FieldFixedLength(13)
	@FieldOptional
	public String primoAccontoIrpefConiuge;
	
	//DFA
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio17;

	@FieldFixedLength(3)
	public String dfa;

	@FieldFixedLength(13)
	@FieldOptional
	public String secondoAccontoIrpefConiuge;

	@FieldFixedLength(13)
	@FieldOptional
	public String accontiIrpefSospesiConiuge;

	//DFB
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio18;

	@FieldFixedLength(3)
	public String dfb;

	@FieldFixedLength(13)
	@FieldOptional
	public String accontoAddizionaleComunaleConiuge;

	@FieldFixedLength(13)
	@FieldOptional
	public String accontoAddizionaleComunaleSospesoConiuge;
	
	//DFC
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio19;

	@FieldFixedLength(3)
	public String dfc;

	@FieldFixedLength(13)
	@FieldOptional
	public String primoAccontoCedolareSeccaConiuge;

	@FieldFixedLength(13)
	@FieldOptional
	public String secondoAccontoCedolareSeccaConiuge;
	
	//DFD
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio20;

	@FieldFixedLength(3)
	public String dfd;

	@FieldFixedLength(13)
	@FieldOptional
	public String impostaLorda;

	@FieldFixedLength(13)
	@FieldOptional
	public String detrazioneFamigliaACarico;	
	
	//OND
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio21;

	@FieldFixedLength(3)
	public String ond;

	@FieldFixedLength(2)
	@FieldOptional
	public String codiceOnere;

	@FieldFixedLength(13)
	@FieldOptional
	public String importoOnere;	
		
	//DFE
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio22;

	@FieldFixedLength(3)
	public String dfe;

	@FieldFixedLength(13)
	@FieldOptional
	public String detrazioneFamiglieNumerose;

	@FieldFixedLength(13)
	@FieldOptional
	public String creditoNonRiconosciutoFamiglieNumerose;	
	
	//DFF
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio23;

	@FieldFixedLength(3)
	public String dff;

	@FieldFixedLength(13)
	@FieldOptional
	public String detrazioneLavoroDipendentePensioneRedditi;

	@FieldFixedLength(13)
	@FieldOptional
	public String totaleDetrazioniOneri;	

	//DFG
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio24;

	@FieldFixedLength(3)
	public String dfg;

	@FieldFixedLength(13)
	@FieldOptional
	public String detrazioneCanoniLocazione;

	@FieldFixedLength(13)
	@FieldOptional
	public String creditoNonRiconosciutoCanoneLocazione;	
	
	//DGG
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio25;

	@FieldFixedLength(3)
	public String dgg;

	@FieldFixedLength(13)
	@FieldOptional
	public String totaleDetrazioni;

	//DFH
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio26;

	@FieldFixedLength(3)
	public String dfh;

	@FieldFixedLength(1)
	public String codiceBonus;
	
	@FieldFixedLength(13)
	@FieldOptional
	public String bonusErogato;

	@FieldFixedLength(13)
	@FieldOptional
	public String bonusNonErogato;	
	
	//DFI
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio27;

	@FieldFixedLength(3)
	public String dfi;

	@FieldFixedLength(1)
	@FieldOptional
	public String previdenzaComplementare;

	@FieldFixedLength(13)
	@FieldOptional
	public String contributiPrevidenzaDedottiDaiRedditi;	
		
	//DFL
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio28;

	@FieldFixedLength(3)
	public String dfl;

	@FieldFixedLength(13)
	@FieldOptional
	public String contributiNonDedottiDaiRedditi;

	@FieldFixedLength(13)
	@FieldOptional
	public String tfrPerFondo;	

	//DFM
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio29;

	@FieldFixedLength(3)
	public String dfm;

	@FieldFixedLength(13)
	@FieldOptional
	public String oneriEsclusi;

	@FieldFixedLength(13)
	@FieldOptional
	public String contributiVersati;	

	//DFN
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio30;

	@FieldFixedLength(3)
	public String dfn;
	
	@FieldFixedLength(2)
	@FieldOptional
	public String dfnCodiceOnere1;	

	@FieldFixedLength(13)
	@FieldOptional
	public String dfnImportoOnere1;	

	@FieldFixedLength(2)
	@FieldOptional
	public String dfnCodiceOnere2;	

	@FieldFixedLength(13)
	@FieldOptional
	public String dfnImportoOnere2;	

	@FieldFixedLength(2)
	@FieldOptional
	public String dfnCodiceOnere3;	

	@FieldFixedLength(13)
	@FieldOptional
	public String dfnImportoOnere3;	
	
	@FieldFixedLength(1)
	@FieldOptional
	public String assicurazioniSanitarie;
	
	//CAM
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio31;

	@FieldFixedLength(3)
	public String cam;
	
	@FieldFixedLength(13)
	@FieldOptional
	public String imponibileTempoIndeterminato;	

	@FieldFixedLength(13)
	@FieldOptional
	public String imponibileTempoDdeterminato;	
	
	@FieldFixedLength(1)
	@FieldOptional
	public String codiceRedditiEsenti;

	@FieldFixedLength(13)
	@FieldOptional
	public String importoRedditiEsenti;	
	
	@FieldFixedLength(2)
	@FieldOptional
	public String codiceSommeEstere;	

	@FieldFixedLength(13)
	@FieldOptional
	public String importoSommeEstere;	
	
	//DFO
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio32;

	@FieldFixedLength(3)
	public String dfo;

	@FieldFixedLength(13)
	@FieldOptional
	public String irpefDaTrattenerDopo28Febbrario;

	@FieldFixedLength(13)
	@FieldOptional
	public String irpefDaVersareErario;	
	
	//DFP
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio33;

	@FieldFixedLength(3)
	public String dfp;
	
	@FieldFixedLength(1)
	@FieldOptional
	public String applicazioneMaggioreRitenuta;

	@FieldFixedLength(1)
	@FieldOptional
	public String casiParticolari;
	
	//TS1
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio34;

	@FieldFixedLength(3)
	public String ts1;

	@FieldFixedLength(13)
	@FieldOptional
	public String totaleCompensiArretratiDetraibili;

	@FieldFixedLength(13)
	@FieldOptional
	public String totaleRitenuteSospese;	
	
	@FieldFixedLength(13)
	@FieldOptional
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

	public String getSpazio1() {
		return spazio1;
	}

	public void setSpazio1(String spazio1) {
		this.spazio1 = spazio1;
	}

	public String getDg1() {
		return dg1;
	}

	public void setDg1(String dg1) {
		this.dg1 = dg1;
	}

	public String getCodiceDpt() {
		return codiceDpt;
	}

	public void setCodiceDpt(String codiceDpt) {
		this.codiceDpt = codiceDpt;
	}

	public String getSpazio2() {
		return spazio2;
	}

	public void setSpazio2(String spazio2) {
		this.spazio2 = spazio2;
	}

	public String getUffResp() {
		return uffResp;
	}

	public void setUffResp(String uffResp) {
		this.uffResp = uffResp;
	}

	public String getIscrizione() {
		return iscrizione;
	}

	public void setIscrizione(String iscrizione) {
		this.iscrizione = iscrizione;
	}

	public String getSedeMae() {
		return sedeMae;
	}

	public void setSedeMae(String sedeMae) {
		this.sedeMae = sedeMae;
	}

	public String getDescMae() {
		return descMae;
	}

	public void setDescMae(String descMae) {
		this.descMae = descMae;
	}

	public String getSpazio3() {
		return spazio3;
	}

	public void setSpazio3(String spazio3) {
		this.spazio3 = spazio3;
	}

	public String getDg2() {
		return dg2;
	}

	public void setDg2(String dg2) {
		this.dg2 = dg2;
	}

	public String getDescDpt() {
		return descDpt;
	}

	public void setDescDpt(String descDpt) {
		this.descDpt = descDpt;
	}

	public String getCodFisSosImposta() {
		return codFisSosImposta;
	}

	public void setCodFisSosImposta(String codFisSosImposta) {
		this.codFisSosImposta = codFisSosImposta;
	}

	public String getSpazio4() {
		return spazio4;
	}

	public void setSpazio4(String spazio4) {
		this.spazio4 = spazio4;
	}

	public String getDg3() {
		return dg3;
	}

	public void setDg3(String dg3) {
		this.dg3 = dg3;
	}

	public String getIndirizzoSosImposta() {
		return indirizzoSosImposta;
	}

	public void setIndirizzoSosImposta(String indirizzoSosImposta) {
		this.indirizzoSosImposta = indirizzoSosImposta;
	}

	public String getSpazio5() {
		return spazio5;
	}

	public void setSpazio5(String spazio5) {
		this.spazio5 = spazio5;
	}

	public String getDg4() {
		return dg4;
	}

	public void setDg4(String dg4) {
		this.dg4 = dg4;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSpazio6() {
		return spazio6;
	}

	public void setSpazio6(String spazio6) {
		this.spazio6 = spazio6;
	}

	public String getDg5() {
		return dg5;
	}

	public void setDg5(String dg5) {
		this.dg5 = dg5;
	}

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public String getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getComuneNascita() {
		return comuneNascita;
	}

	public void setComuneNascita(String comuneNascita) {
		this.comuneNascita = comuneNascita;
	}

	public String getProvinciaNascita() {
		return provinciaNascita;
	}

	public void setProvinciaNascita(String provinciaNascita) {
		this.provinciaNascita = provinciaNascita;
	}

	public String getEventiEccezionali() {
		return eventiEccezionali;
	}

	public void setEventiEccezionali(String eventiEccezionali) {
		this.eventiEccezionali = eventiEccezionali;
	}

	public String getCasiDiEsclusione() {
		return casiDiEsclusione;
	}

	public void setCasiDiEsclusione(String casiDiEsclusione) {
		this.casiDiEsclusione = casiDiEsclusione;
	}

	public String getSpazio7() {
		return spazio7;
	}

	public void setSpazio7(String spazio7) {
		this.spazio7 = spazio7;
	}

	public String getDg6() {
		return dg6;
	}

	public void setDg6(String dg6) {
		this.dg6 = dg6;
	}

	public String getComuneFiscaleResidenzaAnnoRedditi() {
		return comuneFiscaleResidenzaAnnoRedditi;
	}

	public void setComuneFiscaleResidenzaAnnoRedditi(String comuneFiscaleResidenzaAnnoRedditi) {
		this.comuneFiscaleResidenzaAnnoRedditi = comuneFiscaleResidenzaAnnoRedditi;
	}

	public String getCodiceProvinciaResidenzaAnnoRedditi() {
		return codiceProvinciaResidenzaAnnoRedditi;
	}

	public void setCodiceProvinciaResidenzaAnnoRedditi(String codiceProvinciaResidenzaAnnoRedditi) {
		this.codiceProvinciaResidenzaAnnoRedditi = codiceProvinciaResidenzaAnnoRedditi;
	}

	public String getCodiceComuneResidenzaAnnoRedditi() {
		return codiceComuneResidenzaAnnoRedditi;
	}

	public void setCodiceComuneResidenzaAnnoRedditi(String codiceComuneResidenzaAnnoRedditi) {
		this.codiceComuneResidenzaAnnoRedditi = codiceComuneResidenzaAnnoRedditi;
	}

	public String getComuneResidenaAnnoDichiarazione() {
		return comuneResidenaAnnoDichiarazione;
	}

	public void setComuneResidenaAnnoDichiarazione(String comuneResidenaAnnoDichiarazione) {
		this.comuneResidenaAnnoDichiarazione = comuneResidenaAnnoDichiarazione;
	}

	public String getCodiceProvinciaResidenzaAnnoDichiarazione() {
		return codiceProvinciaResidenzaAnnoDichiarazione;
	}

	public void setCodiceProvinciaResidenzaAnnoDichiarazione(String codiceProvinciaResidenzaAnnoDichiarazione) {
		this.codiceProvinciaResidenzaAnnoDichiarazione = codiceProvinciaResidenzaAnnoDichiarazione;
	}

	public String getCodiceComuneResidenzaAnnoDichiarazione() {
		return codiceComuneResidenzaAnnoDichiarazione;
	}

	public void setCodiceComuneResidenzaAnnoDichiarazione(String codiceComuneResidenzaAnnoDichiarazione) {
		this.codiceComuneResidenzaAnnoDichiarazione = codiceComuneResidenzaAnnoDichiarazione;
	}

	public String getSpazio8() {
		return spazio8;
	}

	public void setSpazio8(String spazio8) {
		this.spazio8 = spazio8;
	}

	public String getDf1() {
		return df1;
	}

	public void setDf1(String df1) {
		this.df1 = df1;
	}

	public String getRedditoTotTempoIndeterminato() {
		return redditoTotTempoIndeterminato;
	}

	public void setRedditoTotTempoIndeterminato(String redditoTotTempoIndeterminato) {
		this.redditoTotTempoIndeterminato = redditoTotTempoIndeterminato;
	}

	public String getRedditoTotTempoDeterminato() {
		return redditoTotTempoDeterminato;
	}

	public void setRedditoTotTempoDeterminato(String redditoTotTempoDeterminato) {
		this.redditoTotTempoDeterminato = redditoTotTempoDeterminato;
	}

	public String getSpazio9() {
		return spazio9;
	}

	public void setSpazio9(String spazio9) {
		this.spazio9 = spazio9;
	}

	public String getDf2() {
		return df2;
	}

	public void setDf2(String df2) {
		this.df2 = df2;
	}

	public String getAltriRedditiAssimiliati() {
		return altriRedditiAssimiliati;
	}

	public void setAltriRedditiAssimiliati(String altriRedditiAssimiliati) {
		this.altriRedditiAssimiliati = altriRedditiAssimiliati;
	}

	public String getAssegniConiuge() {
		return assegniConiuge;
	}

	public void setAssegniConiuge(String assegniConiuge) {
		this.assegniConiuge = assegniConiuge;
	}

	public String getGiorni() {
		return giorni;
	}

	public void setGiorni(String giorni) {
		this.giorni = giorni;
	}

	public String getSpazio10() {
		return spazio10;
	}

	public void setSpazio10(String spazio10) {
		this.spazio10 = spazio10;
	}

	public String getDf3() {
		return df3;
	}

	public void setDf3(String df3) {
		this.df3 = df3;
	}

	public String getRitenuteSospeseIrpef() {
		return ritenuteSospeseIrpef;
	}

	public void setRitenuteSospeseIrpef(String ritenuteSospeseIrpef) {
		this.ritenuteSospeseIrpef = ritenuteSospeseIrpef;
	}

	public String getRitenuteTotaliIrpef() {
		return ritenuteTotaliIrpef;
	}

	public void setRitenuteTotaliIrpef(String ritenuteTotaliIrpef) {
		this.ritenuteTotaliIrpef = ritenuteTotaliIrpef;
	}

	public String getSpazio11() {
		return spazio11;
	}

	public void setSpazio11(String spazio11) {
		this.spazio11 = spazio11;
	}

	public String getDf4() {
		return df4;
	}

	public void setDf4(String df4) {
		this.df4 = df4;
	}

	public String getAddizionaleRegionaleDovuta() {
		return addizionaleRegionaleDovuta;
	}

	public void setAddizionaleRegionaleDovuta(String addizionaleRegionaleDovuta) {
		this.addizionaleRegionaleDovuta = addizionaleRegionaleDovuta;
	}

	public String getAddizionaleComunalePagata() {
		return addizionaleComunalePagata;
	}

	public void setAddizionaleComunalePagata(String addizionaleComunalePagata) {
		this.addizionaleComunalePagata = addizionaleComunalePagata;
	}

	public String getAddizionaleComunaleDovuta() {
		return addizionaleComunaleDovuta;
	}

	public void setAddizionaleComunaleDovuta(String addizionaleComunaleDovuta) {
		this.addizionaleComunaleDovuta = addizionaleComunaleDovuta;
	}

	public String getAccontoAddizionaleComunalePagata() {
		return accontoAddizionaleComunalePagata;
	}

	public void setAccontoAddizionaleComunalePagata(String accontoAddizionaleComunalePagata) {
		this.accontoAddizionaleComunalePagata = accontoAddizionaleComunalePagata;
	}

	public String getSpazio12() {
		return spazio12;
	}

	public void setSpazio12(String spazio12) {
		this.spazio12 = spazio12;
	}

	public String getDf5() {
		return df5;
	}

	public void setDf5(String df5) {
		this.df5 = df5;
	}

	public String getPrimoAccontoIrpefDichiarato() {
		return primoAccontoIrpefDichiarato;
	}

	public void setPrimoAccontoIrpefDichiarato(String primoAccontoIrpefDichiarato) {
		this.primoAccontoIrpefDichiarato = primoAccontoIrpefDichiarato;
	}

	public String getSpazio13() {
		return spazio13;
	}

	public void setSpazio13(String spazio13) {
		this.spazio13 = spazio13;
	}

	public String getDf6() {
		return df6;
	}

	public void setDf6(String df6) {
		this.df6 = df6;
	}

	public String getSecondoAccontoIrpef() {
		return secondoAccontoIrpef;
	}

	public void setSecondoAccontoIrpef(String secondoAccontoIrpef) {
		this.secondoAccontoIrpef = secondoAccontoIrpef;
	}

	public String getAccontiIrpefSospesi() {
		return accontiIrpefSospesi;
	}

	public void setAccontiIrpefSospesi(String accontiIrpefSospesi) {
		this.accontiIrpefSospesi = accontiIrpefSospesi;
	}

	public String getSpazio14() {
		return spazio14;
	}

	public void setSpazio14(String spazio14) {
		this.spazio14 = spazio14;
	}

	public String getDf7() {
		return df7;
	}

	public void setDf7(String df7) {
		this.df7 = df7;
	}

	public String getAccontoAddizionaleComunale() {
		return accontoAddizionaleComunale;
	}

	public void setAccontoAddizionaleComunale(String accontoAddizionaleComunale) {
		this.accontoAddizionaleComunale = accontoAddizionaleComunale;
	}

	public String getAccontoAddizionaleComunaleSospeso() {
		return accontoAddizionaleComunaleSospeso;
	}

	public void setAccontoAddizionaleComunaleSospeso(String accontoAddizionaleComunaleSospeso) {
		this.accontoAddizionaleComunaleSospeso = accontoAddizionaleComunaleSospeso;
	}

	public String getSpazio15() {
		return spazio15;
	}

	public void setSpazio15(String spazio15) {
		this.spazio15 = spazio15;
	}

	public String getDf8() {
		return df8;
	}

	public void setDf8(String df8) {
		this.df8 = df8;
	}

	public String getPrimoAccontoCedolareSecca() {
		return primoAccontoCedolareSecca;
	}

	public void setPrimoAccontoCedolareSecca(String primoAccontoCedolareSecca) {
		this.primoAccontoCedolareSecca = primoAccontoCedolareSecca;
	}

	public String getSecondoAccontoCedolareSecca() {
		return secondoAccontoCedolareSecca;
	}

	public void setSecondoAccontoCedolareSecca(String secondoAccontoCedolareSecca) {
		this.secondoAccontoCedolareSecca = secondoAccontoCedolareSecca;
	}

	public String getSpazio16() {
		return spazio16;
	}

	public void setSpazio16(String spazio16) {
		this.spazio16 = spazio16;
	}

	public String getDf9() {
		return df9;
	}

	public void setDf9(String df9) {
		this.df9 = df9;
	}

	public String getPrimoAccontoIrpefConiuge() {
		return primoAccontoIrpefConiuge;
	}

	public void setPrimoAccontoIrpefConiuge(String primoAccontoIrpefConiuge) {
		this.primoAccontoIrpefConiuge = primoAccontoIrpefConiuge;
	}

	public String getSpazio17() {
		return spazio17;
	}

	public void setSpazio17(String spazio17) {
		this.spazio17 = spazio17;
	}

	public String getDfa() {
		return dfa;
	}

	public void setDfa(String dfa) {
		this.dfa = dfa;
	}

	public String getSecondoAccontoIrpefConiuge() {
		return secondoAccontoIrpefConiuge;
	}

	public void setSecondoAccontoIrpefConiuge(String secondoAccontoIrpefConiuge) {
		this.secondoAccontoIrpefConiuge = secondoAccontoIrpefConiuge;
	}

	public String getAccontiIrpefSospesiConiuge() {
		return accontiIrpefSospesiConiuge;
	}

	public void setAccontiIrpefSospesiConiuge(String accontiIrpefSospesiConiuge) {
		this.accontiIrpefSospesiConiuge = accontiIrpefSospesiConiuge;
	}

	public String getSpazio18() {
		return spazio18;
	}

	public void setSpazio18(String spazio18) {
		this.spazio18 = spazio18;
	}

	public String getDfb() {
		return dfb;
	}

	public void setDfb(String dfb) {
		this.dfb = dfb;
	}

	public String getAccontoAddizionaleComunaleConiuge() {
		return accontoAddizionaleComunaleConiuge;
	}

	public void setAccontoAddizionaleComunaleConiuge(String accontoAddizionaleComunaleConiuge) {
		this.accontoAddizionaleComunaleConiuge = accontoAddizionaleComunaleConiuge;
	}

	public String getAccontoAddizionaleComunaleSospesoConiuge() {
		return accontoAddizionaleComunaleSospesoConiuge;
	}

	public void setAccontoAddizionaleComunaleSospesoConiuge(String accontoAddizionaleComunaleSospesoConiuge) {
		this.accontoAddizionaleComunaleSospesoConiuge = accontoAddizionaleComunaleSospesoConiuge;
	}

	public String getSpazio19() {
		return spazio19;
	}

	public void setSpazio19(String spazio19) {
		this.spazio19 = spazio19;
	}

	public String getDfc() {
		return dfc;
	}

	public void setDfc(String dfc) {
		this.dfc = dfc;
	}

	public String getPrimoAccontoCedolareSeccaConiuge() {
		return primoAccontoCedolareSeccaConiuge;
	}

	public void setPrimoAccontoCedolareSeccaConiuge(String primoAccontoCedolareSeccaConiuge) {
		this.primoAccontoCedolareSeccaConiuge = primoAccontoCedolareSeccaConiuge;
	}

	public String getSecondoAccontoCedolareSeccaConiuge() {
		return secondoAccontoCedolareSeccaConiuge;
	}

	public void setSecondoAccontoCedolareSeccaConiuge(String secondoAccontoCedolareSeccaConiuge) {
		this.secondoAccontoCedolareSeccaConiuge = secondoAccontoCedolareSeccaConiuge;
	}

	public String getSpazio20() {
		return spazio20;
	}

	public void setSpazio20(String spazio20) {
		this.spazio20 = spazio20;
	}

	public String getDfd() {
		return dfd;
	}

	public void setDfd(String dfd) {
		this.dfd = dfd;
	}

	public String getImpostaLorda() {
		return impostaLorda;
	}

	public void setImpostaLorda(String impostaLorda) {
		this.impostaLorda = impostaLorda;
	}

	public String getDetrazioneFamigliaACarico() {
		return detrazioneFamigliaACarico;
	}

	public void setDetrazioneFamigliaACarico(String detrazioneFamigliaACarico) {
		this.detrazioneFamigliaACarico = detrazioneFamigliaACarico;
	}

	public String getSpazio21() {
		return spazio21;
	}

	public void setSpazio21(String spazio21) {
		this.spazio21 = spazio21;
	}

	public String getOnd() {
		return ond;
	}

	public void setOnd(String ond) {
		this.ond = ond;
	}

	public String getCodiceOnere() {
		return codiceOnere;
	}

	public void setCodiceOnere(String codiceOnere) {
		this.codiceOnere = codiceOnere;
	}

	public String getImportoOnere() {
		return importoOnere;
	}

	public void setImportoOnere(String importoOnere) {
		this.importoOnere = importoOnere;
	}

	public String getSpazio22() {
		return spazio22;
	}

	public void setSpazio22(String spazio22) {
		this.spazio22 = spazio22;
	}

	public String getDfe() {
		return dfe;
	}

	public void setDfe(String dfe) {
		this.dfe = dfe;
	}

	public String getDetrazioneFamiglieNumerose() {
		return detrazioneFamiglieNumerose;
	}

	public void setDetrazioneFamiglieNumerose(String detrazioneFamiglieNumerose) {
		this.detrazioneFamiglieNumerose = detrazioneFamiglieNumerose;
	}

	public String getCreditoNonRiconosciutoFamiglieNumerose() {
		return creditoNonRiconosciutoFamiglieNumerose;
	}

	public void setCreditoNonRiconosciutoFamiglieNumerose(String creditoNonRiconosciutoFamiglieNumerose) {
		this.creditoNonRiconosciutoFamiglieNumerose = creditoNonRiconosciutoFamiglieNumerose;
	}

	public String getSpazio23() {
		return spazio23;
	}

	public void setSpazio23(String spazio23) {
		this.spazio23 = spazio23;
	}

	public String getDff() {
		return dff;
	}

	public void setDff(String dff) {
		this.dff = dff;
	}

	public String getDetrazioneLavoroDipendentePensioneRedditi() {
		return detrazioneLavoroDipendentePensioneRedditi;
	}

	public void setDetrazioneLavoroDipendentePensioneRedditi(String detrazioneLavoroDipendentePensioneRedditi) {
		this.detrazioneLavoroDipendentePensioneRedditi = detrazioneLavoroDipendentePensioneRedditi;
	}

	public String getTotaleDetrazioniOneri() {
		return totaleDetrazioniOneri;
	}

	public void setTotaleDetrazioniOneri(String totaleDetrazioniOneri) {
		this.totaleDetrazioniOneri = totaleDetrazioniOneri;
	}

	public String getSpazio24() {
		return spazio24;
	}

	public void setSpazio24(String spazio24) {
		this.spazio24 = spazio24;
	}

	public String getDfg() {
		return dfg;
	}

	public void setDfg(String dfg) {
		this.dfg = dfg;
	}

	public String getDetrazioneCanoniLocazione() {
		return detrazioneCanoniLocazione;
	}

	public void setDetrazioneCanoniLocazione(String detrazioneCanoniLocazione) {
		this.detrazioneCanoniLocazione = detrazioneCanoniLocazione;
	}

	public String getCreditoNonRiconosciutoCanoneLocazione() {
		return creditoNonRiconosciutoCanoneLocazione;
	}

	public void setCreditoNonRiconosciutoCanoneLocazione(String creditoNonRiconosciutoCanoneLocazione) {
		this.creditoNonRiconosciutoCanoneLocazione = creditoNonRiconosciutoCanoneLocazione;
	}

	public String getSpazio25() {
		return spazio25;
	}

	public void setSpazio25(String spazio25) {
		this.spazio25 = spazio25;
	}

	public String getDgg() {
		return dgg;
	}

	public void setDgg(String dgg) {
		this.dgg = dgg;
	}

	public String getTotaleDetrazioni() {
		return totaleDetrazioni;
	}

	public void setTotaleDetrazioni(String totaleDetrazioni) {
		this.totaleDetrazioni = totaleDetrazioni;
	}

	public String getSpazio26() {
		return spazio26;
	}

	public void setSpazio26(String spazio26) {
		this.spazio26 = spazio26;
	}

	public String getDfh() {
		return dfh;
	}

	public void setDfh(String dfh) {
		this.dfh = dfh;
	}

	public String getCodiceBonus() {
		return codiceBonus;
	}

	public void setCodiceBonus(String codiceBonus) {
		this.codiceBonus = codiceBonus;
	}

	public String getBonusErogato() {
		return bonusErogato;
	}

	public void setBonusErogato(String bonusErogato) {
		this.bonusErogato = bonusErogato;
	}

	public String getBonusNonErogato() {
		return bonusNonErogato;
	}

	public void setBonusNonErogato(String bonusNonErogato) {
		this.bonusNonErogato = bonusNonErogato;
	}

	public String getSpazio27() {
		return spazio27;
	}

	public void setSpazio27(String spazio27) {
		this.spazio27 = spazio27;
	}

	public String getDfi() {
		return dfi;
	}

	public void setDfi(String dfi) {
		this.dfi = dfi;
	}

	public String getPrevidenzaComplementare() {
		return previdenzaComplementare;
	}

	public void setPrevidenzaComplementare(String previdenzaComplementare) {
		this.previdenzaComplementare = previdenzaComplementare;
	}

	public String getContributiPrevidenzaDedottiDaiRedditi() {
		return contributiPrevidenzaDedottiDaiRedditi;
	}

	public void setContributiPrevidenzaDedottiDaiRedditi(String contributiPrevidenzaDedottiDaiRedditi) {
		this.contributiPrevidenzaDedottiDaiRedditi = contributiPrevidenzaDedottiDaiRedditi;
	}

	public String getSpazio28() {
		return spazio28;
	}

	public void setSpazio28(String spazio28) {
		this.spazio28 = spazio28;
	}

	public String getDfl() {
		return dfl;
	}

	public void setDfl(String dfl) {
		this.dfl = dfl;
	}

	public String getContributiNonDedottiDaiRedditi() {
		return contributiNonDedottiDaiRedditi;
	}

	public void setContributiNonDedottiDaiRedditi(String contributiNonDedottiDaiRedditi) {
		this.contributiNonDedottiDaiRedditi = contributiNonDedottiDaiRedditi;
	}

	public String getTfrPerFondo() {
		return tfrPerFondo;
	}

	public void setTfrPerFondo(String tfrPerFondo) {
		this.tfrPerFondo = tfrPerFondo;
	}

	public String getSpazio29() {
		return spazio29;
	}

	public void setSpazio29(String spazio29) {
		this.spazio29 = spazio29;
	}

	public String getDfm() {
		return dfm;
	}

	public void setDfm(String dfm) {
		this.dfm = dfm;
	}

	public String getOneriEsclusi() {
		return oneriEsclusi;
	}

	public void setOneriEsclusi(String oneriEsclusi) {
		this.oneriEsclusi = oneriEsclusi;
	}

	public String getContributiVersati() {
		return contributiVersati;
	}

	public void setContributiVersati(String contributiVersati) {
		this.contributiVersati = contributiVersati;
	}

	public String getSpazio30() {
		return spazio30;
	}

	public void setSpazio30(String spazio30) {
		this.spazio30 = spazio30;
	}

	public String getDfn() {
		return dfn;
	}

	public void setDfn(String dfn) {
		this.dfn = dfn;
	}

	public String getDfnCodiceOnere1() {
		return dfnCodiceOnere1;
	}

	public void setDfnCodiceOnere1(String dfnCodiceOnere1) {
		this.dfnCodiceOnere1 = dfnCodiceOnere1;
	}

	public String getDfnImportoOnere1() {
		return dfnImportoOnere1;
	}

	public void setDfnImportoOnere1(String dfnImportoOnere1) {
		this.dfnImportoOnere1 = dfnImportoOnere1;
	}

	public String getDfnCodiceOnere2() {
		return dfnCodiceOnere2;
	}

	public void setDfnCodiceOnere2(String dfnCodiceOnere2) {
		this.dfnCodiceOnere2 = dfnCodiceOnere2;
	}

	public String getDfnImportoOnere2() {
		return dfnImportoOnere2;
	}

	public void setDfnImportoOnere2(String dfnImportoOnere2) {
		this.dfnImportoOnere2 = dfnImportoOnere2;
	}

	public String getDfnCodiceOnere3() {
		return dfnCodiceOnere3;
	}

	public void setDfnCodiceOnere3(String dfnCodiceOnere3) {
		this.dfnCodiceOnere3 = dfnCodiceOnere3;
	}

	public String getDfnImportoOnere3() {
		return dfnImportoOnere3;
	}

	public void setDfnImportoOnere3(String dfnImportoOnere3) {
		this.dfnImportoOnere3 = dfnImportoOnere3;
	}

	public String getAssicurazioniSanitarie() {
		return assicurazioniSanitarie;
	}

	public void setAssicurazioniSanitarie(String assicurazioniSanitarie) {
		this.assicurazioniSanitarie = assicurazioniSanitarie;
	}

	public String getSpazio31() {
		return spazio31;
	}

	public void setSpazio31(String spazio31) {
		this.spazio31 = spazio31;
	}

	public String getCam() {
		return cam;
	}

	public void setCam(String cam) {
		this.cam = cam;
	}

	public String getImponibileTempoIndeterminato() {
		return imponibileTempoIndeterminato;
	}

	public void setImponibileTempoIndeterminato(String imponibileTempoIndeterminato) {
		this.imponibileTempoIndeterminato = imponibileTempoIndeterminato;
	}

	public String getImponibileTempoDdeterminato() {
		return imponibileTempoDdeterminato;
	}

	public void setImponibileTempoDdeterminato(String imponibileTempoDdeterminato) {
		this.imponibileTempoDdeterminato = imponibileTempoDdeterminato;
	}

	public String getCodiceRedditiEsenti() {
		return codiceRedditiEsenti;
	}

	public void setCodiceRedditiEsenti(String codiceRedditiEsenti) {
		this.codiceRedditiEsenti = codiceRedditiEsenti;
	}

	public String getImportoRedditiEsenti() {
		return importoRedditiEsenti;
	}

	public void setImportoRedditiEsenti(String importoRedditiEsenti) {
		this.importoRedditiEsenti = importoRedditiEsenti;
	}

	public String getCodiceSommeEstere() {
		return codiceSommeEstere;
	}

	public void setCodiceSommeEstere(String codiceSommeEstere) {
		this.codiceSommeEstere = codiceSommeEstere;
	}

	public String getImportoSommeEstere() {
		return importoSommeEstere;
	}

	public void setImportoSommeEstere(String importoSommeEstere) {
		this.importoSommeEstere = importoSommeEstere;
	}

	public String getSpazio32() {
		return spazio32;
	}

	public void setSpazio32(String spazio32) {
		this.spazio32 = spazio32;
	}

	public String getDfo() {
		return dfo;
	}

	public void setDfo(String dfo) {
		this.dfo = dfo;
	}

	public String getIrpefDaTrattenerDopo28Febbrario() {
		return irpefDaTrattenerDopo28Febbrario;
	}

	public void setIrpefDaTrattenerDopo28Febbrario(String irpefDaTrattenerDopo28Febbrario) {
		this.irpefDaTrattenerDopo28Febbrario = irpefDaTrattenerDopo28Febbrario;
	}

	public String getIrpefDaVersareErario() {
		return irpefDaVersareErario;
	}

	public void setIrpefDaVersareErario(String irpefDaVersareErario) {
		this.irpefDaVersareErario = irpefDaVersareErario;
	}

	public String getSpazio33() {
		return spazio33;
	}

	public void setSpazio33(String spazio33) {
		this.spazio33 = spazio33;
	}

	public String getDfp() {
		return dfp;
	}

	public void setDfp(String dfp) {
		this.dfp = dfp;
	}

	public String getApplicazioneMaggioreRitenuta() {
		return applicazioneMaggioreRitenuta;
	}

	public void setApplicazioneMaggioreRitenuta(String applicazioneMaggioreRitenuta) {
		this.applicazioneMaggioreRitenuta = applicazioneMaggioreRitenuta;
	}

	public String getCasiParticolari() {
		return casiParticolari;
	}

	public void setCasiParticolari(String casiParticolari) {
		this.casiParticolari = casiParticolari;
	}

	public String getSpazio34() {
		return spazio34;
	}

	public void setSpazio34(String spazio34) {
		this.spazio34 = spazio34;
	}

	public String getTs1() {
		return ts1;
	}

	public void setTs1(String ts1) {
		this.ts1 = ts1;
	}

	public String getTotaleCompensiArretratiDetraibili() {
		return totaleCompensiArretratiDetraibili;
	}

	public void setTotaleCompensiArretratiDetraibili(String totaleCompensiArretratiDetraibili) {
		this.totaleCompensiArretratiDetraibili = totaleCompensiArretratiDetraibili;
	}

	public String getTotaleRitenuteSospese() {
		return totaleRitenuteSospese;
	}

	public void setTotaleRitenuteSospese(String totaleRitenuteSospese) {
		this.totaleRitenuteSospese = totaleRitenuteSospese;
	}

	public String getTotaleRitenuteOperate() {
		return totaleRitenuteOperate;
	}

	public void setTotaleRitenuteOperate(String totaleRitenuteOperate) {
		this.totaleRitenuteOperate = totaleRitenuteOperate;
	}

	public String getSpazio35() {
		return spazio35;
	}

	public void setSpazio35(String spazio35) {
		this.spazio35 = spazio35;
	}

	public String getTo1() {
		return to1;
	}

	public void setTo1(String to1) {
		this.to1 = to1;
	}

	public String getSpazio36() {
		return spazio36;
	}

	public void setSpazio36(String spazio36) {
		this.spazio36 = spazio36;
	}

	public String getTo2() {
		return to2;
	}

	public void setTo2(String to2) {
		this.to2 = to2;
	}

	public String getSpazio37() {
		return spazio37;
	}

	public void setSpazio37(String spazio37) {
		this.spazio37 = spazio37;
	}

	public String getTo3() {
		return to3;
	}

	public void setTo3(String to3) {
		this.to3 = to3;
	}

	public String getSpazio38() {
		return spazio38;
	}

	public void setSpazio38(String spazio38) {
		this.spazio38 = spazio38;
	}

	public String getPag() {
		return pag;
	}

	public void setPag(String pag) {
		this.pag = pag;
	}

	public String getNumerazionePagina() {
		return numerazionePagina;
	}

	public void setNumerazionePagina(String numerazionePagina) {
		this.numerazionePagina = numerazionePagina;
	}

	public String getSpazio39() {
		return spazio39;
	}

	public void setSpazio39(String spazio39) {
		this.spazio39 = spazio39;
	}

	public String getBrc() {
		return brc;
	}

	public void setBrc(String brc) {
		this.brc = brc;
	}

	public String getBrcCodiceDpt() {
		return brcCodiceDpt;
	}

	public void setBrcCodiceDpt(String brcCodiceDpt) {
		this.brcCodiceDpt = brcCodiceDpt;
	}

	public String getBrcTipo() {
		return brcTipo;
	}

	public void setBrcTipo(String brcTipo) {
		this.brcTipo = brcTipo;
	}

	public String getBrcRata() {
		return brcRata;
	}

	public void setBrcRata(String brcRata) {
		this.brcRata = brcRata;
	}

	public String getBrcAnno() {
		return brcAnno;
	}

	public void setBrcAnno(String brcAnno) {
		this.brcAnno = brcAnno;
	}

	public String getBrcTipoEmis() {
		return brcTipoEmis;
	}

	public void setBrcTipoEmis(String brcTipoEmis) {
		this.brcTipoEmis = brcTipoEmis;
	}

	public String getBrcIscrizione() {
		return brcIscrizione;
	}

	public void setBrcIscrizione(String brcIscrizione) {
		this.brcIscrizione = brcIscrizione;
	}

	public String getSt() {
		return st;
	}

	public void setSt(String st) {
		this.st = st;
	}

	public String getSpazio40() {
		return spazio40;
	}

	public void setSpazio40(String spazio40) {
		this.spazio40 = spazio40;
	}

	public String getBrcCodiEnte() {
		return brcCodiEnte;
	}

	public void setBrcCodiEnte(String brcCodiEnte) {
		this.brcCodiEnte = brcCodiEnte;
	}

	public String getSpazio41() {
		return spazio41;
	}

	public void setSpazio41(String spazio41) {
		this.spazio41 = spazio41;
	}

	public String getBrcCodiUffi() {
		return brcCodiUffi;
	}

	public void setBrcCodiUffi(String brcCodiUffi) {
		this.brcCodiUffi = brcCodiUffi;
	}

	public String getSpazio42() {
		return spazio42;
	}

	public void setSpazio42(String spazio42) {
		this.spazio42 = spazio42;
	}

	public String getBrcVersione() {
		return brcVersione;
	}

	public void setBrcVersione(String brcVersione) {
		this.brcVersione = brcVersione;
	}

	public String getBrcFlagCessati() {
		return brcFlagCessati;
	}

	public void setBrcFlagCessati(String brcFlagCessati) {
		this.brcFlagCessati = brcFlagCessati;
	}
	
	
	

}
