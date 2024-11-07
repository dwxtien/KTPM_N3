package DAL;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

import Entities.Sach;
import Entities.TacGia;
import Tools.Doc_List_Tu_File;
import Tools.Ghi_List_Vao_File;

public class TacGiaDAL {
	public static ArrayList<TacGia> show() {
		try {
			ArrayList<TacGia> a = new ArrayList<TacGia>();
			a = Doc_List_Tu_File.Doc_TacGia_Tu_File();
			ArrayList<Sach> b = new ArrayList<Sach>();
			b = Doc_List_Tu_File.Doc_Sach_Tu_File();
//			HashMap<String, Integer> count = new HashMap<String, Integer>();
			for(TacGia author:a) {
				author.setSoDauSach(
							(b.stream()
							.filter(item->item.getMaTG()
							.equalsIgnoreCase(author.getMaTG()))
							.collect(Collectors.toList()))
							.size()
				);
			}
			Collections.sort(a, Comparator.comparing(TacGia::getMaTG));
			return a;
		} catch (IOException e) {
			return null;
		} catch (ClassNotFoundException e) {
			return null;
		}
	}
	public static HashMap<String,String > hashMapTG() {
		HashMap<String,String > mapTG = new HashMap<String, String>();
		ArrayList<TacGia> listTG = TacGiaDAL.show();
		for (TacGia item : listTG) {
			mapTG.put(item.getMaTG(), item.getTenTG());
		}
		return mapTG;
	}
	public static String GetTenTG(String maTG) {
		ArrayList<TacGia> a = show();
		for (TacGia item : a) {
			if (item.getMaTG().equals(maTG))
				return item.getTenTG();
		}
		return "";
	}

	public static boolean insert(ArrayList<TacGia> list, TacGia a) throws IOException {
		if (a.getMaTG().equals("")) {
			JOptionPane.showMessageDialog(null, "Mã tác giả không được để trống");
			return false;
		}
		for (TacGia item : list)
			if (a.getMaTG().equals(item.getMaTG())) {
				JOptionPane.showMessageDialog(null, "Mã tác giả đã tồn tại");
				return false;
			}
		int index = list.size();
		for (int i = 0; i < list.size(); i++) {
			if (a.getMaTG().compareTo(list.get(i).getMaTG()) > 0)
				index = i + 1;
		}
		list.add(index, a);
		Ghi_List_Vao_File.ghi_TacGia_Vao_File(list);
		return true;
	}

	public static boolean update(ArrayList<TacGia> list, TacGia a) throws IOException {
		int index = -1;
		for (int i = 0; i < list.size(); i++)
			if (a.getMaTG().equals(list.get(i).getMaTG())) {
				index = i;
			}
		if (index != -1) {
			list.set(index, a);
			Ghi_List_Vao_File.ghi_TacGia_Vao_File(list);
			return true;
		}
		return false;

	}

	public static boolean delete(ArrayList<TacGia> list, TacGia a) throws IOException {
		int index = -1;
		for (int i = 0; i < list.size(); i++)
			if (a.getMaTG().equals(list.get(i).getMaTG())) {
				index = i;
			}
		if (index != -1) {
			list.remove(index);
			Ghi_List_Vao_File.ghi_TacGia_Vao_File(list);
			return true;
		} else
			return false;
	}
}
