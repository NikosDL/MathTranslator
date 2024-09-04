package nec.MathTranslator.Controllers;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import nec.MathTranslator.Components.MyComponent;
import nec.MathTranslator.Model.MyMainModel;
import nec.MathTranslator.Model.MyModel;

/**
 * TODO: Test how modular this design is by making a user control component
 * that would add/remove GUI Components. If it's easy to "automate", it'd be
 * satisfactory for me. If it's too complicated, maybe it's time to rethink
 * the whole interaction design.
 */

public final class MyComponentRegistry
        implements MyController {

    public static enum MyComponentEnum {
        MENU_BAR,
        RIGHT_COLUMN,
        RIGHT_COLUMN_DOC_PREVIEW,
        BOTTOM_BAR_SUGGESTION_GRID,
        LEFT_COLUMN,
        LEFT_COLUMN_EXPORT_BUTTONS_CONTAINER,
        LEFT_COLUMN_ENTER_TRANSLATION_HBOX,
        CENTER_VBOX,
        CENTER_VBOX_LINE_PREVIEW_TEXT_AREA,
        CENTER_VBOX_INPUT_TEXT_FIELD
    }

    private final MyMainController mainController;
    private final MyMainModel mainModel;

    private final Map<MyComponentEnum, MyComponent> componentMap;
    private final List<MyController> subcontrollers;
    private final Map<MyComponentEnum, MyController> componentToControllerMap;
    private final List<MyModel> submodels;
    private final Map<MyComponentEnum, MyModel> componentToModelMap;

    protected MyComponentRegistry(MyController mainController, MyModel mainModel) {

        this.mainController = (MyMainController) mainController;
        this.mainModel = (MyMainModel) mainModel;

        this.componentMap = new HashMap<>();
        this.subcontrollers = new ArrayList<>();
        this.submodels = new ArrayList<>();

        this.componentToControllerMap = new HashMap<>();
        this.componentToModelMap = new HashMap<>();

        for (MyComponentEnum comp : MyComponentEnum.values()) {
            this.mapComponentToController(comp);
            this.mapComponentToModel(comp);
        }

        System.out.println(Instant.now() + ": MyComponentRegistry Initialized");
    }

    // TODO: Subscribe/Bind changes to component enum, find a way to be able to add 
    // new components to Enum without having to rewrite everything
    // Maybe make enum category based, depending on which controller is 
    // responsible
    private final void mapComponentToController(MyComponentEnum comp) {
        switch (comp) {
            case MENU_BAR, RIGHT_COLUMN, BOTTOM_BAR_SUGGESTION_GRID, LEFT_COLUMN, CENTER_VBOX ->
                this.componentToControllerMap.put(comp, this.mainController);
            case RIGHT_COLUMN_DOC_PREVIEW ->
                this.componentToControllerMap.put(comp, this.mainController);
            case LEFT_COLUMN_EXPORT_BUTTONS_CONTAINER ->
                this.componentToControllerMap.put(comp, this.mainController);
            case LEFT_COLUMN_ENTER_TRANSLATION_HBOX ->
                this.componentToControllerMap.put(comp, this.mainController);
            case CENTER_VBOX_LINE_PREVIEW_TEXT_AREA, CENTER_VBOX_INPUT_TEXT_FIELD ->
                this.componentToControllerMap.put(comp, this.mainController);
            default ->
                System.out.println("Component " + comp.toString() + " does not "
                        + "need a controller.");
        }
    }

    private final void mapComponentToModel(MyComponentEnum comp) {
        switch (comp) {
            case MENU_BAR, RIGHT_COLUMN, BOTTOM_BAR_SUGGESTION_GRID, LEFT_COLUMN, CENTER_VBOX ->
                this.componentToModelMap.put(comp, this.mainModel);
            case RIGHT_COLUMN_DOC_PREVIEW ->
                this.componentToModelMap.put(comp, this.mainModel);
            case LEFT_COLUMN_EXPORT_BUTTONS_CONTAINER ->
                this.componentToModelMap.put(comp, this.mainModel);
            case CENTER_VBOX_LINE_PREVIEW_TEXT_AREA ->
                this.componentToModelMap
                        .put(comp, this.mainModel.getPreviewModel());
            case CENTER_VBOX_INPUT_TEXT_FIELD, LEFT_COLUMN_ENTER_TRANSLATION_HBOX ->
                this.componentToModelMap
                        .put(comp, this.mainModel.getInputTranslationModel());
            default ->
                System.out.println("Component " + comp.toString() + " does not "
                        + "need a model");
        }
    }

    // Setters
    protected void registerComponent(MyComponentEnum name, MyComponent ref) {
        this.componentMap.put(name, ref);
    }

    // Getters
    protected MyComponent getComponentRef(MyComponentEnum name) {
        return this.componentMap.get(name);
    }

    protected List<MyComponent> getComponentRefByModel(MyModel model) {
        List<MyComponent> toRet = new ArrayList<>();
        for (MyComponentEnum key : this.componentToModelMap.keySet()) {
            if (this.componentToModelMap.get(key).equals(model)) {
                toRet.add(this.componentMap.get(key));
            }
        }

        return toRet;
    }

    protected List<MyComponent> getComponentRefByController(MyController controller) {
        List<MyComponent> toRet = new ArrayList<>();
        for (MyComponentEnum key : this.componentToControllerMap.keySet()) {
            if (this.componentToControllerMap.get(key).equals(controller)) {
                toRet.add(this.componentMap.get(key));
            }
        }

        return toRet;
    }

    protected MyController getComponentControllerByEnum(MyComponentEnum name) {
        return this.componentToControllerMap.get(name);
    }

    protected MyModel getComponentModelByEnum(MyComponentEnum name) {
        return this.componentToModelMap.get(name);
    }

    /**
     * Not needed as of now. Would only be relevant if the top-level layout is
     * editable by user
     */
//    protected void unregisterComponent(MyComponentEnum name) {
//        this.componentMap.remove(name);
//    }
    
    /**
     * We don't need to add extra references. We already have refs to the main
     * controller/model and can get the refs from there. Maybe there is an
     * argument for encapsulation, but right now the registry is supposed to 
     * be designed as an intercom, with all different app parts having access
     * to it.
     */
//    protected void registerSubcontroller(MyController subcontroller) {
//        this.subcontrollers.add(subcontroller);
//    }
//    protected void registerSubmodel(MyModel submodel) {
//        this.submodels.add(submodel);
//    }
}
