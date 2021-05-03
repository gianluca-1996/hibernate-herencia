package negocio;

import java.util.List;

import dao.ClienteDao;
import datos.Cliente;

public class ClienteABM {

	private static ClienteABM instancia = null; //patron singleton
	
	protected ClienteABM() {}
	
	public static ClienteABM getInstance()
	{
		if(instancia == null)
			instancia = new ClienteABM();
		
		return instancia;
	}
	
	public Cliente traer(int idCliente)
	{
		
		return ClienteDao.getInstance().traer(idCliente);
	}
	
	public List<Cliente> traer()
	{
		return ClienteDao.getInstance().traer();
	}
	
	public void agregar(Cliente cliente) throws Exception
	{
		if(traer(cliente.getIdCliente()) != null)
			throw new Exception("ERROR - El cliente ya existe...");
		
		ClienteDao.getInstance().agregar(cliente);
	}
}
