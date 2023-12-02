package net.codejava;

public class Node {
	public int Key;
	public int Value;
	public Node nextNode;
	
	public Node(int Key, int Value) {
		this.Key = Key;
		this.Value = Value;
		this.nextNode = null;
	}

	@Override
	public String toString() {
		return "{" + this.Key + ":" + this.Value + "}";
	}
	
}