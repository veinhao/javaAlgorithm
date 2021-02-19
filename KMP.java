//KMP算法

public class KMP {
	public static int KMP1(String text,String pattern) {
		int ires=0,i=0,j=0;
		int[] next=new int[pattern.length()];
		next=computePattern(pattern);
		while(i<text.length()&&j<pattern.length()) {
			if(text.charAt(i)==pattern.charAt(j)) {
				++j;
				++i;
			} 
			if(i<text.length()&&j<pattern.length()&&text.charAt(i)!=pattern.charAt(j)){
				j=next[j-1];
				if(text.charAt(i)==pattern.charAt(j)) {
					ires=i-j;
					++i;
					++j;
				}else {
					ires=++i;
				}
			}
		}
		if(j!=pattern.length()) ires=-1;
		return ires;
	}
	
	public static int[] computePattern(String pattern) {
		if(pattern.length()==0) return null;
		int[] res=new int[pattern.length()];
		res[0]=0;
		if(pattern.length()==1) return res;
		
		int i=0,j=1;
		
		for(int k=1;k<pattern.length();k++) {
			if(pattern.charAt(i)==pattern.charAt(j)) {
				res[k]=i+1;
				++i;
			}else {
				if(i==0) {
					res[k]=0;
				}else {
					i=res[i-1];
					if(pattern.charAt(i)==pattern.charAt(j)) res[k]=i+1;
					else res[k]=0;
				}
			}
			++j;
		}
		return res;
	}
	
	public static void main(String []args) {
		System.out.println(KMP1("abcxabcdabxabcdabcdabcy","abcdabcy"));
	}
}
