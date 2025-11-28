public class Primes {
    public static void main(String[] args) {
        
        // --- שלב א: הכנה ---
        int n = Integer.parseInt(args[0]);
        // יצירת מערך בגודל n + 1 (עבור אינדקסים 0 עד n)
        boolean[]IsPrime = new boolean[n+1];

        // הכרזה על כל המשתנים כ-true (ראשוני)
        for(int i = 0; i < IsPrime.length; i++){
            IsPrime[i] = true;
        }
         IsPrime[0] = false; // 0 אינו ראשוני
         IsPrime[1] = false; // 1 אינו ראשוני

         // --- שלב ב: מימוש נפת ארטוסתנס ---
         // ריצה על כל המספרים עד שורש n
         for(int i = 2; i <= Math.sqrt(n * 1.0); i++){
            if(IsPrime[i]){// אם המספר הנוכחי הוא ראשוני (true)
                // סמן את כל הכפולות שלו כ"לא ראשוני" (false)
                for(int j = i + i; j < n + 1; j = j + i){
                    IsPrime[j] = false;
                }
            }
         }
         
         // --- שלב ג: הדפסה וספירה ---
         
         System.out.println("Prime numbers up to " + n + ":");

         int counter = 0;
         for(int i = 0; i < IsPrime.length; i++){
            if (IsPrime[i] == true){
                counter++;
                System.out.println(i);
            }
        }
    
         
        double totalNumbers = n; // המכנה הוא n (סך המספרים 1 עד n)
        double percentage = ((double)counter / totalNumbers) * 100.0; 

        
        System.out.printf("There are %d primes between 2 and %d (%.0f%% are primes)\n", counter, n, percentage);
         
    }
}