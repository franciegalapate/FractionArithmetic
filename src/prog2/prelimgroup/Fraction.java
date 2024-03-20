package prog2.prelimgroup;
public class Fraction {
    protected prog2.prelimgroup.Fraction Fraction;
    private int numerator, denominator;
    public Fraction() {
        /* Method: Default Constructor
         * Purpose: Create a new Fraction object and initialize it with "invalid" data.
         * Parameters: None
         * Preconditions: None
         * Post conditions: A new fraction object is created with the numerator and denominator set to 0. */
        numerator = 0;
        denominator = 0;
    }

    public Fraction(int num, int den) {
        /* Constructor: Fraction
         * Purpose: Create a new Fraction object and initialize it with the given numerator and denominator.
         * Parameters:
         *     - num: The numerator of the fraction.
         *     - den: The denominator of the fraction.
         * Preconditions: None
         * Post-conditions: A new Fraction object is created with the specified numerator and denominator values. */
        numerator = num;
        denominator = den;
    }

    public void setNumerator(int num) {
        /* Method: setNumerator
         * Purpose: Set the numerator of the Fraction object to the given value.
         * Parameters:
         *     - num: The new value for the numerator.
         * Preconditions: None
         * Post-conditions: The numerator of the Fraction object is updated to the specified value. */
        numerator = num;
    }

    public int getNumerator() {
        /* Method: getNumerator
         * Purpose: Retrieve the numerator of the Fraction object.
         * Parameters: None
         * Preconditions: None
         * Post-conditions: The numerator of the Fraction object is returned. */
        return numerator;
    }

    public void setDenominator(int den) {
        /* Method: setDenominator
         * Purpose: Set the denominator of the Fraction object to the specified value.
         * Parameters:
         *     - den: The new value for the denominator.
         * Preconditions: None
         * Post-conditions: The denominator of the Fraction object is updated with the specified value. */
        denominator = den;
    }

    public int getDenominator() {
        /* Method: getDenominator
         * Purpose: Retrieve the denominator of the Fraction object.
         * Parameters: None
         * Preconditions: None
         * Post-conditions: The denominator of the Fraction object is returned. */
        return denominator;
    }

    public String toString() {
        /* Method: toString
         * Purpose: Generate a string representation of the Fraction object, including
         * the fraction in the form of numerator/denominator and its equivalent decimal representation.
         * Parameters: None
         * Preconditions: None
         * Post-conditions: A formatted string containing the fraction and its decimal representation is returned. */
        double decimalResult = toDouble();
        return String.format("| Result is:  %d/%d or %.2f |", numerator, denominator, decimalResult);
    }

    public double toDouble() {
        /* Method: toDouble
         * Purpose: Calculate and return the decimal representation of the Fraction object.
         * Parameters: None
         * Preconditions: None
         * Post-conditions: The decimal representation of the fraction is returned, or NaN if the denominator is 0. */
        return (denominator == 0) ? Double.NaN : (double) numerator / denominator;
    }

    private void computeGCD(int x, int y) {
        /* Method: computeGCD
         * Purpose: Compute the Greatest Common Divisor (GCD) of two integers and print the result.
         * Parameters:
         *     - x: The first integer.
         *     - y: The second integer.
         * Preconditions: None
         * Post-conditions: The GCD of x and y is computed and printed. */
        int gcd = 1;
        for (int i = 1; i <= x && i <= y; i++) {
            if (x % i == 0 && y % i == 0) {
                gcd = i;
            }
            System.out.println("GCD of " + x + " and " + y + " is: " + gcd);
        }
    }

    public Fraction add(Fraction b) {
        /* BY ROBERT SEJ CUBE & PRINCE ASHRIN YXIE MENDOZA
         * Method: add
         * Purpose: Add the current fraction to another fraction.
         * Parameters:
         *     - b: The fraction to be added to the current fraction.
         * Preconditions:
         *     - The denominators of both fractions must not be zero.
         * Post-conditions:
         *     - A new Fraction object is created representing the sum of the current fraction and fraction b.
         *     - The resulting fraction is reduced to its simplest form.
         * Throws:
         *     - IllegalArgumentException if the denominators of either fraction are zero. */

        // Find the lowest common denominator
        int common = lcd(denominator, b.denominator);

        // Convert fractions to LCD
        Fraction commonA = new Fraction();
        Fraction commonB = new Fraction();
        commonA = convert(common);
        commonB = b.convert(common);

        // Create a new fraction to return as the sum
        Fraction sum = new Fraction();

        // Calculate sum
        sum.numerator = commonA.numerator + commonB.numerator;
        sum.denominator = common;

        // Reduce the resulting fraction
        sum = sum.reduce();
        return sum;
    }

    public Fraction subtract(Fraction b) {
        /* BY JHON MICHAEL FERRER & FRANCIE GALAPATE
         * Method: subtract
         * Purpose: Subtract the given fraction (b) from this fraction.
         * Parameters:
         *   - b: The fraction to subtract.
         * Preconditions:
         *   - The denominators of both fractions must not be zero.
         * Post-conditions:
         *   - A new Fraction object is created representing the result of the subtraction.
         *   - The resulting fraction is reduced to its simplest form.
         * Throws:
         *   - IllegalArgumentException if the denominators of either fraction are zero.
         */

        // Find the lowest common denominator
        int common = lcd(denominator, b.denominator);

        // Convert fractions to lcd
        Fraction commonA = convert(common);
        Fraction commonB = b.convert(common);

        // Create a new fraction to return as the difference
        Fraction difference = new Fraction();
        difference.numerator = commonA.numerator - commonB.numerator;
        difference.denominator = common;

        // Reduce the resulting fraction
        difference = difference.reduce();
        return difference;
    }

    public Fraction multiply(Fraction b) {
        /* BY JON DELVIC CALUB
         * Method: multiply
         * Purpose: Multiply the current fraction by another fraction.
         * Parameters:
         *   - b: The fraction to be multiplied with the current fraction.
         * Preconditions:
         *   - The denominators of both fractions must not be zero.
         * Post-conditions:
         *   - A new Fraction object is created representing the product of the current fraction and fraction b.
         *   - The resulting fraction is reduced to its simplest form.
         * Throws:
         *   - IllegalArgumentException if the denominators of either fraction are zero. */

        // Create a new fraction to return as the product
        Fraction product = new Fraction();

        // Calculate product
        product.numerator = numerator * b.numerator;
        product.denominator = denominator * b.denominator;

        // Reduce the resulting fraction
        product = product.reduce();
        return product;
    }

    public Fraction divide(Fraction b) {
        /* BY FRANCIE GABRIELLE GALAPATE
         * Method: divide
         * Purpose: Divide the current fraction by another fraction.
         * Parameters:
         *   - b: The fraction to be divided by the current fraction.
         * Preconditions:
         *   - The denominators of both fractions must not be zero.
         * Post-conditions:
         *   - A new Fraction object is created representing the quotient of the current fraction and fraction b.
         *   - The resulting fraction is reduced to its simplest form.
         * Throws:
         *   - IllegalArgumentException if the denominators of either fraction are zero. */

        // Create a new fraction to return as the quotient
        Fraction quotient = new Fraction();

        // Calculate quotient
        quotient.numerator = numerator * b.denominator;
        quotient.denominator = denominator * b.numerator;

        // Reduce the resulting fraction
        quotient = quotient.reduce();

        return quotient;
    }

    public void reducingFraction(int a, int b) {
        /* BY WILIAN DOMINIC MANUNTAG
         * Method: reducingFraction
         * Purpose: Reduce a fraction represented by the numerator 'a' and denominator 'b'.
         * Parameters:
         *   - a: The numerator of the fraction.
         *   - b: The denominator of the fraction.
         * Preconditions:
         *   - The numerator 'a' and denominator 'b' must not be zero.
         * Post-conditions:
         *   - If the denominator 'b' is 1, the output is the numerator 'a'.
         *   - If the numerator 'a' is less than the denominator 'b', the output is the reduced fraction
         *     and its decimal equivalent.
         *   - The program terminates after displaying the output. */

        if(b == 1){
            System.out.println(" "+a);
        }
        if(a < b) {
            int gcd = gcd(a, b);
            double deci = ((double)a)/b;
            System.out.print(" "+a / gcd + "/" + b / gcd + " or " + deci);
        }
    }

    // ADDITIONAL OPERATIONS
    private int lcd(int d1, int d2) {
        /* Method: lcd
         * Purpose: Find the least common denominator of two integers.
         * Parameters:
         *   - d1: The first integer.
         *   - d2: The second integer.
         * Returns:
         *   - The least common denominator of 'd1' and 'd2'. */

        int factor = d1;
        while ((d1 % d2) != 0)
            d1 += factor;
        return d1;
    }
    private int gcd(int d1, int d2) {
        /* Method: gcd
         * Purpose: Find the greatest common divisor of two integers.
         * Parameters:
         *   - d1: The first integer.
         *   - d2: The second integer.
         * Returns:
         *   - The greatest common divisor of 'd1' and 'd2'. */

        int factor;
        while (d2 != 0) {
            factor = d2;
            d2 = d1 % d2;
            d1 = factor;
        }
        return d1;
    }
    private Fraction convert(int common) {
        /* Method: convert
         * Purpose: Convert the current fraction to a specified common denominator.
         * Parameters:
         *   - common: The common denominator to convert to.
         * Returns:
         *   - A new Fraction object representing the converted fraction. */

        Fraction result = new Fraction();
        int factor = common / denominator;
        result.numerator = numerator * factor;
        result.denominator = common;
        return result;
    }

    public Fraction reduce() {
        /* Method: reduce
         * Purpose: Reduce the current fraction to its simplest form.
         * Returns:
         *   - A new Fraction object representing the reduced fraction. */

        Fraction result = new Fraction();
        int common;

        // Get absolute values for numerator and denominator
        int num = Math.abs(numerator);
        int den = Math.abs(denominator);

        // Figure out which is less, numerator or denominator
        if (num > den)
            common = gcd(num, den);
        else if (num < den)
            common = gcd(den, num);
        else  // If both are the same, no need to call gcd
            common = num;

        // Set result based on a common factor derived from gcd
        result.numerator = numerator / common;
        result.denominator = denominator / common;
        return result;
    }

} // End of Fraction Class
