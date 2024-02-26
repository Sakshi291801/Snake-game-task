package com.demo.Snake;
	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.event.KeyEvent;
	import java.awt.event.KeyListener;

	public class GamePanel extends JPanel implements ActionListener, KeyListener {

	    private static final int TILE_SIZE = 20;
	    private static final int BOARD_WIDTH = 30;
	    private static final int BOARD_HEIGHT = 20;
	    private static final int INITIAL_SNAKE_LENGTH = 3;
	    private static final int GAME_SPEED = 100; // Milliseconds per frame

	    private final Snake snake;
	    private final Food food;
	    private final Timer timer;
	    private boolean isGameOver;
	    private int score;


	    public GamePanel() {
	        setPreferredSize(new Dimension(TILE_SIZE * BOARD_WIDTH, TILE_SIZE * BOARD_HEIGHT));
	        setBackground(Color.BLACK);
	        setFocusable(true);
	        addKeyListener(this);

	        snake = new Snake();
	        food = new Food();
	        timer = new Timer(GAME_SPEED, this);
	        isGameOver = false;
	        score = 0;

	        timer.start();
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);

	        if (isGameOver) {
	            displayGameOver(g);
	        } else {
	            drawSnake(g);
	            drawFood(g);
	        }
	    }

	    private void drawSnake(Graphics g) {
	        g.setColor(Color.GREEN);
	        for (Point segment : snake.getBody()) {
	            g.fill3DRect(segment.x * TILE_SIZE, segment.y * TILE_SIZE, TILE_SIZE, TILE_SIZE, true);
	        }
	    }

	    private void drawFood(Graphics g) {
	        g.setColor(Color.RED);
	        g.fillOval(food.getPosition().x * TILE_SIZE, food.getPosition().y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
	    }

	    private void displayGameOver(Graphics g) {
	        g.setColor(Color.WHITE);
	        g.setFont(new Font("Arial", Font.BOLD, 30));
	        g.drawString("Game Over", TILE_SIZE * 5, TILE_SIZE * 10);
	        g.drawString("Score: " + score, TILE_SIZE * 5, TILE_SIZE * 12);
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
	        if (!isGameOver) {
	            snake.move();
	            if (snake.checkCollision() || snake.checkBoundaries()) {
	                isGameOver = true;
	            } else if (snake.getHead().equals(food.getPosition())) {
	                snake.grow();
	                food.generatePosition();
	                score++;
	            }
	            repaint();
	        }
	    }

	    @Override
	    public void keyTyped(KeyEvent e) {}

		
		int DirectionUP;
	   
	    public void keyPressed(KeyEvent e) {
	        int key = e.getKeyCode();
			if (key == KeyEvent.VK_UP && snake.getDirection() != Direction.DOWN) {
	            snake.setDirection(Direction.UP);
	        } else if (key == KeyEvent.VK_DOWN && snake.getDirection() != Direction.UP) {
	            snake.setDirection(Direction.DOWN);
	        } else if (key == KeyEvent.VK_LEFT && snake.getDirection() != Direction.RIGHT) {
	            snake.setDirection(Direction.LEFT);
	        } else if (key == KeyEvent.VK_RIGHT && snake.getDirection() != Direction.LEFT) {
	            snake.setDirection(Direction.RIGHT);
	        }
	    }

	    @Override
	    public void keyReleased(KeyEvent e) {}

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> {
	            JFrame frame = new JFrame("Snake Game");
	            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            frame.setResizable(false);
	            frame.add(new GamePanel(), BorderLayout.CENTER);
	            frame.pack();
	            frame.setLocationRelativeTo(null);
	            frame.setVisible(true);
	        });
	    }
	}


