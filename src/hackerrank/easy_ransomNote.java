package hackerrank;

public class easy_ransomNote {

	public static void main(String[] args) {
		//String[] magazine = {"give", "me", "one", "grand", "today", "night"};
		//String[] note = {"give", "one", "grand", "today"};	//Yes
		String[] magazine = {"two","times","three","is","not","four"};
		String[] note = {"two","times","two","is","four"};	//No
		checkMagazine(magazine, note);
	}
	
	private static void checkMagazine(String[] magazine, String[] note) {
		String sRet = "Yes";
		
		for (int i = 0; i < note.length; i++) {
			for (int j = 0; j < magazine.length; j++) {
				if(note[i].equals(magazine[j])){
					magazine[j] = "";
					note[i] = "";
					break;
				}
			}
			
			if(!note[i].equals("")) {
				sRet = "No";
				break;
			}
		}
		
		System.out.println(sRet);
	}

}
