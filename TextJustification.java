package Zoho;

import java.util.List;
import java.util.ArrayList;

public class TextJustification {

	static StringBuilder str = new StringBuilder();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String words[] = {"This", "is", "an", "example", "of", "text", "justification."};
//		String words[] = {"What","must","be","acknowledgment","shall","be"};
		int maxWidth = 16;
		TextJustification obj = new TextJustification();
		List<String> result = obj.fullJustify(words, maxWidth);
		System.out.println(result);

	}
	
    public List<String> fullJustify(String[] words, int maxWidth) {
        
    	List<String> ans = new ArrayList();
    	
    	boolean flag = false;
    	
    	for(int i=0; i<words.length; i++) {
    		if(i == words.length-1) {
    			join(ans, words[i], maxWidth, true);
    		}
    		else {
    			join(ans, words[i], maxWidth, false);
    		}
    	}
    	
    	//LastWord Align Process
    	StringBuilder str2 = new StringBuilder();
    	str2.append(processLastWord(ans.get(ans.size()-1)));
    	ans.remove(ans.size()-1);
    	ans.add(str2.toString());
    	
    	for(String s : ans) {
    		System.out.println("First Index : " + s.charAt(0));
    		System.out.println(s.length());
    	}
    	
    	return ans;
    }
    
    public String processLastWord(String s) {
    	
    	StringBuilder sb = new StringBuilder();
    	for(int i=0; i<s.length(); i++) {
    		if(s.charAt(i) == ' ') {
    			sb.append(" ");
    			i = findNextIndex(i, s.toString())-1;
    		}
    		else {
    			sb.append(s.charAt(i));
    		}
    	}
    	int space = s.length() - sb.length();
    	for(int i=0; i<space; i++) {
    		sb.append(" ");
    	}
    	
    	return sb.toString();
    }
    
    public void join(List<String> list, String word, int wid, boolean flag) {
    	
    	int len = str.length()+word.length()+1;
    	if(word.length() >= wid-1) {
    		list.add(alaignStr(str.toString(), wid));
    		list.add(word);
    		str = new StringBuilder();
    	}
    	else if(len-1 == wid) {
    		str.append(word);
    		list.add(str.toString());
    		str = new StringBuilder();
    	}
    	else if(len <= wid) {
    		str.append(word+" ");
    	}
    	else if(len > wid) {
    		list.add(alaignStr(str.toString(), wid));
    		str = new StringBuilder();
    		str.append(word + " ");
    	}
    	
    	if(flag == true) {
    		System.out.println(str.toString());
    		list.add(alaignStr(str.toString(), wid));
    	}
    	
    }
    
    public String alaignStr(String word, int wid) {
    	
    	StringBuilder str2 = new StringBuilder();
    	str2.append(word);
    	
    	//Remove Space in the End
    	str2.deleteCharAt(str2.length()-1);
    	
    	int space = wid - str2.length();
    	
    	// No space only one word
    	for(int i=0; i<str2.length(); i++) {
    		if(str2.charAt(i) == ' ') {
    			break;
    		}
    		else if(i == str2.length()-1){
    			String spa = "";
    			for(int j=0; j<space; j++) {
    				spa += " ";
    			}
    			str2.append(spa);
    			return str2.toString();
    		}
    	}
    	
    	while(space > 0) {
    		int i = 0;
    		for(i=0; i<str2.length(); i++) {
    			if(str2.charAt(i) == ' ') {
    				str2.insert(i, " ");
    				space -= 1;
    				i = findNextIndex(i, str2.toString());
    				if(space == 0) {
    					break;
    				}
    			}
    			else {
    				continue;
    			}
    		}
    	}
    	    	
    	return str2.toString();
    }
    
    public int findNextIndex(int i, String str) {
    	
    	for(int j = i; j<str.length(); j++) {
			if(str.charAt(j) == ' ') {
				continue;
			}
			else {
				return j;
			}
		}
    	
    	return str.length()-1;
    }

}
