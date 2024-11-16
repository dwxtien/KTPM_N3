/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import DAL.HoaDonDAL;
import Entities.HoaDon;

public class HoaDonBLL {
    public static TableModel show(){
        
        ArrayList<HoaDon> list= HoaDonDAL.show();
        String[] columnNames = {"STT","Mã hóa đơn","Tên khách hàng","Ngày giao dịch","Số lượng","Thành tiền"};
        Object[][] data = new Object[list.size()][columnNames.length];
        int row = 0;
        for(HoaDon c : list){
            data[row][0] = (row + 1);
            data[row][1] = c.getMaHD();
            data[row][2] = c.getTenKH();
            data[row][3] = c.getNgayGiaoDich();
            data[row][4] = c.getSoLuong();
//            data[row][5] = c.getSachMua().size();
            data[row][5] = c.getThanhTien();
            row++;
        }
        
        DefaultTableModel table = new DefaultTableModel(data,columnNames){
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            public Class<?> getColumnClass(int column){
                switch(column){
                    case 0:return Integer.class;
                    case 1:return String.class;
                    case 2: return String.class;
                    case 3: return String.class;
                    case 4: return Integer.class;
                    case 5: return Float.class;
                    default: return float.class;
                }
            };
            
            @Override
            public boolean isCellEditable(int row, int column) {
               //all cells false
               return false;
            }
        };
        
       return table;
        
    }
    
    
    public static int TongSoLuong(){
        ArrayList<HoaDon> list= HoaDonDAL.show();
        int t = 0;
        for(HoaDon item:list){
            t += item.getSoLuong();
        }
        return t;
    }
    public static float TongDoanhThu(){
        ArrayList<HoaDon> list= HoaDonDAL.show();
        float t = 0;
        for(HoaDon item:list){
            t += item.getThanhTien();
        }
        return t;
    }
}
