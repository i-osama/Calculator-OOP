package Calculator;


import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

//Here, decimal Scale: 12


//Interface - Arithmetic Operations
interface Arithmetic {
double add(double... numbers);
double subtract(double... numbers);
double multiply(double... numbers);
double divide(double... numbers);
double modulus(double num1, double num2);
double absolute(double num);
}


//Geometric
interface Geometric {
double sin(double angle);
double cos(double angle);
double tan(double angle);
double tanh(double angle);
double sinh(double angle);
double cosh(double angle);

}

// Exponential 
interface Exponential {
    double square(double num);
    double squareRoot(double num);
    double cube(double num);
    double ln(double num);
    double exp(double num);
    double power(double base, double exponent);
    double log(double num);
    double log10(double num);
  
}

//Prime Number
interface PrimeNumber {
    boolean isPrime(int number); 
}


// Implementing all three interfaces
class ScientificCalculator implements Arithmetic, Geometric, Exponential, PrimeNumber {
	 // Arithmetic Operations
    @Override
    public double add(double... numbers) {
        double result = 0;
        for (double num : numbers) {
            result += num;
        }
        return result;
    }


    @Override
    public double subtract(double... numbers) {
        double result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result -= numbers[i];
        }
        return result;
    }


    @Override
    public double multiply(double... numbers) {
        double result = 1;
        for (double num : numbers) {
            result *= num;
        }
        return result;
    }


    @Override
    public double divide(double... numbers) {
        double result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] != 0) {
                result /= numbers[i];
            } else {
                System.out.println("Error: Cannot divide by zero.");
                return Double.NaN;
            }
        }
        return result;
    }


    @Override
    public double modulus(double num1, double num2) {
        return num1 % num2;
    }


    @Override
    public double absolute(double num) {
        return Math.abs(num);
    }


    // Geometric Operations
    @Override
    public double sin(double angle) {
        return Math.sin(angle);
    }
    @Override
    public double cos(double angle) {
        return Math.cos(angle);
    }


    @Override
    public double tan(double angle) {
        return Math.tan(angle);
    }


    @Override
    public double sinh(double angle) {
        return Math.sinh(angle);
    }


    @Override
    public double cosh(double angle) {
        return Math.cosh(angle);
    }


    @Override
    public double tanh(double angle) {
        return Math.tanh(angle);
    }


    // Exponential Operations
    @Override
    public double square(double num) {
        return num * num;
    }


    @Override
    public double squareRoot(double num) {
        return Math.sqrt(num);
    }


    @Override
    public double cube(double num) {
        return num * num * num;
    }


    @Override
    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }


    @Override
    public double log(double num) {
        return Math.log(num);
    }


    @Override
    public double log10(double num) {
        return Math.log10(num);
    }
    @Override
    public double ln(double num) {
        return Math.log1p(num - 1);
    }


    @Override
    public double exp(double num) {
        return Math.exp(num);
    }
    
	@Override
	public boolean isPrime(int number) {
		if (number <= 1) {
            return false; 
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false; 
            }
        }
        return true; 
	}



    // Constant value of pi up to 12 digits
    public static final BigDecimal PI = new BigDecimal("3.141592653589");
}

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ScientificCalculator calculator = new ScientificCalculator();


        System.out.println("Enter operation type:");
        System.out.println("A. Arithmetic");
        System.out.println("B. Geometric");
        System.out.println("C. Exponential");
        System.out.println("D. Prime Number");

        System.out.println();

        		System.out.print("Select your option: ");

        char operationType = Character.toLowerCase(scanner.next().charAt(0));
//        operationType = operationType.toLowerCase();
        
    
        	     switch (operationType) {
                 case 'a':
                     // Arithmetic Operations
                     System.out.println("Enter numbers for arithmetic operations:");
                     double[] numbers = new double[7];
                     for (int i = 0; i < 7; i++) {
                         System.out.print("Enter number " + (i + 1) + ": ");
                         numbers[i] = scanner.nextDouble();
                     }

                     System.out.println();

                     System.out.println("Addition: " + calculator.add(numbers));
                     System.out.println("Subtraction: " + calculator.subtract(numbers));
                     System.out.println("Multiplication: " + calculator.multiply(numbers));
                     System.out.println("Division: " + calculator.divide(numbers));
                     break;


                 case 'b':
                     // Geometric Operations
                     System.out.print("Enter angle in radians: ");
                     double angleInRadians = scanner.nextDouble();
                     
                     System.out.println();
                     System.out.println("Sine: " + calculator.sin(angleInRadians));
                     System.out.println("Cosine: " + calculator.cos(angleInRadians));
                     System.out.println("Tangent: " + calculator.tan(angleInRadians));
                     System.out.print("Enter angle in degrees: ");
                     double angleInDegrees = scanner.nextDouble();
                     System.out.println("Sine: " + calculator.sin(Math.toRadians(angleInDegrees)));
                     System.out.println("Cosine: " + calculator.cos(Math.toRadians(angleInDegrees)));
                     System.out.println("Tangent: " + calculator.tan(Math.toRadians(angleInDegrees)));
                     break;


                 case 'c':
                     // Exponential Operations
                     System.out.println("Choose an operation:");
                     System.out.println("1. Show constant 20-digit pi value");
                     System.out.println("2. Square");
                     System.out.println("3. Square Root");
                     System.out.println("4. Cube");
                     System.out.println("5. Power");
                     System.out.println("5. Logarithm (base e)");
                     System.out.println("6. Logarithm (base 10)");
                     System.out.println("7. Natural Logarithm (ln)");
                     System.out.println("8. Exponential Function (e^x)");
                     int expOperation = scanner.nextInt();
                     System.out.println();

                     switch (expOperation) {
                         case 1:
                             System.out.println("Constant 20-digit pi value: " + calculator.PI.toPlainString());
                             break;
                         case 2:
                             System.out.print("Enter a number to square: ");
                             double numToSquare = scanner.nextDouble();
                             System.out.println("Square: " + calculator.square(numToSquare));
                             break;
                         case 3:
                             System.out.print("Enter a number to find the square root: ");
                             double numForSquareRoot = scanner.nextDouble();
                             System.out.println("Square Root: " + calculator.squareRoot(numForSquareRoot));
                             break;
                         case 4:
                             System.out.print("Enter a number to cube: ");
                             double numToCube = scanner.nextDouble();
                             System.out.println("Cube: " + calculator.cube(numToCube));
                             break;
                         case 5:
                             System.out.print("Enter the base: ");
                             double baseForPower = scanner.nextDouble();
                             System.out.print("Enter the exponent: ");
                             double exponentForPower = scanner.nextDouble();
                             System.out.println("Power: " + calculator.power(baseForPower, exponentForPower));
                             break;
                         case 6:
                             System.out.print("Enter a number for logarithm (base e): ");
                             double logNum = scanner.nextDouble();
                             System.out.println("Logarithm (base e): " + calculator.log(logNum));
                             break;
                         case 7:
                             System.out.print("Enter a number for logarithm (base 10): ");
                             double log10Num = scanner.nextDouble();
                             System.out.println("Logarithm (base 10): " + calculator.log10(log10Num));
                             break;
                         case 8:
                             System.out.print("Enter a number for natural logarithm (ln): ");
                             double lnNum = scanner.nextDouble();
                             System.out.println("Natural Logarithm (ln): " + calculator.ln(lnNum));
                             break;
                         case 9:
                             System.out.print("Enter a number for exponential (e^x): ");
                             double expNum = scanner.nextDouble();
                             System.out.println("Exponential (e^x): " + calculator.exp(expNum));
                             break;
                         default:
                             System.out.println("Invalid exponential operation.");
                     }
                     break;
                     
                 case 'd':
                	  System.out.println("Enter the number to check if it's prime: ");
                      int number = scanner.nextInt();
                      if (calculator.isPrime(number)) {
                          System.out.println(number + " is a prime number.");
                      } else {
                          System.out.println(number + " is not a prime number.");
                      }
                      break;


                 default:
                     System.out.println("Invalid operation type.");
                     break;
                     
             }
        	
   
    }
}

