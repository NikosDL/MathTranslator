package nec.MathTranslator.Controllers;

import java.time.Instant;
import nec.MathTranslator.Components.*;

public final class MyComponentFactory
        implements MyController {

    private MyMainController mainController;

    public MyComponentFactory(MyMainController mainController) {
        this.mainController = mainController;

        System.out.println(Instant.now() + ": MyComponentFactory Initialized");
    }

    protected MyComponent getNewRoot() {
        var root = new MyBorderPane();

        return root;
    }

    protected MyComponent getNewMenuBar() {
        var menuBar = new MyMenuBar();

        return menuBar;
    }

    protected MyComponent getNewRightColumn() {
        var rightColumn = new MyRightColumn();

        return rightColumn;
    }

    protected MyComponent getNewRightColumnDocPreview() {
        var docPreview = new MyRightColumnDocPreview();

        return docPreview;
    }

    protected MyComponent getNewBottomBarSuggestionGrid() {
        var bottomBar = new MyBottomBarSuggestionGrid();

        return bottomBar;
    }

    protected MyComponent getNewLeftColumn() {
        var leftColumn = new MyLeftColumn();

        return leftColumn;
    }

    protected MyComponent getNewLeftColumnExportButtonsContainer() {
        var exportButtonsContainer = new MyLeftColumnExportButtonsContainer();

        return exportButtonsContainer;
    }

    protected MyComponent getNewCenterVBox() {
        var centerBox = new MyCenterVBox();

        return centerBox;
    }

    protected MyComponent getNewCenterVBoxPreviewTextArea() {
        var linePreview = new MyCenterVBoxPreviewTextArea();

        return linePreview;
    }

    protected MyComponent getNewCenterVBoxInputTextArea() {
        var input = new MyCenterVBoxInputTextArea();

        return input;
    }

    protected MyComponent getNewLeftColumnEnterTranslationHBox() {
        var customTransBox = new MyLeftColumnEnterTranslationHBox();

        return customTransBox;
    }

    // this.mainController.registerSubController(this);
}
