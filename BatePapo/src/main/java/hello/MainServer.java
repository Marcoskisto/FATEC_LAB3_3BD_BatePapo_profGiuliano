package hello;

import static spark.Spark.*;

import java.util.LinkedList;


public class MainServer {
	
	final static ChatModel chatmodel = new ChatModel();
	
    public static void main(String[] args) {

		// Get port config of heroku on environment variable
        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 8081;
        }
        port(port);

		//Servir conteudo html, css e javascript
		staticFileLocation("/static");

		inicializarCarros();

		//Controller controller = new Controller(model);
		Controller controller = new Controller(chatmodel);

		//esta função é chamada a partir da view 
		controller.buscarSala();
		controller.enviarMSG();
		controller.logar();
		controller.cadastrar();
		controller.getUsuarios();
		controller.deletaUsuario();
		
    }
    
    public static void inicializarCarros(){
    	/*chatmodel.addUsuario(new Usuario("marcos.com.br", "123456", null));
    	chatmodel.addSala(new Sala("Masculino",new LinkedList<Mensagem>()));
    	chatmodel.addSala(new Sala("Feminino",new LinkedList<Mensagem>()));
    	chatmodel.addSala(new Sala("SJCampos",new LinkedList<Mensagem>()));
    	chatmodel.addSala(new Sala("Adulto",new LinkedList<Mensagem>()));
    	chatmodel.addSala(new Sala("Jacarei",new LinkedList<Mensagem>()));
    	chatmodel.addSala(new Sala("Adolescente",new LinkedList<Mensagem>()));
    	chatmodel.buscaSala("Jacarei").getMensagens().add(new Mensagem("kleber@serco.com.br","Olá, tudo bem?","10:55:00"));
    	chatmodel.buscaSala("Jacarei").getMensagens().add(new Mensagem("Vanessa","Tudo bem e com vc??","10:56:00"));
    	chatmodel.buscaSala("Jacarei").getMensagens().add(new Mensagem("kleber@serco.com.br","Tudo bem também","10:57:00"));
    	chatmodel.buscaSala("Jacarei").getMensagens().add(new Mensagem("Vanessa","Fazendo o que de bom?","11:00:00"));
    	chatmodel.buscaSala("Jacarei").getMensagens().add(new Mensagem("kleber@serco.com.br","Estudando e vc??","11:10:00"));
    	chatmodel.buscaSala("Jacarei").getMensagens().add(new Mensagem("Vanessa","Dormindo?","11:15:00"));
    	chatmodel.buscaSala("Jacarei").getMensagens().add(new Mensagem("Sera??","Agora foi?","11:20:00"));
    	chatmodel.buscaSala("Adulto").getMensagens().add(new Mensagem("Sera??","Agora foi?","11:20:00"));
    	chatmodel.buscaSala("Adolescente").getMensagens().add(new Mensagem("Sera??","Agora foi?","11:20:00"));
    	chatmodel.buscaSala("SJCampos").getMensagens().add(new Mensagem("Sera??","Agora foi?","11:20:00"));
    	chatmodel.buscaSala("Feminino").getMensagens().add(new Mensagem("Sera??","Agora foi?","11:20:00"));
    	chatmodel.buscaSala("Masculino").getMensagens().add(new Mensagem("Sera??","Agora foi?","11:20:00"));*/
    }
}
