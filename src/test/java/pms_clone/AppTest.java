package pms_clone;

import static org.junit.Assert.*;

import java.util.List;

import com.pms_clone.model.Tickets;
import org.hibernate.*;
import org.hibernate.transform.Transformers;
import org.junit.Test;

import com.pms_clone.util.HibernateUtil;

public class AppTest {

	@Test
	public void testSelectDB() {
		String str = "Junit is working fine";
		assertEquals("Junit is working fine", str);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
	    session.beginTransaction();

	    // Check database version
	    String sql = "select * from Tickets";
        SQLQuery sqlQuery = session.createSQLQuery(sql);
	    //List<Tickets> tickets = sqlQuery.setResultTransformer(Transformers.aliasToBean(Tickets.class)).list();
        List<Tickets> tickets = session.createQuery("from Tickets").list();
	    System.out.println("Total no of tickets "+tickets.get(0).getTracker());
	    session.getTransaction().commit();
	    session.close();
	}

    @Test
    public void testInsertDB() {
        String str = "Junit is working fine";
        assertEquals("Junit is working fine", str);
        Tickets tkt =  new Tickets();
        tkt.setOwner("Myself vikash");

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(tkt);
            transaction.commit();
            session.close();
			System.out.println("InsertSuccessful");
        } catch (Exception e) {
            System.out.println("Error in saving project to db "+e.toString());
        }
    }

}
