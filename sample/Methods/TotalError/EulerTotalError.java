package sample.Methods.TotalError;

import sample.Methods.LocalError.EulerLocalError;
import sample.Methods.LocalError.LocalError;

public class EulerTotalError extends TotalError {
    /**
     * @see TotalError#getCorrespondingErrorMethod()
     */
    LocalError getCorrespondingErrorMethod() {
        return new EulerLocalError();
    }
    /**
     * @see TotalError#getNameOfSeries()
     */
    String getNameOfSeries() {
        return "Euler";
    }
}
