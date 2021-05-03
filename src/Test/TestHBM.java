package Test;

import org.hibernate.Session;

import dao.HibernateUtil;

public class TestHBM {

	public static void main(String[] args) {
		
		try
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.close();
			System.out.println("OK");
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

	}

}
