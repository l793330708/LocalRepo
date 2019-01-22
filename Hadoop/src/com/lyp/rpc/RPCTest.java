package com.lyp.rpc;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import com.lyp.rpc.LoginService;

public class RPCTest {

	public static void main(String[] args) throws Exception {
		//the package must be the same name at remote or you'll fail to connect with a msg unknows protocol
		LoginService proxy = RPC.getProxy(LoginService.class,1L,new InetSocketAddress("leiyp",3000), new Configuration());
		String msg = proxy.login("leiyp", "dumpass");
		System.out.println(msg);
	}

}
