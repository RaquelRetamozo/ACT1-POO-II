package controllers;

import core.Controller;
import views.AddGuestView;

import javax.swing.*;

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
    public void addGuest(String name, String phone, String address,
                         String gender, String birthdate, boolean terms) {
        if (!terms) {
            JOptionPane.showMessageDialog(null,
                    "Debe aceptar los Términos y Condiciones.",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "El nombre no puede estar vacío.",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(null,
                "Invitado registrado exitosamente.",
                "Éxito", JOptionPane.INFORMATION_MESSAGE);
        addGuestView.cleanFields();
    }

    //-----------------------------------------------------------------------
    //    Getters
    //-----------------------------------------------------------------------

    public AddGuestView getView() {
        return addGuestView;
    }
}
