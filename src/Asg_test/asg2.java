package Asg_test;

import java.util.HashMap;    
import java.util.Map;    

public class asg2 {
	
	public static Map<Integer, Double> Map = new HashMap<Integer, Double>(); 
	
	public static Double Prize(int n){
		Double Result = 0.0;
		
		if(Map.get(n) != null)
			Result = Map.get(n);
		else{
		
		if(n==1){
			
			Result = 5.5;
		}
		else{
			
			Double floor = Math.floor(Prize(n-1)) * 1.0;
			Double ceil = Math.ceil(Prize(n-1)) * 1.0;
			
			Double probLow = floor / 10.0;
			Double probHigh = 1 - probLow;
			
			Double[] eArray = new Double[n];
			
			//System.out.println("probLow in Price(" + n + ") is " + probLow );
			//System.out.println("probHigh in Price(" + n + ") is " + probHigh );
			
			//get expt in this recursive step
			Double expt = 0.0;
			Double count = 0.0;
			for(int i = 10; i>= ceil ; i-- ){
				count++;
				expt += i;
				
			}
			expt /= count;
			
			//System.out.println("expt in Price(" + n + ") is " + expt );
			
			for(int i = 1; i <= n; i++ ){
				if(i==n)
					eArray[i-1] = Math.pow(probLow, i-1) * 5.5;
				else{
					
					eArray[i-1] = Math.pow(probLow, i-1) * probHigh * expt;
				}
			
			}
			
			
			for(int i= 0; i <eArray.length; i++ ){
				Result += eArray[i];
				//System.out.println("e:" + eArray[i]);
			}
			
			
		}
		
		if(Map.get(n) == null)
			Map.put(n, Result);
		}
		
		return Result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Prize(3) is  " + asg2.Prize(3));
		System.out.println("Prize(4) is  " + asg2.Prize(4));
		System.out.println("Prize(5) is  " + asg2.Prize(5));
		System.out.println("Prize(6) is  " + asg2.Prize(6));
		System.out.println("Prize(7) is  " + asg2.Prize(7));
		System.out.println("Prize(8) is  " + asg2.Prize(8));
		System.out.println("Prize(9) is  " + asg2.Prize(9));
		System.out.println("Prize(10) is  " + asg2.Prize(10));
		System.out.println("Prize(11) is  " + asg2.Prize(11));
		System.out.println("Prize(12) is  " + asg2.Prize(12));
		
		System.out.println("Prize(13) is  " + asg2.Prize(13));
		System.out.println("Prize(14) is  " + asg2.Prize(14));
		System.out.println("Prize(15) is  " + asg2.Prize(15));
		System.out.println("Prize(16) is  " + asg2.Prize(16));
		System.out.println("Prize(17) is  " + asg2.Prize(17));
		System.out.println("Prize(18) is  " + asg2.Prize(18));
		System.out.println("stop");
	}

}
