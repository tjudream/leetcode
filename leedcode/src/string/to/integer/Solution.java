package string.to.integer;

public class Solution {
	public static void main(String[] args) {
		System.out.println(atoi("-2147483648"));
		//int x = -2147483648;
		//System.out.println(Integer.MAX_VALUE);
	}
	public static int atoi(String str) {
        if (str == null) return 0;
        str = str.trim();
        if (str.length()==0) return 0;
        int res = 0;
        boolean isNeg = false;
        int i=0;
        if (str.charAt(i) == '-') {
        	isNeg = true;
        	i++;
        } else if (str.charAt(i) == '+') {
        	i++;
        }
        //System.out.println(isNeg);
        while (i<str.length()) {
        	char c = str.charAt(i);
        	if (c<'0' || c>'9') break;
        	int digit = c - '0';
        	/*System.out.println(res);
        	if (res == 214748364) {
        		System.out.println( "digit = " + digit );
        		System.out.println( res + " > " + (-((Integer.MIN_VALUE + digit)/10)) );
        	}*/
        	if (isNeg && res == 214748364 && digit == 8) {
        		return Integer.MIN_VALUE;
        	}
        	if (isNeg && res > -((Integer.MIN_VALUE + digit)/10)) {
        		return Integer.MIN_VALUE;
        	}else if(res > ((Integer.MAX_VALUE - digit)/10)) {
        		return Integer.MAX_VALUE;
        	}
        	
        	res = res*10 + digit;
        	i++;
        }
        
        return isNeg?-res:res;
    }
}
