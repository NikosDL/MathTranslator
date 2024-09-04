package nec.MathTranslator.Components;

import java.time.Instant;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import nec.MathTranslator.Controllers.MyController;
import nec.MathTranslator.Model.MyInputTranslationModel;
import nec.MathTranslator.Model.MyModel;

public class MyCenterVBoxInputTextArea
        extends TextArea
        implements MyComponent {

    private MyController controller;
    private MyInputTranslationModel model;

    public MyCenterVBoxInputTextArea() {
        super();

        System.out.println(Instant.now() + ": MyCenterVBoxInputTextArea Initialized");

    }

    @Override
    public void setController(MyController control) {
        this.controller = control;
    }

    @Override
    public void setModel(MyModel model) {
        this.model = (MyInputTranslationModel) model;
        this.model.setUpBindings(this.textProperty());
    }

    @Override
    public void setUpGUI() {
        this.setBackground(Background.EMPTY);

        System.out.println(Instant.now() + ": MyCenterVBoxInputTextArea GUI Initialized");

    }

    @Override
    public void setUpReactivity() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
