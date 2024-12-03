package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import BLL.HoaDonBLL;
import BLL.NhaXuatBanBLL;
import BLL.SachBLL;
import BLL.TacGiaBLL;
import BLL.TaiKhoanBLL;
import DAL.HoaDonDAL;
import DAL.NhaXuatBanDAL;
import DAL.SachDAL;
import DAL.TacGiaDAL;
import DAL.TaiKhoanDAL;
import Entities.HoaDon;
import Entities.NhaXuatBan;
import Entities.Sach;
import Entities.TacGia;
import Entities.TaiKhoan;
import javax.swing.DefaultComboBoxModel;

public class AdminUI extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	List<Sach> list;
	DefaultTableModel model;

	/**
	 * Creates new form AdminUI
	 */
	public AdminUI() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(AdminUI.class.getResource("/Image/Designcontest-Ecommerce-Business-Admin.256.png")));
		setTitle("Quản Trị Viên Hệ Thống");
		initComponents();

		show_Sach();
		show_TacGia();
		show_NhaXuatBan();
		show_TaiKhoanAdmin();
		show_TaiKhoanUser();
		if (HoaDonDAL.show() != null) {
			show_HoaDon();
			show_DoanhThu();
		}
		this.setLocationRelativeTo(null);
	}

	// show table
	DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();

	public void show_Sach() {
		model = (DefaultTableModel) tbSach.getModel();
		tbSach.setModel(SachBLL.show());
		renderer.setHorizontalAlignment(JLabel.LEFT);
		tbSach.setDefaultRenderer(Object.class, renderer);
		tbSach.getColumnModel().getColumn(0).setPreferredWidth(28);
		tbSach.getColumnModel().getColumn(1).setPreferredWidth(50);
		tbSach.getColumnModel().getColumn(2).setPreferredWidth(250);
		tbSach.getColumnModel().getColumn(3).setPreferredWidth(80);
		tbSach.getColumnModel().getColumn(4).setPreferredWidth(65);
		tbSach.getColumnModel().getColumn(5).setPreferredWidth(60);
		tbSach.getColumnModel().getColumn(6).setPreferredWidth(90);
		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
		rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);

		// Đặt renderer cho từng cột
		for (int i = 2; i < tbSach.getColumnCount(); i++) {
			tbSach.getColumnModel().getColumn(i).setCellRenderer(leftRenderer);
		}
		tbSach.getColumnModel().getColumn(7).setCellRenderer(rightRenderer);
		tbSach.getColumnModel().getColumn(8).setCellRenderer(rightRenderer);

		cboMaTG1.setModel(TacGiaBLL.cbb_show());
		cboMaNXB1.setModel(NhaXuatBanBLL.cbb_show());
		renderer.setHorizontalAlignment(JLabel.CENTER);
		tbSach.setDefaultRenderer(Object.class, renderer);
	}

	public void show_TacGia() {
		model = (DefaultTableModel) tbTacGia.getModel();
		tbTacGia.setModel(TacGiaBLL.show());
		tbTacGia.getColumnModel().getColumn(0).setPreferredWidth(30);
		tbTacGia.getColumnModel().getColumn(1).setPreferredWidth(70);
		tbTacGia.getColumnModel().getColumn(2).setPreferredWidth(200);
		tbTacGia.getColumnModel().getColumn(3).setPreferredWidth(70);

		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
		rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
		// Đặt renderer cho từng cột
		for (int i = 2; i < tbTacGia.getColumnCount(); i++) {
			tbTacGia.getColumnModel().getColumn(i).setCellRenderer(leftRenderer);
		}
		tbTacGia.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);

		renderer.setHorizontalAlignment(JLabel.CENTER);
		tbTacGia.setDefaultRenderer(Object.class, renderer);

	}

	public void show_NhaXuatBan() {
		model = (DefaultTableModel) tbNXB.getModel();
		tbNXB.setModel(NhaXuatBanBLL.show());
		tbNXB.getColumnModel().getColumn(0).setPreferredWidth(30);
		tbNXB.getColumnModel().getColumn(1).setPreferredWidth(95);
		tbNXB.getColumnModel().getColumn(2).setPreferredWidth(180);
		tbNXB.getColumnModel().getColumn(3).setPreferredWidth(100);
		tbNXB.getColumnModel().getColumn(4).setPreferredWidth(120);
		tbNXB.getColumnModel().getColumn(5).setPreferredWidth(70);
		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
		rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);

		// Đặt renderer cho từng cột
		for (int i = 0; i < tbNXB.getColumnCount(); i++) {
			tbNXB.getColumnModel().getColumn(i).setCellRenderer(leftRenderer);
		}
		tbNXB.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);

		renderer.setHorizontalAlignment(JLabel.CENTER);
		tbNXB.setDefaultRenderer(Object.class, renderer);
	}

	public void show_TaiKhoanAdmin() {
		tbTaiKhoanAdmin.setModel(TaiKhoanBLL.show1());
		renderer.setHorizontalAlignment(JLabel.CENTER);
		tbTaiKhoanAdmin.setDefaultRenderer(Object.class, renderer);
	}

	public void show_TaiKhoanUser() {
		tbTaiKhoanUser.setModel(TaiKhoanBLL.show2());
		renderer.setHorizontalAlignment(JLabel.CENTER);
		tbTaiKhoanUser.setDefaultRenderer(Object.class, renderer);
	}

	public void show_HoaDon() {
		tbHoaDon.setModel(HoaDonBLL.show());
		tbHoaDon.getColumnModel().getColumn(0).setPreferredWidth(30);
		tbHoaDon.getColumnModel().getColumn(1).setPreferredWidth(80);
		tbHoaDon.getColumnModel().getColumn(2).setPreferredWidth(80);
		tbHoaDon.getColumnModel().getColumn(3).setPreferredWidth(100);
		tbHoaDon.getColumnModel().getColumn(4).setPreferredWidth(100);
		tbHoaDon.getColumnModel().getColumn(5).setPreferredWidth(130);
		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
		rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
		tbHoaDon.getColumnModel().getColumn(2).setCellRenderer(leftRenderer);
		tbHoaDon.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
		tbHoaDon.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);

		renderer.setHorizontalAlignment(JLabel.CENTER);
		tbHoaDon.setDefaultRenderer(Object.class, renderer);
	}

	public void show_DoanhThu() {
		tbDSDaBan.setModel(HoaDonBLL.show());
		renderer.setHorizontalAlignment(JLabel.CENTER);
		tbDSDaBan.setDefaultRenderer(Object.class, renderer);

		sum.setText(String.valueOf(HoaDonBLL.TongSoLuong()));
		totalRevenue.setText(String.valueOf(HoaDonBLL.TongDoanhThu()));
	}

	// Select row
	public void show_Row_tbSach() {
		int i = tbSach.getSelectedRow();
		@SuppressWarnings("unused")
		Sach s = SachDAL.show().get(i);
		txtMaSach1.setText((String) (tbSach.getValueAt(i, 1)));
		txtTenSach1.setText((String) (tbSach.getValueAt(i, 2)));
		txtNamXB1.setText(String.valueOf(tbSach.getValueAt(i, 3)));
		txtSoTrang1.setText(String.valueOf(tbSach.getValueAt(i, 4)));
		cboMaTG1.setSelectedItem((String) (tbSach.getValueAt(i, 5)));
		cboMaNXB1.setSelectedItem((String) (tbSach.getValueAt(i, 6)));
		txtDonGia1.setText(String.valueOf(tbSach.getValueAt(i, 7)));
		txtSoLuongCon1.setText(String.valueOf(tbSach.getValueAt(i, 8)));
	}

	public void show_Row_tbTacGia() {
		int i = tbTacGia.getSelectedRow();
		TacGia s = TacGiaDAL.show().get(i);

		txtMaTG.setText(s.getMaTG());
		txtTenTG.setText(s.getTenTG());
	}

	public void show_Row_tbNXB() {
		int i = tbNXB.getSelectedRow();
		NhaXuatBan s = NhaXuatBanDAL.show().get(i);

		txtMaNXB.setText(s.getMaNXB());
		txtTenNXB.setText(s.getTenNXB());
		txtDiaChi.setText(s.getDiaChi());
		txtSDT.setText(s.getSDT());
	}

	public void show_Row_tbTaiKhoanAdmin() {
		int i = tbTaiKhoanAdmin.getSelectedRow();
		TaiKhoan s = TaiKhoanDAL.showAdmin().get(i);

		usernameAdmin.setText(s.getMaTaiKhoan());
		passwordAdmin.setText(s.getMatKhau());
	}

	public void show_Row_tbTaiKhoanUser() {
		int i = tbTaiKhoanUser.getSelectedRow();
		TaiKhoan s = TaiKhoanDAL.showUser().get(i);

		usernameKH.setText(s.getMaTaiKhoan());
		passwordKH.setText(s.getMatKhau());
	}

	public void show_Row_tbHoaDon() {
		int i = tbHoaDon.getSelectedRow();
		HoaDon s = HoaDonDAL.show().get(i);

		txtMaHoaDon.setText(s.getMaHD());
		txtTenKH.setText(s.getTenKH());
		txtNgayGiaoDich.setText(s.getNgayGiaoDich());

	}

	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		QuanLyNhaSach = new javax.swing.JLabel();
		QuanLyNhaSach.setBounds(403, 11, 277, 41);
		QuanLyNhaSach.setIconTextGap(40);
		QuanLyNhaSach.setDisplayedMnemonic(KeyEvent.VK_CUT);
		QuanLyNhaSach.setForeground(Color.BLUE);
		QuanLyNhaSach.setBackground(Color.WHITE);
		AdminTabPane = new javax.swing.JTabbedPane();
		AdminTabPane.setBounds(10, 58, 1064, 600);
		AdminTabPane.setForeground(SystemColor.textHighlight);
		jPanelSach = new javax.swing.JPanel();
		jPanelCenter = new javax.swing.JPanel();
		jLabel3 = new javax.swing.JLabel();
		jLabel3.setBounds(10, 49, 166, 32);
		jLabel4 = new javax.swing.JLabel();
		jLabel4.setBounds(10, 90, 166, 32);
		jLabel5 = new javax.swing.JLabel();
		jLabel5.setBounds(10, 127, 166, 32);
		jLabel6 = new javax.swing.JLabel();
		jLabel6.setBounds(600, 127, 158, 32);
		jLabel7 = new javax.swing.JLabel();
		jLabel7.setAlignmentY(Component.TOP_ALIGNMENT);
		jLabel7.setBounds(600, 46, 158, 32);
		jLabel8 = new javax.swing.JLabel();
		jLabel8.setBounds(10, 162, 166, 32);
		jLabel9 = new javax.swing.JLabel();
		jLabel9.setBounds(600, 87, 158, 32);
		txtMaSach1 = new javax.swing.JTextField();
		txtMaSach1.setBounds(190, 49, 367, 32);
		txtTenSach1 = new javax.swing.JTextField();
		txtTenSach1.setBounds(190, 90, 367, 32);
		txtNamXB1 = new javax.swing.JTextField();
		txtNamXB1.setBounds(190, 127, 367, 32);
		txtSoTrang1 = new javax.swing.JTextField();
		txtSoTrang1.setBounds(190, 162, 367, 32);
		txtDonGia1 = new javax.swing.JTextField();
		txtDonGia1.setBounds(758, 127, 252, 32);
		cboMaTG1 = new javax.swing.JComboBox<>();
		cboMaTG1.setBounds(758, 49, 252, 26);
		cboMaNXB1 = new javax.swing.JComboBox<>();
		cboMaNXB1.setBounds(758, 90, 252, 26);
		btnThem = new javax.swing.JButton();
		btnThem.setRolloverIcon(new ImageIcon(AdminUI.class.getResource("/Image/add1.png")));
		btnThem.setIcon(new ImageIcon(AdminUI.class.getResource("/Image/add.png")));
		btnThem.setBounds(82, 199, 121, 29);
		btnSua = new javax.swing.JButton();
		btnSua.setRolloverIcon(new ImageIcon(AdminUI.class.getResource("/Image/maintenance1.png")));
		btnSua.setIcon(new ImageIcon(AdminUI.class.getResource("/Image/maintenance.png")));
		btnSua.setBounds(452, 199, 121, 29);
		btnXoa = new javax.swing.JButton();
		btnXoa.setRolloverIcon(new ImageIcon(AdminUI.class.getResource("/Image/delete.png")));
		btnXoa.setIcon(new ImageIcon(AdminUI.class.getResource("/Image/trash.png")));
		btnXoa.setBounds(855, 199, 121, 29);
		jScrollPane1 = new javax.swing.JScrollPane();
		jScrollPane1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		jScrollPane1.setBounds(0, 239, 1053, 320);
		tbSach = new javax.swing.JTable();
		tbSach.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		tbSach.setAutoCreateRowSorter(true);
		tbSach.setAlignmentY(Component.TOP_ALIGNMENT);
		tbSach.setAlignmentX(Component.LEFT_ALIGNMENT);
		tbSach.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		tbSach.setRowHeight(25);
		tbSach.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		jLabel30 = new javax.swing.JLabel();
		jLabel30.setBounds(600, 162, 158, 32);
		txtSoLuongCon1 = new javax.swing.JTextField();
		txtSoLuongCon1.setBounds(758, 162, 252, 32);
		jPanelTacGia = new javax.swing.JPanel();
		jPanel9 = new javax.swing.JPanel();
		jScrollPane2 = new javax.swing.JScrollPane();
		tbTacGia = new javax.swing.JTable();
		tbTacGia.setRowHeight(25);
		tbTacGia.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		tbTacGia.setAutoCreateRowSorter(true);
		jPanel10 = new javax.swing.JPanel();
		jLabel10 = new javax.swing.JLabel();
		jLabel10.setForeground(Color.BLUE);
		jLabel11 = new javax.swing.JLabel();
		jLabel11.setForeground(Color.BLUE);
		txtMaTG = new javax.swing.JTextField();
		txtTenTG = new javax.swing.JTextField();
		btnSua2 = new javax.swing.JButton();
		btnAddAuthor = new javax.swing.JButton();
		btnXoa2 = new javax.swing.JButton();
		btnReset2 = new javax.swing.JButton();
		jPanelNXB = new javax.swing.JPanel();
		jPanelNBX = new javax.swing.JPanel();
		jPanelNBX.setBounds(10, 11, 613, 552);
		jScrollPaneNXB = new javax.swing.JScrollPane();
		jScrollPaneNXB.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tbNXB = new javax.swing.JTable();
		tbNXB.setAlignmentY(Component.TOP_ALIGNMENT);
		tbNXB.setAlignmentX(Component.LEFT_ALIGNMENT);
		tbNXB.setRowHeight(25);
		tbNXB.setAutoCreateRowSorter(true);
		jPanel12 = new javax.swing.JPanel();
		jPanel12.setBounds(641, 11, 419, 542);
		jLabelMaNXB = new javax.swing.JLabel();
		jLabelMaNXB.setForeground(Color.BLUE);
		jLabelTenNXB = new javax.swing.JLabel();
		jLabelTenNXB.setForeground(Color.BLUE);
		txtMaNXB = new javax.swing.JTextField();
		txtTenNXB = new javax.swing.JTextField();
		btnSua3 = new javax.swing.JButton();
		btnThem3 = new javax.swing.JButton();
		btnXoa3 = new javax.swing.JButton();
		jLabelAddress = new javax.swing.JLabel();
		jLabelAddress.setForeground(Color.BLUE);
		jLabelSDT = new javax.swing.JLabel();
		jLabelSDT.setForeground(Color.BLUE);
		txtSDT = new javax.swing.JTextField();
		txtDiaChi = new javax.swing.JTextField();
		btnReset3 = new javax.swing.JButton();
		jPanelTaiKhoan = new javax.swing.JPanel();
		jTabbedPane1 = new javax.swing.JTabbedPane();
		jTabbedPane1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		jPanel14 = new javax.swing.JPanel();
		jScrollPane7 = new javax.swing.JScrollPane();
		tbTaiKhoanUser = new javax.swing.JTable();
		tbTaiKhoanUser.setRowHeight(25);
		tbTaiKhoanUser.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		jPanel16 = new javax.swing.JPanel();
		jLabel22 = new javax.swing.JLabel();
		jLabel23 = new javax.swing.JLabel();
		usernameKH = new javax.swing.JTextField();
		jLabel24 = new javax.swing.JLabel();
		reset = new javax.swing.JButton();
		reset.setRolloverIcon(new ImageIcon(AdminUI.class.getResource("/Image/cancel24v2.png")));
		reset.setIcon(new ImageIcon(AdminUI.class.getResource("/Image/cancel24.png")));
		delTkUser = new javax.swing.JButton();
		delTkUser.setRolloverIcon(new ImageIcon(AdminUI.class.getResource("/Image/delete.png")));
		delTkUser.setIcon(new ImageIcon(AdminUI.class.getResource("/Image/trash.png")));
		btnThemtkUser = new javax.swing.JButton();
		btnThemtkUser.setRolloverIcon(new ImageIcon(AdminUI.class.getResource("/Image/add1.png")));
		btnThemtkUser.setIcon(new ImageIcon(AdminUI.class.getResource("/Image/add.png")));
		cboxShowPass = new javax.swing.JCheckBox();
		cboxShowPass.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		passwordKH = new javax.swing.JPasswordField();
		jPanel15 = new javax.swing.JPanel();
		jScrollPane5 = new javax.swing.JScrollPane();
		jScrollPane5.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		tbTaiKhoanAdmin = new javax.swing.JTable();
		tbTaiKhoanAdmin.setRowHeight(25);
		tbTaiKhoanAdmin.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		jPanel_QLy = new javax.swing.JPanel();
		jLabel19 = new javax.swing.JLabel();
		jLabel20 = new javax.swing.JLabel();
		jScrollPane6 = new javax.swing.JScrollPane();
		jScrollPane6.setEnabled(false);
		usernameAdmin = new javax.swing.JTextPane();
		usernameAdmin.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		jLabel21 = new javax.swing.JLabel();
		btnHuyTK = new javax.swing.JButton();
		btnHuyTK.setRolloverIcon(new ImageIcon(AdminUI.class.getResource("/Image/cancel24v2.png")));
		btnHuyTK.setIcon(new ImageIcon(AdminUI.class.getResource("/Image/cancel24.png")));
		btnSuaTK = new javax.swing.JButton();
		btnSuaTK.setRolloverIcon(new ImageIcon(AdminUI.class.getResource("/Image/save1.png")));
		btnSuaTK.setIcon(new ImageIcon(AdminUI.class.getResource("/Image/save.png")));
		passwordAdmin = new javax.swing.JPasswordField();
		passwordAdmin.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		confirmPass = new javax.swing.JPasswordField();
		confirmPass.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		jLabel33 = new javax.swing.JLabel();
		cboxShowPass1 = new javax.swing.JCheckBox();
		cboxShowPass1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		cboxShowPass2 = new javax.swing.JCheckBox();
		cboxShowPass2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		jPanelDoanhThu = new javax.swing.JPanel();
		jPanel13 = new javax.swing.JPanel();
		jLabel16 = new javax.swing.JLabel();
		jLabel16.setForeground(Color.BLUE);
		jLabel16.setHorizontalAlignment(SwingConstants.CENTER);
		jScrollPaneDoanhThu = new javax.swing.JScrollPane();
		jScrollPaneDoanhThu.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		tbDSDaBan = new javax.swing.JTable();
		tbDSDaBan.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		tbDSDaBan.setRowHeight(25);
		tbDSDaBan.setAutoCreateRowSorter(true);
		jLabel17 = new javax.swing.JLabel();
		jLabel18 = new javax.swing.JLabel();
		sum = new javax.swing.JTextField();
		totalRevenue = new javax.swing.JTextField();
		jPanelHoaDon = new javax.swing.JPanel();
		jPanel17 = new javax.swing.JPanel();
		jLabel25 = new javax.swing.JLabel();
		jLabel26 = new javax.swing.JLabel();
		jLabel27 = new javax.swing.JLabel();
		txtMaHoaDon = new javax.swing.JTextField();
		txtNgayGiaoDich = new javax.swing.JTextField();
		txtTenKH = new javax.swing.JTextField();
		jScrollPaneHoaDon = new javax.swing.JScrollPane();
		jScrollPaneHoaDon.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		tbHoaDon = new javax.swing.JTable();
		tbHoaDon.setRowHeight(25);
		tbHoaDon.setAutoCreateRowSorter(true);
		btnLogOut = new javax.swing.JButton();
		btnLogOut.setBounds(888, 16, 175, 41);
		btnLogOut.setRolloverIcon(new ImageIcon(AdminUI.class.getResource("/Image/shutdown2.png")));
		btnLogOut.setIcon(new ImageIcon(AdminUI.class.getResource("/Image/shutdown.png")));
		btnLogOut.setFont(new Font("Segoe UI", Font.BOLD, 22));

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setBackground(new java.awt.Color(153, 255, 204));
		setMinimumSize(new java.awt.Dimension(1024, 700));
		setPreferredSize(new java.awt.Dimension(1100, 700));

		QuanLyNhaSach.setFont(new Font("iCiel Cadena", Font.BOLD | Font.ITALIC, 29)); // NOI18N
		QuanLyNhaSach.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		QuanLyNhaSach.setText("QUẢN LÝ NHÀ SÁCH");

		AdminTabPane.setBackground(new Color(0, 0, 255));
		AdminTabPane.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
		AdminTabPane.setFont(new Font("Segoe UI", Font.BOLD, 16)); // NOI18N
		AdminTabPane.addChangeListener(new javax.swing.event.ChangeListener() {
			public void stateChanged(javax.swing.event.ChangeEvent evt) {
				AdminTabPaneStateChanged(evt);
			}
		});

		jPanelSach.setOpaque(false);

		jPanelCenter.setBackground(new java.awt.Color(204, 255, 204));
		jPanelCenter.setForeground(new java.awt.Color(0, 0, 204));

		jLabel3.setFont(new Font("Segoe UI", Font.ITALIC, 18)); // NOI18N
		jLabel3.setForeground(new java.awt.Color(0, 0, 162));
		jLabel3.setText("Mã sách");

		jLabel4.setFont(new Font("Segoe UI", Font.ITALIC, 18)); // NOI18N
		jLabel4.setForeground(new java.awt.Color(0, 0, 162));
		jLabel4.setText("Tên sách");

		jLabel5.setFont(new Font("Segoe UI", Font.ITALIC, 18)); // NOI18N
		jLabel5.setForeground(new java.awt.Color(0, 0, 162));
		jLabel5.setText("Năm xuất bản");

		jLabel6.setFont(new Font("Segoe UI", Font.ITALIC, 18)); // NOI18N
		jLabel6.setForeground(new java.awt.Color(0, 0, 162));
		jLabel6.setText("Đơn giá");

		jLabel7.setFont(new Font("Segoe UI", Font.ITALIC, 18)); // NOI18N
		jLabel7.setForeground(new java.awt.Color(0, 0, 162));
		jLabel7.setText("Mã tác giả");

		jLabel8.setFont(new Font("Segoe UI", Font.ITALIC, 18)); // NOI18N
		jLabel8.setForeground(new java.awt.Color(0, 0, 162));
		jLabel8.setText("Số trang");

		jLabel9.setFont(new Font("Segoe UI", Font.ITALIC, 18)); // NOI18N
		jLabel9.setForeground(new java.awt.Color(0, 0, 162));
		jLabel9.setText("Mã nhà xuất bản");

		txtMaSach1.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // NOI18N

		txtTenSach1.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // NOI18N

		txtNamXB1.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // NOI18N

		txtSoTrang1.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // NOI18N

		txtDonGia1.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // NOI18N

		cboMaTG1.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // NOI18N
		cboMaTG1.setModel(
				new DefaultComboBoxModel<String>(new String[] {"Tác Giả 1", "Tác Giả 2", "Tác Giả 3", "Tác Giả 4"}));

		cboMaNXB1.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // NOI18N
		cboMaNXB1.setModel(
				new DefaultComboBoxModel<String>(new String[] {"NXB 1", "NXB 2", "NXB 3", "NXB 4"}));

		btnThem.setFont(new Font("Segoe UI", Font.BOLD, 18)); // NOI18N
		btnThem.setText("Thêm");
		btnThem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnThemActionPerformed(evt);
			}
		});

		btnSua.setFont(new Font("Segoe UI", Font.BOLD, 18)); // NOI18N
		btnSua.setText("Sửa");
		btnSua.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnSuaActionPerformed(evt);
			}
		});

		btnXoa.setFont(new Font("Segoe UI", Font.BOLD, 18)); // NOI18N
		btnXoa.setText("Xóa");
		btnXoa.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnXoaActionPerformed(evt);
			}
		});

		tbSach.setBorder(
				javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("")));
		tbSach.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null }, },
				new String[] { "STT", "Mã sách", "Tên sách", "Năm xuất bản", "Số trang", "Mã tác giả", "Mã NXB",
						"đơn giá", "Số lượng còn" }));

//		renderer.setHorizontalAlignment(SwingConstants.LEFT);
		tbSach.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tbSachMouseClicked(evt);
			}
		});
		jScrollPane1.setViewportView(tbSach);

		jLabel30.setFont(new Font("Segoe UI", Font.ITALIC, 18)); // NOI18N
		jLabel30.setForeground(new java.awt.Color(0, 0, 162));
		jLabel30.setText("Số lượng còn");

		txtSoLuongCon1.setFont(new Font("Segoe UI", Font.PLAIN, 18));

		javax.swing.GroupLayout gl_jPanelSach = new javax.swing.GroupLayout(jPanelSach);
		gl_jPanelSach.setHorizontalGroup(
			gl_jPanelSach.createParallelGroup(Alignment.LEADING)
				.addComponent(jPanelCenter, GroupLayout.DEFAULT_SIZE, 1069, Short.MAX_VALUE)
		);
		gl_jPanelSach.setVerticalGroup(
			gl_jPanelSach.createParallelGroup(Alignment.LEADING)
				.addComponent(jPanelCenter, GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
		);
		jPanelSach.setLayout(gl_jPanelSach);
		jPanelCenter.setLayout(null);
		jPanelCenter.add(btnThem);
		jPanelCenter.add(btnSua);
		jPanelCenter.add(btnXoa);
		jPanelCenter.add(cboMaTG1);
		jPanelCenter.add(cboMaNXB1);
		jPanelCenter.add(jLabel8);
		jPanelCenter.add(txtSoTrang1);
		jPanelCenter.add(jLabel5);
		jPanelCenter.add(txtNamXB1);
		jPanelCenter.add(jLabel3);
		jPanelCenter.add(txtMaSach1);
		jPanelCenter.add(jLabel4);
		jPanelCenter.add(txtTenSach1);
		jPanelCenter.add(jLabel7);
		jPanelCenter.add(jLabel9);
		jPanelCenter.add(jLabel6);
		jPanelCenter.add(jLabel30);
		jPanelCenter.add(txtDonGia1);
		jPanelCenter.add(txtSoLuongCon1);
		jPanelCenter.add(jScrollPane1);

		JPanel JpanelLookFor = new JPanel();
		JpanelLookFor.setBounds(162, 0, 734, 43);
		jPanelCenter.add(JpanelLookFor);
		JpanelLookFor.setLayout(null);
		JpanelLookFor.setBackground(new java.awt.Color(204, 255, 204));
		JpanelLookFor.setForeground(new java.awt.Color(0, 0, 204));
		JLabel LookForName = new JLabel();
		LookForName.setText("Tìm kiếm theo tên:");
		LookForName.setForeground(new Color(0, 0, 162));
		LookForName.setFont(new Font("Segoe UI", Font.ITALIC, 18));
		LookForName.setBounds(10, 5, 155, 32);
		JpanelLookFor.add(LookForName);

		textFieldLookFor = new JTextField();
		textFieldLookFor.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		textFieldLookFor.setBounds(164, 6, 276, 32);
		JpanelLookFor.add(textFieldLookFor);

		JButton btnSearch = new JButton();
		btnSearch.setRolloverIcon(new ImageIcon(AdminUI.class.getResource("/Image/magnifying-glass.png")));
		btnSearch.setIcon(new ImageIcon(AdminUI.class.getResource("/Image/loupe.png")));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnSearchActionPerformed(evt);
			}
		});
		btnSearch.setText("Tìm kiếm");
		btnSearch.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnSearch.setBounds(448, 5, 137, 32);
		JpanelLookFor.add(btnSearch);

		JButton btnReset1 = new JButton();
		btnReset1.setRolloverIcon(new ImageIcon(AdminUI.class.getResource("/Image/reload.png")));
		btnReset1.setIcon(
				new ImageIcon(AdminUI.class.getResource("/Image/circle-of-two-clockwise-arrows-rotation.png")));
		btnReset1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnReset1ActionPerformed(evt);
			}
		});
		btnReset1.setText("Tải lại");
		btnReset1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnReset1.setBounds(595, 5, 137, 32);
		JpanelLookFor.add(btnReset1);

		AdminTabPane.addTab("Quản lý sách", jPanelSach);

		tbTacGia.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, },
				new String[] { "STT", "M\u00E3 t\u00E1c gi\u1EA3", "T\u00EAn t\u00E1c gi\u1EA3",
						"s\u1ED1 \u0111\u1EA7u s\u00E1ch" }));
		tbTacGia.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tbTacGiaMouseClicked(evt);
			}
		});
		jScrollPane2.setViewportView(tbTacGia);

		javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
		jPanel9.setLayout(jPanel9Layout);
		jPanel9Layout.setHorizontalGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel9Layout.createSequentialGroup().addComponent(jScrollPane2,
						javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 14, Short.MAX_VALUE)));
		jPanel9Layout.setVerticalGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel9Layout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 505,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(53, 53, 53)));
		jPanel9.setBackground(new java.awt.Color(204, 255, 204));
		jPanel9.setForeground(new java.awt.Color(0, 0, 204));
		jLabel10.setFont(new Font("Segoe UI", Font.ITALIC, 18)); // NOI18N
		jLabel10.setText("Mã tác giả: ");

		jLabel11.setFont(new Font("Segoe UI", Font.ITALIC, 18)); // NOI18N
		jLabel11.setText("Tên tác giả: ");

		txtMaTG.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

		txtTenTG.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
//        txtTenTG.setFocusable(false);

		btnSua2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		btnSua2.setText("Sửa");
		btnSua2.setBorder(
				javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.darkGray, java.awt.Color.lightGray));
		btnSua2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnSua2ActionPerformed(evt);
			}
		});

		btnAddAuthor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		btnAddAuthor.setText("Thêm");
		btnAddAuthor.setBorder(
				javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.darkGray, java.awt.Color.lightGray));
		btnAddAuthor.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnThem2ActionPerformed(evt);
			}
		});

		btnXoa2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		btnXoa2.setText("Xóa");
		btnXoa2.setActionCommand("");
		btnXoa2.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.red, java.awt.Color.darkGray));
		btnXoa2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnXoa2ActionPerformed(evt);
			}
		});

		btnReset2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		btnReset2.setText("Reset");
		btnReset2.setBorder(
				javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.darkGray, java.awt.Color.lightGray));
		btnReset2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnReset2ActionPerformed(evt);
			}
		});

		JButton btnSearchAuthor = new JButton();
		btnSearchAuthor.setRolloverIcon(new ImageIcon(AdminUI.class.getResource("/Image/magnifying-glass.png")));
		btnSearchAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnSearchAuthorActionPerformed(evt);
			}
		});
		btnSearchAuthor.setIcon(new ImageIcon(AdminUI.class.getResource("/Image/loupe.png")));
		btnSearchAuthor.setText("Tìm kiếm");
		btnSearchAuthor.setFont(new Font("Segoe UI", Font.PLAIN, 18));

		JButton btnResetAuthor = new JButton();
		btnResetAuthor.setRolloverIcon(new ImageIcon(AdminUI.class.getResource("/Image/reload.png")));
		btnResetAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnResetAuthorActionPerformed(evt);
			}
		});
		btnResetAuthor.setIcon(
				new ImageIcon(AdminUI.class.getResource("/Image/circle-of-two-clockwise-arrows-rotation.png")));
		btnResetAuthor.setText("Tải lại");
		btnResetAuthor.setFont(new Font("Segoe UI", Font.PLAIN, 18));

		javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
		jPanel10Layout.setHorizontalGroup(jPanel10Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel10Layout
				.createSequentialGroup()
				.addGroup(jPanel10Layout.createParallelGroup(Alignment.LEADING)
						.addGroup(jPanel10Layout.createSequentialGroup().addGap(47).addGroup(jPanel10Layout
								.createParallelGroup(Alignment.TRAILING)
								.addGroup(jPanel10Layout.createSequentialGroup()
										.addGroup(jPanel10Layout.createParallelGroup(Alignment.LEADING, false)
												.addComponent(jLabel11, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
												.addComponent(jLabel10, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(jPanel10Layout.createParallelGroup(Alignment.TRAILING)
												.addComponent(txtMaTG, GroupLayout.PREFERRED_SIZE, 262,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(txtTenTG, GroupLayout.PREFERRED_SIZE, 262,
														GroupLayout.PREFERRED_SIZE)))
								.addGroup(jPanel10Layout.createSequentialGroup()
										.addGroup(jPanel10Layout.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(btnSua2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(btnAddAuthor, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
														120, Short.MAX_VALUE))
										.addGap(145)
										.addGroup(jPanel10Layout.createParallelGroup(Alignment.TRAILING)
												.addComponent(btnReset2, GroupLayout.PREFERRED_SIZE, 120,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(btnXoa2, GroupLayout.PREFERRED_SIZE, 120,
														GroupLayout.PREFERRED_SIZE)))))
						.addGroup(jPanel10Layout.createSequentialGroup().addGap(88)
								.addComponent(btnSearchAuthor, GroupLayout.PREFERRED_SIZE, 137,
										GroupLayout.PREFERRED_SIZE)
								.addGap(10).addComponent(btnResetAuthor, GroupLayout.PREFERRED_SIZE, 137,
										GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(29, Short.MAX_VALUE)));
		jPanel10Layout.setVerticalGroup(jPanel10Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel10Layout
				.createSequentialGroup().addGap(16)
				.addGroup(jPanel10Layout.createParallelGroup(Alignment.BASELINE).addComponent(jLabel10).addComponent(
						txtMaTG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(48)
				.addGroup(jPanel10Layout.createParallelGroup(Alignment.BASELINE).addComponent(jLabel11).addComponent(
						txtTenTG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(42)
				.addGroup(jPanel10Layout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSearchAuthor, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnResetAuthor, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
				.addGap(77)
				.addGroup(jPanel10Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAddAuthor, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnReset2, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
				.addGap(52)
				.addGroup(jPanel10Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSua2, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnXoa2, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(152, Short.MAX_VALUE)));
		jPanel10.setLayout(jPanel10Layout);
		jPanel10.setBackground(new java.awt.Color(204, 255, 204));
		jPanel10.setForeground(new java.awt.Color(0, 0, 204));
		javax.swing.GroupLayout gl_jPanelTacGia = new javax.swing.GroupLayout(jPanelTacGia);
		gl_jPanelTacGia.setHorizontalGroup(gl_jPanelTacGia.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanelTacGia.createSequentialGroup().addContainerGap()
						.addComponent(jPanel9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(56).addComponent(jPanel10, GroupLayout.PREFERRED_SIZE, 461, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(12, Short.MAX_VALUE)));
		gl_jPanelTacGia.setVerticalGroup(gl_jPanelTacGia.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanelTacGia.createSequentialGroup().addContainerGap()
						.addGroup(gl_jPanelTacGia.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(jPanel9, Alignment.LEADING, 0, 0, Short.MAX_VALUE).addComponent(jPanel10,
										Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE))
						.addContainerGap(26, Short.MAX_VALUE)));
		jPanelTacGia.setLayout(gl_jPanelTacGia);
		jPanelTacGia.setBackground(new java.awt.Color(204, 255, 204));
		jPanelTacGia.setForeground(new java.awt.Color(0, 0, 204));
		AdminTabPane.addTab("Quản lý tác giả", jPanelTacGia);

		tbNXB.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // NOI18N
		tbNXB.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null }, },
				new String[] { "STT", "M\u00E3 nh\u00E0 xu\u1EA5t b\u1EA3n", "T\u00EAn nh\u00E0 xu\u1EA5t b\u1EA3n",
						"\u0110\u1ECBa ch\u1EC9", "S\u0110T", "S\u1ED1 \u0111\u1EA7u s\u00E1ch" }));
		tbNXB.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tbNXBMouseClicked(evt);
			}
		});
		jScrollPaneNXB.setViewportView(tbNXB);

		javax.swing.GroupLayout gl_jPanelNBX = new javax.swing.GroupLayout(jPanelNBX);
		gl_jPanelNBX.setHorizontalGroup(gl_jPanelNBX.createParallelGroup(Alignment.LEADING).addComponent(jScrollPaneNXB,
				GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE));
		gl_jPanelNBX.setVerticalGroup(gl_jPanelNBX.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanelNBX.createSequentialGroup()
						.addComponent(jScrollPaneNXB, GroupLayout.PREFERRED_SIZE, 541, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanelNBX.setLayout(gl_jPanelNBX);
		jPanelNBX.setBackground(new java.awt.Color(204, 255, 204));
		jPanelNBX.setForeground(new java.awt.Color(0, 0, 204));
		jLabelMaNXB.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		jLabelMaNXB.setText("Mã NXB: ");

		jLabelTenNXB.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		jLabelTenNXB.setText("Tên NXB: ");

		txtMaNXB.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

		txtTenNXB.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

		btnSua3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		btnSua3.setText("Sửa");
		btnSua3.setBorder(
				javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.darkGray, java.awt.Color.lightGray));
		btnSua3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnSua3ActionPerformed(evt);
			}
		});

		btnThem3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		btnThem3.setText("Thêm");
		btnThem3.setBorder(
				javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.darkGray, java.awt.Color.lightGray));
		btnThem3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnThem3ActionPerformed(evt);
			}
		});

		btnXoa3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		btnXoa3.setText("Xóa");
		btnXoa3.setActionCommand("");
		btnXoa3.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.red, java.awt.Color.darkGray));
		btnXoa3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnXoa3ActionPerformed(evt);
			}
		});

		jLabelAddress.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		jLabelAddress.setText("Địa chỉ:");

		jLabelSDT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		jLabelSDT.setText("SĐT:");

		txtSDT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

		txtDiaChi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

		btnReset3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		btnReset3.setText("Reset");
		btnReset3.setBorder(
				javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.darkGray, java.awt.Color.lightGray));
		btnReset3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnReset3ActionPerformed(evt);
			}
		});
		
		JButton btnSearchPublishingCompany = new JButton();
		btnSearchPublishingCompany.setRolloverIcon(new ImageIcon(AdminUI.class.getResource("/Image/magnifying-glass.png")));
		btnSearchPublishingCompany.setToolTipText("tìm theo mã hoặc tên");
		btnSearchPublishingCompany.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnSearchPublishingCompanyActionPerformed(evt);
			}
		});
		btnSearchPublishingCompany.setIcon(new ImageIcon(AdminUI.class.getResource("/Image/loupe.png")));
		btnSearchPublishingCompany.setText("Tìm kiếm");
		btnSearchPublishingCompany.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		JButton btnResetPublishingCompany = new JButton();
		btnResetPublishingCompany.setRolloverIcon(new ImageIcon(AdminUI.class.getResource("/Image/reload.png")));
		btnResetPublishingCompany.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				show_NhaXuatBan();
				delJtextFieldTbNXB();
			}
		});
		btnResetPublishingCompany.setIcon(new ImageIcon(AdminUI.class.getResource("/Image/circle-of-two-clockwise-arrows-rotation.png")));
		btnResetPublishingCompany.setText("Tải lại");
		btnResetPublishingCompany.setFont(new Font("Segoe UI", Font.PLAIN, 18));

		javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
		jPanel12Layout.setHorizontalGroup(
			jPanel12Layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(jPanel12Layout.createSequentialGroup()
					.addGroup(jPanel12Layout.createParallelGroup(Alignment.LEADING)
						.addGroup(jPanel12Layout.createSequentialGroup()
							.addGap(53)
							.addGroup(jPanel12Layout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnSua3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnThem3, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
							.addGap(53)
							.addGroup(jPanel12Layout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnReset3, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnXoa3, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)))
						.addGroup(jPanel12Layout.createSequentialGroup()
							.addGap(30)
							.addGroup(jPanel12Layout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(jLabelTenNXB, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
								.addComponent(jLabelMaNXB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jLabelAddress, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
								.addComponent(jLabelSDT, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(jPanel12Layout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtSDT)
								.addComponent(txtDiaChi)
								.addComponent(txtTenNXB)
								.addComponent(txtMaNXB, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(24, Short.MAX_VALUE))
				.addGroup(jPanel12Layout.createSequentialGroup()
					.addContainerGap(68, Short.MAX_VALUE)
					.addComponent(btnSearchPublishingCompany, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(btnResetPublishingCompany, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
					.addGap(67))
		);
		jPanel12Layout.setVerticalGroup(
			jPanel12Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel12Layout.createSequentialGroup()
					.addGap(16)
					.addGroup(jPanel12Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabelMaNXB)
						.addComponent(txtMaNXB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(jPanel12Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabelTenNXB)
						.addComponent(txtTenNXB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(jPanel12Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabelAddress)
						.addComponent(txtDiaChi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(jPanel12Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabelSDT)
						.addComponent(txtSDT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(jPanel12Layout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSearchPublishingCompany, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnResetPublishingCompany, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(jPanel12Layout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnThem3, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnReset3, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
					.addGap(59)
					.addGroup(jPanel12Layout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSua3, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnXoa3, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(124, Short.MAX_VALUE))
		);
		jPanel12Layout.linkSize(SwingConstants.VERTICAL, new Component[] {btnSua3, btnThem3, btnXoa3, btnReset3});
		jPanel12Layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnSua3, btnThem3, btnXoa3, btnReset3});
		jPanel12.setLayout(jPanel12Layout);
		jPanel12.setBackground(new java.awt.Color(204, 255, 204));
		jPanel12.setForeground(new java.awt.Color(0, 0, 204));
		jPanelNXB.setBackground(new java.awt.Color(204, 255, 204));
		jPanelNXB.setForeground(new java.awt.Color(0, 0, 204));
		AdminTabPane.addTab("Quản lý nhà xuất bản", jPanelNXB);
		jPanelNXB.setLayout(null);
		jPanelNXB.add(jPanelNBX);
		jPanelNXB.add(jPanel12);

		tbTaiKhoanUser.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null }, { null, null }, { null, null }, { null, null } },
				new String[] { "Tên đăng nhập", "Mật khẩu" }));
		tbTaiKhoanUser.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tbTaiKhoan2MouseClicked(evt);
			}
		});
		jScrollPane7.setViewportView(tbTaiKhoanUser);

		jLabel22.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
		jLabel22.setForeground(new java.awt.Color(0, 0, 204));
		jLabel22.setText("Tài khoản khách hàng");

		jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		jLabel23.setText("Tên đăng nhập:");

		usernameKH.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // NOI18N

		jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		jLabel24.setText("Mật khẩu:");

		reset.setBackground(new Color(173, 248, 248));
		reset.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // NOI18N
		reset.setForeground(new java.awt.Color(255, 0, 0));
		reset.setText("Hủy bỏ");
		reset.setBorder(new javax.swing.border.MatteBorder(null));
		reset.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				resetActionPerformed(evt);
			}
		});

		delTkUser.setBackground(new Color(173, 248, 248));
		delTkUser.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // NOI18N
		delTkUser.setForeground(new java.awt.Color(255, 0, 0));
		delTkUser.setText("Xóa");
		delTkUser.setBorder(new javax.swing.border.MatteBorder(null));
		delTkUser.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				delTkUserActionPerformed(evt);
			}
		});

		btnThemtkUser.setBackground(new Color(173, 248, 248));
		btnThemtkUser.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // NOI18N
		btnThemtkUser.setForeground(new java.awt.Color(255, 0, 0));
		btnThemtkUser.setText("Thêm");
		btnThemtkUser.setBorder(new javax.swing.border.MatteBorder(null));
		btnThemtkUser.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnThemtkUserActionPerformed(evt);
			}
		});

		cboxShowPass.setText("Hiện mật khẩu");
		cboxShowPass.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cboxShowPassActionPerformed(evt);
			}
		});

		passwordKH.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		jPanel16.setBackground(new java.awt.Color(204, 255, 204));
		jPanel16.setForeground(new java.awt.Color(0, 0, 204));
		javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
		jPanel14Layout.setHorizontalGroup(jPanel14Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel14Layout.createSequentialGroup().addContainerGap()
						.addComponent(jScrollPane7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(jPanel16, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		jPanel14Layout
				.setVerticalGroup(jPanel14Layout.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
						jPanel14Layout.createSequentialGroup().addContainerGap()
								.addGroup(jPanel14Layout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(jPanel16, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
										.addComponent(jScrollPane7, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 495,
												Short.MAX_VALUE))
								.addContainerGap(26, Short.MAX_VALUE)));
		GroupLayout gl_jPanel16 = new GroupLayout(jPanel16);
		gl_jPanel16.setHorizontalGroup(
			gl_jPanel16.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanel16.createSequentialGroup()
					.addGap(154)
					.addComponent(jLabel22, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_jPanel16.createSequentialGroup()
					.addGap(33)
					.addComponent(jLabel23)
					.addGap(52)
					.addComponent(usernameKH, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_jPanel16.createSequentialGroup()
					.addGap(33)
					.addComponent(jLabel24, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
					.addGap(52)
					.addComponent(passwordKH, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_jPanel16.createSequentialGroup()
					.addGap(208)
					.addComponent(cboxShowPass))
				.addGroup(gl_jPanel16.createSequentialGroup()
					.addGap(33)
					.addComponent(delTkUser, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addGap(110)
					.addComponent(btnThemtkUser, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addGap(71)
					.addComponent(reset, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
		);
		gl_jPanel16.setVerticalGroup(
			gl_jPanel16.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanel16.createSequentialGroup()
					.addGap(66)
					.addComponent(jLabel22, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addGroup(gl_jPanel16.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jPanel16.createSequentialGroup()
							.addGap(3)
							.addComponent(jLabel23))
						.addComponent(usernameKH, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(48)
					.addGroup(gl_jPanel16.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jPanel16.createSequentialGroup()
							.addGap(3)
							.addComponent(jLabel24))
						.addComponent(passwordKH, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(7)
					.addComponent(cboxShowPass)
					.addGap(27)
					.addGroup(gl_jPanel16.createParallelGroup(Alignment.LEADING)
						.addComponent(delTkUser, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnThemtkUser, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(reset, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
		);
		jPanel16.setLayout(gl_jPanel16);
		jPanel14.setLayout(jPanel14Layout);
		jPanel14.setBackground(new java.awt.Color(204, 255, 204));
		jPanel14.setForeground(new java.awt.Color(0, 0, 204));
		jTabbedPane1.addTab("Khách hàng", jPanel14);

		tbTaiKhoanAdmin.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null }, { null, null }, { null, null }, { null, null } },
				new String[] { "Tên đăng nhập", "Mật khẩu" }));
		tbTaiKhoanAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tbTaiKhoan1MouseClicked(evt);
			}
		});
		jScrollPane5.setViewportView(tbTaiKhoanAdmin);

		jLabel19.setFont(new Font("Segoe UI", Font.ITALIC, 18)); // NOI18N
		jLabel19.setForeground(new java.awt.Color(0, 0, 162));
		jLabel19.setText("Tên tài khoản mới: ");

		jLabel20.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // NOI18N
		jLabel20.setForeground(new java.awt.Color(0, 0, 162));
		jLabel20.setText("Mật khẩu mới:");

		jScrollPane6.setViewportView(usernameAdmin);
		usernameAdmin.setSize(getPreferredSize());
		jLabel21.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // NOI18N
		jLabel21.setForeground(new java.awt.Color(0, 0, 162));
		jLabel21.setText("Xác nhận mật khẩu mới:");

		btnHuyTK.setBackground(new Color(173, 248, 248));
		btnHuyTK.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // NOI18N
		btnHuyTK.setForeground(new java.awt.Color(255, 0, 0));
		btnHuyTK.setText("Hủy");
		btnHuyTK.setBorder(new javax.swing.border.MatteBorder(null));
		btnHuyTK.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnHuyTKActionPerformed(evt);
			}
		});

		btnSuaTK.setBackground(new Color(173, 248, 248));
		btnSuaTK.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // NOI18N
		btnSuaTK.setForeground(new java.awt.Color(255, 0, 0));
		btnSuaTK.setText("Lưu");
		btnSuaTK.setBorder(new javax.swing.border.MatteBorder(null));
		btnSuaTK.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnSuaTKActionPerformed(evt);
			}
		});

		jLabel33.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 24)); // NOI18N
		jLabel33.setForeground(Color.BLUE);
		jLabel33.setText("Thay đổi thông tin tài khoản");

		cboxShowPass1.setText("Hiện mật khẩu");
		cboxShowPass1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cboxShowPass1ActionPerformed(evt);
			}
		});

		cboxShowPass2.setText("Hiện xác nhận mật khẩu");
		cboxShowPass2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cboxShowPass2ActionPerformed(evt);
			}
		});
		jPanel_QLy.setBackground(new java.awt.Color(204, 255, 204));
		jPanel_QLy.setForeground(new java.awt.Color(0, 0, 204));
		javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
		jPanel15Layout.setHorizontalGroup(
			jPanel15Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel15Layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jScrollPane5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(jPanel_QLy, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		jPanel15Layout.setVerticalGroup(
			jPanel15Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel15Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel15Layout.createParallelGroup(Alignment.LEADING)
						.addComponent(jScrollPane5, GroupLayout.PREFERRED_SIZE, 501, GroupLayout.PREFERRED_SIZE)
						.addComponent(jPanel_QLy, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		jPanel15.setLayout(jPanel15Layout);
		GroupLayout gl_jPanel_QLy = new GroupLayout(jPanel_QLy);
		gl_jPanel_QLy.setHorizontalGroup(
			gl_jPanel_QLy.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanel_QLy.createSequentialGroup()
					.addGap(121)
					.addComponent(jLabel33))
				.addGroup(gl_jPanel_QLy.createSequentialGroup()
					.addGap(61)
					.addComponent(jLabel19, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(jScrollPane6, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_jPanel_QLy.createSequentialGroup()
					.addGap(61)
					.addComponent(jLabel20, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(passwordAdmin, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_jPanel_QLy.createSequentialGroup()
					.addGap(265)
					.addComponent(cboxShowPass1))
				.addGroup(gl_jPanel_QLy.createSequentialGroup()
					.addGap(61)
					.addComponent(jLabel21, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(confirmPass, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_jPanel_QLy.createSequentialGroup()
					.addGap(265)
					.addComponent(cboxShowPass2))
				.addGroup(gl_jPanel_QLy.createSequentialGroup()
					.addGap(156)
					.addComponent(btnSuaTK, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					.addGap(77)
					.addComponent(btnHuyTK, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
		);
		gl_jPanel_QLy.setVerticalGroup(
			gl_jPanel_QLy.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanel_QLy.createSequentialGroup()
					.addGap(70)
					.addComponent(jLabel33, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(40)
					.addGroup(gl_jPanel_QLy.createParallelGroup(Alignment.LEADING)
						.addComponent(jLabel19)
						.addComponent(jScrollPane6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_jPanel_QLy.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jPanel_QLy.createSequentialGroup()
							.addGap(3)
							.addComponent(jLabel20))
						.addComponent(passwordAdmin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(7)
					.addComponent(cboxShowPass1)
					.addGap(17)
					.addGroup(gl_jPanel_QLy.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jPanel_QLy.createSequentialGroup()
							.addGap(3)
							.addComponent(jLabel21))
						.addComponent(confirmPass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(7)
					.addComponent(cboxShowPass2)
					.addGap(33)
					.addGroup(gl_jPanel_QLy.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSuaTK, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnHuyTK, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
		);
		jPanel_QLy.setLayout(gl_jPanel_QLy);
		jPanel15.setBackground(new java.awt.Color(204, 255, 204));
		jPanel15.setForeground(new java.awt.Color(0, 0, 204));
		jTabbedPane1.addTab("Quản lý", jPanel15);

		javax.swing.GroupLayout gl_jPanelTaiKhoan = new javax.swing.GroupLayout(jPanelTaiKhoan);
		jPanelTaiKhoan.setLayout(gl_jPanelTaiKhoan);
		gl_jPanelTaiKhoan.setHorizontalGroup(gl_jPanelTaiKhoan
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(gl_jPanelTaiKhoan
						.createSequentialGroup().addContainerGap().addComponent(jTabbedPane1).addContainerGap()));
		gl_jPanelTaiKhoan
				.setVerticalGroup(gl_jPanelTaiKhoan.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(gl_jPanelTaiKhoan.createSequentialGroup().addContainerGap()
								.addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 571,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanelTaiKhoan.setBackground(new java.awt.Color(204, 255, 204));
		jPanelTaiKhoan.setForeground(new java.awt.Color(0, 0, 204));
		AdminTabPane.addTab("Quản lý tài khoản", jPanelTaiKhoan);

		jLabel16.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 24)); // NOI18N
		jLabel16.setText("Danh sách sách đã bán");

		tbDSDaBan.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null } },
				new String[] { "Mã hóa đơn", "Mã sách", "Số lượng", "Đơn giá", "Thành tiền" }));
		jScrollPaneDoanhThu.setViewportView(tbDSDaBan);

		jLabel17.setFont(new Font("Segoe UI", Font.ITALIC, 18)); // NOI18N
		jLabel17.setText("Tổng số sách đã bán:");

		jLabel18.setFont(new Font("Segoe UI", Font.ITALIC, 18)); // NOI18N
		jLabel18.setText("Tổng doanh thu:");

		sum.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // NOI18N
		sum.setFocusable(false);

		totalRevenue.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // NOI18N
		totalRevenue.setFocusable(false);

		javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
		jPanel13Layout
				.setHorizontalGroup(
						jPanel13Layout
								.createParallelGroup(
										Alignment.TRAILING)
								.addGroup(jPanel13Layout.createSequentialGroup().addGap(0, 574, Short.MAX_VALUE)
										.addGroup(jPanel13Layout.createParallelGroup(Alignment.LEADING)
												.addComponent(jLabel17).addComponent(jLabel18))
										.addGap(27)
										.addGroup(jPanel13Layout.createParallelGroup(Alignment.LEADING)
												.addComponent(totalRevenue, GroupLayout.PREFERRED_SIZE, 116,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(
														sum, GroupLayout.PREFERRED_SIZE, 116,
														GroupLayout.PREFERRED_SIZE))
										.addGap(193))
								.addGroup(Alignment.LEADING, jPanel13Layout.createSequentialGroup().addGap(84)
										.addGroup(jPanel13Layout.createParallelGroup(Alignment.LEADING)
												.addGroup(jPanel13Layout.createSequentialGroup().addGap(291)
														.addComponent(jLabel16, GroupLayout.PREFERRED_SIZE, 281,
																GroupLayout.PREFERRED_SIZE))
												.addComponent(jScrollPaneDoanhThu, GroupLayout.PREFERRED_SIZE, 871,
														GroupLayout.PREFERRED_SIZE))
										.addContainerGap(84, Short.MAX_VALUE)));
		jPanel13Layout.setVerticalGroup(jPanel13Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel13Layout
				.createSequentialGroup().addGap(20)
				.addComponent(jLabel16, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(jScrollPaneDoanhThu, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)
				.addGap(38)
				.addGroup(jPanel13Layout.createParallelGroup(Alignment.BASELINE).addComponent(jLabel17).addComponent(
						sum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(jPanel13Layout.createParallelGroup(Alignment.BASELINE).addComponent(jLabel18).addComponent(
						totalRevenue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(57, Short.MAX_VALUE)));
		jPanel13.setLayout(jPanel13Layout);
		jPanel13.setBackground(new java.awt.Color(204, 255, 204));
		jPanel13.setForeground(new java.awt.Color(0, 0, 204));
		javax.swing.GroupLayout gl_jPanelDoanhThu = new javax.swing.GroupLayout(jPanelDoanhThu);
		jPanelDoanhThu.setLayout(gl_jPanelDoanhThu);
		gl_jPanelDoanhThu
				.setHorizontalGroup(gl_jPanelDoanhThu.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								gl_jPanelDoanhThu.createSequentialGroup().addContainerGap()
										.addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addContainerGap()));
		gl_jPanelDoanhThu.setVerticalGroup(gl_jPanelDoanhThu
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(gl_jPanelDoanhThu.createSequentialGroup().addContainerGap().addComponent(jPanel13,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(21, 21, 21)));
		jPanelDoanhThu.setBackground(new java.awt.Color(204, 255, 204));
		jPanelDoanhThu.setForeground(new java.awt.Color(0, 0, 204));
		AdminTabPane.addTab("Xem thông tin doanh thu", jPanelDoanhThu);

		jLabel25.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // NOI18N
		jLabel25.setText("Mã hóa đơn");

		jLabel26.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // NOI18N
		jLabel26.setText("Tên khách hàng");

		jLabel27.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // NOI18N
		jLabel27.setText("Ngày giao dịch");

		txtMaHoaDon.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // NOI18N

		txtNgayGiaoDich.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // NOI18N

		txtTenKH.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // NOI18N

		javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
		jPanel17Layout.setHorizontalGroup(
				jPanel17Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel17Layout.createSequentialGroup()
						.addContainerGap().addGroup(jPanel17Layout
								.createParallelGroup(Alignment.LEADING)
								.addGroup(jPanel17Layout.createSequentialGroup()
										.addGroup(jPanel17Layout.createParallelGroup(Alignment.LEADING)
												.addComponent(jLabel25, GroupLayout.PREFERRED_SIZE, 91,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel26, GroupLayout.PREFERRED_SIZE, 134,
														GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(jPanel17Layout.createParallelGroup(Alignment.LEADING)
												.addComponent(txtTenKH, GroupLayout.PREFERRED_SIZE, 185,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(txtNgayGiaoDich, GroupLayout.PREFERRED_SIZE, 185,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(txtMaHoaDon, GroupLayout.PREFERRED_SIZE, 185,
														GroupLayout.PREFERRED_SIZE)))
								.addComponent(jLabel27, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(706, Short.MAX_VALUE)));
		jPanel17Layout.setVerticalGroup(jPanel17Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel17Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel17Layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jLabel25, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtMaHoaDon, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(jPanel17Layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jLabel26, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTenKH, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(23)
						.addGroup(jPanel17Layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jLabel27, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtNgayGiaoDich, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap(50, Short.MAX_VALUE)));
		jPanel17Layout.linkSize(SwingConstants.HORIZONTAL, new Component[] { jLabel25, jLabel26, jLabel27 });
		jPanel17.setLayout(jPanel17Layout);
		jPanel17.setBackground(new java.awt.Color(204, 255, 204));
		jPanel17.setForeground(new java.awt.Color(0, 0, 204));
		tbHoaDon.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // NOI18N
		tbHoaDon.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"STT", "M\u00E3 h\u00F3a \u0111\u01A1n", "T\u00EAn kh\u00E1ch h\u00E0ng", "Ng\u00E0y giao d\u1ECBch", "S\u1ED1 l\u01B0\u1EE3ng", "Th\u00E0nh ti\u1EC1n"
			}
		));

		tbHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tbHoaDonMouseClicked(evt);
			}
		});
		jScrollPaneHoaDon.setViewportView(tbHoaDon);

		javax.swing.GroupLayout gl_jPanelHoaDon = new javax.swing.GroupLayout(jPanelHoaDon);
		gl_jPanelHoaDon.setHorizontalGroup(
			gl_jPanelHoaDon.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanelHoaDon.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jPanelHoaDon.createParallelGroup(Alignment.LEADING)
						.addComponent(jScrollPaneHoaDon, GroupLayout.PREFERRED_SIZE, 1047, GroupLayout.PREFERRED_SIZE)
						.addComponent(jPanel17, GroupLayout.DEFAULT_SIZE, 1047, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_jPanelHoaDon.setVerticalGroup(
			gl_jPanelHoaDon.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanelHoaDon.createSequentialGroup()
					.addContainerGap()
					.addComponent(jPanel17, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(jScrollPaneHoaDon, GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
					.addContainerGap())
		);
		jPanelHoaDon.setLayout(gl_jPanelHoaDon);
		jPanelHoaDon.setBackground(new java.awt.Color(204, 255, 204));
		jPanelHoaDon.setForeground(new java.awt.Color(0, 0, 204));
		AdminTabPane.addTab("Xem thông tin hóa đơn", jPanelHoaDon);

		btnLogOut.setText("Đăng xuất");
		btnLogOut.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnLogOutActionPerformed(evt);
			}
		});
		getContentPane().setLayout(null);
		getContentPane().add(QuanLyNhaSach);
		getContentPane().add(btnLogOut);
		getContentPane().add(AdminTabPane);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void AdminTabPaneStateChanged(javax.swing.event.ChangeEvent evt) {// GEN-FIRST:event_AdminTabPaneStateChanged
		// TODO add your handling code here:
		int index = AdminTabPane.getSelectedIndex();
		switch (index) {
		case 0:
			show_Sach();
			break;

		case 1:
			show_TacGia();
			break;

		case 2:
			show_NhaXuatBan();
			break;

		case 3:
			show_TaiKhoanAdmin();
			show_TaiKhoanUser();
			break;

		case 4:
			if (HoaDonDAL.show() != null) {
				show_DoanhThu();
			}
			break;

		case 5:
			if (HoaDonDAL.show() != null) {
				show_HoaDon();
			}
			break;

		default:
			break;
		}
	}// GEN-LAST:event_AdminTabPaneStateChanged

	private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnLogOutActionPerformed
		// TODO add your handling code here:
		AutomaticallyClosedMsgBox(2000, "Đang đăng xuất.\nXin hãy đợi...");
		this.dispose();
		DangNhapUI dn = new DangNhapUI("Quản lý Cửa Hàng");
		dn.showWindow();
	}// GEN-LAST:event_btnLogOutActionPerformed

	// Quản lý sách
	private void tbSachMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tbSachMouseClicked
		// TODO add your handling code here:
		show_Row_tbSach();
	}// GEN-LAST:event_tbSachMouseClicked

	private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnThemActionPerformed
		// TODO add your handling code here:

		try {
			Sach newBook = new Sach();
			newBook.setMaSach(txtMaSach1.getText());
			newBook.setTenSach(txtTenSach1.getText());
			newBook.setNamXuatBan(Integer.parseInt(txtNamXB1.getText()));
			newBook.setSoTrang(Integer.parseInt(txtSoTrang1.getText()));
			newBook.setMaTG(cboMaTG1.getSelectedItem().toString());
			newBook.setMaNXB(cboMaNXB1.getSelectedItem().toString());
			newBook.setDonGia(Float.parseFloat(txtDonGia1.getText()));
			newBook.setSoLuongCon(Integer.parseInt(txtSoLuongCon1.getText()));
			if (SachDAL.insert(SachDAL.show(), newBook)) {
				JOptionPane.showMessageDialog(null, "Thêm sách thành công!");
				show_Sach();
			}

			delJtextFieldTbSach();
		} catch (HeadlessException | IOException | NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Có lỗi xảy ra: " + e.getMessage());
		}
	}// GEN-LAST:event_btnThemActionPerformed

	private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSuaActionPerformed
		// TODO add your handling code here:
		try {
			Sach setBook = new Sach();
			setBook.setMaSach(txtMaSach1.getText());
			setBook.setTenSach(txtTenSach1.getText());
			setBook.setNamXuatBan(Integer.parseInt(txtNamXB1.getText()));
			setBook.setSoTrang(Integer.parseInt(txtSoTrang1.getText()));
			setBook.setMaTG(cboMaTG1.getSelectedItem().toString());
			setBook.setMaNXB(cboMaNXB1.getSelectedItem().toString());
			setBook.setDonGia(Float.parseFloat(txtDonGia1.getText()));
			setBook.setSoLuongCon(Integer.parseInt(txtSoLuongCon1.getText()));
			int reply = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn sửa?", "Thông báo",
					JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.YES_OPTION) {
				if (SachDAL.update(SachDAL.show(), setBook)) {
					show_Sach();
					JOptionPane.showMessageDialog(null, "Sửa sách thành công!");
				} else {
					JOptionPane.showMessageDialog(null, "Mã sách không tồn tại!");
				}
				delJtextFieldTbSach();
			}

		} catch (HeadlessException | IOException | NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Có lỗi xảy ra: " + "không được để trống dữ liệu");
		}
	}// GEN-LAST:event_btnSuaActionPerformed

	private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnXoaActionPerformed
		// TODO add your handling code here:
		try {
			if (tbSach.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(rootPane, "Hãy chọn một dòng để xóa");
			} else if (SachDAL.show().size() == 0) {
				JOptionPane.showMessageDialog(rootPane, "Không có thông tin để xóa");
			} else {
				Sach delBook = new Sach();
				delBook.setMaSach(txtMaSach1.getText());
				int reply = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa?", "Thông báo",
						JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					SachDAL.delete(SachDAL.show(), delBook);
					model = (DefaultTableModel) tbSach.getModel();
					model.setRowCount(0);
					show_Sach();
					delJtextFieldTbSach();
				}

			}

		} catch (IOException | NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Có lỗi xảy ra: " + e.getMessage());
		}

	}// GEN-LAST:event_btnXoaActionPerformed

	private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSearchActionPerformed
		// TODO add your handling code here:
		model = (DefaultTableModel) tbSach.getModel();
		model.setRowCount(0);
		int i = 1;
		for (Sach item : SachDAL.show()) {
			if (item.getTenSach().equalsIgnoreCase(textFieldLookFor.getText())) {
				model.addRow(new Object[] { i++, item.getMaSach(), item.getTenSach(), item.getNamXuatBan(),
						item.getSoTrang(), item.getMaTG(), item.getMaNXB(), item.getDonGia(), item.getSoLuongCon() });
			}
		}
		tbSach.getColumnModel().getColumn(0).setResizable(false);
		tbSach.getColumnModel().getColumn(0).setPreferredWidth(28);
		tbSach.getColumnModel().getColumn(1).setResizable(false);
		tbSach.getColumnModel().getColumn(1).setPreferredWidth(50);
		tbSach.getColumnModel().getColumn(2).setResizable(false);
		tbSach.getColumnModel().getColumn(2).setPreferredWidth(250);
		tbSach.getColumnModel().getColumn(3).setResizable(false);
		tbSach.getColumnModel().getColumn(3).setPreferredWidth(80);
		tbSach.getColumnModel().getColumn(4).setResizable(false);
		tbSach.getColumnModel().getColumn(4).setPreferredWidth(65);
		tbSach.getColumnModel().getColumn(5).setResizable(false);
		tbSach.getColumnModel().getColumn(5).setPreferredWidth(60);
		tbSach.getColumnModel().getColumn(6).setPreferredWidth(90);
		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);

		// Đặt renderer cho từng cột
		for (int j = 0; j < tbSach.getColumnCount(); j++) {
			tbSach.getColumnModel().getColumn(j).setCellRenderer(leftRenderer);
		}
		renderer.setHorizontalAlignment(SwingConstants.LEFT);
		renderer.setHorizontalAlignment(JLabel.CENTER);
		tbNXB.setDefaultRenderer(Object.class, renderer);
	}// GEN-LAST:event_btnSearchActionPerformed

	private void btnSearchAuthorActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSearchActionPerformed
		// TODO add your handling code here:
		if (txtMaTG.getText().equals("") && txtTenTG.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Không có dữ liệu để tìm kiếm");
			show_TacGia();
			return;
		}

		model = (DefaultTableModel) tbTacGia.getModel();
		model.setRowCount(0);
		int i = 0;
		for (TacGia item : TacGiaDAL.show()) {
			if (!txtTenTG.getText().equals("") && !txtMaTG.getText().equals("")) {
				if (item.getMaTG().equalsIgnoreCase(txtMaTG.getText())
						&& (item.getTenTG().toLowerCase().contains(txtTenTG.getText().toLowerCase()))) {
					model.addRow(new Object[] {
//						(Object) i,
							++i, item.getMaTG(), item.getTenTG(), item.getSoDauSach() });
				}
			} else if (txtMaTG.getText().equals("") && !txtTenTG.getText().equals("")) {
				if (item.getTenTG().toLowerCase().contains(txtTenTG.getText().toLowerCase())) {
					model.addRow(new Object[] {
//						(Object) i,
							++i, item.getMaTG(), item.getTenTG(), item.getSoDauSach() });
				}
			} else if (!txtMaTG.getText().equals("") && txtTenTG.getText().equals("")) {
				if (item.getMaTG().equalsIgnoreCase(txtMaTG.getText())) {
					model.addRow(new Object[] {
//						(Object) i,
							++i, item.getMaTG(), item.getTenTG(), item.getSoDauSach() });
				}
			}
		}
		tbTacGia.getColumnModel().getColumn(0).setPreferredWidth(30);
		tbTacGia.getColumnModel().getColumn(1).setPreferredWidth(70);
		tbTacGia.getColumnModel().getColumn(2).setPreferredWidth(200);
		tbTacGia.getColumnModel().getColumn(3).setPreferredWidth(70);

		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
		rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
		// Đặt renderer cho từng cột
		for (int j = 2; j < tbTacGia.getColumnCount(); j++) {
			tbTacGia.getColumnModel().getColumn(j).setCellRenderer(leftRenderer);
		}
		tbTacGia.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);

		renderer.setHorizontalAlignment(JLabel.CENTER);
		tbTacGia.setDefaultRenderer(Object.class, renderer);

	}// GEN-LAST:event_btnSearchActionPerformed
		// cài đặt bảng
	private void btnSearchPublishingCompanyActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
			// TODO add your handling code here:
			if (txtMaNXB.getText().equals("") && txtTenNXB.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Không có dữ liệu để tìm kiếm");
				show_NhaXuatBan();
				return;
			}
			ArrayList<NhaXuatBan> listNXB = NhaXuatBanDAL.show();
			model = (DefaultTableModel) tbNXB.getModel();
			model.setRowCount(0);
			int i = 0;
			for (NhaXuatBan item : NhaXuatBanDAL.show()) {
				if (!txtTenNXB.getText().equals("") && !txtMaNXB.getText().equals("")) {
					if (item.getMaNXB().equalsIgnoreCase(txtMaNXB.getText())
							&& (item.getTenNXB().toLowerCase().contains(txtTenNXB.getText().toLowerCase()))) {
						model.addRow(new Object[] {
//							(Object) i,
								++i, item.getMaNXB(), item.getTenNXB(), item.getDiaChi(),item.getSDT(),
								listNXB
								.stream()
								.filter(itemp->itemp.getMaNXB().equalsIgnoreCase(item.getMaNXB()))
								.collect(Collectors.toList())
								.size() 
						});
					}
				} else if (txtMaNXB.getText().equals("") && !txtTenNXB.getText().equals("")) {
					if (item.getTenNXB().toLowerCase().contains(txtTenNXB.getText().toLowerCase())) {
						model.addRow(new Object[] {
//							(Object) i,
								++i, item.getMaNXB(), item.getTenNXB(), item.getDiaChi(),item.getSDT(),
								listNXB
								.stream()
								.filter(itemp->itemp.getMaNXB().equalsIgnoreCase(item.getMaNXB()))
								.collect(Collectors.toList())
								.size() 
						});
					}
				} else if (!txtMaNXB.getText().equals("") && txtTenNXB.getText().equals("")) {
					if (item.getMaNXB().equalsIgnoreCase(txtMaNXB.getText())) {
						model.addRow(new Object[] {
//							(Object) i,
								++i, item.getMaNXB(), item.getTenNXB(), item.getDiaChi(),item.getSDT(),
								listNXB
								.stream()
								.filter(itemp->itemp.getMaNXB().equalsIgnoreCase(item.getMaNXB()))
								.collect(Collectors.toList())
								.size()});
					}
				}
			}
			tbNXB.getColumnModel().getColumn(0).setPreferredWidth(30);
			tbNXB.getColumnModel().getColumn(1).setPreferredWidth(95);
			tbNXB.getColumnModel().getColumn(2).setPreferredWidth(180);
			tbNXB.getColumnModel().getColumn(3).setPreferredWidth(100);
			tbNXB.getColumnModel().getColumn(4).setPreferredWidth(120);
			tbNXB.getColumnModel().getColumn(5).setPreferredWidth(70);
			DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
			DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
			leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
			rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);

			// Đặt renderer cho từng cột
			for (int j = 0; i < tbNXB.getColumnCount(); j++) {
				tbNXB.getColumnModel().getColumn(j).setCellRenderer(leftRenderer);
			}
			tbNXB.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);

			renderer.setHorizontalAlignment(JLabel.CENTER);
			tbNXB.setDefaultRenderer(Object.class, renderer);

		}// GEN-LAST:event_btnSearchActionPerformed
			// cài đặt bảng
	private void btnResetAuthorActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnReset1ActionPerformed
		// TODO add your handling code here:
		show_TacGia();
		delJtextFieldTbTacGia();
	}// GEN-LAST:event_btnReset1ActionPerformed
	private void btnReset1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnReset1ActionPerformed
		// TODO add your handling code here:
		delJtextFieldTbSach();
		show_Sach();
	}// GEN-LAST:event_btnReset1ActionPerformed

	private void tbTacGiaMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tbTacGiaMouseClicked
		// TODO add your handling code here:
		show_Row_tbTacGia();
	}// GEN-LAST:event_tbTacGiaMouseClicked

	private void tbNXBMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tbNXBMouseClicked
		// TODO add your handling code here:
		show_Row_tbNXB();
	}// GEN-LAST:event_tbNXBMouseClicked

	private void cboxShowPassActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cboxShowPassActionPerformed
		// TODO add your handling code here:
		if (cboxShowPass.isSelected()) {
			passwordKH.setEchoChar((char) 0);
		} else {
			passwordKH.setEchoChar('*');
		}
	}// GEN-LAST:event_cboxShowPassActionPerformed

	private void tbTaiKhoan2MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tbTaiKhoan2MouseClicked
		// TODO add your handling code here:
		show_Row_tbTaiKhoanUser();
	}// GEN-LAST:event_tbTaiKhoan2MouseClicked

	private void tbTaiKhoan1MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tbTaiKhoan1MouseClicked
		// TODO add your handling code here:
		show_Row_tbTaiKhoanAdmin();
	}// GEN-LAST:event_tbTaiKhoan1MouseClicked

	private void cboxShowPass1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cboxShowPass1ActionPerformed
		// TODO add your handling code here:
		if (cboxShowPass1.isSelected()) {
			passwordAdmin.setEchoChar((char) 0);
		} else {
			passwordAdmin.setEchoChar('*');
		}
	}// GEN-LAST:event_cboxShowPass1ActionPerformed

	private void cboxShowPass2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cboxShowPass2ActionPerformed
		// TODO add your handling code here:
		if (cboxShowPass2.isSelected()) {
			confirmPass.setEchoChar((char) 0);
		} else {
			confirmPass.setEchoChar('*');
		}
	}// GEN-LAST:event_cboxShowPass2ActionPerformed

	// Quản lý TacGia
	private void btnThem2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnThem2ActionPerformed
		// TODO add your handling code here:
		try {
			TacGia newTG = new TacGia();
			newTG.setMaTG(txtMaTG.getText());
			newTG.setTenTG(txtTenTG.getText());

			if (TacGiaDAL.insert(TacGiaDAL.show(), newTG)) {
				JOptionPane.showMessageDialog(null, "Thêm tác giả thành công!");
				show_TacGia();
			}
			delJtextFieldTbTacGia();

		} catch (HeadlessException | IOException e) {
			JOptionPane.showMessageDialog(null, "Có lỗi xảy ra: " + e.getMessage());
		}
	}// GEN-LAST:event_btnThem2ActionPerformed

	private void btnSua2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSua2ActionPerformed
		// TODO add your handling code here:
		try {
			TacGia setTacGia = new TacGia();
			setTacGia.setMaTG(txtMaTG.getText());
			setTacGia.setTenTG(txtTenTG.getText());
			int reply = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn sửa?", "Thông báo",
					JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.YES_OPTION) {
				if (TacGiaDAL.update(TacGiaDAL.show(), setTacGia)) {
					JOptionPane.showMessageDialog(AdminTabPane, "Sửa tác giả thành công!");
					show_TacGia();
				} else {
					JOptionPane.showMessageDialog(null, "Mã tác giả không tồn tại!");
				}
				delJtextFieldTbTacGia();
			}

		} catch (HeadlessException | IOException e) {
			JOptionPane.showMessageDialog(null, "Có lỗi xảy ra: " + e.getMessage());
		}
	}// GEN-LAST:event_btnSua2ActionPerformed

	private void btnXoa2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnXoa2ActionPerformed
		// TODO add your handling code here:
		try {
			if (tbTacGia.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(rootPane, "Hãy chọn một dòng để xóa");
			} else if (TacGiaDAL.show().size() == 0) {
				JOptionPane.showMessageDialog(rootPane, "Không có thông tin để xóa");
			} else {
				TacGia delTG = new TacGia();
				delTG.setMaTG(txtMaTG.getText());
				int reply = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa?", "Thông báo",
						JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					TacGiaDAL.delete(TacGiaDAL.show(), delTG);
					model = (DefaultTableModel) tbTacGia.getModel();
					model.setRowCount(0);
					show_TacGia();
					delJtextFieldTbTacGia();
				}

			}

		} catch (IOException | NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Có lỗi xảy ra: " + e.getMessage());
		}
	}// GEN-LAST:event_btnXoa2ActionPerformed

	private void btnReset2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnReset2ActionPerformed
		// TODO add your handling code here:
		delJtextFieldTbTacGia();
	}// GEN-LAST:event_btnReset2ActionPerformed

	// Quản lý NhaXuatBan
	private void btnThem3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnThem3ActionPerformed
		// TODO add your handling code here:
		try {
			NhaXuatBan newNXB = new NhaXuatBan();
			newNXB.setMaNXB(txtMaNXB.getText());
			newNXB.setTenNXB(txtTenNXB.getText());
			newNXB.setDiaChi(txtDiaChi.getText());
			newNXB.setSDT(txtSDT.getText());
			if (NhaXuatBanDAL.insert(NhaXuatBanDAL.show(), newNXB)) {
				JOptionPane.showMessageDialog(null, "Thêm nhà xuất bản thành công!");
				show_NhaXuatBan();
			}
			delJtextFieldTbNXB();

		} catch (HeadlessException | IOException e) {
			JOptionPane.showMessageDialog(null, "Có lỗi xảy ra: " + e.getMessage());
		}
	}// GEN-LAST:event_btnThem3ActionPerformed

	private void btnSua3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSua3ActionPerformed
		// TODO add your handling code here:
		try {
			NhaXuatBan setNXB = new NhaXuatBan();
			setNXB.setMaNXB(txtMaNXB.getText());
			setNXB.setTenNXB(txtTenNXB.getText());
			setNXB.setDiaChi(txtDiaChi.getText());
			setNXB.setSDT(txtSDT.getText());
			int reply = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn sửa?", "Thông báo",
					JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.YES_OPTION) {
				if (NhaXuatBanDAL.update(NhaXuatBanDAL.show(), setNXB)) {
					JOptionPane.showMessageDialog(AdminTabPane, "Sửa nhà xuất bản thành công!");
					show_NhaXuatBan();
				} else {
					JOptionPane.showMessageDialog(null, "Mã nhà xuất bản không tồn tại!");
				}
				delJtextFieldTbNXB();
			}

		} catch (HeadlessException | IOException e) {
			JOptionPane.showMessageDialog(null, "Có lỗi xảy ra: " + e.getMessage());
		}
	}// GEN-LAST:event_btnSua3ActionPerformed

	private void btnXoa3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnXoa3ActionPerformed
		// TODO add your handling code here:
		try {
			if (tbNXB.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(rootPane, "Hãy chọn một dòng để xóa");
			} else if (NhaXuatBanDAL.show().size() == 0) {
				JOptionPane.showMessageDialog(rootPane, "Không có thông tin để xóa");
			} else {
				NhaXuatBan delNXB = new NhaXuatBan();
				delNXB.setMaNXB(txtMaNXB.getText());
				int reply = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa?", "Thông báo",
						JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					NhaXuatBanDAL.delete(NhaXuatBanDAL.show(), delNXB);
					model = (DefaultTableModel) tbTacGia.getModel();
					model.setRowCount(0);
					show_NhaXuatBan();
					delJtextFieldTbNXB();
				}

			}

		} catch (IOException | NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Có lỗi xảy ra: " + e.getMessage());
		}
	}// GEN-LAST:event_btnXoa3ActionPerformed

	private void btnReset3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnReset3ActionPerformed
		// TODO add your handling code here:
		delJtextFieldTbNXB();
	}// GEN-LAST:event_btnReset3ActionPerformed

	// Quản lý Tài khoản Admin
	private void btnSuaTKActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSuaTKActionPerformed
		// TODO add your handling code here:
		try {
			TaiKhoan setTK = new TaiKhoan();
			setTK.setMaTaiKhoan(usernameAdmin.getText());
			char[] pf = passwordAdmin.getPassword();
			String value = new String(pf);
			char[] confirmpf = confirmPass.getPassword();
			String confirmValue = new String(confirmpf);
			setTK.setMatKhau(value);
			setTK.setVaiTro("Admin");
			if (value.equals(confirmValue)) {
				int reply = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn sửa?", "Thông báo",
						JOptionPane.YES_NO_OPTION);

				if (reply == JOptionPane.YES_OPTION) {
					if (TaiKhoanDAL.update(TaiKhoanDAL.show(), setTK)) {
						JOptionPane.showMessageDialog(AdminTabPane, "Sửa tài khoản thành công!");
						show_TaiKhoanAdmin();
					} else {
						JOptionPane.showMessageDialog(null, "Mã tài khoản không tồn tại!");
					}
				}

				delJtextFieldTbTKAmin();
			} else {
				JOptionPane.showMessageDialog(null, "Mật khẩu xác nhận không chính xác!");
			}

		} catch (HeadlessException | IOException e) {
			JOptionPane.showMessageDialog(null, "Có lỗi xảy ra: " + e.getMessage());
		}
	}// GEN-LAST:event_btnSuaTKActionPerformed

	private void btnHuyTKActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnHuyTKActionPerformed
		// TODO add your handling code here:
		delJtextFieldTbTKAmin();
	}// GEN-LAST:event_btnHuyTKActionPerformed

	private void btnThemtkUserActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnThemtkUserActionPerformed
		// TODO add your handling code here:
		try {
			TaiKhoan newTK = new TaiKhoan();
			newTK.setMaTaiKhoan(usernameKH.getText());
			char[] pf = passwordKH.getPassword();
			String value = new String(pf);
			newTK.setMatKhau(value);
			newTK.setVaiTro("User");
			if (TaiKhoanDAL.insert(TaiKhoanDAL.show(), newTK)) {
				JOptionPane.showMessageDialog(null, "Thêm tai khoản user thành công!");
				show_TaiKhoanUser();
			}
			delJtextFieldTbTKUser();

		} catch (HeadlessException | IOException e) {
			JOptionPane.showMessageDialog(null, "Có lỗi xảy ra: " + e.getMessage());
		}
	}// GEN-LAST:event_btnThemtkUserActionPerformed

	private void delTkUserActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_delTkUserActionPerformed
		// TODO add your handling code here:
		try {
			if (tbTaiKhoanUser.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(rootPane, "Hãy chọn một dòng để xóa");
			} else if (TaiKhoanDAL.showUser().size() == 0) {
				JOptionPane.showMessageDialog(rootPane, "Không có thông tin để xóa");
			} else {
				TaiKhoan delTK = new TaiKhoan();
				delTK.setMaTaiKhoan(usernameKH.getText());
				int reply = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa?", "Thông báo",
						JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					TaiKhoanDAL.delete(TaiKhoanDAL.show(), delTK);
					model = (DefaultTableModel) tbTaiKhoanUser.getModel();
					model.setRowCount(0);
					show_TaiKhoanUser();
					delJtextFieldTbTKUser();
				}

			}

		} catch (IOException | NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Có lỗi xảy ra: " + e.getMessage());
		}
	}// GEN-LAST:event_delTkUserActionPerformed

	private void resetActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_resetActionPerformed
		// TODO add your handling code here:
		delJtextFieldTbTKUser();
	}// GEN-LAST:event_resetActionPerformed

	private void tbHoaDonMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tbHoaDonMouseClicked
		// TODO add your handling code here:
		show_Row_tbHoaDon();
	}// GEN-LAST:event_tbHoaDonMouseClicked

	public void AutomaticallyClosedMsgBox(long time, String text) {
		JOptionPane jop = new JOptionPane();
		jop.setMessageType(JOptionPane.INFORMATION_MESSAGE);
		jop.setMessage(text);
		JDialog dialog = jop.createDialog(null, "Thông báo");

		// Set timer
		new Thread(() -> {
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
			dialog.dispose();
		}).start();

		dialog.setVisible(true);
	}

	// reset textField
	public void delJtextFieldTbSach() {
		txtMaSach1.setText("");
		txtTenSach1.setText("");
		txtNamXB1.setText("");
		txtSoTrang1.setText("");
		cboMaTG1.setSelectedIndex(0);
		cboMaNXB1.setSelectedIndex(0);
		txtDonGia1.setText("");
		txtSoLuongCon1.setText("");
	}

	public void delJtextFieldTbTacGia() {
		txtMaTG.setText("");
		txtTenTG.setText("");
	}

	public void delJtextFieldTbNXB() {
		txtMaNXB.setText("");
		txtTenNXB.setText("");
		txtDiaChi.setText("");
		txtSDT.setText("");

	}

	public void delJtextFieldTbTKAmin() {
		usernameAdmin.setText("");
		passwordAdmin.setText("");
		confirmPass.setText("");
	}

	public void delJtextFieldTbTKUser() {
		usernameKH.setText("");
		passwordKH.setText("");
	}

	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(AdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(AdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(AdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(AdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {

				new AdminUI().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JTabbedPane AdminTabPane;
	private javax.swing.JButton btnHuyTK;
	private javax.swing.JButton btnLogOut;
	private javax.swing.JButton btnReset2;
	private javax.swing.JButton btnReset3;
	private javax.swing.JButton btnSua;
	private javax.swing.JButton btnSua2;
	private javax.swing.JButton btnSua3;
	private javax.swing.JButton btnSuaTK;
	private javax.swing.JButton btnThem;
	private javax.swing.JButton btnAddAuthor;
	private javax.swing.JButton btnThem3;
	private javax.swing.JPanel jPanel_QLy;
	private javax.swing.JButton btnThemtkUser;
	private javax.swing.JButton btnXoa;
	private javax.swing.JButton btnXoa2;
	private javax.swing.JButton btnXoa3;
	private javax.swing.JComboBox<String> cboMaNXB1;
	private javax.swing.JComboBox<String> cboMaTG1;
	private javax.swing.JCheckBox cboxShowPass;
	private javax.swing.JCheckBox cboxShowPass1;
	private javax.swing.JCheckBox cboxShowPass2;
	private javax.swing.JPasswordField confirmPass;
	private javax.swing.JButton delTkUser;
	private javax.swing.JLabel QuanLyNhaSach;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabelMaNXB;
	private javax.swing.JLabel jLabelTenNXB;
	private javax.swing.JLabel jLabelAddress;
	private javax.swing.JLabel jLabelSDT;
	private javax.swing.JLabel jLabel16;
	private javax.swing.JLabel jLabel17;
	private javax.swing.JLabel jLabel18;
	private javax.swing.JLabel jLabel19;
	private javax.swing.JLabel jLabel20;
	private javax.swing.JLabel jLabel21;
	private javax.swing.JLabel jLabel22;
	private javax.swing.JLabel jLabel23;
	private javax.swing.JLabel jLabel24;
	private javax.swing.JLabel jLabel25;
	private javax.swing.JLabel jLabel26;
	private javax.swing.JLabel jLabel27;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel30;
	private javax.swing.JLabel jLabel33;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanelTaiKhoan;
	private javax.swing.JPanel jPanel10;
	private javax.swing.JPanel jPanelNBX;
	private javax.swing.JPanel jPanel12;
	private javax.swing.JPanel jPanel13;
	private javax.swing.JPanel jPanel14;
	private javax.swing.JPanel jPanel15;
	private javax.swing.JPanel jPanel16;
	private javax.swing.JPanel jPanel17;
	private javax.swing.JPanel jPanelSach;
	private javax.swing.JPanel jPanelTacGia;
	private javax.swing.JPanel jPanelNXB;
	private javax.swing.JPanel jPanelHoaDon;
	private javax.swing.JPanel jPanelDoanhThu;
	private javax.swing.JPanel jPanelCenter;
	private javax.swing.JPanel jPanel9;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPaneNXB;
	private javax.swing.JScrollPane jScrollPaneDoanhThu;
	private javax.swing.JScrollPane jScrollPane5;
	private javax.swing.JScrollPane jScrollPane6;
	private javax.swing.JScrollPane jScrollPane7;
	private javax.swing.JScrollPane jScrollPaneHoaDon;
	private javax.swing.JTabbedPane jTabbedPane1;
	private javax.swing.JPasswordField passwordAdmin;
	private javax.swing.JPasswordField passwordKH;
	private javax.swing.JButton reset;
	private javax.swing.JTextField sum;
	private javax.swing.JTable tbDSDaBan;
	private javax.swing.JTable tbHoaDon;
	private javax.swing.JTable tbNXB;
	private javax.swing.JTable tbSach;
	private javax.swing.JTable tbTacGia;
	private javax.swing.JTable tbTaiKhoanAdmin;
	private javax.swing.JTable tbTaiKhoanUser;
	private javax.swing.JTextField totalRevenue;
	private javax.swing.JTextField txtDiaChi;
	private javax.swing.JTextField txtDonGia1;
	private javax.swing.JTextField txtMaHoaDon;
	private javax.swing.JTextField txtMaNXB;
	private javax.swing.JTextField txtMaSach1;
	private javax.swing.JTextField txtMaTG;
	private javax.swing.JTextField txtNamXB1;
	private javax.swing.JTextField txtNgayGiaoDich;
	private javax.swing.JTextField txtSDT;
	private javax.swing.JTextField txtSoLuongCon1;
	private javax.swing.JTextField txtSoTrang1;
	private javax.swing.JTextField txtTenKH;
	private javax.swing.JTextField txtTenNXB;
	private javax.swing.JTextField txtTenSach1;
	private javax.swing.JTextField txtTenTG;
	private javax.swing.JTextPane usernameAdmin;
	private javax.swing.JTextField usernameKH;
	private JTextField textFieldLookFor;
}
