public class P2J3 {
    public static void reverseAscendingSubarrays(int[] items){  
        int index = 0;
        
        for(int i = 0; i < items.length; i++){
            if(i == items.length - 1 || items[i + 1] < items[i]){
                int rSide = i;
                int lSide = index;

                while(rSide > lSide){
                    int temp = items[lSide];
                    items[lSide] = items[rSide];
                    items[rSide] = temp;

                    rSide--;
                    lSide++;
                }
                index = i + 1;
            }
        }
    }

    public static String pancakeScramble(String text){
        
        for(int i = 2; i <= text.length(); i++){
            text = new StringBuilder(text.substring(0,i)).reverse().toString() + text.substring(i);
        }
        return text;
    }

    public static String reverseVowels(String text){
        String vowel = "";
        String revTxt = "";

        for(int i = 0; i < text.length(); i++){
            if(text.charAt(i)=='A' || text.charAt(i)=='E' || text.charAt(i)=='I' || text.charAt(i)=='O' || text.charAt(i)=='U' || text.charAt(i)=='a' || text.charAt(i)=='e' || text.charAt(i)=='i' || text.charAt(i)=='o' || text.charAt(i)=='u'){
                vowel = text.charAt(i)+ vowel;
            }
        }

        int scndIdx = 0;
        for(int i = 0; i < text.length(); i++){

            if(text.charAt(i)=='A' || text.charAt(i)=='E' || text.charAt(i)=='I' || text.charAt(i)=='O' || text.charAt(i)=='U' || text.charAt(i)=='a' || text.charAt(i)=='e' || text.charAt(i)=='i' || text.charAt(i)=='o' || text.charAt(i)=='u'){
                
                if(Character.isUpperCase(text.charAt(i))){
                    revTxt = revTxt + Character.toUpperCase(vowel.charAt(scndIdx));
                    scndIdx++;
                }
                else{
                    revTxt = revTxt + Character.toLowerCase(vowel.charAt(scndIdx));
                    scndIdx++;
                }
            }
            else{
                revTxt = revTxt + text.charAt(i);
            }
        }
        return revTxt;
    }
}
    

  

