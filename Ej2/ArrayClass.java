package Ej2;

public class ArrayClass {
    private int[] series;

    /**
     * initiate the series field to an empty array with size 5.
     */
    public ArrayClass() {
        series = new int[5];
    }

    public ArrayClass(int[] series) {
        this.series = series;
    }

    public int[] getSeries() {
        return this.series;
    }

    public void setSeries(int[] series) {
        this.series = series;
    }

    public int getIndexFromSeries(int n) throws IndexOutOfBoundsException {
        return this.series[n];
    }

    public int getLength() {
        return this.series.length;
    }

}
