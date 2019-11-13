package sample.Methods.TotalError;

import sample.Methods.LocalError.ImprovedEulerLocalError;
import sample.Methods.LocalError.LocalError;

public class ImprovedEulerTotalError extends TotalError {
    /**
     * @see TotalError#getCorrespondingErrorMethod()
     */
    LocalError getCorrespondingErrorMethod() {
        return new ImprovedEulerLocalError();
    }
    /**
     * @see TotalError#getNameOfSeries()
     */
    String getNameOfSeries() {
        return "Improved Euler";
    }
}
