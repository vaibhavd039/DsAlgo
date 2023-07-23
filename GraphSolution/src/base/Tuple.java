package base;

public class Tuple<T, U> implements Comparable<Tuple<T, U>> {
    public final T first;
    public final U second;

    public Tuple(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public int compareTo(Tuple<T, U> other) {
        if (this.first.equals(other.first)) {
            return this.second.toString().compareTo(
                    other.second.toString());
        } else {
            return this.first.toString().compareTo(
                    other.first.toString());
        }
    }

    public String toString() {
        return "(" + first.toString() + ", "
                + second.toString() + ")";
    }
}