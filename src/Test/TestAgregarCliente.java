package Test;

import java.util.LinkedHashSet;
import java.util.Set;

import datos.Cliente;
import datos.Contacto;
import datos.InscripcionAfip;
import datos.PersonaFisica;
import datos.PersonaJuridica;
import negocio.ClienteABM;

public class TestAgregarCliente {

	public static void main(String[] args) {

		/*EN ESTE TEST REALIZO EL ALTA DE UN CLIENTE 
		 * YA SEA PERSONAFISICA O JURIDICA
		 * CON SU CONTACTO E INSCRIPCIONES EN AFIP YA SETEADOS*/
		
		Cliente cliente = new PersonaJuridica("10012", "UNLa - SISTEMAS", "20-654987-6");	//DENTRO DE UNA VARIABLE DE TIPO CLIENTE GUARDO UN NUEVO OBJETO DE UNA DE SUS CLASES HIJAS 
		cliente.setContacto(new Contacto("unlaSistemas@gmail.com", "42874565", "1120654987"));	//SETEO EL CONTACTO DEL CLIENTE
		Set<InscripcionAfip> listaAfip = new LinkedHashSet<InscripcionAfip>();	//LISTA PARA GUARDAR LOS OBJETOS DE TIPO INSCRIPCIONAFIP
		
		//AGREGO LOS OBJETOS EN LA LISTA Y LUEGO LA SETEO EN LA VARIABLE CLIENTE
		listaAfip.add(new InscripcionAfip("inscr.AFIP", cliente));	
		listaAfip.add(new InscripcionAfip("inscr.AFIP", cliente));
		cliente.setInscripcionAfip(listaAfip);
		
		//PERSISTENCIA DEL OBJETO
		try
		{
			ClienteABM.getInstance().agregar(cliente);
			System.out.print("-------------------EXITO\"-------------------");
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
