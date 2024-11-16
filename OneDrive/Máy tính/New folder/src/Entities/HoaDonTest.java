package Entities;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class HoaDonTest {

    private HoaDon hoaDon;
    private ArrayList<SachTrongGioHang> sachMua;

    @BeforeEach
    public void setUp() {
        sachMua = new ArrayList<>();
        // Tạo một đối tượng Sach
        Sach sach1 = new Sach("S001", "Sách A", 2023, 100, "TG01", "NXB01", 20000, 10);
        Sach sach2 = new Sach("S002", "Sách B", 2023, 150, "TG02", "NXB02", 30000, 5);
        // Thêm sách vào giỏ hàng
        sachMua.add(new SachTrongGioHang("TK001", sach1, 2)); // 2 cuốn Sách A
        sachMua.add(new SachTrongGioHang("TK001", sach2, 1)); // 1 cuốn Sách B
        // Tạo hóa đơn
        hoaDon = new HoaDon("HD001", "2024-11-16", "Nguyen Van A", sachMua, 3, 70000);
    }

    @Test
    public void testGetMaHoaDon() {
        assertEquals("HD001", hoaDon.getMaHD());
    }

    @Test
    public void testGetTenKhachHang() {
        assertEquals("Nguyen Van A", hoaDon.getTenKH());
    }

    @Test
    public void testGetNgayGiaoDich() {
        assertEquals("2024-11-16", hoaDon.getNgayGiaoDich());
    }

    @Test
    public void testGetSachMua() {
        assertEquals(sachMua, hoaDon.getSachMua());
    }

    @Test
    public void testTongTien() {
        float expectedTotal = 2 * sachMua.get(0).getSachDaChon().getDonGia() +
                              1 * sachMua.get(1).getSachDaChon().getDonGia();
        assertEquals(expectedTotal, hoaDon.getThanhTien(), 0.01);
    }

    @Test
    public void testAddSach() {
        Sach sach3 = new Sach("S003", "Sách C", 2023, 200, "TG03", "NXB03", 25000, 8);
        SachTrongGioHang sachTrongGioHang3 = new SachTrongGioHang("TK001", sach3, 1);
        
        // Thêm sách vào hóa đơn
        hoaDon.getSachMua().add(sachTrongGioHang3);

         
        // Kiểm tra số lượng sách trong hóa đơn
        assertEquals(3, hoaDon.getSachMua().size());
    }

    @Test
    public void testRemoveSach() {
        // Xóa sách đầu tiên trong giỏ hàng
        sachMua.remove(0);
        hoaDon.setSachMua(sachMua); // Cập nhật danh sách sách trong hóa đơn

        // Kiểm tra số lượng sách trong hóa đơn
        assertEquals(1, hoaDon.getSachMua().size()); // Kỳ vọng số lượng sách còn lại là 1
    }
}