package base;

public class WeighedEdge implements Comparable<WeighedEdge> {
    public int source;
    public int destination;
    public int weight;

    public WeighedEdge(int source, int getDestination, int getWeight) {
        this.source = source;
        this.destination = getDestination;
        this.weight = getWeight;
    }

    @Override
    public int compareTo(WeighedEdge other) {
        return Integer.compare(this.weight, other.weight);
    }
}
