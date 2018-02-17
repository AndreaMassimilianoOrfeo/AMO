package it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch;

import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.servicefacade.ServiceFacadeJDBC;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

public class LauncherCedLoader implements Tasklet {

	public static Job job;
	public static JobLauncher jobLauncher;

	private String idPostemissione;
	private String caricaArtefattiOracle;
	private String tipoPostemissione;
	private String inputDir;
	private String fileLavoratiDir;
	private String landDir;
	private String filePDFdir;
	private String time;

	private static final Logger LOGGER = Logger.getLogger(LauncherCedLoader.class);

	@Autowired
	private ServiceFacadeJDBC serviceFacadeJDBC;

	public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception {

		LOGGER.info("Inizio classe LauncherCedLoader");

		List<String> idPostemissioneList = new ArrayList<String>();

		idPostemissioneList = serviceFacadeJDBC.getPostemissioniElaborate();

		LOGGER.info("Inizio elaborazione postemissioni: " + idPostemissioneList);

		for (String idPostemissione : idPostemissioneList) {

			JobParametersBuilder builder = new JobParametersBuilder();
			builder.addString("id.postemissione", idPostemissione);
			builder.addString("carica.artefatti.oracle", caricaArtefattiOracle);
			builder.addString("tipo.postemissione", tipoPostemissione);
			builder.addString("input.dir", inputDir);
			builder.addString("file.lavorati.dir", fileLavoratiDir);
			builder.addString("land.dir", landDir);
			builder.addString("filePDF.dir", filePDFdir);

			builder.addString("time", new String("" + System.currentTimeMillis()));

			Launcher.jobLauncher.run(Launcher.job, builder.toJobParameters());
		}

		LOGGER.info("Fine - Elaborate postemissioni: " + idPostemissioneList);

		return RepeatStatus.FINISHED;
	}

	public static Job getJob() {
		return job;
	}

	public static void setJob(Job job) {
		Launcher.job = job;
	}

	public static JobLauncher getJobLauncher() {
		return jobLauncher;
	}

	public static void setJobLauncher(JobLauncher jobLauncher) {
		Launcher.jobLauncher = jobLauncher;
	}

	public String getIdPostemissione() {
		return idPostemissione;
	}

	public void setIdPostemissione(String idPostemissione) {
		this.idPostemissione = idPostemissione;
	}

	public String getCaricaArtefattiOracle() {
		return caricaArtefattiOracle;
	}

	public void setCaricaArtefattiOracle(String caricaArtefattiOracle) {
		this.caricaArtefattiOracle = caricaArtefattiOracle;
	}

	public String getTipoPostemissione() {
		return tipoPostemissione;
	}

	public void setTipoPostemissione(String tipoPostemissione) {
		this.tipoPostemissione = tipoPostemissione;
	}

	public String getInputDir() {
		return inputDir;
	}

	public void setInputDir(String inputDir) {
		this.inputDir = inputDir;
	}

	public String getFileLavoratiDir() {
		return fileLavoratiDir;
	}

	public void setFileLavoratiDir(String fileLavoratiDir) {
		this.fileLavoratiDir = fileLavoratiDir;
	}

	public String getLandDir() {
		return landDir;
	}

	public void setLandDir(String landDir) {
		this.landDir = landDir;
	}

	public String getFilePDFdir() {
		return filePDFdir;
	}

	public void setFilePDFdir(String filePDFdir) {
		this.landDir = filePDFdir;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
