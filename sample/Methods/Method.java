package sample.Methods;

import javafx.scene.chart.XYChart;

/**
 * Interface for methods that use x0,y0,X and N to calculate some series.
 */
public interface Method {
    /**
     * Calculate points based on given parameters.
     * @param x0 left border for x axis
     * @param y0 for determining first point
     * @param X right border for x axis
     * @param N amount of steps
     * @return series that contain points of solution of differential equation
     * @throws Exception if series cannot be calculated
     */
    XYChart.Series getSeries(Number x0, Number y0, Number X, Number N) throws Exception;
}
