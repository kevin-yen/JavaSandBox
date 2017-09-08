package me.khyen.test;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

/**
 * @author Kevin Yen
 */

public class JavaSandBox {

	public static void main(String [] args) throws IOException, ParseException {
		Node node = AntProfileLogParser.read(new File("/home/kevin/console.txt"));

		JsonWriter.write(new File("/home/kevin/console.json"), node);
	}

}
