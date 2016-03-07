import java.util.Stack;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
public class Stats {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Bag<Double> numbers = new Bag<Double>();
//		Queue<Integer> a = new Queue<Integer>();
		Stack<Integer> stack;
		stack = new Stack<Integer>();
		while(!StdIn.isEmpty())
			stack.push(StdIn.readInt());
		while(!stack.empty()){
			int i = stack.pop();
			StdOut.println(i);
		}
	}

}
