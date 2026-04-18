package controllers;

import core.Controller;
import views.AddGuestView;

public class AddGuestController extends Controller {
    //-----------------------------------------------------------------------
    //    Attributes
    //-----------------------------------------------------------------------
    private AddGuestView addGuestView;

    //-----------------------------------------------------------------------
    //    Methods
    //-----------------------------------------------------------------------
    @Override
    public void run() {
        addGuestView = new AddGuestView(this);
    }

    //-----------------------------------------------------------------------
    //    Getters
    //-----------------------------------------------------------------------

    public AddGuestView getView() {
        return addGuestView;
    }
}
