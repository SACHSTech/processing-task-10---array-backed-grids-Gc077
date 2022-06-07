import processing.core.PApplet;

/**
 * This program draws an interactive grid
 * @author Garv Choudhry
 */

public class Sketch extends PApplet {
	
  // Declare global variables 
  int CELL_WIDTH = 20;
  int CELL_HEIGHT = 20;
  int MARGIN = 5;
  int ROW_COUNT = 10;
  int COLUMN_COUNT = 10;
  int SCREEN_WIDTH = (CELL_WIDTH + MARGIN) * COLUMN_COUNT + MARGIN;
  int SCREEN_HEIGHT = (CELL_HEIGHT + MARGIN) * ROW_COUNT + MARGIN;
  int intMouseXGrid;
  int intMouseYGrid;

  boolean IsGridPressed = false;
  boolean IsGridPrint = false;

  int intSelectCount;
  int intRowSelectCount;
  int intColumnSelectCount;
  int intContinousGrid;

  boolean restart;

  // Array 
  int[][] intGrid = new int[ROW_COUNT][COLUMN_COUNT];

  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
    // put your size call here
    size(SCREEN_WIDTH, SCREEN_HEIGHT);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(0);
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
	  GridDraw();
    GridDetails();
  }

  /**
   * 
   * Draws the grid and calculates values within the intGrid Integer Array.
   */
  public void GridDraw(){
    for (int intColumn = 0 < COLUMN_COUNT; intColumn++){
      for (int intRow = 0; intRow < ROW_COUNT; intRow++){
        if(IsGridPressed && intMouseXGrid == intColumn && intMouseYGrid == intRow){
          // Center Block
          if (intGrid[intRow][intColumn] == 0){
            intGrid[intRow][intColumn] = 1;
            intSelectCount++;
          }
          else if (intGrid[intRow][intColumn] == 1){
            intGrid[intRow][intColumn] = 0;
            intSelectCount --;
          }

          // Left Block
          if (intColumn > 0 && intGrid[intRow][intColumn - 1] == 0){
            intGrid[intRow][intColumn - 1] = 1;
            intSelectCount ++;
          }
          else if (intColumn > 0 && intGrid[intRow][intColumn-1] == 1){
            intGrid[intRow][intColumn-1] = 0;
            intSelectCount --;
          }

          // Right Block
        }
      }
    }
  }
  public void mousePressed(){
    
  }
}
