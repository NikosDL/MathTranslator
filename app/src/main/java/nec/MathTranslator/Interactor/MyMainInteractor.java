package nec.MathTranslator.Interactor;

import java.util.Map;
import javafx.beans.property.StringProperty;
import nec.MathTranslator.Controllers.MyMainController;
import nec.MathTranslator.Model.MyMainModel;

/**
 * MainInteractor file for high-level decision-making and coordination
 * 
 * Needs access to models and also to the controller, especially to request
 * multithreading. 
 */

public final class MyMainInteractor
        implements MyInteractor {

    private final MyInputTranslationInteractor translationInteractor;
    private final MyPreviewBuilderInteractor previewInteractor;
    private final MyIOInteractor ioInteractor;

    private final MyMainController mainController;
    private final MyMainModel mainModel;

    public MyMainInteractor(MyMainController mainControl, MyMainModel mainModel) {
        this.mainController = mainControl;
        this.mainModel = mainModel;

        /**
         * Subinteractor initialization
         */
        this.translationInteractor = new MyInputTranslationInteractor(this);
        this.previewInteractor = new MyPreviewBuilderInteractor(this);
        this.ioInteractor = new MyIOInteractor(this);
    }

    /**
     * Saving/Loading of the translation Map. 
     * 
     * Saving on exit route:
     * App.onExit: -> MyMainController.saveTranslationMapOnExit() -> 
     * MyMainInteractor.saveTranslationMap() -> 
     * MyIOInteractor.saveTranslationMapToFile(MyMainModel.getTranslationMapToSave())
     * The model is accessed by the Interactor.
     * 
     * Loading on start route:
     * MyMainController::init -> MyMainModel.loadTranslationMap(MyMainInteractor
     * .loadTranslationMap()) -> MyIOInteractor.loadTranslationMapFromFile()
     * The model accesses the Interactor
     * 
     * TBD: Should the controller be the liaison between interactor/model?
     * 
     * TODO: Move the call to load the Map from the MainController constructor
     * into the Model file. Will need to be called after the GUI/Interactors 
     * have been set up, since the Model is initialized from the App itself.
     * 
     * [31.08., 11:44] Comment: Maybe it's not necessary to move the call to the
     * model. It's part of the initial initialization and it should probably
     * happen via the controller.
     * 
     */
    public void saveTranslationMap() {
        this.ioInteractor.saveTranslationMapToFile(mainModel.getTranslationMapToSave());
    }
    
    public Map<String, String> loadTranslationMap() {
        return this.ioInteractor.loadTranslationMapFromFile();
    }
    
    protected StringProperty getInputProperty() {
        return this.mainModel.getCurrentInput();
    }

}
