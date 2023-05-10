package MathPackage;

public class MathMaven {
    public String Query;
        public static void main(String[] args) {
        //    operatorsimple(6,-3);
        //    TrigonometricMath(90);
        // System.out.println("binary of i is :");
        //    toBinary(31); 
        // System.out.println("Hexadecimal of values decimal is: "+toHex(289));  
        // System.out.println("Decimal of values binary is: "+getDecimal(10101));  
        // System.out.println("Decimal of values hex is: "+getDecimal("f"));  
        // System.out.println("Decimal of values  octal is: "+getDecimal(10));    
        // System.out.println("Decimal  of values octal  is: "+toOctal(19)); 
        // equation(0, 4, 2); 
        // triangle_number(6);
        // triangle(5);
        // factoriel(2,3);
        // specific(8);
        isprime(17);
    
        }
        
      
        // public static void operatorsimple(double x,double y) {
        //     //return the sum of two numbers in int you should be concatenate in ineteger
        //     System.out.println("Sum number  of x and y is : "+Math.addExact((int)x, (int)y));
    
        //     //return the substract of two nummbers
        //     System.out.println("subtract number  of x and y is : "+Math.subtractExact((int)x, (int)y));
    
        //     //return the multiply of two numbers
        //     System.out.println("multiply number  of x and y is : "+Math.multiplyExact((int)x,(int) y));
    
        //     //return the division of two numbers
        //     System.out.println(" division number  of x and y is : "+Math.divideExact((int)x,(int) y));
    
        //     // incrementExact() with the int argument
        //     System.out.println(Math.incrementExact((int)x));  
    
        //     // decrementExact() with the int argument
        //     System.out.println(Math.decrementExact((int)x));
    
        //      // negateExact() with int arguments //negates the specified variable and returns it
        //     System.out.println(Math.negateExact((int)x));  // -3
        //     System.out.println(Math.negateExact((int)y));  // 6
    
        //     // return the maximum of two numbers  
        //     System.out.println("Maximum number of x and y is: "+Math.max(x, y));   
    
        //     // return the minimum of two numbers  
        //     System.out.println("Minimum number of x and y is: "+Math.min(x, y));   
    
        //     // return the square root of x
        //     System.out.println("Square root of x is: " + Math.sqrt(x));   
              
        //     // return the square root of y   
        //     System.out.println("Square root of y is: " + Math.sqrt(y));   
              
        //     //exp returns 6 power of 4 i.e. 6*6*6*6    
        //     System.out.println("Power of x and y is: " + Math.pow(x, y));      
      
        //     // return the logarithm of given value       
        //     System.out.println("Logarithm of x is: " + Math.log(x));   
        //     System.out.println("Logarithm of y is: " + Math.log(y));  
              
        //     // return the logarithm of given value when base is 10      
        //     System.out.println("log10 of x is: " + Math.log10(x));   
        //     System.out.println("log10 of y is: " + Math.log10(y));    
              
        //     // return the log of x + 1  
        //     System.out.println("log1p of x is: " +Math.log1p(x));    
      
        //     // return a power of 2    
        //     System.out.println("exp of a is: " +Math.exp(x)); 
              
        //     // return (a power of 2)-1  
        //     System.out.println("expm1 of a is: " +Math.expm1(x)); 
    
        //     // The absolute value of a number is equal to the number if the number is positive or zero and equal to the negative of the number if the number is negative.
        //     System.out.println("|" + x + "| is " + Math.abs(x));  
            
        //     // Truncating and Rounding functions
        //     // You can round off a floating point number  to the nearest integer with round()
        //     System.out.println(x + " is approximately " + Math.round(x));    
        //     System.out.println(y + " is approximately " + Math.round(y)); 
    
        //     // The "ceiling" of a number is the smallest integer greater than or equal to the number. Every integer is its own //ceiling.
        //      System.out.println("The ceiling of " + x + " is " + Math.ceil(x));
    
        //      // The "floor" of a number is the largest integer less than or equal to the number.
        //     // Every integer is its own floor.
        //     System.out.println("The floor of " + x + " is " + Math.floor(x));
    
        //      // The Math library defines a couple of useful constants:
        //     System.out.println("Pi is " + Math.PI);    
        //     System.out.println("e is " + Math.E);     
    
    
    
        // }   
        // public static void TrigonometricMath(double a){
    
        //        // converting values to radian    
        //        double b = Math.toRadians(a);   
        //         //converts angle from radians to degrees
        //        System.out.println(Math.toDegrees(b));
              
        //        // return the trigonometric sine of a      
        //        System.out.println("Sine value of a is: " +Math.sin(a));    
                 
        //        // return the trigonometric cosine value of a  
        //        System.out.println("Cosine value of a is: " +Math.cos(a));  
                 
        //        // return the trigonometric tangent value of a  
        //        System.out.println("Tangent value of a is: " +Math.tan(a));  
                 
        //        // return the trigonometric arc sine of a      
        //        System.out.println("Sine value of a is: " +Math.asin(a));    
                 
        //        // return the trigonometric arc cosine value of a  
        //        System.out.println("Cosine value of a is: " +Math.acos(a));  
                 
        //        // return the trigonometric arc tangent value of a  
        //        System.out.println("Tangent value of a is: " +Math.atan(a));  
         
        //        // return the hyperbolic sine of a      
        //        System.out.println("Sine value of a is: " +Math.sinh(a));    
                 
        //        // return the hyperbolic cosine value of a  
        //        System.out.println("Cosine value of a is: " +Math.cosh(a));  
                 
        //        // return the hyperbolic tangent value of a  
        //        System.out.println("Tangent value of a is: " +Math.tanh(a));  
        //    }  
        //convert  decimal to binary   
    //        public static void toBinary(int decimal){    
    //         int binary[] = new int[40];    
    //         int index = 0;    
    //         while(decimal > 0){    
    //           binary[index++] = decimal%2;    
    //           decimal = decimal/2;    
    //         }    
    //         for(int i = index-1;i >= 0;i--){    
    //           System.out.print(binary[i]);    
    //         }      
    //    }    
    
        //convert decimal to hexadecimal
        // public static String toHex(int decimal){    
        //  int rem;  
        //  String hex="";   
        //  char hexchars[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};  
        // while(decimal>0)  
        //  {  
        //    rem=decimal%16;   
        //    hex=hexchars[rem]+hex;   
        //    decimal=decimal/16;  
        //  }  
        // return hex;  
        // }    
        //convert binary to decimal
        // public static int getDecimal(int binary){  
        //     int decimal = 0;  
        //     int n = 0;  
        //     while(true){  
        //       if(binary == 0){  
        //         break;  
        //       } else {  
        //           int temp = binary%10;  
        //           decimal += temp*Math.pow(2, n);  
        //           binary = binary/10;  
        //           n++;  
        //        }  
        //     }  
        //     return decimal;  
        // } 
        //convert hex to decimal
        // public static int getDecimal(String hex){  
        //     String digits = "0123456789ABCDEF";  
        //              hex = hex.toUpperCase();  
        //              int val = 0;  
        //              for (int i = 0; i < hex.length(); i++)  
        //              {  
        //                  char c = hex.charAt(i);  
        //                  int d = digits.indexOf(c);  
        //                  val = 16*val + d;  
        //              }  
        //              return val;  
        // }  
        //convert octal to decimal
        // public static int getDecimal(int octal){    
        //     //Declaring variable to store decimal number  
        //     int decimal = 0;    
        //     //Declaring variable to use in power  
        //     int n = 0;    
        //     //writing logic   
        //     while(true){    
        //       if(octal == 0){    
        //         break;    
        //       } else {    
        //           int temp = octal%10;    
        //           decimal += temp*Math.pow(8, n);    
        //           octal = octal/10;    
        //           n++;    
        //        }    
        //     }    
        //     return decimal;    
        // }   
        //convert decimal to octal 
        // public static String toOctal(int decimal){    
        //     int rem; //declaring variable to store remainder  
        //     String octal=""; //declareing variable to store octal  
        //     //declaring array of octal numbers  
        //     char octalchars[]={'0','1','2','3','4','5','6','7'};  
        //     //writing logic of decimal to octal conversion   
        //     while(decimal>0)  
        //     {  
        //        rem=decimal%8;   
        //        octal=octalchars[rem]+octal;   
        //        decimal=decimal/8;  
        //     }  
        //     return octal;  
        // }   
    
        //solving quadratic equation
    //     public static  void equation(float a,float b,float c){
    // 		double delta=b*b-4*a*c;
    //         System.out.println("value of detrminant is : "+delta);
    // 		double  result;
    
    // 		if(a==0){
    // 			if(b==0){
    // 				System.out.println("aucune solution");
    // 			}else{
    //                 result=(-c)/(b);
    //                 System.out.println("the result is : "+result);
    // 			}
                
    // 		}
    // 		else {
    // 			if(delta<0)
    // 			{
    // 				System.out.println("the equation have no solution.");
    // 			}
    // 			else if(delta==0) 
    // 			{
    //                 result=-b/(2*a);
    // 				System.out.println("the equation have one solution is : "+result);
    // 			}
    // 			else if(delta>0) 
    // 			{
    //                 double result1=(-b+Math.sqrt(delta)/(2*a));
    //                 double result2=(-b-Math.sqrt(delta)/(2*a));
    
    // 				System.out.println("the equation have two solution :"+result1+" and "+result2);			
    // 			}
    // 	}
    // }
        //solving problems triangle withnumber and &
        // public static void triangle_number(int n)
        // {
        //     System.out.println();
        //     for(int i=n ; i>=1; i--)
        //     {
        //         for(int j=1 ; j<=i ; j++)
        //         {
        //             System.out.print(j);
        //         }
        //         for(int k=n ; k>i ; k--)
        //         {
        //             System.out.print("&");
        //         }
        //         System.out.println();
        //     }
           
        // }
        //problem solving triangle with @
        // {
        //     System.out.println();
        //     System.out.println("@");
        //     for(int i=n ; i>=1; i--)
        //     {
        //         System.out.print("@");
        //         for(int j=n ; j>=i ; j--)
        //         {
        //             System.out.print(" ");
        //         }
               
        //         System.out.println("@");
        //     }
        //     for(int j=n ; j>0 ; j--)
        //     {
        //         System.out.print("@ ");
        //     }       
        // }
    
        // problem solving specific
        // public static void specific(int n)
        // {
        //     for(int i=n ; i>=1 ; i--)
        //     {
        //         for(int j=1; j<i ; j++)
        //         {
        //             System.out.print(" ");
        //         }
        //         System.out.print("#");
        //         for(int k=n ; k>= i; k--)
        //         {
        //             System.out.print(" ");
        //         }
        //         for(int k=n ; k>= i; k--)
        //         {
        //             System.out.print(" ");
        //         }
        //         System.out.print("#");
        //         System.out.println();
    
        //     }
        //     for(int i=n ; i>=1 ; i--)
        //     {
        //         for(int j=n ; j >= i ; j--)
        //         {
        //             System.out.print(" ");
        //         }
        //         System.out.print("#");
        //         for(int k=1 ; k < i ; k++)
        //         {
        //             System.out.print(" ");
        //         }
        //         for(int k=1 ; k < i ; k++)
        //         {
        //             System.out.print(" ");
        //         }
        //         System.out.print("#");
        //         System.out.println();
        //     }
        // }
        // test number is prime or not 
        public static void isprime(int a)
        {
            boolean isprime=true; 
            for(int i=2 ; i<a/2 ;i++)
            {
                if(a % i == 0)
                {
                    isprime=false;
                    break;
                }
            }
            if(isprime)
            {
                System.out.println("Yes");
            }
            else
            {
                System.out.println("No");
            }
        }
        
}  
