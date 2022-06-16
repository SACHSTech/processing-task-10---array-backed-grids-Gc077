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
    DataGrid();
  }

  /**
   * 
   * Draws the grid and calculates values within the intGrid Integer Array.
   */
  public void GridDraw(){
    for (int intColumn = 0; intColumn < COLUMN_COUNT; intColumn++){
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
          if(intColumn < COLUMN_COUNT - 1 && intGrid[intRow][intColumn +1] == 0){

            intGrid[intRow][intColumn + 1] = 0;
            intSelectCount ++;
          }

          else if(intColumn < COLUMN_COUNT - 1 && intGrid[intRow][intColumn + 1] == 1){

            intGrid[intRow][intColumn + 1] = 0;
            intSelectCount --;
          }

          // Top block
          if(intRow > 0 && intGrid[intRow - 1][intColumn] == 0){

            intGrid[intRow - 1][intColumn] = 1;
            intSelectCount++;
          }

          else if(intRow > 0 && intGrid[intRow - 1][intColumn] == 0){

            intGrid[intRow - 1][intColumn] = 0;
            intSelectCount --;
          }

          //Bottom block
          if (intRow < ROW_COUNT - 1 && intGrid[intRow+1][intColumn] == 0){

            intGrid[intRow+1][intColumn] = 1;
            intSelectCount ++;
          }

          else if (intRow < ROW_COUNT - 1 && intGrid[intRow+1][intColumn] == 1){

            intGrid[intRow+1][intColumn] = 0;
            intSelectCount --;
            
          }

          // Output text to screen
          System.out.println(intSelectCount + " cells selected.");


          IsGridPressed = false;
        }
        if (intGrid[intRow][intColumn] == 1){

          fill(0, 255, 0); // Green

        }

        else{

          fill(255); // White
        }

        rect(MARGIN + (intColumn * (CELL_WIDTH + MARGIN)), MARGIN + (intRow * (CELL_HEIGHT + MARGIN)), CELL_WIDTH, CELL_HEIGHT);

        if (restart){
          for (int i = 0; i < COLUMN_COUNT; i++){
            for (int e = 0; e < ROW_COUNT; e++){
    
              intGrid[e][i] = 0;
            }
          }
        // Restart output values 
        intContinousGrid = 0;
        intRowSelectCount = 0;
        intSelectCount = 0;
        intColumnSelectCount = 0;
        }
      }
    }
  }
  /**
   * Data for rows, columns and continous selected blocks, outputs this data.
   * 
   */
  public void DataGrid(){
    if (IsGridPrint){

      for (int i = 0; i < ROW_COUNT; i++){
        for (int e = 0; e < COLUMN_COUNT; e++){
  
          if (intGrid[i][e] == 1){

            intRowSelectCount ++;
          }

          if (e < COLUMN_COUNT - 1){

            if (intGrid[i][e] == 1 && intGrid[i][e+1] == 1){

              intContinousGrid ++;
            }
          }

          if (e > 0 && e < COLUMN_COUNT){

            if (intGrid[i][e-1] == 1 && intGrid[i][e] == 1 && e == COLUMN_COUNT - 1){

              intContinousGrid ++;
            } 

            else if (intGrid[i][e-1] == 1 && intGrid[i][e] == 1 && intGrid[i][e+1] == 0 && e < COLUMN_COUNT - 1){

              intContinousGrid ++;
            }
          }
        }

        // Output the number of selected blocks that are continous
        if (intRowSelectCount > 2 && intContinousGrid > 0){

          System.out.println("There are " + intContinousGrid + " continuous blocks selected on the row " + i + ".");

        }
        // output the number of selected blocks in a row 
        System.out.println("The Row " + i + " has " + intRowSelectCount + " selected cells.");

        // Restart the values
        intRowSelectCount = 0;
        intContinousGrid = 0;
      } 

      for(int i = 0; i < COLUMN_COUNT; i ++){
        for(int e = 0; e < ROW_COUNT; e ++){

          if (intGrid[e][i] == 1){

            intColumnSelectCount ++;
          }
        }

        // Output the number of blocks selected in a column
        System.out.println("The column " + i + " has " + intColumnSelectCount + " cells selected.");

        intColumnSelectCount = 0;
      }

      IsGridPrint = false;
    }
  }
  public void mousePressed(){
    intMouseXGrid = mouseX / (CELL_WIDTH + MARGIN);
    intMouseYGrid = mouseY / (CELL_HEIGHT + MARGIN);
    IsGridPressed = true;
    IsGridPrint = true;
  }

  // Restart feature 
  public void keyPressed(){
    if (key == 'z'){

      restart = true;
    }
  }

  public void keyReleased(){
    if (key == 'z'){

      restart = false;
    }
  }
}
