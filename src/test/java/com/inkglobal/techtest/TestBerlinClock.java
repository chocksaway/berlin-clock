package com.inkglobal.techtest;

import com.inkglobal.techtest.BerlinClock;
import com.inkglobal.techtest.BerlinClockDetail;
import com.inkglobal.techtest.LampRow;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: milesd
 * Date: 02/04/2014
 * Time: 22:17
 * Unit tests for Berlin Clock
 */
public class TestBerlinClock {
    @Test
    public void testBerlinValidityForInput() {
        String input = "00:00:00 Y OOOO OOOO OOOOOOOOOOO OOOO";
        assertEquals(BerlinClock.validateBerlinClockInput(input), true);

        assertEquals(BerlinClock.checkClockGroups(input), true);

        assertEquals(BerlinClock.checkCorrectLampColoursForRows(input), true);
    }



    @Test
    public void testBerlinClockTopRow() {
        LampRow topRow1 = new LampRow();

        topRow1.setEachLampTimeValue(5);
        topRow1.setTimeUnit("HOUR");

        assertEquals(topRow1.getTime("RRR0"), 15);
    }

    @Test
    public void testBerlinClockTopSecondRow() {
        LampRow topRow2 = new LampRow();

        topRow2.setEachLampTimeValue(1);
        topRow2.setTimeUnit("HOUR");

        assertEquals(topRow2.getTime("RR00"), 2);
    }


    @Test
    public void testBerlinClockBottomFirstRow() {
        LampRow bottomRow1 = new LampRow();

        bottomRow1.setEachLampTimeValue(5);
        bottomRow1.setTimeUnit("MINUTE");

        assertEquals(bottomRow1.getTime("YYYYYYYYYYY"), 55);
    }


    @Test
    public void testBerlinClockBottomSecondRow() {
        LampRow bottomRow2 = new LampRow();

        bottomRow2.setEachLampTimeValue(1);
        bottomRow2.setTimeUnit("MINUTE");

        assertEquals(bottomRow2.getTime("YYYY"), 4);
    }

    /**
     * Berlin clock tests detailed in specification
     *
     * Check input for validity, output a "time" hh:mm:ss (from the Berlin clock input)
     * (check this is equal with the input time),
     * print the clock
     */

    @Test
    public void testFullBerlinClockInput() {
        //00:00:00 Y OOOO OOOO OOOOOOOOOOO OOOO
        //13:17:01 O RROO RRRO YYROOOOOOOO YYOO
        //23:59:59 O RRRR RRRO YYRYYRYYRYY YYYY
        //24:00:00 Y RRRR RRRR OOOOOOOOOOO OOOO

        // 1
        String input = "00:00:00 Y OOOO OOOO OOOOOOOOOOO OOOO";

        assertEquals(BerlinClock.validateBerlinClockInput(input), true);

        assertEquals(BerlinClock.checkClockGroups(input), true);

        assertEquals(BerlinClock.checkCorrectLampColoursForRows(input), true);

        BerlinClockDetail detail = BerlinClock.getBerlinClockDetail(input);

        detail.printBerlinClock();

        assertEquals(detail.getTimeIn24HourFormat(), "00:00:00");

        // 2
        input = "13:17:01 O RROO RRRO YYROOOOOOOO YYOO";

        assertEquals(BerlinClock.validateBerlinClockInput(input), true);

        assertEquals(BerlinClock.checkClockGroups(input), true);

        assertEquals(BerlinClock.checkCorrectLampColoursForRows(input), true);

        detail = BerlinClock.getBerlinClockDetail(input);

        detail.printBerlinClock();

        assertEquals(detail.getTimeIn24HourFormat(), "13:17:01");

        // 3
        input = "23:59:59 O RRRR RRRO YYRYYRYYRYY YYYY";

        assertEquals(BerlinClock.validateBerlinClockInput(input), true);

        assertEquals(BerlinClock.checkClockGroups(input), true);

        assertEquals(BerlinClock.checkCorrectLampColoursForRows(input), true);

        detail = BerlinClock.getBerlinClockDetail(input);

        detail.printBerlinClock();

        assertEquals(detail.getTimeIn24HourFormat(), "23:59:59");

        // 4
        input = "24:00:00 Y RRRR RRRR OOOOOOOOOOO OOOO";

        assertEquals(BerlinClock.validateBerlinClockInput(input), true);

        assertEquals(BerlinClock.checkClockGroups(input), true);

        assertEquals(BerlinClock.checkCorrectLampColoursForRows(input), true);

        detail = BerlinClock.getBerlinClockDetail(input);

        detail.printBerlinClock();

        assertEquals(detail.getTimeIn24HourFormat(), "24:00:00");
    }











}
