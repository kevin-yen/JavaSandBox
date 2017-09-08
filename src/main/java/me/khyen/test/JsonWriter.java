package me.khyen.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JsonWriter {

	public static void write(File jsonFile, Node node) throws IOException {
		FileWriter fileWriter = new FileWriter(jsonFile);

		fileWriter.write(toJson(node));

		fileWriter.close();
	}

	private static String toJson(Node node) {
		StringBuilder sb = new StringBuilder();

		sb.append("{\"name\":\"");
		sb.append(node.getName());
		sb.append("\",\"timestamp\":");
		sb.append(node.getTimestamp().getTime());
		sb.append(",\"duration\":");
		sb.append(node.getDuration());

		if (node.getChildren().size() > 0) {
			sb.append(",\"children\":[");

			boolean first = true;

			for (Node childNode : node.getChildren()) {
				if (first) {
					first = false;
				}
				else {
					sb.append(",");
				}

				sb.append(childNode.toString());
			}

			sb.append("]");
		}

		sb.append("}");

		return sb.toString();
	}

}
