package it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch;

import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.support.DefaultTransactionStatus;

public class NoTransaction extends org.springframework.transaction.support.AbstractPlatformTransactionManager {

	@Override
	protected Object doGetTransaction() throws TransactionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void doBegin(Object transaction, TransactionDefinition definition)
			throws TransactionException {
		// TODO Auto-generated method stub

	}

	@Override
	protected void doCommit(DefaultTransactionStatus status)
			throws TransactionException {
		// TODO Auto-generated method stub

	}

	@Override
	protected void doRollback(DefaultTransactionStatus status)
			throws TransactionException {
		// TODO Auto-generated method stub

	}

}
