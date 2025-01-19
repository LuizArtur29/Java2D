import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class SimpleGame extends JPanel{
    private BufferedImage buffer;
    private boolean gameOver = false;
    private int width = 600, height = 400;
    private int score = 0;
    private Timer timer;
    //Jogador
    private int playerX = width / 2;
    private int playerY = height / 2;
    private int playerSize = 50;
    //Inimigo
    private int enemyX = 100;
    private int enemyY = 100;
    private int enemySize = 50;
    private int enemySpeedX = 10;
    private int enemySpeedY = 10;

    public SimpleGame() {
        buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (!gameOver) {
                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_W -> playerY -= 15;
                        case KeyEvent.VK_S -> playerY += 15;
                        case KeyEvent.VK_A -> playerX -= 15;
                        case KeyEvent.VK_D -> playerX += 15;
                    }
                    repaint(); // Atualiza a tela após mover o jogador
                }
            }
        });
        setFocusable(true);
        requestFocusInWindow();

        timer = new Timer(16, e -> gameLoop()); // Chamando gameLoop a cada 16ms (~60 FPS)
        timer.start();
    }

    public int getScore() {
        return score;
    }

    private void gameLoop() {
        if (!gameOver) {
            moveEnemy();
            checkCollision();
            repaint();
            score++;
        }
    }

    private void moveEnemy() {
        enemyX += enemySpeedX;
        enemyY += enemySpeedY;
        // Bater nas bordas
        if (enemyX <= 0 || enemyX >= width - enemySize) {
            enemySpeedX = -enemySpeedX;
        }
        if (enemyY <= 0 || enemyY >= height - enemySize) {
            enemySpeedY = -enemySpeedY;
        }
    }

    private void checkCollision() {
        // Verifica colisão entre jogador e inimigo
        if (playerX < enemyX + enemySize && playerX + playerSize > enemyX &&
                playerY < enemyY + enemySize && playerY + playerSize > enemyY) {
            gameOver = true;
            timer.stop();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        setBackground(Color.BLACK);

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(buffer, 0, 0, null);

        //JOGADOR
        g2d.setColor(Color.BLUE);
        g2d.fillRect(playerX, playerY, playerSize, playerSize);
        //INIMIGO
        g2d.setColor(Color.RED);
        g2d.fillOval(enemyX, enemyY, enemySize, enemySize);
        //HUD
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Serif", Font.BOLD, 24));
        int score = getScore();
        g2d.drawString("Score: " + score, 10, 30);
        //GAMEOVER
        if (gameOver) {
            g2d.setColor(Color.WHITE);
            g2d.setFont(new Font("Serif", Font.BOLD, 36));
            g2d.drawString("Game Over", width / 2 - 100, height / 2);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Game");
        SimpleGame gamePanel = new SimpleGame();
        frame.add(gamePanel);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        // Simular um loop de jogo simples que redesenha a cada 16ms (~60 FPS)
        Timer timer = new Timer(16, e -> gamePanel.repaint());
        timer.start();
    }
}