package nec.MathTranslator.Components;

import java.time.Instant;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Background;
import nec.MathTranslator.Controllers.MyController;
import nec.MathTranslator.Model.MyModel;

public class MyMenuBar
        extends MenuBar
        implements MyComponent {

    private MyController controller;
    private MyModel model;

    public MyMenuBar() {
        super();

        System.out.println(Instant.now() + ": MyMenuBar Initialized");

    }

    @Override
    public final void setUpGUI() {

        // File Menu
        Menu fileMenu = new Menu("File");

        MenuItem newFileItem = new MenuItem("New");
        newFileItem.setOnAction(e -> {
        });
        MenuItem saveItem = new MenuItem("Save");
        saveItem.setOnAction(e -> {
        });
        MenuItem loadItem = new MenuItem("Load");
        loadItem.setOnAction(e -> {
        });
        MenuItem exitItem = new MenuItem("Exit");
        exitItem.setOnAction(e -> {
        });

        fileMenu.getItems().addAll(newFileItem, saveItem, loadItem, exitItem);

        // Edit Menu
        Menu editMenu = new Menu("Edit");

        MenuItem undoItem = new MenuItem("Undo");
        undoItem.setOnAction(e -> {
        });
        MenuItem redoItem = new MenuItem("Redo");
        redoItem.setOnAction(e -> {
        });

        editMenu.getItems().addAll(undoItem, redoItem);

        // Customization Menu
        Menu customizationMenu = new Menu("Customize");

        MenuItem settingsItem = new MenuItem("Settings");
        settingsItem.setOnAction(e -> {
        });

        customizationMenu.getItems().addAll(settingsItem);

        this.getMenus().addAll(fileMenu, editMenu, customizationMenu);

        System.out.println(Instant.now() + ": MyMenuBar GUI Initialized");
    }

    @Override
    public final void setUpReactivity() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public final void setController(MyController control) {
        this.controller = control;
    }

    @Override
    public final void setModel(MyModel model) {
        this.model = model;
    }

}
