package com.lyp.rpc;

public interface LoginService {
	public static final long versionID = 1L;
	public String login(String name,String password);
}
