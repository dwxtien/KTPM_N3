/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Entities.HoaDon;
import Tools.Doc_List_Tu_File;
import Tools.Ghi_List_Vao_File;
import java.io.IOException;
import java.util.ArrayList;

public class HoaDonDAL {
    public static ArrayList<HoaDon> show(){
        try{
            ArrayList<HoaDon> a = new ArrayList<HoaDon>();
            a = Doc_List_Tu_File.Doc_HoaDon_Tu_File();
            return a;
        }
        catch(IOException e){
            return null;
        }
        catch(ClassNotFoundException e){
            return null;
        }
    }
    
    public static void insert(ArrayList<HoaDon> list, HoaDon a) throws IOException{
        
        list.add(a);
        Ghi_List_Vao_File.ghi_HoaDon_Vao_File(list);
    }
    
    
    public static boolean delete(ArrayList<HoaDon> list, HoaDon a) throws IOException{
        int index = -1;
        for(int i=0;i<list.size();i++)
            if(a.getMaHD().equals(list.get(i).getMaHD())){
                index = i;
            }
        if(index!=-1){
            list.remove(index);
            Ghi_List_Vao_File.ghi_HoaDon_Vao_File(list);
            return true;
        }
        else
        return false;
    }
    
}
