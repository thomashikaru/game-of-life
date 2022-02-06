import java.awt.event.KeyEvent;
import java.util.Arrays;

public class GameOfLife {

	// dimensions of screen
	private static int size = 30;
	
	// global variable: the boolean grid keeps track of which cells are live (true) and dead (false)
	private static boolean[][] grid;
	
	public static void main(String[] args) {

		// setup
		StdDraw.enableDoubleBuffering();
		StdDraw.setCanvasSize(1000, 1000);
		StdDraw.setPenRadius(0.001);
		
		// initialization phase
		// TODO: whenever user clicks mouse, set that cell to alive

		
		// simulation phase
		while (true) {
			StdDraw.clear();
			draw();
			update();
		}
	}
	
	// updates grid according to game of life rules
	public static void update() {
		// TODO: Your Code Here
	}
	
	// draw the 2D array to the screen
	public static void draw() {
		
		StdDraw.clear();
		
		// draw vertical gridlines
		for (int i = 1; i < size; i++) {
			StdDraw.line(i*1.0/size, 0, i*1.0/size, 1);
		}
		
		// draw horizontal gridlines
		for (int i = 1; i < size; i++) {
			StdDraw.line(0, i*1.0/size, 1, i*1.0/size);
		}
		
		// TODO: draw filled squares for each of the live cells. leave dead cells blank.
		
		
		
		StdDraw.show();
	}
	
	// helper method: return the number of live neighbors of the cell at row i, column j
	public static int numLiveNeighbors(int i, int j) {
		// TODO: Your Code Here
		return 0;
	}

}