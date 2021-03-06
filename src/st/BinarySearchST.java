package st;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class BinarySearchST<Key extends Comparable<Key>,Value> {
	
	private Key[] keys;
	private Value[] vals;
	private int N;
	public BinarySearchST(int capacity){
		keys = (Key[])new Comparable[capacity];
		vals = (Value[]) new Object[capacity];
	}

	public void put(Key key,Value val){
		int i = rank(key);
		if(i < N && keys[i].compareTo(key)==0){
			vals[i] = val;
			return;
		}
		for(int j = N;j > i;j--){
			keys[j] = keys[j-1];
			vals[j] = vals[j-1];
		}
		keys[i] = key;
		vals[i] = val;
		N++;
	}
	public int rank(Key key,int lo,int hi){
		if(hi < lo)
			return lo;
		int mid = lo + (hi -lo)/2;
		int cmp = key.compareTo(keys[mid]);
		if(cmp < 0)
			return rank(key,lo,mid -1);
		else if(cmp >0){
			return rank(key,mid+1,hi);
		}else{
			return mid;
		}
	}
	public int rank(Key key){
		int lo = 0,hi = N-1;
		while(lo <= hi){
			int mid = lo + (hi -lo)/2;
			int cmp = key.compareTo(keys[mid]);
			if(cmp < 0)
				hi = mid -1;
			else if(cmp >0)
				lo = mid +1;
			else return mid;
		}
		return lo;
	}
	
	public Key min(){
		return keys[0];
	}
	public Key max(){
		return keys[N-1];
	}
	public Key select(int k){
		return keys[k];
	}
	
	public Key ceiling(Key key){
		int i = rank(key);
		if(i == N)
			return null;
		return keys[i];
	}
	public Key floor(Key key){
		int i = rank(key);
		if(i < N && key.compareTo(keys[i])==0){
			return keys[i];
		}
		else if(i ==0)
			return null;
		else{
			return keys[i-1];
		}
		
	}
	public Value get(Key key){
		if(isEmpty())
			return null;
		int i = rank(key);
		if(i < N && keys[i].compareTo(key)==0)
			return vals[i];
		else 
			return null;
		
	}
	public void delete(Key key,Value val){
		int i = rank(key);
		if(i == N || key.compareTo(keys[i])!=0){
			return;
		}
//		if(i < N && key.compareTo(keys[i])==0){
			for(int j = i;j < N; j++){
				keys[j] = keys[j++];
				vals[j] = vals[j++];
			}
//		}
			N--;
			keys[N] = null;
			vals[N] = null;
		
	}
	public boolean contains(Key key){
		return get(key)!=null;
	}
	public boolean isEmpty(){
		return size()==0;
	}
	public int size(){
		return N;
	}
	public Iterable<Key> keys(Key lo,Key hi){
		Queue<Key> q = new Queue<Key>();
		for(int i=rank(lo);i < rank(hi);i++){
			q.enqueue(keys[i]);
		}
		if(contains(hi)){
			q.enqueue(keys[rank(hi)]);
		}
		return q;
	}
	
	public static void main(String[] args){
		BinarySearchST<String,Integer> st;
		st = new BinarySearchST<String,Integer>(20);
		
		for(int i = 0; !StdIn.isEmpty();i++){
			String key = StdIn.readString();
			st.put(key, i);
		}
		
		for(String s : st.keys("A", "Z")){
			StdOut.println(s + " " + st.get(s));
		}
	}
}
