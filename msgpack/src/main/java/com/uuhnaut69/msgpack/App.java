package com.uuhnaut69.msgpack;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.msgpack.MessagePack;
import org.msgpack.packer.Packer;
import org.msgpack.template.Template;
import org.msgpack.unpacker.Unpacker;

import static org.msgpack.template.Templates.*;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) throws Exception {
//		MyMessage src1 = new MyMessage();
//		src1.setName("msgpack");
//		src1.setVersion(0.6);
//
//		MyMessage src2 = new MyMessage();
//		src2.setName("muga");
//		src2.setVersion(10.0);
//
//		MyMessage src3 = new MyMessage();
//		src3.setName("frsyukik");
//		src3.setVersion(1.0);
//
//		MessagePack msgpack = new MessagePack();
//		//
//		// Serialize
//		//
//		ByteArrayOutputStream out = new ByteArrayOutputStream();
//		Packer packer = msgpack.createPacker(out);
//		packer.write(src1);
//		packer.write(src2);
//		packer.write(src3);
//		byte[] bytes = out.toByteArray();
//
//		//
//		// Deserialize
//		//
//		ByteArrayInputStream in = new ByteArrayInputStream(bytes);
//		Unpacker unpacker = msgpack.createUnpacker(in);
//		MyMessage dst1 = unpacker.read(MyMessage.class);
//		MyMessage dst2 = unpacker.read(MyMessage.class);
//		MyMessage dst3 = unpacker.read(MyMessage.class);
//
//		System.out.println(dst1);
//		System.out.println(dst2);
//		System.out.println(dst3);

		MessagePack msgpack = new MessagePack();

		// Create templates for serializing/deserializing List and Map objects
		Template<List<String>> listTmpl = tList(TString);
		Template<Map<String, String>> mapTmpl = tMap(TString, TString);

		//
		// Serialization
		//

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		Packer packer = msgpack.createPacker(out);

		// Serialize List object
		List<String> list = new ArrayList<String>();
		list.add("msgpack");
		list.add("for");
		list.add("java");
		packer.write(list); // List object

		// Serialize Map object
		Map<String, String> map = new HashMap<String, String>();
		map.put("sadayuki", "furuhashi");
		map.put("muga", "nishizawa");
		packer.write(map); // Map object

		//
		// Deserialization
		//

		byte[] bytes = out.toByteArray();
		ByteArrayInputStream in = new ByteArrayInputStream(bytes);
		Unpacker unpacker = msgpack.createUnpacker(in);

		// to List object
		List<String> dstList = unpacker.read(listTmpl);

		System.out.println(dstList);

		// to Map object
		Map<String, String> dstMap = unpacker.read(mapTmpl);

		System.out.println(dstMap);
	}
}
