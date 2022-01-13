package schoolapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentForm {
    public StudentForm() {
        txtAverage.setBackground(Color.GRAY);
        averagePanel.setVisible(false);
        btnSeeCourses.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("\t Your courses: \n");
                for (Course c : Application.getInstance().courses_aux.courses){
                    for(Student s:c.students){
                        if(Application.getInstance().currentUser.menuStrategy.getAccountHolderInformation().containsKey(s.first_name)){
                            textArea1.append(c.name + "\n");
                        }
                    }
                }
            }
        });
        btnSeeGrades.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == btnSeeGrades)
                {
                    textArea1.setText("\t Grades: \n");
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
}
