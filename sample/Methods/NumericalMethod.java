package sample.Methods;

import javafx.scene.chart.XYChart;

/**
 * Represent numerical method.
 */
abstract public class NumericalMethod implements Method {

    /**
     * Calculate derivative at some point.
     *
     * @param x horizontal value of point
     * @param y vertical value of point
     * @return derivative of equation at given point
     * @throws Exception if derivative cannot be calculated
     */
    Number getDerivative(Number x, Number y) throws Exception {
        double xDouble = x.doubleValue();
        double yDouble = y.doubleValue();
        if (xDouble == 0 || yDouble / xDouble < -1)
            throw new Exception(getNameOfSeries() + " method cannot calculate value of derivative at " + xDouble);
        return (1 + yDouble / xDouble) * Math.log((xDouble + yDouble) / xDouble) + yDouble / xDouble;
    }

    /**
     * Represent name of series
     *
     * @return name of series
     */
    abstract public String getNameOfSeries();

    /**
     * Calculate y_i+1 based on previous point and step.
     *
     * @param currentX value of x at previous step
     * @param currentY value of y at previous step
     * @param h        distance(range) of step
     * @return y_i+1
     * @throws Exception if returning value cannot be calculated
     */
    abstract public Number getNextVerticalValue(double currentX, double currentY, double h) throws Exception;

    /**
     * @see Method#getSeries(Number, Number, Number, Number)
     * Represent points of numerical solution
     */
    public XYChart.Series getSeries(Number x0, Number y0, Number X, Number N) throws Exception {
        double h = (X.doubleValue() - x0.doubleValue()) / N.longValue();
        double currentX = x0.doubleValue();
        double currentY = y0.doubleValue();

        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName(getNameOfSeries());

        for (long i = 0; i <= N.longValue(); i++) {
            series.getData().add(new XYChart.Data<>(currentX, currentY));
            currentY = getNextVerticalValue(currentX, currentY, h).doubleValue();
            currentX += h;
        }

        return series;
    }
}
