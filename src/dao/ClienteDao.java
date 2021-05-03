package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Cliente;
import datos.InscripcionAfip;
import datos.PersonaFisica;
import datos.PersonaJuridica;

public class ClienteDao {
	
	private static Session session;
	private Transaction tx;
	private static ClienteDao instancia = null; //Patron Singleton
	
	protected ClienteDao() {}
	
	public static ClienteDao getInstance()
	{
		if(instancia == null)
			instancia = new ClienteDao();
		
		return instancia;
	}
	
	protected void iniciaOperacion() throws HibernateException
	{
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	protected void manejaException(HibernateException he) throws HibernateException
	{
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
	/*
	 * EN ESTE METODO SE RECUPERA EL OBJETO 
	 * Y EN CASO DE EXISTIR SE INICIALIZAN
	 * SU CONTACTO E INSCRIPCIONESAFIP*/
	public Cliente traer(int idCliente)
	{
		Cliente objeto = null;
		
		try
		{
			iniciaOperacion();
			objeto = (Cliente) session.createQuery("from Cliente c where c.idCliente =" 
			+ idCliente).uniqueResult();
			
			if(objeto != null)
			{
				Hibernate.initialize(objeto.getContacto());
				
				for(InscripcionAfip afip : objeto.getInscripcionAfip())
					Hibernate.initialize(afip);
			}
		}finally
		{
			session.close();
		}
		
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> traer() throws HibernateException
	{
		List<Cliente> lista = null;
		
		try
		{
			iniciaOperacion();
			lista = session.createQuery("from Cliente").list();
		}finally
		{
			session.close();
		}
		
		return lista;
	}
	
	public void agregar(Cliente cliente) throws Exception
	{	
		try
		{
			iniciaOperacion();
			session.save(cliente);
			tx.commit();
		}	catch(HibernateException he) {
				manejaException(he);
				throw he;
			}
			
			finally {
				session.close();
			}
	}
}




