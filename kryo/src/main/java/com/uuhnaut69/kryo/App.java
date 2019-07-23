package com.uuhnaut69.kryo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) throws IOException {

		Kryo kryo = new Kryo();
		Output output = new Output(new FileOutputStream("file2.dat"));
		Input input = new Input(new FileInputStream("file2.dat"));
		Person person = new Person();
		kryo.writeObject(output, person);
		output.close();

		Person readPerson = kryo.readObject(input, Person.class);
		input.close();

		System.out.println(readPerson);

	}
}
