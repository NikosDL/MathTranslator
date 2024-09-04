package nec.MathTranslator.Model;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Function: Get the user input, translate it into LaTeX and present it.
 * Components: 
 * 1. (Done) Binding with the input TextField 
 * - [31.08., 11:52] Revision: This is something needed by the interactor who 
 * will do the translation, not necessarily by the model.
 * - Currently achieved directly from the TextField via way of registry
 * - TBD: Make interface for bindable elements/models what include setUpBindings()?
 * 2. (Done) Access to the translationMap from the "database" (done - loadTranslationMap())
 * 3. (WIP) Ability to edit the translationMap 
 * - TODO: Add way to remove entries
 * - TODO: Make a different Model for that to obey separation of concerns a bit more strictly
 * 4. (Pending) Access to the Translation Interactor, send/receive 
 * 5. (Pending) Binding with the output TextField in order to show the translated String
 */
public class MyInputTranslationModel
        implements MyModel {

    private SimpleStringProperty currentInput;
    private Map<String, String> translationMap;

    public MyInputTranslationModel() {
        currentInput = new SimpleStringProperty();
        translationMap = new HashMap<>();

        System.out.println(Instant.now() + ": MyInputTranslationModel Initialized");
    }

    // [31.08., 12:05] Question: Needs encapsulation?
    public void setUpBindings(StringProperty input) {
        this.currentInput.bind(input);
    }

    protected Map<String, String> getTranslationMap() {
        return this.translationMap;
    }
    
    protected StringProperty getCurrentInput() {
        return this.currentInput;
    }
    
    protected void loadTranslationMap(Map<String, String> transMap) {
        this.translationMap = transMap;
    }
    
    // [31.08., 12:04] TODO: Turn this into protected/private and add bindings 
    // to the respective TextFields for that functionality
    // [31.08., 12:21] TODO: Add a checkpoint to assert that the translation is
    // a valid LaTeX command
    public final void addToTranslationMap(String key, String value) {
        this.translationMap.put(key, value);
    }
}
