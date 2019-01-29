package com.lyp.mrFlow;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.util.Tool;

/**
 * 网络传输必须实现序列化接口否则Bean无法传输，MapReduce通过RPC方式通信
 * @author Administrator
 *
 */
public class FlowBean implements Writable {
	public String phoneNB;
	@Override
	public String toString() {
		return "FlowBean [name=" + name + ", consumeM=" + consumeM + "]";
	}
	public String name;
	public int money;
	public int consumeM;
	public FlowBean() {
		
	}
	public FlowBean(String name,String phoneNB,int consumeM) {
		this.name = name;
		this.phoneNB = phoneNB;
		this.consumeM = consumeM;
	};
	public FlowBean(String name, int consumeM) {
		this.name = name;
		this.consumeM = consumeM;
	}
	public String getPhoneNB() {
		return phoneNB;
	}
	public void setPhoneNB(String phoneNB) {
		this.phoneNB = phoneNB;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getCousumeM() {
		return consumeM;
	}
	public void setCousumeM(int cousumeM) {
		this.consumeM = cousumeM;
	}
	@Override
	public void write(DataOutput out) throws IOException {
		out.writeBytes(name);
		out.writeBytes(phoneNB);
		out.writeInt(consumeM);
		out.writeInt(money);
		
	}
	@Override
	public void readFields(DataInput in) throws IOException {
		name = in.readUTF();
		phoneNB = in.readUTF();
		consumeM = in.readInt();
		money = in.readInt();
		
	}
	
}
