import java.io.File;
import java.io.IOException;

public class taskManager {

    private static final String FILE_PATH = "tasks.json";

    public static void verifyFile() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            try {
                if (!file.createNewFile()) {
                    System.out.println("JSON file could not be created.");
                }
            } catch (IOException e) {
                System.out.println("There was a problem creating the file.");
                e.printStackTrace();
            }
        }
    }

    public static void addTask(String description){
        verifyFile();
    }

    public static void updateTask(int id, String description){
        verifyFile();
    }

    public static void deleteTask(int id){
        verifyFile();
    }

    public static void markInProgress(int id){
        verifyFile();
    }

    public static void markDone(int id){
        verifyFile();
    }

    public static void listTasks(){
        verifyFile();
    }

    public static void listTasksByStatus(String status){
        verifyFile();
    }
}
