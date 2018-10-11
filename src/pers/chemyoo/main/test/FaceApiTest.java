package pers.chemyoo.main.test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import pers.chemyoo.core.FaceDetect;
import pers.chemyoo.utils.Base64Utils;
import pers.chemyoo.utils.FileSelectUtils;
import pers.chemyoo.utils.FileUtils;

/** 
 * @author Author : jianqing.liu
 * @version version : created time��2018��10��11�� ����4:41:13 
 * @since since from 2018��10��11�� ����4:41:13 to now.
 * @description class description
 */
public class FaceApiTest {
	
	public static void main(String[] args) throws IOException {
		Map<String, Object> map = new HashMap<>();
		// age ���䣻beauty ��ò���֣�gender �Ա� race ��ɫ��
		// face_type �������ͣ�human: ��ʵ���� cartoon: ��ͨ������
        map.put("image_type", FaceDetect.BASE64);
        File file = FileSelectUtils.getFile();
        if(file == null) {
        	System.err.println("�������...");
        	return;
        }
        
        String filepath = file.getAbsolutePath();
        
        byte[] data = FileUtils.readFileByBytes(filepath);
        try {
        	map.put("image", Base64Utils.encode(data));
			System.err.println(FaceDetect.detect(map));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
