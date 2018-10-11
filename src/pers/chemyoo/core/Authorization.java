package pers.chemyoo.core;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import pers.chemyoo.constants.ConstantKeys;
import pers.chemyoo.utils.ObjectSerializable;

/** 
 * @author Author : jianqing.liu
 * @version version : created time：2018年10月11日 上午11:12:24 
 * @since since from 2018年10月11日 上午11:12:24 to now.
 * @description class description
 */
public class Authorization {
	
	public static String getAuthToken() {
		Auth auth = ObjectSerializable.readObject();
		GregorianCalendar cal = new GregorianCalendar();
		if(auth != null && auth.expire.after(cal.getTime())) {
			return auth.token;
		}
		try {
            URL uri = new URL(ConstantKeys.ACCESS_TOKEN_URL);
            // 打开和URL之间的连接
            HttpURLConnection connection = (HttpURLConnection) uri.openConnection();
            connection.setRequestMethod("GET");
            
            connection.connect();
            
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
            	// 获取所有响应头字段
                // Map<String, List<String>> map = connection.getHeaderFields()
                String result = IOUtils.toString(connection.getInputStream(), "utf-8");
                JSONObject jsonObject = new JSONObject(result);
                auth = new Auth();
                auth.token = jsonObject.getString("access_token");// get access_token.
                Long expiresIn = jsonObject.getLong("expires_in");// get expire second.
                
                cal.add(Calendar.SECOND, expiresIn.intValue());
                auth.expire = cal.getTime();
                ObjectSerializable.serializable(auth);
                return auth.token;
            } else {
            	return IOUtils.toString(connection.getInputStream(), "utf-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
	
	public static void main(String[] args) {
		System.err.println(getAuthToken());
	}
	
}
