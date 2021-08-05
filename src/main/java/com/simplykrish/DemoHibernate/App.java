package com.simplykrish.DemoHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Alien ak=new Alien();
    	ak.setAid(1);
    	ak.setAname("ajith");
    	ak.setAcolor("blue");
    	
    	Configuration conf=new Configuration().configure().addAnnotatedClass(Alien.class);
    	
    	ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
    	
    	SessionFactory sf=conf.buildSessionFactory();
    	
    	Session session=sf.openSession();
 
    	Transaction tx=session.beginTransaction();
    	
    	session.save(ak);
    	
    	tx.commit();
    }
}
