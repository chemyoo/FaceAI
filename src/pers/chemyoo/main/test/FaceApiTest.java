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
 * @version version : created time：2018年10月11日 下午4:41:13 
 * @since since from 2018年10月11日 下午4:41:13 to now.
 * @description class description
 */
public class FaceApiTest {
	
	public static void main(String[] args) throws IOException {
		Map<String, Object> map = new HashMap<>();
		// age 年龄；beauty 相貌评分；gender 性别； race 肤色；face_type 人脸类型；
		// human: 真实人脸 cartoon: 卡通人脸；
        map.put("face_field", "age,beauty,gender,race,face_type");
        map.put("image_type", FaceDetect.BASE64);
        File file = FileSelectUtils.getFile();
        if(file == null) {
        	System.err.println("程序结束...");
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
