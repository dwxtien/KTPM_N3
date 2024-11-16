package Entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaiKhoanTest {

    private TaiKhoan taiKhoan;

    @BeforeEach
    public void setUp() {
        taiKhoan = new TaiKhoan("TK001", "password123", "User ");
    }

    @Test
    public void testGetMaTaiKhoan() {
        assertEquals("TK001", taiKhoan.getMaTaiKhoan());
    }

    @Test
    public void testSetMaTaiKhoan() {
        taiKhoan.setMaTaiKhoan("TK002");
        assertEquals("TK002", taiKhoan.getMaTaiKhoan());
    }

    @Test
    public void testGetMatKhau() {
        assertEquals("password123", taiKhoan.getMatKhau());
    }

    @Test
    public void testSetMatKhau() {
        taiKhoan.setMatKhau("newpassword456");
        assertEquals("newpassword456", taiKhoan.getMatKhau());
    }

    @Test
    public void testGetVaiTro() {
        assertEquals("User ", taiKhoan.getVaiTro());
    }

    @Test
    public void testSetVaiTro() {
        taiKhoan.setVaiTro("Admin");
        assertEquals("Admin", taiKhoan.getVaiTro());
    }

    @Test
    public void testToString() {
        String expectedString = "TaiKhoan{MaTaiKhoan=TK001, MatKhau=password123, VaiTro=User }";
        assertEquals(expectedString, taiKhoan.toString());
    }
}