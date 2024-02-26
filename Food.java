package com.demo.Snake;

	import java.awt.Point;
	import java.util.Random;

	public class Food {
	    private Point position;

	    public Food() {
	        position = new Point();
	        generatePosition();
	    }

	    public Point getPosition() {
	        return position;
	    }

	    public void generatePosition() {
	        Random random = new Random();
	        position.x = random.nextInt(GameBoard.BOARD_WIDTH);
	        position.y = random.nextInt(GameBoard.BOARD_HEIGHT);
	    }
	}

