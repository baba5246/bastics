package bastics;

/**
 * Compute basic statistics class
 */
public class StatisticsComputer {

    private Statistics statistics;
    private String delimiter;

    private int recordCount = 0;

    public StatisticsComputer(String delimiter) {
        this.statistics = new Statistics();
        this.delimiter = delimiter;
    }

    public Statistics getStatistics() {

        statistics.setRecordCount(recordCount);

        return statistics;
    }

    public void setLine(String line) {

        recordCount++;
    }



}
