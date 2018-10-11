package pers.chemyoo.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/** 
 * @author Author : jianqing.liu
 * @version version : created time：2018年10月11日 上午11:54:47 
 * @since since from 2018年10月11日 上午11:54:47 to now.
 * @description class description
 */
public class ObjectSerializable {
	
	private ObjectSerializable() {}
	
	private static final String DIRECTORY = System.getProperty("user.dir") + "/Auth.obj";
	
	public static <T> void serializable(T t){
		File file = new File(DIRECTORY);
		try(FileOutputStream out = new FileOutputStream(file);
			ObjectOutputStream outSerializable = new ObjectOutputStream(out);){
			outSerializable.writeObject(t);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T readObject(){
		File file = new File(DIRECTORY);
		if(file.exists()) {
			try(FileInputStream fis = new FileInputStream(file);
				ObjectInputStream in = new ObjectInputStream(fis);) {
				return (T) in.readObject();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
