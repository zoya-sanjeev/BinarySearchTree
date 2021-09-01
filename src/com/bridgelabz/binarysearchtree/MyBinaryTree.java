package com.bridgelabz.binarysearchtree;

public class MyBinaryTree <K extends Comparable<K>>{
	private MyBinaryNode<K> root;
	
	public void add(K key) {
		this.root=this.addRecursively(root,key);
	}
	
	public MyBinaryNode<K> addRecursively(MyBinaryNode<K> current,K key){
		if(current==null)
			return new MyBinaryNode<>(key);
		int compareResult=key.compareTo(current.key);
		if(compareResult==0) return current;
		if(compareResult<0) {
			current.left=addRecursively(current.left, key);
		}
		else {
			current.right=addRecursively(current.right, key);
		}
		return current;
	}
	
	public int getSize() {
		return this.getSizeRecursive(root);
	}
	private int getSizeRecursive(MyBinaryNode<K> current) {
		return current==null?0:1+this.getSizeRecursive(current.left)+ this.getSizeRecursive(current.right);
	}
	
	public boolean search(K find) {
		if(searchRecursive(root,find))
			return true;
		else
			return false;
		
	}
	private boolean searchRecursive(MyBinaryNode<K> current, K find) {
		if(current==null)
			return false;
		int compare=current.key.compareTo(find);
		if(compare==0)
			return true;
		else if(compare<0)
			return searchRecursive(current.right, find);
		else
			return searchRecursive(current.left, find);
	}

}
