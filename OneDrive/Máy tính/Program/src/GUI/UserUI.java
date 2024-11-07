/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import BLL.SachBLL;
import BLL.SachTrongGioHangBLL;
import DAL.SachDAL;
import DAL.SachTrongGioHangDAL;
import Entities.Sach;
import Entities.SachTrongGioHang;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class UserUI extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	DefaultTableModel model;
	DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();

	public UserUI() {
		this.setSize(1086, 739);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(UserUI.class.getResource("/Image/Hopstarter-Soft-Scraps-User-Clients.256.png")));
		setTitle("Khách Hàng");
		initComponents();

		show_Sach();
		show_GioHang();
		this.setLocationRelativeTo(null);

	}

	public void show_Sach() {
		model = (DefaultTableModel) tbSachUser.getModel();
		tbSachUser.setModel(SachBLL.showForUser());
		// căn lề trái và phải
		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
		rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
		tbSachUser.getColumnModel().getColumn(0).setPreferredWidth(30);
		tbSachUser.getColumnModel().getColumn(1).setPreferredWidth(50);
		tbSachUser.getColumnModel().getColumn(2).setPreferredWidth(230);
		tbSachUser.getColumnModel().getColumn(3).setPreferredWidth(70);
		tbSachUser.getColumnModel().getColumn(4).setPreferredWidth(55);
		tbSachUser.getColumnModel().getColumn(5).setPreferredWidth(150);
		tbSachUser.getColumnModel().getColumn(6).setPreferredWidth(150);
		tbSachUser.getColumnModel().getColumn(1).setCellRenderer(leftRenderer);
		tbSachUser.getColumnModel().getColumn(2).setCellRenderer(leftRenderer);
		tbSachUser.getColumnModel().getColumn(5).setCellRenderer(leftRenderer);
		tbSachUser.getColumnModel().getColumn(6).setCellRenderer(leftRenderer);
		tbSachUser.getColumnModel().getColumn(7).setCellRenderer(rightRenderer);
		tbSachUser.getColumnModel().getColumn(8).setCellRenderer(rightRenderer);
		renderer.setHorizontalAlignment(JLabel.CENTER);
		tbSachUser.setDefaultRenderer(Object.class, renderer);
		txtSoLuong.getVisibleRect();
	}

	public void show_GioHang() {
		if (SachTrongGioHangDAL.show(DangNhapUI.username) != null) {
			model = (DefaultTableModel) tbGioHang.getModel();

			tbGioHang.setModel(SachTrongGioHangBLL.show(DangNhapUI.username));
			tbGioHang.getColumnModel().getColumn(0).setPreferredWidth(30);
			tbGioHang.getColumnModel().getColumn(1).setPreferredWidth(260);
			tbGioHang.getColumnModel().getColumn(2).setPreferredWidth(81);
			tbGioHang.getColumnModel().getColumn(4).setPreferredWidth(169);
			DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
			DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
			leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
			rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
			tbGioHang.getColumnModel().getColumn(1).setCellRenderer(leftRenderer);
			tbGioHang.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
			tbGioHang.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
			tbGioHang.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);

			// Đặt renderer cho từng cột
		}

		renderer.setHorizontalAlignment(JLabel.CENTER);

	}

	public void show_Row() {
		int i = tbSachUser.getSelectedRow();
		txtTenSachUser.setText((String) (tbSachUser.getValueAt(i, 2)));
	}

	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jMenu1 = new javax.swing.JMenu();
		jMenu2 = new javax.swing.JMenu();
		jMenu3 = new javax.swing.JMenu();
		jMenu4 = new javax.swing.JMenu();
		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		btnLogOut = new javax.swing.JButton();
		btnLogOut.setRolloverIcon(new ImageIcon(UserUI.class.getResource("/Image/shutdown2.png")));
		btnLogOut.setIcon(new ImageIcon(UserUI.class.getResource("/Image/shutdown.png")));
		userInfo = new javax.swing.JButton();
		userInfo.setBackground(new Color(218, 252, 252));
		userInfo.setRolloverIcon(new ImageIcon(UserUI.class.getResource("/Image/profile1.png")));
		tabbedPane = new javax.swing.JTabbedPane();
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int index = tabbedPane.getSelectedIndex();
				switch (index) {
				case 0:
					show_Sach();
					break;
				case 1:
					show_GioHang();;
					break;

				default:
					break;
				}
			}
		});
		jPanel2 = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		txtSearchSach = new javax.swing.JTextField();
		btnSearch = new javax.swing.JButton();
		btnSearch.setRolloverIcon(new ImageIcon(UserUI.class.getResource("/Image/magnifying-glass.png")));
		jScrollPane1 = new javax.swing.JScrollPane();
		tbSachUser = new javax.swing.JTable();
		tbSachUser.setRowHeight(25);
		tbSachUser.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		tbSachUser.setAutoCreateRowSorter(true);
		btnThemVaoGio = new javax.swing.JButton();
		btnThemVaoGio.setRolloverIcon(new ImageIcon(UserUI.class.getResource("/Image/cart.png")));
		btnThemVaoGio.setIcon(new ImageIcon(UserUI.class.getResource("/Image/add-cart.png")));
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		txtTenSachUser = new javax.swing.JTextField();
		txtSoLuong = new javax.swing.JTextField();
		btnResetTB = new javax.swing.JButton();
		btnResetTB.setRolloverIcon(new ImageIcon(UserUI.class.getResource("/Image/reload.png")));
		jPanel3 = new javax.swing.JPanel();
		jLabel4 = new javax.swing.JLabel();
		jLabel4.setHorizontalTextPosition(SwingConstants.LEFT);
		jLabel4.setBounds(465, 0, 112, 50);
		jScrollPane2 = new javax.swing.JScrollPane();
		jScrollPane2.setBounds(10, 56, 1023, 397);
		jScrollPane2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		tbGioHang = new javax.swing.JTable();
		tbGioHang.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		tbGioHang.setRowHeight(25);
		btnThoat = new javax.swing.JButton();
		btnThoat.setRolloverIcon(new ImageIcon(UserUI.class.getResource("/Image/exit2.png")));
		btnThoat.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnThoat.setIcon(new ImageIcon(UserUI.class.getResource("/Image/log-out.png")));
		btnThoat.setBounds(890, 471, 143, 33);
		btnThanhToan = new javax.swing.JButton();
		btnThanhToan.setRolloverIcon(new ImageIcon(UserUI.class.getResource("/Image/money2.png")));
		btnThanhToan.setIcon(new ImageIcon(UserUI.class.getResource("/Image/money.png")));
		btnThanhToan.setBounds(805, 11, 167, 33);
		btnXoaGioHang = new javax.swing.JButton();
		btnXoaGioHang.setRolloverIcon(new ImageIcon(UserUI.class.getResource("/Image/delete.png")));
		btnXoaGioHang.setIcon(new ImageIcon(UserUI.class.getResource("/Image/trash.png")));
		btnXoaGioHang.setBounds(651, 11, 112, 33);

		jMenu1.setText("jMenu1");

		jMenu2.setText("jMenu2");

		jMenu3.setText("jMenu3");

		jMenu4.setText("jMenu4");

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setBackground(new java.awt.Color(255, 216, 253));

		jPanel1.setBackground(new java.awt.Color(153, 255, 255));
		jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 106, 122), 2));
		jPanel1.setPreferredSize(new java.awt.Dimension(1300, 81));

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
		jLabel1.setForeground(new java.awt.Color(255, 38, 66));
		jLabel1.setText("CỬA HÀNG SÁCH FAHASA");

		btnLogOut.setText("Log out");
		btnLogOut.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnLogOutActionPerformed(evt);
			}
		});

		userInfo.setIcon(new ImageIcon(UserUI.class.getResource("/Image/profile.png"))); // NOI18N
		userInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		userInfo.setMargin(new java.awt.Insets(0, 0, 0, 0));
		userInfo.setMaximumSize(new java.awt.Dimension(40, 40));
		userInfo.setMinimumSize(new java.awt.Dimension(40, 40));
		userInfo.setPreferredSize(new java.awt.Dimension(40, 40));
		userInfo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				userInfoActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
						.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap(274, Short.MAX_VALUE)
								.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 476, GroupLayout.PREFERRED_SIZE)
								.addGap(131)
								.addComponent(userInfo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(17).addComponent(btnLogOut).addContainerGap()));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(42)
						.addComponent(userInfo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(8, Short.MAX_VALUE))
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap(28, Short.MAX_VALUE)
						.addComponent(jLabel1).addGap(21))
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap(27, Short.MAX_VALUE)
						.addComponent(btnLogOut).addGap(22)));
		jPanel1.setLayout(jPanel1Layout);

		tabbedPane.setBackground(new java.awt.Color(255, 255, 102));
		tabbedPane.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

		jPanel2.setBackground(new java.awt.Color(204, 255, 204));

		jLabel2.setBackground(new java.awt.Color(255, 216, 253));
		jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
		jLabel2.setForeground(new java.awt.Color(83, 58, 255));
		jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel2.setText("Thông tin sách");

		jLabel3.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 18)); // NOI18N
		jLabel3.setText("Tìm kiếm:");

		txtSearchSach.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

		btnSearch.setIcon(new ImageIcon(UserUI.class.getResource("/Image/loupe.png"))); // NOI18N
		btnSearch.setActionCommand("Search");
		btnSearch.setMaximumSize(new java.awt.Dimension(30, 30));
		btnSearch.setMinimumSize(new java.awt.Dimension(30, 30));
		btnSearch.setPreferredSize(new java.awt.Dimension(30, 30));
		btnSearch.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnSearchActionPerformed(evt);
			}
		});

		tbSachUser.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null }, },
				new String[] { "STT", "M\u00E3 s\u00E1ch", "T\u00EAn s\u00E1ch", "N\u0103m xu\u1EA5t b\u1EA3n",
						"S\u1ED1 trang", "T\u00E1c gi\u1EA3", "Nh\u00E0 xu\u1EA5t b\u1EA3n", "\u0110\u01A1n gi\u00E1",
						"S\u1ED1 l\u01B0\u1EE3ng c\u00F2n" }));
		tbSachUser.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tbSachUserMouseClicked(evt);
			}
		});
		jScrollPane1.setViewportView(tbSachUser);

		btnThemVaoGio.setBackground(new java.awt.Color(255, 255, 153));
		btnThemVaoGio.setFont(new Font("Segoe UI", Font.BOLD, 18)); // NOI18N
		btnThemVaoGio.setForeground(new java.awt.Color(0, 0, 255));
		btnThemVaoGio.setText("Thêm vào giỏ");
		btnThemVaoGio.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnThemVaoGioActionPerformed(evt);
			}
		});

		jLabel5.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // NOI18N
		jLabel5.setText("Tên sách:");

		jLabel6.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // NOI18N
		jLabel6.setText("Số lượng:");

		txtTenSachUser.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // NOI18N
		txtTenSachUser.setFocusable(false);
		txtTenSachUser.setHorizontalAlignment(SwingConstants.LEFT);

		txtSoLuong.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // NOI18N

		btnResetTB
				.setIcon(new ImageIcon(UserUI.class.getResource("/Image/circle-of-two-clockwise-arrows-rotation.png"))); // NOI18N
		btnResetTB.setMaximumSize(new java.awt.Dimension(30, 30));
		btnResetTB.setMinimumSize(new java.awt.Dimension(30, 30));
		btnResetTB.setPreferredSize(new java.awt.Dimension(30, 30));
		btnResetTB.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnResetTBActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addContainerGap()
						.addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, 1013, Short.MAX_VALUE).addContainerGap())
				.addGroup(Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
						.addContainerGap(286, Short.MAX_VALUE).addComponent(jLabel3).addGap(18)
						.addComponent(txtSearchSach, GroupLayout.PREFERRED_SIZE, 392, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnResetTB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(165))
				.addGroup(Alignment.TRAILING,
						jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(jScrollPane1,
								GroupLayout.DEFAULT_SIZE, 1033, Short.MAX_VALUE))
				.addGroup(jPanel2Layout.createSequentialGroup().addGap(41)
						.addGroup(jPanel2Layout
								.createParallelGroup(Alignment.LEADING).addComponent(jLabel6).addComponent(jLabel5))
						.addGap(10)
						.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
								.addGroup(jPanel2Layout.createSequentialGroup()
										.addComponent(txtSoLuong, GroupLayout.PREFERRED_SIZE, 196,
												GroupLayout.PREFERRED_SIZE)
										.addGap(368).addComponent(btnThemVaoGio, GroupLayout.PREFERRED_SIZE, 192,
												GroupLayout.PREFERRED_SIZE))
								.addComponent(txtTenSachUser, GroupLayout.PREFERRED_SIZE, 390,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap(159, Short.MAX_VALUE)));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel2Layout
				.createSequentialGroup()
				.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
						.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE).addComponent(jLabel3)
										.addComponent(txtSearchSach, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addComponent(btnResetTB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(jPanel2Layout
						.createParallelGroup(Alignment.BASELINE).addComponent(jLabel5).addComponent(txtTenSachUser,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(1)
				.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnThemVaoGio, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel6).addComponent(txtSoLuong, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(42, Short.MAX_VALUE)));
		jPanel2.setLayout(jPanel2Layout);

		tabbedPane.addTab("Sách", jPanel2);

		jPanel3.setBackground(new java.awt.Color(204, 255, 204));

		jLabel4.setBackground(new java.awt.Color(255, 216, 253));
		jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
		jLabel4.setForeground(new java.awt.Color(83, 58, 255));
		jLabel4.setHorizontalAlignment(SwingConstants.LEFT);
		jLabel4.setText("Giỏ hàng");

		tbGioHang.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null }, },
				new String[] { "STT", "S\u00E1ch", "\u0110\u01A1n gi\u00E1", "S\u1ED1 l\u01B0\u1EE3ng",
						"Th\u00E0nh ti\u1EC1n" }));
		jScrollPane2.setViewportView(tbGioHang);

		btnThoat.setBackground(new java.awt.Color(255, 255, 153));
		btnThoat.setFont(new Font("Segoe UI", Font.BOLD, 18)); // NOI18N
		btnThoat.setForeground(new java.awt.Color(0, 51, 255));
		btnThoat.setText("Thoát");

		btnThanhToan.setBackground(new java.awt.Color(255, 255, 153));
		btnThanhToan.setFont(new Font("Segoe UI", Font.BOLD, 18)); // NOI18N
		btnThanhToan.setForeground(new java.awt.Color(0, 51, 255));
		btnThanhToan.setText("Thanh toán");
		btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnThanhToanActionPerformed(evt);
			}
		});

		btnXoaGioHang.setBackground(new java.awt.Color(255, 255, 153));
		btnXoaGioHang.setFont(new Font("Segoe UI", Font.BOLD, 18)); // NOI18N
		btnXoaGioHang.setForeground(new java.awt.Color(0, 51, 255));
		btnXoaGioHang.setText("Xóa");
		btnXoaGioHang.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnXoaGioHangActionPerformed(evt);
			}
		});

		tabbedPane.addTab("Giỏ hàng", jPanel3);
		jPanel3.setLayout(null);
		jPanel3.add(jLabel4);
		jPanel3.add(jScrollPane2);
		jPanel3.add(btnThanhToan);
		jPanel3.add(btnXoaGioHang);
		jPanel3.add(btnThoat);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1012, Short.MAX_VALUE)
								.addComponent(tabbedPane))
						.addContainerGap()));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(36, 36, 36).addComponent(tabbedPane)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnLogOutActionPerformed
		// TODO add your handling code here:
		AutomaticallyClosedMsgBox(2000, "Đang đăng xuất.\nXin hãy đợi...");
		this.dispose();
		DangNhapUI dn = new DangNhapUI("Quản lý sách");
		dn.showWindow();
	}// GEN-LAST:event_btnLogOutActionPerformed

	private void userInfoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_userInfoActionPerformed
		// TODO add your handling code here:
		this.dispose();
		ThongTinUserUI dn = new ThongTinUserUI();
		dn.showWindow();
	}// GEN-LAST:event_userInfoActionPerformed

	private void btnResetTBActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnResetTBActionPerformed
		// TODO add your handling code here:
		show_Sach();
		txtSearchSach.setText("");
		txtTenSachUser.setText("");
		txtSoLuong.setText("");

	}// GEN-LAST:event_btnResetTBActionPerformed

	private void btnThemVaoGioActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnThemVaoGioActionPerformed
		// TODO add your handling code here:
		try {
			Sach s = SachDAL.GetSach(txtTenSachUser.getText());
//            this.dispose();
			if (Integer.parseInt(txtSoLuong.getText()) <= s.getSoLuongCon()) {
//				this.dispose();
				ThemSachVaoGioHangUI dn = new ThemSachVaoGioHangUI(DangNhapUI.username, s,
						Integer.parseInt(txtSoLuong.getText()));
				dn.showWindow();
			} else {
				JOptionPane.showMessageDialog(null, "Số lượng vượt quá!");
//				this.dispose();
//				UserUI dn = new UserUI();
//				dn.showWindow();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Có lỗi: " + e);
		}
	}// GEN-LAST:event_btnThemVaoGioActionPerformed

	private void tbSachUserMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tbSachUserMouseClicked
		// TODO add your handling code here:
		show_Row();
	}// GEN-LAST:event_tbSachUserMouseClicked

	private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSearchActionPerformed
		// TODO add your handling code here:
		if (txtSearchSach.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Không có dữ liệu để tìm kiếm");
			show_Sach();
			return;
		}
		model = (DefaultTableModel) tbSachUser.getModel();
		model.setRowCount(0);
		int i = 1;
		for (Sach item : SachDAL.show()) {
			if (item.getTenSach().toLowerCase().contains(txtSearchSach.getText().toLowerCase())) {
				model.addRow(new Object[] { i++, item.getMaSach(), item.getTenSach(), item.getNamXuatBan(),
						item.getSoTrang(), item.getMaTG(), item.getMaNXB(), item.getDonGia(), item.getSoLuongCon() });
			}
		}
	}// GEN-LAST:event_btnSearchActionPerformed

	private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnThanhToanActionPerformed
		// TODO add your handling code here:
		this.dispose();
		ThongTinThanhToanUI dn = new ThongTinThanhToanUI(DangNhapUI.username,
				SachTrongGioHangDAL.show(DangNhapUI.username));
		dn.showWindow();
	}// GEN-LAST:event_btnThanhToanActionPerformed

	private void btnXoaGioHangActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnXoaGioHangActionPerformed
		// TODO add your handling code here:
		try {
			int i = tbGioHang.getSelectedRow();
			if (i == -1) {
				JOptionPane.showMessageDialog(rootPane, "Hãy chọn một dòng để xóa");
			} else if (SachTrongGioHangDAL.show(DangNhapUI.username).isEmpty()) {
				JOptionPane.showMessageDialog(rootPane, "Không có sách trong giỏ hàng để xóa");
			} else {
				SachTrongGioHang delBook = SachTrongGioHangDAL.show(DangNhapUI.username).get(i);
				int reply = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa?", "Thông báo",
						JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					SachTrongGioHangDAL.delete(SachTrongGioHangDAL.show(DangNhapUI.username), delBook);
					model = (DefaultTableModel) tbGioHang.getModel();
					model.setRowCount(0);
					show_GioHang();
				}

			}

		} catch (IOException | NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Có lỗi xảy ra: " + e.getMessage());
		}
	}// GEN-LAST:event_btnXoaGioHangActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(UserUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(UserUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(UserUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(UserUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {

				new UserUI().setVisible(true);
			}
		});
	}

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

	public void showWindow() {
		this.setSize(1086, 739);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnLogOut;
	private javax.swing.JButton btnResetTB;
	private javax.swing.JButton btnSearch;
	private javax.swing.JButton btnThanhToan;
	private javax.swing.JButton btnThemVaoGio;
	private javax.swing.JButton btnThoat;
	private javax.swing.JButton btnXoaGioHang;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenu jMenu3;
	private javax.swing.JMenu jMenu4;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTabbedPane tabbedPane;
	private javax.swing.JTable tbGioHang;
	private javax.swing.JTable tbSachUser;
	private javax.swing.JTextField txtSearchSach;
	private javax.swing.JTextField txtSoLuong;
	private javax.swing.JTextField txtTenSachUser;
	private javax.swing.JButton userInfo;
	// End of variables declaration//GEN-END:variables
}
