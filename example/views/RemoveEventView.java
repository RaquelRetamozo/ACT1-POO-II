package views;

import controllers.RemoveEventController;
import core.Model;
import core.View;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        make_frame();
        make_label();
        make_table();
        make_btn_selectAll();
        make_btn_remove();
        make_btn_cancel();
    }
    //-----------------------------------------------------------------------
    //    Methods
    //-----------------------------------------------------------------------
    @Override
    public void update(Model model, Object data) {
        if (data != null) {
            String notice = (String) data;
            JOptionPane.showMessageDialog(this, notice);
        }
    }
    public void refreshTable(DefaultTableModel sourceModel) {
        tableModel.setRowCount(0);

        for (int i = 0; i < sourceModel.getRowCount(); i++) {
            Object[] row = new Object[sourceModel.getColumnCount() + 1];
            for (int j = 0; j < sourceModel.getColumnCount(); j++) {
                row[j] = sourceModel.getValueAt(i, j);
            }
            row[sourceModel.getColumnCount()] = false;
            tableModel.addRow(row);
        }
    }

    private void make_frame() {
        setLayout(null);
    }

    private void make_label() {
        JLabel lbl_title = new JLabel("Select events to remove:");
        lbl_title.setFont(new Font("Tahoma", Font.BOLD, 12));
        lbl_title.setBounds(20, 15, 250, 20);
        add(lbl_title);
    }

    private void make_table() {
        tableModel = new DefaultTableModel(
                new Object[]{"Date", "Description", "Frequency", "E-mail", "Alarm", "Boolean"}, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 5) return Boolean.class; // checkbox
                return String.class;
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 5;
            }
        };

        table = new JTable(tableModel);
        table.getColumnModel().getColumn(5).setMaxWidth(60);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 45, 440, 180);
        add(scrollPane);
    }

    private void make_btn_selectAll() {
        JButton btn_selectAll = new JButton("Seleccionar Todos");
        btn_selectAll.setBounds(320, 235, 140, 25);
        add(btn_selectAll);

        btn_selectAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    tableModel.setValueAt(true, i, 5);
                }
            }
        });
    }

    private void make_btn_remove() {
        JButton btn_remove = new JButton("Eliminar Evento");
        btn_remove.setBounds(240, 270, 140, 25);
        add(btn_remove);

        btn_remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(null,
                        "¿Está seguro que desea eliminar los eventos seleccionados?",
                        "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    // Elimina de abajo hacia arriba para no alterar los índices
                    for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
                        if ((Boolean) tableModel.getValueAt(i, 5)) {
                            removeEventController.removeEvent(i);
                            tableModel.removeRow(i);
                        }
                    }
                }
            }
        });
    }

    private void make_btn_cancel() {
        JButton btn_cancel = new JButton("Cancel");
        btn_cancel.setBounds(70, 270, 140, 25);
        add(btn_cancel);

        btn_cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    tableModel.setValueAt(false, i, 5);
                }
            }
        });
    }
}
