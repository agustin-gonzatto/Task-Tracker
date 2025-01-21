# Task-Tracker-CLI

Task-Tracker-CLI is a simple command-line interface (CLI) application to help you manage your tasks efficiently. With this tool, you can keep track of what you need to do, what you have completed, and what you are currently working on.

---

## Features
- Add tasks with detailed descriptions.
- Update tasks to reflect new details or changes.
- Delete tasks that are no longer relevant.
- Mark tasks as "in-progress" or "done" to track their status.
- List tasks by their status or display all tasks.

---

## Compilation
Compile the Java files before using the CLI:

### CMD:
```bash
javac *.java
```

### PowerShell:
```powershell
javac .\*.java
```

---

## Usage
Run the application using the following commands:

### Add a Task
```bash
java TaskCLI add "<description>"
```
Example:
```bash
java TaskCLI add "Write documentation for Task-Tracker"
```

### Update a Task
```bash
java TaskCLI update <id> "<new description>"
```
Example:
```bash
java TaskCLI update 1 "Update README with detailed instructions"
```

### Delete a Task
```bash
java TaskCLI delete <id>
```
Example:
```bash
java TaskCLI delete 1
```

### Mark a Task as In-Progress
```bash
java TaskCLI mark-in-progress <id>
```
Example:
```bash
java TaskCLI mark-in-progress 2
```

### Mark a Task as Done
```bash
java TaskCLI done <id>
```
Example:
```bash
java TaskCLI done 3
```

### List All Tasks
```bash
java TaskCLI list
```
Example:
```bash
java TaskCLI list
```

### List Tasks by Status
```bash
java TaskCLI list <status>
```
Available statuses: `pending`, `in-progress`, `done`.

Example:
```bash
java TaskCLI list in-progress
```

---

## Notes
- Replace `<id>` with the task ID (a unique number assigned to each task).
- Replace `<description>` with the text describing your task.
- Ensure the tasks are properly compiled before running any commands.
