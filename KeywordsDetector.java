public class KeywordsDetector {
    
    // --- 1. שיטת main (קריאה לתוכנית) ---
    public static void main(String[] args) {
        String[] sentences = {
            "Our product will transform the market",
            "Programming is both painful and engaging",
            "This has nothing to do with machine learning",
            "We need to leverage our core competencies",
            "Let's talk about data and algorithms",
            "Chatbots are great but must be used carefully",
            "This blockchain-based solution will disrupt the industry",
            "The team showed great Synergy in the last project",
            "Use simple words without hype and fluff",
            "Our new technology presents a significant paradigm shift",
            "Effective presentations must be clear, concise, and humble"
        };
        // Some keywords that typically signal bullshit contents in business presentations 
        String[] keywords = {"synergy", "disrupt", "leverage", "Paradigm", "transform"};
        detectAndPrint(sentences, keywords);
    }

    // --- 2. השיטה הראשית detectAndPrint ---
    // Iterates through all the sentences.
    // If a sentence contains one or more of the kewords, prints it.
    public static void detectAndPrint(String[] sentences, String[] keywords) {
        
        // **הערה חשובה:** כדי שהקוד יעבוד, נדרש גם מימוש של MyString.lowerCase!

        // יצירת מערך חדש lowerkeywords והמרת מילות מפתח לאותיות קטנות
        String[] lowerKeywords = new String[keywords.length];
        for(int i = 0; i < keywords.length; i++){
            // (בהנחה ש-MyString זמין ו-lowerCase עובד)
            lowerKeywords[i] =  MyString.lowerCase(keywords[i]); 
        }

        // יצירת מערך חדש למשפטים באותיות קטנות 
        String[] lowerSentences = new String[sentences.length];
        for(int i = 0; i < sentences.length; i++){
            lowerSentences[i] = MyString.lowerCase(sentences[i]);
        }

        // לולאה חיצונית: מעבר על כל משפט
        for (int i = 0; i < sentences.length; i++) {
            
            boolean isBullshit = false; 
          
            // לולאה פנימית: בדיקת מילות המפתח מול המשפט הנוכחי
            for (int j = 0; j < lowerKeywords.length; j++) {
                
                // כאן מתבצעת הקריאה לפונקציית contains הממומשת למטה:
                if (contains(lowerSentences[i], lowerKeywords[j])) { 
                    isBullshit = true; 
                    break; 
                }
            }
            
            // הדפסת התוצאה
            if (isBullshit) {
                System.out.println(sentences[i]); 
            }
        }
    }
    
    /**
     * בודק אם str1 מכיל את str2.
     * מניח ששתי המחרוזות כבר הומרו לאותיות קטנות.
     */
    public static boolean contains(String str1, String str2) {
        int length1 = str1.length();
        int length2 = str2.length();
        
        // מקרה גבול: str1 קצרה מדי
        if (length1 < length2) {
            return false;
        }
        
        // לולאה חיצונית: נקודת התחלה
        for (int i = 0; i <= (length1 - length2); i++) {
            int j = 0;
            // לולאה פנימית: בדיקת התאמה תו-אחר-תו
            for (j = 0; j < length2; j++) {
                if (str1.charAt(i + j) != str2.charAt(j)) {
                    break; // אי-התאמה, עוברים לנקודת ההתחלה הבאה
                }
            }
            // אם הלולאה הפנימית סיימה עד הסוף (לא הופעל break)
            if (j == length2) {
                return true; // נמצאה התאמה
            }
        }
        return false; // לא נמצאה התאמה אחרי כל הבדיקות
    }
}