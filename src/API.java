
public enum API {
	
	IMDB_TOP_MOVIES("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json", new ExtratorDeConteudoIMDB()),
	NASA("https://api.nasa.gov/planetary/apod?api_key=kQfl6YrUpKGgpeT0yUGIDsEVib9FS9S0WPvCxuAO&start_date=2022-06-12&end_date=2022-06-14", new ExtratorDeConteudoNasa());

	private String url;
	private ExtratorDeConteudo extrator;
	
	API(String url,ExtratorDeConteudo extrator ) {
		this.url = url;
		this.extrator = extrator;
	}
	
	public String getUrl() {
		return url;
	}
	
	public ExtratorDeConteudo getExtrator() {
		return extrator;
	}
}
