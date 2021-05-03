package datos;

public class Contacto {

	private int idContacto;
	private String email;
	private String telfijo;
	private String movil;
	
	public Contacto() {}
	
	public Contacto(String email, String telfijo, String movil)
	{
		super();
		setEmail(email);
		setTelfijo(telfijo);
		setMovil(movil);
	}

	public int getIdContacto() {
		return idContacto;
	}

	protected void setIdContacto(int idContacto) {
		this.idContacto = idContacto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelfijo() {
		return telfijo;
	}

	public void setTelfijo(String telfijo) {
		this.telfijo = telfijo;
	}

	public String getMovil() {
		return movil;
	}

	public void setMovil(String movil) {
		this.movil = movil;
	}

	@Override
	public String toString() {
		return "Contacto [idContacto=" + idContacto + ", email=" + email + ", telfijo=" + telfijo + ", movil=" + movil
				+ "]";
	}
	
	
}
