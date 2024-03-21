package prog2.midgroup01;
import prog2.prelimgroup.Fraction;

public class MixedFraction extends Fraction {
    private int whole;

    public MixedFraction() {
        super(); // Call the default constructor of Fraction
        whole = 0;
    }

    public MixedFraction(int w, Fraction fraction) {
        /* Constructor: MixedFraction
         * Purpose: Construct a MixedFraction object with a provided whole number and Fraction part.
         * Parameters:
         *   - w: The whole number part of the mixed fraction.
         *   - fraction: The Fraction part of the mixed fraction.
         * Preconditions: None
         * Post-conditions: A MixedFraction object is constructed with the provided whole number and Fraction part. */
        super(w * fraction.getDenominator() + fraction.getNumerator(), fraction.getDenominator());
        this.whole = w;
    }

    public MixedFraction(int w, int numerator, int denominator) {
        /* Constructor: MixedFraction
         * Purpose: Construct a MixedFraction object with provided whole number, numerator, and denominator.
         * Parameters:
         *   - w: The whole number part of the mixed fraction.
         *   - numerator: The numerator part of the fraction.
         *   - denominator: The denominator part of the fraction.
         * Preconditions: None
         * Post-conditions: A MixedFraction object is constructed with the provided whole number, numerator, and denominator. */
        this.whole = w;
        this.Fraction = new Fraction(numerator, denominator); // Constructing the Fraction part
    }

    public MixedFraction(Fraction fraction) {
        /* Constructor: MixedFraction
         * Purpose: Construct a MixedFraction object with a provided Fraction part.
         * Parameters:
         *   - fraction: The Fraction part of the mixed fraction.
         * Preconditions: None
         * Post-conditions: A MixedFraction object is constructed with the provided Fraction part. */
        this.Fraction = fraction;
    }

    public void setWholePart(int w) {
        this.whole = w;
    }

    public void setFractionPart(Fraction f) {
        this.Fraction = f;
    }

    int getWhole() {
        return whole;
    }

    Fraction getFractionPart() {
        return Fraction;
    }

    Fraction toFraction() {
        /* Method: toFraction
         * Purpose: Convert the MixedFraction object to an equivalent Fraction object.
         *          The mixed fraction is converted to an improper fraction.
         * Parameters: None
         * Preconditions: None
         * Post-conditions: An equivalent Fraction object representing the improper fraction is returned. */

        // Convert the mixed fraction to an improper fraction
        int improperNum = whole * Fraction.getDenominator() + Fraction.getNumerator();
        // Create a new Fraction object representing the improper fraction
        return new Fraction(improperNum, Fraction.getDenominator());
    }

    public String toString() {
        /* Method: toString
         * Purpose: Generate a string representation of the MixedFraction object, including
         * the fraction in the form of whole numerator/denominator and its equivalent decimal representation.
         * Parameters: None
         * Preconditions: None
         * Post-conditions: A formatted string containing the mixed fraction and its decimal representation is returned. */

        // Convert the mixed fraction to an improper fraction
        int improperNum = whole * denominator + Fraction.getNumerator();

        // Check if the improper fraction represents a whole number (no fractional part)
        if (improperNum % denominator == 0) {
            return String.format("| Result is: %d |", improperNum / denominator);
        }

        // Check if the result has a denominator of 1 (no fractional part)
        if (denominator == 1) {
            return String.format("| Result is: %d |", improperNum);
        }

        // Otherwise, format the mixed fraction as "whole numerator/denominator"
        return String.format("| Result is: %d %d/%d |", whole, Fraction.getNumerator(), denominator);
    }

    public double toDouble() {
        /* Method: toDouble
         * Purpose: Calculate and return the decimal representation of the MixedFraction object.
         * Parameters: None
         * Preconditions: None
         * Post-conditions: The decimal representation of the mixed fraction is returned, or NaN if the denominator is 0. */

        // Convert the mixed fraction to an improper fraction
        int improperNum = whole * denominator + Fraction.getNumerator();

        return (denominator == 0) ? Double.NaN : (double) improperNum / denominator;
    }

    MixedFraction add(MixedFraction other) {
        /** HELP */

        return other;
    }

    MixedFraction subtract(MixedFraction other) {
        /** HELP */
        return other;
    }

    MixedFraction multiply(MixedFraction other) {
        /**
         * Method: multiply
         * Purpose: Multiply the current MixedFraction object by another MixedFraction object.
         *          The multiplication is performed by converting both mixed fractions to improper fractions,
         *          then multiplying their numerators and denominators separately.
         * Parameters:
         *   - other: The MixedFraction object to multiply the current MixedFraction by.
         * Preconditions: None
         * Post-conditions: A new MixedFraction object representing the product of the multiplication is returned.
         */

        // Multiply the whole parts
        int newWhole = this.whole * other.whole;

        // Convert both mixed fractions to improper fractions
        int thisImproperNum = this.whole * this.getDenominator() + this.getNumerator();
        int otherImproperNum = other.whole * other.getDenominator() + other.getNumerator();

        // Multiply the numerators and denominators separately
        int newNumerator = thisImproperNum * otherImproperNum;
        int newDenominator = this.getDenominator() * other.getDenominator();

        // Create a new Fraction object representing the result
        Fraction resultFraction = new Fraction(newNumerator, newDenominator);

        // Convert the result back to a mixed fraction
        return new MixedFraction(newWhole, resultFraction);
    }


    MixedFraction divide(MixedFraction other, prog2.prelimgroup.Fraction b) {
        /* Method: divide
         * Purpose: Divide the current MixedFraction object by another MixedFraction object and a Fraction object.
         *          The division is performed by converting both mixed fractions to improper fractions.
         * Parameters:
         *   - other: The MixedFraction object to divide the current MixedFraction by.
         *   - b: The Fraction object to divide the current MixedFraction by.
         * Preconditions: None
         * Post-conditions: A new MixedFraction object representing the quotient of the division is returned. */

        // Convert the current mixed fraction to an improper fraction
        int improperNum1 = whole * getDenominator() + getNumerator();

        // Calculate the numerator and denominator of the resulting fraction
        int resultNumerator = improperNum1 * b.getDenominator();
        int resultDenominator = getDenominator() * b.getNumerator();

        // Create a new Fraction object representing the result
        Fraction result = new Fraction(resultNumerator, resultDenominator);

        // Reduce the resulting fraction
        result = result.reduce();
        return (MixedFraction) result;
    }

    MixedFraction reduce(MixedFraction other) {
        /** HELP */
        return other;
    }
}
