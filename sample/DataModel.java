package sample;

import javafx.scene.chart.LineChart;
import javafx.scene.control.Label;
import sample.Methods.*;
import sample.Methods.LocalError.EulerLocalError;
import sample.Methods.LocalError.ImprovedEulerLocalError;
import sample.Methods.LocalError.LocalError;
import sample.Methods.LocalError.RungeKuttaLocalError;
import sample.Methods.TotalError.EulerTotalError;
import sample.Methods.TotalError.ImprovedEulerTotalError;
import sample.Methods.TotalError.RungeKuttaTotalError;
import sample.Methods.TotalError.TotalError;

import java.util.LinkedList;

class DataModel {

    private Number x0 = 1;
    private Number y0 = 2;
    private Number X = 6;
    private Number N = 10;
    private Number Nmax = 100;

    private boolean isAnalyticalMethodUsed = false;
    private boolean isEulerMethodUsed = false;
    private boolean isIEMethodUsed = false;
    private boolean isRKMethodUsed = false;

    private String mode = "Graph of solution";

    final private Analytical analytical = new Analytical();
    final private Euler euler = new Euler();
    final private ImprovedEuler improvedEuler = new ImprovedEuler();
    final private RungeKutta rungeKutta = new RungeKutta();

    final private EulerLocalError eulerLocalError = new EulerLocalError();
    final private ImprovedEulerLocalError improvedEulerLocalError = new ImprovedEulerLocalError();
    final private RungeKuttaLocalError rungeKuttaLocalError = new RungeKuttaLocalError();

    final private EulerTotalError eulerTotalError = new EulerTotalError();
    final private ImprovedEulerTotalError improvedEulerTotalError = new ImprovedEulerTotalError();
    final private RungeKuttaTotalError rungeKuttaTotalError = new RungeKuttaTotalError();

    void setX0(Number x0) {
        this.x0 = x0;
    }

    void setY0(Number y0) {
        this.y0 = y0;
    }

    void setX(Number x) {
        X = x;
    }

    void setN(Number n) {
        N = n;
    }

    public void setNmax(Number nmax) {
        Nmax = nmax;
    }

    void setAnalyticalMethodUsed(boolean analyticalMethodUsed) {
        isAnalyticalMethodUsed = analyticalMethodUsed;
    }

    void setEulerMethodUsed(boolean eulerMethodUsed) {
        isEulerMethodUsed = eulerMethodUsed;
    }

    void setIEMethodUsed(boolean IEMethodUsed) {
        isIEMethodUsed = IEMethodUsed;
    }

    void setRKMethodUsed(boolean RKMethodUsed) {
        isRKMethodUsed = RKMethodUsed;
    }

    void setMode(String mode) {
        this.mode = mode;
    }

    /**
     * Plot required graph based on set fields.
     * @param chart where graph would be plotted
     * @param errorLabel for display error message if occurs
     */
    void plotGraph(LineChart chart, Label errorLabel) {

        switch (mode) {
            case "Graph of solution":
                chart.getXAxis().setLabel("X");
                chart.getYAxis().setLabel("Y");
                LinkedList<Method> requiredMethods = new LinkedList<>();
                if (isAnalyticalMethodUsed) requiredMethods.add(analytical);
                if (isEulerMethodUsed) requiredMethods.add(euler);
                if (isIEMethodUsed) requiredMethods.add(improvedEuler);
                if (isRKMethodUsed) requiredMethods.add(rungeKutta);
                chart.getData().clear();
                for (Method method : requiredMethods) {
                    try {
                        chart.getData().add(method.getSeries(x0, y0, X, N));
                    } catch (Exception e) {
                        errorLabel.setText(e.toString());
                    }
                }
                break;
            case "Graph of local errors":
                chart.getXAxis().setLabel("X");
                chart.getYAxis().setLabel("Local error");
                LinkedList<LocalError> requiredLocalErrorMethods = new LinkedList<>();
                if (isEulerMethodUsed) requiredLocalErrorMethods.add(eulerLocalError);
                if (isIEMethodUsed) requiredLocalErrorMethods.add(improvedEulerLocalError);
                if (isRKMethodUsed) requiredLocalErrorMethods.add(rungeKuttaLocalError);
                chart.getData().clear();
                for (LocalError method : requiredLocalErrorMethods) {
                    try {
                        chart.getData().add(method.getSeries(x0, y0, X, N));
                    } catch (Exception e) {
                        errorLabel.setText(e.toString());
                    }
                }
                break;
            case "Graph of total errors":
                chart.getXAxis().setLabel("N");
                chart.getYAxis().setLabel("Total error");
                LinkedList<TotalError> requiredTotalErrorMethods = new LinkedList<>();
                if (isEulerMethodUsed) requiredTotalErrorMethods.add(eulerTotalError);
                if (isIEMethodUsed) requiredTotalErrorMethods.add(improvedEulerTotalError);
                if (isRKMethodUsed) requiredTotalErrorMethods.add(rungeKuttaTotalError);
                chart.getData().clear();
                for (TotalError method : requiredTotalErrorMethods) {
                    try {
                        chart.getData().add(method.getSeries(x0, y0, X, N, Nmax));
                    } catch (Exception e) {
                        errorLabel.setText(e.toString());
                    }
                }
                break;
        }

    }
}
