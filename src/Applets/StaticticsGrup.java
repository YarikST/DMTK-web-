package Applets;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.awt.*;

/**
 Являє статистику однієї групи.
 */
public class StaticticsGrup extends JApplet {
    protected JPanel panelTitle;
    protected JPanel panelTabel;
    protected TableModel tableModel = new MyModel();

    protected String grup;

    public StaticticsGrup(String grup) throws HeadlessException {
        this.grup = grup;

    }

    protected void panelTitle() {

    }

    protected void panelTable() {

    }

    public JPanel getPanelTabel() {
        return panelTabel;
    }

    class MyModel implements TableModel{
        @Override
        public int getRowCount() {
            return 0;
        }

        @Override
        public int getColumnCount() {
            return 0;
        }

        @Override
        public String getColumnName(int columnIndex) {
            return null;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return null;
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return null;
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

        }

        @Override
        public void addTableModelListener(TableModelListener l) {

        }

        @Override
        public void removeTableModelListener(TableModelListener l) {

        }
    }
}
