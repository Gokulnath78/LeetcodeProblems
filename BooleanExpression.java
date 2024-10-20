class Solution {
    public boolean parseBoolExpr(String expression) {
    	Stack<Character> stk = new Stack();						          // | ( & ( t , f , t ) , ! ( t ) )
    	String word = "";
    	char ch = 't';
    	for(int i=0; i<expression.length(); i++) {
    		word = "";
    		if(expression.charAt(i) == ',') {
    			continue;
    		}
    		else if(expression.charAt(i) != ')') {
    			stk.push(expression.charAt(i));
    		}
    		else if(expression.charAt(i) == ')') { 
    			while(stk.peek() != '(' && !stk.isEmpty()) {
    				word = word + stk.pop();
    			}
    			if(!stk.isEmpty() && stk.peek() == '(') {
        			stk.pop();
    			}
    			if(!stk.isEmpty()) {								                // | ( & ( t , f , t ) , ! ( t ) )
        			ch = stk.pop();
    			}

    			if(ch == '&' && word.contains("f")) {
    				stk.push('f');
    			}
    			else if(ch == '&' && !word.contains("f")) {
    				stk.push('t');
    			}
    			else if(ch == '|' && word.contains("t")) {
    				stk.push('t');
    			}
    			else if(ch == '|' && !word.contains("t")) {
    				stk.push('f');
    			}
    			else if(ch == '!') {								              	// | ( & ( t , f , t ) , ! ( t ) )
    				for(int a=0; a<word.length(); a++) {
    					if(word.charAt(a) == 't') {
    						stk.push('f');
    					}
    					else {
    						stk.push('t');
    					}
    				}
    			}    			
    		}
    	}
    	if(stk.peek() == 'f') {
    		return false;
    	}
    	
    	return true;
    }
}
