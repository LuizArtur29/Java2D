import javax.swing.*;
import java.awt.*;

public class ManipulacaoDeCores extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Cor sólida
        g2d.setColor(new Color(16, 58, 216, 255));
        g2d.fillRect(30, 50, 150, 100);

        // Texto atrás do segundo retângulo
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.BOLD, 11));
        g2d.drawString("Texto atrás do retângulo", 220, 100);

        // Cor com transparência
        g2d.setColor(new Color(239, 10, 10, 0));
        g2d.fillRect(210, 50, 150, 100);

        // Gradiante
        GradientPaint gradient = new GradientPaint(390, 50, Color.RED, 490, 50, Color.YELLOW);
        g2d.setPaint(gradient);
        g2d.fillRect(390, 50, 150, 100);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Exemplo de manipulação de cores");
        ManipulacaoDeCores panel = new ManipulacaoDeCores();

        frame.add(panel);
        frame.setSize(600, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}