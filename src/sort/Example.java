package sort;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Merge;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Selection;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Transaction;

public class Example {
	
	/*选择排序*/
	public static void sort_select(Comparable[] a){
		int N = a.length;
		for(int i = 0;i < N;i ++){
			int min = i;
			for(int j = i+1; j<N;j++){
				if(less(a[j],a[min]))
					min = j;
			}
			
			exch(a,i,min);
		}
	}
	
	/*插入排序*/
	public static void sort_insert(Comparable[] a){
		int N = a.length;
		for(int i = 1 ;i < N; i++){
			for(int j = i; j > 0 && less(a[j],a[j-1]); j--){
				exch(a,j,j-1);
					
			}
		}
	}
	
	/*Shell排序*/
	public static void sort_shell(Comparable[] a){
		int N = a.length;
		int h = 1;
		while( h < N/3)
			h = 3*h + 1;
		while(h>=1){
			for(int i = h;i < N;i ++){
				for( int j = i; j >=h && less(a[j],a[j-h]);j-=h)
					exch(a,j,j-h);
			}
			h = h/3;
		}
	}
	private static	Comparable [] aux;
	public static void merge(Comparable[] a,Comparable[] aux,int lo,int mid,int hi){
		int i = lo; 
		int j = mid + 1;
		for(int k = lo; k <= hi; k++)
			aux[k] = a[k];
		
		for(int k = lo;k <=hi ;k ++){
			if(i > mid)
				a[k] = aux[j++];
			else if(j > hi)
				a[k] = aux[i++];
			else if(less(aux[j],aux[i])) //这里比较的是辅助数组aux
				a[k] = aux[j++];
			else
				a[k] = aux[i++];
		}
		 for (int k = lo; k <= hi; k++) {
	            aux[k] = a[k]; 
	        }
		
	}
	
	public static void sort_merge(Comparable[] a){
		aux = new Comparable[a.length];
		sort_merge3(a,aux,0,a.length-1);
	}
	private static void sort_merge3(Comparable[] a ,Comparable[] aux,int lo ,int hi){
		if(hi <= lo)
			return;
		int mid = lo + (hi-lo)/2;
		sort_merge3(a,aux,lo,mid);
		sort_merge3(a,aux,mid+1,hi);
		merge(a,aux,lo,mid,hi);
	}
	
	
	
	public static void  sort_merge2(Comparable[] a){
		int N = a.length;
		aux = new Comparable[N];
		for(int sz = 1;sz < N; sz = sz +sz){
			for(int lo = 0;lo < N -sz;lo +=sz +sz){
				//sort_merge(a,lo,lo+sz-1,Math.min(lo+sz+sz-1, N-1));
			}

		}
	}
	
	/*快速排序*/
	public static void sort_quick(Comparable[] a){
		StdRandom.shuffle(a);
		sort_quick(a,0,a.length-1);
	}
	
	private static void sort_quick(Comparable[] a,int lo,int hi){
		if(hi <= lo)
			return ;
		int j = partition(a,lo,hi);
		sort_quick(a,lo,j-1);
		sort_quick(a,j+1,hi);
	}
	
	private static int partition(Comparable[] a,int lo,int hi){
		int i  = lo,j = hi +1;
		Comparable v = a[lo];
		while(true){
			while(less(a[++i],v)){
				if(i == hi)
					break;
			}
			while(less(v,a[--j])){
				if(j == lo)
					break;
			}
			if(i>=j)
				break;
			exch(a,i,j);
			
		}
		exch(a ,lo,j);
		return j;
	}
	
	private static boolean less(Comparable v,Comparable w){
		return v.compareTo(w) < 0;
	}
	private static void exch(Comparable[] a,int i,int j){
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	public static void show(Comparable[] a){
		for(int i = 0;i < a.length;i++){
			StdOut.print(a[i] + " ");
		}
		StdOut.println();
	}
	
	public static boolean isSorted(Comparable[] a){
		for(int i = 1;i < a.length;i ++){
			if(less(a[i],a[i-1]))
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		String[] a = {"S","O","R","T","E","X","A","M","P","L","E"};
//		Selection.sort(a);
//		Example.sort_select(a);
//		Example.sort_insert(a);
		Example.sort_merge(a);
//		Merge.sort(a);
		System.out.println( isSorted(a));
		show(a);
		
		int M = Integer.parseInt(args[0]);
		MinPQ<Transaction> pq = new MinPQ<Transaction>(M+1);
		while(StdIn.hasNextLine()){
			pq.insert(new Transaction(StdIn.readLine()));
			if(pq.size()>M){
				pq.delMin();
			}
			
		}
		
		Stack<Transaction> stack = new Stack<Transaction>();
		while(!pq.isEmpty())
			stack.push(pq.delMin());
		for(Transaction t: stack)
			StdOut.println(t);

	}

}
