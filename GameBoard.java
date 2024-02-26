package com.demo.Snake;

public class GameBoard {
	
	    public static final int BOARD_WIDTH = 0;
		public static int BOARD_HEIGHT;
		private final int width;
	    private final int height;
	    private char[][] board;

	    public GameBoard(int width, int height) {
	        this.width = width;
	        this.height = height;
	        this.board = new char[height][width];
	        initializeBoard();
	    }

	    private void initializeBoard() {
	        for (int row = 0; row < height; row++) {
	            for (int col = 0; col < width; col++) {
	                // Initialize empty cells
	                board[row][col] = ' ';
	            }
	        }
	    }

}
