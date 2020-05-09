// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a Onslow College 13DTC assignment.
// You may not distribute it in any other way without permission.

import ecs100.*;
import java.awt.Color;

/** A FlagStaff object represents a flag on a flagstaff.
 *   The flagstaff has a pole that is FLAGSTAFF_HEIGHT units high.
 *   It has a flag whose position can be anywhere from the bottom of the pole to 
 *   the top
 */
public class FlagStaff{
    //constants for dimensions of flag and flag staff
    public static final double FLAGSTAFF_HEIGHT = 300;  
    public static final double FLAG_SIZE = 30; 
    public static final double LEFT = 145; //horizontal distance to flag staff

    // fields for position of flag and flag staff        
    double flagStaffBase;   // position of the base of the flag staff
    double flagPosition;    // position of top of flag
    double groundPosition;  // position of the ground

    /** 
     * Constructor initialises the fields, but does not draw the flag.
     * @author Brook Thomson 
     * @param base a double for the position of the base of the flag staff 
     */
    public FlagStaff(double base) {
        flagStaffBase = base;
        flagPosition = base - FLAG_SIZE; // since flag starts at the base
        groundPosition = base + 1; // so ground is below pole
    }

    /** 
     * Redraw draws the flagstaff (a line) and the flag (a blue rectangle)
     * @author Brook Thomson
     */
    public void redraw() {
        UI.clearGraphics();
        UI.setColor(Color.black);
        UI.setLineWidth(3);
        UI.drawLine(LEFT, flagStaffBase, LEFT, flagStaffBase - FLAGSTAFF_HEIGHT);
        UI.setColor(Color.blue);
        UI.fillRect(LEFT + 1, flagPosition, FLAG_SIZE, FLAG_SIZE);
        UI.setColor(Color.green);
        UI.drawLine(10, groundPosition, 300, groundPosition);
    }     

    /** 
     * Raise changes the flag position field, but does not let it go over the top of 
     * the flagstaff. Does not redraw the flag.
     * @author Heather Harper
     * @param amountUp a double for the amount to raise the flag
     */
    public void raise(double amountUp) {
        flagPosition -= amountUp;       //- becuase top is y = 0
        if (flagPosition < (flagStaffBase - FLAGSTAFF_HEIGHT)){
            flagPosition = flagStaffBase - FLAGSTAFF_HEIGHT;
        }
    }

    /** 
     * Lower changes the flag position field, but does not let it go below the  
     * bottom of the flagstaff. Does not redraw the flag.
     * @author Heather Harper
     * @param amountDown a double for the amount to lower the flag
     */
    public void lower(double amountDown) {
        flagPosition += amountDown;     //+ becuase top is y = 0
        if (flagPosition > (flagStaffBase - FLAG_SIZE)) {
            flagPosition = flagStaffBase - FLAG_SIZE;
        }
    }
    
}
