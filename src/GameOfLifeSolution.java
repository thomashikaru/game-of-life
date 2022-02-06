import java.awt.event.KeyEvent;
import java.util.Arrays;

public class GameOfLifeSolution {

	private static int size = 30;
	private static int pause_millis = 50;
	private static boolean[][] grid;
	
	public static void main(String[] args) {

		// setup
		StdDraw.enableDoubleBuffering();
		StdDraw.setCanvasSize(1000, 1000);
		StdDraw.setPenRadius(0.001);
		grid = new boolean[size][size];
		
		// drawing phase
		boolean b = true;
		while (b) {
			draw();
			if (StdDraw.isMousePressed()) {
				double x = StdDraw.mouseX();
				double y = StdDraw.mouseY();
				int i = (int)((1-y)*grid.length);
				int j = (int)(x*grid[0].length);
				grid[i][j] = true;
			}
			if (StdDraw.isKeyPressed(KeyEvent.VK_SPACE)) {
				b = false;
			}
		}
		
		// main simulation loop
		while (true) {
			draw();
			update();
			StdDraw.pause(pause_millis);
		}
	}
	
	// updates grid according to game of life rules
	public static void update() {
		// make copy of grid
		boolean[][] newgrid = new boolean[size][size];
		
		// apply rules and makes changes to copy
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				int numNeighbors = numLiveNeighbors(i, j);
				if (!grid[i][j] && numNeighbors == 3) {
					newgrid[i][j] = true;
				}
				else if (grid[i][j] && (numNeighbors < 2 || numNeighbors > 3)) {
					newgrid[i][j] = false;
				}
				else {
					newgrid[i][j] = grid[i][j];
				}
			}
		}
		
		// update grid to copy
		grid = newgrid;
	}
	
	// draw the 2D array to the screen
	public static void draw() {
		double x = 0;
		double y = 0;
		double width = 1.0/size;
		double height = 1.0/size;
		
		StdDraw.clear();
		
		// draw vertical gridlines
		for (int i = 1; i < size; i++) {
			StdDraw.line(i*1.0/size, 0, i*1.0/size, 1);
		}
		
		// draw horizontal gridlines
		for (int i = 1; i < size; i++) {
			StdDraw.line(0, i*1.0/size, 1, i*1.0/size);
		}
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j]) {
					x = j*width + width/2.0;
					y = 1.0 - (i*height + height/2.0);
					StdDraw.filledRectangle(x, y, width/2.0, height/2.0);
				}
			}
		}
		StdDraw.show();
	}
	
	// calculate the number of live neighbors of the cell at row i, column j
	private static int numLiveNeighbors(int i, int j) {
		int result = 0;
		
		if (i > 0) {
			if (grid[i-1][j]) {
				result++;
			}
		}
		if (j > 0) {
			if (grid[i][j-1]) {
				result++;
			}
		}
		if (i < size-1) {
			if (grid[i+1][j]) {
				result++;
			}
		}
		if (j < size-1) {
			if (grid[i][j+1]) {
				result++;
			}
		}
		if (i > 0 && j > 0) {
			if (grid[i-1][j-1]) {
				result++;
			}
		}
		if (i < size-1 && j < size-1) {
			if (grid[i+1][j+1]) {
				result++;
			}
		}
		if (i > 0 && j < size-1) {
			if (grid[i-1][j+1]) {
				result++;
			}
		}
		if (i < size-1 && j > 0) {
			if (grid[i+1][j-1]) {
				result++;
			}
		}
		return result;
	}
}