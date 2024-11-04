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
                    showTasks();
                }
                case 2->{
                    // addTask();
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

    private static void showTasks() {
        while(true) {
            System.out.println("==============================================");
            showTask();
            System.out.println("0. Back");
            System.out.println("==============================================");
            int anInt = Utils.getInt("Choose menu: ");

            if(anInt == 0){
                return;
            }

            if (anInt <= 0 || anInt > taskService.getCount()) {
                System.out.println("Wrong menu! Try again !!!");
                continue;
            }
            System.out.println(taskService.getTask(anInt));
        }
    }

    private static int showTask(){
        System.out.println("===== Task Menu =====");
        Task[] all = taskService.getAllTasks();
        int count = 1;
        for (Task task : all) {
            System.out.println(count + ". " + task.getName());
            count++;
        }
        return count;
    }
}
