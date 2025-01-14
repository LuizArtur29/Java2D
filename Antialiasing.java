import javax.swing.*;
import java.awt.*;

public class Antialiasing extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Configurações para suavização (antialiasing)
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Desenhando retângulo
        g2d.setColor(Color.RED);
        g2d.fillRect(800, 90, 150, 300);

        // Desenhando oval
        g2d.setColor(Color.RED);
        g2d.fillOval(500, 450, 400, 200);

        // Aplicando rotação
        g2d.rotate(Math.toRadians(25), 100, 100);
        g2d.setColor(Color.ORANGE);
        g2d.fillRect(300, 20, 300, 300);

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Exemplo de Anti-aliasing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.add(new Antialiasing());
        frame.setVisible(true);
    }
}