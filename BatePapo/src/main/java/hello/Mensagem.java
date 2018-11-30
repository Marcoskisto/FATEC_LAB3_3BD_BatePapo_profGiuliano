package hello;

public class Mensagem {
	private String Email;
	private String Texto;
	private String Hora;
	
	public Mensagem(String email, String texto, String hora) {
		this.setEmail(email);
		this.setTexto(texto);
		this.setHora(hora);
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getTexto() {
		return Texto;
	}

	public void setTexto(String texto) {
		Texto = texto;
	}

	public String getHora() {
		return Hora;
	}

	public void setHora(String hora) {
		Hora = hora;
	}
}
