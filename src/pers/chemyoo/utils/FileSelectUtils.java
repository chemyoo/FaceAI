package pers.chemyoo.utils;
import java.io.File;

import javax.swing.JFileChooser;

/** 
 * @author Author : jianqing.liu
 * @version version : created time：2018年10月11日 下午4:24:49 
 * @since since from 2018年10月11日 下午4:24:49 to now.
 * @description class description
 */
public class FileSelectUtils {
	
	private FileSelectUtils (){}
	
	public static File getFile() {
		JFileChooser fileChooser = new JFileChooser("D:/");//"F:/pic"
//		FileSystemView fsv = FileSystemView.getFileSystemView();  //注意了，这里重要的一句
		//设置最初路径为桌面路径              
//		fileChooser.setCurrentDirectory(fsv.getHomeDirectory());
		fileChooser.setDialogTitle("请选择文件夹...");
		fileChooser.setApproveButtonText("确定");
		//只选择文件夹
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		//设置文件是否可多选
		fileChooser.setMultiSelectionEnabled(false);
		fileChooser.setAcceptAllFileFilterUsed(false);// 去掉显示所有文件的按钮
		fileChooser.setFileFilter(new SelectFileFilter());
		if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			return fileChooser.getSelectedFile();
		}
		return null;
	}
}
