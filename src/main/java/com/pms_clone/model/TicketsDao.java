package com.pms_clone.model;

import com.pms_clone.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import java.util.List;

public class TicketsDao {

    public static List<Tickets> getAllTickets(){
        List<Tickets> ticketsList = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            // Check database version
            String sql = "select * from Tickets";
            //SQLQuery sqlQuery = session.createSQLQuery(sql);
            //List<Tickets> tickets = sqlQuery.setResultTransformer(Transformers.aliasToBean(Tickets.class)).list();
            ticketsList = session.createQuery("from Tickets").list();
            System.out.println("Total no of tickets "+ticketsList.size());
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("Execption in finding all tickets "+e.toString());
            e.printStackTrace();
        }
        return ticketsList;
    }
}
