package hello;
import java.util.LinkedList;
import java.util.List;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

public class ChatModel {
	private ObjectContainer usuarios=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/usuarios.db4o");
	private ObjectContainer salas = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/salas.db4o");
	
	public ObjectSet<Usuario> getUsuarios() {
		Query query = usuarios.query();
		query.constrain(Usuario.class);
	    ObjectSet<Usuario> todosUsuarios = query.execute();
	    
		return todosUsuarios;
	}
	
	
	public void addSala(Sala sala){
		salas.store(sala);
		salas.commit();

	}
	//novo em 06/10
	public void addUsuario(Usuario usuario){
		usuarios.store(usuario);
		usuarios.commit();
	}
	public void setUsuarios(ObjectContainer usuarios) {
		usuarios = usuarios;
	}
	public ObjectContainer getSalas() {
		return salas;
	}
	
	
	public Sala buscaSala(String nome){
		
		Query query = salas.query();
		query.constrain(Sala.class);
	    ObjectSet<Sala> allSalas = query.execute();
		
		for(Sala sala:allSalas){
			 if(sala.comparar(nome)) return sala;
		}
		
		return null;
		
	}
	public Usuario buscaUsuario(String email) {
		Query query = usuarios.query();
		query.constrain(Usuario.class);
	    ObjectSet<Usuario> allUsuarios = query.execute();
	    
	    for(Usuario usuario:allUsuarios) {
	    	if(usuario.getEmail().equals(email)) return usuario;
	    }
		return null;
	}

	public List<Usuario> buscarDadosUsuario(DadosUsuario Dados){
		List<Usuario> UsuariosEncontrados = new LinkedList<Usuario>();
		
		Query query = usuarios.query();
		query.constrain(Usuario.class);
	    ObjectSet<Usuario> allUsuarios = query.execute();
		
		for(Usuario usuario:allUsuarios){
			 if(Dados.comparar(usuario.getDados())) UsuariosEncontrados.add(usuario);
		}
		
		return UsuariosEncontrados;
		
	}
	//inserido em 06/10
	public Usuario logar(String email, String senha) {
		Usuario dadosLogin = new Usuario(email, senha, null); 
		
		Query query = usuarios.query();
		query.constrain(Usuario.class);
	    ObjectSet<Usuario> allUsuarios = query.execute();
		
		for(Usuario usuario:allUsuarios) {
			if(dadosLogin.comparar(usuario)) return usuario;
		}
		return new Usuario("error","error", new DadosUsuario(null,null,null));
	}
	public void addMsgNaSala(String sala,String email, String msg, String hora) {
		buscaSala(sala).addMensagem(email,msg,hora);
		salas.store(buscaSala(sala).getMensagens());
		salas.commit();
		
	}
	public void deletaUsuario(String email) {
		usuarios.delete(this.buscaUsuario(email));
		usuarios.commit();
	}


	public void deletaMsg() {
		Query query = salas.query();
		query.constrain(Sala.class);
	    ObjectSet<Sala> allSalas = query.execute();
		
	    for(Sala sala:allSalas) {
	    	salas.delete(sala);
	    }
	    salas.commit();
	}
	
	
}