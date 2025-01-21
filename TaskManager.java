import java.io.*;
import java.util.*;

public class TaskManager {

    private static final String FILE_PATH = "tasks.json";

    public static boolean jsonExists(String fileName) {
        boolean exists = false;
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            try {
                if (!file.createNewFile()) {
                    System.out.println("JSON file could not be created.");
                }else{
                    exists = true;
                }
            } catch (IOException e) {
                System.out.println("There was a problem creating the file.");
                e.printStackTrace();
            }
        }else{
            exists = true;
        }
        return exists;
    }

    public static void addTask(String description){
        if (jsonExists(FILE_PATH)) {
            List<Task> tasks = readTasks();
            int id = tasks.isEmpty() ? 1 : tasks.get(tasks.size() - 1).id + 1;
            Task newTask = new Task(id, description, "pending");
            tasks.add(newTask);
            writeTasks(tasks);
            System.out.println("Task id added: " + newTask.getId());
        }
    }

    public static void updateTask(int id, String newDescription){
        if (jsonExists(FILE_PATH)){
            List<Task> tasks = readTasks();
            for (Task task : tasks) {
                if (task.getId() == id) {
                    task.setDescription(newDescription);
                    task.setUpdatedAt(new Date());
                    writeTasks(tasks);
                    System.out.println("Task id updated: " + task.getId());
                }
            }
        }
    }

    public static void deleteTask(int id){
        if (jsonExists(FILE_PATH)){
            List<Task> tasks = readTasks();
            tasks.removeIf(task -> task.getId() == id);
            writeTasks(tasks);
        }
    }

    public static void markInProgress(int id){
        if (jsonExists(FILE_PATH)){
            List<Task> tasks = readTasks();
            for (Task task : tasks) {
                if (task.getId() == id) {
                    task.setStatus("in-progress");
                }
            }
            writeTasks(tasks);
        }
    }

    public static void markDone(int id){
        if (jsonExists(FILE_PATH)){
            List<Task> tasks = readTasks();
            for (Task task : tasks) {
                if (task.getId() == id) {
                    task.setStatus("done");
                }
            }
            writeTasks(tasks);
        }
    }

    public static void listTasks(){
        if (jsonExists(FILE_PATH)){
            List<Task> tasks = readTasks();
            if (!tasks.isEmpty()) {
                for (Task task : tasks) {
                    System.out.println(task);
                }
            }
        }
    }

    public static void listTasksByStatus(String status){
        if (jsonExists(FILE_PATH)){
            List<Task> tasks = readTasks();
            for (Task task : tasks) {
                if (task.getStatus().equals(status)) {
                    System.out.println(task);
                }
            }
        }
    }

    public static List<Task> readTasks() {
        List<Task> tasks = new ArrayList<>();
        if (jsonExists(FILE_PATH)) {
            try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
                StringBuilder jsonBuilder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    jsonBuilder.append(line.trim());
                }
                String json = jsonBuilder.toString();
                if (!json.isEmpty()) {
                    json = json.substring(1, json.length() - 1);
                    String[] taskArray = json.split("},\\{");
                    for (String taskString : taskArray) {
                        taskString = taskString.replace("{", "").replace("}", "");
                        String[] fields = taskString.split(",");
                        Map<String, String> taskMap = new HashMap<>();
                        for (String field : fields) {
                            String[] keyValue = field.split(":");
                            String key = keyValue[0].replace("\"", "").trim();
                            String value = keyValue[1].replace("\"", "").trim();
                            taskMap.put(key, value);
                        }
                        Task task = new Task(
                                Integer.parseInt(taskMap.get("id")),
                                taskMap.get("description"),
                                taskMap.get("status")
                        );
                        tasks.add(task);
                    }
                }
            } catch (IOException e) {
                System.out.println("Error reading tasks from file.");
                e.printStackTrace();
            }
        }
        return tasks;
    }

    public static void writeTasks(List<Task> tasks) {
        if (jsonExists(FILE_PATH)) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
                writer.write("[");
                for (int i = 0; i < tasks.size(); i++) {
                    Task task = tasks.get(i);
                    writer.write("{\"id\":\"" + task.id + "\","
                            + "\"description\":\"" + task.description + "\","
                            + "\"status\":\"" + task.status + "\","
                            + "\"createdAt\":\"" + task.createdAt + "\","
                            + "\"updatedAt\":\"" + task.updatedAt + "\"}");
                    if (i < tasks.size() - 1) {
                        writer.write(",");
                    }
                }
                writer.write("]");
            } catch (IOException e) {
                System.out.println("Error writing tasks to file.");
                e.printStackTrace();
            }
        }
    }
}