package com.inkglobal.util;

/**
 * Created with IntelliJ IDEA.
 * User: milesd
 * Date: 03/04/2014
 * Time: 12:18
 * Enum lookup avoids IllegalArgument Exception
 */
public class LookupUtil {
    public static <E extends Enum<E>> E lookup(Class<E> e, String id) {
        E result = null;
        try {
            result = Enum.valueOf(e, id);
        } catch (IllegalArgumentException ex) {
            // log error or something here

            //throw new RuntimeException(
            //        "Invalid value for enum " + e.getSimpleName() + ": " + id);
        }

        return result;
    }
}
