package it.gov.mef.noipa.postemissione.pe_depconconverterbatch.batch.cu;

import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.core.io.Resource;

import it.gov.mef.noipa.postemissione.parser.autogenerated.cu.cu.Cedolini;
import it.gov.mef.noipa.postemissione.pe_depconconverterbatch.bean.OrigineDati;
import it.gov.mef.noipa.postemissione.pe_depconconverterbatch.bean.cu.CudAnnotazione;
import it.gov.mef.noipa.postemissione.pe_depconconverterbatch.bean.cu.CudPrimaPagina;
import it.gov.mef.noipa.postemissione.pe_depconconverterbatch.bean.cu.CudSecondaPagina;
import it.gov.mef.noipa.postemissione.pe_depconconverterbatch.bean.cu.CudSecondaPaginaWrapper;
import it.gov.mef.noipa.postemissione.pe_depconconverterbatch.bean.cu.DepconCudWrapper;

public class Processor implements ItemProcessor<DepconCudWrapper, Cedolini.Cu> {

	private static final String CU = "CU";
	private static final String CRE = "CRE";
	private static final String ERE = "ERE";
	private static final String DIP = "DIP";
	private static final String CREDITORE = "creditore";
	private static final String EREDE = "erede";
	private static final String DIPENDENTE = "dipendente";

	private static final Logger logger = Logger.getLogger(Processor.class);
	
	private Resource resource;
	private Map<String, OrigineDati> origineDatiMap;
	
	public Cedolini.Cu process(DepconCudWrapper depconCudWrapper) throws Exception {
		
		Cedolini.Cu cud = new Cedolini.Cu();
		CudPrimaPagina primaPagina = depconCudWrapper.getCudPrimaPagina() ;
	
		cud.setLINGUA("i"); // TODO DA GESTIRE DINAMICAMENTE , RICAVANDO PER OGNI CU LA LINGUA ITA("i") - GER("t")
		cud.setAREA(CU);
		cud.setSOTTOAREA(getSottoAreaByTipologiaCU(resource));
		cud.setISCRIZIONE(primaPagina.getIscrizione());
		cud.setUFFICIORESPONSABILE(primaPagina.getUffResp().trim());
		cud.setUFFICIOSERVIZIO(primaPagina.getBrcCodiUffi().trim());
		cud.setCODICEFISCALE(primaPagina.getCodiceFiscale().trim());
		cud.setVERSIONE(primaPagina.getBrcVersione().trim());
		
		cud.setBARCODE(primaPagina.getBrcCodiceDpt()+primaPagina.getBrcTipo()+primaPagina.getBrcRata()+primaPagina.getBrcAnno()+primaPagina.getBrcTipoEmis()
		+primaPagina.getBrcIscrizione()+primaPagina.getSt()+primaPagina.getSpazio40()+primaPagina.getBrcCodiEnte()+primaPagina.getSpazio41()
		+primaPagina.getBrcCodiUffi()+primaPagina.getSpazio42()+primaPagina.getBrcVersione()+primaPagina.getBrcFlagCessati());
		
		cud.setDATORELAV1(primaPagina.getCodFisSosImposta().trim());
		cud.setDATORELAV2(primaPagina.getDescDpt().trim());
		cud.setDATORELAV49(primaPagina.getIndirizzoSosImposta().trim());
		
		// sezione A dipendente/pensionato/altro percettore somme
		cud.setA1(primaPagina.getCodiceFiscale().trim());
		cud.setA2(primaPagina.getCognome().trim());
		cud.setA3(primaPagina.getNome().trim());
		cud.setA4(primaPagina.getSesso().trim());
		
		logger.debug("process getDataNascita["+primaPagina.getDataNascita()+"] ");
		logger.debug("process setA5G["+primaPagina.getDataNascita().substring(0, 2)+"] ");
		logger.debug("process setA5M["+primaPagina.getDataNascita().substring(3, 5)+"] ");
		logger.debug("process setA5A["+primaPagina.getDataNascita().substring(6, 10)+"] ");
		
		cud.setA5G(new BigInteger(primaPagina.getDataNascita().substring(0, 2)));
		cud.setA5M(new BigInteger(primaPagina.getDataNascita().substring(3, 5)));
		cud.setA5A(new BigInteger(primaPagina.getDataNascita().substring(6, 10)));
		
		cud.setA6(primaPagina.getComuneNascita().trim());
		cud.setA7(primaPagina.getProvinciaNascita().trim());
		cud.setA8(""); //TODO primaPagina DG5 CATEGORIE PARTICOLARI (2) in attesa del file di test
		cud.setA9(primaPagina.getEventiEccezionali().trim());
		cud.setA10(primaPagina.getCasiDiEsclusione().trim());
		cud.setA2022(primaPagina.getComuneResidenaAnnoDichiarazione().trim()); 
		cud.setA23(""); //TODO primaPagina DG6 FUSIONE COMUNI 2017 (4) in attesa del file di test
		cud.setA2426(primaPagina.getComuneFiscaleResidenzaAnnoRedditi().trim()); 
		cud.setA27(""); //TODO primaPagina DG6 FUSIONE COMUNI 2018(4) in attesa del file di test
		cud.setA41(""); //TODO primaPagina DG7 nuovo record in attesa del file di test 
		cud.setA42(""); //TODO primaPagina DG7 nuovo record in attesa del file di test
		cud.setA44(""); //TODO primaPagina DG7 nuovo record in attesa del file di test
		
		cud.setB1(primaPagina.getRedditoTotTempoIndeterminato().trim());
		cud.setB2(primaPagina.getRedditoTotTempoDeterminato().trim());
		cud.setB4(primaPagina.getAltriRedditiAssimiliati().trim());
		cud.setB5(primaPagina.getAssegniConiuge().trim());
		cud.setB6(primaPagina.getGiorni().trim());
		
		cud.setB21(primaPagina.getRitenuteTotaliIrpef().trim());
		cud.setB22(primaPagina.getAddizionaleRegionaleDovuta().trim());
		cud.setB26(primaPagina.getAddizionaleComunalePagata().trim());
		cud.setB27(primaPagina.getAddizionaleComunaleDovuta().trim());
		cud.setB29(primaPagina.getAccontoAddizionaleComunalePagata().trim());
		cud.setB30(primaPagina.getRitenuteSospeseIrpef().trim());
		
		cud.setB121(primaPagina.getPrimoAccontoIrpefDichiarato().trim());
		cud.setB122(primaPagina.getSecondoAccontoIrpef().trim());
		cud.setB124(primaPagina.getAccontoAddizionaleComunale().trim());
		cud.setB126(primaPagina.getPrimoAccontoCedolareSecca().trim());
		cud.setB127(primaPagina.getAccontoAddizionaleComunaleSospeso().trim());
		cud.setB131(primaPagina.getPrimoAccontoIrpefConiuge().trim());
		cud.setB132(primaPagina.getPrimoAccontoIrpefDichiarato().trim());
				
		cud.setB321(primaPagina.getPrimoAccontoIrpefConiuge().trim());
		cud.setB322(primaPagina.getSecondoAccontoIrpefConiuge().trim());
		cud.setB324(primaPagina.getAccontoAddizionaleComunaleConiuge().trim());
		cud.setB326(primaPagina.getPrimoAccontoCedolareSeccaConiuge().trim());
		cud.setB327(primaPagina.getCodiceOnere().trim());
		cud.setB331(primaPagina.getAccontiIrpefSospesiConiuge().trim());
		cud.setB332(primaPagina.getAccontoAddizionaleComunaleSospesoConiuge().trim());
		
		cud.setB341(primaPagina.getImportoOnere().trim());
		cud.setB342(primaPagina.getPrimoAccontoIrpefDichiarato().trim());
		cud.setB361(primaPagina.getImpostaLorda().trim());
		cud.setB362(primaPagina.getDetrazioneFamigliaACarico().trim());
		cud.setB363(primaPagina.getDetrazioneFamiglieNumerose().trim());
		cud.setB365(primaPagina.getCreditoNonRiconosciutoFamiglieNumerose().trim());
		cud.setB367(primaPagina.getDetrazioneLavoroDipendentePensioneRedditi().trim());
		cud.setB368(primaPagina.getTotaleDetrazioniOneri().trim());
		cud.setB369(primaPagina.getDetrazioneCanoniLocazione().trim());
		
		cud.setB371(primaPagina.getCreditoNonRiconosciutoCanoneLocazione().trim());
		cud.setB373(primaPagina.getTotaleDetrazioni().trim());
			
		cud.setB391(primaPagina.getCodiceBonus().trim());
		cud.setB392(primaPagina.getBonusErogato().trim());
		cud.setB393(primaPagina.getBonusNonErogato().trim());
		
		// valorizzazione N istanze di NFAMCARICO 1 per ogni occorrenza di CudSecondaPagina presa dalla mappa mappaCuSecondaPagina
		LinkedHashMap<Integer, CudSecondaPaginaWrapper> mappaCuSecondaPagina = depconCudWrapper.getMappaCuSecondaPaginaWrapper();
		
		for (Map.Entry<Integer, CudSecondaPaginaWrapper> entry : mappaCuSecondaPagina.entrySet()) {
			
			Cedolini.Cu.NFAMCARICO tmpFamCarico = new Cedolini.Cu.NFAMCARICO();
			
			CudSecondaPaginaWrapper cudSecondaPaginaWrapper = (CudSecondaPaginaWrapper) entry.getValue();
			
			CudSecondaPagina secondaPagina = cudSecondaPaginaWrapper.getCudSecondaPagina();
			
			tmpFamCarico.setB411(primaPagina.getPrevidenzaComplementare().trim());
			tmpFamCarico.setB413(primaPagina.getContributiNonDedottiDaiRedditi().trim());
			tmpFamCarico.setB412(primaPagina.getContributiPrevidenzaDedottiDaiRedditi().trim());
			tmpFamCarico.setB414(primaPagina.getTfrPerFondo().trim());
			tmpFamCarico.setB431(primaPagina.getOneriEsclusi().trim());
			tmpFamCarico.setB441(primaPagina.getContributiVersati().trim());
			tmpFamCarico.setB432(primaPagina.getDfnCodiceOnere1().trim());
			tmpFamCarico.setB433(primaPagina.getDfnImportoOnere1().trim());
			tmpFamCarico.setB434(primaPagina.getDfnCodiceOnere2().trim());
			tmpFamCarico.setB435(primaPagina.getDfnImportoOnere2().trim());
			tmpFamCarico.setB436(primaPagina.getDfnCodiceOnere3().trim());
			tmpFamCarico.setB437(primaPagina.getDfnImportoOnere3().trim());
			tmpFamCarico.setB444(primaPagina.getAssicurazioniSanitarie().trim());
			tmpFamCarico.setB457(primaPagina.getImponibileTempoIndeterminato().trim());
			tmpFamCarico.setB458(primaPagina.getImponibileTempoDdeterminato().trim());
			tmpFamCarico.setB473(primaPagina.getIrpefDaTrattenerDopo28Febbrario().trim());
			tmpFamCarico.setB476(primaPagina.getApplicazioneMaggioreRitenuta().trim());
			tmpFamCarico.setB466(primaPagina.getCodiceRedditiEsenti().trim());
			tmpFamCarico.setB467(primaPagina.getImportoRedditiEsenti().trim());
			tmpFamCarico.setB475(primaPagina.getIrpefDaVersareErario().trim());
			tmpFamCarico.setB477(primaPagina.getCasiParticolari().trim());
			tmpFamCarico.setB468(primaPagina.getCodiceRedditiEsenti().trim());
			tmpFamCarico.setB469(primaPagina.getImportoRedditiEsenti().trim());
			tmpFamCarico.setB481(""); //TODO primaPagina REE nuovo record in attesa del file di test
			tmpFamCarico.setB482(""); //TODO primaPagina REE nuovo record in attesa del file di test
			
			tmpFamCarico.setB511(primaPagina.getTotaleCompensiArretratiDetraibili().trim());
			tmpFamCarico.setB513(primaPagina.getTotaleRitenuteOperate().trim());
			tmpFamCarico.setB514(primaPagina.getTotaleRitenuteSospese().trim());
			
			// DC1 coniuge
			tmpFamCarico.setB611(secondaPagina.getFlagConiuge().trim());
			tmpFamCarico.setB641(secondaPagina.getCfConiuge().trim());
			tmpFamCarico.setB651(secondaPagina.getMessiACaricoConiuge().trim());

			// DC2 primo figlio
			tmpFamCarico.setB612(secondaPagina.getFlagFiglioDc2().trim());
			tmpFamCarico.setB632(secondaPagina.getFlagDisabileDc2().trim());
			tmpFamCarico.setB642(secondaPagina.getCfFiglio().trim());
			tmpFamCarico.setB652(secondaPagina.getMesiACaricoFiglio().trim());
			tmpFamCarico.setB662(secondaPagina.getMinoredi3AnniDc2().trim());
			tmpFamCarico.setB672(secondaPagina.getPercentualeDetrazioneSpettanteDc2().trim());
			tmpFamCarico.setB682(""); //TODO secondaPagina DC2 DETRAZIONE 100% FIGLI(1) attesa del file di test
			
			// DC3 secondo figlio
			tmpFamCarico.setB613(secondaPagina.getFlagFiglioDc3().trim());
			tmpFamCarico.setB623(secondaPagina.getFlagAltroFamiliareDc3().trim());
			tmpFamCarico.setB633(secondaPagina.getFlagDisabileDc3().trim());
			tmpFamCarico.setB643(secondaPagina.getCfFiglioOFamiliareDc3().trim());
			tmpFamCarico.setB653(secondaPagina.getMesiACaricoFiglioDc3().trim());
			tmpFamCarico.setB663(secondaPagina.getMinoreADi3AnniDc3().trim());
			tmpFamCarico.setB673(secondaPagina.getPercentualeDetrazioneSpettanteDc3().trim());
			tmpFamCarico.setB683(""); //TODO secondaPagina DC3 DETRAZIONE 100% FIGLI(1) attesa del file di test

			// DC4 terzo figlio
			tmpFamCarico.setB614(secondaPagina.getFlagFiglioDc4().trim());
			tmpFamCarico.setB624(secondaPagina.getFlagAltroFamiliareDc4().trim());
			tmpFamCarico.setB634(secondaPagina.getFlagDisabileDc4().trim());
			tmpFamCarico.setB644(secondaPagina.getCfFiglioOFamiliareDc4().trim());
			tmpFamCarico.setB654(secondaPagina.getMesiACaricoFiglioDc4().trim());
			tmpFamCarico.setB664(secondaPagina.getMinoreADi3AnniDc4().trim());
			tmpFamCarico.setB674(secondaPagina.getPercentualeDetrazioneSpettanteDc4().trim());
			tmpFamCarico.setB684(""); //TODO secondaPagina DC4 DETRAZIONE 100% FIGLI(1) attesa del file di test
			
			// DC5 quarto figlio
			tmpFamCarico.setB615(secondaPagina.getFlagFiglioDc5().trim());
			tmpFamCarico.setB625(secondaPagina.getFlagAltroFamiliareDc5().trim());
			tmpFamCarico.setB635(secondaPagina.getFlagDisabileDc5().trim());
			tmpFamCarico.setB645(secondaPagina.getCfFiglioOFamiliareDc5().trim());
			tmpFamCarico.setB655(secondaPagina.getMesiACaricoFiglioDc5().trim());
			tmpFamCarico.setB665(secondaPagina.getMinoreADi3AnniDc5().trim());
			tmpFamCarico.setB675(secondaPagina.getPercentualeDetrazioneSpettanteDc5().trim());
			tmpFamCarico.setB685(""); //TODO secondaPagina DC5 DETRAZIONE 100% FIGLI(1) attesa del file di test

			// DC6 quinto figlio
			tmpFamCarico.setB616(secondaPagina.getFlagFiglioDc6().trim());
			tmpFamCarico.setB626(secondaPagina.getFlagAltroFamiliareDc6().trim());
			tmpFamCarico.setB636(secondaPagina.getFlagDisabileDc6().trim());
			tmpFamCarico.setB646(secondaPagina.getCfFiglioOFamiliareDc6().trim());
			tmpFamCarico.setB656(secondaPagina.getMesiACaricoFiglioDc6().trim());
			tmpFamCarico.setB666(secondaPagina.getMinoreADi3AnniDc6().trim());
			tmpFamCarico.setB676(secondaPagina.getPercentualeDetrazioneSpettanteDc6().trim());
			tmpFamCarico.setB686(""); //TODO secondaPagina DC6 DETRAZIONE 100% FIGLI(1) attesa del file di test
			
			// DC7 sesto figlio
			tmpFamCarico.setB617(secondaPagina.getFlagFiglioDc7().trim());
			tmpFamCarico.setB627(secondaPagina.getFlagAltroFamiliareDc7().trim());
			tmpFamCarico.setB637(secondaPagina.getFlagDisabileDc7().trim());
			tmpFamCarico.setB647(secondaPagina.getCfFiglioOFamiliareDc7().trim());
			tmpFamCarico.setB657(secondaPagina.getMesiACaricoFiglioDc7().trim());
			tmpFamCarico.setB667(secondaPagina.getMinoreADi3AnniDc7().trim());
			tmpFamCarico.setB677(secondaPagina.getPercentualeDetrazioneSpettanteDc7().trim());
			tmpFamCarico.setB687(""); //TODO secondaPagina DC7 DETRAZIONE 100% FIGLI(1) attesa del file di test

			// DC8 settimo figlio
			tmpFamCarico.setB618(secondaPagina.getFlagFiglioDc8().trim());
			tmpFamCarico.setB628(secondaPagina.getFlagAltroFamiliareDc8().trim());
			tmpFamCarico.setB638(secondaPagina.getFlagDisabileDc8().trim());
			tmpFamCarico.setB648(secondaPagina.getCfFiglioOFamiliareDc8().trim());
			tmpFamCarico.setB658(secondaPagina.getMesiACaricoFiglioDc8().trim());
			tmpFamCarico.setB668(secondaPagina.getMinoreADi3AnniDc8().trim());
			tmpFamCarico.setB678(secondaPagina.getPercentualeDetrazioneSpettanteDc8().trim());
			tmpFamCarico.setB688(""); //TODO secondaPagina DC8 DETRAZIONE 100% FIGLI(1) attesa del file di test

			// DC9 ottavo figlio
			tmpFamCarico.setB619(secondaPagina.getFlagFiglioDc9().trim());
			tmpFamCarico.setB629(secondaPagina.getFlagAltroFamiliareDc9().trim());
			tmpFamCarico.setB639(secondaPagina.getFlagDisabileDc9().trim());
			tmpFamCarico.setB649(secondaPagina.getCfFiglioOFamiliareDc9().trim());
			tmpFamCarico.setB659(secondaPagina.getMesiACaricoFiglioDc9().trim());
			tmpFamCarico.setB669(secondaPagina.getMinoreADi3AnniDc9().trim());
			tmpFamCarico.setB679(secondaPagina.getPercentualeDetrazioneSpettanteDc9().trim());
			tmpFamCarico.setB689(""); //TODO secondaPagina DC9 DETRAZIONE 100% FIGLI(1) attesa del file di test
			
			tmpFamCarico.setB710(secondaPagina.getPercentualeSpettanteFamiglieNumerose().trim());
			tmpFamCarico.setB801(secondaPagina.getIndennitaAccontiAnnoCorrente().trim());
			tmpFamCarico.setB804(secondaPagina.getRitenutaAnnoCorrente().trim());
			tmpFamCarico.setB810(secondaPagina.getTfrMaturatoInAziendaDal2001().trim());
			tmpFamCarico.setB802(secondaPagina.getAccontoAnnoPrecedente().trim());
			tmpFamCarico.setB806(secondaPagina.getRitenuteAnnoPrecedente().trim());
			tmpFamCarico.setB811(secondaPagina.getTfrMaturatoFinoAl200AlFondo().trim());
			tmpFamCarico.setB803(secondaPagina.getDetrazione().trim());
			tmpFamCarico.setB809(secondaPagina.getTfrMaturatoInAziendaFinoA2000().trim());
			tmpFamCarico.setB920(secondaPagina.getImpostaSostitutivaRivalutazioniTfr().trim());
			 
			tmpFamCarico.setC1(secondaPagina.getMatricolaAzienda().trim());
			tmpFamCarico.setC2(secondaPagina.getInps().trim());
			tmpFamCarico.setC3(secondaPagina.getAltro().trim());
			tmpFamCarico.setC4(secondaPagina.getImponibilePrevidenziale().trim());
			tmpFamCarico.setC6(secondaPagina.getContributiACaricoDelLavoratore().trim());
			tmpFamCarico.setC7(secondaPagina.getFlagDenunciaUniEmensTuttiIMesi().trim());
			
			tmpFamCarico.setC801(secondaPagina.getMeseSenzaDenunciaUniEmens01Dp2().trim());
			tmpFamCarico.setC802(secondaPagina.getMeseSenzaDenunciaUniEmens02Dp2().trim());
			tmpFamCarico.setC803(secondaPagina.getMeseSenzaDenunciaUniEmens03Dp2().trim());
			tmpFamCarico.setC804(secondaPagina.getMeseSenzaDenunciaUniEmens04Dp2().trim());
			tmpFamCarico.setC805(secondaPagina.getMeseSenzaDenunciaUniEmens05Dp2().trim());
			tmpFamCarico.setC806(secondaPagina.getMeseSenzaDenunciaUniEmens06Dp2().trim());
			tmpFamCarico.setC807(secondaPagina.getMeseSenzaDenunciaUniEmens07Dp2().trim());
			tmpFamCarico.setC808(secondaPagina.getMeseSenzaDenunciaUniEmens08Dp2().trim());
			tmpFamCarico.setC809(secondaPagina.getMeseSenzaDenunciaUniEmens09Dp2().trim());
			tmpFamCarico.setC810(secondaPagina.getMeseSenzaDenunciaUniEmens10Dp2().trim());
			tmpFamCarico.setC811(secondaPagina.getMeseSenzaDenunciaUniEmens11Dp2().trim());
			tmpFamCarico.setC812(secondaPagina.getMeseSenzaDenunciaUniEmens12Dp2().trim());
			
			tmpFamCarico.setC9(secondaPagina.getCodiceFiscaleAzienda().trim());
			tmpFamCarico.setC11(secondaPagina.getCodiceMef().trim());
			tmpFamCarico.setC12(secondaPagina.getCassaPensione().trim());
			tmpFamCarico.setC13(secondaPagina.getCassaPrev().trim());
			tmpFamCarico.setC14(secondaPagina.getCassaCred().trim());
			tmpFamCarico.setC15(secondaPagina.getCassaEnpDep().trim());
			tmpFamCarico.setC17(secondaPagina.getAnnoRiferimento().trim());
			tmpFamCarico.setC18(secondaPagina.getImponibilePensionistico().trim());
			tmpFamCarico.setC19(secondaPagina.getContributiDovutiDp4().trim());
			tmpFamCarico.setC21(secondaPagina.getImponibileTfs().trim());
			tmpFamCarico.setC22(secondaPagina.getContributiTfs().trim());
			tmpFamCarico.setC24(secondaPagina.getImponibileTfr().trim());
			tmpFamCarico.setC25(secondaPagina.getContributiTfrDovuti().trim());
			tmpFamCarico.setC26(secondaPagina.getImponibileGestioneCredito().trim());
			tmpFamCarico.setC27(secondaPagina.getContributiGestioneCreditoDovuti().trim());
			tmpFamCarico.setC29(secondaPagina.getImponibileEnpDep().trim());
			tmpFamCarico.setC30(secondaPagina.getContributiEnpDepDovuti().trim());
			
			
			cud.getNFAMCARICO().add(tmpFamCarico);
			
		}
		// valorizzazione N istanze di NFAMCARICO 1 per ogni occorrenza di CudSecondaPagina presa dalla mappa mappaCuSecondaPagina
		
		// questo ciclo per ora deve avere una sola iterazione , prendendo solo la prima occorrenza di seconda pagina
		// al momento l'xsd non gestisce per i tag da daN01aF02 la corrispondenza con la struttura repetable , ma li prevede fuori , una sola volta
		for (Map.Entry<Integer, CudSecondaPaginaWrapper> entry : mappaCuSecondaPagina.entrySet()) {
		
			//TODO da modificare per ora ricerca della prima occorrenza di CudSecondaPagina
			int numOccSecondaPagina = 1;
			
			CudSecondaPaginaWrapper cudSecondaPaginaWrapper = (CudSecondaPaginaWrapper) entry.getValue();
		
			// set xml tag daN01aN14
			int annotationPosition = 1 ;
			for (Map.Entry<Integer, CudAnnotazione> entryAnnotazione : cudSecondaPaginaWrapper.getMappaAnnotazioniCud().entrySet()) {
				CudAnnotazione cudAnnotazione = entryAnnotazione.getValue();
				setXmlAnnotation(cud, cudAnnotazione, annotationPosition);
				annotationPosition++;
			}
			// set xml tag daN01aN14
			
			CudSecondaPagina secondaPagina = cudSecondaPaginaWrapper.getCudSecondaPagina();
			
			cud.setC41(secondaPagina.getCompensiAlParasubordinato().trim()); 
			cud.setC42(secondaPagina.getContributiDovuti().trim()); 
			cud.setC43(secondaPagina.getContributiACaricoDelLavoratoreDp3().trim());
			cud.setC44(secondaPagina.getContributiVersati().trim());
			cud.setC45(secondaPagina.getFlagDenunciaUniEmensTuttiIMesiDp3().trim());
			
			cud.setC4601(secondaPagina.getMeseSenzaDenunciaUniEmens01Dp3().trim());
			cud.setC4602(secondaPagina.getMeseSenzaDenunciaUniEmens02Dp3().trim());
			cud.setC4603(secondaPagina.getMeseSenzaDenunciaUniEmens03Dp3().trim());
			cud.setC4604(secondaPagina.getMeseSenzaDenunciaUniEmens04Dp3().trim());
			cud.setC4605(secondaPagina.getMeseSenzaDenunciaUniEmens05Dp3().trim());
			cud.setC4606(secondaPagina.getMeseSenzaDenunciaUniEmens06Dp3().trim());
			cud.setC4607(secondaPagina.getMeseSenzaDenunciaUniEmens07Dp3().trim());
			cud.setC4608(secondaPagina.getMeseSenzaDenunciaUniEmens08Dp3().trim());
			cud.setC4609(secondaPagina.getMeseSenzaDenunciaUniEmens09Dp3().trim());
			cud.setC4610(secondaPagina.getMeseSenzaDenunciaUniEmens10Dp3().trim());
			cud.setC4611(secondaPagina.getMeseSenzaDenunciaUniEmens11Dp3().trim());
			cud.setC4612(secondaPagina.getMeseSenzaDenunciaUniEmens12Dp3().trim());
			
			cud.setC52(secondaPagina.getCodiceAzienda().trim());
			cud.setC53(secondaPagina.getCategoriaLavoro().trim());
			cud.setC54(secondaPagina.getImponibilePrevidenzialeDp6().trim());
			cud.setC55(secondaPagina.getContributiDovutiDp6().trim());
			cud.setC56(secondaPagina.getContributiACaricoDelLavoratoreTrattenuti().trim());
			cud.setC57(secondaPagina.getContributiVersatiDp6().trim());
			
			cud.setD1(secondaPagina.getTipologiaReddituale().trim());
			cud.setD4(secondaPagina.getLordoCorrisposto().trim());
			cud.setD8(secondaPagina.getImponibile().trim());
			cud.setD9(secondaPagina.getRitenuteATitoloDiAcconto().trim());
			cud.setD101(secondaPagina.getCodiceFiscaleDebitorePg1().trim());
			cud.setD102(secondaPagina.getSommeErogatePg1().trim());
			cud.setD103(secondaPagina.getRitenuteOperatePg1().trim());
			cud.setD104(secondaPagina.getSommeErogateNonTassatePg1().trim());
			cud.setD105(secondaPagina.getCodiceFiscaleDebitorePg2().trim());
			cud.setD106(secondaPagina.getSommeErogatePg2().trim());
			cud.setD107(secondaPagina.getRitenuteOperatePg2().trim());
			cud.setD108(secondaPagina.getSommeErogateNonTassatePg2().trim());
			cud.setF01(secondaPagina.getData().trim());
			cud.setF02(secondaPagina.getFirma().trim());
						
			if ( numOccSecondaPagina >= 1 )
				break;
			
		}
		// questo ciclo per ora deve avere una sola iterazione , prendendo solo la prima occorrenza di seconda pagina
		// al momento l'xsd non gestisce per i tag da daN01aF02 la corrispondenza con la struttura repetable , ma li prevede fuori , una sola volta
		
				
		return cud;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public void setOrigineDatiMap(Map<String, OrigineDati> origineDatiMap) {
		this.origineDatiMap = origineDatiMap;
	}
	
	private String getSottoAreaByTipologiaCU(Resource resource)
	{
		String fileName = resource.getFilename();
		logger.debug("getSottoAreaByTipologiaCU fileName ["+fileName+"]");
		
		if ( fileName.contains(DIP) ) return DIPENDENTE;
		if ( fileName.contains(ERE) ) return EREDE;
		if ( fileName.contains(CRE) ) return CREDITORE;
		
		return DIPENDENTE;
	}
	
	private void setXmlAnnotation (Cedolini.Cu cud,CudAnnotazione cudAnnotazione , int annotationPosition) {
	
		//cud.setdaN01aN14
		logger.debug("setXmlAnnotation annotationPosition["+annotationPosition+"] note["+cudAnnotazione.note+"]");
		switch (annotationPosition) {
		case 1:
			cud.setN01(cudAnnotazione.note);
			break;
		case 2:
			cud.setN02(cudAnnotazione.note);
			break;
		case 3:
			cud.setN03(cudAnnotazione.note);
			break;
		case 4:
			cud.setN04(cudAnnotazione.note);
			break;
		case 5:
			cud.setN05(cudAnnotazione.note);
			break;
		case 6:
			cud.setN06(cudAnnotazione.note);
			break;
		case 7:
			cud.setN07(cudAnnotazione.note);
			break;
		case 8:
			cud.setN08(cudAnnotazione.note);
			break;
		case 9:
			cud.setN09(cudAnnotazione.note);
			break;
		case 10:
			cud.setN10(cudAnnotazione.note);
			break;
		case 11:
			cud.setN11(cudAnnotazione.note);
			break;
		case 12:
			cud.setN12(cudAnnotazione.note);
			break;
		case 13:
			cud.setN13(cudAnnotazione.note);
			break;
		case 14:
			cud.setN14(cudAnnotazione.note);
			break;

		default:
			break;
		}
	}
}
