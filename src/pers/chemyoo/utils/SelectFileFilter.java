package pers.chemyoo.utils;

import java.io.File;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.filechooser.FileFilter;

/** 
 * @author Author : jianqing.liu
 * @version version : created time：2018年10月11日 下午4:26:39 
 * @since since from 2018年10月11日 下午4:26:39 to now.
 * @description class description
 */
public class SelectFileFilter extends FileFilter {

	@Override
	public boolean accept(File f) {
		String fileName = f.getName();
		String ext = fileName.substring(fileName.indexOf('.') + 1);
		return Arrays.toString(ImageIO.getWriterFormatNames()).contains(ext) || f.isDirectory();
	}

	@Override
	public String getDescription() {
		return "image（图片文件）";
	}

}
