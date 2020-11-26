import jdk.jfr.Event;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ChangePassword extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JLabel lblEnterNewPassword;

    /**
     * Launch the application
     */
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                try{

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
    /**
     * Create the frame
     */
    public ChangePassword(String name){
        setBounds(450, 360, 1024, 450);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        textField = new JTextField();
        textField.setFont(new Font("Aerial", Font.PLAIN, 34));
        textField.setBounds(373, 35, 609, 67);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton btnSearch = new JButton("Enter");
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String pstr = textField.getText();
                try{
                    System.out.println("Update password name" + name);
                    System.out.println("Update password");

                    Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/account",
                            "root", "hideonbush1969");

                    Connection connection;
                    PreparedStatement st = (PreparedStatement) con.prepareStatement("Update account set password=? where name=?");

                    st.setString(1, pstr);
                    st.setString(2, name);
                    st.executeUpdate();
                    JOptionPane.showMessageDialog(btnSearch, "Password reset successfully!");
                } catch (SQLException sqlException){
                    sqlException.printStackTrace();
                }
            }
        });
        btnSearch.setFont(new Font("Aerial", Font.PLAIN, 29));
        btnSearch.setBackground(new Color(240, 240, 240));
        btnSearch.setBounds(438, 300, 200, 59);
        contentPane.add(btnSearch);

        lblEnterNewPassword = new JLabel("Enter new password: ");
        lblEnterNewPassword.setFont(new Font("Aerial", Font.PLAIN, 30));
        lblEnterNewPassword.setBounds(45, 37, 326, 67);
        contentPane.add(lblEnterNewPassword);
    }
}
