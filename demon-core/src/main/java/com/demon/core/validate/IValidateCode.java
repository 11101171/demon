package com.demon.core.validate;

import java.io.OutputStream;

/**
 * 图形验证码
 * @author gyc
 *
 */
public interface IValidateCode {
	
	/**
	 * 生成图形验证码
	 * @return
	 */
	String createValidateCode(OutputStream os);

}
