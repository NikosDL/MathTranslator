package nec.MathTranslator.Components;

import java.time.Instant;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import nec.MathTranslator.Controllers.MyComponentRegistry;
import nec.MathTranslator.Controllers.MyController;
import nec.MathTranslator.Controllers.MyMainController;
import nec.MathTranslator.Model.MyMainModel;
import nec.MathTranslator.Model.MyModel;

public class MyLeftColumn
        extends VBox
        implements MyComponent {

    private MyMainController controller;
    private MyMainModel model;

    public MyLeftColumn() {
        super();

        System.out.println(Instant.now() + ": MyLeftColumn Initialized");

    }

    @Override
    public final void setController(MyController control) {
        this.controller = (MyMainController) control;
    }

    @Override
    public final void setModel(MyModel model) {
        this.model = (MyMainModel) model;
    }

    @Override
    public final void setUpGUI() {
        this.setBackground(Background.fill(Color.GREEN));
        this.setPadding(new Insets(10));
        this.setSpacing(50);
        this.setStyle("-fx-border-color: black;"
                + "-fx-border-insets: 2");

        MyLeftColumnExportButtonsContainer buttonContainer
                = (MyLeftColumnExportButtonsContainer) this.controller
                        .getNewComponent(MyComponentRegistry.MyComponentEnum
                                .LEFT_COLUMN_EXPORT_BUTTONS_CONTAINER);
        MyLeftColumnEnterTranslationHBox customTransBox 
                = (MyLeftColumnEnterTranslationHBox) this.controller
                        .getNewComponent(MyComponentRegistry.MyComponentEnum
                                .LEFT_COLUMN_ENTER_TRANSLATION_HBOX);

        this.getChildren().addAll(buttonContainer, customTransBox);

        System.out.println(Instant.now() + ": MyLeftColumn GUI Initialized");

    }

    @Override
    public final void setUpReactivity() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
