// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a Onslow College 13DTC assignment.
// You may not distribute it in any other way without permission.

/* Exercise for Onslow College 13DTC
 * Name:
 * Email:
 * Date:
 */
import ecs100.*;
import java.awt.Color;

/** A FlagStaff object represents a flag on a flagstaff.
 *   The flagstaff has a pole that is FLAGSTAFF_HEIGHT units high.
 *   It has a flag whose position can be anywhere from the bottom of the pole to the top

 *   The constructor specifies the position of the base of the flagstaff.

 *   The bottom left corner of the flag is initially at the bottom of the pole.
 *   The flag is FLAG_SIZE units high.
 *   The flag can be raised or lowered.
 *
 *   The flag can be as simple as a blue square, but you can draw a more fancy flag if you want
 *
 *   The class has three methods:
 *     - raise(double dist), which changes the flag position on the staff but does not let it go over the top of the flagstaff
 *     - lower(double dist), which changes the flag position on the staff but does not let it go below the bottom of the flagstaff.
 *           Both methods change the field, but do not redraw the flag.
 *     - redraw() which draws the flagstaff [UI.drawLine(....)] and the flag [UI.fillRect(....)]
 */
public class FlagStaff{

    public static final double FLAGSTAFF_HEIGHT = 300;  
    public static final double FLAG_SIZE = 30; 
    public static final double LEFT = 145; //horizontal distance to flag staff

    // fields,           
    double flagStaffBase;   // position of the base of the flag staff
    double flagPosition;    // position of top of flag
    double groundPosition;  // position of the ground

    /** Constructor:
     * Parameters: the position of the base of the flag staff
     * Initialises the fields, but does not draw the flag.
     */
    public FlagStaff(double base) {
        flagStaffBase = base;
        flagPosition = base - FLAG_SIZE; // since flag starts at the base
        groundPosition = base + 1; // so ground is below pole
    }

    /** redraw method:
     * Draws the flagstaff (a line) and the flag (a blue rectangle)*/
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

    /** raise method:
     * Parameter:  amount to raise the flag
     * Changes the field, but does not let it go over the top of the flagstaff.
     * Does not redraw the flag.
     */
    public void raise(double amountUp) {
        flagPosition -= amountUp;       //- becuase top is y = 0
        if (flagPosition < (flagStaffBase - FLAGSTAFF_HEIGHT)){
            flagPosition = flagStaffBase - FLAGSTAFF_HEIGHT;
        }
    }

    /** lower method:
     * Parameter:  amount to lower the flag
     * Changes the field, but does not let it go below the bottom of the flagstaff.
     * Does not redraw the flag.
     */
    public void lower(double amountDown) {
        flagPosition += amountDown;     //+ becuase top is y = 0
        if (flagPosition > (flagStaffBase - FLAG_SIZE)) {
            flagPosition = flagStaffBase - FLAG_SIZE;
        }
    }
    
}
