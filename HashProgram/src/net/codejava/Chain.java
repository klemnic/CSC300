package net.codejava;

public class Chain {
	public Node Header;
	public int Size;
	
	public Chain() {
		this.Header = null;
		this.Size = 0;
	}
	
	//compare every node with its key and input. When there is an item has the key, return true, otherwise return false;
	public boolean SearchByKey(int key) {
		Node temp = this.Header;
		while (temp != null) {
			if (temp.Key == key) {
				return true;
			}
			temp = temp.nextNode;
		}
		return false;
	}
	
	public Node SearchNodeByKey(int key) {
		Node temp = this.Header;
		while (temp != null) {
			if (temp.Key == key) {
				return temp;
			}
			temp = temp.nextNode;
		}
		return null;
	}
	
	public void InsertNode(int key, int value) {
		Node temp = this.Header;
		if (temp == null) {
			this.Header = new Node(key, value);
			this.Size++;
		} else {
			while(temp.nextNode != null) {
				temp = temp.nextNode;
			}
			temp.nextNode = new Node(key, value);
			this.Size++;
		}
	}
	
	public Boolean DeleteNodeByKey(int key) {
		Node previous = this.Header;
		Node current;
		if (previous != null) {
			current = previous.nextNode;
			if (previous.Key == key) {
				this.Header = current;
				previous.nextNode = null;
				this.Size--;
				return true;
			}
			while (current != null) {
				if (current.Key == key) {
					previous.nextNode = current.nextNode;
					current.nextNode = null;
					this.Size--;
					return true;
				} else {
					previous = current;
					current = current.nextNode;
				}
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		Node temp = this.Header;
		String output = "";
		while(temp != null) {
			if (output.length() > 0) {
				output += "; ";
			}
			output += temp.toString();
			temp = temp.nextNode;
		}
		return output;
	}
	
}