import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {
    
    public void cria(InputStream inputStream, String nomeArquivo) throws Exception{

        //leitura da imagem (carregando a imagem)
        //InputStream inputStream = new FileInputStream(new File("entrada/filme.jpg"));
        //InputStream inputStream = new URL("https://imersao-java-apis.s3.amazonaws.com/TopMovies_1.jpg").openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        //criar nova imagem em memória com transparência e com tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 300;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
        
        //copiar imagem original para novo imagem (em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);
        
        //configurar fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 95);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);

        //escrever uma frase na nova imagem
        graphics.drawString("TOPZERA", 200, novaAltura - 100);
        
        //escrever a nova imagem em um arquivo arquivo
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));
    }

}
