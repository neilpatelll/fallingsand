import java.awt.*;
import java.util.*;

public class SandLab {
   public static void main(String[] args) {
       SandLab lab = new SandLab(120, 80);
       lab.run();
   }

   // add constants for particle types here
   public static final int E = 0;
   public static final int M = 1;
   public static final int S = 2;
   public static final int W = 3;

   // do not add any more fields
   private int[][] grid;
   private SandDisplay display;  //SandDisplay is the GUI class

   public SandLab(int rows, int cols) {
       String[] names;
       names = new String[4];
       names[E] = "Empty";
       names[M] = "Metal";
       names[S] = "Sand";
       names[W] = "Water";
       display = new SandDisplay("Falling Sand", rows, cols, names);
       grid = new int[rows][cols];
   }

	/** called when the user clicks on a location using the given tool */
   private void locationClicked(int row, int col, int tool) {
       grid[row][col] = tool;
   }

	/** copies each element of grid into the display */
   public void updateDisplay() {
       for (int r = 0; r < grid.length; r++) {
           for (int c = 0; c < grid[r].length; c++) {
               switch (grid[r][c]) {
               case E:
                   display.setColor(r, c, new Color(0, 0, 0));
                   break;
               case M:
                   display.setColor(r, c, new Color(128, 128, 128));
                   break;
               case S:
                   display.setColor(r, c, new Color(255, 255, 0));
                   break;
               case W:
                   display.setColor(r, c, new Color(0, 0, 255));
                   break;
               default:
                   display.setColor(r, c, new Color(0, 0, 0));
               }

           }
       }
   }

	/** called repeatedly, causes one random particle to maybe do something */
   public void step() {
       Random rand = new Random();
       int row = rand.nextInt(grid.length);
       int col = rand.nextInt(grid[row].length);
       int cell = grid[row][col];

       if (cell == S) {
           if (row + 1 < grid.length && grid[row + 1][col] == E) {
               grid[row + 1][col] = grid[row][col];
               grid[row][col] = E;
           }
           else if(row + 1 < grid.length && grid[row + 1][col] == W) {
               int tmpCell = grid[row][col]; // save SAND
               grid[row][col] = grid[row+1][col]; // WATER to SAND
               grid[row+1][col] = tmpCell; // SAND to WATER
              
           }
       }
       if (cell == W) {
           //DOWN
           if (row + 1 < grid.length && grid[row + 1][col] == E) {
               grid[row + 1][col] = grid[row][col];
               grid[row][col] = E;
           }
           //LEFT
           if(col - 1 >= 0 && grid[row][col-1] == E) {
               grid[row][col-1] = grid[row][col];
               grid[row][col] = E;              
           }
           //RIGHT
           if(col + 1 < grid[row].length && grid[row][col+1] == E) {
               grid[row][col+1] = grid[row][col];
               grid[row][col] = E;              
           }
       }
   }

   // do not modify
   public void run() {
       while (true) {
           for (int i = 0; i < display.getSpeed(); i++)
               step();
           updateDisplay();
           display.repaint();
           display.pause(1); 
           int[] mouseLoc = display.getMouseLocation();
           if (mouseLoc != null) 
               locationClicked(mouseLoc[0], mouseLoc[1], display.getTool());
       }
   }
}