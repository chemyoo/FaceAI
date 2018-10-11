package pers.chemyoo.main.test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import pers.chemyoo.core.FaceDetect;
import pers.chemyoo.utils.Base64Util;
import pers.chemyoo.utils.FileSelectUtils;
import pers.chemyoo.utils.FileUtil;

/** 
 * @author Author : jianqing.liu
 * @version version : created time��2018��10��11�� ����4:41:13 
 * @since since from 2018��10��11�� ����4:41:13 to now.
 * @description class description
 */
public class FaceApiTest {
	
	public static void main(String[] args) throws IOException {
		Map<String, Object> map = new HashMap<>();
		// age ���䣻beauty ��ò���֣�gender �Ա� race ��ɫ��face_type �������ͣ�
		// human: ��ʵ���� cartoon: ��ͨ������
        map.put("face_field", "age,beauty,gender,race,face_type");
        map.put("image_type", FaceDetect.BASE64);
        File file = FileSelectUtils.getFile();
        if(file == null) {
        	System.err.println("�������...");
        	return;
        }
        
        String filepath = file.getAbsolutePath();
        
        byte[] data = FileUtil.readFileByBytes(filepath);
        try {
        	map.put("image", Base64Util.encode(data));
			System.err.println(FaceDetect.detect(map));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
