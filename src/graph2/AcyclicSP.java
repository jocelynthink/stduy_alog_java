package graph2;

import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import graph.Topological;

public class AcyclicSP {

	/**
	 * 无环加权有向图的最短路径，先求出拓扑排序，然后按照拓扑排序的顺序计算最短路径
	 */
	private DirectedEdge[] edgeTo;
	private double[] distTo;
	public AcyclicSP(EdgeWeightedDigraph G,int s){
		edgeTo = new DirectedEdge[G.V()];
		distTo = new double[G.V()];
		for(int v = 0; v < G.V(); v++){
			distTo[v] = Double.POSITIVE_INFINITY;
		}
		distTo[s] = 0.0;
		
		Topological top = new Topological(G);
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
