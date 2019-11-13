package sample.Methods;

public class RungeKutta extends NumericalMethod {

    /**
     * @see NumericalMethod#getNextVerticalValue(double, double, double)
     */
    public Number getNextVerticalValue(double currentX, double currentY, double h) throws Exception {
        double[] k = new double[4];
        k[0] = h * getDerivative(currentX, currentY).doubleValue();
        k[1] = h * getDerivative(currentX + h / 2, currentY + k[0] / 2).doubleValue();
        k[2] = h * getDerivative(currentX + h / 2, currentY + k[1] / 2).doubleValue();
        k[3] = h * getDerivative(currentX + h, currentY + k[2]).doubleValue();
        return currentY + 1.0 / 6 * (k[0] + 2 * k[1] + 2 * k[2] + k[3]);
    }

    /**
     * @see NumericalMethod#getNameOfSeries()
     */
    public String getNameOfSeries() {
        return "Runge-Kutta";
    }
}
