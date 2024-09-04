package nec.MathTranslator.Model;

import java.time.Instant;
import nec.MathTranslator.Components.MyComponent;

/*
** Not yet implemented
*/

public class MyPreviewModel implements MyModel {

    Object currentLine;
    
    public MyPreviewModel() {
        System.out.println(Instant.now() + ": MyInputTranslation Initialized");
    }
    
    protected void setUpBindings(MyComponent... t) {}
}
