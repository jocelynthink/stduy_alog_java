package graph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class DirectedDFS {

	private boolean[] marked;
	public DirectedDFS(Digraph G,int s){
		marked = new boolean[G.V()];
		dfs(G,s);
	}
	public DirectedDFS(Digraph G,Iterable<Integer> sources){
		marked = new boolean[G.V()];
		for(int s : sources){
			if(!marked[s])
				dfs(G,s);
		}
	}
	public boolean marked(int v){
		return marked[v];
	}
	private void dfs(Digraph G,int v){
		marked[v] = true;
		for(int w: G.adj(v))
			if(!marked[w])
				dfs(G,w);
	}
	
	
	public static void main(String[] args) {
		 // read in digraph from command-line argument
        In in = new In(args[0]);
        Digraph G = new Digraph( in);
        

        // read in sources from command-line arguments
        Bag<Integer> sources = new Bag<Integer>();
        for (int i = 1; i < args.length; i++) {
            int s = Integer.parseInt(args[i]);
            sources.add(s);
        }

        // multiple-source reachability
        DirectedDFS dfs = new DirectedDFS(G, sources);

        // print out vertices reachable from sources
        for (int v = 0; v < G.V(); v++) {
            if (dfs.marked(v)) StdOut.print(v + " ");
        }
        StdOut.println();

	}

}
