package hello;

public class DadosUsuario {

	private String nome;
	private String dataNasimento;
	private String cidade;
	
	
	public DadosUsuario(String nome, String dataNascimento, String cidade){
		this.nome = nome;
		this.dataNasimento = dataNascimento;
		this.cidade = cidade;
	}	
	//
	public boolean comparar(DadosUsuario Dados){
		if(nome.equals(Dados.nome) && cidade.equals(Dados.cidade)){
			return true;
		} else {
			return false;
		}
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getIdade() {
		return dataNasimento;
	}



	public void setIdade(String idade) {
		dataNasimento = idade;
	}



	public String getCidade() {
		return cidade;
	}



	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
}
