package me.khyen.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Node {

	private Node parent;
	private String name;
	private Date timestamp;
	private long duration;
	private List<Node> children = new ArrayList<>();

	public Node(Node parent, String name, Date timestamp) {
		this.parent = parent;
		this.name = name;
		this.timestamp = timestamp;
	}

	public void add(Node node) {
		children.add(node);
	}

	public Node add(Node parent, String name, Date timestamp) {
		Node childNode = new Node(parent, name, timestamp);

		children.add(childNode);

		return childNode;
	}

	public List<Node> getChildren() {
		return children;
	}

	public long getDuration() {
		return duration;
	}

	public String getName() {
		return name;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public Node getParent() {
		return parent;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("{\"name\":\"");
		sb.append(name);
		sb.append("\",\"timestamp\":");
		sb.append(timestamp.getTime());
		sb.append(",\"duration\":");
		sb.append(duration);

		if (children.size() > 0) {
			sb.append(",\"children\":[");

			boolean first = true;

			for (Node node : children) {
				if (first) {
					first = false;
				}
				else {
					sb.append(",");
				}

				sb.append(node.toString());
			}

			sb.append("]");
		}

		sb.append("}");

		return sb.toString();
	}

}
