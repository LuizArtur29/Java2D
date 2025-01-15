import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class FormasBasicas extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Desenho de um retângulo
        g2d.setColor(Color.BLUE);
        g2d.fill(new Rectangle2D.Double(20, 20, 200, 150));

        // Desenho de uma elipse
        g2d.setColor(Color.RED);
        g2d.fill(new Ellipse2D.Double(290, 20, 200, 150));

        // Desenhando um Arco
        g2d.setColor(Color.GREEN);
        g2d.fill(new Arc2D.Double(520, 20, 300, 260, 0, 180, Arc2D.OPEN));

        // Desenho de uma linha
        g2d.setColor(Color.BLACK);
        g2d.draw(new Line2D.Double(20, 250, 220, 280));

        // Desenhando uma curva quadrática
        QuadCurve2D quadCurve = new QuadCurve2D.Double(300, 250, 400, 350, 500, 280);
        g2d.draw(quadCurve);

        // Desenhando uma curva cúbica
        CubicCurve2D cubicCurve = new CubicCurve2D.Double(600, 250, 750, 400, 450, 550, 820, 400);
        g2d.draw(cubicCurve);

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Exemplo de formas básicas");
        FormasBasicas panel = new FormasBasicas();

        frame.add(panel);
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}