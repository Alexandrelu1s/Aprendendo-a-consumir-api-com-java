import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
    	Scanner sc = new Scanner(System.in);
    	List<Conteudo> conteudos = null;
    	
    	System.out.print("Digite 1 para imDb e 2 para Nasa: ");
    	int n = sc.nextInt();
    	
    	if(n == 1) {
    		
    		String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
    		
    		var http = new ClienteHttp();
            String json = http.buscaDados(url);
            
            ExtratorDeConteudoIMDB extrator = new ExtratorDeConteudoIMDB();
            conteudos = extrator.extraiConteudos(json);
    	}
    	
    	if(n == 2) {
    		
    		String url = "https://api.nasa.gov/planetary/apod?api_key=kQfl6YrUpKGgpeT0yUGIDsEVib9FS9S0WPvCxuAO&start"
    				+ "_date=2022-06-12&end_date=2022-06-14";
    		
    		var http = new ClienteHttp();
            String json = http.buscaDados(url);
            
            ExtratorDeConteudoNasa extrator = new ExtratorDeConteudoNasa();
            conteudos = extrator.extraiConteudos(json);
    	}
    	
        var geradora = new StickerGenerator();
        var diretorio = new File("figurinhas/");
    	diretorio.mkdir();
    	
        for (int i = 0; i < 3; i++) {
        	
        	Conteudo conteudo = conteudos.get(i);
        	
        	
        	
        	InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
        	String nomeArquivo = "figurinhas/" + conteudo.getTitulo() + ".png";
        	
        	geradora.cria(inputStream, nomeArquivo);
        	
        	
            System.out.println(conteudo.getTitulo());
            
            System.out.println("\n");
        }
        
        sc.close();
    }
}
