package BLL;

import DAL.TacGiaDAL;
import Entities.TacGia;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class TacGiaBLL {
	public static TableModel show() {

		ArrayList<TacGia> list = TacGiaDAL.show();
		String[] columnNames = { "STT", "Mã tác giả", "Tên tác giả", "số đầu sách" };
		Object[][] data = new Object[list.size()][columnNames.length];
		int row = 0;
		for (TacGia c : list) {
			data[row][0] = (row + 1);
			data[row][1] = c.getMaTG();
			data[row][2] = c.getTenTG();
			data[row][3] = c.getSoDauSach();
			row++;
		}

		DefaultTableModel table = new DefaultTableModel(data, columnNames) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return int.class;
				case 1:
					return String.class;
				case 2:
					return String.class;
				case 3:
					return int.class;
				default:
					return String.class;
				}
			};

			@Override
			public boolean isCellEditable(int row, int column) {
				// all cells false
				return false;
			};
		};

		return table;

	}

	public static Object[] showControlWithCombobox(String cbbValue) {
		ArrayList<TacGia> list = TacGiaDAL.show();
		Object[] obj = new Object[4];
		for (TacGia k : list) {
			if (cbbValue.equals(k.getMaTG())) {
				obj[1] = k.getMaTG();
				obj[2] = k.getTenTG();
			}
		}
		return obj;
	}

	public static ComboBoxModel<String> cbb_show() {

		StringBuilder items = new StringBuilder();

		for (int i = 0; i < TacGiaDAL.show().size(); i++) {
			items.append(TacGiaDAL.show().get(i).getMaTG());
			items.append("#");
		}

		return new DefaultComboBoxModel<String>(items.toString().split("#"));
	}
}
