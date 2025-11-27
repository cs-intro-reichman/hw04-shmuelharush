public class MyString {
    public static void main(String[] args) {
        System.out.println("Testing lowercase:");
        System.out.println("UnHappy : " + lowerCase("UnHappy"));
        System.out.println("This costs 15 Sheksls : " + lowerCase("This costs 15 Sheksls"));
        System.out.println("TLV : " + lowerCase("TLV"));
        System.out.println("lowercase : " + lowerCase("lowercase"));

        System.out.println("Testing contains:");
        System.out.println(contains("unhappy", "happy")); // true
        System.out.println(contains("happy", "unhappy")); // false
        System.out.println(contains("historical", "story")); // false
        System.out.println(contains("psychology", "psycho")); // true
        System.out.println(contains("personality", "son")); // true
        System.out.println(contains("personality", "dad")); // false
        System.out.println(contains("resignation", "sign")); // true
    }

  /** Returns the lowercase version of the given string. */
    public static String lowerCase(String str) {

        int sum = 0;
        String lowString="";

        for (int i=0; i<str.length();i++)
        {
            //בודק האן הוא אות גדולה
            char temp = str.charAt(i);
            if (temp >= 'A' && temp <= 'Z' ){
            sum = temp +32;
            //ממיר את המשתנה שהוא int חזרה לchar
            char lowerCase = (char)(sum);

            lowString = lowString + lowerCase;}
            else 
            {lowString = lowString + temp; }

        }
        return lowString;
    }
    /** If str1 contains str2, returns true; otherwise returns false. */
    public static boolean contains(String str1, String str2) {
        String newstr1 = lowerCase(str1);
        String newstr2 = lowerCase(str2);
        int length1 = newstr1.length();
        int length2 = newstr2.length();
            if(length1 < length2){
                return false;
            }
        for(int i = 0; i <= (length1 -length2); i++){
            int j = 0;
            for (j = 0; j < length2; j++){
                if(newstr1.charAt(i+j) != newstr2.charAt(j)){
                break;
                }
            }
            if(j==length2){
                return true;
            }
        }
        return false;
    }
}