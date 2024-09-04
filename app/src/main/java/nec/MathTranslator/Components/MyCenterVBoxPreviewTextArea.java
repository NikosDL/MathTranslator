package nec.MathTranslator.Components;

import java.time.Instant;
import javafx.beans.property.StringProperty;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import nec.MathTranslator.Controllers.MyController;
import nec.MathTranslator.Model.MyModel;

public class MyCenterVBoxPreviewTextArea
        extends TextArea
        implements MyComponent {

    private MyController controller;
    private MyModel model;

    public MyCenterVBoxPreviewTextArea() {
        super();

        System.out.println(Instant.now() + ": MyCenterVBoxPreviewTextArea Initialized");

    }

    @Override
    public void setController(MyController control) {
        this.controller = control;
    }

    @Override
    public void setModel(MyModel model) {
        this.model = model;
    }

    @Override
    public void setUpGUI() {
        this.setBackground(Background.EMPTY);

        System.out.println(Instant.now() + ": MyCenterVBoxPreviewTextArea GUI Initialized");
    }
    
    public void bindContent(StringProperty transContent) {
        this.textProperty().bind(transContent);
    }

    @Override
    public void setUpReactivity() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
