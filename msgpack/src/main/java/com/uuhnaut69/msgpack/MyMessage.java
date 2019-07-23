package com.uuhnaut69.msgpack;

import org.msgpack.annotation.Message;
import org.msgpack.annotation.Optional;

@Message
public class MyMessage {

	private String name;
	private double version;

	// new field
	@Optional
	private int flag = 0;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getVersion() {
		return version;
	}

	public void setVersion(double version) {
		this.version = version;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public MyMessage() {
		// TODO Auto-generated constructor stub
	}

	public MyMessage(String name, double version, int flag) {
		this.name = name;
		this.version = version;
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "MyMessage [name=" + name + ", version=" + version + ", flag=" + flag + "]";
	}

}
