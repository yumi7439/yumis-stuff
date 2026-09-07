import java.util.Random;
import java.util.Arrays;
import javax.swing.JFrame;

public class Grid {
	private boolean bombGrid[][];
	private int countGrid[][];
	private int numRows;
	private int numColumns;
	private int numBombs;
	
	public Grid() {
		this.numRows = 10;
		this.numColumns = 10;
		this.numBombs = 25;
		createBombGrid();
		createCountGrid();
	}
	public Grid(int rows, int columns) {
		this.numRows = rows;
		this.numColumns = columns;
		this.numBombs = 25;
		createBombGrid();
		createCountGrid();
	}
	public Grid(int rows, int columns, int numBombs) {
		this.numRows = rows;
		this.numColumns = columns;
		this.numBombs = numBombs;
		createBombGrid();
		createCountGrid();
	}
	
	
	
	 public static void main(String[] args) {
	 
	   

	    }
	 
private void createBombGrid() {
	Random random = new Random();
	bombGrid = new boolean [numRows][numColumns]; //all false by default so i deleted my double for loop that i used to make all buttons false first

		int bombPlaced = 0;
		while(bombPlaced < getNumBombs()) { 
			int bombRow = random.nextInt(numRows); //   generates random numbers from 0 to numRows - 1
			int bombColumn = random.nextInt(numColumns);
			
			if (!bombGrid[bombRow][bombColumn]) { // if the random location already has a bomb while loop continues to generate a new set of random numbers
				bombGrid[bombRow][bombColumn] = true; // before adding a bomb
				bombPlaced++;
			}
			
		}
		
		
		}

private void createCountGrid() {
    countGrid = new int[numRows][numColumns];

    for (int row = 0; row < numRows; row++) {
        for (int col = 0; col < numColumns; col++) { //starting with calculating count for [0][0] 

            int count = 0;  //initialize count to 0 before count for each numRows x numColumn buttons     //1,1 an arbitrary currentButton is represented by 
                                                                                       //(row = 1)+(allRow = 0),(col = 1)+(allCol = 0)
 // Check all adjacent 8 neighboring buttons and currentButton in the middle.                                   
            for (int allRow = -1; allRow <= 1; allRow++) {                           //(0,0),(0,1),(0,2)       
                for (int allCol = -1; allCol <= 1; allCol++) {                       //(1,0),(1,1),(1,2) 
                                                                                     //(2,0),(2,1),(2,2) 
                    int currRow = row + allRow;                                         
                    int currCol = col + allCol;  //inner double for loop is for checking the current button and all 8 neighbors

                    // make sure all neighbors are in bounds or having value indices before checking and incrementing count
                    if (currRow >= 0 && currRow < numRows && currCol >= 0 && currCol < numColumns) {
                        if (bombGrid[currRow][currCol]) {
                            count++;
                        }
                    }
                }
            }

            countGrid[row][col] = count;
        }
    }
}

	public int getNumRows() {
		return this.numRows;
	}
	public int getNumColumns() {
		return this.numColumns;
	}
	public int getNumBombs() {
		return this.numBombs;
	}
	public boolean[][] getBombGrid() {
	 
		    if (bombGrid == null) {
		        return null;
		    }
            final boolean[][] result = new boolean[bombGrid.length][];  //stickoverflow
		    for (int i = 0; i < bombGrid.length; i++) {
		        result[i] = Arrays.copyOf(bombGrid[i], bombGrid[i].length);
		        
		    }
		    return result;
		
	}
	public int[][] getCountGrid() {
		if (countGrid == null) {
	        return null;
	    }
        final int[][] result = new int[countGrid.length][];
	    for (int i = 0; i < countGrid.length; i++) {                 
	        result[i] = Arrays.copyOf(countGrid[i], countGrid[i].length);// stickoverflow
	        
	    }
	    return result;
	}
	public boolean isBombAtLocation(int row, int column) {
		
		return bombGrid[row][column];
	}
	public int getCountAtLocation(int row, int column) {
		return countGrid[row][column];
	}
	
	
   
}
