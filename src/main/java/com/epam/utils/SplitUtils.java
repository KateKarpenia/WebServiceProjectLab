package com.epam.utils;

/**
 * Created by Kate on 18.04.17.
 */
public class SplitUtils {

    public static String getLastSplit(String sourceString, String patternForSplit) {
        String lastValue = "";
        String[] content = sourceString.split(patternForSplit);

        if (content.length > 1) {
            lastValue = content[content.length - 1].trim();
        }
        return lastValue;
    }

    public static String getCertainSplitValueBy(String sourceString, int splitIndex, String patternForSplit) {
        String lastValue = "";
        String[] content = sourceString.split(patternForSplit);

        if (content.length > 1) {
            lastValue = content[splitIndex].trim();
        }
        return lastValue;
    }

}
