/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import DAL.NhaXuatBanDAL;
import DAL.SachDAL;
import DAL.TacGiaDAL;
import Entities.Sach;

public class SachBLL {
	public static TableModel showForUser() {
		ArrayList<Sach> list = SachDAL.show();
		HashMap<String, String> mapTG = TacGiaDAL.hashMapTG();
		HashMap<String, String> mapNXB = NhaXuatBanDAL.hashMapNXB();
		String[] columnNames = { "STT", "Mã sách", "Tên sách", "Năm xuất bản", "Số trang", "Tác giả", "Nhà Xuất Bản",
				"Đơn giá", "Số lượng còn" };
		Object[][] data = new Object[list.size()][columnNames.length];
		int row = 0;
		for (Sach c : list) {
			data[row][0] = (row + 1);
			data[row][1] = c.getMaSach();
			data[row][2] = c.getTenSach();
			data[row][3] = c.getNamXuatBan();
			data[row][4] = c.getSoTrang();
			data[row][5] = mapTG.get(c.getMaTG());
			data[row][6] = mapNXB.get(c.getMaNXB());
			data[row][7] = c.getDonGia();
			data[row][8] = c.getSoLuongCon();
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
					return Integer.class;
				case 4:
					return Integer.class;
				case 5:
					return String.class;
				case 6:
					return String.class;
				case 7:
					return Float.class;
				default:
					return Integer.class;
				}
			};

			@Override
			public boolean isCellEditable(int row, int column) {
				// all cells false
				return false;
			}
		};

		return table;

	}

	public static TableModel show() {

		ArrayList<Sach> list = SachDAL.show();
		String[] columnNames = { "STT", "Mã sách", "Tên sách", "Năm xuất bản", "Số trang", "Mã tác giả", "Mã NXB",
				"Đơn giá", "Số lượng còn" };
		Object[][] data = new Object[list.size()][columnNames.length];
		int row = 0;
		for (Sach c : list) {
			data[row][0] = (row + 1);
			data[row][1] = c.getMaSach();
			data[row][2] = c.getTenSach();
			data[row][3] = c.getNamXuatBan();
			data[row][4] = c.getSoTrang();
			data[row][5] = c.getMaTG();
			data[row][6] = c.getMaNXB();
			data[row][7] = c.getDonGia();
			data[row][8] = c.getSoLuongCon();
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
					return Integer.class;
				case 4:
					return Integer.class;
				case 5:
					return String.class;
				case 6:
					return String.class;
				case 7:
					return Float.class;
				default:
					return Integer.class;
				}
			};

			@Override
			public boolean isCellEditable(int row, int column) {
				// all cells false
				return false;
			}
		};

		return table;

	}
}
