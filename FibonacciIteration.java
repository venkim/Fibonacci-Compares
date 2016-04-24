package com.venkat.fibo;

import java.util.logging.Level;
import java.util.logging.Logger;

import junit.framework.Test;

public class FibonacciIteration {
	/*
	 * The complexity - big O of this method
	 * is just n. 
	 */
	public static long fibo(int n){
		if (n == 1 || n == 2 )
			return 1;
		
		long result = 1;
		long prev = 1;
		long temp = 0;
		
		n -= 2 ;
		while (n > 0){

			temp = result ;
			result = result + prev;
			prev = temp;
			
			n--;
		}
		return result;
	}
	/*
	 * The big O complexity of this method is 2 power n
	 * Recursion while the easiest to understand and express
	 * sometimes can be very inefficient. If you start at the root
	 * and trace a tree, n calls n-1, n-2, and n-1 calls n-2,n-3
	 * and so on - you will see that a whole tree with each node
	 * having two children - but for the leaf node will emerge
	 * and its level is n - meaning 2power n nodes
	 * It could be reduced - if you start saving the results
	 * --- leading to dynamic programming --- 
	 * but this example is just to show the cons of using recursion
	 * without looking at cost.
	 */
	public static long fib_recurse(int n){
		// error condition - for this test we just return 1
		if (n < 1){
			return 1L;
		}
		// base condition
		if (n == 1 || n == 2 )
			return 1L;
		
		try {
			// recursive call
			return ( fib_recurse(n-1) + fib_recurse(n-2) );
		} catch( Exception ex){
			Logger.getLogger(Test.class.getName()).log(Level.SEVERE, ex.getMessage(), ex); 
			return 1;
		}
		
	}
	
	public static void main(String args[]){

		for(int i = 31 ; i < 41 ; i++){
			long time = System.currentTimeMillis() ;
			System.out.println(">>>>>Fibo iteration method of " + i + " is " + fibo(i));
			long iter_time = System.currentTimeMillis() - time;
			
			time= System.currentTimeMillis() ;
			System.out.println(">>>>>Fibo recursive method of " + i + " is " + fib_recurse(i));
			long recu_time = System.currentTimeMillis() - time;
			
			System.out.println(" Number " + i + " Iter time = " + iter_time + " Recursive time =" + recu_time ); 
		}
	}
}
