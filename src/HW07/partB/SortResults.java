package HW07.partB;

public class SortResults {
    private final String algorithm;
    private final long microseconds;
    private final boolean sorted;
    private final int swaps;
    private final long comparisons;

    public SortResults(String algorithm, boolean sorted, long microseconds, int swaps, long comparisons) {
        this.algorithm = algorithm;
        this.microseconds = microseconds;
        this.sorted = sorted;
        this.comparisons = comparisons;
        this.swaps = swaps;
    }

    public String toString() {
        return String.format("%-20s %8b %14d %12d %12d", algorithm, sorted, microseconds, swaps, comparisons);
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public long getMicroseconds() {
        return microseconds;
    }

    public boolean isSorted() {
        return sorted;
    }

    public long getComparisons() {
        return comparisons;
    }

    public int getSwaps() {
        return swaps;
    }
}
