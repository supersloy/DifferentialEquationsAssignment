package sample.Methods.LocalError;

import sample.Methods.Euler;
import sample.Methods.NumericalMethod;

public class EulerLocalError extends LocalError {
    /**
     * @see LocalError#getCorrespondingMethod()
     */
    NumericalMethod getCorrespondingMethod() {
        return new Euler();
    }
}
