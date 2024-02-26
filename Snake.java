package com.demo.Snake;

import java.awt.Point;
import java.util.ArrayList;

	public class Snake {
	    private int length;
	    private char direction;
	    private ArrayList<Point> body;

	    public Snake(int initialLength, char initialDirection) {
	        this.length = initialLength;
	        this.direction = initialDirection;
	        this.body = new ArrayList<>();
	        // Initialize the snake body at a specific starting position
	        // For example, if the game board is 10x10, starting at position (5,5) and moving right
	        int startX = 5;
	        int startY = 5;
	        for (int i = 0; i < initialLength; i++) {
	            body.add(new Point(startX - i, startY));
	        }
	    }



		// Method to move the snake
	    public void move() {
	        // Move the snake's head based on the current direction
	        Point head = body.get(0);
	        int newHeadX = (int) head.getX();
	         int newHeadY = (int) head.getY();
	        switch (direction) {
	            case 'U':
	                newHeadY--;
	                break;
	            case 'D':
	                newHeadY++;
	                break;
	            case 'L':
	                newHeadX--;
	                break;
	            case 'R':
	                newHeadX++;
	                break;
	        }
	        // Add the new head to the snake's body
	        body.add(0, new Point(newHeadX, newHeadY));
	        // Remove the tail to maintain the snake's length
	        if (body.size() > length) {
	            body.remove(body.size() - 1);
	        }
	    }

	    // Method to check for collisions
	    public boolean checkCollision() {
	        // Implement collision detection logic here
	        // For example, check if the snake's head collides with its body or the game board boundaries
	        return false; // Placeholder
	    }

	    // Method to grow the snake when it eats food
	    public void grow() {
	        length++; // Increase the length of the snake
	        // Add a new segment to the snake's body at the current tail position
	        Point p = body.get(body.size() - 1);
	        body.add(new Point());

	    }

	    // Getters and setters for length and direction properties
	    public int getLength() {
	        return length;
	    }

	    public char getDirection() {
	        return direction;
	    }

	    public void setDirection(char direction) {
	        this.direction = direction;
	    }

		public Point[] getBody() {
			// TODO Auto-generated method stub
			return null;
		}

		public boolean checkBoundaries() {
			// TODO Auto-generated method stub
			return false;
		}



		public Object getHead() {
			// TODO Auto-generated method stub
			return null;
		}

	    // Other methods as needed
	}



