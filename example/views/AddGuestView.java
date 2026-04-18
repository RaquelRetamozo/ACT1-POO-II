package views;

import controllers.AddGuestController;
import core.Model;
import core.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddGuestView extends JPanel implements View {
    //-----------------------------------------------------------------------
    //    Attributes
    //-----------------------------------------------------------------------
    private AddGuestController addGuestController;
    private JTextField tf_name;
    private JTextField tf_phone;
    private JTextField tf_address;
    private JRadioButton rbtn_male;
    private JRadioButton rbtn_female;
    private JComboBox<String> cmb_day;
    private JComboBox<String> cmb_month;
    private JComboBox<String> cmb_year;
    private JCheckBox cbx_terms;

    //-----------------------------------------------------------------------
    //    Constructor
    //-----------------------------------------------------------------------
    public AddGuestView(AddGuestController addGuestController) {
        this.addGuestController = addGuestController;
        make_frame();
        make_field_name();
        make_field_phone();
        make_field_gender();
        make_field_birthdate();
        make_field_address();
        make_field_terms();
        make_btn_save();
        make_btn_clean();
    }

    //-----------------------------------------------------------------------
    //    Methods
    //-----------------------------------------------------------------------
    @Override
    public void update(Model model, Object data) {
        if (data != null) {
            JOptionPane.showMessageDialog(this, (String) data);
        }
    }

    private void cleanFields() {
        tf_name.setText("");
        tf_phone.setText("");
        tf_address.setText("");
        rbtn_male.setSelected(true);
        cmb_day.setSelectedIndex(0);
        cmb_month.setSelectedIndex(0);
        cmb_year.setSelectedIndex(0);
        cbx_terms.setSelected(false);
    }

    private void make_frame() {
        setLayout(null);
    }

    private void make_field_name() {
        JLabel lbl_name = new JLabel("Ingrese Nombre:");
        lbl_name.setFont(new Font("Tahoma", Font.BOLD, 11));
        lbl_name.setBounds(29, 30, 130, 14);
        add(lbl_name);

        tf_name = new JTextField();
        tf_name.setBounds(169, 27, 196, 20);
        tf_name.setColumns(10);
        add(tf_name);
    }

    private void make_field_phone() {
        JLabel lbl_phone = new JLabel("Ingrese número celular:");
        lbl_phone.setFont(new Font("Tahoma", Font.BOLD, 11));
        lbl_phone.setBounds(29, 65, 150, 14);
        add(lbl_phone);

        tf_phone = new JTextField();
        tf_phone.setBounds(190, 62, 175, 20);
        tf_phone.setColumns(10);
        add(tf_phone);
    }

    private void make_field_gender() {
        JLabel lbl_gender = new JLabel("Género:");
        lbl_gender.setFont(new Font("Tahoma", Font.BOLD, 11));
        lbl_gender.setBounds(29, 100, 60, 14);
        add(lbl_gender);

        ButtonGroup btng_gender = new ButtonGroup();

        rbtn_male = new JRadioButton("Masculino");
        rbtn_male.setSelected(true);
        rbtn_male.setBounds(169, 96, 90, 23);
        btng_gender.add(rbtn_male);
        add(rbtn_male);

        rbtn_female = new JRadioButton("Femenino");
        rbtn_female.setBounds(265, 96, 90, 23);
        btng_gender.add(rbtn_female);
        add(rbtn_female);
    }

    private void make_field_birthdate() {
        JLabel lbl_birth = new JLabel("Fecha de Nacimiento:");
        lbl_birth.setFont(new Font("Tahoma", Font.BOLD, 11));
        lbl_birth.setBounds(29, 135, 145, 14);
        add(lbl_birth);

        // Dia
        String[] days = new String[31];
        for (int i = 0; i < 31; i++) days[i] = String.valueOf(i + 1);
        cmb_day = new JComboBox<>(days);
        cmb_day.setBounds(169, 132, 50, 20);
        add(cmb_day);

        // Mes
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
                "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        cmb_month = new JComboBox<>(months);
        cmb_month.setBounds(225, 132, 60, 20);
        add(cmb_month);

        // Año
        String[] years = new String[100];
        for (int i = 0; i < 100; i++) years[i] = String.valueOf(2024 - i);
        cmb_year = new JComboBox<>(years);
        cmb_year.setBounds(291, 132, 70, 20);
        add(cmb_year);
    }

    private void make_field_address() {
        JLabel lbl_address = new JLabel("Dirección:");
        lbl_address.setFont(new Font("Tahoma", Font.BOLD, 11));
        lbl_address.setBounds(29, 170, 80, 14);
        add(lbl_address);

        tf_address = new JTextField();
        tf_address.setBounds(169, 167, 196, 20);
        tf_address.setColumns(10);
        add(tf_address);
    }

    private void make_field_terms() {
        cbx_terms = new JCheckBox("Acepta Términos y Condiciones");
        cbx_terms.setBounds(29, 205, 220, 23);
        add(cbx_terms);
    }

    private void make_btn_save() {
        JButton btn_save = new JButton("Guardar");
        btn_save.setBounds(127, 240, 89, 23);
        add(btn_save);

        btn_save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!cbx_terms.isSelected()) {
                    JOptionPane.showMessageDialog(null,
                            "Debe aceptar los Términos y Condiciones.",
                            "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if (tf_name.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "El nombre no puede estar vacío.",
                            "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                JOptionPane.showMessageDialog(null,
                        "Invitado registrado exitosamente.",
                        "Éxito", JOptionPane.INFORMATION_MESSAGE);
                cleanFields();
            }
        });
    }

    private void make_btn_clean() {
        JButton btn_clean = new JButton("Limpiar");
        btn_clean.setBounds(253, 240, 89, 23);
        add(btn_clean);

        btn_clean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cleanFields();
            }
        });
    }
}
