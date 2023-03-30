import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoIMDB implements ExtratorDeConteudo {

	@Override
	public List<Conteudo> extraiConteudos(String json) {

		// pegar/extrair só os dados que interessam (titulo, poster, classificacao)

		JsonParser parser = new JsonParser();
		List<Map<String, String>> listaDeAtributos = parser.parse(json);
		
		return listaDeAtributos.stream().map(atributos -> new Conteudo(atributos.get("title"), atributos.get("image"))).toList();
		
		/*return listaDeAtributos.stream().map(atributos -> new Conteudo(atributos.get("title"), atributos.get("image"))).replaceAll("(@+)(.*).jpg$", "$1.jpg")
				.toList(); caso fosse usado na API do imDb para escolher o tamanho certo da imagem*/
		
	}

}
