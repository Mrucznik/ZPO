package Przyklad3_Hibernate;
import org.hibernate.*;
import org.hibernate.cfg.*;
import test.Student;

public class Main5 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Student s =new Student("Adam","Nowak",123423,3.5f,true);
		session.save(s);
		tx.commit();
		session.close();

	}

}
