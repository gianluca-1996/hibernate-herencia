package datos;

import java.util.Set;

public abstract class Cliente {

	private int idCliente;
	private String nroCliente;
	private Contacto contacto;
	private Set<InscripcionAfip> inscripcionAfip;
	

	public Cliente() {}
	
	public Cliente(String nroCliente)
	{
		super();
		this.nroCliente = nroCliente;
	}
	
	public int getIdCliente()
	{
		return this.idCliente;
	}
	
	protected void setidCliente(int idCliente)
	{
		this.idCliente = idCliente;
	}
	
	public String getNroCliente() 
	{
		return this.nroCliente;
	}
	
	public void setNroCliente(String nroCliente)
	{
		this.nroCliente = nroCliente;
	}

	public Contacto getContacto() {
		return contacto;
	}
	
	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}
	
	public Set<InscripcionAfip> getInscripcionAfip() {
		return inscripcionAfip;
	}
	
	public void setInscripcionAfip(Set<InscripcionAfip> inscripcionAfip) {
		this.inscripcionAfip = inscripcionAfip;
	}
	
	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nroCliente=" + nroCliente + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCliente;
		result = prime * result + ((nroCliente == null) ? 0 : nroCliente.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (idCliente != other.idCliente)
			return false;
		if (nroCliente == null) {
			if (other.nroCliente != null)
				return false;
		} else if (!nroCliente.equals(other.nroCliente))
			return false;
		return true;
	}
	
	
	
}

















