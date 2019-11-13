package sample.Methods;

public class Euler extends NumericalMethod {

    /**
     * @see NumericalMethod#getNextVerticalValue(double, double, double)
     */
    public Number getNextVerticalValue(double currentX, double currentY, double h) throws Exception {
        return currentY + h * getDerivative(currentX, currentY).doubleValue();
    }

    /**
     * @see NumericalMethod#getNameOfSeries()
     */
    public String getNameOfSeries() {
        return "Euler";
    }
}
