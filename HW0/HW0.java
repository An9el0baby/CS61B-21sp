public class HW0 {
    public static void month(Integer x ){
    switch (x){
        case 12:
            System.out.println("This is 12");
            break;
        case 13:
            System.out.println("This is 13");
    }
    }

    public static boolean isPrime(int n) {
        for (int divisor =2; divisor < n; divisor++){
            if (n % divisor ==0 ){
                return false;
            }
        }
        return true;
    }

    public static void printPrimes(int n) {
        int i;
        for (i = 2; i <= n; i++) {       
          if (isPrime(i)) {
            System.out.println(" " + i);
          }
        }
        System.out.println("i is " + i);
      }

    public static void printTriangle(int n){
        for (int i =1; i<=n; i++){
            for (int j=1; j<=i;j++){
                if (j ==1){
                    System.out.println("*");
                }
                else{
                    System.out.print("*");
                }
            }
        }
    } 

    public static int maximumArray(int[] m) {
        /** Returns the maximum value from m. */
        int max_number = 0;
        for (int i =0 ; i< m.length;i++){
            if (m[i]>max_number){
                max_number = m[i];
            }
        }
        return max_number;
    }



    public static void main(String[] args) {
        int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};   
        System.out.println(maximumArray(numbers));   
        }
    }

