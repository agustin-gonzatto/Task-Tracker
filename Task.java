import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Task {
    int id;
    String description;
    String status;
    Date createdAt;
    Date updatedAt;

    Task(int id, String description, String status) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    public int getId() {
        return id;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return "ID: " + id + "\nDescription: " + description + "\nStatus: " + status + "\nCreatedAt: " + dateFormat.format(createdAt) + "\nUpdatedAt: " + dateFormat.format(updatedAt);
    }
}
