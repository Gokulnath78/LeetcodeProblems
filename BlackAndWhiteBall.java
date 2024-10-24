    public long minimumSteps(String s) {
        
    	long count = 0;
    	char ar[] = s.toCharArray(), temp = 'a';
    	int right = ar.length-1, left = right-1;
    	
    	while(right > 0 && left >= 0) {
    		if(ar[left] == '1' && ar[right] == '0') {
    			count += Math.abs(left-right);
    			
    			temp = ar[left];
    			ar[left] = ar[right];
    			ar[right] = temp;
    			
    			right--;
    			left = right-1;
    		}
    		else if(ar[left] == '1' && ar[right] == '1') {
    			right--;
    			if(left > 0) {
        			left = right-1;
    			}
    		}    		
    		else if(ar[left] == '0' && ar[right] == '1') {
    			right--;
    		}
    		else if(ar[left] == '0' && ar[right] == '0') {
    			left--;
    		}
    	}
    	
    	return count;
    }
