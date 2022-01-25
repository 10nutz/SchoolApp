package schoolapp;
import javax.swing.*;
import java.beans.ExceptionListener;
import java.beans.XMLEncoder;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class NewThread extends Thread{
    public static void SeeMenu1() {
        System.out.println("Choose option:");
        System.out.println("1.Login");
        System.out.println("2.Register");
        System.out.println("3.Close");
    }
    public static void SeeStudentMenu() {
        System.out.println("-----Student Menu-----");
        System.out.println("Choose option:");
        System.out.println("1.See courses");
        System.out.println("2.See grades");
        System.out.println("3.See average year grade");
        System.out.println("4.See failed exams");
        System.out.println("5.Back");
    }
    public static void SeeTeacherMenu(){
        System.out.println("-----Teacher Menu-----");
        System.out.println("1.See courses");
        System.out.println("2.See students");
        System.out.println("3.Grade student");
        System.out.println("4.Back");
    }
    private String thd;
    NewThread(String str){
        super();
        this.thd = str;
    }

    @Override
    public void run(){
        if(thd.compareTo("GUI") == 0){
            JFrame frame = new JFrame("Graphic User Interface");
            LoginForm loginForm = new LoginForm(frame);
            frame.setContentPane(loginForm.getMainPanel());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        }
        else{
            Scanner sc = new Scanner(System.in);
            Integer option = 0;
            CoursesManager c_aux;
            while (option != null) {
                SeeMenu1();
                System.out.println("Your option:");
                option = sc.nextInt();
                if (option == 1) {
                    System.out.println("Username:");
                    var username = sc.next();
                    System.out.println("Password:");
                    var password = sc.next();
                    try {
                        Application.getInstance().login(new User(username, password));
                        Settings.initApplication();
                        iDataLoader idt = Settings.dataLoaderHashMap.get(Settings.loadType);
                        c_aux = new CoursesManager(idt.createCoursesData());
                        if (Application.getInstance().currentUser.menuStrategy.getAccountType() == UserAccountType.TEACHER) {
                            Integer op2=0;
                            while(op2 != null){
                                SeeTeacherMenu();
                                System.out.println("Your option:");
                                op2 = sc.nextInt();
                                if (op2 == 1) {
                                    for (Course c : c_aux.courses) {
                                        if (Application.getInstance().currentUser.menuStrategy.getAccountHolderInformation().containsKey(c.teacher.first_name)) {
                                            System.out.println(c.name);
                                        }
                                    }
                                }else{
                                    if(op2 == 2){
                                        for (Course c : c_aux.courses) {
                                            if (Application.getInstance().currentUser.menuStrategy.getAccountHolderInformation().containsKey(c.teacher.first_name)) {
                                                System.out.println("\n\n\t" + c.name + ":");
                                                for (Student s : c.students)
                                                    System.out.print(s.toString());
                                            }
                                        }
                                    }else{
                                        if(op2 == 3){
                                            for (Course c : c_aux.courses) {
                                                if (Application.getInstance().currentUser.menuStrategy.getAccountHolderInformation().containsKey(c.teacher.first_name)) {
                                                    System.out.println("\n\n\t" + c.name + ":");
                                                    for (Student s : c.students)
                                                        System.out.print(s.toString() +" grade: " + c.grades.get(s));
                                                }
                                            }
                                            try {
                                                sc.nextLine();
                                                System.out.println("\nCourse name:");
                                                String cn = sc.nextLine();
                                                System.out.println("Student name:");
                                                String sn = sc.next();
                                                System.out.println("Student surname:");
                                                String ss = sc.next();
                                                System.out.println("Grade:");
                                                int grd = sc.nextInt();
                                                for (Course c : c_aux.courses) {
                                                    if (c.name.compareTo(cn) == 0 && Application.getInstance().currentUser.menuStrategy.getAccountHolderInformation().containsKey(c.teacher.first_name)) {
                                                        for (Student s : c.students) {
                                                            if (s.first_name.compareTo(sn) == 0 && s.second_name.compareTo(ss) == 0) {
                                                                c.grades.put(new Student(sn,ss, s.group), Integer.valueOf(grd));
                                                                System.out.println("Grade added successfully!");
                                                            }
                                                        }
                                                    }
                                                }
                                                iDisplayManager idm = Settings.displayHashMap.get(DISPLAY_TYPE.FILE);
                                                Course[] caux = new Course[c_aux.courses.size()];
                                                c_aux.courses.toArray(caux);
                                                idm.displayCourses(caux);
                                            } catch (Exception ex) {
                                                ex.getMessage();
                                                //initial mergea, nu am reusit sa gasesc cauza problemei
                                            }
                                        }else{
                                            break;
                                        }
                                    }
                                }
                            }
                        } else {
                            Integer op1 = 0;
                            while (op1 != null) {
                                SeeStudentMenu();
                                System.out.println("Your option:");
                                op1 = sc.nextInt();
                                if (op1 == 1) {
                                    for (Course c : c_aux.courses)
                                        for (Student s : c.students) {
                                            if (Application.getInstance().currentUser.menuStrategy.getAccountHolderInformation().containsKey(s.first_name)) {
                                                System.out.println(c.name);
                                            }
                                        }
                                } else {
                                    if (op1 == 2) {
                                        for (Course c : c_aux.courses)
                                            for (Student s : c.students) {
                                                if (Application.getInstance().currentUser.menuStrategy.getAccountHolderInformation().containsKey(s.first_name)) {
                                                    System.out.println(c.name + ",grade: " + c.grades.get(s));
                                                }
                                            }
                                    } else {
                                        if (op1 == 3) {
                                            int sum = 0;
                                            int nr = 0;
                                            for (int i = 1; i <= 4; i++) {
                                                System.out.println("\t Year " + i);
                                                for (Course c : c_aux.courses) {
                                                    if (c.year == i) {
                                                        for (Student s : c.students) {
                                                            if (Application.getInstance().currentUser.menuStrategy.getAccountHolderInformation().containsKey(s.first_name)) {
                                                                System.out.println(c.name + ", grade: " + c.grades.get(s));
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            System.out.println("Choose year:");
                                            int yar = sc.nextInt();
                                            if (yar < 5) {
                                                for (Course c : c_aux.courses) {
                                                    if (c.year == yar) {
                                                        for (Student s : c.students) {
                                                            if (Application.getInstance().currentUser.menuStrategy.getAccountHolderInformation().containsKey(s.first_name)) {
                                                                sum = sum + c.grades.get(s);
                                                                nr++;
                                                            }
                                                        }
                                                    }
                                                }
                                                System.out.println("Your average grade for year " + yar + " is " + (float) sum / nr);
                                            } else {
                                                System.out.println("Year does not exist!");
                                            }
                                        } else {
                                            if (op1 == 4) {
                                                try {
                                                    for (Course c : c_aux.courses)
                                                        for (Student s : c.students)
                                                            if (Application.getInstance().currentUser.menuStrategy.getAccountHolderInformation().containsKey(s.first_name)) {
                                                                if (c.grades.get(s) < 5)
                                                                    System.out.println(c.name);
                                                            }
                                                } catch (Exception ex) {
                                                    ex.getMessage();
                                                }
                                            }else{
                                                if(op1 == 5)
                                                    break;
                                            }
                                        }
                                    }
                                }

                            }
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    if (option == 2) {
                        System.out.println("-----Register-----");
                        System.out.println("Name:");
                        String n = sc.next();
                        System.out.println("Surname:");
                        String s = sc.next();
                        System.out.println("Username:");
                        String un = sc.next();
                        System.out.println("Password:");
                        String ps = sc.next();
                        try{
                            Application.getInstance().register(n,s,un,ps);
                        }catch(Exception ex){
                            ex.getMessage();
                        }
                    } else {
                        System.exit(0);
                    }
                }
            }
        }
    }
}
