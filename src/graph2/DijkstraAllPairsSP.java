package graph2;

import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;

public class DijkstraAllPairsSP {

	private DijkstraSP[] all;
	DijkstraAllPairsSP(EdgeWeightedDigraph G){
		all = new DijkstraSP[G.V()];
		for(int v = 0; v < G.V();v++){
			all[v] = new DijkstraSP(G,v);
		}
	}
	Iterable<DirectedEdge> path(int s,int v){
		return all[s].pathTo(v);
	}
	double dist(int s,int t){
		return all[s].distTo(t);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
