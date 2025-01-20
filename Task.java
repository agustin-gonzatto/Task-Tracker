public class Task {
    int id;
    String description;
    String status;

    Task(int id, String description, String status){
        this.id = id;
        this.description = description;
        this.status = status;
    }

    @Override
    public String toString() {
        return "{\"id\":\""+id+"\",\"description\":\""+description+"\",\"status\":\""+status+"\"}";
    }
}
