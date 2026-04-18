package controllers;

import core.Controller;
import models.SchedulerIO;
import views.RemoveEventView;

import javax.swing.*;

public class RemoveEventController extends Controller {
    //-----------------------------------------------------------------------
    //		Attributes
    //-----------------------------------------------------------------------
    private RemoveEventView removeEventView;
    private EventListController eventListController;

    //-----------------------------------------------------------------------
    //    Constructor
    //-----------------------------------------------------------------------
    public RemoveEventController (EventListController eventListController) {
        this.eventListController = eventListController;
    }

    //-----------------------------------------------------------------------
    //    Methods
    //-----------------------------------------------------------------------
    @Override
    public void run() { removeEventView = new RemoveEventView (this );
    }
    public void removeEvent(int rowIndex) {
        try {
            SchedulerIO schedulerIO = new SchedulerIO();
            schedulerIO.attach(removeEventView);
            schedulerIO.deleteEvent(rowIndex);
            eventListController.removeRowFromTable(rowIndex);
            JOptionPane.showMessageDialog(null, "Event removed successfully.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error removing event: " + e.getMessage(),
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    //-----------------------------------------------------------------------
    //    Getters
    //-----------------------------------------------------------------------
    public RemoveEventView getView() {
        return removeEventView;
    }
}
