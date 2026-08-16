import java.util.Scanner;
//ques 1 Write Java Program to Check Leap Year 
public class Main {
     public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  
         System.out.print("enter the year you want to check: ");
         int num = myObj.nextInt();
        
        
         if((num%4 == 0 && num%100 !=0) || (num %400 ==0)){
             System.out.println("the year " + num +" is a leap year.");
         }
        
         else{
             System.out.println("the year " + num +" is not a leap year.");
         }
     }
}


// ques 2 Write Java Program to Check Whether a Character is Alphabet or Not 
public class Main{
    public static void main(String[] args){
        Scanner myObj = new Scanner(System.in);
        System.out.println("enter a character");
         
        String check = myObj.nextLine();
        int len = check.length();
        if(len > 1){
            System.out.println("not a character");
        }else{
            System.out.println("a character");
        }
    }
}


//ques 3 Write Java Program to Find Factorial of a Number 
public class Main{
      public static void main(String[] args){
          Scanner input = new Scanner(System.in);
          System.out.print("enter the number of which you want factorial: ");
          int num  = input.nextInt();
          int fac = factorial(num);
          System.out.println(fac);
     }
         
    
    public static int factorial(int nums){
         int fact = 1;
         for(int i=1 ; i<=nums ; i++){
              fact = fact*i;
         }
         return fact;
     }
    
}

//ques 4 Write Java Program to Display Fibonacci Series 
  public class Main{
     public static void main(String[] args){
         Scanner input = new Scanner(System.in);
         System.out.print("enter the number to which you want number of series elements: ");
         int num = input.nextInt();
         for(int i=0 ; i<num; i++){
             System.out.print(fibo(i) + " ");
         }
     }
     public static int fibo(int n){
         if(n ==0){
             return 0;
         }else if(n==1){
             return 1;
         }else{
             return (fibo(n-1) + fibo(n-2));
         }
     }
  }

// Ques 5 Write Java Program to Find GCD of Two Numbers 
 public class Main{
     public static void main(String[] args){
         Scanner input = new Scanner(System.in);
         System.out.print("enter the first number: ");
         int num1 = input.nextInt();
         System.out.print("enter the second number: ");
         int num2 = input.nextInt();
        
         while(num1 != num2){
             if(num1 > num2){
                 num1 = num1 - num2;
             }else{
                 num2 = num2 - num1;
             }
         }
         System.out.println("GCD is " + num1);
     }
 }

// Ques 6 Write Java Program to Find LCM of Two Numbers 
public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("enter the first number: ");
        int num1 = input.nextInt();
        System.out.print("enter the second number: ");
        int num2 = input.nextInt();
        
        int lcm = (num1 > num2) ? num1 : num2;
        
        while(true){
            if(lcm % num1 == 0 && lcm % num2 == 0){
                System.out.println("LCM is " + lcm);
                break;
            }
            lcm++;
        }
    }
}

//ques 7 Write Java Program to Count Number of Digits in an Integer 
 public class Main{
     public static void main(String[] args){
         Scanner input = new Scanner(System.in);
         System.out.print("enter a number: ");
         int num = input.nextInt();
         int count = 0;
        
         for(int i=num ; i >0 ; i =i/10){
             count++;
         }
         System.out.print(count);
     }
 }
         
//ques 8 Write Java Program to Reverse a Number 
public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("enter a number: ");
        int num = input.nextInt();
        int rev=0;
        while(num>0){
            rev = (num%10) + rev*10;
            num = num/10;
        }
        
        System.out.print(rev);
    }
}

//ques 9 Write Java Program to Calculate the Power of a Number 
public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("enter a number: ");
        int base = input.nextInt();
        int pow = input.nextInt();
        
        long result = 1;

        for (int i = 1; i <= pow; i++) {
            result = result * base;
        }

        System.out.println("Power = " + result);

    }
    
}


// Ques 10 Write Java Program to Check Palindrome 
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = input.nextInt();

        int original = n;
        int reverse = 0;

        while (n != 0) {
            int digit = n % 10;
            reverse = reverse * 10 + digit;
            n = n / 10;
        }

        if (original == reverse)
            System.out.println("Palindrome");
        else
            System.out.println("Not a Palindrome");
    }
}

