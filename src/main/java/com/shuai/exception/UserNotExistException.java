package com.shuai.exception;

/**
 * UserNotExistException
 *
 * @author shuai
 * @date 2018/11/30
 */
public class UserNotExistException extends RuntimeException {
	public UserNotExistException() {
		super("用户不存在");
	}
}
