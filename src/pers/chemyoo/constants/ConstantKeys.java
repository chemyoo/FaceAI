package pers.chemyoo.constants;
/** 
 * @author Author : jianqing.liu
 * @version version : created time：2018年10月11日 上午11:02:15 
 * @since since from 2018年10月11日 上午11:02:15 to now.
 * @description class description
 */
public class ConstantKeys {

	private ConstantKeys() {}

	// 百度人脸识别应用id
	public static final String APPID = "11749431";
	// 百度人脸识别应用apikey
	public static final String API_KEY = "a8SGE2MwNlIBfmsUBipHnRKR";
	// 百度人脸识别应用sercetkey
	public static final String SERCET_KEY = "FxaG8r4yuArN6dmtqDWlKZHNxxD6A2GX";
	// 百度人脸识别token 有效期一个月
	public static final String TOKEN_KEY = "token";

	public static final String API_HOST = "https://aip.baidubce.com/oauth/2.0/token?";

	public static final String ACCESS_TOKEN_URL = new StringBuilder(API_HOST)
			.append("grant_type=client_credentials").append("&client_id=")
			.append(API_KEY).append("&client_secret=").append(SERCET_KEY).toString();
	
	public static final String BAIDU_FACE_API = "https://aip.baidubce.com/rest/2.0/face/v3/detect";
}
