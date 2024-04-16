package GUI.custom.table;

import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
public class TableActionCellEditorSale  extends DefaultCellEditor{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TableActionEvent event;
	public TableActionCellEditorSale(TableActionEvent event) {
		super(new JCheckBox());
		this.event = event;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		PanelActionSale action = new PanelActionSale();
		action.initEvent(event, row);
		action.setBackground(table.getSelectionBackground());
		return action;
	}
}

