package sort;

public class MaxPQ<Key extends Comparable<Key>> {
	private Key[] pq;
	private int N = 0;
	public MaxPQ(int maxN){
		pq = (Key[]) new Comparable[maxN+1];
	}
	public boolean isEmpty(){
		return N == 0;
	}
	public int size(){
		return N;
	}
	public void insert(Key v){
		pq[++N] = v;
		swim(N);
	}
	public Key delMax(){
		Key max = pq[1];
		exch(1,N--);
		pq[N+1] = null;
		sink(1);
		return max;
	}
	
	private  boolean less(int i,int j){
		return pq[i].compareTo(pq[j]) < 0;
	}
	private void exch(int i,int j){
		Key t = pq[i];
		pq[i]  = pq[j];
		pq[j] = t;
	}
	
	private void swim(int k){
		while(k > 1 && less(k/2,k))
		{
			exch(k/2,k);
			k = k/2;
		}
	}
	
	private void sink(int k){
		while(2*k <= N){
			int j = 2*k;
			if(j < N & less(j,j+1))
				j++;
			if(!less(k,j))
				break;
			exch(k,j);
			k = j;
		}
	}
	
	
	public static void sort(Comparable[] a){
		int N = a.length;
		for(int k = N/2;k >=1;k--){
			sink(a,k,N);
		}
		while(N>1){
			exch(a,1,N--);
			sink(a,1,N);
		}
	}
	
	public static void sink(Comparable[] a,int k,int N){
		while(2*k <=N){
			int  j = 2*k;
			if(j < N && less2(j,j++))
				j++;
			if(!less2(k,j)){
				break;
			}
			exch(a,k,j);
			k = j;
		}
	}
	public static void exch(Comparable[] a,int i,int j){
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	private static boolean less2(Comparable v,Comparable w){
		return v.compareTo(w) < 0;
	}
	
	public void test(int t,int x){
		
	}

	public void test(int x,double y){
		
	}

	public static void main(String[] args) {
		
	}
	
	
}
