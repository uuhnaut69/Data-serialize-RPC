package com.uuhnaut69.thrift;

import org.apache.thrift.transport.TTransportException;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws TTransportException {
		CrossPlatformServiceServer server = new CrossPlatformServiceServer();
		server.start();
	}
}
