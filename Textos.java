import javax.swing.*;
import java.awt.*;

public class Textos extends JPanel {

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //Alguns Exemplos
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.BOLD, 36));
        g2d.drawString("ARIAL + NEGRITO", 50, 50);

        g2d.setColor(Color.MAGENTA);
        g2d.setFont(new Font("Times New Roman", Font.ITALIC, 30));
        g2d.drawString("TIMES NEW ROMAN + ITALICO", 50, 100);

        g2d.setColor(Color.BLUE);
        g2d.setFont(new Font("Verdana", Font.PLAIN, 33));
        g2d.drawString("VERDANA", 50, 150);

        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 28));
        g2d.drawString("COURIER NEW + NEGRITO + ITALICO ", 40, 200);

        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Comic Sans MS", Font.PLAIN, 32));
        g2d.drawString("COMIC SANS MS ", 50, 250);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Exemplo de manipulação de textos");
        Textos panel = new Textos();

        frame.add(panel);
        frame.setSize(600, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}