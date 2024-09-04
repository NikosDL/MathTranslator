package nec.MathTranslator.Model;

import java.time.Instant;
import java.util.Map;
import javafx.beans.property.StringProperty;

/**
 * MainModel for high-level communication/decision making/organization
 * 
 * TBD: Does it need to know about the controller? Current answer: no
 */

public final class MyMainModel
        implements MyModel {

//    private List<MyModel> submodels;
    private MyInputTranslationModel transModel;
    private MyPreviewModel previewModel;

    public MyMainModel() {
        // Submodels Initialization
        this.transModel = new MyInputTranslationModel();
        this.previewModel = new MyPreviewModel();

        System.out.println(Instant.now() + ": MyMainModel Initialized");
    }

    /**
     * Submodel getters
     */
    public MyInputTranslationModel getInputTranslationModel() {
        return this.transModel;
    }
    
    public StringProperty getCurrentInput() {
        return this.transModel.getCurrentInput();
    }

    public MyPreviewModel getPreviewModel() {
        return this.previewModel;
    }

    /**
     * TranslationMap save/load methods for coordination with the Interactor
     * side. The Model doesn't know about the Interactor, but the Interactor 
     * has access to these methods.
     */
    public Map<String, String> getTranslationMapToSave() {
        return this.transModel.getTranslationMap();
    }

    public void loadTranslationMap(Map<String, String> transMap) {
        this.transModel.loadTranslationMap(transMap);
    }
}
