package nec.MathTranslator.Components;

import java.time.Instant;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import nec.MathTranslator.Controllers.MyController;
import nec.MathTranslator.Controllers.MyMainController;
import nec.MathTranslator.Model.MyMainModel;
import nec.MathTranslator.Model.MyModel;

public class MyLeftColumnExportButtonsContainer
        extends VBox
        implements MyComponent {

    private MyMainController controller;
    private MyMainModel model;

    public MyLeftColumnExportButtonsContainer() {
        super();

        System.out.println(Instant.now() + ": MyLeftColumnExportButtonsContainer Initialized");

    }

    @Override
    public void setController(MyController control) {
        this.controller = (MyMainController) control;
    }

    @Override
    public void setModel(MyModel model) {
        this.model = (MyMainModel) model;
    }

    @Override
    public void setUpGUI() {
        this.setBackground(Background.EMPTY);
        this.setStyle("-fx-border-color: black;"
                + "-fx-border-insets: 2");
        this.setPadding(new Insets(5));
        this.setSpacing(5);

        Button exportToLatex = new Button("Export to Latex");
        exportToLatex.setPrefWidth(Double.MAX_VALUE);
        exportToLatex.setOnAction(e -> {
        });

        Button exportToPdf = new Button("Export to PDF");
        exportToPdf.setPrefWidth(Double.MAX_VALUE);
        exportToPdf.setOnAction(e -> {
        });

        this.getChildren().addAll(exportToLatex, exportToPdf);

        System.out.println(Instant.now() + ": MyLeftColumnExportButtonsContainer GUI Initialized");
    }

    @Override
    public void setUpReactivity() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
