package pers.chemyoo.main.test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import pers.chemyoo.core.Authorization;
import pers.chemyoo.utils.Base64Utils;
import pers.chemyoo.utils.FileSelectUtils;
import pers.chemyoo.utils.FileUtils;
import pers.chemyoo.utils.HttpUtils;

public class BaiDuTest {

	public static void main(String[] args) throws Exception {
		String requestUrl = "https://aip.baidubce.com/rest/2.0/solution/v1/iocr/recognise/finance";
		Map<String,Object> map = new HashMap<>();
        File file = FileSelectUtils.getFile();
        if(file == null) {
        	System.err.println("³ÌÐò½áÊø...");
        	return;
        }
        
        String filepath = file.getAbsolutePath();
        
        byte[] data = FileUtils.readFileByBytes(filepath);
		map.put("image", Base64Utils.encode(data));
		map.put("detectorId", 0);
		String params = map.toString();
		String res = HttpUtils.post(requestUrl , Authorization.getAuthToken(), "application/x-www-form-urlencoded", params, "utf-8");
		System.err.println(res);
	}
	
}
