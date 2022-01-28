package schoolapp;

import javax.swing.*;
import java.beans.ExceptionListener;
import java.beans.XMLEncoder;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Collections;

enum LOAD_TYPE {
    HARDCODED, KEYBOARD, FILE
}

enum DISPLAY_TYPE {
    CONSOLE, FILE, GUI
}

public class TestClass {

    public static void main(String[] args) {
    NewThread t1 = new NewThread("Console");
    NewThread t2 = new NewThread("GUI");
    t1.start();
    t2.start();
    }
}
