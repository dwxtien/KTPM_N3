package DAL;

import Entities.TaiKhoan;
import Tools.Doc_List_Tu_File;
import Tools.Ghi_List_Vao_File;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TaiKhoanDAL_Test {

    private ArrayList<TaiKhoan> taiKhoanList;

    @BeforeEach
    public void setUp() {
        taiKhoanList = new ArrayList<>();
        taiKhoanList.add(new TaiKhoan("TK001", "User 1", "User "));
        taiKhoanList.add(new TaiKhoan("TK002", "Admin1", "Admin"));
        taiKhoanList.add(new TaiKhoan("TK003", "User 2", "User "));
    }

    @Test
    public void testShow() throws IOException, ClassNotFoundException {
        // Giả lập phương thức đọc file
        Doc_List_Tu_File mockDoc = mock(Doc_List_Tu_File.class);
        when(mockDoc.Doc_TaiKhoan_Tu_File()).thenReturn(taiKhoanList);

        // Gọi phương thức show
        ArrayList<TaiKhoan> result = TaiKhoanDAL.show();

        // Kiểm tra kết quả
        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals("User 1", result.get(0).getMaTaiKhoan());
    }

    @Test
    public void testShowAdmin() throws IOException, ClassNotFoundException {
        // Giả lập phương thức đọc file
        Doc_List_Tu_File mockDoc = mock(Doc_List_Tu_File.class);
        when(mockDoc.Doc_TaiKhoan_Tu_File()).thenReturn(taiKhoanList);

        // Gọi phương thức showAdmin
        ArrayList<TaiKhoan> result = TaiKhoanDAL.showAdmin();

        // Kiểm tra kết quả
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Admin1", result.get(0).getMaTaiKhoan());
    }

    @Test
    public void testShowUser () throws IOException, ClassNotFoundException {
        // Giả lập phương thức đọc file
        Doc_List_Tu_File mockDoc = mock(Doc_List_Tu_File.class);
        when(mockDoc.Doc_TaiKhoan_Tu_File()).thenReturn(taiKhoanList);

        // Gọi phương thức showUser 
        ArrayList<TaiKhoan> result = TaiKhoanDAL.showUser ();

        // Kiểm tra kết quả
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("User 1", result.get(0).getMaTaiKhoan());
    }

    @Test
    public void testInsert() throws IOException {
        TaiKhoan newTaiKhoan = new TaiKhoan("TK004", "User 3", "User ");

        // Gọi phương thức insert
        boolean result = TaiKhoanDAL.insert(taiKhoanList, newTaiKhoan);

        // Kiểm tra kết quả
        assertTrue(result);
        assertEquals(4, taiKhoanList.size());
        assertEquals("User 3", taiKhoanList.get(3).getMaTaiKhoan());
    }

    @Test
    public void testInsertDuplicate() throws IOException {
        TaiKhoan duplicateTaiKhoan = new TaiKhoan("TK001", "User 1", "User ");

        // Gọi phương thức insert
        boolean result = TaiKhoanDAL.insert(taiKhoanList, duplicateTaiKhoan);

        // Kiểm tra kết quả
        assertFalse(result);
        assertEquals(3, taiKhoanList.size()); // Không thay đổi số lượng
    }
}