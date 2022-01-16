package schoolapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentForm {
    public StudentForm(JFrame owner) {
        this.owner = owner;
        txtAverage.setBackground(Color.GRAY);
        averagePanel.setVisible(false);
        btnSeeCourses.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                averagePanel.setVisible(false);
                textArea1.setText("\n\t Your courses: \n");
                for (Course c : Application.getInstance().courses_aux.courses) {
                    for (Student s : c.students) {
                        if (Application.getInstance().currentUser.menuStrategy.getAccountHolderInformation().containsKey(s.first_name)) {
                            textArea1.append(c.name + "\n");
                        }
                    }
                }
            }
        });
        btnSeeGrades.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnSeeGrades) {
                    averagePanel.setVisible(false);
                    textArea1.setText("\n\t Grades: \n");
                    for (Course c : Application.getInstance().courses_aux.courses) {
                        for (Student s : c.students) {
                            if (Application.getInstance().currentUser.menuStrategy.getAccountHolderInformation().containsKey(s.first_name)) {
                                textArea1.append(c.name + ", grade: " + c.grades.get(s) + "\n");
                            }
                        }
                    }
                }
            }
        });
        btnSeeAverage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnSeeAverage) {
                    textArea1.setText("");
                    averagePanel.setVisible(true);
                    for (int i = 1; i <= 4; i++) {
                        textArea1.append("\n\t Year " + i + "\n");
                        for (Course c : Application.getInstance().courses_aux.courses) {
                            if (c.year == i) {
                                for (Student s : c.students) {
                                    if (Application.getInstance().currentUser.menuStrategy.getAccountHolderInformation().containsKey(s.first_name)) {
                                        textArea1.append(c.name + ", grade: " + c.grades.get(s) + "\n");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == calculateButton) {
                    try {
                        int sum = 0;
                        int nr = 0;
                        for (Course c : Application.getInstance().courses_aux.courses) {
                            if (c.year == Integer.parseInt(txtAverage.getText())) {
                                for (Student s : c.students) {
                                    if (Application.getInstance().currentUser.menuStrategy.getAccountHolderInformation().containsKey(s.first_name)) {
                                        sum = sum + c.grades.get(s);
                                        nr++;
                                    }
                                }
                            }
                        }
                        if (Integer.parseInt(txtAverage.getText()) < 5) {
                            textArea1.append("\nYour average grade for year " + txtAverage.getText() + " is " + (float)sum / nr);
                        }else{
                            textArea1.append("\nYear does not exist!");
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Incorrect data!");
                    }
                }

            }
        });
        btnSeeFailedExams.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnSeeFailedExams) {
                    textArea1.setText("\n\tFailed exams\n");
                    averagePanel.setVisible(false);
                    try {
                        for (Course c : Application.getInstance().courses_aux.courses)
                            for (Student s : c.students)
                                if (Application.getInstance().currentUser.menuStrategy.getAccountHolderInformation().containsKey(s.first_name)) {
                                    if (c.grades.get(s) < 5)
                                        textArea1.append(c.name);
                                }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Something went wrong!");
                    }
                }
            }
        });
        btnBackToLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == btnBackToLogin){
                    JOptionPane.showMessageDialog(null, "Back to login!");
                    main.setVisible(false);
                    owner.setContentPane(new LoginForm(owner).getMainPanel());
                }
            }
        });
    }

    public JPanel getMain() {
        return main;
    }

    private JPanel main;
    private JButton btnSeeCourses;
    private JButton btnSeeAverage;
    private JButton btnSeeGrades;
    private JButton btnSeeFailedExams;
    private JButton btnBackToLogin;
    private JTextArea textArea1;
    private JTextField txtAverage;
    private JButton calculateButton;
    private JPanel averagePanel;
    private JLabel lblAverage;
    private JFrame owner;
}
