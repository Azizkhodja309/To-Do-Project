package toDoProject.ui;

import toDoProject.enums.TaskStatus;
import toDoProject.model.Task;
import toDoProject.service.TaskService;

public class AndroidUI {
    private static TaskService taskService = new TaskService(2);


    public static void main(String[] args) {
        taskLoop: while (true){
            System.out.println("""
                    ===== Task menu =====
                    1.Show Tasks
                    2.Add Task
                    3.Delete
                    4.Update
                    0.Log Out
                    """);
            Integer choose = Utils.getInt("Choose : ");
            switch (choose){
                case 1->{
                    // showTasks();
                }
                case 2->{
                    addTask();
                    }
                case 3->{
                    // deleteTask();
                    }
                case 4->{
                    // updateTask();
                    }
                case 0->{
                    break taskLoop;
                }
                default->
                    System.out.println("Wrong menu! Try again!!!");
            }
        }
    }

    private static void addTask() {
        System.out.println("Please Enter Task Info: ");
        String name = Utils.getStr("Name: ");
        String description = Utils.getStr("Description: ");
        System.out.println("TaskStatus:");
        System.out.println(TaskStatus.getAllValuesAsString());
        int statusOrder = Utils.getInt("Choose status: ");
        TaskStatus status = TaskStatus.getValueByOrder(statusOrder);

        Task task = new Task(name,description,status);

        taskService.create(task);
        System.out.println("Successfully Created");

    }
}
