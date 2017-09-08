package me.khyen.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AntProfileLogParser {

	private static DateFormat dateFormat = new SimpleDateFormat("E MMM dd HH:mm:ss z yy");
	private static Pattern taskStartedPattern = Pattern.compile("^(?<name>\\w+): started (?<timestamp>.*)$");
	private static Pattern taskFinishedPattern = Pattern.compile("^(?<name>\\w+): finished (?<timestamp>.*) \\((?<duration>[0-9]+)ms\\)$");
	private static Pattern targetStartedPattern = Pattern.compile("^Target (?<name>\\w+): started (?<timestamp>.*)$");
	private static Pattern targetFinishedPattern = Pattern.compile("^Target (?<name>\\w+): finished (?<timestamp>.*) \\((?<duration>[0-9]+)ms\\)$");

	public static Node read(File logFile) throws IOException, ParseException {
		Node rootNode = new Node(null, "root", new Date());
		Node node = rootNode;

		BufferedReader bufferedReader = new BufferedReader(new FileReader(logFile));

		int lineNumber = 0;

		String line = bufferedReader.readLine();

		while (line != null) {
			lineNumber++;

			System.out.println(lineNumber);

			line = line.trim();

			Matcher targetStartedMatcher = targetStartedPattern.matcher(line);
			Matcher targetFinishedMatcher = targetFinishedPattern.matcher(line);
			Matcher taskStartedMatcher = taskStartedPattern.matcher(line);
			Matcher taskFinishedMatcher = taskFinishedPattern.matcher(line);

			if (targetStartedMatcher.find()) {
				Node childNode = node.add(node, targetStartedMatcher.group("name"), dateFormat.parse(targetStartedMatcher.group("timestamp")));

				node.add(childNode);

				node = childNode;
			}
			else if (taskStartedMatcher.find()) {
				Node childNode = node.add(node, taskStartedMatcher.group("name"), dateFormat.parse(taskStartedMatcher.group("timestamp")));

				node.add(childNode);

				node = childNode;
			}
			else if (targetFinishedMatcher.find()) {
				node.setDuration(Long.parseLong(targetFinishedMatcher.group("duration")));

				node = node.getParent();
			}
			else if(taskFinishedMatcher.find()) {
				node.setDuration(Long.parseLong(taskFinishedMatcher.group("duration")));

				node = node.getParent();
			}

			line = bufferedReader.readLine();
		}

		return rootNode;
	}

}
