/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DAL.TaiKhoanDAL;
import Entities.TaiKhoan;
import java.awt.HeadlessException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import java.awt.Dimension;

/**
 *
 * @author PC
 */
public class ThongTinUserUI extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
	/**
     * Creates new form ThongTinUserUI
     */
    public ThongTinUserUI() {
		setSize(new Dimension(510, 430));
		getContentPane().setBackground(new Color(173, 248, 248));
		getContentPane().setEnabled(false);
        initComponents();
        
        show_TaiKhoan();
    }

    public void show_TaiKhoan(){
        txtTenDangNhap.setText(DangNhapUI.username); 
        ArrayList<TaiKhoan> list= TaiKhoanDAL.showUser();
        for(TaiKhoan item:list){
            if(item.getMaTaiKhoan().equals(DangNhapUI.username))
                txtPassword.setText(item.getMatKhau());
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel1.setForeground(Color.BLUE);
        jLabel2 = new javax.swing.JLabel();
        jLabel2.setForeground(Color.BLUE);
        jLabel3 = new javax.swing.JLabel();
        jLabel3.setForeground(Color.BLUE);
        btnSua = new javax.swing.JButton();
        btnSua.setRolloverIcon(new ImageIcon(ThongTinUserUI.class.getResource("/Image/maintenance1.png")));
        btnSua.setIcon(new ImageIcon(ThongTinUserUI.class.getResource("/Image/maintenance.png")));
        btnExit = new javax.swing.JButton();
        btnExit.setRolloverIcon(new ImageIcon(ThongTinUserUI.class.getResource("/Image/cancel24v2.png")));
        btnExit.setIcon(new ImageIcon(ThongTinUserUI.class.getResource("/Image/cancel24.png")));
        txtTenDangNhap = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        cboxShowPass = new javax.swing.JCheckBox();
        cboxShowPass.setBackground(new Color(218, 252, 252));
        cboxShowPass.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 24)); // NOI18N
        jLabel1.setText("TÀI KHOẢN");

        jLabel2.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // NOI18N
        jLabel2.setText("Tên đăng nhập:");

        jLabel3.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // NOI18N
        jLabel3.setText("Mật khẩu:");

        btnSua.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnExit.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // NOI18N
        btnExit.setText("Thoát");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        txtTenDangNhap.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // NOI18N

        txtPassword.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // NOI18N

        cboxShowPass.setText("Hiện mật khẩu");
        cboxShowPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxShowPassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(75)
        			.addComponent(btnSua)
        			.addPreferredGap(ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
        			.addComponent(btnExit)
        			.addGap(79))
        		.addGroup(layout.createSequentialGroup()
        			.addGap(34)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel2)
        				.addComponent(jLabel3))
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(cboxShowPass)
        				.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        					.addComponent(txtTenDangNhap)
        					.addComponent(txtPassword, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)))
        			.addContainerGap(33, Short.MAX_VALUE))
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(138, Short.MAX_VALUE)
        			.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
        			.addGap(134))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(27)
        			.addComponent(jLabel1)
        			.addGap(28)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel2)
        				.addComponent(txtTenDangNhap, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel3)
        				.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(cboxShowPass)
        			.addGap(25)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnSua)
        				.addComponent(btnExit))
        			.addGap(71))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        this.dispose();
        UserUI dn = new UserUI();
        dn.showWindow();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        try{
            TaiKhoan setTK = new TaiKhoan();
            setTK.setMaTaiKhoan(txtTenDangNhap.getText());
            char[] pf = txtPassword.getPassword();
            String value = new String(pf);
            setTK.setMatKhau(value);
            setTK.setVaiTro("User");
            int reply = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn sửa?", "Thông báo", JOptionPane.YES_NO_OPTION);
            
            if (reply == JOptionPane.YES_OPTION) {
                if(TaiKhoanDAL.update(TaiKhoanDAL.show(),setTK)){
                    JOptionPane.showMessageDialog(null,"Sửa tai khoản thành công!");
                    show_TaiKhoan();
                }
            }
        }
        catch(HeadlessException | IOException e){
            JOptionPane.showMessageDialog(null,"Có lỗi xảy ra: "+e.getMessage());
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void cboxShowPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxShowPassActionPerformed
        // TODO add your handling code here:
        if(cboxShowPass.isSelected()){
            txtPassword.setEchoChar((char)0);
        }
        else{
            txtPassword.setEchoChar('*');
        }
    }//GEN-LAST:event_cboxShowPassActionPerformed

    public void showWindow() {
            this.setSize(510, 420);
            this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            this.setLocationRelativeTo(null);
            this.setVisible(true);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ThongTinUserUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongTinUserUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongTinUserUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongTinUserUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThongTinUserUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSua;
    private javax.swing.JCheckBox cboxShowPass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtTenDangNhap;
    // End of variables declaration//GEN-END:variables
}
