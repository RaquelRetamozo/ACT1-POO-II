package views;

import controllers.RemoveEventController;
import core.Model;
import core.View;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class RemoveEventView extends JPanel implements View {
    //-----------------------------------------------------------------------
    //    Attributes
    //-----------------------------------------------------------------------
    private RemoveEventController removeEventController;
    private JTable table;
    private DefaultTableModel tableModel;
    //-----------------------------------------------------------------------
    //    Constructor
    //-----------------------------------------------------------------------
    public RemoveEventView(RemoveEventController removeEventController) {
        this.removeEventController = removeEventController;
    }
    @Override
    public void update(Model model, Object data) {

    }
}
