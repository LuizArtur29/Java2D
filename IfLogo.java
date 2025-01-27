import javax.swing.*;
import java.awt.*;

public class IfLogo extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Configurações de renderização (opcional, para melhorar a qualidade)
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Desenhando um círculo
        g2d.setColor(Color.RED);
        g2d.fillOval(50, 80, 100, 100);

        // Desenhando um retângulo
        g2d.setColor(Color.GREEN);
        g2d.fillRect(180, 80, 100, 100);
        g2d.fillRect(310, 80, 100, 100);
        g2d.fillRect(180, 200, 100, 100);
        g2d.fillRect(50, 200, 100, 100);
        g2d.fillRect(180, 320, 100, 100);
        g2d.fillRect(50, 320, 100, 100);
        g2d.fillRect(310, 320, 100, 100);
        g2d.fillRect(180, 440, 100, 100);
        g2d.fillRect(50, 440, 100, 100);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Instituto Federal");
        IfLogo ifLogo = new IfLogo();

        frame.add(ifLogo);
        frame.setSize(500, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}