package prelimgroup;

public class Fraction {
    protected Fraction Fraction;
    private int numerator, denominator;
    public Fraction() {
        numerator = 0;
        denominator = 0;
    }

    public Fraction(int num, int den) {
        numerator = num;
        denominator = den;
    }

    public void setNumerator(int num) {
        numerator = num;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setDenominator(int den) {
        denominator = den;
    }

    public int getDenominator() {
        return denominator;
    }

    public String toString() {
        double decimalResult = toDouble();
        return String.format("| Result is:  %d/%d or %.2f |", numerator, denominator, decimalResult);
    }

    public double toDouble() {
        return (denominator == 0) ? Double.NaN : (double) numerator / denominator;
    }

    protected void computeGCD(int x, int y) {
        int gcd = 1;
        for (int i = 1; i <= x && i <= y; i++) {
            if (x % i == 0 && y % i == 0) {
                gcd = i;
            }
            System.out.println("GCD of " + x + " and " + y + " is: " + gcd);
        }
    }

    public Fraction add(Fraction b) {
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
        int factor = d1;
        while ((d1 % d2) != 0)
            d1 += factor;
        return d1;
    }
    private int gcd(int d1, int d2) {
        int factor;
        while (d2 != 0) {
            factor = d2;
            d2 = d1 % d2;
            d1 = factor;
        }
        return d1;
    }
    protected Fraction convert(int common) {
        Fraction result = new Fraction();
        int factor = common / denominator;
        result.numerator = numerator * factor;
        result.denominator = common;
        return result;
    }

    protected Fraction reduce() {
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

} // End of prelimgroup.Fraction Class
