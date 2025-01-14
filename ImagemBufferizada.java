import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImagemBufferizada {

    private static BufferedImage image;

    public static void main(String[] args) {
        // Criar um seletor de arquivos
        JFileChooser fileChooser = new JFileChooser();

        // Mostrar o seletor de arquivos e verificar se o usuário escolheu um arquivo
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File inputFile = fileChooser.getSelectedFile();
            try {
                // Ler a imagem do arquivo selecionado
                image = ImageIO.read(inputFile);

                // Verificar se a imagem foi carregada corretamente
                if (image == null) {
                    System.out.println("Erro: O arquivo selecionado não é uma imagem válida.");
                    return;
                }

                // Criar e configurar a janela para exibir a imagem
                JFrame frame = new JFrame("Imagem Carregada");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(image.getWidth(), image.getHeight());

                // Adicionar um painel personalizado para desenhar a imagem
                frame.add(new ImagePanel());
                frame.setVisible(true);
            } catch (IOException e) {
                System.out.println("Erro ao ler o arquivo de imagem: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("Nenhum arquivo foi selecionado.");
        }
    }

    // Painel personalizado para desenhar a imagem
    static class ImagePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (image != null) {
                g.drawImage(image, 0, 0, this);
            }
        }
    }
}
