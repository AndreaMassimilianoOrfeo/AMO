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
  echo -e "usage: ${SHELL_NAME} [-h] [-r rataemissione] [-p progemissione]
            Il batch legge nella cartella [POSTEMISSIONE_HOME]/postemissione_file/depcon/elaborati/[rataemissione]_[progremissione]
       -h               	Visualizza questo help
       -r rataemissione     Rata in lavorazione formato: 'YYYYMM'
       -p progremissione    Progressivo emissione
       -m modalita          Modalita batch, valori ammessi: ['cedolino' , 'cud']   DEFAULT:'cedolino'
       -v validaxml         flag per validare l'xml prodotto, valori ammessi: ['s', 'n']   DEFAULT:'s'"

       exit 0;

       
}
# =============================================================================


Elaborazione()
{
	export MODE=$mode
	mkdir $POSTEMISSIONE_HOME/postemissione_file/depcon/elaborati/${rataemissione}_${progremissione}
  
	param=" input.dir=$POSTEMISSIONE_HOME/postemissione_file/depcon/daelaborare/${rataemissione}_${progremissione} output.dir=$POSTEMISSIONE_HOME/postemissione_file/cedolinoxml/daelaborare bck.dir=$POSTEMISSIONE_HOME/postemissione_file/depcon/elaborati/${rataemissione}_${progremissione} rataemissione=$rataemissione progemissione=$progremissione flag.validarexml=$validaxml "
	
	nohup $JAVA_POSTEMISSIONE_HOME/bin/java -Xmx2048m -cp $POSTEMISSIONE_HOME/postemissione/batch/jar/PE_DepconConverterBatch.jar org.springframework.batch.core.launch.support.CommandLineJobRunner PE_DepconConverterBatchJob.xml PE_DepconConverterBatchJob ${param} >> ${LOGFILE} &

}

# =============================================================================

# Inizio routine Controlli =====================================================
Controlli()
{
  #PAR=1
  #verifica presenza parametro rataemissione e postemissione
  echo ${#rataemissione}  
  echo ${#progremissione}
  if 
  [ ${#rataemissione} -eq 0 -o ${#progremissione} -eq 0 ];
   then
      Err "parametri non correttamente valorizzati"
      Usage
  fi

}
# Fine routine Controlli =======================================================


# ==============================================================================

mode="cedolino"
validaxml="s"

while [ -n "$1" ]
do
  case "$1" in
        -h) Usage;;
        -r) rataemissione=${2}; shift;;
        -p) progremissione=${2}; shift;;
        -m) mode=${2}; shift;;
        -v) validaxml=${2}; shift;;
      --) shift; break;;
       *) Usage;;
  esac
  shift
done

Controlli
Elaborazione
#
# FINE SHELL
#
