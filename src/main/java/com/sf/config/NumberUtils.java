package com.sf.config;

import java.math.BigDecimal;

public class NumberUtils {
	 public static BigDecimal makeBigDecimal(double d) {

         return BigDecimal.valueOf(d);

    }
    
    /**
     * To int
     * @param intStr
     * @return
     */
	public static int toInt(String intStr) {
		int result = 0;
		try {
			result = Integer.parseInt(intStr);
		} catch (Exception e) {
			//do nothing
		}
		return result;
	}
	
	/**
	 * To double
	 * @param dbStr
	 * @return
	 */
	public static double toDouble(String dbStr){
		double result = 0d;
		try {
			result = Double.parseDouble(dbStr);
		} catch (Exception e) {
			// DO NOTHING
		}
		return result;
	}
}

