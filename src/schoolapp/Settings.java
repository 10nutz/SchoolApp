package schoolapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Settings {
	public static String STUDENTS_PATH;
	public static String TEACHERS_PATH;
	public static String COURSES_PATH;
	public static LOAD_TYPE loadType;
	public static DISPLAY_TYPE displayType;
	static HashMap<LOAD_TYPE, iDataLoader> dataLoaderHashMap = new HashMap<>() {
		{
			put(LOAD_TYPE.HARDCODED, new HardcodedDataManager());
			put(LOAD_TYPE.FILE, new FileDataManager());
			put(LOAD_TYPE.KEYBOARD, new KeyboardDataManager());
		}
	};
	static HashMap<DISPLAY_TYPE, iDisplayManager> displayHashMap = new HashMap<>() {
		{
			put(DISPLAY_TYPE.CONSOLE, new ConsoleDisplay());
			put(DISPLAY_TYPE.FILE, new FileDisplay());
			put(DISPLAY_TYPE.GUI, new GraphicUserInterfaceDisplay());
		}
	};

	public static void initApplication() {
		// read settings.txt and init all values from the file
		try {
			File f = new File("settings.txt");
			BufferedReader b = new BufferedReader(new FileReader(f));
			String readLine = b.readLine();
			String[] splits = readLine.split("= ");
			STUDENTS_PATH = splits[1];
			readLine = b.readLine();
			splits = readLine.split("= ");
			TEACHERS_PATH = splits[1];
			readLine = b.readLine();
			splits = readLine.split("= ");
			COURSES_PATH = splits[1];
			readLine = b.readLine();
			String[] splits2 = readLine.split("\"");
			loadType = loadType.valueOf(splits2[1]);
			System.out.println(loadType.toString());
			readLine = b.readLine();
			splits2 = readLine.split("\"");
			displayType = displayType.valueOf(splits2[1]);
			System.out.println(displayType.toString());
			b.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
