package schoolapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherForm {
    public TeacherForm(JFrame owner) {
        this.owner = owner;
        txtCourse.setBackground(Color.GRAY);
        txtName.setBackground(Color.GRAY);
        txtSurname.setBackground(Color.GRAY);
        txtGrade.setBackground(Color.GRAY);
        gradePanel.setVisible(false);
        btnSeeCourses.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnSeeCourses) {
                    gradePanel.setVisible(false);
                    textArea1.setForeground(Color.WHITE);
                    textArea1.setText("\nYour courses:\n\n");
                    for (Course c : Application.getInstance().courses_aux.courses) {
                        if (Application.getInstance().currentUser.menuStrategy.getAccountHolderInformation().containsKey(c.teacher.first_name)) {
                            textArea1.append(c.name + "\n");
                        }
                    }
                }
            }
        });
        btnSeeStudents.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnSeeStudents) {
                    gradePanel.setVisible(false);
                    textArea1.setText("");
                    textArea1.setForeground(Color.WHITE);
                    for (Course c : Application.getInstance().courses_aux.courses) {
                        if (Application.getInstance().currentUser.menuStrategy.getAccountHolderInformation().containsKey(c.teacher.first_name)) {
                            textArea1.append("\n\n\t" + c.name + ":");
                            for (Student s : c.students)
                                textArea1.append("\t" + s.toString());
                        }
                    }
                }
            }
        });
        btnGrade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gradePanel.setVisible(true);
                textArea1.setText("");
                textArea1.setForeground(Color.WHITE);
                for (Course c : Application.getInstance().courses_aux.courses) {
                    if (Application.getInstance().currentUser.menuStrategy.getAccountHolderInformation().containsKey(c.teacher.first_name)) {
                        textArea1.append("\n\n\t" + c.name + ":");
                        for (Student s : c.students)
                            textArea1.append("\t" + s.toString() + ", grade: " + c.grades.get(s));
                    }
                }
            }
        });
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnSave) {
                    try {
                        for (Course c : Application.getInstance().courses_aux.courses) {
                            if (c.name.compareTo(txtCourse.getText()) == 0 && Application.getInstance().currentUser.menuStrategy.getAccountHolderInformation().containsKey(c.teacher.first_name)) {
                                for (Student s : c.students) {
                                    if (s.first_name.compareTo(txtName.getText()) == 0 && s.second_name.compareTo(txtSurname.getText()) == 0) {
                                        c.grades.put(new Student(txtName.getText(),txtSurname.getText(), s.group), Integer.valueOf(txtGrade.getText()));
                                        JOptionPane.showMessageDialog(null, "Grade added successfully!");
                                    }
                                }
                            }
                        }
                        iDisplayManager idm = Settings.displayHashMap.get(DISPLAY_TYPE.FILE);
                        Course[] caux = new Course[Application.getInstance().courses_aux.courses.size()];
                        Application.getInstance().courses_aux.courses.toArray(caux);
                        idm.displayCourses(caux);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null,"Incorrect data!");
                        //initial mergea, nu am reusit sa gasesc cauza problemei
                    }
                }
            }
        });
        btnBackHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == btnBackHome){
                    JOptionPane.showMessageDialog(null, "Back to login!");
                    mainPanel.setVisible(false);
                    owner.setContentPane(new LoginForm(owner).getMainPanel());
                }
            }
        });
    }

    public JPanel getPanel1() {
        return mainPanel;
    }

    private JPanel mainPanel;
    private JButton btnSeeCourses;
    private JButton btnSeeStudents;
    private JButton btnGrade;
    private JTextArea textArea1;
    private JTextField txtCourse;
    private JTextField txtName;
    private JTextField txtSurname;
    private JTextField txtGrade;
    private JButton btnSave;
    private JLabel lblCourse;
    private JLabel lblName;
    private JLabel lblSurname;
    private JLabel lblGrade;
    private JPanel gradePanel;
    private JButton btnBackHome;
    private JFrame owner;
}
