package ied.view;

import java.awt.Component;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class UiListener implements ActionListener, ListSelectionListener {
	UserInterface welcome; 
	
	public UiListener(UserInterface w) {
		this.welcome = w;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// execute
		if (e.getSource() == welcome.getjButton1())
		{
			String[] o = new String[]{"Column1", "Column2","Column1", "Column2","Column1", "Column2","Column1"}; 
			insertRow(welcome.getjTable1(),o);
		}
		//change event request 
		else if (e.getSource() == welcome.getJComboBox1())
		{
			if(welcome.getJComboBox1().getSelectedIndex() == 0) 
				this.welcome.setJTextField1((""));
			
			else if(welcome.getJComboBox1().getSelectedIndex() == 1) 
				this.welcome.setJTextField1(("Titre de film"));	
			
			else if(welcome.getJComboBox1().getSelectedIndex() == 2)
				this.welcome.setJTextField1(("Nom de l'acteur"));
		}
		
	}
	// selected movie
	@Override
	public void valueChanged(ListSelectionEvent e) {
		
	    if (e.getSource() == welcome.getjTable1().getSelectionModel() && welcome.getjTable1().getRowSelectionAllowed()) {
			int selected = welcome.getjTable1().getSelectedRow(); 
			tableDeleteAllRows(welcome.getjTable2());
		    String[] o;
			if(selected == 0) {
				o = new String[]{"pppppp"}; 
				this.insertRow(welcome.getjTable2(), o);

			}
			if(selected == 1) {
				o = new String[]{"oooooooo"}; 
				this.insertRow(welcome.getjTable2(), o);
			}
	      } 
	}
	
	private void tableDeleteAllRows(JTable table) {
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		int rowCount = dm.getRowCount();
		//Remove rows one by one from the end of the table
		for (int i = rowCount - 1; i >= 0; i--) {
		    dm.removeRow(i);
		}
	}
	
	private void insertRow(JTable table, String[] row) {
	    DefaultTableModel t = (DefaultTableModel) table.getModel();
	    Vector<String> v = new Vector<String>(Arrays.asList(row)) ; 
	    t.insertRow(table.getRowCount(),  v);
	}
}
