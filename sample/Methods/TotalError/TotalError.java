package sample.Methods.TotalError;

import javafx.scene.chart.XYChart;
import sample.Methods.LocalError.LocalError;

import java.util.Comparator;
import java.util.List;

/**
 * Represent method to find total approximation errors.
 */
public abstract class TotalError {
    //Corresponding local error method.
    private LocalError correspondingErrorMethod = getCorrespondingErrorMethod();

    /**
     * @return corresponding local error method
     */
    abstract LocalError getCorrespondingErrorMethod();

    /**
     * Represent name of series
     * @return name of series
     */
    abstract String getNameOfSeries();

    /**
     * Calculate points of total approximation errors.
     * @param x0 left bound of x value for numerical and exact method
     * @param y0 initial y value
     * @param X right bound of x value for numerical and exact method
     * @param N starting amount of steps
     * @param Nmax final amount of steps
     * @return series containing points of total approximation errors
     * @throws Exception if series cannot be calculated
     */
    public XYChart.Series getSeries(Number x0, Number y0, Number X, Number N, Number Nmax) throws Exception {
        List<XYChart.Data<Number, Number>> dataAboutLocalErrors;
        List<Number> localErrors;

        double maxError = 0;

        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName(getNameOfSeries());

        for (long i = N.longValue(); i <= Nmax.longValue(); i++) {

            dataAboutLocalErrors = correspondingErrorMethod.getSeries(x0, y0, X, i).getData();
            maxError = dataAboutLocalErrors
                    .stream()
                    .map(XYChart.Data::getYValue)
                    .max(Comparator.comparingDouble(Number::doubleValue))
                    .orElse(-1)
                    .doubleValue();
            series.getData().add(new XYChart.Data<>(i, maxError));
        }
        return series;
    }

}
