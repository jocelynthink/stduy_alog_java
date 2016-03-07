package graph;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.SymbolDigraph;

public class Topological {

	private Iterable<Integer> order;
	public Topological(Digraph G){
		DirectedCycle cyclefinder = new DirectedCycle(G);
		if(!cyclefinder.hasCycle()){
			DepthFirstOrder dfs = new DepthFirstOrder(G);
			order  = dfs.reversePost();
		}
	}
	
	public Iterable<Integer> order(){
		return order;
	}
	public boolean isDAG(){
		return order != null;
	}
	public static void main(String[] args) {
		 In in = new In(args[0]);
	     Digraph G = new Digraph( in);
		Topological top = new Topological(G);
		if(top.isDAG()){
			for(int v : top.order())
			StdOut.println(v);
		}else{
			StdOut.println("not DAG");
		}
		

	}

}
