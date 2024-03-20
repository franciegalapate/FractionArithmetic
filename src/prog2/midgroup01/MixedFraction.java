package prog2.midgroup01;
import prog2.prelimgroup.Fraction;

public class MixedFraction extends Fraction {
    private int whole;

    public MixedFraction() {
        super(); // Call the default constructor of Fraction
        whole = 0;
    }

    public MixedFraction(int w, Fraction fraction) {
        super(whole * fraction.getDenominator() + fraction.getNumerator(), fraction.getDenominator());
        this.whole = w;
    }

    public MixedFraction(int w, int numerator, int denominator) {
        this.whole = w;
        /** HELP */
    }

    public MixedFraction(Fraction fraction) {
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
        /** HELP */

        return null;
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
        /** HELP */
        return other;
    }


    MixedFraction divide(MixedFraction other, prog2.prelimgroup.Fraction b) {
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
