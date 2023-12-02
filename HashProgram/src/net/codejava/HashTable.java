package net.codejava;

public abstract class HashTable {
	
	public abstract void HashInsert(int key, int value);
	
	public abstract boolean HashSearch(int key);
	
	public abstract void HashDelete(int key);
}