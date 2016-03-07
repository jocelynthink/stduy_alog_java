package st;

public class brst<Key extends Comparable<Key>,Value> {

	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	private class Node{
		Key key;
		Value val;
		Node left,right;
		int N;
		boolean color;
		
		Node(Key key,Value val,int N,boolean color){
			this.key = key;
			this.val = val;
			this.N = N;
			this.color = color;
		}
	}
	
	private boolean isRed(Node h){
		if(h==null)
			return false;
		return h.color==RED;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
