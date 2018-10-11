package pers.chemyoo.utils;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

/** 
 * @author Author : jianqing.liu
 * @version version : created time��2018��10��11�� ����4:24:49 
 * @since since from 2018��10��11�� ����4:24:49 to now.
 * @description class description
 */
public class FileSelectUtils {
	
	private FileSelectUtils (){}
	
	public static File getFile() {
		JFileChooser fileChooser = new JFileChooser();//"F:/pic"
		FileSystemView fsv = FileSystemView.getFileSystemView();  //ע���ˣ�������Ҫ��һ��
		//�������·��Ϊ����·��              
		fileChooser.setCurrentDirectory(fsv.getHomeDirectory());
		fileChooser.setDialogTitle("��ѡ���ļ���...");
		fileChooser.setApproveButtonText("ȷ��");
		//ֻѡ���ļ���
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		//�����ļ��Ƿ�ɶ�ѡ
		fileChooser.setMultiSelectionEnabled(false);
		fileChooser.setAcceptAllFileFilterUsed(false);// ȥ����ʾ�����ļ��İ�ť
		fileChooser.setFileFilter(new SelectFileFilter());
		if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			return fileChooser.getSelectedFile();
		}
		return null;
	}
}
