package Test;

import datos.Cliente;
import datos.InscripcionAfip;
import datos.PersonaFisica;
import datos.PersonaJuridica;
import negocio.ClienteABM;

public class TestCliente {

	public static void main(String[] args) {

		/*
		 * EN ESTE TEST SE REALIZA LA RECUPERACION
		 * DE LOS DATOS EN LA BD. PRIMERO SE OBTIENE UN CLIENTE POR SU ID
		 * Y SE MUESTRA TAMBIEN SU CONTACTO E INSCRIPCIONES AFIP
		 * LUEGO SE TRAE UNA LISTA DE TODOS LOS CLIENTES*/
		
		PersonaFisica pf = null;
		PersonaJuridica pj = null;
		Cliente cliente = null;
		int idCliente = 1;
		
		System.out.println("+ traer(" + idCliente + ")");	
		try
		{
			cliente = ClienteABM.getInstance().traer(idCliente);	//SE OBTIENE LA INSTANCIA CLIENTEABM Y SE LLAMA AL METODO "TRAER" MEDIANTE SU ID  
			if(cliente instanceof PersonaFisica)	//SE EVALUA SI LA VARIABLE CONTIENE UN OBJETO FISICO O JURIDICO
			{
				//EN EL CASO DE QUE EL OBJETO SEA PERSONAFISICA SE REALIZA EL CASTEO Y SE IMPRIMEN LOS DATOS
				pf = (PersonaFisica) cliente;	
				System.out.println(pf + "\n" + pf.getContacto());
				for(InscripcionAfip afip : pf.getInscripcionAfip())
					System.out.println(afip);
			}
			
			else
			{
				//EN EL CASO DE QUE EL OBJETO SEA PERSONAJURIDICA SE REALIZA EL CASTEO Y SE IMPRIMEN LOS DATOS
				pj = (PersonaJuridica) cliente;
				System.out.println(pj + "\n" + pj.getContacto());
				for(InscripcionAfip afip : pj.getInscripcionAfip())
					System.out.println(afip);
			}
			
			//SE IMPRIME LA LISTA CON TODOS LOS CLIENTES SIN SUS CONTACTOS NI INSCRIPCIONES
			System.out.println("\n + traer()");
			
			for(Cliente c : ClienteABM.getInstance().traer())
				System.out.println(c);

		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

	}

}
