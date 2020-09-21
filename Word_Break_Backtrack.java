import java.util.*;


public class Word_Break_Backtrack {

	
	public static void main(String args[]) {
		//Scanner sc = new Scanner(System.in);
		//int dict_total_words = sc.nextInt();
		/*
		Input  test1=  new Input(new String[] { "i", "like", "sam", "sung", "samsung", "mobile", "ice", 
		"cream", "icecream", "man", "go", "mango"}, new String("ilikesamsungmobile")  );
		*/
		
		/**/
		Input  test1=  new Input(new String[] {"micro","soft","hi","ring","hiring","microsoft"}, new String("microsofthiring")  );
		
		
		//12 words are there
		HashSet<String> dictionary = new HashSet<String>(); 
		
		//input the dictionary words
		for(int i=0;i<test1.dict.length;i++) {
			//dictionary.add(sc.next());
			dictionary.add(test1.dict[i]);
		}
		//ilikesamsungmobile - sample
		
		//String input = sc.next();
		String input = test1.input;
		
		wordBreak(input,"",dictionary);
		
	}
	
	
	
	
	
	//word break function
	public static void wordBreak(String input, String output,HashSet<String> dict) {
		if(input.length()==0) {
			System.out.println(output);
			
		}
		for(int i=0;i<input.length();i++) {
			String left = input.substring(0,i+1);
			if(dict.contains(left)) {
				String right = input.substring(i+1);
				wordBreak(right,output+left+" ",dict);
			}
		}
		
		
	}
	
}	



class Input{
	
	//dictionary array
	public String[] dict;
	//input string
	public String input;
	
	Input(String[] dict,String input){
		this.dict = dict;
		this.input = input; 
	}


}


