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

  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
    // put your size call here
    size(500, 600);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(255,255,255);
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
	  
  }

  public void mousePressed(){
    
  }
}
