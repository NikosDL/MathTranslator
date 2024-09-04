package nec.MathTranslator.Components;

import nec.MathTranslator.Controllers.MyController;
import nec.MathTranslator.Model.MyModel;

abstract public interface MyComponent {
    void setController(MyController control);
    void setModel(MyModel model);
    void setUpGUI();
    void setUpReactivity();
}
