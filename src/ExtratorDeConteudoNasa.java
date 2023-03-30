import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoNasa implements ExtratorDeConteudo {

	@Override
	public List<Conteudo> extraiConteudos(String json){
		
		// pegar/extrair só os dados que interessam (titulo, poster, classificacao)
		
		JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);
        
        
        return listaDeAtributos.stream().map(atributos -> new Conteudo(atributos.get("title"), atributos.get("url"))).toList();

	}
	
}
