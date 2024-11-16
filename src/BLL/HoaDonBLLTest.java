package BLL;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import javax.swing.table.TableModel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import DAL.HoaDonDAL;
import Entities.HoaDon;

public class HoaDonBLLTest {

    private ArrayList<HoaDon> hoaDonList;
    private HoaDon hoaDon1;
    private HoaDon hoaDon2;

    @BeforeEach
    public void setUp() {
        hoaDonList = new ArrayList<>();
        hoaDon1 = new HoaDon("HD01", "2024-11-13", "Nguyen Van A", new ArrayList<>(), 3, 150.0);
        hoaDon2 = new HoaDon("HD02", "2024-11-14", "Nguyen Van B", new ArrayList<>(), 2, 200.0);
        hoaDonList.add(hoaDon1);
        hoaDonList.add(hoaDon2);
    }

    @Test
    public void testShow() {
        try (MockedStatic<HoaDonDAL> hoaDonDALMock = Mockito.mockStatic(HoaDonDAL.class)) {
            hoaDonDALMock.when(HoaDonDAL::show).thenReturn(hoaDonList);

            TableModel tableModel = HoaDonBLL.show();
            assertNotNull(tableModel);
            assertEquals(2, tableModel.getRowCount());
            assertEquals("HD01", tableModel.getValueAt(0, 1));
            assertEquals("HD02", tableModel.getValueAt(1, 1));
        }
    }

    @Test
    public void testTongSoLuong() {
        try (MockedStatic<HoaDonDAL> hoaDonDALMock = Mockito.mockStatic(HoaDonDAL.class)) {
            hoaDonDALMock.when(HoaDonDAL::show).thenReturn(hoaDonList);

            int totalQuantity = HoaDonBLL.TongSoLuong();
            assertEquals(5, totalQuantity);
        }
    }

    @Test
    public void testTongDoanhThu() {
        try (MockedStatic<HoaDonDAL> hoaDonDALMock = Mockito.mockStatic(HoaDonDAL.class)) {
            hoaDonDALMock.when(HoaDonDAL::show).thenReturn(hoaDonList);

            float totalRevenue = HoaDonBLL.TongDoanhThu();
            assertEquals(350.0, totalRevenue);
        }
    }
}
