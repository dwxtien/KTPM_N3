/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tools;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.logging.Logger;

import Entities.HoaDon;
import Entities.NhaXuatBan;
import Entities.Sach;
import Entities.SachTrongGioHang;
import Entities.TacGia;
import Entities.TaiKhoan;

public class Doc_List_Tu_File {
    public static ArrayList<TacGia> Doc_TacGia_Tu_File() throws IOException, ClassNotFoundException{
        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("TacGia.DAT"));
            @SuppressWarnings("unchecked")
			ArrayList<TacGia> s=(ArrayList<TacGia>)in.readObject();
            in.close();
            return s;
        }
        catch(FileNotFoundException e){
            Logger.getLogger("TacGia.DAT", e.getMessage());
            return new ArrayList<TacGia>();
        }
    }
    
    public static ArrayList<HoaDon> Doc_HoaDon_Tu_File() throws IOException, ClassNotFoundException{
        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("HoaDon.DAT"));
            @SuppressWarnings("unchecked")
			ArrayList<HoaDon> s=(ArrayList<HoaDon>)in.readObject();
            in.close();
            return s;
        }
        catch(FileNotFoundException e){
            Logger.getLogger("HoaDon.DAT", e.getMessage());
            return new ArrayList<HoaDon>();
        }
    }
    
    public static ArrayList<SachTrongGioHang> Doc_SachTrongGioHang_Tu_File() throws IOException, ClassNotFoundException{
        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("SachTrongGioHang.DAT"));
            @SuppressWarnings("unchecked")
			ArrayList<SachTrongGioHang> s=(ArrayList<SachTrongGioHang>)in.readObject();
            in.close();
            return s;
        }
        catch(FileNotFoundException e){
            Logger.getLogger("SachTrongGioHang.DAT", e.getMessage());
            return new ArrayList<SachTrongGioHang>();
        }
    }
    
    public static ArrayList<NhaXuatBan> Doc_NhaXuatBan_Tu_File() throws IOException, ClassNotFoundException{
        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("NhaXuatBan.DAT"));
            @SuppressWarnings("unchecked")
			ArrayList<NhaXuatBan> s=(ArrayList<NhaXuatBan>)in.readObject();
            in.close();
            return s;
        }
        catch(FileNotFoundException e){
            Logger.getLogger("NhaXuatBan.DAT", e.getMessage());
            return new ArrayList<NhaXuatBan>();
        }
    }
    
    public static ArrayList<Sach> Doc_Sach_Tu_File() throws IOException, ClassNotFoundException{
        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("Sach.DAT"));
            @SuppressWarnings("unchecked")
			ArrayList<Sach> s=(ArrayList<Sach>)in.readObject();
            in.close();
            return s;
        }
        catch(FileNotFoundException e){
            Logger.getLogger("Sach.DAT", e.getMessage());
            return new ArrayList<Sach>();
        }
    }
    
    public static ArrayList<TaiKhoan> Doc_TaiKhoan_Tu_File() throws IOException, ClassNotFoundException{
        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("TaiKhoan.DAT"));
            @SuppressWarnings("unchecked")
			ArrayList<TaiKhoan> s=(ArrayList<TaiKhoan>)in.readObject();
            in.close();
            return s;
        }
        catch(FileNotFoundException e){
            Logger.getLogger("TaiKhoan.DAT", e.getMessage());
            return new ArrayList<TaiKhoan>();
        }
    }
}
