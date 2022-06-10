
public class ReverseString {

	public static void main(String[] args) {
		String input = "Test Seq 12345";    // �뀒�뒪�듃 �엯�젰 臾몄옄�뿴
		String t = reverse(input);
		System.out.println("Input string: " + input);
		System.out.println("Reversed string: " + t);
	}
  
	private static String reverse(String s) {
		ArrayStack<Character> st = new ArrayStack<>(s.length()); 
		for(int i = 0; i < s.length(); i++) 
			st.push(s.charAt(i));  // s�쓽 i踰� 臾몄옄. 踰덊샇�뒗 0踰덈��꽣 �떆�옉
		String output = "";
		while(!st.isEmpty())   
			output = output + st.pop();
		return output;
	}
} // 肄붾뱶 6-8
