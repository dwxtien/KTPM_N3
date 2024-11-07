/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import Tools.Ghi_List_Vao_File;

public class TacGia implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String MaTG;
    private String TenTG;
    private int soDauSach;
    public TacGia() {
    }

    public TacGia(String MaTG, String TenTG, int soDauSach) {
        this.MaTG = MaTG;
        this.TenTG = TenTG;
        this.soDauSach=soDauSach;
    }

    public String getMaTG() {
        return MaTG;
    }

    public void setMaTG(String MaTG) {
        this.MaTG = MaTG;
    }

    public String getTenTG() {
        return TenTG;
    }

    public void setTenTG(String TenTG) {
        this.TenTG = TenTG;
    }

    @Override
    public String toString() {
        return "TacGia{" + "MaTG=" + MaTG + ", TenTG=" + TenTG + '}';
    }

	public int getSoDauSach() {
		return soDauSach;
	}

	public void setSoDauSach(int soDauSach) {
		this.soDauSach = soDauSach;
	}
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		TacGia x1 = new TacGia("TG01", "Nguyễn Thị Hồng", 10);
		
		ArrayList<TacGia> a = new ArrayList<TacGia>();
		a.add(x1);
		Ghi_List_Vao_File.ghi_TacGia_Vao_File(a);
//		ArrayList<TacGia> b = Doc_List_Tu_File.Doc_TacGia_Tu_File();
	}
}
