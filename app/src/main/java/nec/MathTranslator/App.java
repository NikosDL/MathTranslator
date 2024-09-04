package nec.MathTranslator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import nec.MathTranslator.Controllers.MyMainController;
import nec.MathTranslator.Interactor.MyMainInteractor;
import nec.MathTranslator.Model.MyMainModel;

public class App extends Application {
    MyMainModel model;
    MyMainController controller;
    MyMainInteractor interactor;
    
    @Override
    public void start(Stage stage) {
        model = new MyMainModel();
        controller = new MyMainController(model);
        
        Scene mainScene = new Scene(controller.getRoot(), 1600, 900);
        
        stage.setScene(mainScene);
        stage.setOnCloseRequest(e -> controller.saveTranslationMapOnExit());
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}

// Subcontrollers, submodels, subinteractors for each "module"
// Component factory that creates components
// Each component object already contains styling
// Sizing/layout is taken care of the components parent