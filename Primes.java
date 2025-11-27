public class Primes {
    public static void main(String[] args) {
        // הגדרת משתנה n והכרזרה על מערך n + 1

        int n = Integer.parseInt(args[0]);
        boolean[]IsPrime = new boolean[n+1];

        // הכרזה על כל המשתנים בboolean true ו0 , 1 false
        for(int i =0; i <IsPrime.length; i++){
            IsPrime[i]=true;
        }
         IsPrime[0] = false;
         IsPrime[1] = false;

         //ריצה על כל המספרים עד שורש n ומימוש האלגוריתמם
         for(int i = 2; i<=Math.sqrt(n*1.0); i++){
            if(IsPrime[i]){// האם הוא ראשוני כלומר אמת 
                for(int j = i+i; j<n+1; j = j+i){
                    IsPrime[j] = false;
        
                }
            }
         }
         // לולאה של הדפסה של מספרים ראשוניים וסופרת כל הדפס
         int counter = 0;
         for(int i =0; i <IsPrime.length; i++){
            if (IsPrime[i]==true){
                counter++;
                System.out.println(i);
            }
}
    
         // שלב ג - הדפסה של הנתונים

        double totalNumbers = n - 1;
        double percentage = (counter / totalNumbers) * 100.0; // כפל ב-100.0 מבטיח חישוב Double

        // הדפסה בפורמט הנדרש
        System.out.printf("There are %d primes between 2 and %d (%.0f%% are primes).%n",counter,  n,percentage);
         
    }
}
