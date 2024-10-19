class Solution {
    public char findKthBit(int n, int k) {
        
    	String calculate = "0";
    	for(int i=1; i<n; i++) {
    		calculate = calculate + "1" + invertAndReverse(calculate);
    	}
    	    	
    	return calculate.charAt(k-1);
    }
    
    public String invertAndReverse(String str) {
    	
    	StringBuilder res = new StringBuilder();
    	
        for(int i=0; i<str.length(); i++) {
    		if(str.charAt(i) == '1') {
    			res.append("0");
    		}
    		else if(str.charAt(i) == '0') {
    			res.append("1");
    		}
    	}
    	
    	return res.reverse().toString();
    }
}
