package com.ak.c2j.utils;

public class Constants {

	
	
	
	/**
	 * 0000 1111
	 */
	public static final byte LOW_NIBBLE_MASK = 0x0F;

	/**
	 * 1111 0000
	 */
	public static final int HIGH_NIBBLE_MASK = 0xF0;
	
	public static final int FOUR = 4;
	
	
	public static final int HIGH_NIBBLE = 0;
	public static final int LOW_NIBBLE = 1;
	
	public static byte NEGATIVE_IDENTIFIER = 0x0D;
	
	
	/**
	 * This is the max value  COMP-3 byte can hold.  This is equivalent
	 * to the byte containing two nines, 1001 1001.
	 */
	public final static int COMP3_MAX_VALUE = 153;
}
