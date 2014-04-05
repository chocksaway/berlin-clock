package com.inkglobal.techtest;

/**
 * Created with IntelliJ IDEA.
 * User: milesd
 * Date: 03/04/2014
 * Time: 11:00
 * Basic lamp details.
 */
public interface LampBase {
    enum Colour { R, Y }
    enum Time { HOUR, MINUTE, SECOND }
    int timeMultiplier=0;

    public int getTime(String expression);

    public void setEachLampTimeValue(int value);

    public void setLampColour(String r);

    public void setTimeUnit(String hour);
}
