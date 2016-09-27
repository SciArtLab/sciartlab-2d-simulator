package com.xmunch.processing.testing;

import java.util.HashMap;
import java.util.Map;

import processing.core.PApplet;

public class CellularAutomata extends PApplet {

    Map<String, Cell> cellList = new HashMap<String, Cell>();

    // Size of cells
    int cellSize = 5;

    // How likely for a cell to be alive at start (in percentage)
    float probabilityOfAliveAtStart = 15;

    // Variables for timer
    int interval = 100;
    int lastRecordedTime = 0;

    // Pause
    boolean pause = false;

    @Override
    public void settings() {
        size(640, 360);
    }

    @Override
    public void setup() {

        // This stroke will draw the background grid
        stroke(48);

        // Initialization of cells
        for (int x = 0; x < width / cellSize; x++) {
            for (int y = 0; y < height / cellSize; y++) {
                float state = random(100);
                if (state > probabilityOfAliveAtStart) {
                    state = 0;
                } else {
                    state = 1;
                }
                Cell cell = cellList.get(x + "," + y);
                if (cell == null)
                    cell = new Cell();
                cell.setState(state);
                cellList.put(x + "," + y, cell); // Save state of each cell
            }
        }
        background(9); // Fill in black in case cells don't cover all the windows
    }

    @Override
    public void draw() {

        // Draw grid
        for (int x = 0; x < width / cellSize; x++) {
            for (int y = 0; y < height / cellSize; y++) {
                if (cellList.get(x + "," + y).getState() == 1) {
                    fill(CellState.alive.getColor()); // If alive

                } else {
                    fill(CellState.dead.getColor()); // If dead
                }
                ellipse(x * cellSize, y * cellSize, cellSize, cellSize);

            }
        }
        // Iterate if timer ticks
        if (millis() - lastRecordedTime > interval) {
            if (!pause) {
                iteration();
                lastRecordedTime = millis();
            }
        }

        // Create new cells manually on pause
        if (pause && mousePressed) {
            // Map and avoid out of bound errors
            int xCellOver = (int) map(mouseX, 0, width, 0, width / cellSize);
            xCellOver = constrain(xCellOver, 0, width / cellSize - 1);
            int yCellOver = (int) map(mouseY, 0, height, 0, height / cellSize);
            yCellOver = constrain(yCellOver, 0, height / cellSize - 1);

            // Check against cells in buffer
            if (cellList.get(xCellOver + "," + yCellOver).getState() == 1) { // Cell is alive
                cellList.get(xCellOver + "," + yCellOver).setState(0); // Kill
                fill(CellState.dead.getColor()); // Fill with kill color
            } else { // Cell is dead
                cellList.get(xCellOver + "," + yCellOver).setState(1); // Make alive
                fill(CellState.alive.getColor()); // Fill alive color
            }
        }
    }

    void iteration() {

        // Visit each cell:
        for (int x = 0; x < width / cellSize; x++) {
            for (int y = 0; y < height / cellSize; y++) {
                // And visit all the neighbours of each cell
                int neighbours = 0; // We'll count the neighbours
                for (int xx = x - 1; xx <= x + 1; xx++) {
                    for (int yy = y - 1; yy <= y + 1; yy++) {
                        if (((xx >= 0) && (xx < width / cellSize)) && ((yy >= 0) && (yy < height / cellSize))) { // Make
                                                                                                                 // sure
                                                                                                                 // you
                                                                                                                 // are
                                                                                                                 // not
                                                                                                                 // out
                                                                                                                 // of
                                                                                                                 // bounds
                            if (!((xx == x) && (yy == y))) { // Make sure to to check against self
                                if (cellList.get(xx + "," + yy).getState() == 1) {
                                    neighbours++; // Check alive neighbours and count them
                                }
                            } // End of if
                        } // End of if
                    } // End of yy loop
                } // End of xx loop
                  // We've checked the neigbours: apply rules!
                if (cellList.get(x + "," + y).getState() == 1) { // The cell is alive: kill it if
                                                                 // necessary
                    if (neighbours < 2 || neighbours > 3) {
                        cellList.get(x + "," + y).setState(0); // Die unless it has 2 or 3
                                                               // neighbours
                    }
                } else { // The cell is dead: make it live if necessary
                    if (neighbours == 3) {
                        cellList.get(x + "," + y).setState(1); // Only if it has 3 neighbours
                    }
                } // End of if
            } // End of y loop
        } // End of x loop
    } // End of function

    @Override
    public void keyPressed() {
        if (key == 'r' || key == 'R') {
            // Restart: reinitialization of cells
            for (int x = 0; x < width / cellSize; x++) {
                for (int y = 0; y < height / cellSize; y++) {
                    float state = random(100);
                    if (state > probabilityOfAliveAtStart) {
                        state = 0;
                    } else {
                        state = 1;
                    }
                    cellList.get(x + "," + y).setState(state); // Save state of each cell
                }
            }
        }
        if (key == ' ') { // On/off of pause
            pause = !pause;
        }
        if (key == 'c' || key == 'C') { // Clear all
            for (int x = 0; x < width / cellSize; x++) {
                for (int y = 0; y < height / cellSize; y++) {
                    cellList.get(x + "," + y).setState(0); // Save all to zero
                }
            }
        }
    }
}
