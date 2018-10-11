package pers.chemyoo.core;

import java.io.Serializable;
import java.util.Date;

/** 
 * @author Author : jianqing.liu
 * @version version : created time：2018年10月11日 下午12:07:05 
 * @since since from 2018年10月11日 下午12:07:05 to now.
 * @description class description
 */
public class Auth implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2257456781117660435L;
	public String token;
	public Date expire;
	
}
