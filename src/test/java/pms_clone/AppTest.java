package pms_clone;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import com.pms_clone.util.HibernateUtil;

public class AppTest {

	@Test
	public void testJdbcConnection() {
		String str = "Junit is working fine";
		assertEquals("Junit is working fine", str);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
	    session.beginTransaction();

	    // Check database version
	    String sql = "select version()";
	    session.createQuery(sql).getResultList();
	    String result = (String) session.createNativeQuery(sql).getSingleResult();	    
	    System.out.println(result);
	    session.getTransaction().commit();
	    session.close();
	}

}
