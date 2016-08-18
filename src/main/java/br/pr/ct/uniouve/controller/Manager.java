package br.pr.ct.uniouve.controller;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Manager implements Serializable {

	private static final long serialVersionUID = 4182628377736417363L;
	private transient Session session;
	private transient Transaction transaction;
	
	public Manager getSiadmSession() {
		session = HibernateUtil.getSiadmSessionFactory();
		transaction = session.beginTransaction();
		return this;
	}
	
	/*public Manager getAgendamentosSession() {
		session = HibernateUtil.getAgendamentoSessionFactory();
		transaction = session.beginTransaction();
		return this;
	}*/
	
	public Session getSession() {
		if(this.session != null && this.session.isConnected())
			return this.session;
		return null;
	}

	public void commit() {
		if(session.isOpen() && transaction != null)
			transaction.commit();
		if(session.isOpen())
			session.close();
		if(session.isConnected())
			session.disconnect();
	}
	
	public void rollback() {
		if(transaction != null && session != null && session.isOpen())
			transaction.rollback();
	}
	
	public void flush() {
		if(session.isOpen() && session.isConnected())
		{
			session.flush();
			session.clear();
		}
	}
}