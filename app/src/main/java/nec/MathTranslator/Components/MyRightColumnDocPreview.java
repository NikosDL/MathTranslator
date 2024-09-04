package nec.MathTranslator.Components;

import java.time.Instant;
import javafx.scene.image.ImageView;
import nec.MathTranslator.Controllers.MyController;
import nec.MathTranslator.Controllers.MyMainController;
import nec.MathTranslator.Model.MyMainModel;
import nec.MathTranslator.Model.MyModel;

public class MyRightColumnDocPreview
        extends ImageView
        implements MyComponent {

    private MyMainController controller;
    private MyMainModel model;

    public MyRightColumnDocPreview() {
        super();

        System.out.println(Instant.now() + ": MyRightColumnDocPreview Initialized");

    }

    @Override
    public final void setController(MyController control) {
        this.controller = (MyMainController) control;
    }

    @Override
    public final void setModel(MyModel model) {
        this.model = (MyMainModel) model;
    }

    @Override
    public final void setUpGUI() {
        System.out.println("Nope.");
        
        System.out.println(Instant.now() + ": MyRightColumnDocPreview GUI Initialized");
    }

    @Override
    public final void setUpReactivity() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
