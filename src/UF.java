import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class UF {
	
	private int[] id;
	private int count;
	/*º”»®*/
	private int[] sz;
	
	public UF(int N){
		count = N;
		id = new int[N];
		for(int i = 0;i < N; i++)
			id[i] = i;
		
		sz = new int[N];
		for(int i = 0;i < N; i++){
			sz[i] = 1;
		}
	}
	public void union(int p,int q){
		int pId = find(p);
		int qId = find(q);
		if(pId == qId)
			return ;
		for(int i = 0;i < id.length;i ++){
			if(id[i]==pId)
				id[i]=qId;
		}
		count --;
	}
	public int find(int p){
		return id[p];
	}
	
	public boolean connected(int p,int q){
		return find(p) == find(q);
	}
	
	public  int count(){
		return count;
	}
	
	private int find2(int p){
		while(p!=id[p])
			p = id[p];
		return p;
	}
	public void union2(int p,int q){
		int pRoot = find2(p);
		int qRoot = find2(q);
		if(pRoot == qRoot)
			return;
		id[pRoot] = qRoot;
		count --;
	}
	
	public int find3(int p){
		while(p!=id[p])
			p = id[p];
		return p;
	}
	public void union3(int p ,int q){
		int i = find3(p);
		int j = find3(q);
		if(i == j)
			return ;
		if(sz[i] < sz[j]){
			id[i] = j;
			sz[j] += sz[i];
		}else{
			id[j] = i;
			sz[i] +=sz[j];
		}
		count --;
	}
	public static void main(String[] args) {
		int N = 0;
		N = StdIn.readInt();	
		UF uf = new UF(N);
		while(!StdIn.isEmpty()){
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if(uf.connected(p, q))
				continue;
			uf.union(p, q);
			StdOut.println(p+" "+q);
		}
		StdOut.println(uf.count() + "  components");
	
	}

}
