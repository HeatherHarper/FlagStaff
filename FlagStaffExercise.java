// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a Onslow College 13DTC assignment.
// You may not distribute it in any other way without permission.

import ecs100.*;
import java.awt.Color;

/** 
 * FlagStaffExercise drives the FlagStaff class
 */

public class FlagStaffExercise {

    private static final double GROUND = 400;
    private FlagStaff flag1 = new FlagStaff(GROUND); 
    private double raiseAmount; // distance to raise/lower flag from Amount slider
    
    /** 
     * doFlagStaff raises the flag up then down by random amounts
     */
    public void doFlagStaff(){        
        this.clear();

        flag1.redraw();
        UI.sleep(500);

        int steps = 0;
        UI.println("Make flags go up");
        while (steps < 8){
            // make flags go up by a random amount 
            flag1.raise(Math.random()*100);

            UI.clearGraphics();
            flag1.redraw();

            UI.sleep(500);
            steps++;   //(shorthand for steps = steps + 1;
        }
        UI.println("Make flags go down");
        while (steps> 0){
            // make flags go down by a random fraction
            flag1.lower(Math.random()*100);

            UI.clearGraphics();
            flag1.redraw();

            UI.sleep(500);
            steps--;   //(shorthand for steps = steps - 1;
        }
    }
    
    /**
     * clears the GUI
     */
    public void clear(){
        UI.clearPanes();
    }

    /** 
     * doRaise calls raise method then redraws the flag
     * @author Heather Harper
     */
    private void doRaise() {
        flag1.raise(raiseAmount);
        flag1.redraw();
    }
    
    /** 
     * doLower calls lower method then redraws the flag
     * @author Heather Harper
     */
    private void doLower() {
        flag1.lower(raiseAmount);
        flag1.redraw();
    }    
        
    /** 
     * setAmount sets the raiseAmount feild for raising/lowering flag
     * @author William Kho
     * @param amount a double from the amount slider
     */
    private void setAmount(double amount) {
        this.raiseAmount = amount;
    }
    
    /** 
     * print the country the user entered in textfield
     * @author Chris Sa
     * @param country a String taken from a textfield using GUI
     */
    public void printCountry(String country) {
        UI.setColor(Color.black);
        UI.drawString(country, 100, GROUND + 50);
    }
    
    /** 
     * main method for FlagStaff project, sets up GUI by adding buttons, textfeild
     * and slider
     * @author William Kho
     */
    public static void main(String[] args){
        FlagStaffExercise fse = new FlagStaffExercise();
        UI.addButton("Clear", fse::clear );
        UI.addButton("FlagStaff", fse::doFlagStaff );
        
        final int AMOUNTMIN = 0;
        final int AMOUNTMAX = 100;
        final int AMOUNTINT = 0;
        
        // Add buttons, textfield, slider
        UI.addButton("Raise", fse::doRaise);
        UI.addButton("Lower", fse::doLower);
        UI.addSlider("Amount", AMOUNTMIN, AMOUNTMAX, AMOUNTINT, fse::setAmount);
        UI.addTextField("Country", fse::printCountry);
        
        
        
        UI.addButton("Quit", UI::quit );        
    }

}
