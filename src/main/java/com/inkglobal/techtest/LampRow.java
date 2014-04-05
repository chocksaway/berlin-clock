package com.inkglobal.techtest;

import com.inkglobal.util.LookupUtil;

/**
 * Created with IntelliJ IDEA.
 * User: milesd
 * Date: 03/04/2014
 * Time: 11:04
 *
 */
public class LampRow implements LampBase {
    private Colour  colour;
    private Time    time;
    private int timeMultiplier;

    private int total;
    private int pos=0;

    private static final String HHMM_FORMAT = "00";

    /**
     * Get the time for the for a lamp row
     * Call this method recursively going through each lamp sequentially left to right
     *
     * @param expression - row of lights
     * @return - the total number of hours for the row of lights
     */
    public int getTime(String expression) {
        //System.out.println(pos + " " + expression.substring(pos,pos+1) + " " + colour);

        if (LookupUtil.lookup(Colour.class, expression.substring(pos,pos+1)) != null) {
            total += timeMultiplier;
        }
        pos++;

        if (pos < expression.length()) {
            getTime(expression);
        }

        return total;
    }

    public static String ensureTimeUnitIsHHMM(int total) {
        if (total == 0 ) {
            return HHMM_FORMAT;
        }
        return Integer.toString(total);
    }

    /**
     * Set the specific (time) value for each lamp
     * @param value
     */
    public void setEachLampTimeValue(int value) {
        this.timeMultiplier = value;
    }

    /**
     * Set the lamp colour
     * @param lampColour
     */
    public void setLampColour(String lampColour) {
        this.colour = Colour.valueOf(lampColour);
    }

    /**
     * Set the unit of time.  Hours, minutes, seconds.
     * @param timeUnit
     */
    public void setTimeUnit(String timeUnit) {
        this.time = Time.valueOf(timeUnit);
    }


}
