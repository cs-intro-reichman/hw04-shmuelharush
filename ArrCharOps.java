/** A library of operations on arrays of characters (char values).
 *  The library also features a string comparison method. */
public class ArrCharOps {
    public static void main(String[] args) {
        String str = "clearly";
        char[] arr1 = {'c','l','e','a','r','l','y'};
        char[] arr2 = {'U','n','d','e','r','s','t', 'o', 'o', 'd'};
        System.out.println(str);  // Prints the string
        println(arr1);            // Prints an array of characters
        System.out.println(charAt(arr1,2));      
        System.out.println(indexOf(arr1,'l'));  
        System.out.println(indexOf(arr1,'l',3)); 
        System.out.println(lastIndexOf(arr1, 'l'));
        System.out.println(concat(arr1, arr2));
        System.out.println(subArray(arr2, 2, 9));
        System.out.println(compareTo("abcd", "abcd"));
        System.out.println(compareTo("abc", "abcd"));
        System.out.println(compareTo("abw", "abcd"));
        System.out.println(compareTo("Abcd", "a"));
        System.out.println(compareTo("apple", "banana"));
        System.out.println(compareTo("apple", "applepie"));
        System.out.println(compareTo("Zoo", "zoo"));
        System.out.println(hashCode(arr1));
        System.out.println(hashCode(arr2));
    }

    /** Prints the given array of characters, and moves the cursor to the next line.
     */
    public static void println(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    /** Returns the char value at the specified index. Assume that the array is non-empty.
     */
    public static char charAt(char[] arr, int index) {
      
        return arr[index];
    }

    /** If the two arrays have the same value in every index, 
     *  returns true; Otherwise returns false.
     */
    public static boolean equals(char[] arr1, char[] arr2) {
        if(arr1.length != arr2.length){
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
           if(arr1[i]!=arr2[i]){
            return false;
           } 
        }

        return true;
    }

    /** Returns the index within the given array of the first occurrence of the given character.
     *  If no such character is found, returns -1.
     */
    public static int indexOf(char[] arr, char ch) {
            for (int i = 0; i < arr.length; i++) {
                if(arr[i]==ch){
                    return i;
                }
            }
        return -1;
    }

    /** Same as indexOf(char[], char), but starts the search in the given index.
     */
    public static int indexOf(char[] arr, char ch, int fromIndex) {
        for (int i = fromIndex; i < arr.length; i++) {
            if(arr[i]==ch){
                return i;
            }
        }
        return -1;
    }

    /** Returns the index within the given arr of the last occurrence of the given character.
     *  If no such character is found, returns -1.
     */
    public static int lastIndexOf(char[] arr, char ch) {
       for(int i = arr.length -1; i >=0; i--){
        if(arr[i]==ch){
            return i;
        }
       }
        return -1;
    }

    /* Returns an array which is the concatanation of the two given arrays.
    */
    public static char[] concat(char[] arr1, char[] arr2) {
            int newLength = arr1.length + arr2.length;
            char[] result = new char[newLength];
            //העתקת arr1
            for(int i=0; i<arr1.length; i++){
                result[i]=arr1[i];
            }
            // התעקת arr2 
            for (int j = 0; j < arr2.length; j++) {
                int resultIndex = arr1.length+j;
              result[resultIndex] = arr2[j];
            
            }

        return  result;
    }

    /** Returns a new array that can be described as a sub-array of this array.
     *  The sub-array begins at the specified beginIndex and extends to the character at index endIndex - 1.
     *  For example, if arr contains the characters "hamburger", then subArray(4, 8) returns an array of
     *  characters containing the characters "urge".
     */     
    
    public static char[] subArray(char[] arr, int beginIndex, int endIndex) {
         int length = endIndex - beginIndex;
        char[] result = new char[length];

        for(int i = beginIndex; i<endIndex; i++){
            // שלב העתקה
            int resultIndex = i - beginIndex;

            result[resultIndex] = arr[i];

        }
        return result;
    }

     /** Returns a single integer that represents the given array. This integer is sometimes 
     *  referred to as the array's "hash code". Later in the course we'll explain what these 
     *  hash codes are used for. For now, simply implement the specification given below.
     *  The hash code is computed as: arr[0]*7^(n-1) + arr[1]*7^(n-2) + ... + arr[n-2]*7 + arr[n-1]
     *  where arr[i] is the i'th character of the array, and n is the array's length.
     *  The hash value of an empty array is zero.
     */
    public static long hashCode(char[] arr) {
        //טיפול במקרה קצה מערך ריק
       if(arr.length==0){
        return 0;
       }
       // הגדרה ואתחול משתנה שנקבל בסוף 
       long hash =0;
       // כתיבת לולאה - ליבת הקוד 
       for(int i =0; i<arr.length; i++){
        //התחלה מhash שווה אפס ורק המס ביטים של האיבר במקום ה0 למשל a = 67 וככה מתקדם על כל הלולאה  
        hash = hash * 7 + arr[i];

       }
        return hash;
    }

    /**
     * Compares the two strings lexicographically.
     * Assume that both strings are not empty.
     * 
     * Characters are compared one by one from left to right, using their numeric Unicode values,
        as follows:
     * 1. If two characters at the same position in both strings are different,
     *    the string with the smaller character is considered lexicographically smaller.
     * 2. If all characters in the shorter string match the corresponding characters
     *    in the longer string, the shorter string is considered lexicographically smaller.
     * 3. If both strings have the same characters and the same length, they are considered equal.
     * 
     * Examples:
     * - "apple" is less than "banana" because 'a' comes before 'b'.
     * - "abc" is less than "abcd" because it is shorter.
     * - "hello" is equal to "hello".
     * - "date" is greater than "dark" because 't' comes after 'k'.
     * 
     * @param str1 the first string to compare
     * @param str2 the second string to compare
     * @return -1 if str1 is lexicographically less than str2,
     *         zero if they are equal, and 1 if str1 is
     *         lexicographically greater than str2.
     *         return -2 if there is an error with the input.
     */
       

   public static int compareTo(String str1, String str2) {
    
    if (str1 == null || str2 == null || str1.isEmpty() || str2.isEmpty()) {
        return -2;
    }
    int minlength = Math.min(str1.length() , str2.length());
        for (int i=0; i<minlength; i++){

            char char1 = str1.charAt(i);
            char char2 = str2.charAt(i);
                if (char1 < char2){
                 return -1;
             } if (char1 > char2){
                 return 1;
               }
        }
        int length1 = str1.length();
        int length2 = str2.length();
                if (length1 < length2){
                   return -1;
                } else if (length1 > length2){
                   return 1;
           } else {
                 return 0;
                }
            }
        }