package GUI;

import Entities.Sach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ThemSachVaoGioHangUITest {

    private ThemSachVaoGioHangUI themSachVaoGioHangUI;
    private Sach testSach;

    @BeforeEach
    public void setUp() {
        // Khởi tạo đối tượng testSach với các giá trị phù hợp
        testSach = new Sach();
        testSach.setMaSach("S001");
        testSach.setTenSach("Test Book");
        testSach.setNamXuatBan(2021);
        testSach.setSoTrang(200);
        testSach.setMaTG("TG001");
        testSach.setMaTG("NXB001");
        testSach.setDonGia(10000);

        // Khởi tạo đối tượng themSachVaoGioHangUI với mã tài khoản, sách và số lượng
        themSachVaoGioHangUI = new ThemSachVaoGioHangUI("TK001", testSach, 3);
    }
 
    @Test
    public void testUIComponents() {
        // Kiểm tra các thành phần UI không null
        assertNotNull(themSachVaoGioHangUI); // Kiểm tra đối tượng themSachVaoGioHangUI không null
        assertNotNull(themSachVaoGioHangUI.getBtnThemGio()); // Kiểm tra nút "Thêm vào giỏ" không null
        assertNotNull(themSachVaoGioHangUI.getBtnExit1()); // Kiểm tra nút "Thoát" không null
        assertNotNull(themSachVaoGioHangUI.getTxtSoLuong()); // Kiểm tra ô nhập số lượng không null
    }

    @Test
    public void testShowWindow() {
        // Kiểm tra cửa sổ được hiển thị
        themSachVaoGioHangUI.showWindow(); // Gọi phương thức hiển thị cửa sổ
        assertTrue(themSachVaoGioHangUI.isShowing()); // Kiểm tra cửa sổ có đang hiển thị không
    }

    @Test
    public void testShowSachDetails() {
        // Kiểm tra thông tin chi tiết của sách hiển thị đúng
        assertEquals("Test Book", themSachVaoGioHangUI.showTenSach.getText()); // Kiểm tra tên sách hiển thị đúng
        assertEquals("2021", themSachVaoGioHangUI.showNamXB.getText()); // Kiểm tra năm xuất bản hiển thị đúng
        assertEquals("200", themSachVaoGioHangUI.showSoTrang.getText()); // Kiểm tra số trang hiển thị đúng
        assertEquals("10000.0", themSachVaoGioHangUI.showDonGia.getText()); // Kiểm tra đơn giá hiển thị đúng
        assertEquals("3", themSachVaoGioHangUI.showSoLuong.getText()); // Kiểm tra số lượng hiển thị đúng
        assertEquals("30000.0", themSachVaoGioHangUI.showThanhTien.getText()); // Kiểm tra thành tiền hiển thị đúng (2 * 10000)
    }
}
