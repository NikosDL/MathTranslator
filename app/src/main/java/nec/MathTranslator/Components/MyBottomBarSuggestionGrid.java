package nec.MathTranslator.Components;

import java.time.Instant;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import nec.MathTranslator.Controllers.MyController;
import nec.MathTranslator.Model.MyModel;

public class MyBottomBarSuggestionGrid
        extends HBox
        implements MyComponent {

    private MyController controller;
    private MyModel model;

    public MyBottomBarSuggestionGrid() {
        super();

        System.out.println(Instant.now() + ": MyBottomBar Initialized");
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
        this.setBackground(Background.fill(Color.YELLOW));
        this.setStyle("-fx-border-color: black;"
                + "-fx-border-insets: 2.5");

        System.out.println(Instant.now() + ": MyBottomBar GUI Initialized");

    }

    @Override
    public void setUpReactivity() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
