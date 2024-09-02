package KLEF.Hibernate_CURD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import jakarta.persistence.Query;






/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    { 
    	
    	StandardServiceRegistry ssr= new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
         
        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();  
        Transaction t;
        
        Patient P1=new Patient();
        P1.Fn="VArun";
        P1.Ln="CSE";
        session.save(P1);
        t= session.beginTransaction();
        t.commit();
                
        System.out.println( "Record Created" );
        
        Patient P2=session.find(Patient.class,1);
        System.out.println("Patient Record Updated");
        System.out.println(P2);
        
        Query query = session.createQuery("update Patient set Fn=:Fn, Ln=:Ln where id=:id");
        query.setParameter("Fn", "jeevan");
        query.setParameter("Ln", "Mashdgfhasdf");
        query.setParameter("id", 1);
        session.save(P1);
        Transaction f = session.beginTransaction();
        int result = query.executeUpdate();
        t.commit();
        System.out.println(" rows updated: "+result);
        
    }
}
