package schoolapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm {
    public LoginForm(JFrame owner) {
        this.owner = owner;
        txtUsername.setBackground(Color.GRAY);
        txtUsername.setForeground(Color.white);
        txtPassword.setBackground(Color.GRAY);
        txtPassword.setForeground(Color.white);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == btnLogin){
                    try {
                        User user = new User(txtUsername.getText(),new String(txtPassword.getPassword()));
                        Application.getInstance().login(user);
                        JOptionPane.showMessageDialog(null,"Login successfully");
                        mainPanel.setVisible(false);
                        if(Application.getInstance().currentUser.menuStrategy.getAccountType()== UserAccountType.STUDENT)
                            owner.setContentPane(new StudentForm().getMain());
                        else
                            owner.setContentPane(new TeacherForm().getPanel1() );
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                }
            }
        });
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == btnRegister){
                    mainPanel.setVisible(false);
                    owner.setContentPane(new RegisterForm(owner).getMain());
                }
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    private JPanel mainPanel;
    private JLabel lblUsername;
    private JTextField txtUsername;
    private JLabel lblPassword;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JButton btnRegister;
    private JLabel loginIcon;
    private JFrame owner;
}
