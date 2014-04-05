package com.inkglobal.techtest;

import com.inkglobal.util.SplitUtil;

/**
 * Created with IntelliJ IDEA.
 * User: milesd
 * Date: 05/04/2014
 * Time: 13:16
 * Berlin Clock detail
 */
public class BerlinClockDetail {
    private static final String INPUT_SPLIT = SplitUtil.INPUT_SPLIT;
    private static final String INPUT_TIME_SPLIT = SplitUtil.INPUT_TIME_SPLIT;
    private String yellowLamp;
    private String inputTime;
    private String topRow1;
    private String topRow2;
    private String bottomRow1;
    private String bottomRow2;
    private String calculatedTime;

    public BerlinClockDetail(String inputTime, String yellowLamp, String topRow1,
                             String topRow2, String bottomRow1, String bottomRow2, String timeIn24HourFormat) {
        this.inputTime = inputTime;
        this.yellowLamp = yellowLamp;
        this.topRow1 = topRow1;
        this.topRow2 = topRow2;
        this.bottomRow1 = bottomRow1;
        this.bottomRow2 = bottomRow2;

        this.calculatedTime = new StringBuffer(timeIn24HourFormat + INPUT_TIME_SPLIT
                              + inputTime.split(INPUT_SPLIT)[0].split(INPUT_TIME_SPLIT)[2]).toString();

    }

    public String getTimeIn24HourFormat() {
        return calculatedTime;
    }

    /**
     * Not the most sophisticated way of
     * printing a Berlin clock
     */
    public void printBerlinClock() {
        System.out.println( "------\r\n" +
                            this.inputTime + "\r\n" +
                            "------\r\n" +
                            this.yellowLamp + "\r\n" +
                            this.topRow1 + "\r\n" +
                            this.topRow2 + "\r\n" +
                            this.bottomRow1 + "\r\n" +
                            this.bottomRow2
                            + "\r\n"
                            + "------\r\n");
    }
}
