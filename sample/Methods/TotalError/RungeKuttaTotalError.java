package sample.Methods.TotalError;

import sample.Methods.LocalError.LocalError;
import sample.Methods.LocalError.RungeKuttaLocalError;

public class RungeKuttaTotalError extends TotalError {
    /**
     * @see TotalError#getCorrespondingErrorMethod()
     */
    LocalError getCorrespondingErrorMethod() {
        return new RungeKuttaLocalError();
    }
    /**
     * @see TotalError#getNameOfSeries()
     */
    String getNameOfSeries() {
        return "Runge-Kutta";
    }
}
