package graph2;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;

public class MST {

	private boolean[] marked;
	private Queue<Edge> mst;
	private MinPQ<Edge> pq;
	public void lazyPrimMST(EdgeWeightedGraph G){
		pq = new MinPQ<Edge>();
		marked = new boolean[G.V()];
		mst = new Queue<Edge>();
		visit(G,0);
		
	}
	private void visit(EdgeWeightedGraph G, int i) {
		
		
	}
	public MST(EdgeWeightedGraph G){
		
	}
	
	public Iterable<Edge> edges(){
		return mst;
	}
	public double weight(){
		double weight = 0;
		return weight;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
