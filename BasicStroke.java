import javax.swing.*;
import java.awt.*;

public class BasicStroke extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Define uma linha simples com traço padrão
        g2d.setStroke(new java.awt.BasicStroke(2.0f)); // Espessura 2px
        g2d.setColor(Color.BLUE);
        g2d.drawLine(50, 50, 520, 50);

        // Define uma linha com espessura maior e pontas arredondadas
        g2d.setStroke(new java.awt.BasicStroke(8.0f, java.awt.BasicStroke.CAP_ROUND, java.awt.BasicStroke.JOIN_BEVEL));
        g2d.setColor(Color.RED);
        g2d.drawLine(50, 150, 520, 150);

        // Define uma linha tracejada
        float[] dashPattern = {10.0f, 5.0f}; // Traços de 10px seguidos por espaços de 5px
        g2d.setStroke(new java.awt.BasicStroke(4.0f, java.awt.BasicStroke.CAP_BUTT, java.awt.BasicStroke.JOIN_MITER, 10.0f, dashPattern, 0.0f));
        g2d.setColor(Color.GREEN);
        g2d.drawLine(50, 250, 520, 250);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Exemplo de BasicStroke");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new BasicStroke());
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
