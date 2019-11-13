package sample.Methods;

public class ImprovedEuler extends NumericalMethod {

    /**
     * @see NumericalMethod#getNextVerticalValue(double, double, double)
     */
    public Number getNextVerticalValue(double currentX, double currentY, double h) throws Exception {
        double intermediateY = currentY + h * getDerivative(currentX, currentY).doubleValue();
        return currentY + h / 2 * (getDerivative(currentX, currentY).doubleValue() + getDerivative(currentX + h, intermediateY).doubleValue());
    }

    /**
     * @see NumericalMethod#getNameOfSeries()
     */
    public String getNameOfSeries() {
        return "Improved Euler";
    }
}
