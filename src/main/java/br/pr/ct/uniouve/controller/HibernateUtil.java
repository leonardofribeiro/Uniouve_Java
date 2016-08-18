package br.pr.ct.uniouve.controller;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.pr.ct.uniouve.model.AreaInstitucional;
import br.pr.ct.uniouve.model.Usuario;

public class HibernateUtil implements Serializable {
	
	private static final long serialVersionUID = 1862457524814232706L;
	private transient static final SessionFactory siadmSessionFactory = siadmBuildSessionFactory();
	//private transient static final SessionFactory agendamentoSessionFactory = agendamentoBuildSessionFactory();
	
	private static SessionFactory siadmBuildSessionFactory() {
		SessionFactory sessionFactory = null;
		try
		{
			/*Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);*/
			sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(AreaInstitucional.class)
				.addAnnotatedClass(Usuario.class)
				.buildSessionFactory();
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			throw new ExceptionInInitializerError(e);
		}
		return sessionFactory;
	}
	
	/*@SuppressWarnings("deprecation")
	private static SessionFactory agendamentoBuildSessionFactory() {
		SessionFactory sessionFactory = null;
		try
		{
			/*Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			sessionFactory = new Configuration().configure("agendamento_hibernate.cfg.xml")
				.addAnnotatedClass(AgendamentoCarro.class)
				.addAnnotatedClass(Passageiro.class)
				.addAnnotatedClass(HistoricoAgendamentoCarro.class)
				.addAnnotatedClass(EmailAssinatura.class)
				.buildSessionFactory();
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			throw new ExceptionInInitializerError(e);
		}
		return sessionFactory;
	}*/

	public static Session getSiadmSessionFactory() {
		Session session = null;
		try
		{
			session = siadmSessionFactory.openSession();
		}
		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
			session = siadmSessionFactory.getCurrentSession();
		}
		return session;
	}
	
	/*public static Session getAgendamentoSessionFactory() {
		Session session = null;
		try
		{
			session = agendamentoSessionFactory.openSession();
		}
		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
			session = agendamentoSessionFactory.getCurrentSession();
		}
		return session;
	}*/
}
