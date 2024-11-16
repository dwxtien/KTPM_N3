/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.NhaXuatBanDAL;
import DAL.SachDAL;
import Entities.NhaXuatBan;
import Entities.Sach;

import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class NhaXuatBanBLL {
	public static TableModel show() {

		ArrayList<NhaXuatBan> list = NhaXuatBanDAL.show();
		ArrayList<Sach> listS = SachDAL.show();
		
		String[] columnNames = { "STT", "Mã nhà xuất bản", "Tên nhà xuất bản", "Địa chỉ", "Số điện thoại",
				"Số đầu sách" };
		Object[][] data = new Object[list.size()][columnNames.length];
		int row = 0;
		for (NhaXuatBan c : list) {
			data[row][0] = row + 1;
			data[row][1] = c.getMaNXB();
			data[row][2] = c.getTenNXB();
			data[row][3] = c.getDiaChi();
			data[row][4] = c.getSDT();
			data[row][5] = listS
							.stream()
							.filter(item->item.getMaNXB().equalsIgnoreCase(c.getMaNXB()))
							.collect(Collectors.toList())
							.size() ;
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
					return Integer.class;
				case 1:
					return String.class;
				case 2:
					return String.class;
				case 3:
					return String.class;
				case 4:
					return String.class;
				case 5:
					return Integer.class;
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
		ArrayList<NhaXuatBan> list = NhaXuatBanDAL.show();
		Object[] obj = new Object[4];
		for (NhaXuatBan k : list) {
			if (cbbValue.equals(k.getMaNXB())) {
				obj[0] = k.getMaNXB();
				obj[1] = k.getTenNXB();
				obj[2] = k.getDiaChi();
				obj[3] = k.getSDT();
			}
		}
		return obj;
	}

	public static ComboBoxModel<String> cbb_show() {

		StringBuilder items = new StringBuilder();

		for (int i = 0; i < NhaXuatBanDAL.show().size(); i++) {
			items.append(NhaXuatBanDAL.show().get(i).getMaNXB());
			items.append("#");
		}

		return new DefaultComboBoxModel<String>(items.toString().split("#"));
	}
}
