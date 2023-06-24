import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/**
 * PythagoreanTriplet
 */
public class PythagoreanTriplet {
    private final int a, b, c;
    PythagoreanTriplet(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }
    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() == obj.getClass())
            return this.hashCode() == obj.hashCode();
        return false;
    }
    public static BuildTriplets makeTripletsList() {
        return new BuildTriplets();
    }
}
class BuildTriplets {
    private final List<PythagoreanTriplet> triplets = new ArrayList<>();
    private int total;
    private int maxFactor = Integer.MAX_VALUE;
    public BuildTriplets thatSumTo(int total) {
        this.total = total;
        if (maxFactor == Integer.MAX_VALUE) this.maxFactor = total;
        return this;
    }
    public BuildTriplets withFactorsLessThanOrEqualTo(int maxFactor) {
        this.maxFactor = maxFactor;
        return this;
    }
    public List<PythagoreanTriplet> build() {
        for (int a = 1; a <= maxFactor; a++) {
            for (int b = a; b <= maxFactor; b++) {
                int c = total - a - b;
                if (c > maxFactor) continue;
                if (isTriplet(a, b, c)) {
                    triplets.add(new PythagoreanTriplet(a, b, c));
                }
            }
        }
        return triplets;
    }
    private boolean isTriplet(int a, int b, int c) {
        return a * a + b * b == c * c;
    }
}
