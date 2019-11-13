package sample.Methods.LocalError;

import javafx.scene.chart.XYChart;
import sample.Methods.Analytical;
import sample.Methods.Method;
import sample.Methods.NumericalMethod;

/**
 * Represent method to find local error between exact values and calculated using corresponding numerical method.
 */
public abstract class LocalError implements Method {
    //For obtaining exact solution
    private Analytical analytical = new Analytical();
    //For obtaining corresponding numerical solution
    private NumericalMethod correspondingMethod = getCorrespondingMethod();

    /**
     * @return corresponding numerical method
     */
    abstract NumericalMethod getCorrespondingMethod();

    /**
     * @see Method#getSeries(Number, Number, Number, Number)
     * Represents points of graph with local errors.
     */
    public XYChart.Series getSeries(Number x0, Number y0, Number X, Number N) throws Exception {
        double h = (X.doubleValue() - x0.doubleValue()) / N.longValue();
        double currentX = x0.doubleValue();
        double currentYexact;
        double currentYnumerical = y0.doubleValue();
        double deltaY = 0;
        double exactEquationConstant = analytical.getEquationConstant(x0, y0).doubleValue();

        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName(correspondingMethod.getNameOfSeries());

        for (long i = 0; i <= N.longValue(); i++) {
            series.getData().add(new XYChart.Data<>(currentX, deltaY));

            currentYnumerical = correspondingMethod.getNextVerticalValue(currentX, currentYnumerical, h).doubleValue();
            currentX += h;
            currentYexact = analytical.exactSolution(currentX, exactEquationConstant).doubleValue();

            deltaY = Math.abs(currentYexact-currentYnumerical);
        }
        return series;
    }
}
