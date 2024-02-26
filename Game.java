package com.demo.Snake;

	import java.awt.Point;
	import java.awt.event.KeyEvent;

	public class Game {
	    private Snake snake;
	    private Food food;
	    private boolean isGameOver;
	    private char currentDirection;

	    public Game() {
	        snake = new Snake(currentDirection, currentDirection);
	        food = new Food();
	        isGameOver = false;
	        currentDirection = 'R'; // Initial direction
	    }

	    public void handleInput(int key) {
	        switch (key) {
	            case KeyEvent.VK_UP:
	                if (currentDirection != 'D') // Prevent the snake from reversing
	                    currentDirection = 'U';
	                break;
	            case KeyEvent.VK_DOWN:
	                if (currentDirection != 'U')
	                    currentDirection = 'D';
	                break;
	            case KeyEvent.VK_LEFT:
	                if (currentDirection != 'R')
	                    currentDirection = 'L';
	                break;
	            case KeyEvent.VK_RIGHT:
	                if (currentDirection != 'L')
	                    currentDirection = 'R';
	                break;
	        }
	    }

	    public void update() {
	        if (!isGameOver) {
	            snake.move();

	            // Check for collisions with food
	            if (snake.getHead().equals(food.getPosition())) {
	                snake.grow();
	                food.generatePosition();
	            }

	            // Check for collisions with itself or game board boundaries
	            if (snake.checkCollision() || snake.checkBoundaries()) {
	                isGameOver = true;
	            }
	        }
	    }
	}



