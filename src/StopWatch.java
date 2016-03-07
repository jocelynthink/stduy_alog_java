import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.ThreeSum;


public class StopWatch {

	private final long start;
	public StopWatch(){
		start = System.currentTimeMillis();
	}
	public double elapsedTime(){
		long now  = System.currentTimeMillis();
		return (now - start) /1000.0;
	}
	
	public static double timeTrial(int N){
		int MAX = 1000000;
		int[] a = new int[N];
		for(int i = 0;i < N;i ++){
			a[i]= StdRandom.uniform(-MAX,MAX);
		}
		StopWatch timer = new StopWatch();
		int cnt = ThreeSum.count(a);
		return timer.elapsedTime();
	}
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		int[] a = new int[N];
		for(int i= 0;i < N;i++){
			a[i] = StdRandom.uniform(-1000000,1000000);
		}
		StopWatch timer = new StopWatch();
		int cnt = ThreeSum.count(a);
		double time = timer.elapsedTime();
		StdOut.println(cnt + " triples " + time + " seconds");
		
		
		for( N= 250 ;true;N+=N){
			 time  = timeTrial(N);
			StdOut.printf("%7d %5.1f\n", N,time);
		}
	}

}
