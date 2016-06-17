package com.ak.c2j.utils;


public class ConversionUtil {

	private static int getHighNibbleValue(byte b) {
		return (b & Constants.HIGH_NIBBLE_MASK) >>> Constants.FOUR;
	}

	private static int getLowNibbleValue(byte b) {

		return (b & Constants.LOW_NIBBLE_MASK);
	}

	private static int[] getNibbleFromByte(byte b) {

		int[] ubyte = new int[2];

		ubyte[Constants.HIGH_NIBBLE] = getHighNibbleValue(b);
		ubyte[Constants.LOW_NIBBLE] = getLowNibbleValue(b);

		return ubyte;
	}

	private static boolean isNegative(byte signbit) {
		return getLowNibbleValue(signbit) == Constants.NEGATIVE_IDENTIFIER ? true : false;
	}

	private static int[] unpackCOMP3(byte b) throws Exception {

		if (b > Constants.COMP3_MAX_VALUE) {
			throw new Exception("too large value");
		}
		return getNibbleFromByte(b);
	}

	private static final String convertPackedNibblesToString(byte[] buffer) throws Exception {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < buffer.length - 1; i++) {
			int[] cbyte = unpackCOMP3(buffer[i]);
			sb.append(cbyte[0]);
			sb.append(cbyte[1]);
		}
		sb.append(getHighNibbleValue(buffer[buffer.length - 1]));
		return sb.toString();
	}

	public static final String convertCOMP3ToString(byte[] buffer, int scale) throws Exception {
		StringBuffer sb = new StringBuffer();

		if (isNegative(buffer[buffer.length - 1])) {
			sb.append('-');
		}
		sb.append(convertPackedNibblesToString(buffer));
		if (scale > 0) {
			sb.insert((sb.length() - scale), '.');
		} else {
			for (int i = 0; i < scale; i++)
				sb.append("0");// zero padding
		}
		return sb.toString();
	}

}
