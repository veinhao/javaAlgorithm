//KMP字符串搜索算法

public class KMP {
	public static int KMP1(String text,String pattern) {
		if(pattern.length()==0) return 0;
        if(pattern.length()>text.length()) return -1;
        int ires=0,i=0,j=0;
		int[] next=new int[pattern.length()];
		next=computePattern(pattern);
		while(i<text.length()&&j<pattern.length()) {
			if(text.charAt(i)==pattern.charAt(j)) {
				ires=i-j;
				++j;
				++i;
			} 
			else{
				if(j==0) {
					++i;
				}
				else j=next[j-1];
				
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
		int k=1;
		while(k<pattern.length()){
			if(pattern.charAt(i)==pattern.charAt(j)) {
				res[k++]=i+1;
				++i;
				++j;
			}else {
				if(i==0) {
					res[k++]=0;
					++j;
				}else {
					i=res[i-1];
				}
				
			}
			
		}
		return res;
	}
	
	public static void main(String []args) {
		System.out.println(KMP1("abcxabcdabxabcdabcdabcy","abcdabcy"));
	}
}
