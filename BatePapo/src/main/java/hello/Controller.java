package hello;

import static spark.Spark.get;

//import java.util.List;

import com.google.gson.Gson;
import spark.Route;

public class Controller {
	
	private ChatModel chatmodel;

	public ChatModel getChatmodel() {
		return chatmodel;
	}

	public void setChatmodel(ChatModel chatmodel) {
		this.chatmodel = chatmodel;
	}

	public Controller(ChatModel chatmodel){
		this.chatmodel = chatmodel;
	}
	

	public void buscarSala(){
		get("/sala/:nome", (req, res) -> {
		
			String sala = req.params(":nome");	
			Sala salaEncontrada = chatmodel.buscaSala(sala);	
			return new Gson().toJson(salaEncontrada);
			
		});
	}
	
	public void enviarMSG(){
		get("/msg/:sala/:email/:msg/:hora", (req, res) -> {		
			chatmodel.addMsgNaSala(req.params(":sala"), req.params(":email"), req.params(":msg"), req.params(":hora"));	
			return "ok";			
		});
	}

	public void logar() {
		get("/login/:email/:senha", (req,res) -> {
			Usuario login = chatmodel.logar(req.params(":email"), req.params(":senha"));
			
			return new Gson().toJson(login);
		});
	}

	public void cadastrar(){
		get("/cadastro/:email/:senha/:nome/:cidade/:data", (req, res) -> {		
			chatmodel.addUsuario(new Usuario(req.params(":email"),req.params(":senha"),new DadosUsuario(req.params(":nome"),req.params(":data"),req.params(":cidade"))));	
			return "ok";			
		});
	
		}
	public void getUsuarios(){
		get("/usuarios/", (req, res) -> {
		
			//String sala = req.params(":nome");	
			//Sala salaEncontrada = chatmodel.buscaSala(sala);	
			return new Gson().toJson(chatmodel.getUsuarios());
			
		});
	}
	public void deletaUsuario() {
		get("/deletaUsuario/:email", (req, res) -> {
			chatmodel.deletaUsuario(req.params(":email"));	
			return "PARABENS, USUARIO DELETADO COM SUCESSO!!!!<br><a href='http://localhost:8081/desenvolvedor.html'>Retornar</a>";
			
		});
	}
	}
		
