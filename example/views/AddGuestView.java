package views;

import controllers.AddGuestController;
import core.Model;
import core.View;

import javax.swing.*;

public class AddGuestView extends JPanel implements View {
    //-----------------------------------------------------------------------
    //    Attributes
    //-----------------------------------------------------------------------
    private AddGuestController addGuestController;

    //-----------------------------------------------------------------------
    //    Constructor
    //-----------------------------------------------------------------------
    public AddGuestView(AddGuestController addGuestController) {
        this.addGuestController = addGuestController;
    }

    //-----------------------------------------------------------------------
    //    Methods
    //-----------------------------------------------------------------------
    @Override
    public void update(Model model, Object data) {
    }
}
