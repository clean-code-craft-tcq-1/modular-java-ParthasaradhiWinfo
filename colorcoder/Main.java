package colorcoder;

import colorcoder.colors.ColorCodeConstants;
import colorcoder.colors.ColorPair;
import colorcoder.colors.MajorColor;
import colorcoder.colors.MinorColor;

public class Main {
	static ColorPair GetColorFromPairNumber(int pairNumber) {
        int zeroBasedPairNumber = pairNumber - 1;
        MajorColor majorColor =
                MajorColor.fromIndex(zeroBasedPairNumber / ColorCodeConstants.NUMBER_OF_MINOR_COLORS);
        MinorColor minorColor =
                MinorColor.fromIndex(zeroBasedPairNumber % ColorCodeConstants.NUMBER_OF_MINOR_COLORS);
        return new ColorPair(majorColor, minorColor);
    }

    static int GetPairNumberFromColor(MajorColor major, MinorColor minor) {
        return major.getIndex() * ColorCodeConstants.NUMBER_OF_MINOR_COLORS + minor.getIndex() + 1;
    }

    static void testNumberToPair(int pairNumber,
                                 MajorColor expectedMajor,
                                 MinorColor expectedMinor) {
        ColorPair colorPair = GetColorFromPairNumber(pairNumber);
        System.out.println("Got pair " + colorPair.ToString());
        assert (colorPair.getMajor() == expectedMajor);
        assert (colorPair.getMinor() == expectedMinor);
    }

    static void testPairToNumber(
            MajorColor major,
            MinorColor minor,
            int expectedPairNumber) {
        int pairNumber = GetPairNumberFromColor(major, minor);
        System.out.println("Got pair number " + pairNumber);
        assert (pairNumber == expectedPairNumber);
    }

    public static void main(String[] args) {
        testNumberToPair(4, MajorColor.WHITE, MinorColor.BROWN);
        testNumberToPair(5, MajorColor.WHITE, MinorColor.SLATE);

        testPairToNumber(MajorColor.BLACK, MinorColor.ORANGE, 12);
        testPairToNumber(MajorColor.VIOLET, MinorColor.SLATE, 25);
    }
}