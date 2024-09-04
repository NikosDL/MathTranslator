package nec.MathTranslator.Components;

import java.time.Instant;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import nec.MathTranslator.Controllers.MyComponentRegistry.MyComponentEnum;
import nec.MathTranslator.Controllers.MyController;
import nec.MathTranslator.Controllers.MyMainController;
import nec.MathTranslator.Model.MyModel;

public class MyCenterVBox
        extends VBox
        implements MyComponent {

    private MyMainController controller;
    private MyModel model;

    public MyCenterVBox() {
        super();

        System.out.println(Instant.now() + ": MyCenterVBox Initialized");

    }

    @Override
    public void setController(MyController control) {
        this.controller = (MyMainController) control;
    }

    @Override
    public void setModel(MyModel model) {
        this.model = model;
    }

    @Override
    public void setUpGUI() {
        this.setBackground(Background.fill(Color.PURPLE));
        this.setStyle("-fx-border-color: black;"
                + "-fx-border-insets: 2");
        this.setPadding(new Insets(5));
        this.setSpacing(15);

        MyCenterVBoxPreviewTextArea previewArea
                = (MyCenterVBoxPreviewTextArea) this.controller.getNewComponent(
                        MyComponentEnum.CENTER_VBOX_LINE_PREVIEW_TEXT_AREA);
        previewArea.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);

        MyCenterVBoxInputTextArea inputArea
                = (MyCenterVBoxInputTextArea) this.controller.getNewComponent(
                        MyComponentEnum.CENTER_VBOX_INPUT_TEXT_FIELD);
        inputArea.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);

        this.getChildren().addAll(previewArea, inputArea);

        System.out.println(Instant.now() + ": MyCenterVBox GUI Initialized");

    }

    @Override
    public void setUpReactivity() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
