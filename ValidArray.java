    public boolean validMountainArray(int[] arr) {
        if(arr.length < 3) {
    		return false;
    	}
    	int left = 0, right = 1;
    	while(left < arr.length && right < arr.length) {
    		if(arr[left] < arr[right]) {
                if(left == arr.length-2 && right == arr.length-1) {
    				return false;
    			}
    			left++;
    			right++;
    		}
    		else if(arr[left] == arr[right]) {
    			return false;
    		}
    		else if(arr[left] > arr[right]) {
    			if(left == 0 && right == 1) {
    				return false;
    			}
    			while(left < arr.length && right < arr.length) {
    				if(arr[left] < arr[right]) {
    					return false;
    				}
                    else if(arr[left] == arr[right]){
                        return false;
                    }
    				left++;
    				right++;
    			}
    		}
    	}
    	
    	return true;
    }
