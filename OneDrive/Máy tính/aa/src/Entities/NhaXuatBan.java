/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.io.IOException;
import java.io.Serializable;


@SuppressWarnings("serial")
public class NhaXuatBan implements Serializable{
	private String MaNXB;
    private String TenNXB;
    private String DiaChi;
    private String SDT;

    public NhaXuatBan() {
    }

    public NhaXuatBan(String MaNXB, String TenNXB, String DiaChi, String SDT) {
        this.MaNXB = MaNXB;
        this.TenNXB = TenNXB;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
    }

    public String getMaNXB() {
        return MaNXB;
    }

    public void setMaNXB(String MaNXB) {
        this.MaNXB = MaNXB;
    }

    public String getTenNXB() {
        return TenNXB;
    }

    public void setTenNXB(String TenNXB) {
        this.TenNXB = TenNXB;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    @Override
    public String toString() {
        return "NhaXuatBan{" + "MaNXB=" + MaNXB + ", TenNXB=" + TenNXB + ", DiaChi=" + DiaChi + ", SDT=" + SDT + '}';
    }
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        ArrayList<NhaXuatBan> a = Doc_List_Tu_File.Doc_NhaXuatBan_Tu_File();
    }
}
