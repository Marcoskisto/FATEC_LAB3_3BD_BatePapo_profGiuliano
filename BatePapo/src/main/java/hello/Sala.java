package hello;
import java.util.LinkedList;
import java.util.List;
import java.util.jar.Attributes.Name;

public class Sala {
	private String name;
	private List<Mensagem> Mensagens = new LinkedList<Mensagem>();
	
	
	public Sala(String name,List<Mensagem> mensagens ) {
		this.name=name;		
		this.Mensagens=mensagens;
	}
		
	public List<Mensagem> getMensagens() {
		return Mensagens;
	}

	public void setMensagens(List<Mensagem> mensagens) {
		Mensagens = mensagens;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean comparar(String nome) {
		if(nome.equals(this.name)){
			return true;
		} else {
			return false;

	}

	}
	public void addMensagem(String email, String msg, String hora) {
		getMensagens().add(new Mensagem(email,msg,hora));

		
	}

}
