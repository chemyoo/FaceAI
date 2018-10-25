package pers.chemyoo.utils;

import java.awt.Color;

/** 
 * @author Author : jianqing.liu
 * @version version : created time：2018年10月12日 下午2:55:17 
 * @since since from 2018年10月12日 下午2:55:17 to now.
 * @description class description
 */
public class HammingDistanceUtils {
	// get HanMing distance
	public static int hammingDistance(int x, int y) {
		int hamming = Math.abs(x ^ y);
		int count = 0;
		while (hamming > 0) {
			hamming = hamming & (hamming - 1);
			count ++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		float[] f = Color.RGBtoHSB(0, 0, 0, null);
		float[] f2 = Color.RGBtoHSB(1, 1, 1, null);
		int x = converRgbToArgb(Color.getHSBColor(f[0], f[1], f[2]));
		int y = converRgbToArgb(Color.getHSBColor(f2[0], f2[1], f2[2]));
		int distance = HammingDistanceUtils.hammingDistance(x, y);
		System.err.println(distance);
	}
	
	private static int converRgbToArgb(Color color) {
		return (0xFF << 24) | (color.getRed() << 16) | (color.getGreen() << 8) | color.getBlue();
	}
}
