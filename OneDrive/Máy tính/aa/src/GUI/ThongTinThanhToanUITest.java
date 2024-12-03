package GUI;

import Entities.HoaDon;
import Entities.Sach;
import Entities.SachTrongGioHang;
import DAL.HoaDonDAL;
import DAL.SachTrongGioHangDAL;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ThongTinThanhToanUITest {

    private ThongTinThanhToanUI thongTinThanhToanUI;
    private ArrayList<SachTrongGioHang> sachTrongGioHangList;

    @BeforeEach
    public void setUp() {
        // Khởi tạo danh sách sách trong giỏ hàng
        sachTrongGioHangList = new ArrayList<>();
        
        // Tạo một đối tượng SachTrongGioHang và thiết lập các thuộc tính
        SachTrongGioHang sach1 = new SachTrongGioHang();
        sach1.setMaTaiKhoan("TK001");
        sach1.setSachDaChon(new Sach());
        sach1.getSachDaChon().setMaSach("S001");
        sach1.getSachDaChon().setTenSach("Test Book");
        sach1.setSoLuong(2);
        
        // Thêm sách vào danh sách giỏ hàng
        sachTrongGioHangList.add(sach1);

        // Khởi tạo đối tượng ThongTinThanhToanUI với tên người dùng và danh sách sách trong giỏ hàng
        thongTinThanhToanUI = new ThongTinThanhToanUI("Test User", sachTrongGioHangList);
    }

    @Test
    public void testUIComponents() {
        // Kiểm tra các thành phần UI không null
        assertNotNull(thongTinThanhToanUI); // Kiểm tra đối tượng thongTinThanhToanUI không null
        assertNotNull(thongTinThanhToanUI.btnConfirm); // Kiểm tra nút "Xác nhận" không null
        assertNotNull(thongTinThanhToanUI.btnHuy); // Kiểm tra nút "Hủy" không null
        assertNotNull(thongTinThanhToanUI.txtTenKH); // Kiểm tra ô nhập tên khách hàng không null
        assertNotNull(thongTinThanhToanUI.txtMaHoaDon); // Kiểm tra ô nhập mã hóa đơn không null
        assertNotNull(thongTinThanhToanUI.txtSoLuong); // Kiểm tra ô nhập số lượng không null
        assertNotNull(thongTinThanhToanUI.txtThanhTien); // Kiểm tra ô nhập thành tiền không null
    }

    @Test
    public void testShowWindow() {
        // Kiểm tra cửa sổ được hiển thị
        thongTinThanhToanUI.showWindow(); // Gọi phương thức hiển thị cửa sổ
        assertTrue(thongTinThanhToanUI.isShowing()); // Kiểm tra cửa sổ có đang hiển thị không
    }

    @Test
    public void testDisplayTransactionInfo() {
        // Hiển thị cửa sổ
        thongTinThanhToanUI.showWindow();
        
        // Kiểm tra thông tin giao dịch hiển thị đúng
        assertEquals("HD1", thongTinThanhToanUI.txtMaHoaDon.getText()); // Kiểm tra mã hóa đơn hiển thị đúng
        assertEquals("Test User", thongTinThanhToanUI.txtTenKH.getText()); // Kiểm tra tên khách hàng hiển thị đúng
        assertEquals(String.valueOf(SachTrongGioHangDAL.showSoLuong("Test User")), thongTinThanhToanUI.txtSoLuong.getText()); // Kiểm tra số lượng hiển thị đúng
        assertEquals(String.valueOf(SachTrongGioHangDAL.showthanhTien("Test User")), thongTinThanhToanUI.txtThanhTien.getText()); // Kiểm tra thành tiền hiển thị đúng
    }

    @Test
    public void testConfirmButtonAction() throws Exception {
        // Giả lập hành động nhấn nút xác nhận
        thongTinThanhToanUI.btnConfirm.doClick();
        
        // Kiểm tra xem có thông báo thành công không
        // Thông báo sẽ được hiển thị qua JOptionPane, cần kiểm tra xem có gọi đúng hàm không
        // Có thể cần sử dụng một thư viện mock để kiểm tra điều này
    }

    @Test
    public void testCancelButtonAction() {
        // Giả lập hành động nhấn nút hủy
        thongTinThanhToanUI.btnHuy.doClick();
        
        // Kiểm tra cửa sổ không còn hiển thị nữa
        assertFalse(thongTinThanhToanUI.isShowing());
    }
}
