package it.gov.mef.noipa.postemissione.pe_depconconverterbatch.bean.cu;

import org.coury.jfilehelpers.annotations.FieldFixedLength;
import org.coury.jfilehelpers.annotations.FieldOptional;
import org.coury.jfilehelpers.annotations.FieldTrim;
import org.coury.jfilehelpers.annotations.FixedLengthRecord;
import org.coury.jfilehelpers.enums.FixedMode;
import org.coury.jfilehelpers.enums.TrimMode;

@FixedLengthRecord(fixedMode=FixedMode.AllowLessChars)
public class CudSecondaPagina {

	//DC1
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio1;

	@FieldFixedLength(3)
	public String dg1;
	
	@FieldFixedLength(1)
	@FieldOptional
	public String flagConiuge;

	@FieldFixedLength(2)
	public String spazio2;

	@FieldFixedLength(16)
	@FieldOptional
	public String cfConiuge;
	
	@FieldFixedLength(2)
	@FieldOptional
	public String messiACaricoConiuge;
	
	//DC2
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio3;

	@FieldFixedLength(3)
	public String dc2;

	@FieldFixedLength(1)
	@FieldOptional
	public String flagFiglioDc2;
	
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio4;

	@FieldFixedLength(1)
	@FieldOptional
	public String flagDisabileDc2;
	
	@FieldFixedLength(16)
	@FieldOptional
	public String cfFiglio;
	
	@FieldFixedLength(2)
	@FieldOptional
	public String mesiACaricoFiglio;
	
	@FieldFixedLength(2)
	@FieldOptional
	public String minoredi3AnniDc2;
	
	@FieldFixedLength(3)
	@FieldOptional
	public String percentualeDetrazioneSpettanteDc2;
		
	//DC3
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio6;

	@FieldFixedLength(3)
	public String dc3;

	@FieldFixedLength(1)
	@FieldOptional
	public String flagFiglioDc3;
	
	@FieldFixedLength(1)
	@FieldOptional
	public String flagAltroFamiliareDc3;

	@FieldFixedLength(1)
	@FieldOptional
	public String flagDisabileDc3;
	
	@FieldFixedLength(16)
	@FieldOptional
	public String cfFiglioOFamiliareDc3;
	
	@FieldFixedLength(2)
	@FieldOptional
	public String mesiACaricoFiglioDc3;
	
	@FieldFixedLength(2)
	@FieldOptional
	public String minoreADi3AnniDc3;
	
	@FieldFixedLength(3)
	@FieldOptional
	public String percentualeDetrazioneSpettanteDc3;
	
	//DC4
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio7;

	@FieldFixedLength(3)
	public String dc4;

	@FieldFixedLength(1)
	@FieldOptional
	public String flagFiglioDc4;
	
	@FieldFixedLength(1)
	@FieldOptional
	public String flagAltroFamiliareDc4;

	@FieldFixedLength(1)
	@FieldOptional
	public String flagDisabileDc4;
	
	@FieldFixedLength(16)
	@FieldOptional
	public String cfFiglioOFamiliareDc4;
	
	@FieldFixedLength(2)
	@FieldOptional
	public String mesiACaricoFiglioDc4;
	
	@FieldFixedLength(2)
	@FieldOptional
	public String minoreADi3AnniDc4;
	
	@FieldFixedLength(3)
	@FieldOptional
	public String percentualeDetrazioneSpettanteDc4;

	//DC5
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio8;

	@FieldFixedLength(3)
	public String dc5;

	@FieldFixedLength(1)
	@FieldOptional
	public String flagFiglioDc5;
	
	@FieldFixedLength(1)
	@FieldOptional
	public String flagAltroFamiliareDc5;

	@FieldFixedLength(1)
	@FieldOptional
	public String flagDisabileDc5;
	
	@FieldFixedLength(16)
	@FieldOptional
	public String cfFiglioOFamiliareDc5;
	
	@FieldFixedLength(2)
	@FieldOptional
	public String mesiACaricoFiglioDc5;
	
	@FieldFixedLength(2)
	@FieldOptional
	public String minoreADi3AnniDc5;
	
	@FieldFixedLength(3)
	@FieldOptional
	public String percentualeDetrazioneSpettanteDc5;

	//DC6
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio9;

	@FieldFixedLength(3)
	public String dc6;

	@FieldFixedLength(1)
	@FieldOptional
	public String flagFiglioDc6;
	
	@FieldFixedLength(1)
	@FieldOptional
	public String flagAltroFamiliareDc6;

	@FieldFixedLength(1)
	@FieldOptional
	public String flagDisabileDc6;
	
	@FieldFixedLength(16)
	@FieldOptional
	public String cfFiglioOFamiliareDc6;
	
	@FieldFixedLength(2)
	@FieldOptional
	public String mesiACaricoFiglioDc6;
	
	@FieldFixedLength(2)
	@FieldOptional
	public String minoreADi3AnniDc6;
	
	@FieldFixedLength(3)
	@FieldOptional
	public String percentualeDetrazioneSpettanteDc6;
	
	//DC7
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio10;

	@FieldFixedLength(3)
	public String dc7;

	@FieldFixedLength(1)
	@FieldOptional
	public String flagFiglioDc7;
	
	@FieldFixedLength(1)
	@FieldOptional
	public String flagAltroFamiliareDc7;

	@FieldFixedLength(1)
	@FieldOptional
	public String flagDisabileDc7;
	
	@FieldFixedLength(16)
	@FieldOptional
	public String cfFiglioOFamiliareDc7;
	
	@FieldFixedLength(2)
	@FieldOptional
	public String mesiACaricoFiglioDc7;
	
	@FieldFixedLength(2)
	@FieldOptional
	public String minoreADi3AnniDc7;
	
	@FieldFixedLength(3)
	@FieldOptional
	public String percentualeDetrazioneSpettanteDc7;
	
	//DC8
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio11;

	@FieldFixedLength(3)
	public String dc8;

	@FieldFixedLength(1)
	@FieldOptional
	public String flagFiglioDc8;
	
	@FieldFixedLength(1)
	@FieldOptional
	public String flagAltroFamiliareDc8;

	@FieldFixedLength(1)
	@FieldOptional
	public String flagDisabileDc8;
	
	@FieldFixedLength(16)
	@FieldOptional
	public String cfFiglioOFamiliareDc8;
	
	@FieldFixedLength(2)
	@FieldOptional
	public String mesiACaricoFiglioDc8;
	
	@FieldFixedLength(2)
	@FieldOptional
	public String minoreADi3AnniDc8;
	
	@FieldFixedLength(3)
	@FieldOptional
	public String percentualeDetrazioneSpettanteDc8;
	
	//DC9
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio12;

	@FieldFixedLength(3)
	public String dc9;

	@FieldFixedLength(1)
	@FieldOptional
	public String flagFiglioDc9;
	
	@FieldFixedLength(1)
	@FieldOptional
	public String flagAltroFamiliareDc9;

	@FieldFixedLength(1)
	@FieldOptional
	public String flagDisabileDc9;
	
	@FieldFixedLength(16)
	@FieldOptional
	public String cfFiglioOFamiliareDc9;
	
	@FieldFixedLength(2)
	@FieldOptional
	public String mesiACaricoFiglioDc9;
	
	@FieldFixedLength(2)
	@FieldOptional
	public String minoreADi3AnniDc9;
	
	@FieldFixedLength(3)
	@FieldOptional
	public String percentualeDetrazioneSpettanteDc9;
	
	//DCA
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio13;

	@FieldFixedLength(3)
	public String dca;
	
	@FieldFixedLength(3)
	@FieldOptional
	public String percentualeSpettanteFamiglieNumerose;

	//TS2
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio14;

	@FieldFixedLength(3)
	public String ts2;
	
	@FieldFixedLength(13)
	@FieldOptional
	public String indennitaAccontiAnnoCorrente;
	
	@FieldFixedLength(13)
	@FieldOptional
	public String accontoAnnoPrecedente;
	
	@FieldFixedLength(13)
	@FieldOptional
	public String detrazione;
	
	//TS3
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio15;

	@FieldFixedLength(3)
	public String ts3;
	
	@FieldFixedLength(13)
	@FieldOptional
	public String ritenutaAnnoCorrente;
	
	@FieldFixedLength(13)
	@FieldOptional
	public String ritenuteAnnoPrecedente;
	
	@FieldFixedLength(13)
	@FieldOptional
	public String tfrMaturatoInAziendaFinoA2000;
	
	//TS4
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio16;

	@FieldFixedLength(3)
	public String ts4;
	
	@FieldFixedLength(13)
	@FieldOptional
	public String tfrMaturatoInAziendaDal2001;
	
	@FieldFixedLength(13)
	@FieldOptional
	public String tfrMaturatoFinoAl200AlFondo;
	
	@FieldFixedLength(13)
	@FieldOptional
	public String impostaSostitutivaRivalutazioniTfr;

	//DP1
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio17;

	@FieldFixedLength(3)
	public String dp1;
	
	@FieldFixedLength(11)
	@FieldOptional
	public String matricolaAzienda;
	
	@FieldFixedLength(1)
	@FieldOptional
	public String inps;
	
	@FieldFixedLength(1)
	@FieldOptional
	public String altro;
	
	@FieldFixedLength(13)
	@FieldOptional
	public String imponibilePrevidenziale;
	
	@FieldFixedLength(13)
	@FieldOptional
	public String contributiACaricoDelLavoratore;
	
	//DP2
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio18;

	@FieldFixedLength(3)
	public String dp2;
	
	@FieldFixedLength(2)
	@FieldOptional
	public String flagDenunciaUniEmensTuttiIMesi;
	
	@FieldFixedLength(2)
	@FieldOptional
	public String meseSenzaDenunciaUniEmens01Dp2;
	
	@FieldFixedLength(2)
	@FieldOptional
	public String meseSenzaDenunciaUniEmens02Dp2;
	
	@FieldFixedLength(2)
	@FieldOptional
	public String meseSenzaDenunciaUniEmens03Dp2;
	
	@FieldFixedLength(2)
	@FieldOptional
	public String meseSenzaDenunciaUniEmens04Dp2;
	
	@FieldFixedLength(2)
	@FieldOptional
	public String meseSenzaDenunciaUniEmens05Dp2;
	
	@FieldFixedLength(2)
	@FieldOptional
	public String meseSenzaDenunciaUniEmens06Dp2;
	
	@FieldFixedLength(2)
	@FieldOptional
	public String meseSenzaDenunciaUniEmens07Dp2;
	
	@FieldFixedLength(2)
	@FieldOptional
	public String meseSenzaDenunciaUniEmens08Dp2;
	
	@FieldFixedLength(2)
	@FieldOptional
	public String meseSenzaDenunciaUniEmens09Dp2;
	
	@FieldFixedLength(2)
	@FieldOptional
	public String meseSenzaDenunciaUniEmens10Dp2;
	
	@FieldFixedLength(2)
	@FieldOptional
	public String meseSenzaDenunciaUniEmens11Dp2;
	
	@FieldFixedLength(2)
	@FieldOptional
	public String meseSenzaDenunciaUniEmens12Dp2;


	//DP3
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio19;

	@FieldFixedLength(3)
	public String dp3;
	
	@FieldFixedLength(13)
	@FieldOptional
	public String compensiAlParasubordinato;
	
	@FieldFixedLength(13)
	@FieldOptional
	public String contributiDovuti;
	
	@FieldFixedLength(13)
	@FieldOptional
	public String contributiACaricoDelLavoratoreDp3;
	
	@FieldFixedLength(13)
	@FieldOptional
	public String contributiVersati;

	@FieldFixedLength(2)
	@FieldOptional
	public String flagDenunciaUniEmensTuttiIMesiDp3;
	
	@FieldFixedLength(2)
	@FieldOptional
	public String meseSenzaDenunciaUniEmens01Dp3;
	
	@FieldFixedLength(2)
	@FieldOptional
	public String meseSenzaDenunciaUniEmens02Dp3;
	
	@FieldFixedLength(2)
	@FieldOptional
	public String meseSenzaDenunciaUniEmens03Dp3;
	
	@FieldFixedLength(2)
	@FieldOptional
	public String meseSenzaDenunciaUniEmens04Dp3;
	
	@FieldFixedLength(2)
	@FieldOptional
	public String meseSenzaDenunciaUniEmens05Dp3;
	
	@FieldFixedLength(2)
	@FieldOptional
	public String meseSenzaDenunciaUniEmens06Dp3;
	
	@FieldFixedLength(2)
	@FieldOptional
	public String meseSenzaDenunciaUniEmens07Dp3;
	
	@FieldFixedLength(2)
	@FieldOptional
	public String meseSenzaDenunciaUniEmens08Dp3;
	
	@FieldFixedLength(2)
	@FieldOptional
	public String meseSenzaDenunciaUniEmens09Dp3;
	
	@FieldFixedLength(2)
	@FieldOptional
	public String meseSenzaDenunciaUniEmens10Dp3;
	
	@FieldFixedLength(2)
	@FieldOptional
	public String meseSenzaDenunciaUniEmens11Dp3;
	
	@FieldFixedLength(2)
	@FieldOptional
	public String meseSenzaDenunciaUniEmens12Dp3;

	//DP4
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio20;

	@FieldFixedLength(3)
	public String dp4;

	@FieldFixedLength(11)
	@FieldOptional
	public String codiceFiscaleAzienda;
	
	@FieldFixedLength(7)
	@FieldOptional
	public String codiceMef;
	
	@FieldFixedLength(1)
	@FieldOptional
	public String cassaPensione;
	
	@FieldFixedLength(4)
	@FieldOptional
	public String cassaPrev;
	
	@FieldFixedLength(1)
	@FieldOptional
	public String cassaCred;
	
	@FieldFixedLength(1)
	@FieldOptional
	public String cassaEnpDep;
	
	@FieldFixedLength(4)
	@FieldOptional
	public String annoRiferimento;
	
	@FieldFixedLength(13)
	@FieldOptional
	public String imponibilePensionistico;
	
	@FieldFixedLength(13)
	@FieldOptional
	public String contributiDovutiDp4;
	
	@FieldFixedLength(13)
	@FieldOptional
	public String imponibileTfs;
	
	//DP5
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio21;

	@FieldFixedLength(3)
	public String dp5;

	@FieldFixedLength(13)
	@FieldOptional
	public String contributiTfs;

	@FieldFixedLength(13)
	@FieldOptional
	public String imponibileTfr;

	@FieldFixedLength(13)
	@FieldOptional
	public String contributiTfrDovuti;

	@FieldFixedLength(13)
	@FieldOptional
	public String imponibileGestioneCredito;

	@FieldFixedLength(13)
	@FieldOptional
	public String contributiGestioneCreditoDovuti;

	@FieldFixedLength(13)
	@FieldOptional
	public String imponibileEnpDep;

	@FieldFixedLength(13)
	@FieldOptional
	public String contributiEnpDepDovuti;
	
	//DP6
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio22;

	@FieldFixedLength(3)
	public String dp6;

	@FieldFixedLength(1)
	@FieldOptional
	public String entePrevidenziale;
	
	@FieldFixedLength(10)
	@FieldOptional
	public String codiceAzienda;
	
	@FieldFixedLength(1)
	@FieldOptional
	public String categoriaLavoro;
	
	@FieldFixedLength(13)
	@FieldOptional
	public String imponibilePrevidenzialeDp6;

	@FieldFixedLength(13)
	@FieldOptional
	public String contributiDovutiDp6;

	@FieldFixedLength(13)
	@FieldOptional
	public String contributiACaricoDelLavoratoreTrattenuti;

	@FieldFixedLength(13)
	@FieldOptional
	public String contributiVersatiDp6;
		
	//CL1
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio23;

	@FieldFixedLength(3)
	public String cl1;

	@FieldFixedLength(3)
	@FieldOptional
	public String tipologiaReddituale;
		
	//CL2
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio24;

	@FieldFixedLength(3)
	public String cl2;

	@FieldFixedLength(13)
	@FieldOptional
	public String lordoCorrisposto;

	@FieldFixedLength(13)
	@FieldOptional
	public String imponibile;

	@FieldFixedLength(13)
	@FieldOptional
	public String ritenuteATitoloDiAcconto;

	//PG1
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio25;

	@FieldFixedLength(3)
	public String pg1;

	@FieldFixedLength(16)
	@FieldOptional
	public String codiceFiscaleDebitorePg1;
		
	@FieldFixedLength(13)
	@FieldOptional
	public String sommeErogatePg1;

	@FieldFixedLength(13)
	@FieldOptional
	public String ritenuteOperatePg1;

	@FieldFixedLength(13)
	@FieldOptional
	public String sommeErogateNonTassatePg1;

	//PG2
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio26;

	@FieldFixedLength(3)
	public String pg2;

	@FieldFixedLength(16)
	@FieldOptional
	public String codiceFiscaleDebitorePg2;
		
	@FieldFixedLength(13)
	@FieldOptional
	public String sommeErogatePg2;

	@FieldFixedLength(13)
	@FieldOptional
	public String ritenuteOperatePg2;

	@FieldFixedLength(13)
	@FieldOptional
	public String sommeErogateNonTassatePg2;
	
	//FI0
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio27;

	@FieldFixedLength(3)
	public String fi0;
	
	@FieldFixedLength(10)
	@FieldOptional
	public String data; 

	@FieldFixedLength(40)
	@FieldOptional
	public String firma;
	
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
	@FieldOptional
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

	public String getFlagConiuge() {
		return flagConiuge;
	}

	public void setFlagConiuge(String flagConiuge) {
		this.flagConiuge = flagConiuge;
	}

	public String getSpazio2() {
		return spazio2;
	}

	public void setSpazio2(String spazio2) {
		this.spazio2 = spazio2;
	}

	public String getCfConiuge() {
		return cfConiuge;
	}

	public void setCfConiuge(String cfConiuge) {
		this.cfConiuge = cfConiuge;
	}

	public String getMessiACaricoConiuge() {
		return messiACaricoConiuge;
	}

	public void setMessiACaricoConiuge(String messiACaricoConiuge) {
		this.messiACaricoConiuge = messiACaricoConiuge;
	}

	public String getSpazio3() {
		return spazio3;
	}

	public void setSpazio3(String spazio3) {
		this.spazio3 = spazio3;
	}

	public String getDc2() {
		return dc2;
	}

	public void setDc2(String dc2) {
		this.dc2 = dc2;
	}

	public String getFlagFiglioDc2() {
		return flagFiglioDc2;
	}

	public void setFlagFiglioDc2(String flagFiglioDc2) {
		this.flagFiglioDc2 = flagFiglioDc2;
	}

	public String getSpazio4() {
		return spazio4;
	}

	public void setSpazio4(String spazio4) {
		this.spazio4 = spazio4;
	}

	public String getFlagDisabileDc2() {
		return flagDisabileDc2;
	}

	public void setFlagDisabileDc2(String flagDisabileDc2) {
		this.flagDisabileDc2 = flagDisabileDc2;
	}

	public String getCfFiglio() {
		return cfFiglio;
	}

	public void setCfFiglio(String cfFiglio) {
		this.cfFiglio = cfFiglio;
	}

	public String getMesiACaricoFiglio() {
		return mesiACaricoFiglio;
	}

	public void setMesiACaricoFiglio(String mesiACaricoFiglio) {
		this.mesiACaricoFiglio = mesiACaricoFiglio;
	}

	public String getMinoredi3AnniDc2() {
		return minoredi3AnniDc2;
	}

	public void setMinoredi3AnniDc2(String minoredi3AnniDc2) {
		this.minoredi3AnniDc2 = minoredi3AnniDc2;
	}

	public String getPercentualeDetrazioneSpettanteDc2() {
		return percentualeDetrazioneSpettanteDc2;
	}

	public void setPercentualeDetrazioneSpettanteDc2(String percentualeDetrazioneSpettanteDc2) {
		this.percentualeDetrazioneSpettanteDc2 = percentualeDetrazioneSpettanteDc2;
	}

	public String getSpazio6() {
		return spazio6;
	}

	public void setSpazio6(String spazio6) {
		this.spazio6 = spazio6;
	}

	public String getDc3() {
		return dc3;
	}

	public void setDc3(String dc3) {
		this.dc3 = dc3;
	}

	public String getFlagFiglioDc3() {
		return flagFiglioDc3;
	}

	public void setFlagFiglioDc3(String flagFiglioDc3) {
		this.flagFiglioDc3 = flagFiglioDc3;
	}

	public String getFlagAltroFamiliareDc3() {
		return flagAltroFamiliareDc3;
	}

	public void setFlagAltroFamiliareDc3(String flagAltroFamiliareDc3) {
		this.flagAltroFamiliareDc3 = flagAltroFamiliareDc3;
	}

	public String getFlagDisabileDc3() {
		return flagDisabileDc3;
	}

	public void setFlagDisabileDc3(String flagDisabileDc3) {
		this.flagDisabileDc3 = flagDisabileDc3;
	}

	public String getCfFiglioOFamiliareDc3() {
		return cfFiglioOFamiliareDc3;
	}

	public void setCfFiglioOFamiliareDc3(String cfFiglioOFamiliareDc3) {
		this.cfFiglioOFamiliareDc3 = cfFiglioOFamiliareDc3;
	}

	public String getMesiACaricoFiglioDc3() {
		return mesiACaricoFiglioDc3;
	}

	public void setMesiACaricoFiglioDc3(String mesiACaricoFiglioDc3) {
		this.mesiACaricoFiglioDc3 = mesiACaricoFiglioDc3;
	}

	public String getMinoreADi3AnniDc3() {
		return minoreADi3AnniDc3;
	}

	public void setMinoreADi3AnniDc3(String minoreADi3AnniDc3) {
		this.minoreADi3AnniDc3 = minoreADi3AnniDc3;
	}

	public String getPercentualeDetrazioneSpettanteDc3() {
		return percentualeDetrazioneSpettanteDc3;
	}

	public void setPercentualeDetrazioneSpettanteDc3(String percentualeDetrazioneSpettanteDc3) {
		this.percentualeDetrazioneSpettanteDc3 = percentualeDetrazioneSpettanteDc3;
	}

	public String getSpazio7() {
		return spazio7;
	}

	public void setSpazio7(String spazio7) {
		this.spazio7 = spazio7;
	}

	public String getDc4() {
		return dc4;
	}

	public void setDc4(String dc4) {
		this.dc4 = dc4;
	}

	public String getFlagFiglioDc4() {
		return flagFiglioDc4;
	}

	public void setFlagFiglioDc4(String flagFiglioDc4) {
		this.flagFiglioDc4 = flagFiglioDc4;
	}

	public String getFlagAltroFamiliareDc4() {
		return flagAltroFamiliareDc4;
	}

	public void setFlagAltroFamiliareDc4(String flagAltroFamiliareDc4) {
		this.flagAltroFamiliareDc4 = flagAltroFamiliareDc4;
	}

	public String getFlagDisabileDc4() {
		return flagDisabileDc4;
	}

	public void setFlagDisabileDc4(String flagDisabileDc4) {
		this.flagDisabileDc4 = flagDisabileDc4;
	}

	public String getCfFiglioOFamiliareDc4() {
		return cfFiglioOFamiliareDc4;
	}

	public void setCfFiglioOFamiliareDc4(String cfFiglioOFamiliareDc4) {
		this.cfFiglioOFamiliareDc4 = cfFiglioOFamiliareDc4;
	}

	public String getMesiACaricoFiglioDc4() {
		return mesiACaricoFiglioDc4;
	}

	public void setMesiACaricoFiglioDc4(String mesiACaricoFiglioDc4) {
		this.mesiACaricoFiglioDc4 = mesiACaricoFiglioDc4;
	}

	public String getMinoreADi3AnniDc4() {
		return minoreADi3AnniDc4;
	}

	public void setMinoreADi3AnniDc4(String minoreADi3AnniDc4) {
		this.minoreADi3AnniDc4 = minoreADi3AnniDc4;
	}

	public String getPercentualeDetrazioneSpettanteDc4() {
		return percentualeDetrazioneSpettanteDc4;
	}

	public void setPercentualeDetrazioneSpettanteDc4(String percentualeDetrazioneSpettanteDc4) {
		this.percentualeDetrazioneSpettanteDc4 = percentualeDetrazioneSpettanteDc4;
	}

	public String getSpazio8() {
		return spazio8;
	}

	public void setSpazio8(String spazio8) {
		this.spazio8 = spazio8;
	}

	public String getDc5() {
		return dc5;
	}

	public void setDc5(String dc5) {
		this.dc5 = dc5;
	}

	public String getFlagFiglioDc5() {
		return flagFiglioDc5;
	}

	public void setFlagFiglioDc5(String flagFiglioDc5) {
		this.flagFiglioDc5 = flagFiglioDc5;
	}

	public String getFlagAltroFamiliareDc5() {
		return flagAltroFamiliareDc5;
	}

	public void setFlagAltroFamiliareDc5(String flagAltroFamiliareDc5) {
		this.flagAltroFamiliareDc5 = flagAltroFamiliareDc5;
	}

	public String getFlagDisabileDc5() {
		return flagDisabileDc5;
	}

	public void setFlagDisabileDc5(String flagDisabileDc5) {
		this.flagDisabileDc5 = flagDisabileDc5;
	}

	public String getCfFiglioOFamiliareDc5() {
		return cfFiglioOFamiliareDc5;
	}

	public void setCfFiglioOFamiliareDc5(String cfFiglioOFamiliareDc5) {
		this.cfFiglioOFamiliareDc5 = cfFiglioOFamiliareDc5;
	}

	public String getMesiACaricoFiglioDc5() {
		return mesiACaricoFiglioDc5;
	}

	public void setMesiACaricoFiglioDc5(String mesiACaricoFiglioDc5) {
		this.mesiACaricoFiglioDc5 = mesiACaricoFiglioDc5;
	}

	public String getMinoreADi3AnniDc5() {
		return minoreADi3AnniDc5;
	}

	public void setMinoreADi3AnniDc5(String minoreADi3AnniDc5) {
		this.minoreADi3AnniDc5 = minoreADi3AnniDc5;
	}

	public String getPercentualeDetrazioneSpettanteDc5() {
		return percentualeDetrazioneSpettanteDc5;
	}

	public void setPercentualeDetrazioneSpettanteDc5(String percentualeDetrazioneSpettanteDc5) {
		this.percentualeDetrazioneSpettanteDc5 = percentualeDetrazioneSpettanteDc5;
	}

	public String getSpazio9() {
		return spazio9;
	}

	public void setSpazio9(String spazio9) {
		this.spazio9 = spazio9;
	}

	public String getDc6() {
		return dc6;
	}

	public void setDc6(String dc6) {
		this.dc6 = dc6;
	}

	public String getFlagFiglioDc6() {
		return flagFiglioDc6;
	}

	public void setFlagFiglioDc6(String flagFiglioDc6) {
		this.flagFiglioDc6 = flagFiglioDc6;
	}

	public String getFlagAltroFamiliareDc6() {
		return flagAltroFamiliareDc6;
	}

	public void setFlagAltroFamiliareDc6(String flagAltroFamiliareDc6) {
		this.flagAltroFamiliareDc6 = flagAltroFamiliareDc6;
	}

	public String getFlagDisabileDc6() {
		return flagDisabileDc6;
	}

	public void setFlagDisabileDc6(String flagDisabileDc6) {
		this.flagDisabileDc6 = flagDisabileDc6;
	}

	public String getCfFiglioOFamiliareDc6() {
		return cfFiglioOFamiliareDc6;
	}

	public void setCfFiglioOFamiliareDc6(String cfFiglioOFamiliareDc6) {
		this.cfFiglioOFamiliareDc6 = cfFiglioOFamiliareDc6;
	}

	public String getMesiACaricoFiglioDc6() {
		return mesiACaricoFiglioDc6;
	}

	public void setMesiACaricoFiglioDc6(String mesiACaricoFiglioDc6) {
		this.mesiACaricoFiglioDc6 = mesiACaricoFiglioDc6;
	}

	public String getMinoreADi3AnniDc6() {
		return minoreADi3AnniDc6;
	}

	public void setMinoreADi3AnniDc6(String minoreADi3AnniDc6) {
		this.minoreADi3AnniDc6 = minoreADi3AnniDc6;
	}

	public String getPercentualeDetrazioneSpettanteDc6() {
		return percentualeDetrazioneSpettanteDc6;
	}

	public void setPercentualeDetrazioneSpettanteDc6(String percentualeDetrazioneSpettanteDc6) {
		this.percentualeDetrazioneSpettanteDc6 = percentualeDetrazioneSpettanteDc6;
	}

	public String getSpazio10() {
		return spazio10;
	}

	public void setSpazio10(String spazio10) {
		this.spazio10 = spazio10;
	}

	public String getDc7() {
		return dc7;
	}

	public void setDc7(String dc7) {
		this.dc7 = dc7;
	}

	public String getFlagFiglioDc7() {
		return flagFiglioDc7;
	}

	public void setFlagFiglioDc7(String flagFiglioDc7) {
		this.flagFiglioDc7 = flagFiglioDc7;
	}

	public String getFlagAltroFamiliareDc7() {
		return flagAltroFamiliareDc7;
	}

	public void setFlagAltroFamiliareDc7(String flagAltroFamiliareDc7) {
		this.flagAltroFamiliareDc7 = flagAltroFamiliareDc7;
	}

	public String getFlagDisabileDc7() {
		return flagDisabileDc7;
	}

	public void setFlagDisabileDc7(String flagDisabileDc7) {
		this.flagDisabileDc7 = flagDisabileDc7;
	}

	public String getCfFiglioOFamiliareDc7() {
		return cfFiglioOFamiliareDc7;
	}

	public void setCfFiglioOFamiliareDc7(String cfFiglioOFamiliareDc7) {
		this.cfFiglioOFamiliareDc7 = cfFiglioOFamiliareDc7;
	}

	public String getMesiACaricoFiglioDc7() {
		return mesiACaricoFiglioDc7;
	}

	public void setMesiACaricoFiglioDc7(String mesiACaricoFiglioDc7) {
		this.mesiACaricoFiglioDc7 = mesiACaricoFiglioDc7;
	}

	public String getMinoreADi3AnniDc7() {
		return minoreADi3AnniDc7;
	}

	public void setMinoreADi3AnniDc7(String minoreADi3AnniDc7) {
		this.minoreADi3AnniDc7 = minoreADi3AnniDc7;
	}

	public String getPercentualeDetrazioneSpettanteDc7() {
		return percentualeDetrazioneSpettanteDc7;
	}

	public void setPercentualeDetrazioneSpettanteDc7(String percentualeDetrazioneSpettanteDc7) {
		this.percentualeDetrazioneSpettanteDc7 = percentualeDetrazioneSpettanteDc7;
	}

	public String getSpazio11() {
		return spazio11;
	}

	public void setSpazio11(String spazio11) {
		this.spazio11 = spazio11;
	}

	public String getDc8() {
		return dc8;
	}

	public void setDc8(String dc8) {
		this.dc8 = dc8;
	}

	public String getFlagFiglioDc8() {
		return flagFiglioDc8;
	}

	public void setFlagFiglioDc8(String flagFiglioDc8) {
		this.flagFiglioDc8 = flagFiglioDc8;
	}

	public String getFlagAltroFamiliareDc8() {
		return flagAltroFamiliareDc8;
	}

	public void setFlagAltroFamiliareDc8(String flagAltroFamiliareDc8) {
		this.flagAltroFamiliareDc8 = flagAltroFamiliareDc8;
	}

	public String getFlagDisabileDc8() {
		return flagDisabileDc8;
	}

	public void setFlagDisabileDc8(String flagDisabileDc8) {
		this.flagDisabileDc8 = flagDisabileDc8;
	}

	public String getCfFiglioOFamiliareDc8() {
		return cfFiglioOFamiliareDc8;
	}

	public void setCfFiglioOFamiliareDc8(String cfFiglioOFamiliareDc8) {
		this.cfFiglioOFamiliareDc8 = cfFiglioOFamiliareDc8;
	}

	public String getMesiACaricoFiglioDc8() {
		return mesiACaricoFiglioDc8;
	}

	public void setMesiACaricoFiglioDc8(String mesiACaricoFiglioDc8) {
		this.mesiACaricoFiglioDc8 = mesiACaricoFiglioDc8;
	}

	public String getMinoreADi3AnniDc8() {
		return minoreADi3AnniDc8;
	}

	public void setMinoreADi3AnniDc8(String minoreADi3AnniDc8) {
		this.minoreADi3AnniDc8 = minoreADi3AnniDc8;
	}

	public String getPercentualeDetrazioneSpettanteDc8() {
		return percentualeDetrazioneSpettanteDc8;
	}

	public void setPercentualeDetrazioneSpettanteDc8(String percentualeDetrazioneSpettanteDc8) {
		this.percentualeDetrazioneSpettanteDc8 = percentualeDetrazioneSpettanteDc8;
	}

	public String getSpazio12() {
		return spazio12;
	}

	public void setSpazio12(String spazio12) {
		this.spazio12 = spazio12;
	}

	public String getDc9() {
		return dc9;
	}

	public void setDc9(String dc9) {
		this.dc9 = dc9;
	}

	public String getFlagFiglioDc9() {
		return flagFiglioDc9;
	}

	public void setFlagFiglioDc9(String flagFiglioDc9) {
		this.flagFiglioDc9 = flagFiglioDc9;
	}

	public String getFlagAltroFamiliareDc9() {
		return flagAltroFamiliareDc9;
	}

	public void setFlagAltroFamiliareDc9(String flagAltroFamiliareDc9) {
		this.flagAltroFamiliareDc9 = flagAltroFamiliareDc9;
	}

	public String getFlagDisabileDc9() {
		return flagDisabileDc9;
	}

	public void setFlagDisabileDc9(String flagDisabileDc9) {
		this.flagDisabileDc9 = flagDisabileDc9;
	}

	public String getCfFiglioOFamiliareDc9() {
		return cfFiglioOFamiliareDc9;
	}

	public void setCfFiglioOFamiliareDc9(String cfFiglioOFamiliareDc9) {
		this.cfFiglioOFamiliareDc9 = cfFiglioOFamiliareDc9;
	}

	public String getMesiACaricoFiglioDc9() {
		return mesiACaricoFiglioDc9;
	}

	public void setMesiACaricoFiglioDc9(String mesiACaricoFiglioDc9) {
		this.mesiACaricoFiglioDc9 = mesiACaricoFiglioDc9;
	}

	public String getMinoreADi3AnniDc9() {
		return minoreADi3AnniDc9;
	}

	public void setMinoreADi3AnniDc9(String minoreADi3AnniDc9) {
		this.minoreADi3AnniDc9 = minoreADi3AnniDc9;
	}

	public String getPercentualeDetrazioneSpettanteDc9() {
		return percentualeDetrazioneSpettanteDc9;
	}

	public void setPercentualeDetrazioneSpettanteDc9(String percentualeDetrazioneSpettanteDc9) {
		this.percentualeDetrazioneSpettanteDc9 = percentualeDetrazioneSpettanteDc9;
	}

	public String getSpazio13() {
		return spazio13;
	}

	public void setSpazio13(String spazio13) {
		this.spazio13 = spazio13;
	}

	public String getDca() {
		return dca;
	}

	public void setDca(String dca) {
		this.dca = dca;
	}

	public String getPercentualeSpettanteFamiglieNumerose() {
		return percentualeSpettanteFamiglieNumerose;
	}

	public void setPercentualeSpettanteFamiglieNumerose(String percentualeSpettanteFamiglieNumerose) {
		this.percentualeSpettanteFamiglieNumerose = percentualeSpettanteFamiglieNumerose;
	}

	public String getSpazio14() {
		return spazio14;
	}

	public void setSpazio14(String spazio14) {
		this.spazio14 = spazio14;
	}

	public String getTs2() {
		return ts2;
	}

	public void setTs2(String ts2) {
		this.ts2 = ts2;
	}

	public String getIndennitaAccontiAnnoCorrente() {
		return indennitaAccontiAnnoCorrente;
	}

	public void setIndennitaAccontiAnnoCorrente(String indennitaAccontiAnnoCorrente) {
		this.indennitaAccontiAnnoCorrente = indennitaAccontiAnnoCorrente;
	}

	public String getAccontoAnnoPrecedente() {
		return accontoAnnoPrecedente;
	}

	public void setAccontoAnnoPrecedente(String accontoAnnoPrecedente) {
		this.accontoAnnoPrecedente = accontoAnnoPrecedente;
	}

	public String getDetrazione() {
		return detrazione;
	}

	public void setDetrazione(String detrazione) {
		this.detrazione = detrazione;
	}

	public String getSpazio15() {
		return spazio15;
	}

	public void setSpazio15(String spazio15) {
		this.spazio15 = spazio15;
	}

	public String getTs3() {
		return ts3;
	}

	public void setTs3(String ts3) {
		this.ts3 = ts3;
	}

	public String getRitenutaAnnoCorrente() {
		return ritenutaAnnoCorrente;
	}

	public void setRitenutaAnnoCorrente(String ritenutaAnnoCorrente) {
		this.ritenutaAnnoCorrente = ritenutaAnnoCorrente;
	}

	public String getRitenuteAnnoPrecedente() {
		return ritenuteAnnoPrecedente;
	}

	public void setRitenuteAnnoPrecedente(String ritenuteAnnoPrecedente) {
		this.ritenuteAnnoPrecedente = ritenuteAnnoPrecedente;
	}

	public String getTfrMaturatoInAziendaFinoA2000() {
		return tfrMaturatoInAziendaFinoA2000;
	}

	public void setTfrMaturatoInAziendaFinoA2000(String tfrMaturatoInAziendaFinoA2000) {
		this.tfrMaturatoInAziendaFinoA2000 = tfrMaturatoInAziendaFinoA2000;
	}

	public String getSpazio16() {
		return spazio16;
	}

	public void setSpazio16(String spazio16) {
		this.spazio16 = spazio16;
	}

	public String getTs4() {
		return ts4;
	}

	public void setTs4(String ts4) {
		this.ts4 = ts4;
	}

	public String getTfrMaturatoInAziendaDal2001() {
		return tfrMaturatoInAziendaDal2001;
	}

	public void setTfrMaturatoInAziendaDal2001(String tfrMaturatoInAziendaDal2001) {
		this.tfrMaturatoInAziendaDal2001 = tfrMaturatoInAziendaDal2001;
	}

	public String getTfrMaturatoFinoAl200AlFondo() {
		return tfrMaturatoFinoAl200AlFondo;
	}

	public void setTfrMaturatoFinoAl200AlFondo(String tfrMaturatoFinoAl200AlFondo) {
		this.tfrMaturatoFinoAl200AlFondo = tfrMaturatoFinoAl200AlFondo;
	}

	public String getImpostaSostitutivaRivalutazioniTfr() {
		return impostaSostitutivaRivalutazioniTfr;
	}

	public void setImpostaSostitutivaRivalutazioniTfr(String impostaSostitutivaRivalutazioniTfr) {
		this.impostaSostitutivaRivalutazioniTfr = impostaSostitutivaRivalutazioniTfr;
	}

	public String getSpazio17() {
		return spazio17;
	}

	public void setSpazio17(String spazio17) {
		this.spazio17 = spazio17;
	}

	public String getDp1() {
		return dp1;
	}

	public void setDp1(String dp1) {
		this.dp1 = dp1;
	}

	public String getMatricolaAzienda() {
		return matricolaAzienda;
	}

	public void setMatricolaAzienda(String matricolaAzienda) {
		this.matricolaAzienda = matricolaAzienda;
	}

	public String getInps() {
		return inps;
	}

	public void setInps(String inps) {
		this.inps = inps;
	}

	public String getAltro() {
		return altro;
	}

	public void setAltro(String altro) {
		this.altro = altro;
	}

	public String getImponibilePrevidenziale() {
		return imponibilePrevidenziale;
	}

	public void setImponibilePrevidenziale(String imponibilePrevidenziale) {
		this.imponibilePrevidenziale = imponibilePrevidenziale;
	}

	public String getContributiACaricoDelLavoratore() {
		return contributiACaricoDelLavoratore;
	}

	public void setContributiACaricoDelLavoratore(String contributiACaricoDelLavoratore) {
		this.contributiACaricoDelLavoratore = contributiACaricoDelLavoratore;
	}

	public String getSpazio18() {
		return spazio18;
	}

	public void setSpazio18(String spazio18) {
		this.spazio18 = spazio18;
	}

	public String getDp2() {
		return dp2;
	}

	public void setDp2(String dp2) {
		this.dp2 = dp2;
	}

	public String getFlagDenunciaUniEmensTuttiIMesi() {
		return flagDenunciaUniEmensTuttiIMesi;
	}

	public void setFlagDenunciaUniEmensTuttiIMesi(String flagDenunciaUniEmensTuttiIMesi) {
		this.flagDenunciaUniEmensTuttiIMesi = flagDenunciaUniEmensTuttiIMesi;
	}

	public String getMeseSenzaDenunciaUniEmens01Dp2() {
		return meseSenzaDenunciaUniEmens01Dp2;
	}

	public void setMeseSenzaDenunciaUniEmens01Dp2(String meseSenzaDenunciaUniEmens01Dp2) {
		this.meseSenzaDenunciaUniEmens01Dp2 = meseSenzaDenunciaUniEmens01Dp2;
	}

	public String getMeseSenzaDenunciaUniEmens02Dp2() {
		return meseSenzaDenunciaUniEmens02Dp2;
	}

	public void setMeseSenzaDenunciaUniEmens02Dp2(String meseSenzaDenunciaUniEmens02Dp2) {
		this.meseSenzaDenunciaUniEmens02Dp2 = meseSenzaDenunciaUniEmens02Dp2;
	}

	public String getMeseSenzaDenunciaUniEmens03Dp2() {
		return meseSenzaDenunciaUniEmens03Dp2;
	}

	public void setMeseSenzaDenunciaUniEmens03Dp2(String meseSenzaDenunciaUniEmens03Dp2) {
		this.meseSenzaDenunciaUniEmens03Dp2 = meseSenzaDenunciaUniEmens03Dp2;
	}

	public String getMeseSenzaDenunciaUniEmens04Dp2() {
		return meseSenzaDenunciaUniEmens04Dp2;
	}

	public void setMeseSenzaDenunciaUniEmens04Dp2(String meseSenzaDenunciaUniEmens04Dp2) {
		this.meseSenzaDenunciaUniEmens04Dp2 = meseSenzaDenunciaUniEmens04Dp2;
	}

	public String getMeseSenzaDenunciaUniEmens05Dp2() {
		return meseSenzaDenunciaUniEmens05Dp2;
	}

	public void setMeseSenzaDenunciaUniEmens05Dp2(String meseSenzaDenunciaUniEmens05Dp2) {
		this.meseSenzaDenunciaUniEmens05Dp2 = meseSenzaDenunciaUniEmens05Dp2;
	}

	public String getMeseSenzaDenunciaUniEmens06Dp2() {
		return meseSenzaDenunciaUniEmens06Dp2;
	}

	public void setMeseSenzaDenunciaUniEmens06Dp2(String meseSenzaDenunciaUniEmens06Dp2) {
		this.meseSenzaDenunciaUniEmens06Dp2 = meseSenzaDenunciaUniEmens06Dp2;
	}

	public String getMeseSenzaDenunciaUniEmens07Dp2() {
		return meseSenzaDenunciaUniEmens07Dp2;
	}

	public void setMeseSenzaDenunciaUniEmens07Dp2(String meseSenzaDenunciaUniEmens07Dp2) {
		this.meseSenzaDenunciaUniEmens07Dp2 = meseSenzaDenunciaUniEmens07Dp2;
	}

	public String getMeseSenzaDenunciaUniEmens08Dp2() {
		return meseSenzaDenunciaUniEmens08Dp2;
	}

	public void setMeseSenzaDenunciaUniEmens08Dp2(String meseSenzaDenunciaUniEmens08Dp2) {
		this.meseSenzaDenunciaUniEmens08Dp2 = meseSenzaDenunciaUniEmens08Dp2;
	}

	public String getMeseSenzaDenunciaUniEmens09Dp2() {
		return meseSenzaDenunciaUniEmens09Dp2;
	}

	public void setMeseSenzaDenunciaUniEmens09Dp2(String meseSenzaDenunciaUniEmens09Dp2) {
		this.meseSenzaDenunciaUniEmens09Dp2 = meseSenzaDenunciaUniEmens09Dp2;
	}

	public String getMeseSenzaDenunciaUniEmens10Dp2() {
		return meseSenzaDenunciaUniEmens10Dp2;
	}

	public void setMeseSenzaDenunciaUniEmens10Dp2(String meseSenzaDenunciaUniEmens10Dp2) {
		this.meseSenzaDenunciaUniEmens10Dp2 = meseSenzaDenunciaUniEmens10Dp2;
	}

	public String getMeseSenzaDenunciaUniEmens11Dp2() {
		return meseSenzaDenunciaUniEmens11Dp2;
	}

	public void setMeseSenzaDenunciaUniEmens11Dp2(String meseSenzaDenunciaUniEmens11Dp2) {
		this.meseSenzaDenunciaUniEmens11Dp2 = meseSenzaDenunciaUniEmens11Dp2;
	}

	public String getMeseSenzaDenunciaUniEmens12Dp2() {
		return meseSenzaDenunciaUniEmens12Dp2;
	}

	public void setMeseSenzaDenunciaUniEmens12Dp2(String meseSenzaDenunciaUniEmens12Dp2) {
		this.meseSenzaDenunciaUniEmens12Dp2 = meseSenzaDenunciaUniEmens12Dp2;
	}

	public String getSpazio19() {
		return spazio19;
	}

	public void setSpazio19(String spazio19) {
		this.spazio19 = spazio19;
	}

	public String getDp3() {
		return dp3;
	}

	public void setDp3(String dp3) {
		this.dp3 = dp3;
	}

	public String getCompensiAlParasubordinato() {
		return compensiAlParasubordinato;
	}

	public void setCompensiAlParasubordinato(String compensiAlParasubordinato) {
		this.compensiAlParasubordinato = compensiAlParasubordinato;
	}

	public String getContributiDovuti() {
		return contributiDovuti;
	}

	public void setContributiDovuti(String contributiDovuti) {
		this.contributiDovuti = contributiDovuti;
	}

	public String getContributiACaricoDelLavoratoreDp3() {
		return contributiACaricoDelLavoratoreDp3;
	}

	public void setContributiACaricoDelLavoratoreDp3(String contributiACaricoDelLavoratoreDp3) {
		this.contributiACaricoDelLavoratoreDp3 = contributiACaricoDelLavoratoreDp3;
	}

	public String getContributiVersati() {
		return contributiVersati;
	}

	public void setContributiVersati(String contributiVersati) {
		this.contributiVersati = contributiVersati;
	}

	public String getFlagDenunciaUniEmensTuttiIMesiDp3() {
		return flagDenunciaUniEmensTuttiIMesiDp3;
	}

	public void setFlagDenunciaUniEmensTuttiIMesiDp3(String flagDenunciaUniEmensTuttiIMesiDp3) {
		this.flagDenunciaUniEmensTuttiIMesiDp3 = flagDenunciaUniEmensTuttiIMesiDp3;
	}

	public String getMeseSenzaDenunciaUniEmens01Dp3() {
		return meseSenzaDenunciaUniEmens01Dp3;
	}

	public void setMeseSenzaDenunciaUniEmens01Dp3(String meseSenzaDenunciaUniEmens01Dp3) {
		this.meseSenzaDenunciaUniEmens01Dp3 = meseSenzaDenunciaUniEmens01Dp3;
	}

	public String getMeseSenzaDenunciaUniEmens02Dp3() {
		return meseSenzaDenunciaUniEmens02Dp3;
	}

	public void setMeseSenzaDenunciaUniEmens02Dp3(String meseSenzaDenunciaUniEmens02Dp3) {
		this.meseSenzaDenunciaUniEmens02Dp3 = meseSenzaDenunciaUniEmens02Dp3;
	}

	public String getMeseSenzaDenunciaUniEmens03Dp3() {
		return meseSenzaDenunciaUniEmens03Dp3;
	}

	public void setMeseSenzaDenunciaUniEmens03Dp3(String meseSenzaDenunciaUniEmens03Dp3) {
		this.meseSenzaDenunciaUniEmens03Dp3 = meseSenzaDenunciaUniEmens03Dp3;
	}

	public String getMeseSenzaDenunciaUniEmens04Dp3() {
		return meseSenzaDenunciaUniEmens04Dp3;
	}

	public void setMeseSenzaDenunciaUniEmens04Dp3(String meseSenzaDenunciaUniEmens04Dp3) {
		this.meseSenzaDenunciaUniEmens04Dp3 = meseSenzaDenunciaUniEmens04Dp3;
	}

	public String getMeseSenzaDenunciaUniEmens05Dp3() {
		return meseSenzaDenunciaUniEmens05Dp3;
	}

	public void setMeseSenzaDenunciaUniEmens05Dp3(String meseSenzaDenunciaUniEmens05Dp3) {
		this.meseSenzaDenunciaUniEmens05Dp3 = meseSenzaDenunciaUniEmens05Dp3;
	}

	public String getMeseSenzaDenunciaUniEmens06Dp3() {
		return meseSenzaDenunciaUniEmens06Dp3;
	}

	public void setMeseSenzaDenunciaUniEmens06Dp3(String meseSenzaDenunciaUniEmens06Dp3) {
		this.meseSenzaDenunciaUniEmens06Dp3 = meseSenzaDenunciaUniEmens06Dp3;
	}

	public String getMeseSenzaDenunciaUniEmens07Dp3() {
		return meseSenzaDenunciaUniEmens07Dp3;
	}

	public void setMeseSenzaDenunciaUniEmens07Dp3(String meseSenzaDenunciaUniEmens07Dp3) {
		this.meseSenzaDenunciaUniEmens07Dp3 = meseSenzaDenunciaUniEmens07Dp3;
	}

	public String getMeseSenzaDenunciaUniEmens08Dp3() {
		return meseSenzaDenunciaUniEmens08Dp3;
	}

	public void setMeseSenzaDenunciaUniEmens08Dp3(String meseSenzaDenunciaUniEmens08Dp3) {
		this.meseSenzaDenunciaUniEmens08Dp3 = meseSenzaDenunciaUniEmens08Dp3;
	}

	public String getMeseSenzaDenunciaUniEmens09Dp3() {
		return meseSenzaDenunciaUniEmens09Dp3;
	}

	public void setMeseSenzaDenunciaUniEmens09Dp3(String meseSenzaDenunciaUniEmens09Dp3) {
		this.meseSenzaDenunciaUniEmens09Dp3 = meseSenzaDenunciaUniEmens09Dp3;
	}

	public String getMeseSenzaDenunciaUniEmens10Dp3() {
		return meseSenzaDenunciaUniEmens10Dp3;
	}

	public void setMeseSenzaDenunciaUniEmens10Dp3(String meseSenzaDenunciaUniEmens10Dp3) {
		this.meseSenzaDenunciaUniEmens10Dp3 = meseSenzaDenunciaUniEmens10Dp3;
	}

	public String getMeseSenzaDenunciaUniEmens11Dp3() {
		return meseSenzaDenunciaUniEmens11Dp3;
	}

	public void setMeseSenzaDenunciaUniEmens11Dp3(String meseSenzaDenunciaUniEmens11Dp3) {
		this.meseSenzaDenunciaUniEmens11Dp3 = meseSenzaDenunciaUniEmens11Dp3;
	}

	public String getMeseSenzaDenunciaUniEmens12Dp3() {
		return meseSenzaDenunciaUniEmens12Dp3;
	}

	public void setMeseSenzaDenunciaUniEmens12Dp3(String meseSenzaDenunciaUniEmens12Dp3) {
		this.meseSenzaDenunciaUniEmens12Dp3 = meseSenzaDenunciaUniEmens12Dp3;
	}

	public String getSpazio20() {
		return spazio20;
	}

	public void setSpazio20(String spazio20) {
		this.spazio20 = spazio20;
	}

	public String getDp4() {
		return dp4;
	}

	public void setDp4(String dp4) {
		this.dp4 = dp4;
	}

	public String getCodiceFiscaleAzienda() {
		return codiceFiscaleAzienda;
	}

	public void setCodiceFiscaleAzienda(String codiceFiscaleAzienda) {
		this.codiceFiscaleAzienda = codiceFiscaleAzienda;
	}

	public String getCodiceMef() {
		return codiceMef;
	}

	public void setCodiceMef(String codiceMef) {
		this.codiceMef = codiceMef;
	}

	public String getCassaPensione() {
		return cassaPensione;
	}

	public void setCassaPensione(String cassaPensione) {
		this.cassaPensione = cassaPensione;
	}

	public String getCassaPrev() {
		return cassaPrev;
	}

	public void setCassaPrev(String cassaPrev) {
		this.cassaPrev = cassaPrev;
	}

	public String getCassaCred() {
		return cassaCred;
	}

	public void setCassaCred(String cassaCred) {
		this.cassaCred = cassaCred;
	}

	public String getCassaEnpDep() {
		return cassaEnpDep;
	}

	public void setCassaEnpDep(String cassaEnpDep) {
		this.cassaEnpDep = cassaEnpDep;
	}

	public String getAnnoRiferimento() {
		return annoRiferimento;
	}

	public void setAnnoRiferimento(String annoRiferimento) {
		this.annoRiferimento = annoRiferimento;
	}

	public String getImponibilePensionistico() {
		return imponibilePensionistico;
	}

	public void setImponibilePensionistico(String imponibilePensionistico) {
		this.imponibilePensionistico = imponibilePensionistico;
	}

	public String getContributiDovutiDp4() {
		return contributiDovutiDp4;
	}

	public void setContributiDovutiDp4(String contributiDovutiDp4) {
		this.contributiDovutiDp4 = contributiDovutiDp4;
	}

	public String getImponibileTfs() {
		return imponibileTfs;
	}

	public void setImponibileTfs(String imponibileTfs) {
		this.imponibileTfs = imponibileTfs;
	}

	public String getSpazio21() {
		return spazio21;
	}

	public void setSpazio21(String spazio21) {
		this.spazio21 = spazio21;
	}

	public String getDp5() {
		return dp5;
	}

	public void setDp5(String dp5) {
		this.dp5 = dp5;
	}

	public String getContributiTfs() {
		return contributiTfs;
	}

	public void setContributiTfs(String contributiTfs) {
		this.contributiTfs = contributiTfs;
	}

	public String getImponibileTfr() {
		return imponibileTfr;
	}

	public void setImponibileTfr(String imponibileTfr) {
		this.imponibileTfr = imponibileTfr;
	}

	public String getContributiTfrDovuti() {
		return contributiTfrDovuti;
	}

	public void setContributiTfrDovuti(String contributiTfrDovuti) {
		this.contributiTfrDovuti = contributiTfrDovuti;
	}

	public String getImponibileGestioneCredito() {
		return imponibileGestioneCredito;
	}

	public void setImponibileGestioneCredito(String imponibileGestioneCredito) {
		this.imponibileGestioneCredito = imponibileGestioneCredito;
	}

	public String getContributiGestioneCreditoDovuti() {
		return contributiGestioneCreditoDovuti;
	}

	public void setContributiGestioneCreditoDovuti(String contributiGestioneCreditoDovuti) {
		this.contributiGestioneCreditoDovuti = contributiGestioneCreditoDovuti;
	}

	public String getImponibileEnpDep() {
		return imponibileEnpDep;
	}

	public void setImponibileEnpDep(String imponibileEnpDep) {
		this.imponibileEnpDep = imponibileEnpDep;
	}

	public String getContributiEnpDepDovuti() {
		return contributiEnpDepDovuti;
	}

	public void setContributiEnpDepDovuti(String contributiEnpDepDovuti) {
		this.contributiEnpDepDovuti = contributiEnpDepDovuti;
	}

	public String getSpazio22() {
		return spazio22;
	}

	public void setSpazio22(String spazio22) {
		this.spazio22 = spazio22;
	}

	public String getDp6() {
		return dp6;
	}

	public void setDp6(String dp6) {
		this.dp6 = dp6;
	}

	public String getEntePrevidenziale() {
		return entePrevidenziale;
	}

	public void setEntePrevidenziale(String entePrevidenziale) {
		this.entePrevidenziale = entePrevidenziale;
	}

	public String getCodiceAzienda() {
		return codiceAzienda;
	}

	public void setCodiceAzienda(String codiceAzienda) {
		this.codiceAzienda = codiceAzienda;
	}

	public String getCategoriaLavoro() {
		return categoriaLavoro;
	}

	public void setCategoriaLavoro(String categoriaLavoro) {
		this.categoriaLavoro = categoriaLavoro;
	}

	public String getImponibilePrevidenzialeDp6() {
		return imponibilePrevidenzialeDp6;
	}

	public void setImponibilePrevidenzialeDp6(String imponibilePrevidenzialeDp6) {
		this.imponibilePrevidenzialeDp6 = imponibilePrevidenzialeDp6;
	}

	public String getContributiDovutiDp6() {
		return contributiDovutiDp6;
	}

	public void setContributiDovutiDp6(String contributiDovutiDp6) {
		this.contributiDovutiDp6 = contributiDovutiDp6;
	}

	public String getContributiACaricoDelLavoratoreTrattenuti() {
		return contributiACaricoDelLavoratoreTrattenuti;
	}

	public void setContributiACaricoDelLavoratoreTrattenuti(String contributiACaricoDelLavoratoreTrattenuti) {
		this.contributiACaricoDelLavoratoreTrattenuti = contributiACaricoDelLavoratoreTrattenuti;
	}

	public String getContributiVersatiDp6() {
		return contributiVersatiDp6;
	}

	public void setContributiVersatiDp6(String contributiVersatiDp6) {
		this.contributiVersatiDp6 = contributiVersatiDp6;
	}

	public String getSpazio23() {
		return spazio23;
	}

	public void setSpazio23(String spazio23) {
		this.spazio23 = spazio23;
	}

	public String getCl1() {
		return cl1;
	}

	public void setCl1(String cl1) {
		this.cl1 = cl1;
	}

	public String getTipologiaReddituale() {
		return tipologiaReddituale;
	}

	public void setTipologiaReddituale(String tipologiaReddituale) {
		this.tipologiaReddituale = tipologiaReddituale;
	}

	public String getSpazio24() {
		return spazio24;
	}

	public void setSpazio24(String spazio24) {
		this.spazio24 = spazio24;
	}

	public String getCl2() {
		return cl2;
	}

	public void setCl2(String cl2) {
		this.cl2 = cl2;
	}

	public String getLordoCorrisposto() {
		return lordoCorrisposto;
	}

	public void setLordoCorrisposto(String lordoCorrisposto) {
		this.lordoCorrisposto = lordoCorrisposto;
	}

	public String getImponibile() {
		return imponibile;
	}

	public void setImponibile(String imponibile) {
		this.imponibile = imponibile;
	}

	public String getRitenuteATitoloDiAcconto() {
		return ritenuteATitoloDiAcconto;
	}

	public void setRitenuteATitoloDiAcconto(String ritenuteATitoloDiAcconto) {
		this.ritenuteATitoloDiAcconto = ritenuteATitoloDiAcconto;
	}

	public String getSpazio25() {
		return spazio25;
	}

	public void setSpazio25(String spazio25) {
		this.spazio25 = spazio25;
	}

	public String getPg1() {
		return pg1;
	}

	public void setPg1(String pg1) {
		this.pg1 = pg1;
	}

	public String getCodiceFiscaleDebitorePg1() {
		return codiceFiscaleDebitorePg1;
	}

	public void setCodiceFiscaleDebitorePg1(String codiceFiscaleDebitorePg1) {
		this.codiceFiscaleDebitorePg1 = codiceFiscaleDebitorePg1;
	}

	public String getSommeErogatePg1() {
		return sommeErogatePg1;
	}

	public void setSommeErogatePg1(String sommeErogatePg1) {
		this.sommeErogatePg1 = sommeErogatePg1;
	}

	public String getRitenuteOperatePg1() {
		return ritenuteOperatePg1;
	}

	public void setRitenuteOperatePg1(String ritenuteOperatePg1) {
		this.ritenuteOperatePg1 = ritenuteOperatePg1;
	}

	public String getSommeErogateNonTassatePg1() {
		return sommeErogateNonTassatePg1;
	}

	public void setSommeErogateNonTassatePg1(String sommeErogateNonTassatePg1) {
		this.sommeErogateNonTassatePg1 = sommeErogateNonTassatePg1;
	}

	public String getSpazio26() {
		return spazio26;
	}

	public void setSpazio26(String spazio26) {
		this.spazio26 = spazio26;
	}

	public String getPg2() {
		return pg2;
	}

	public void setPg2(String pg2) {
		this.pg2 = pg2;
	}

	public String getCodiceFiscaleDebitorePg2() {
		return codiceFiscaleDebitorePg2;
	}

	public void setCodiceFiscaleDebitorePg2(String codiceFiscaleDebitorePg2) {
		this.codiceFiscaleDebitorePg2 = codiceFiscaleDebitorePg2;
	}

	public String getSommeErogatePg2() {
		return sommeErogatePg2;
	}

	public void setSommeErogatePg2(String sommeErogatePg2) {
		this.sommeErogatePg2 = sommeErogatePg2;
	}

	public String getRitenuteOperatePg2() {
		return ritenuteOperatePg2;
	}

	public void setRitenuteOperatePg2(String ritenuteOperatePg2) {
		this.ritenuteOperatePg2 = ritenuteOperatePg2;
	}

	public String getSommeErogateNonTassatePg2() {
		return sommeErogateNonTassatePg2;
	}

	public void setSommeErogateNonTassatePg2(String sommeErogateNonTassatePg2) {
		this.sommeErogateNonTassatePg2 = sommeErogateNonTassatePg2;
	}

	public String getSpazio27() {
		return spazio27;
	}

	public void setSpazio27(String spazio27) {
		this.spazio27 = spazio27;
	}

	public String getFi0() {
		return fi0;
	}

	public void setFi0(String fi0) {
		this.fi0 = fi0;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getFirma() {
		return firma;
	}

	public void setFirma(String firma) {
		this.firma = firma;
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
