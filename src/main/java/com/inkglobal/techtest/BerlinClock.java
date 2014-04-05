package com.inkglobal.techtest;

import com.inkglobal.util.SplitUtil;

/**
 * Created with IntelliJ IDEA.
 * User: milesd
 * Date: 02/04/2014
 * Time: 22:24
 *
 * Berlin clock implementation class
 *
 */
public class BerlinClock {
    private static final int BERLIN_VALID_STRING_LENGTH = 37;
    private static final int BERLIN_CLOCK_GROUPS = 6;
    private static final String INPUT_SPLIT = SplitUtil.INPUT_SPLIT;

    static int total;

    /**
     * Check the length Berlin clock input
     * @param input berlin clock string
     * @return true if invalid length
     */
    static boolean validateBerlinClockInput(String input) {
        if (input.length() != BERLIN_VALID_STRING_LENGTH) {
            return false;
        }

        return true;
    }

    /**
     * Check the number of groups for the Berlin clock
     * Six is valid
     *
     * @param input
     * @return true if there are 6 groups
     */
    static boolean checkClockGroups(String input) {
        if (input.split(INPUT_SPLIT).length == BERLIN_CLOCK_GROUPS) {
            return true;
        }
        return false;
    }

    /**
     * Split input check for correct lamp colours (for each row)
     *
     * The top two rows of lamps are red
     * The first bottom row the 3rd, 6th and 9th lamp are red
     *
     * Sample input 00:00:00 Y OOOO OOOO OOOOOOOOOOO OOOO
     *
     * @param input
     * @return - true if lamps on rows are valid colours
     */
    public static boolean checkCorrectLampColoursForRows(String input) {
        String[] splitInput = input.split(INPUT_SPLIT);

        if (splitInput[2].contains("Y") || splitInput[3].contains("Y")) {
            return false;
        } else if (splitInput[4].substring(2, 3).equals("Y")
                || splitInput[4].substring(5, 6).equals("Y")
                || splitInput[4].substring(8, 9).equals("Y")) {
            return false;
        }

        return true;
    }

    /**
     * This is the equivilent of a main method
     * Get the Berlin Clock detail
     *
     * 13:17:01 O RROO RRRO YYROOOOOOOO YYOO
     *
     * @param input
     * @return
     */
    public static BerlinClockDetail getBerlinClockDetail(String input) {
        StringBuffer buff = new StringBuffer();
        String[] splitInput = input.split(INPUT_SPLIT);

        LampRow row = new LampRow();
        // top row 1
        row.setEachLampTimeValue(5);
        row.setTimeUnit("HOUR");
        int hours = row.getTime(splitInput[2]);

        // top row 2
        row = new LampRow();
        row.setTimeUnit("HOUR");
        row.setEachLampTimeValue(1);
        hours += row.getTime(splitInput[3]);

        buff.append(LampRow.ensureTimeUnitIsHHMM(hours) + ":");

        // bottom row 1
        row = new LampRow();
        row.setTimeUnit("MINUTE");
        row.setEachLampTimeValue(5);
        int minutes = row.getTime(splitInput[4]);

        // bottom row 2
        row = new LampRow();
        row.setTimeUnit("MINUTE");
        row.setEachLampTimeValue(1);
        minutes += row.getTime(splitInput[5]);

        buff.append(LampRow.ensureTimeUnitIsHHMM(minutes));

        return new BerlinClockDetail(input, splitInput[1], splitInput[2], splitInput[3], splitInput[4], splitInput[5], buff.toString());
    }
}
