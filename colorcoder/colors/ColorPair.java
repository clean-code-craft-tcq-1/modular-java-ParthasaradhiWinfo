package colorcoder.colors;

public class ColorPair {
	
	private MajorColor majorColor;
    private MinorColor minorColor;

	public ColorPair(MajorColor major, MinorColor minor) {
        majorColor = major;
        minorColor = minor;
    }

    public MajorColor getMajor() {
        return majorColor;
    }

    public MinorColor getMinor() {
        return minorColor;
    }

    public String ToString() {
        String colorPairStr = ColorCodeConstants.MAJOR_COLORS[majorColor.getIndex()];
        colorPairStr += " ";
        colorPairStr += ColorCodeConstants.MINOR_COLORS[minorColor.getIndex()];
        return colorPairStr;
    }
}
