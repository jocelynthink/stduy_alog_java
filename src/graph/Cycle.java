package graph;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Cycle {

	private boolean[] marked;
	private boolean hasCycle;
	private int[] degeTo;
	private Stack<Integer> cycle;
	
	public Cycle(Graph G){
		marked = new boolean[G.V()];
		degeTo = new int[G.V()];
		for(int s = 0; s< G.V();s++){
			if(!marked[s]){
				dfs(G,s,s);
			}
		}
	}
	private void dfs(Graph G,int v,int u){/*u表示源节点 v表示的是下一个要递归的节点*/
		marked[v] = true;
		for(int w : G.adj(v))
			if(!marked[w]){
				degeTo[w] = v;
				dfs(G,w,v);
			}
			else if(w != u){
				
                hasCycle = true;
			}
				
	}
	public boolean hasCycle(){
		return hasCycle;
	}
	
	public Iterable<Integer> cycle() {
        return cycle;
    }
	public static void main(String[] args) {
		In in = new In(args[0]);
        Graph G = new Graph(in);
        Cycle finder = new Cycle(G);
        StdOut.print(finder.hasCycle);
//        if (finder.hasCycle()) {
//            for (int v : finder.cycle()) {
//                StdOut.print(v + " ");
//            }
//            StdOut.println();
//        }
//        else {
//            StdOut.println("Graph is acyclic");
//        }
	}

}
