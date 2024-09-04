package nec.MathTranslator.Components;

import java.time.Instant;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import nec.MathTranslator.Controllers.MyComponentRegistry.MyComponentEnum;
import nec.MathTranslator.Controllers.MyController;
import nec.MathTranslator.Controllers.MyMainController;
import nec.MathTranslator.Model.MyModel;

public class MyRightColumn
        extends VBox
        implements MyComponent {

    private MyMainController controller;
    private MyModel model;

    public MyRightColumn() {
        super();

        System.out.println(Instant.now() + ": MyRightColumn Initialized");

    }

    @Override
    public final void setController(MyController control) {
        this.controller = (MyMainController) control;
    }

    @Override
    public final void setModel(MyModel model) {
        this.model = model;
    }

    @Override
    public final void setUpGUI() {
        this.setBackground(Background.fill(Color.BLUE));
        this.setStyle("-fx-border-color: black; "
                + "-fx-border-insets: 2");

        MyRightColumnDocPreview docPreview
                = (MyRightColumnDocPreview) this.controller.
                        getNewComponent(MyComponentEnum.RIGHT_COLUMN_DOC_PREVIEW);
        this.getChildren().addAll(docPreview);

        System.out.println(Instant.now() + ": MyRightColumn GUI Initialized");

    }

    @Override
    public final void setUpReactivity() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
