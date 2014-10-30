package valid.number;

public class Solution {
	public boolean isNumber(String s) {
		if (s == null) return false;
		s = s.trim();
		if (s.length() == 0) return false;
		if (s.length() == 1) {
			if ( s.charAt(0)>='0' && s.charAt(0)<='9' ) return true;
			else return false;
		}
		if (s.charAt(0) != '.' && s.charAt(0) != '-' && s.charAt(0) != '+' && !(s.charAt(0)>='0' && s.charAt(0)<='9') ) return false;
		
		int eNum = 0;
		int posE = -1;
		int dotNum = 0;
		int posDot[] = new int[2];
		
		if (s.charAt(0) == '.') {
			dotNum++;
			posDot[0] = 0;
		}
		
		for (int i=1;i<s.length();i++) {
			if ( !(s.charAt(i)>='0' && s.charAt(i)<='9') && s.charAt(i) != 'e' && s.charAt(i) != '.' && s.charAt(i) != '+' && s.charAt(i) != '-') {
				//不是数字, e, ., +, -
				return false;
			}
			if ( !(s.charAt(i)>='0' && s.charAt(i)<='9') && s.charAt(i) != '.' &&  i == s.length() - 1 ) {
				//不是数字且是最后一位
				return false;
			}
			if (s.charAt(i) == 'e') {
				eNum++;
				if (eNum > 1) return false;//出现两次e
				posE = i;//记录e的位置
				if ( !(s.charAt(i-1)>='0' && s.charAt(i-1)<='9') ) {
					//e前边不是数字
					if (s.charAt(i-1) == '.') {
						//e的前边是点，但是点是第一位
						if (i-1 == 0) return false;
					} else {
						//e的前边不是点
						return false;
					}
				}
			} else if (s.charAt(i) == '.') {
				dotNum++;
				if (dotNum > 1) return false;//出现3次点
				//if ( !(s.charAt(i-1)>='0' && s.charAt(i-1)<='9') && s.charAt(i-1) != '+' && s.charAt(i-1) != '-') return false;//点的前边不是数字且不是+，-号
				if ( !(s.charAt(i-1)>='0' && s.charAt(i-1)<='9') ) {
					//点的前边不是数字
					if (i == s.length() - 1) return false; //且点是最后一位
					else if (!(s.charAt(i+1)>='0' && s.charAt(i+1)<='9')) return false;//且点的后边也不是数字
				}
				if (dotNum == 1) {
					//第一次出现点
					posDot[0] = i;
					if (eNum > 0 && posDot[0] > posE) return false;//e后边不能有点
				} else {
					//第二次出现点
					posDot[1] = i;
					if ( !(posDot[0] < posE && posDot[1] > posE) ) return false;//两个点在e的同一边
				}
			} else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
				if (s.charAt(i-1) != 'e') return false; //+,-号前边不是e 
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		String strs[] = {
			".e1", //false
			" -.", //false
			"1e.", //false
			"6e6.5",//false
			"-e58",//false
			"+.8", //true
			"46.e3",//true
			"3.",//true
			".1", //true
			"46.e3",//true
			/*"-0.32e+8.9",
			"0",
			" 0.1 ",
			"abc",
			"1 a",
			"2e10",*/
			
		};
		for (int i=0;i<strs.length;i++) {
			System.out.print(strs[i] + "	");
			System.out.println(s.isNumber(strs[i]));
		}
	}
}
