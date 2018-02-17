###################################################################################################
# AUTORE     : 
# DATA       : 2015/07
# VERSIONE   : 1.1
# OBIETTIVO  :
# DESCRIZIONE: 
#
###################################################################################################

. tools.sh

# LOG="/DepconConverterBatch.log"

# Inizio routine Usage =========================================================
Usage()
{
	#" [-i idpostemissione]
  echo -e "usage: ${SHELL_NAME} [-h]
       -h               Eseguire questo script per elaborare tutte le postemissioni nello stato 11 o 903"
#       -i idpostemissione          id postemissione"

  exit 0;

       
}
# =============================================================================


Elaborazione()
{ 
  param=" 
	carica.artefatti.oracle=false 
	input.dir=$POSTEMISSIONE_HOME/postemissione_file/cedolinoxml/elaborati 
	file.lavorati.dir=$POSTEMISSIONE_HOME/postemissione_file/cedolinoxml/caricatiportale 
	land.dir=$POSTEMISSIONE_HOME/postemissione_file/land/daelaborare 
	filePDF.dir=../MEFAS/CURRENT 
	time=$(date +"%s")" #PARAMETRI_CMD
	
  #UNA SOLA ESECUZIONE DATO L'ID
  #nohup $JAVA_POSTEMISSIONE_HOME/bin/java -Xmx1024m -cp $POSTEMISSIONE_HOME/postemissione/batch/jar/PE_XmlLoaderBatch.jar org.springframework.batch.core.launch.support.CommandLineJobRunner PE_XmlLoaderBatchJob.xml PE_XmlLoaderBatchJob ${param} &
 
  #ESEGUE UN JOB PER OGNI POSTEMISSIONE DISPONIBILE
  nohup $JAVA_POSTEMISSIONE_HOME/bin/java -Xmx1024m -cp $POSTEMISSIONE_HOME/postemissione/batch/jar/PE_XmlLoaderBatch.jar org.springframework.batch.core.launch.support.CommandLineJobRunner PE_XmlLoaderBatchJob.xml launcherBatchJobCedLoader ${param} >> ${LOGFILE} &
}

# =============================================================================

# Inizio routine Controlli =====================================================
Controlli()
{
  #verifica presenza parametro idpostemissione
  if 
  [ ${#idpostemissione} -eq 0 ];
   then
      Err "parametri non correttamente valorizzati"
      Usage
  fi

}
# Fine routine Controlli =======================================================


# ==============================================================================

while [ -n "$1" ]
do
  case "$1" in
        -h) Usage;;
#        -i) idpostemissione=${2}; shift;;
        --) shift; break;;
         *) Usage;;
  esac
  shift
done

#Controlli
Elaborazione
#
# FINE SHELL
#