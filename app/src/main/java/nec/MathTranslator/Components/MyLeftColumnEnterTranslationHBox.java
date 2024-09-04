package nec.MathTranslator.Components;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import nec.MathTranslator.Controllers.MyController;
import nec.MathTranslator.Controllers.MyMainController;
import nec.MathTranslator.Model.MyInputTranslationModel;
import nec.MathTranslator.Model.MyModel;

public class MyLeftColumnEnterTranslationHBox 
        extends VBox 
        implements MyComponent {

    private MyMainController controller;
    private MyInputTranslationModel model;
    
    public MyLeftColumnEnterTranslationHBox() {
        super();
    }
    
    @Override
    public void setController(MyController control) {
        this.controller = (MyMainController) control;
    }

    @Override
    public void setModel(MyModel model) {
        this.model = (MyInputTranslationModel) model;
    }

    @Override
    public void setUpGUI() {
        VBox inputBox = new VBox(5);
        Label inputLabel = new Label("Input");
        TextField inputField = new TextField();
        
        inputBox.getChildren().addAll(inputLabel, inputField);
        
        VBox translationBox = new VBox(5);
        Label translationLabel = new Label("Translation");
        TextField translationField = new TextField();
        
        translationBox.getChildren().addAll(translationLabel, translationField);
        
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> {
            this.model.addToTranslationMap(inputField.getText(), translationField.getText());
            inputField.clear();
            translationField.clear();
        });
        
        this.setSpacing(10);
        this.getChildren().addAll(inputBox, translationBox, submitButton);
    }

    @Override
    public void setUpReactivity() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
