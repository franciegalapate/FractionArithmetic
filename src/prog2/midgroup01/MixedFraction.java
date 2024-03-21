package prog2.midgroup01;

import prelimgroup.Fraction;

public class MixedFraction extends Fraction {
    private int whole;

    public MixedFraction() {
        super();
        this.whole = 0;
    }

    public MixedFraction(int w, Fraction f) {
        super(f.getNumerator(), f.getDenominator());
        this.whole = w;
    }

    public MixedFraction(int w, int num, int den) {
        this.whole = w;
        this.setNumerator(num);
        this.setDenominator(den);
    }

    public MixedFraction(Fraction f) {
        super(f.getNumerator(), f.getDenominator());
    }

    public void setWholePart(int w) {
        this.whole = w;
    }

    public void setFractionPart(Fraction f) {
        super.setNumerator(f.getNumerator());
        super.setDenominator(f.getDenominator());
    }

    public int getWhole() {
        return whole;
    }

    public Fraction getFractionPart() {
        int num = super.getNumerator();
        int den = super.getDenominator();
        return new Fraction(num, den);
    }

    public Fraction toFraction(Fraction f) {
        // Convert the mixed fraction to an improper fraction
        int improperNum = whole * getDenominator() + getNumerator();

        return new Fraction(improperNum, getDenominator());
    }

    @Override
    public Fraction add(Fraction b) {
        Fraction thisFraction = toFraction(this);
        return thisFraction.add(b);
    }

    @Override
    public Fraction subtract(prelimgroup.Fraction b) {
        Fraction thisFraction = toFraction(this);
        return thisFraction.subtract(b);
    }

    @Override
    public Fraction multiply(Fraction b) {
        Fraction thisFraction = toFraction(this);
        return thisFraction.multiply(b);
    }

    @Override
    public Fraction divide(Fraction b) {
        Fraction thisFraction = toFraction(this);
        return thisFraction.divide(b);
    }

    @Override
    public String toString() {
        // Get the string representation of the fraction part
        String fractionString = super.toString();

        // If the whole part is zero, just return the fraction part
        if (whole == 0) {
            return fractionString;
        }

        // If the numerator of the fraction part is zero, return only the whole part
        if (super.getNumerator() == 0) {
            return String.valueOf(whole);
        }

        // Combine the whole part, fraction part, and decimal representation
        return String.format("%d %s (%.2f)", whole, fractionString, toDouble());
    }

    @Override
    public void computeGCD(int num, int den) {
        super.computeGCD(num, den);
    }
}
