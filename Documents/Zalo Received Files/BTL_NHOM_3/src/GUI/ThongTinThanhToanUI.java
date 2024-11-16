package GUI;

import java.awt.Component;
import java.awt.Font;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import DAL.HoaDonDAL;
import DAL.SachDAL;
import DAL.SachTrongGioHangDAL;
import Entities.HoaDon;
import Entities.Sach;
import Entities.SachTrongGioHang;
import Tools.Ghi_List_Vao_File;

public class ThongTinThanhToanUI extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private String maHD, tenKH, date = String.valueOf(java.time.LocalDate.now());
	ArrayList<SachTrongGioHang> list;
	ArrayList<Sach> Sachfile = SachDAL.show();
	int stt;

	public ThongTinThanhToanUI() {
		this.setSize(600, 630);
		initComponents();
	}

	public ThongTinThanhToanUI(String TenKH, ArrayList<SachTrongGioHang> a) {
		this.setSize(600, 630);
		initComponents();

		list = a;
		tenKH = TenKH;
		stt = (list != null) ? list.size() + 1 : 1;
		maHD = "HD" + String.valueOf(stt);
		txtMaHoaDon.setText(maHD);
		txtTenKH.setText(TenKH);
		txtNgayGD.setText(date);
		txtSoLuong.setText(String.valueOf(SachTrongGioHangDAL.showSoLuong(TenKH)));
		txtThanhTien.setText(String.valueOf(SachTrongGioHangDAL.showthanhTien(TenKH)));
	}

	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {
		this.setSize(600, 630);
		jPanel1 = new javax.swing.JPanel();
		jLabel8 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		jLabel10 = new javax.swing.JLabel();
		jLabel11 = new javax.swing.JLabel();
		jLabel12 = new javax.swing.JLabel();
		txtMaHoaDon = new javax.swing.JTextField();
		txtTenKH = new javax.swing.JTextField();
		txtNgayGD = new javax.swing.JTextField();
		txtSoLuong = new javax.swing.JTextField();
		jLabel13 = new javax.swing.JLabel();
		txtThanhTien = new javax.swing.JTextField();
		btnConfirm = new javax.swing.JButton();
		btnConfirm.setRolloverIcon(new ImageIcon(ThongTinThanhToanUI.class.getResource("/Image/money2.png")));
		btnConfirm.setIcon(new ImageIcon(ThongTinThanhToanUI.class.getResource("/Image/money.png")));
		btnConfirm.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		btnHuy = new javax.swing.JButton();
		btnHuy.setRolloverIcon(new ImageIcon(ThongTinThanhToanUI.class.getResource("/Image/cancel1.png")));
		btnHuy.setIcon(new ImageIcon(ThongTinThanhToanUI.class.getResource("/Image/cancel.png")));
		btnHuy.setFont(new Font("Segoe UI", Font.PLAIN, 24));

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jPanel1.setBackground(new java.awt.Color(204, 255, 204));

		jLabel8.setBackground(new java.awt.Color(204, 255, 204));
		jLabel8.setFont(new Font("Segoe UI", Font.BOLD, 30)); // NOI18N
		jLabel8.setForeground(new java.awt.Color(83, 58, 255));
		jLabel8.setText("Thông tin giao dịch");

		jLabel9.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // NOI18N
		jLabel9.setText("Mã hóa đơn: ");

		jLabel10.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // NOI18N
		jLabel10.setText("Tên khách hàng:");

		jLabel11.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // NOI18N
		jLabel11.setText("Số lượng mua:");

		jLabel12.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // NOI18N
		jLabel12.setText("Ngày giao dịch");

		txtMaHoaDon.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // NOI18N
		txtMaHoaDon.setFocusable(false);

		txtTenKH.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // NOI18N
		txtTenKH.setFocusable(false);

		txtNgayGD.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // NOI18N
		txtNgayGD.setFocusable(false);

		txtSoLuong.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // NOI18N
		txtSoLuong.setFocusable(false);

		jLabel13.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // NOI18N
		jLabel13.setText("Thành tiền:");

		txtThanhTien.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // NOI18N
		txtThanhTien.setFocusable(false);

		btnConfirm.setText("Xác nhận");
		btnConfirm.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					btnConfirmActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		btnHuy.setText("Hủy");
		btnHuy.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnHuyActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel1Layout
				.createSequentialGroup()
				.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel1Layout
						.createSequentialGroup().addGap(59)
						.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
								.addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel11, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel12, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel13, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtTenKH, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtMaHoaDon, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtNgayGD, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtSoLuong, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtThanhTien, GroupLayout.PREFERRED_SIZE, 274,
										GroupLayout.PREFERRED_SIZE)))
						.addGroup(jPanel1Layout.createSequentialGroup().addGap(141).addComponent(jLabel8))
						.addGroup(jPanel1Layout.createSequentialGroup().addGap(127).addComponent(btnConfirm).addGap(61)
								.addComponent(btnHuy)))
				.addContainerGap(84, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel1Layout
				.createSequentialGroup().addGap(43).addComponent(jLabel8).addGap(28)
				.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE).addComponent(jLabel9).addComponent(
						txtMaHoaDon, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE).addComponent(jLabel10).addComponent(
						txtTenKH, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE).addComponent(jLabel12).addComponent(
						txtNgayGD, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE).addComponent(jLabel11).addComponent(
						txtSoLuong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE).addComponent(jLabel13).addComponent(
						txtThanhTien, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(40).addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE).addComponent(btnConfirm)
						.addComponent(btnHuy))
				.addContainerGap(149, Short.MAX_VALUE)));
		jPanel1Layout.linkSize(SwingConstants.HORIZONTAL,
				new Component[] { jLabel9, jLabel10, jLabel11, jLabel12, jLabel13 });
		jPanel1.setLayout(jPanel1Layout);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jPanel1,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jPanel1,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnHuyActionPerformed
		// TODO add your handling code here:
		this.dispose();
		UserUI dn = new UserUI();
		dn.showWindow();
	}// GEN-LAST:event_btnHuyActionPerformed

	private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) throws IOException {// GEN-FIRST:event_btnConfirmActionPerformed
		// TODO add your handling code here:
		HoaDon a = new HoaDon();
		a.setMaHD(maHD);
		a.setTenKH(tenKH);
		a.setNgayGiaoDich(date);
		a.setSachMua(list);
		a.setSoLuong(SachTrongGioHangDAL.showSoLuong(tenKH));
		a.setThanhTien(SachTrongGioHangDAL.showthanhTien(tenKH));
		int reply = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn thanh toán?", "Thông báo",
				JOptionPane.YES_NO_OPTION);
		if (reply == JOptionPane.YES_OPTION) {

			for (SachTrongGioHang itemTrongGioHang : list) {
				for (Sach item : Sachfile) {
					if (item.getMaSach().equalsIgnoreCase(itemTrongGioHang.getSachDaChon().getMaSach())) {
						item.setSoLuongCon(
								itemTrongGioHang.getSachDaChon().getSoLuongCon() - itemTrongGioHang.getSoLuong());
					}
				}
			}
			try {
				HoaDonDAL.insert(HoaDonDAL.show(), a);
				Ghi_List_Vao_File.ghi_Sach_Vao_File(Sachfile);
			} catch (IOException ex) {
				Logger.getLogger(ThongTinThanhToanUI.class.getName()).log(Level.SEVERE, null, ex);
			}
			JOptionPane.showMessageDialog(null, "Thanh toán thành công!");
			try {
				xoaSachTrongGio(tenKH);
			} catch (IOException ex) {
				Logger.getLogger(ThongTinThanhToanUI.class.getName()).log(Level.SEVERE, null, ex);
			}
			try {
				Ghi_List_Vao_File.ghi_Sach_Vao_File(Sachfile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.dispose();
			UserUI dn = new UserUI();
			dn.showWindow();
		} else {
			txtMaHoaDon.setText("");
			txtTenKH.setText("");
			txtNgayGD.setText("");
			txtSoLuong.setText("");
			txtThanhTien.setText("");
		}
	}// GEN-LAST:event_btnConfirmActionPerformed

	private void xoaSachTrongGio(String tenKH) throws IOException {
		int i = 0;
		ArrayList<SachTrongGioHang> a = SachTrongGioHangDAL.showAll();
		while (i < a.size()) {
			if (a.get(i).getMaTaiKhoan().equals(tenKH)) {
				a.remove(i);
			} else {
				i++;
			}
		}
		Ghi_List_Vao_File.ghi_SachTrongGioHang_Vao_File(a);
	}

	public void showWindow() {
		this.setSize(600, 630);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

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
			java.util.logging.Logger.getLogger(ThongTinThanhToanUI.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(ThongTinThanhToanUI.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(ThongTinThanhToanUI.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(ThongTinThanhToanUI.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ThongTinThanhToanUI().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnConfirm;
	private javax.swing.JButton btnHuy;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JTextField txtMaHoaDon;
	private javax.swing.JTextField txtNgayGD;
	private javax.swing.JTextField txtSoLuong;
	private javax.swing.JTextField txtTenKH;
	private javax.swing.JTextField txtThanhTien;
	// End of variables declaration//GEN-END:variables
}
