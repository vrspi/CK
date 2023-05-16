package MathPackage;
import java.lang.Math;
public class MathMaven {
    public String Query;
        public static void main(String[] args) {
<<<<<<< Updated upstream

        toBinary(31); 
        System.out.println("Hexadecimal of values decimal is: "+toHex(289));  
        System.out.println("Decimal of values binary is: "+getDecimalFromBinary(10101));  
        System.out.println("Decimal of values hex is: "+getDecimal("f"));  
        System.out.println("Decimal of values  octal is: "+getDecimalFromOctal(10));    
        System.out.println("Decimal  of values octal  is: "+toOctal(19)); 
        equation(0, 4, 2); 
        triangle_number(6);
        triangle_at(5);
        specific(8);
        isprime(17);
        incerementNumb(12);
    }

        public static void SumNumb(double x,double y){
            //return the sum of two numbers in int you should be concatenate in ineteger
            System.out.println("Sum number  of x and y is : "+Math.addExact((int)x, (int)y));
=======
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
        isprime(8);
    
>>>>>>> Stashed changes
        }

        public static void SubtractNumb(double x,double y){
            //return the substract of two nummbers
            System.out.println("subtract number  of x and y is : "+Math.subtractExact((int)x, (int)y));
        }

        public static void multiplyNumb(double x,double y){
            //return the multiply of two numbers
            System.out.println("multiply number  of x and y is : "+Math.multiplyExact((int)x,(int) y));
        }

        public static void divisionNumb(double x,double y){
             //return the division of two numbers
             System.out.println(" division number  of x and y is : "+((int)x/(int) y));
        }

        public static void incerementNumb(int x){
               // incrementExact() with the int argument
               System.out.println(Math.incrementExact((int)x));  
        }

        public static void decrementNumb(int x){
             // decrementExact() with the int argument
             System.out.println(Math.decrementExact((int)x)); 
        }

        public static void maxNumb(double x,double y){
         // return the maximum of two numbers  
         System.out.println("Maximum number of x and y is: "+Math.max(x, y));   
        }

        public static void minNumb(double x,double y){
        // return the minimum of two numbers  
        System.out.println("Minimum number of x and y is: "+Math.min(x, y));    
        }

        public static void squareNumb(double x){
        // return the square root of x
        System.out.println("Square root of x is: " + Math.sqrt(x));   
        }

        public static void powerNumb(double x,double y){
         //exp returns 6 power of 4 i.e. 6*6*6*6    
         System.out.println("Power of x and y is: " + Math.pow(x, y));   
        }

        public static void logarithmNumb(double x){
          // return the logarithm of given value       
          System.out.println("Logarithm of x is: " + Math.log(x));  
        }

        public static void logbase10(double x){
        // return the logarithm of given value when base is 10      
        System.out.println("log10 of x is: " + Math.log10(x)); 
        }

        public static void expNumb(double x){
         // return a power of 2    
         System.out.println("exp of a is: " +Math.exp(x)); 
        }

        public static void valueabsolue(double x){
        // The absolute value of a number is equal to the number if the number is positive or zero and equal to the negative of the number if the number is negative.
        System.out.println("|" + x + "| is " + Math.abs(x)); 
        }

        public static void converttoRadians(double x){
             // converting values to radian    
             double y = Math.toRadians(x);  
        }

        public static void converttoDegrees(double x){
            //converts angle from radians to degrees
            double y = Math.toRadians(x);  
            System.out.println(Math.toDegrees(y));
        }

        public static void SineofNumb(double x){
             // return the trigonometric sine of a      
             System.out.println("Sine value of a is: " +Math.sin(x)); 
        }

        public static void CosofNumb(double x){
             // return the trigonometric cosine value of a  
             System.out.println("Cosine value of a is: " +Math.cos(x)); 
        }

        public static void TanofNumb(double x){ 
            // return the trigonometric tangent value of a  
            System.out.println("Tangent value of a is: " +Math.tan(x)); 
        }

        //convert  decimal to binary   
           public static void toBinary(int decimal){    
            int binary[] = new int[40];    
            int index = 0;    
            while(decimal > 0){    
              binary[index++] = decimal%2;    
              decimal = decimal/2;    
            }    
            for(int i = index-1;i >= 0;i--){    
              System.out.print(binary[i]);    
            }      
       }    
    
        //convert decimal to hexadecimal
        public static String toHex(int decimal){    
         int rem;  
         String hex="";   
         char hexchars[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};  
        while(decimal>0)  
         {  
           rem=decimal%16;   
           hex=hexchars[rem]+hex;   
           decimal=decimal/16;  
         }  
        return hex;  
        }  

        //convert binary to decimal
        public static int getDecimalFromBinary(int binary){  
            int decimal = 0;  
            int n = 0;  
            while(true){  
              if(binary == 0){  
                break;  
              } else {  
                  int temp = binary%10;  
                  decimal += temp*Math.pow(2, n);  
                  binary = binary/10;  
                  n++;  
               }  
            }  
            return decimal;  
        } 

       // convert hex to decimal
        public static int getDecimal(String hex){  
            String digits = "0123456789ABCDEF";  
                     hex = hex.toUpperCase();  
                     int val = 0;  
                     for (int i = 0; i < hex.length(); i++)  
                     {  
                         char c = hex.charAt(i);  
                         int d = digits.indexOf(c);  
                         val = 16*val + d;  
                     }  
                     return val;  
        } 

       // convert octal to decimal
        public static int getDecimalFromOctal(int octal){    
            //Declaring variable to store decimal number  
            int decimal = 0;    
            //Declaring variable to use in power  
            int n = 0;    
            //writing logic   
            while(true){    
              if(octal == 0){    
                break;    
              } else {    
                  int temp = octal%10;    
                  decimal += temp*Math.pow(8, n);    
                  octal = octal/10;    
                  n++;    
               }    
            }    
            return decimal;    
        }   

       // convert decimal to octal 
        public static String toOctal(int decimal){    
            int rem; //declaring variable to store remainder  
            String octal=""; //declareing variable to store octal  
            //declaring array of octal numbers  
            char octalchars[]={'0','1','2','3','4','5','6','7'};  
            //writing logic of decimal to octal conversion   
            while(decimal>0)  
            {  
               rem=decimal%8;   
               octal=octalchars[rem]+octal;   
               decimal=decimal/8;  
            }  
            return octal;  
        }   
    
      //  solving quadratic equation
        public static  void equation(float a,float b,float c){
    		double delta=b*b-4*a*c;
            System.out.println("value of detrminant is : "+delta);
    		double  result;
    
    		if(a==0){
    			if(b==0){
    				System.out.println("aucune solution");
    			}else{
                    result=(-c)/(b);
                    System.out.println("the result is : "+result);
    			}
                
    		}
    		else {
    			if(delta<0)
    			{
    				System.out.println("the equation have no solution.");
    			}
    			else if(delta==0) 
    			{
                    result=-b/(2*a);
    				System.out.println("the equation have one solution is : "+result);
    			}
    			else if(delta>0) 
    			{
                    double result1=(-b+Math.sqrt(delta)/(2*a));
                    double result2=(-b-Math.sqrt(delta)/(2*a));
    
    				System.out.println("the equation have two solution :"+result1+" and "+result2);			
    			}
    	}
    }

      //  solving problems triangle withnumber and &
        public static void triangle_number(int n)
        {
            System.out.println();
            for(int i=n ; i>=1; i--)
            {
                for(int j=1 ; j<=i ; j++)
                {
                    System.out.print(j);
                }
                for(int k=n ; k>i ; k--)
                {
                    System.out.print("&");
                }
                System.out.println();
            }
           
        }

      //  problem solving triangle with @
      public static void triangle_at(int n)
        {
            System.out.println();
            System.out.println("@");
            for(int i=n ; i>=1; i--)
            {
                System.out.print("@");
                for(int j=n ; j>=i ; j--)
                {
                    System.out.print(" ");
                }
               
                System.out.println("@");
            }
            for(int j=n ; j>0 ; j--)
            {
                System.out.print("@ ");
            }    
            System.out.println();
        }
    
      //  problem solving specific
        public static void specific(int n)
        {
            System.out.println();
            for(int i=n ; i>=1 ; i--)
            {
                for(int j=1; j<i ; j++)
                {
                    System.out.print(" ");
                }
                System.out.print("#");
                for(int k=n ; k>= i; k--)
                {
                    System.out.print(" ");
                }
                for(int k=n ; k>= i; k--)
                {
                    System.out.print(" ");
                }
                System.out.print("#");
                System.out.println();
    
            }
            for(int i=n ; i>=1 ; i--)
            {
                for(int j=n ; j >= i ; j--)
                {
                    System.out.print(" ");
                }
                System.out.print("#");
                for(int k=1 ; k < i ; k++)
                {
                    System.out.print(" ");
                }
                for(int k=1 ; k < i ; k++)
                {
                    System.out.print(" ");
                }
                System.out.print("#");
                System.out.println();
            }
        }

      //  test number is prime or not 
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
