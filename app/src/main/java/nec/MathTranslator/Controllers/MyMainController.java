package nec.MathTranslator.Controllers;

import java.time.Instant;
import javafx.scene.Parent;
import nec.MathTranslator.Components.MyBorderPane;
import nec.MathTranslator.Components.MyComponent;
import nec.MathTranslator.Interactor.MyMainInteractor;
import nec.MathTranslator.Model.MyMainModel;

public final class MyMainController
        implements MyController {

    // Model Declaration
    private final MyMainModel mainModel;

    // Interactor Declaration
    private final MyMainInteractor mainInteractor;

    // Subcontroller Declaration
    private final MyComponentFactory factory;
    private final MyComponentRegistry registry;
    private final MyThreadController scheduler;

    // Root Declaration
    private MyComponent root;

    public MyMainController(MyMainModel model) {

        // Main App Initialization
        this.mainModel = model;
        this.mainInteractor = new MyMainInteractor(this, this.mainModel);
        this.mainModel.loadTranslationMap(this.mainInteractor.loadTranslationMap());

        // SubController Initialization
        this.registry = new MyComponentRegistry(this, this.mainModel);
        this.factory = new MyComponentFactory(this);
        this.scheduler = new MyThreadController(this);

        // Root Initialization
        this.root = (MyBorderPane) this.factory.getNewRoot();
        this.root.setController(this);
        this.root.setModel(this.mainModel);
        this.root.setUpGUI();

        System.out.println(Instant.now() + ": MyMainController Initialized");
    }

    public final void submitToThreadPool(Runnable r) {
        this.scheduler.passTaskToThreadPool(r);
    }

    public final MyComponent getNewComponent(MyComponentRegistry.MyComponentEnum comp) {
        MyComponent toRet;

        switch (comp) {
            case MENU_BAR ->
                toRet = factory.getNewMenuBar();
            case RIGHT_COLUMN ->
                toRet = factory.getNewRightColumn();
            case RIGHT_COLUMN_DOC_PREVIEW ->
                toRet = factory.getNewRightColumnDocPreview();
            case BOTTOM_BAR_SUGGESTION_GRID ->
                toRet = factory.getNewBottomBarSuggestionGrid();
            case LEFT_COLUMN ->
                toRet = factory.getNewLeftColumn();
            case LEFT_COLUMN_EXPORT_BUTTONS_CONTAINER ->
                toRet = factory.getNewLeftColumnExportButtonsContainer();
            case LEFT_COLUMN_ENTER_TRANSLATION_HBOX ->
                toRet = factory.getNewLeftColumnEnterTranslationHBox();
            case CENTER_VBOX ->
                toRet = factory.getNewCenterVBox();
            case CENTER_VBOX_LINE_PREVIEW_TEXT_AREA ->
                toRet = factory.getNewCenterVBoxPreviewTextArea();
            case CENTER_VBOX_INPUT_TEXT_FIELD ->
                toRet = factory.getNewCenterVBoxInputTextArea();
            default -> {
                toRet = factory.getNewRoot();
                System.out.println("You're crazy. Don't use that.");
            }
        }

        this.registry.registerComponent(comp, toRet);
        toRet.setController(this.registry.getComponentControllerByEnum(comp));
        toRet.setModel(this.registry.getComponentModelByEnum(comp));
        toRet.setUpGUI();
//        toRet.setUpReactivity();

        return toRet;
    }

    // Getters
    protected final MyMainModel getMainModel() {
        return this.mainModel;
    }

    public final Parent getRoot() {
        return (Parent) this.root;
    }

    public final void saveTranslationMapOnExit() {
        this.mainInteractor.saveTranslationMap();
    }

    /**
     * See note in MyComponentRegistry's respective method for explanation as to
     * why this is commented out right now.
     */
    //    protected final void registerSubController(MyController subcontroller) {
//        this.registry.registerSubcontroller(subcontroller);
//    }
    // Only the MainController can communicate with other packages
    // and with the registry, which is why the model registration 
    // happens through it.
    // 29/08: This has kinda changed. Components can communicate with their
    // respective models/controllers. I think this is redundant.
    // TODO: Check if this can be removed.
//    public final void registerSubmodel(MyModel submodel) {
//        this.registry.registerSubmodel(submodel);
//    }
}
