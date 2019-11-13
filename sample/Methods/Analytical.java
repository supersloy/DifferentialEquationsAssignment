package sample.Methods;

import javafx.scene.chart.XYChart;

public class Analytical implements Method {

    /**
     * Return y(x) using already calculated equation constant
     * @param x value of x axis of point
     * @param equationConstant calculated equation constant
     * @return y(x) for given constant
     */
    public Number exactSolution(Number x, Number equationConstant) {
        return x.doubleValue() * (Math.pow(Math.exp(equationConstant.doubleValue()), x.doubleValue()) - 1);
    }

    /**
     * Calculate exact equation constant by using initial values.
     * @param x0 initial value of x
     * @param y0 initial value of y
     * @return equation constant
     */
    public Number getEquationConstant(Number x0, Number y0) {
        return Math.log(y0.doubleValue() / x0.doubleValue() + 1) / x0.doubleValue();
    }

    /**
     * @see Method#getSeries(Number, Number, Number, Number)
     * Represent points of analytical solution
     */
    public XYChart.Series getSeries(Number x0, Number y0, Number X, Number N) throws Exception {
        double h = (X.doubleValue() - x0.doubleValue()) / N.longValue();
        double currentX = x0.doubleValue();
        double exactEquationConstant = getEquationConstant(x0, y0).doubleValue();
        XYChart.Series<Number, Number> analyticalSeries = new XYChart.Series<>();
        analyticalSeries.setName("Analytical");
        for (long i = 0; i <= N.longValue(); i++) {
            if (currentX != 0)
                analyticalSeries.getData().add(new XYChart.Data<>(currentX, exactSolution(currentX,exactEquationConstant)));
            currentX += h;
        }
        return analyticalSeries;
    }
}

