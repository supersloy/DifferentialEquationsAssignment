package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;

public class Controller {

    @FXML
    private LineChart<Double, Double> chart;

    @FXML
    private TextField textFieldx0;
    @FXML
    private TextField textFieldy0;
    @FXML
    private TextField textFieldX;
    @FXML
    private TextField textFieldN;
    @FXML
    private TextField textFieldNmax;

    @FXML
    private CheckBox checkBoxAnalytical;
    @FXML
    private CheckBox checkBoxEuler;
    @FXML
    private CheckBox checkBoxIE;
    @FXML
    private CheckBox checkBoxRK;

    @FXML
    private ComboBox<String> comboBoxMode;

    @FXML
    private Button buttonPlotGraph;

    @FXML
    private Label errorMessage;

    final private DataModel dataModel = new DataModel();

    @FXML
    void EulerCheckBoxPressed(ActionEvent event) {
        dataModel.setEulerMethodUsed(checkBoxEuler.isSelected());
    }

    @FXML
    void IECheckBoxPressed(ActionEvent event) {
        dataModel.setIEMethodUsed(checkBoxIE.isSelected());
    }

    @FXML
    void RKCheckBoxPressed(ActionEvent event) {
        dataModel.setRKMethodUsed(checkBoxRK.isSelected());
    }

    @FXML
    void analyticalCheckBoxPressed(ActionEvent event) {
        dataModel.setAnalyticalMethodUsed(checkBoxAnalytical.isSelected());
    }

    @FXML
    void modeChanged(ActionEvent event) {
        dataModel.setMode(comboBoxMode.getValue());

        //Disabling unnecessary fields.
        if (comboBoxMode.getValue().equals("Graph of total errors"))
            textFieldNmax.setDisable(false);
        else
            textFieldNmax.setDisable(true);

        if (!comboBoxMode.getValue().equals("Graph of solution")) {
            if (checkBoxAnalytical.isSelected()) {
                checkBoxAnalytical.setSelected(false);
                analyticalCheckBoxPressed(new ActionEvent());
            }
            checkBoxAnalytical.setDisable(true);
        } else {
            checkBoxAnalytical.setDisable(false);
        }
    }

    @FXML
    void plotGraphButtonPressed(ActionEvent event) {
        dataModel.plotGraph(chart, errorMessage);
    }

    @FXML
    void textFieldX0Changed(KeyEvent event) {
        //Parsing x0 value if possible
        try {
            dataModel.setX0(Double.parseDouble(textFieldx0.getText()));
            errorMessage.setText("");
        } catch (NumberFormatException e) {
            errorMessage.setText("Field x0 cannot be '" + textFieldx0.getText() + "'.Previous value will be used instead.");
        }
    }

    @FXML
    void textFieldY0Changed(KeyEvent event) {
        //Parsing y0 value if possible
        try {
            dataModel.setY0(Double.parseDouble(textFieldy0.getText()));
            errorMessage.setText("");
        } catch (NumberFormatException e) {
            errorMessage.setText("Field y0 cannot be '" + textFieldy0.getText() + "'.Previous value will be used instead.");
        }
    }

    @FXML
    void textFieldXChanged(KeyEvent event) {
        //Parsing X value if possible
        try {
            dataModel.setX(Double.parseDouble(textFieldX.getText()));
            errorMessage.setText("");
        } catch (NumberFormatException e) {
            errorMessage.setText("Field X cannot be '" + textFieldX.getText() + "'.Previous value will be used instead.");
        }

    }

    @FXML
    void textFieldNChanged(KeyEvent event) {
        //Parsing N value if possible
        try {
            dataModel.setN(Integer.parseInt(textFieldN.getText()));
            errorMessage.setText("");
        } catch (NumberFormatException e) {
            errorMessage.setText("Field N cannot be '" + textFieldN.getText() + "'.Previous value will be used instead.");
        }
    }

    @FXML
    void textFieldNmaxChanged(KeyEvent event) {
        //Parsing Nmax value if possible
        try {
            dataModel.setNmax(Integer.parseInt(textFieldNmax.getText()));
            errorMessage.setText("");
        } catch (NumberFormatException e) {
            errorMessage.setText("Field Nmax cannot be '" + textFieldNmax.getText() + "'.Previous value will be used instead.");
        }
    }

    @FXML
    public void initialize() {
        //Fill combobox with needed values
        comboBoxMode.getItems().addAll("Graph of solution", "Graph of local errors", "Graph of total errors");
        //Setup initial mod to make graph of solution
        comboBoxMode.setValue("Graph of solution");
    }
}
