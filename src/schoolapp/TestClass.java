package schoolapp;

//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Collections;

enum LOAD_TYPE {
	HARDCODED, KEYBOARD,FILE
}

enum DISPLAY_TYPE{
	CONSOLE, FILE, GUI
}
public class TestClass {	
	public static void main(String[] args) {
 		/*Settings.initApplication();
 		iDataLoader dataloader = Settings.loadType == LOAD_TYPE.HARDCODED ? new HardcodedDataManager() : new FileDataManager();
 		
 		Teacher[] tchs = dataloader.createTeacherData();
 		for(Teacher t:tchs) {
 			System.out.println(t);
 		}*/
		Settings.initApplication();
		iDisplayManager displayManager = Settings.displayHashMap.get(Settings.displayType);
		iDataLoader dataManager = Settings.dataLoaderHashMap.get(Settings.loadType);
		//displayManager.displayStudents(dataManager.createStudentsData());
	}
}
