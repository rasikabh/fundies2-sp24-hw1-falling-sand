package student;

import java.awt.*;
import java.util.*;


/**
 * Keeps track of the functionality of a display on which a user can draw falling sand (and other
 * particles).
 */
public class SandLab {

  public static void main(String[] args) {
    SandLab lab = new SandLab(NUM_ROWS, NUM_COLS);
    lab.run();
  }

  protected final SandDisplay display;
  public static final int NUM_ROWS = 120;
  public static final int NUM_COLS = 80;
  private final Random rand;

  public SandLab(int numRows, int numCols) {
    display = new SandDisplay("Falling Sand", numRows, numCols);
    rand = new Random();
  }

  /**
   * Updates the value in the grid to reflect the user painting that pixel using the given tool.
   *
   * @param row  row where the user clicked
   * @param col  column where the user clicked
   * @param tool Particle tool with which the user is painting. If the user is erasing, the tool is
   *             null.
   */
  protected void locationClicked(int row, int col, Particle tool) {
  }

  /**
   * Updates the display to show the right color in each pixel in the grid
   */
  public void updateDisplay() {
  }

  /**
   * Chooses a random spot on the grid, and if it contains a
   * particle, then moves that particle in a manner appropriate to the particle type.
   */
  public void step() {
  }

  /**
   * Keeps the program running (updating the display based on mouseclicks) until the user quits the
   * program.
   */
  public void run() {
    while (true) {
      for (int i = 0; i < display.getSpeed(); i++) {
        step();
      }
      updateDisplay();
      display.repaint();
      display.pause(1);  //wait for redrawing and for mouse
      int[] mouseLoc = display.getMouseLocation();
      if (mouseLoc != null) { //test if mouse clicked
        locationClicked(mouseLoc[0], mouseLoc[1], display.getTool());
      }
    }
  }
}
