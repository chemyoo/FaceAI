package pers.chemyoo.core;

import java.util.Map;
import com.google.gson.JsonObject;
import pers.chemyoo.constants.ConstantKeys;
import pers.chemyoo.utils.GsonUtils;
import pers.chemyoo.utils.HttpUtils;

/** 
 * @author Author : jianqing.liu
 * @version version : created time：2018年10月11日 下午3:04:33 
 * @since since from 2018年10月11日 下午3:04:33 to now.
 * @description class description
 */
public class FaceDetect {
	private FaceDetect() {}
	
	public static final String BASE64 = "BASE64";
	
	public static final String URL = "URL";
	
	public static final String FACE_TOKEN = "FACE_TOKEN";
	
	public static JsonObject detect(Map<String, Object> map) throws Exception {
		map.put("max_face_num", 10);
		String param = GsonUtils.toJson(map);
		String result = HttpUtils.post(ConstantKeys.BAIDU_FACE_API, Authorization.getAuthToken(), 
				"application/json", param);
		return GsonUtils.fromJson(result, JsonObject.class);
	}
	
}
