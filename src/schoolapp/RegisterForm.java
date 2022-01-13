package schoolapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.XMLDecoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RegisterForm {
    public RegisterForm(JFrame owner) {
        this.owner = owner;
        txtUsername.setBackground(Color.GRAY);
        txtUsername.setForeground(Color.white);
        txtPassword.setBackground(Color.GRAY);
        txtPassword.setForeground(Color.white);
        txtFirstName.setBackground(Color.GRAY);
        txtFirstName.setForeground(Color.white);
        txtSecondName.setBackground(Color.GRAY);
        txtSecondName.setForeground(Color.white);
        btnbackToLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == btnbackToLogin){
                    main.setVisible(false);
                    owner.setContentPane(new LoginForm(owner).getMainPanel());
                }
            }
        });
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == btnSave){
                    try{
                        Application.getInstance().register(txtFirstName.getText(),txtSecondName.getText(),txtUsername.getText(),new String(txtPassword.getPassword()));
                        JOptionPane.showMessageDialog(null,"New account created");
                        main.setVisible(false);
                        owner.setContentPane(new LoginForm(owner).getMainPanel());
                    }
                    catch (Exception ex) {
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                }
            }
        });
    }

    public JPanel getMain() {
        return main;
    }

    private JPanel main;
    private JLabel lblFirstName;
    private JTextField txtFirstName;
    private JLabel lblSecondName;
    private JTextField txtSecondName;
    private JLabel lblUsername;
    private JTextField txtUsername;
    private JLabel lblPassword;
    private JPasswordField txtPassword;
    private JButton btnSave;
    private JButton btnbackToLogin;
    private JLabel lblIcon;
    private JFrame owner;
}
