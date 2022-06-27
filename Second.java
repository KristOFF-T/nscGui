package main;

import java.util.Vector;

public class Second {

	public static String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public Second() {
		
	}
	
	public static String revStr(String x) {
		String result = "";
		
		for(int i=x.length()-1; i>-1; i--) {
			result += x.charAt(i);
		}
		
		return result;
	}
	
	public static String convert(int ins, int ons, String num) {
		if(ons < 2 || ins < 2 || ins > 36 || ons > 36)
			return "";
		
		int value;
		String result="";
		if(ins == 10) {
			value = Integer.valueOf(num);

		} else {
			value = c2dn(ins, num);
		}
		
		if(value < 0)
			return "";
		
		if(ons == 10) {
			result = Integer.toString(value);
			
		} else {
			result = convertIntVec(getIntVec(value, ons), ins);
		}
		
		return result;
	}
	
	public static int getIndex(char fc) {
		for(int i=0; i<chars.length(); i++) {
			if(fc == chars.charAt(i))
				return i;
		}
		return -1;
	}
	
	public static int c2dn(int ins, String num) {
		int result=0,
			multiplier=1;
	
		for(int i=num.length()-1; i>-1; i--) {
			int val = getIndex(num.charAt(i));
			
			if(val > ins-1 && result > -1)
				result = -result;
			
			val *= multiplier;
			result += val;
			multiplier *= ins;
		}

		return result;
	}
	
	public static Vector<Integer> getIntVec(int num, int ns) {
		Vector<Integer> vec = new Vector<Integer>();
		//int[] vec = {};
		int temp = num;
		
		int cpow = 1,
			ppow = 1;

		for(int count=1; temp > 0 || count==1; count++) {
			cpow *= ns;
			int rem = temp % cpow,
				d = rem / ppow;
			
			temp -= rem;
			vec.add(d);
			
			ppow *= ns;
		}
		
		return vec;
	}
	
	public static String convertIntVec(Vector<Integer> intVec, int ns) {
		String result = "",
			   rev = "";
	
		for(int i : intVec) {
			rev += chars.charAt(i);
		}
		
		result = revStr(rev);
		
		return result;
	}
}
