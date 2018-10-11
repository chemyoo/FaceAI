package pers.chemyoo.utils;

import java.lang.reflect.Array;

import javax.swing.JOptionPane;

public class ShowResultUtils {
	private ShowResultUtils() {}
	
	public static void show(Object result) {
		JOptionPane.showMessageDialog(null, toString(result), "人脸识别结果为：", JOptionPane.PLAIN_MESSAGE);
	}
	
	private static String toString(Object result) {
		StringBuilder buffer = new StringBuilder();
		if(result != null) {
			if(result.getClass().isArray()) {
				int length = Array.getLength(result);
				buffer.append("[");
				for(int i = 0; i < length; i++) {
					buffer.append(Array.get(result, i));
					buffer.append(", ");
				}
				buffer.delete(buffer.length() - 2, buffer.length());
				buffer.append("]");
			} else {
				return result.toString();
			}
		}
		return buffer.toString();
	}
}