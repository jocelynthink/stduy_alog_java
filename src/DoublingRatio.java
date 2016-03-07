import java.util.Arrays;
import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
public class DoublingRatio {

	public static int count(int[] a){
		Arrays.sort(a);
		int N = a.length;
		int cnt = 0;
		for(int i = 0;i < N;i ++){
			if(BinarySearch.rank(-a[i], a) > i)
				cnt ++;
		}
		return cnt;
	}
	public static int count3(int[] a){
		Arrays.sort(a);
		int N = a.length;
		int cnt = 0;
		for(int i = 0;i<N;i++){
			for(int j = i+1;j<N;j++){
				if(BinarySearch.rank(-a[i]-a[j],a)>i)
					cnt++;
			}
		}
		return cnt;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		double prev = timeTrial(125);
//		for(int N = 250;true;N+=N){
//			double time = timeTrial(N);	
//		}
	
		int[] a = In.readInts(args[0]);
		StdOut.println(count(a));
		StdOut.println(count3(a));

	}

}
