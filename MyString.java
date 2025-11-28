public class MyString {
    public static void main(String[] args) {
        // ... קוד בדיקה מקומי
    }

    /** מחזיר את הגרסה באותיות קטנות של המחרוזת הנתונה. 
     * מחזיר null אם הקלט הוא null.
     */
    public static String lowerCase(String str) {
        
        if (str == null) {
            return null;
        }

        String lowString = "";

        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);

            // בדיקה האם התו הוא אות גדולה (A-Z)
            if (current >= 'A' && current <= 'Z') {
                // המרה לאות קטנה: הוספת 32 לערך ה-ASCII
                current = (char)(current + 32); 
            }
            
            // הוספת התו המעובד (שהומר או נשאר זהה) למחרוזת החדשה
            lowString = lowString + current; 
        }
        return lowString;
    }

    /** בודק אם str1 מכילה את str2 (בדיקה לא רגישה לאותיות). */
    public static boolean contains(String str1, String str2) {
        
        String newstr1 = lowerCase(str1);
        String newstr2 = lowerCase(str2);
        
        if (newstr1 == null || newstr2 == null) {
            return false;
        }

        int length1 = newstr1.length();
        int length2 = newstr2.length();
        
    
        if (length2 == 0) {
            return true;
        }
        
        // מקרה גבול: אם המחרוזת הראשונה קצרה מהשנייה
        if (length1 < length2) {
            return false;
        }

        // הלולאות המקוננות לבדיקת הכלה (לוגיקה זו תקינה)
        for (int i = 0; i <= (length1 - length2); i++) {
            int j = 0;
            for (j = 0; j < length2; j++) {
                if (newstr1.charAt(i + j) != newstr2.charAt(j)) {
                    break;
                }
            }
            if (j == length2) {
                return true; 
            }
        }
        
        return false;
    }
}