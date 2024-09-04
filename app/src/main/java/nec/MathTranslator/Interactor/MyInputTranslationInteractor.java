package nec.MathTranslator.Interactor;

/**
 * The interactor responsible for translating the input in real time. It needs:
 * 1. Binding to the input 
 * 2. Access to the translation map
 * 3. Methods to pass the translation to the output Model for it to be presented
 * 
 * [31.08., 11:46] Initial remarks: The input will probably have to be tokenized
 * in some way. Otherwise, as long as data volumes stay low and efficiency 
 * is not a priority/high-yield strategy, the interactor could check the 
 * TranslationMap for translations after every single input letter 
 * and present them as options. Typos will not be considered at the first 
 * iteration of the app.
 * 
 * [31.08., 11:56] Question: There is the idea for specific parametrized inputs 
 * to show a small popup as a quick input method for arguments. Would that be 
 * this interactor's responsibility? 
 * Remark: The fire conditions for the popup will depend on the output of the 
 * translation process.
 */

import java.util.HashMap;
import java.util.Map;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;

public class MyInputTranslationInteractor 
        implements MyInteractor {
    
    private MyMainInteractor mainInteractor;
    
    private StringProperty input;
    private StringProperty inputLeftToEvaluate;
    private String inputString;
    private Map<String, String> translationMap;
    private String output;
    
    private IntegerProperty inputCursor = new SimpleIntegerProperty();
    private int lastTranslatedCursor = 0;
    
    public MyInputTranslationInteractor(MyMainInteractor mainInteractor) {
        this.mainInteractor = mainInteractor;
        
        this.input = this.mainInteractor.getInputProperty();
        /**
         * [31.08., 12:12] Remark: The translator needs to be able to dif-
         * ferentiate between already translated parts of the input and those
         * that are not. Either use pointers or create a new string/property
         * out of the whole input everytime the latter changes. Is there a more
         * elegant way?
         */
        this.inputLeftToEvaluate = this.input;
        this.input.subscribe(e -> this.checkForValidTranslations());
        this.inputCursor.bind(this.input.length());
        this.inputString = this.input.get();
        this.translationMap = new HashMap<>();
        this.output = "";
    }
    
    private void checkForValidTranslations() {
    
        // if popup, then show popup
    }
    
//    private void populateTranslationMap() {}
}
