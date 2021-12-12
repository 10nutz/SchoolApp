package schoolapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
			ArrayList<String> data = new ArrayList<String>();
			BufferedReader b = new BufferedReader(new FileReader(f));
			String readLine = b.readLine();
			
			while(readLine != null) {
				String[] splits = readLine.split("\"(,\")*");
				data.add(splits[1]);
				readLine = b.readLine();
			}
			STUDENTS_PATH = data.get(0);
			TEACHERS_PATH = data.get(1);
			COURSES_PATH = data.get(2);
			loadType = LOAD_TYPE.valueOf(data.get(3));
			displayType = DISPLAY_TYPE.valueOf(data.get(4));
			b.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
