package controllers;

import core.Controller;
import views.*;

/**
 * Main controller. It will be responsible for program's main screen behavior.
 */
public class HomeController extends Controller 
{
	//-----------------------------------------------------------------------
	//		Attributes
	//-----------------------------------------------------------------------
	private HomeView homeView;
	private EventListController eventListController = new EventListController();
	private NewEventController newEventController = new NewEventController(eventListController);
	private RemoveEventController removeEventController = new RemoveEventController(eventListController);
	private AddGuestController addGuestController = new AddGuestController();
	
	//-----------------------------------------------------------------------
	//		Methods
	//-----------------------------------------------------------------------
	@Override
	public void run()
	{
		// Initializes others controllers
		eventListController.run();
		newEventController.run();
		removeEventController.run();
		addGuestController.run();
		
		// Initializes HomeView
		homeView = new HomeView(this, mainFrame);
		addView("HomeView", homeView);
		loadView("HomeView");
		
		// Displays the program window
		mainFrame.setVisible(true);
	}
	
	
	//-----------------------------------------------------------------------
	//		Getters
	//-----------------------------------------------------------------------
	public EventListView getEventListView()
	{
		return eventListController.getView();
	}
	
	public NewEventView getNewEventView()
	{
		return newEventController.getView();
	}

	public RemoveEventView getRemoveEventView() {
		return removeEventController.getView();
	}

	public AddGuestView getAddGuestView() {
		return addGuestController.getView();
	}
}
