###################################################################################################
# AUTORE     : Finsiel
# DATA       : 27/08/2005
# VERSIONE   : 1
# OBIETTIVO  :
# DESCRIZIONE: Tools.
###################################################################################################
# AUTORE     : Almaviva
# DATA       : 29 Ottobre 2008
# VERSIONE   : 2
# OBIETTIVO  :
# DESCRIZIONE: Inserita gestione dati per il cruscotto flussi.
# AUTORE     : Almaviva
# DATA       : 29 Ottobre 2008
###################################################################################################
# VERSIONE   : 3
# OBIETTIVO  :
# DESCRIZIONE: Eliminata gestione per cruscotto flussi. inserita in tools_flussi.sh
###################################################################################################

# Lettura variabili d'ambiente.
#. $HOME/vars
#. $HOME/pass

export SHELL_NAME=$(basename $0);
export DATA=$(date +'%Y%m%d%H%M%S')
export DataLog=$(date '+%d-%m-%Y, %H:%M:%S')
export PATHSH="$HOME/sh"
export PATHLOG="./log"
export LOGFILE="${PATHLOG}/${SHELL_NAME%.sh}-${DATA}-$$.log"
export PATHFILES="$HOME/elaborazioni/files"
export HIST_FILE="${PATHFILES}/cronologia"
export PATHSQL="$HOME/sql"
export PATHBIN="$HOME/bin"
export PATHDMP="$HOME/dmp"
export PATHJAR="$HOME/jar"
export ENV_WORK_DIR="$HOME/arrivati"
export ENV_SCARTI_DIR="$HOME/scarti"
export RIGA_COMM=$*

# Inizio routine VerifUnixErr ==================================================
# Parametri di input.
# 1) Diagnostico, obbligatorio; verrà visualizzato nel caso in cui il comando,
#  di cui si deve verificare l’esito, produca un errore. Il messaggio deve
#  essere costruito anteponendo uno dei seguenti prefissi:
#  - "[Log]", scrive a terminale e su file di log il diagnostico; non interrompe
#    l’elaborazione.
#  - "[Wrn]", scrive a terminale e su file di log il diagnostico; non interrompe
#    l’elaborazione.
#  - "[Err]", scrive a terminale e su file di log il diagnostico; interrompe
#    l’elaborazione.
#    Esempio di utilizzo:
#    VerifUnixErr "[Log] diagnostico"
VerifUnixErr()
{
 if test $? -ne 0; then
   case `echo "$1" | awk '{print substr($0,0,5)}'` in
     "[Log]")Log "`echo "$1" | awk '{print substr($0,7)}'`"
             ;;
     "[Wrn]")Wrn "`echo "$1" | awk '{print substr($0,7)}'`"
             ;;
     "[Err]")Err "`echo "$1" | awk '{print substr($0,7)}'`"
             ;;
           *)# Controllo validità parametri di input.
             PAR=100
             Err "Routine VerifUnixErr: tipologia di errore non valida."
             ########################################
             ;;
   esac
 fi
}
# Fine routine VerifUnixErr ====================================================

# Inizio routine VerifSqlErr ===================================================
# Parametri di input.
# 1) Flag stampa output, obbligatorio; può assumere i seguenti valori:
#  - "0", non stampa l'output della sessione sqlplus. Deve essere utilizzato
#    in presenza di interrogazioni del DB per valorizzare una o più variabili.
#  - "1", stampa l'output della sessione sqlplus sul video e nel file di log.
#    Deve essere utilizzato in presenza di esecuzioni di script, sia interni
#    sia esterni alla shell stessa, che prevedono l'invio di messaggi in output.
#  - "2", stampa l'output della sessione sqlplus nel file di log.
#    Può essere utilizzato in presenza di esecuzioni in background di script,
#    sia interni sia esterni alla shell stessa, che prevedono l'invio di
#    messaggi in output.
# 2) Codice Sql non bloccante, non obbligatorio; può assumere i seguenti valori:
#  - "un qualsiasi sqlcode", al verificarsi di un solo errore sql con codice
#    uguale a quello comunicato valorizza la variabile "Esito" a "-1" e continua
#    l'elaborazione. In tutti gli altri casi termina l'elaborazione. Può essere
#    utilizzata in presenza di esecuzioni di script, sia interni sia esterni alla
#    shell stessa, che potrebbero generare errori ininfluenti. Ad esempio la
#    drop di una tabella che restituisce un sqlcode "ORA-00942".
#    Esempio di utilizzo:
#    VerifSqlErr 0 "ORA-00942"
#  - "ALL|all", al verificarsi di un qualsiasi errore sql valorizza la variabile
#    "Esito" a "-1" e continua l'elaborazione. Può essere utilizzato come al
#    punto precedente.
#    Esempio di utilizzo:
#    VerifSqlErr 0 "ALL"
#  - Nessun parametro di input, in caso di errore termina l'elaborazione.
VerifSqlErr()
{
 SqlCodeNoBlocc="$2"

 # Controllo validità parametri di input.
 echo "$1" | grep -E "^0$|^1$|^2$" 1>/dev/null 2>/dev/null
 if test $? -ne 0; then
   PAR=101
   echo "[Err] Routine VerifSqlErr: parametro di input 1 [$1] non valido."
   History ${PAR}
 fi

 if test x"${SqlCodeNoBlocc}" != "x"; then
   echo "${SqlCodeNoBlocc}" |
   grep -E "^ORA-[0-9]....$|^SP2-[0-9]....$|^TNS-[0-9]....$|^ALL$|^all$" 1>/dev/null 2>/dev/null
   if test $? -ne 0; then
     PAR=102
     echo "[Err] Routine VerifSqlErr: parametro di input 2 [${SqlCodeNoBlocc}] non valido."
     History ${PAR}
   fi
 fi
 ########################################

 Esito=`echo "${EsitoSql}" |
          awk -v SqlCodeNoBlocc="${SqlCodeNoBlocc}" '/ORA-[0-9]/||/SP2-[0-9]/||
                                                     /PLS-[0-9]/||/TNS-[0-9]/||/PL.SQL: / {
            match ($0,"...-[0-9]*");
            SqlErrMess = $0;
            SqlCode = substr ($0, RSTART, RLENGTH);

            if (SqlCodeNoBlocc == "") {
               # Uscita per errore Oracle bloccante.
               print SqlErrMess;
               }
            else {
               if (SqlCodeNoBlocc == "ALL" || SqlCodeNoBlocc == "all") {
                  # Uscita per errore Oracle non bloccante, Esito = -1.
                  print "-1";
                  }
               else {
                  if (SqlCode == SqlCodeNoBlocc) {
                     # Uscita per errore Oracle non bloccante, Esito = -1.
                     print "-1";
                     }
                  else {
                     # Uscita per errore Oracle bloccante.
                     print SqlErrMess;
                  }
               }
            }}'`

 #echo "EsitoSql=[${EsitoSql}]"
 #echo "Esito=[${Esito}]"

 # Verifica esistenza di errori.
 if test x"${Esito}" != "x"; then
   # Verifica esistenza di errori bloccanti.
   echo "${Esito}" | grep -v "^-1$" 1>/dev/null 2>/dev/null
   if test $? -eq 0; then
     echo "${Esito}" | grep -v "^-1$" | FormatOutput "[Err]" 1
     # Scrittura esito sul fine "cronologia" ed interruzione shell.
     History ${PAR}
   else
     # Se tutti gli errori riscontrati risultano essere non bloccanti
     # il campo "Esito" viene valorizzato a "-1".
     Esito=-1
     echo -e "${EsitoSql}" | FormatOutput "[Log]" $1
   fi
 else
   # In assenza di errori il campo "Esito" viene valorizzato a "0".
   Esito=0
   # Display per elaborazione terminata correttamente.
   echo -e "${EsitoSql}" | FormatOutput "[Log]" $1
 fi
}
# Fine routine VerifSqlErr =====================================================

# Inizio routine FormatOutput ==================================================
# Formatta il messaggio ricevuto in input:
# 1) Crea righe di 74 byte.
# 2) Antepone il prefisso comunicato in input.
# Parametri di input.
# 1) Prefisso messaggio, obbligatorio; può assumere i seguenti valori:
#  - "Log".
#  - "Wrn".
#  - "Err".
# 2) Flag stampa output, obbligatorio; può assumere i seguenti valori:
#  - "1", stampa l'output sul video e nel file di log.
#  - "2", stampa l'output nel file di log.
FormatOutput()
{
 # Controllo validità parametri di input.
 echo "$1" | grep -E "^\\[Log\\]$|^\\[Wrn\\]$|^\\[Err\\]$" 1>/dev/null 2>/dev/null
 if test $? -ne 0; then
   PAR=103
   echo "[Err] Routine FormatOutput: parametro di input 1 [$1] non valido."
   History ${PAR}
 fi

 echo "$2" | grep -E "^0$|^1$|^2$" 1>/dev/null 2>/dev/null
 if test $? -ne 0; then
   PAR=104
   echo "[Err] Routine FormatOutput: parametro di input 2 [$2] non valido."
   History ${PAR}
 fi
 ########################################

 case $2 in
   1)awk -v numByteStampa=74 -v prefix="$1 " '{
       # calcolo righe da stampare
       lenEsitoSql=length($0);
       numRec=int((lenEsitoSql / numByteStampa)+1);

       # inizio stampa con prefisso
       for (i=0;i<numRec;i++) {
           StringaStampa=substr($0,i * numByteStampa + 1,numByteStampa);
           if (length(StringaStampa) > 0) {
              print(prefix StringaStampa);
           }
       }
     }' | tee -a ${LOGFILE}
     ;;

   2)awk -v numByteStampa=74 -v prefix="$1 " '{
       # calcolo righe da stampare
       lenEsitoSql=length($0);
       numRec=int((lenEsitoSql / numByteStampa)+1);

       # inizio stampa con prefisso
       for (i=0;i<numRec;i++) {
           StringaStampa=substr($0,i * numByteStampa + 1,numByteStampa);
           if (length(StringaStampa) > 0) {
              print(prefix StringaStampa);
           }
       }
     }' >> ${LOGFILE}
     ;;
 esac
}

FormatOutput_1000()
{
 # Controllo validità parametri di input.
 echo "$1" | grep -E "^\\[Log\\]$|^\\[Wrn\\]$|^\\[Err\\]$" 1>/dev/null 2>/dev/null
 if test $? -ne 0; then
   PAR=103
   echo "[Err] Routine FormatOutput: parametro di input 1 [$1] non valido."
   History ${PAR}
 fi

 echo "$2" | grep -E "^0$|^1$|^2$" 1>/dev/null 2>/dev/null
 if test $? -ne 0; then
   PAR=104
   echo "[Err] Routine FormatOutput: parametro di input 2 [$2] non valido."
   History ${PAR}
 fi
 ########################################

 case $2 in
   1)awk -v numByteStampa=1000 -v prefix="$1 " '{
       # calcolo righe da stampare
       lenEsitoSql=length($0);
       numRec=int((lenEsitoSql / numByteStampa)+1);

       # inizio stampa con prefisso
       for (i=0;i<numRec;i++) {
           StringaStampa=substr($0,i * numByteStampa + 1,numByteStampa);
           if (length(StringaStampa) > 0) {
              print(prefix StringaStampa);
           }
       }
     }' | tee -a ${LOGFILE}
     ;;

   2)awk -v numByteStampa=1000 -v prefix="$1 " '{
       # calcolo righe da stampare
       lenEsitoSql=length($0);
       numRec=int((lenEsitoSql / numByteStampa)+1);

       # inizio stampa con prefisso
       for (i=0;i<numRec;i++) {
           StringaStampa=substr($0,i * numByteStampa + 1,numByteStampa);
           if (length(StringaStampa) > 0) {
              print(prefix StringaStampa);
           }
       }
     }' >> ${LOGFILE}
     ;;
 esac
}

# Fine routine FormatOutput ====================================================

# Inizio routine CheckDate =====================================================
# Verifica la correttezza della data indicata.
# Parametri di input.
# 1) Data, obbligatorio.
#  Verifica la correttezza della data indicata.
#  In caso di data non corretta valorizza la variabile "Esito" a "-1" e
#  continua l'elaborazione.
CheckDate()
{
 # Controllo validità parametri di input.
 PAR=105
 if test x"$1" = "x"; then
   Err "Routine CheckDate: parametro di input 1 non specificato."
 fi

 #flag di verifica
 Esito=-1

 if test ${#1} -eq 8 -a \
         x"`echo ${1} | tr -d '[0-9]'`" = "x"; then

     #assegnazione anno
     anno=${1:0:4}
     #array mesi
     mesi[0]=31
     mesi[1]=28
     mesi[2]=31
     mesi[3]=30
     mesi[4]=31
     mesi[5]=30
     mesi[6]=31
     mesi[7]=31
     mesi[8]=30
     mesi[9]=31
     mesi[10]=30
     mesi[11]=31
     # assegnazione giorno
     giorno=${1:6:2}
     # controllo anno bisestile
     resto=` expr ${anno} % 4 `
     if test "${resto}" -eq 0; then
        mesi[1]=29
     fi
     # assegnazione mese
     mese=${1:4:2}
     ind_mese=`expr ${mese} - 1`
     #controllo se nella stringa ci sono tutti numeri
        # test sull'anno inserito
     if test "${anno}" -ge "2000" &&
        test "${anno}" -le "9999"; then
        # test sul mese inserito
        if test "${mese}" -ge 1 &&
           test "${mese}" -le 12; then
           #test sul giorno inserito
           if test "${giorno}" -ge 1 &&
              test "${giorno}" -le ${mesi[${ind_mese}]}; then
              Esito=0
           fi
        fi
     fi
 fi

 if test ${Esito} -eq 0; then
   return 0
 else
   return 1
 fi
}
# Fine routine CheckDate ====================================================

# Inizio routine isNumeric =====================================================
# Verifica se la variabile passata in input è costituita da soli numeri.
isNumeric()
{
 case $(echo "$1" | sed "s/^-//") in
   *[!0-9,]*|"")
    return 1;;
   *)
    return 0;;
 esac
}
# fine routine isNumeric =======================================================

# Inizio routine Rpad ==========================================================
Rpad()
{
 # Controllo validità parametri di input.
 PAR=106
 if test $# -ne 3; then
   Err "Routine Rpad: parametri di input errati."
 fi

 Str="$1"
 let Len=$2-${#Str}
 if test ${Len} -lt 0; then
   Len=0
 fi
 Char="$3"

 PAR=107
 if test x"${Str}" = "x"; then
   Err "Routine Rpad: parametro di input 1 [${Str}] non valido."
 fi

 PAR=108
 isNumeric "${Len}"
 VerifUnixErr "[Err] Routine Rpad: parametro di input 2 [${Len}] non valido."

 PAR=109
 if test ${#Char} -ne 1; then
   Err "Routine Rpad: parametro di input 3 [${Char}] non valido."
 fi
 ########################################

 echo -e "${Str:0:$2}$(printf "%-${Len}.${Len}s" | sed "y/ /${Char}/")"
}
# Fine routine Rpad ============================================================

# Inizio routine Rpad ==========================================================
Lpad()
{
 # Controllo validità parametri di input.
 PAR=110
 if test $# -ne 3; then
   Err "Routine Lpad: parametri di input errati."
 fi

 Str="$1"
 let Len=$2-${#Str}
 if test ${Len} -lt 0; then
   Len=0
 fi
 Char="$3"

 PAR=111
 if test x"${Str}" = "x"; then
   Err "Routine Lpad: parametro di input 1 [${Str}] non valido."
 fi

 PAR=112
 isNumeric "${Len}"
 VerifUnixErr "[Err] Routine Lpad: parametro di input 2 [${Len}] non valido."

 PAR=113
 if test ${#Char} -ne 1; then
   Err "Routine Lpad: parametro di input 3 [${Char}] non valido."
 fi
 ########################################

 echo -e "${Str:0:$2}$(printf "%-${Len}.${Len}s" | sed "y/ /${Char}/")"
}
# Fine routine Rpad ============================================================

# Inizio routine DataLog =======================================================
DataLog()
{
 echo $(date '+%d-%m-%Y, %H:%M:%S')
}
# Fine routine DataLog =========================================================

# Inizio routine History =======================================================
History()
{
 if test x"$1" = "x"; then
   echo "${SHELL_NAME} `date '+ %Y/%m/%d %H:%M:%S'` - OK - [${RIGA_COMM}]" >> ${HIST_FILE}
   EXIT_CODE=0
 else
   echo "${SHELL_NAME} `date '+ %Y/%m/%d %H:%M:%S'` - ERR $1 - [${RIGA_COMM}]" >> ${HIST_FILE}
   EXIT_CODE=1
 fi
 exit $EXIT_CODE
}
# Fine routine History =========================================================

# Inizio routine StampaHistory =================================================
StampaHistory()
{
 local DATA=`/opt/freeware/bin/date -d'10 days ago' +%Y/%m/%d`
 grep ^"${SHELL_NAME}" ${HIST_FILE} | awk -v data=${DATA} '{if($2>=data) print}'
 History
}
# Fine routine StampaHistory ===================================================

# Inizio routine CreaLogfile ===================================================
CreaLogfile()
{
 touch "$1" 2>/dev/null
 VerifUnixErr "[Err] Impossibile creare il file di log: $1"
}
# Fine routine CreaLogfile =====================================================

# Inizio routine Log ===========================================================
# Parametri di input.
# 1) Messaggio, obbligatorio.
#  Scrive a terminale e su file di log il messaggio aggiungendo il pefisso
#  [Log]. Deve essere utilizzata per comunicare informazioni che non
#  pregiudicano il corretto svolgimento dell'elaborazione.
Log()
{
 echo -e "$*" | FormatOutput "[Log]" 1
}
# Fine routine Log =============================================================

# Inizio routine Wrn ===========================================================
# Parametri di input.
# 1) Messaggio, obbligatorio.
#  Scrive a terminale e su file di log il messaggio aggiungendo il pefisso
#  [Wrn]. Deve essere utilizzata per comunicare la presenza di errori che non
#  pregiudicano il corretto svolgimento dell'elaborazione.
Wrn()
{
 echo -e "$*" | FormatOutput "[Wrn]" 1
}
# Fine routine Wrn =============================================================

# Inizio routine Err ===========================================================
# Parametri di input.
# 1) Messaggio, obbligatorio.
#  Scrive a terminale e su file di log il messaggio aggiungendo il pefisso
#  [Err]. Deve essere utilizzata per comunicare la presenza di errori che
#  pregiudicano il corretto svolgimento dell'elaborazione.
Err()
{
 echo -e "$*" | FormatOutput "[Err]" 1
 #logger -i -p log.err -t "[Err] ${SHELL_NAME}" -- $*
 #History ${PAR}
}
# Fine routine Err =============================================================

# Inizio routine InizioShell ===================================================
InizioShell()
{
 Log "${SHELL_NAME} START `date '+ %Y/%m/%d %H:%M:%S'` [${RIGA_COMM}]"
 Log "La shell e' stata eseguita puntando al database << ${TWO_TASK} >>."
}
# Fine routine InizioShell =====================================================

# Inizio routine FineShell =====================================================
FineShell()
{
 Log "${SHELL_NAME} STOP  `date '+ %Y/%m/%d %H:%M:%S'`"
 History
}
# Fine routine FineShell =======================================================

# Inizio routine CheckOption ===================================================
# Verifica validita' opzioni.
# Parametri di input.
# 1) riga di comando, obbligatorio;
# 2) controllo "nessuna opzione", obbligatorio; impedisce l'esecuzione della
#    shell senza l'utilizzo di almeno una opzione.
#    può assumere i seguenti valori:
#  - "0", disattivo.
#  - "1", attivo.
#    Esempio di utilizzo:
#    CheckOption "${TEMP}" 0
CheckOption()
{
 echo "$2" | grep -E "^0$|^1$" 1>/dev/null 2>/dev/null
 if test $? -ne 0; then
   PAR=114
   Err "Routine CheckOption: parametro di input 2 [$2] non valido."
 fi

 echo "${1}" | grep -E " *-- $" 1>/dev/null 2>/dev/null
 if test $? -eq 0; then
   if test $2 -eq 0; then
     return 0
   else
     if test ${#1} -eq 3; then
       return 1
     fi
   fi
 else
   return 1
 fi
}
# Fine routine CheckOption =====================================================



# Inizio routine ExecParallelSql ===============================================
# Esecuzione in parallelo dello script comunicato in input.
# Parametri di input:
# 1) Numero di sessioni da eseguire in parallelo;
# 2) DB_USER;
# 3) DB_PWD;
# 4) Script sql da eseguire più eventuali parametri;
ExecParallelSql()
{
 # Controllo validità parametri di input.
 if test $# -ne 4; then
   PAR=115
   Err "Routine ExecParallelSql: parametri di input errati."
 fi

 if ! isNumeric "${1}"; then
   PAR=116
   Err "Routine ExecParallelSql: parametro di input 1 [${1}] non valido."
 fi
 ########################################

 DB_SESSION=${1}
 DB_USER=${2}
 DB_PWD=${3}
 SQL_STM=${4}
 SQL_SCRIPT=$(echo "${SQL_STM}" | awk -F" " '{print $1}')

 # Esecuzione script sql in n sessioni parallele.
 for ((i=1 ; i<=DB_SESSION ; i++)); do
   Log "Lancio ${SQL_SCRIPT} numero ${i}"
   {
   LOGFILE=${LOGFILE}_${i}
   EsitoSql=`sqlplus -s <<- EOS
	  ${DB_USER}/${DB_PWD}
	  @${PATHSQL}/${SQL_STM} ${DB_SESSION} ${i}
			EOS`
   VerifSqlErr 2
   } &
  sleep 4
 done
 wait

 # Verifica la presenza di eventuali errori sql bloccanti.
 for ((i=1 ; i<=DB_SESSION ; i++)); do
   grep -i "^\\[Err\\]" ${LOGFILE}_${i} 1>/dev/null 2>/dev/null
   if test $? -eq 0; then
     Err "Esecuzione in parallelo ${SQL_SCRIPT} numero ${i} terminata in errore."
   fi
 done
}
# Fine   routine ExecParallelSql ===============================================
