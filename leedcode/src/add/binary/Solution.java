package add.binary;

public class Solution {
	public String addBinary(String a, String b) {
        if (a == null) return b;
        else if (b == null) return a;
        
        int lena = a.length();
        int lenb = b.length();
        if (lena == 0) return b;
        else if (lenb == 0) return a;
        
        String res = "";
        lena--;
        lenb--;
        
        int plus = 0;
        while (lena >= 0 && lenb >= 0) {
        	int sum = (a.charAt(lena) - '0') + (b.charAt(lenb) - '0') + plus;
        	if ( sum == 3) {
        		plus = 1;
        		res = "1" + res;
        	} else if ( sum == 2 ) {
        		plus = 1;
        		res = "0" + res;
        	} else if ( sum == 1 ) {
        		plus = 0;
        		res = "1" + res;
        	} else {
        		plus = 0;
        		res = "0" + res;
        	}
        	lena--;
        	lenb--;
        }
        
        while (lena >= 0) {
        	int sum = (a.charAt(lena) - '0') + plus;
        	if ( sum == 3) {
        		plus = 1;
        		res = "1" + res;
        	} else if ( sum == 2 ) {
        		plus = 1;
        		res = "0" + res;
        	} else if ( sum == 1 ) {
        		plus = 0;
        		res = "1" + res;
        	} else {
        		plus = 0;
        		res = "0" + res;
        	}
        	lena--;
        }
        
        while(lenb >= 0) {
        	int sum = (b.charAt(lenb) - '0') + plus;
        	if ( sum == 3) {
        		plus = 1;
        		res = "1" + res;
        	} else if ( sum == 2 ) {
        		plus = 1;
        		res = "0" + res;
        	} else if ( sum == 1 ) {
        		plus = 0;
        		res = "1" + res;
        	} else {
        		plus = 0;
        		res = "0" + res;
        	}
        	lenb--;
        }
        
        if (plus > 0) {
        	res = "1" + res;
        }
        
        return res;
    }
	/*
	public String addBinary(String a, String b) {
		if (a == null) return b;
		else if (b == null) return a;
		char[] ac = a.toCharArray();
		char[] bc = b.toCharArray();
		int lena = ac.length;
		int lenb = bc.length;
		char[] res = new char[Math.max(lena, lenb) + 2];
		int plus = 0;
		while(true) {
			int ai = 0;
			int bi = 0;
			if (lena)
		}
		return res.toString();
	}
	*/
	public static void main(String[] args) {
		Solution s = new Solution();
		String a = "1111";
		String b = "1111";
		System.out.println(s.addBinary(a, b));
	}
}
