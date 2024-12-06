package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import Entities.TaiKhoan;
import Tools.Doc_List_Tu_File;

public class DangNhapUI extends JFrame {

	private static final long serialVersionUID = 1L;
	JTextField txtTaiKhoan, txtMatKhau;
	JButton btnDangNhap, btnThoat;

	public DangNhapUI(String title) {
		super(title);
		this.setSize(new Dimension(530, 380));
		setIconImage(Toolkit.getDefaultToolkit().getImage(DangNhapUI.class.getResource("/Image/security.png")));
		addControl();
		addEvents();
	}

	private void addControl() {

		Container conn = getContentPane();
		JPanel pnMain = new JPanel();
		conn.add(pnMain);
		JPanel pnTitle = new JPanel();
		pnTitle.setBounds(0, 0, 510, 68);
		JLabel lblTitle = new JLabel("Đăng nhập hệ thống ");
		lblTitle.setBounds(119, 5, 297, 52);
		lblTitle.setForeground(Color.BLUE);
		pnMain.setLayout(null);
		pnTitle.setLayout(null);
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 30));
		pnTitle.add(lblTitle);
		pnMain.add(pnTitle);

		JPanel pnDangNhap = new JPanel();
		pnDangNhap.setBounds(0, 68, 513, 270);
		pnDangNhap.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		pnMain.add(pnDangNhap);
		pnDangNhap.setLayout(null);

		JPanel pnTaiKhoan = new JPanel();
		pnTaiKhoan.setPreferredSize(new Dimension(0, 0));
		pnTaiKhoan.setBounds(5, 21, 500, 70);
		JLabel lblTaiKhoan = new JLabel("Tài khoản");
		lblTaiKhoan.setBounds(107, 19, 113, 31);
		lblTaiKhoan.setFont(new Font("Segoe UI", Font.BOLD, 18));
		txtTaiKhoan = new JTextField(20);
		txtTaiKhoan.setBounds(230, 12, 200, 45);
		txtTaiKhoan.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		pnTaiKhoan.setLayout(null);
		pnTaiKhoan.add(lblTaiKhoan);
		pnTaiKhoan.add(txtTaiKhoan);
		pnDangNhap.add(pnTaiKhoan);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(DangNhapUI.class.getResource("/Image/user.png")));
		lblNewLabel.setBounds(50, 19, 32, 32);
		pnTaiKhoan.add(lblNewLabel);

		JPanel pnMatKhau = new JPanel();
		pnMatKhau.setBounds(5, 94, 500, 70);
		JLabel lblMatKhau = new JLabel("Mật Khẩu");
		lblMatKhau.setBounds(107, 19, 113, 31);
		lblMatKhau.setFont(new Font("Segoe UI", Font.BOLD, 18));
		txtMatKhau = new JPasswordField(20);
		txtMatKhau.setBounds(230, 12, 200, 45);
		txtMatKhau.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		pnMatKhau.setLayout(null);
		pnMatKhau.add(lblMatKhau);
		pnMatKhau.add(txtMatKhau);
		pnDangNhap.add(pnMatKhau);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(DangNhapUI.class.getResource("/Image/reset-password.png")));
		lblNewLabel_1.setBounds(52, 19, 32, 32);
		pnMatKhau.add(lblNewLabel_1);

		JPanel pnButton = new JPanel();
		pnButton.setBounds(5, 170, 500, 71);
		btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.setBounds(114, 15, 133, 41);
		btnDangNhap.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnDangNhap.setMnemonic(KeyEvent.VK_CUT);
		btnDangNhap.setRolloverSelectedIcon(
				null);
		btnDangNhap.setRolloverIcon(
				new ImageIcon(DangNhapUI.class.getResource("/Image/enter2.png")));
		btnDangNhap.setInheritsPopupMenu(true);
		btnDangNhap.setIgnoreRepaint(true);
		btnDangNhap.setIconTextGap(1);
		btnDangNhap.setSelected(true);
		btnDangNhap.setIcon(
				new ImageIcon(DangNhapUI.class.getResource("/Image/enter.png")));
		btnThoat = new JButton("Thoát");
		btnThoat.setBounds(252, 15, 133, 41);
		btnThoat.setRolloverSelectedIcon(new ImageIcon(DangNhapUI.class.getResource("/Image/exit2.png")));
		btnThoat.setRolloverIcon(new ImageIcon(DangNhapUI.class.getResource("/Image/exit2.png")));
		btnThoat.setMnemonic(KeyEvent.VK_CUT);
		btnThoat.setIconTextGap(1);
		btnThoat.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnThoat.setAlignmentY(Component.TOP_ALIGNMENT);
		btnThoat.setInheritsPopupMenu(true);
		btnThoat.setIgnoreRepaint(true);
		btnThoat.setIcon(new ImageIcon(DangNhapUI.class.getResource("/Image/log-out.png")));
		pnButton.setLayout(null);
		pnButton.add(btnDangNhap);
		pnButton.add(btnThoat);
		pnDangNhap.add(pnButton);
		btnThoat.setPreferredSize(btnDangNhap.getPreferredSize());
		TitledBorder border = new TitledBorder(BorderFactory.createLineBorder(Color.red), "Thông tin đăng nhập ");
		pnDangNhap.setBorder(border);
	}

	private void addEvents() {
		btnDangNhap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					xuLyDangNhap();
				} catch (IOException ex) {
					Logger.getLogger(DangNhapUI.class.getName()).log(Level.WARNING, null, ex);
				} catch (ClassNotFoundException ex) {
					Logger.getLogger(DangNhapUI.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		});
		btnThoat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AutomaticallyClosedMsgBox(2000, "Đang thoát khỏi Hệ Thống\nThanks for using...");
				System.exit(0);
			}
		});

	}

	public static String username;

	protected void xuLyDangNhap() throws IOException, ClassNotFoundException {
		if (txtTaiKhoan.getText().equals("") || txtMatKhau.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng điền toàn bộ thông tin");
		} else {
			String vaitro = "", isAdmin = "Admin";
			ArrayList<TaiKhoan> listTK = Doc_List_Tu_File.Doc_TaiKhoan_Tu_File();
			for (TaiKhoan item : listTK) {
				if (item.getMaTaiKhoan().equals(txtTaiKhoan.getText())
						&& item.getMatKhau().equals(txtMatKhau.getText())) {
					vaitro = item.getVaiTro();
					username = item.getMaTaiKhoan();
					break;
				}
			}
			if (!vaitro.equals("")) {

				if (vaitro.equals(isAdmin) == false) {

					UserUI nv = new UserUI();
					AutomaticallyClosedMsgBox(2000, "Xác Thực Thành công\nTài Khoản Khách Hàng\n đang đăng nhập...");
					this.dispose();
					nv.setVisible(true);

				} else {
					AdminUI ql = new AdminUI();
					AutomaticallyClosedMsgBox(2000, "Xác Thực Thành công\nTài Khoản ADMIN\n đang đăng nhập...");
					this.dispose();
					ql.setVisible(true);

				}

			} else {
				JOptionPane.showMessageDialog(null, "Tên đăng nhập hoặc mật khẩu không tồn tại");
				txtTaiKhoan.setText("");
				txtMatKhau.setText("");
				username = "";
//                            DangNhapUI dn = new DangNhapUI("Vui lòng đăng nhập để tiếp tục");
//                            dn.showWindow();
			}

		}
	}

	public void showWindow() {
		this.setSize(530, 380);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
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

	public static void main(String[] args) {
		DangNhapUI dn = new DangNhapUI("Vui lòng đăng nhập để tiếp tục");
		dn.showWindow();
	}
}
