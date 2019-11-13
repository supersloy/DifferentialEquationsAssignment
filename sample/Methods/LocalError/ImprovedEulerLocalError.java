package sample.Methods.LocalError;

import sample.Methods.ImprovedEuler;
import sample.Methods.NumericalMethod;

public class ImprovedEulerLocalError extends LocalError{
    /**
     * @see LocalError#getCorrespondingMethod()
     */
    NumericalMethod getCorrespondingMethod() {
        return new ImprovedEuler();
    }
}
