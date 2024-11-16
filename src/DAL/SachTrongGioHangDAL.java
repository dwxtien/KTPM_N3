/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;
import Entities.SachTrongGioHang;
import Tools.Doc_List_Tu_File;
import Tools.Ghi_List_Vao_File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class SachTrongGioHangDAL {
    public static ArrayList<SachTrongGioHang> showAll(){
        try{
            ArrayList<SachTrongGioHang> a = Doc_List_Tu_File.Doc_SachTrongGioHang_Tu_File();
            
            return a;
        }
        catch(IOException e){
            return null;
        }
        catch(ClassNotFoundException e){
            return null;
        }
    }
    
    public static ArrayList<SachTrongGioHang> show(String maTaiKhoan){
        try{
            ArrayList<SachTrongGioHang> a = Doc_List_Tu_File.Doc_SachTrongGioHang_Tu_File()
            		, b = new ArrayList<SachTrongGioHang>();
            for(SachTrongGioHang i:a){
                if(i.getMaTaiKhoan().equals(maTaiKhoan))
                    b.add(i);
            }
            return b;
        }
        catch(IOException e){
            return null;
        }
        catch(ClassNotFoundException e){
            return null;
        }
    }
    
    public static int showSoLuong(String maTaiKhoan){
        try{
            int t=0;
            ArrayList<SachTrongGioHang> a = Doc_List_Tu_File.Doc_SachTrongGioHang_Tu_File()
//            		, b = new ArrayList<SachTrongGioHang>()
            		;
            for(SachTrongGioHang i:a){
                if(i.getMaTaiKhoan().equals(maTaiKhoan))
                    t+=i.getSoLuong();
            }
            return t;
        }
        catch(IOException e){
            return 0;
        }
        catch(ClassNotFoundException e){
            return 0;
        }
    }
    
    public static Double showthanhTien(String maTaiKhoan){
        try{
            Double t=0.0;
            ArrayList<SachTrongGioHang> a = Doc_List_Tu_File.Doc_SachTrongGioHang_Tu_File()
//            		, b = new ArrayList<SachTrongGioHang>()
            		;
            for(SachTrongGioHang i:a){
                if(i.getMaTaiKhoan().equals(maTaiKhoan))
                    t+=i.getThanhTien();
            }
            return t;
        }
        catch(IOException e){
            return 0.0;
        }
        catch(ClassNotFoundException e){
            return 0.0;
        }
    }
    
    public static boolean insert(ArrayList<SachTrongGioHang> list, SachTrongGioHang a) throws IOException{
        if(a.getMaTaiKhoan().equals("")){
            JOptionPane.showMessageDialog(null,"Vui lòng đăng nhập để thực hiện");
            return false;
        }
        list.add(a);
        Ghi_List_Vao_File.ghi_SachTrongGioHang_Vao_File(list);
        return true;
    }
    
    
    
    public static boolean delete(ArrayList<SachTrongGioHang> list, SachTrongGioHang a) throws IOException{
        int index = -1;
        for(int i=0;i<list.size();i++)
            if(a.getMaTaiKhoan().equals(list.get(i).getMaTaiKhoan()) && 
                    a.getSachDaChon().getMaSach().equals(list.get(i).getSachDaChon().getMaSach())){
                index = i;
            }
        if(index!=-1){
            list.remove(index);
            Ghi_List_Vao_File.ghi_SachTrongGioHang_Vao_File(list);
            return true;
        }
        else
        return false;
    }
}
