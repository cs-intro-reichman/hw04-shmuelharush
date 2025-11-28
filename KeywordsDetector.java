public class KeywordsDetector {
    
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
        String[] keywords = {"synergy", "disrupt", "leverage", "Paradigm", "transform"};
        detectAndPrint(sentences, keywords);
    }

    /**
     * עובר על כל המשפטים. אם משפט מכיל אחת ממילות המפתח, הוא מודפס.
     */
    public static void detectAndPrint(String[] sentences, String[] keywords) {
        
        // יצירת מערך lowerKeywords והמרת מילות מפתח לאותיות קטנות (באמצעות MyString)
        String[] lowerKeywords = new String[keywords.length];
        for(int i = 0; i < keywords.length; i++){
            lowerKeywords[i] =  MyString.lowerCase(keywords[i]); 
        }

        // יצירת מערך lowerSentences והמרת משפטים לאותיות קטנות (באמצעות MyString)
        String[] lowerSentences = new String[sentences.length];
        for(int i = 0; i < sentences.length; i++){
            lowerSentences[i] = MyString.lowerCase(sentences[i]);
        }

        // לולאה חיצונית: מעבר על כל משפט
        for (int i = 0; i < sentences.length; i++) {
            
            boolean isBullshit = false; 
          
            // לולאה פנימית: בדיקת מילות המפתח
            for (int j = 0; j < lowerKeywords.length; j++) {
                
                // קריאה לפונקציית contains המקומית
                if (contains(lowerSentences[i], lowerKeywords[j])) { 
                    isBullshit = true; 
                    break; // נמצאה מילת מפתח, אין צורך לבדוק את השאר
                }
            }
            
            // הדפסת המשפט המקורי (sentences[i])
            if (isBullshit) {
                System.out.println(sentences[i]); 
            }
        }
    }
    
    /**
     * בודק אם str1 מכיל את str2.
     * הערה: הקלטות (str1, str2) חייבות להיות כבר באותיות קטנות.
     */
    public static boolean contains(String str1, String str2) {
        // אם אחת המחרוזות היא null, נחזיר false (למרות שכבר הגנו על זה ב-detectAndPrint)
        if (str1 == null || str2 == null) {
            return false;
        }

        int length1 = str1.length();
        int length2 = str2.length();
        
        if (length1 < length2) {
            return false;
        }
        
        for (int i = 0; i <= (length1 - length2); i++) {
            int j = 0;
            for (j = 0; j < length2; j++) {
                if (str1.charAt(i + j) != str2.charAt(j)) {
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