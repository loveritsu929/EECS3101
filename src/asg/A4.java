package asg;

import java.util.Scanner;
import java.math.BigInteger;
import java.util.Vector;
import java.util.LinkedList;

public class A4 {
    static BigInteger D(int n) {
    	if (n <= 2) return BigInteger.valueOf(n-1);
    	else return BigInteger.valueOf(n-1).multiply(D(n-1).add(D(n-2)));
    }

    static LinkedList<Vector<Integer>> Assignments(Vector<Integer> A) {
    	// Precondition:  A is a non-empty vector of distinct elements

    	LinkedList<Vector<Integer>> result = new LinkedList<Vector<Integer>>();

    	if (A.size() == 2){
    		Vector<Integer> reversed = new Vector<Integer>(2);
    		reversed.add(A.elementAt(1));
    		reversed.add(A.elementAt(0));
    		result.add(reversed);
    	} 
    	else if (A.size() > 2){
    		int n = A.size();
    		for (int i=1; i<n; i++) { //each i , two cases
    			// Case 1: (n-1)*D(n-2)
    			Vector<Integer> A1 = new Vector<Integer>(); 	// A1: (n-2) elts; handle books except [i] and [n]
    			A1.addAll(A);
    			A1.remove(n-1);
    			A1.remove(i-1);
    			LinkedList<Vector<Integer>> L1 = Assignments(A1);
    			for (Vector<Integer> B : L1) {
    				B.add(i-1, A.elementAt(n-1));               // G[i] and G[n] swap books
    				B.add(A.elementAt(i-1));
    			}
		
    			// Case 2: (n-1)*D(n-1)
    			Vector<Integer> A2 = new Vector<Integer>();		// A2: (n-1) elts
    			A2.addAll(A);
    			A2.setElementAt(A2.elementAt(n-1), i-1);        // G[i] get B[n]
    			A2.remove(n-1);									 
    			LinkedList<Vector<Integer>> L2 = Assignments(A2); // assign D(n-1)
    			for (Vector<Integer> B : L2) {
    				B.add(A.elementAt(i-1));					  // append G[n]'s book back
    			}

    			// Concatenate the new results to the end of result
    			result.addAll(L1);  // quite inefficient in Java
    			result.addAll(L2);
    		}
    	}
    	return result;
	
    	// Postcondition:  result is a list of all vectors B that can
    	// be formed by rearranging the elements of A such that
    	// B[i] != A[i] for all i.
    }

    static Vector<Integer> SelectAssignment(Vector<Integer> A, BigInteger k) {
    	// Precondition:  elements of A are distinct and
    	// 1 <= k <= D(A.size())

    	// You must fill in this routine
    	int n = A.size();
    	BigInteger case_one_size =BigInteger.valueOf(n-1).multiply(D(n-2));
    	BigInteger case_two_size =BigInteger.valueOf(n-1).multiply(D(n-1));
    			
    	Vector<Integer> target = new Vector<Integer>();
    	
    	if(n==1){
    		//do nothing. empty target
    	}
    	else if(n==2){
    		//reversed
    		target.add(A.elementAt(1));
    		target.add(A.elementAt(0));
    	}
    	else{// n>2
    		
    		if(k.compareTo( case_one_size) == -1 || 
    				k.compareTo( case_one_size) == 0)
    		{ // k <= (n-1) * D(n-2) : Case1
    			
    			
    			
    			
    		}
    		else{ //Case2
    			
    			
    			
    			
    		}
    		
    	}
    	
    	
    	
    	
    	
    	
    	
    	
    	return target;

    	// Postcondition:  result returned is the kth element of the
    	// list produced by Assignments(A).
    	}

    public static void main(String[] args) {
    	// Mr Montmort tested his Assignments code for n=5 as follows.

    	int size = 4;
    	Vector<Integer> identity = new Vector<Integer>(size);
		for (int i = 1; i <= size; i++)
			identity.add(i);
		LinkedList<Vector<Integer>> L = Assignments(identity);
		for (Vector<Integer> B : L)
			System.out.println(B);

		// Next, Mr Montmort wants to test SelectAssignment as follows
		
		System.out.println(SelectAssignment(identity, new BigInteger("9")));
		
		/*
		size = 20;
		identity = new Vector<Integer>(size);
		for (int i = 1; i <= size; i++)
			identity.add(i);
		System.out.println(SelectAssignment(identity, new BigInteger("8")));
		System.out.println(SelectAssignment(identity, new BigInteger("387628462009283761")));
		System.out.println(SelectAssignment(identity, new BigInteger("549865568789765")));
		System.out.println(SelectAssignment(identity, new BigInteger("895014631192902121")));
		identity.remove(size-1);
		System.out.println(SelectAssignment(identity, new BigInteger("44750731559645106")));
		System.out.println(SelectAssignment(identity, new BigInteger("44750731557645106")));
		*/
    }
}
