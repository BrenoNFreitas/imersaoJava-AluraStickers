import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        //fazer uma conexão HTTP e buscar os top 250 filmes
        //url filmes
        //String url = "https://imdb-api.com/en/API/Top250Movies/C H A V E(k_0ojt0yvm)"
        //String url = "https://api.mocki.io/v2/549a5d8b";
        //ExtratorDeConteudo extrator = new ExtratorDeConteudoIMDB();
        
        //url Nasa
        //String url = "https://api.mocki.io/v2/549a5d8b/NASA-APOD-JamesWebbSpaceTelescope";
        //ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();
        
        String url = "http://localhost:8080/linguagens";
        ExtratorDeConteudo extrator = new ExtratorDeConteudoIMDB();

        var http = new clienteHttp();
        String json = http.buscaDados(url);
        
        //exibir e manipular os dados
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var geradora = new GeradoraDeFigurinhas();
        for (int i = 0; i < 2; i++) {
            Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "saida/" + conteudo.getTitulo() + ".png";

            geradora.cria(inputStream, nomeArquivo);

            System.out.println("Título: " + conteudo.getTitulo());
            System.out.println();
        }
    }
}
