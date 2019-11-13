package sample.Methods.LocalError;

import sample.Methods.NumericalMethod;
import sample.Methods.RungeKutta;

public class RungeKuttaLocalError extends LocalError{
    /**
     * @see LocalError#getCorrespondingMethod()
     */
    NumericalMethod getCorrespondingMethod() {
        return new RungeKutta();
    }
}
