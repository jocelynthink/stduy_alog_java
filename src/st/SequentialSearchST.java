package st;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class SequentialSearchST<Key,Value> {
	private Node first;
	private int N = 0;;
	private class Node{
		Key key;
		Value val;
		Node next;
		public  Node(Key key,Value val,Node next){
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}
	
	public void put(Key key,Value val){
		for(Node x = first;x != null;x = x.next){
			if(key.equals(x.key)){
				x.val = val;
				return;
			}
		}
		first = new Node(key,val,first);
		N++;
	}
	public Value get(Key key){
		for(Node x = first;x != null; x = x.next){
			if(key.equals(x.key)){
				return x.val;
			}
		}
		return null;
	}
	public int size(){
		return N;
	}
	
	public Iterable<Key> keys(){
		Queue<Key> queue = new Queue<Key>();
		for(Node x = first;x !=null;x = x.next){
			queue.enqueue(x.key);
		}
		return queue;
	}
	
	public void delete_delay(Key key){
		put(key,null);
	}
	public void delete(Key key){
		first = delete(first,key);
	}
	private Node delete(Node x,Key key){
		if(x == null)
			return null;
		if(key.equals(x.key)){
			N--;
			return x.next;
		}
		x.next = delete(x.next,key);
		return x;
	}
	public boolean contains(Key key){
		return get(key)!=null;
	}
	public boolean isEmpty(){
		return size()==0;
	}

	
	public static void main(String[] args){
		SequentialSearchST<String,Integer> st;
		st = new SequentialSearchST<String,Integer>();
		
		for(int i = 0; !StdIn.isEmpty();i++){
			String key = StdIn.readString();
			st.put(key, i);
		}
		
		for(String s : st.keys()){
			StdOut.println(s + " " + st.get(s));
		}
	}

}
