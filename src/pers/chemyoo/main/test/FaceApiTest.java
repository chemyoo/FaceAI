package pers.chemyoo.main.test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import pers.chemyoo.core.FaceDetect;
import pers.chemyoo.utils.Base64Utils;
import pers.chemyoo.utils.FileSelectUtils;
import pers.chemyoo.utils.FileUtils;
import pers.chemyoo.utils.ShowResultUtils;

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
        	JsonObject json = FaceDetect.detect(map);
			// use picture from network.
			// System.err.println(FaceDetect.detectFromUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1539259612132&di=be744356e89718019759f9dcdcac9447&imgtype=0&src=http%3A%2F%2Fimg10.3lian.com%2Fshow2015%2F5%2F98%2F64.jpg"))
        	int code = json.get("error_code").getAsInt();
        	if(code == 0) {
        		JsonObject result = json.getAsJsonObject("result");
        		JsonArray faces = result.getAsJsonArray("face_list");
        		if(faces.size() > 0) {
        			JsonObject firstFace = faces.get(0).getAsJsonObject();
        			int age = firstFace.get("age").getAsInt();
        			double beauty = firstFace.get("beauty").getAsDouble();
        			String gender = firstFace.get("gender").getAsJsonObject().get("type").getAsString();
        			StringBuilder buider = new StringBuilder();
        			buider.append("���䣺").append(age).append("\r\n")
        				  .append("��ò���֣�").append(beauty).append("\r\n")
        				  .append("�Ա�").append(gender);
        			ShowResultUtils.show(buider);
        		}
        	} else {
        		ShowResultUtils.show(json.get("error_msg").getAsString());
        	}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
