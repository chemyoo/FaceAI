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
 * @version version : created time：2018年10月11日 下午4:41:13 
 * @since since from 2018年10月11日 下午4:41:13 to now.
 * @description class description
 */
public class FaceApiTest {
	
	public static void main(String[] args) throws IOException {
		Map<String, Object> map = new HashMap<>();
		// age 年龄；beauty 相貌评分；gender 性别； race 肤色；
		// face_type 人脸类型，human: 真实人脸 cartoon: 卡通人脸；
        map.put("image_type", FaceDetect.BASE64);
        File file = FileSelectUtils.getFile();
        if(file == null) {
        	System.err.println("程序结束...");
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
        			buider.append("年龄：").append(age).append("\r\n")
        				  .append("相貌评分：").append(beauty).append("\r\n")
        				  .append("性别：").append(gender);
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
