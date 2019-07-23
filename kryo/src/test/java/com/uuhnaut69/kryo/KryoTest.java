package com.uuhnaut69.kryo;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

public class KryoTest {

	private Kryo kryo;
	private Output output;
	private Input input;

	@Before
	public void init() {
		kryo = new Kryo();
		try {
			output = new Output(new FileOutputStream("file.dat"));
			input = new Input(new FileInputStream("file.dat"));
		} catch (FileNotFoundException ex) {
			Logger.getLogger(KryoTest.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Test
	public void givenObject_whenSerializing_thenReadCorrectly() {
		Object someObject = "Some string";

		kryo.writeClassAndObject(output, someObject);
		output.close();

		Object theObject = kryo.readClassAndObject(input);
		input.close();

		assertEquals(theObject, "Some string");
	}

	@Test
	public void givenObjects_whenSerializing_thenReadCorrectly() {
		String someString = "Multiple Objects";
		Date someDate = new Date(915170400000L);

		kryo.writeObject(output, someString);
		kryo.writeObject(output, someDate);
		output.close();

		String readString = kryo.readObject(input, String.class);
		Date readDate = kryo.readObject(input, Date.class);
		input.close();

		assertEquals(readString, "Multiple Objects");
		assertEquals(readDate.getTime(), 915170400000L);
	}

}
