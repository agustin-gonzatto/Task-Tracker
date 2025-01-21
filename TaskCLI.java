public class TaskCLI {
    public static void main(String[] args){
        if(args.length == 0){
            System.out.println("Usage: java -jar TaskCLI.jar <task name>");
        }

        String command = args[0];
        switch (command) {
            case "add":
                if (args.length < 2) {
                System.out.println("Missing task description.");
                } else {
                    String description = args[1];
                    TaskManager.addTask(description);
                }
                break;
            case "update":
                if (args.length < 3) {
                    System.out.println("Please specify task ID and description.");
                } else {
                    int id = Integer.parseInt(args[1]); String newDescription = args[2];
                    TaskManager.updateTask(id, newDescription);
                } break;
            case "delete":
                if (args.length < 2) {
                    System.out.println("Please specify task ID to delete.");
                } else {
                    int id = Integer.parseInt(args[1]);
                    TaskManager.deleteTask(id); System.out.println("Task deleted successfully.");
                } break;
            case "mark-in-progress":
                if (args.length < 2) {
                    System.out.println("Please specify task ID to mark in-progress.");
                } else {
                    int id = Integer.parseInt(args[1]);
                    TaskManager.markInProgress(id);
                    System.out.println("Task marked in-progress successfully.");
                } break;
            case "mark-done":
                if (args.length < 2) {
                    System.out.println("Please specify task ID to mark done.");
                } else {
                    int id = Integer.parseInt(args[1]);
                    TaskManager.markDone(id);
                    System.out.println("Task marked done successfully.");
                } break;
            case "list":
                if (args.length < 2) {
                    TaskManager.listTasks();
                } else {
                    String status = args[1];
                    TaskManager.listTasksByStatus(status);
                } break;
            default: System.out.println("Undefined command."); }
    }
}
