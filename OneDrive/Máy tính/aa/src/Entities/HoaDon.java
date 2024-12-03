package Entities;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import Tools.Doc_List_Tu_File;

public class HoaDon implements Serializable{
	private String MaHD;
    private String NgayGiaoDich;
    private String TenKH;
    private ArrayList<SachTrongGioHang> SachMua;
    private int SoLuong;
    private double ThanhTien;
    public HoaDon() {
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public double getThanhTien() {
        return ThanhTien;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public void setThanhTien(double ThanhTien) {
        this.ThanhTien = ThanhTien;
    }
    
    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getNgayGiaoDich() {
        return NgayGiaoDich;
    }

    public void setNgayGiaoDich(String NgayGiaoDich) {
        this.NgayGiaoDich = NgayGiaoDich;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public ArrayList<SachTrongGioHang> getSachMua() {
        return SachMua;
    }

    public void setSachMua(ArrayList<SachTrongGioHang> SachMua) {
        this.SachMua = SachMua;
    }

    public HoaDon(String MaHD, String NgayGiaoDich, String TenKH, ArrayList<SachTrongGioHang> SachMua, int SoLuong, double ThanhTien) {
        this.MaHD = MaHD;
        this.NgayGiaoDich = NgayGiaoDich;
        this.TenKH = TenKH;
        this.SachMua = SachMua;
        this.SoLuong = SoLuong;
        this.ThanhTien = ThanhTien;
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<HoaDon> a = Doc_List_Tu_File.Doc_HoaDon_Tu_File();
    }
}
