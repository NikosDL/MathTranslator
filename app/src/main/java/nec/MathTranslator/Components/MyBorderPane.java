package nec.MathTranslator.Components;

import java.time.Instant;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import nec.MathTranslator.Controllers.MyComponentRegistry.MyComponentEnum;
import nec.MathTranslator.Controllers.MyController;
import nec.MathTranslator.Controllers.MyMainController;
import nec.MathTranslator.Model.MyMainModel;
import nec.MathTranslator.Model.MyModel;

public final class MyBorderPane
        extends BorderPane
        implements MyComponent {

    private MyMainController controller;
    private MyMainModel model;

    public MyBorderPane() {
        super();

        System.out.println(Instant.now() + ": MyBorderPane Initialized");
    }

    @Override
    public void setUpGUI() {
        this.setBackground(Background.fill(Color.WHEAT));
        this.setStyle("-fx-border-color: black;"
                + "-fx-border-insets: 2");

        MenuBar myMenuBar = (MenuBar) this.controller
                .getNewComponent(MyComponentEnum.MENU_BAR);
        myMenuBar.setPrefWidth(Double.MAX_VALUE);
        myMenuBar.setPrefHeight(25);
        myMenuBar.setMinHeight(USE_PREF_SIZE);
        myMenuBar.setMaxHeight(USE_PREF_SIZE);
        this.setTop(myMenuBar);

        VBox myRightColumn = (VBox) this.controller
                .getNewComponent(MyComponentEnum.RIGHT_COLUMN);
        myRightColumn.prefWidthProperty().bind(this.widthProperty().divide(3));
        myRightColumn.prefHeightProperty().bind(this.heightProperty().subtract(50));
        myRightColumn.setMinSize(USE_PREF_SIZE, USE_PREF_SIZE);
        myRightColumn.setMaxSize(USE_PREF_SIZE, USE_PREF_SIZE);
        this.setRight(myRightColumn);

        HBox myBottomBar = (HBox) this.controller
                .getNewComponent(MyComponentEnum.BOTTOM_BAR_SUGGESTION_GRID);
        myBottomBar.setPrefHeight(20);
        myBottomBar.setMinHeight(USE_PREF_SIZE);
        myBottomBar.setMaxHeight(USE_PREF_SIZE);
        this.setBottom(myBottomBar);

        VBox myLeftColumn = (VBox) this.controller
                .getNewComponent(MyComponentEnum.LEFT_COLUMN);
        myLeftColumn.prefWidthProperty().bind(this.widthProperty().divide(5));
        myLeftColumn.prefHeightProperty().bind(this.heightProperty().subtract(50));
        myLeftColumn.setMinSize(USE_PREF_SIZE, USE_PREF_SIZE);
        myLeftColumn.setMaxSize(USE_PREF_SIZE, USE_PREF_SIZE);
        this.setLeft(myLeftColumn);

        VBox myCenter = (VBox) this.controller
                .getNewComponent(MyComponentEnum.CENTER_VBOX);
        myCenter.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.setCenter(myCenter);

        System.out.println(Instant.now() + ": MyBorderPane GUI Initialzed");
    }

    @Override
    public void setUpReactivity() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Setters
    @Override
    public void setController(MyController mainController) {
        this.controller = (MyMainController) mainController;
    }

    @Override
    public void setModel(MyModel mainModel) {
        this.model = (MyMainModel) mainModel;
    }

}
