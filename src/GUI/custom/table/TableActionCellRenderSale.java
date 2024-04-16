package GUI.custom.table;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class TableActionCellRenderSale extends DefaultTableCellRenderer{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,int row, int column) {
		Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		PanelActionSale action = new PanelActionSale();
		if (isSelected == false && row % 2 == 0) {
			action.setBackground(Color.decode("#1679AB"));
		}else {
			action.setBackground(com.getBackground());
		}
		return action;
	}
}
