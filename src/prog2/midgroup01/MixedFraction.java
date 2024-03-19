package prog2.midgroup01;
import prog2.prelimgroup.Fraction;

public class MixedFraction extends Fraction {
    private int whole;

    public MixedFraction() {
        whole = 0;
    }

    public MixedFraction(int w, Fraction fraction) {
        this.whole = w;
        this.Fraction = fraction;
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
    }

    MixedFraction add(MixedFraction other) {
        /** HELP */
    }

    MixedFraction subtract(MixedFraction other) {
        /** HELP */
    }

    MixedFraction multiply(MixedFraction other) {
        /** HELP */
    }

    MixedFraction divide(MixedFraction other) {
        /** HELP */
    }

    MixedFraction reduce(MixedFraction other) {
        /** HELP */
    }
}
