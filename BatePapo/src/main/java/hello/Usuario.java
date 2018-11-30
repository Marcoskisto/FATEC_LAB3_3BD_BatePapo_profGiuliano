package hello;

public class Usuario {
	private String email;
	private String senha;
	private DadosUsuario Dados;
	
	public Usuario(String email, String senha, DadosUsuario dados) {
		this.setEmail(email);
		this.setSenha(senha);
		this.setDados(dados);		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public DadosUsuario getDados() {
		return Dados;
	}

	public void setDados(DadosUsuario dados) {
		Dados = dados;
	}
	//inserido em 06/10
	public boolean comparar(Usuario dadosLogin){
		if(email.equals(dadosLogin.email) && senha.equals(dadosLogin.senha)){
			return true;
		} else {
			return false;
		}
	}
}

