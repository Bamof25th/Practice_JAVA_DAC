package com.app.ui;

import java.util.Scanner;
import com.app.operations.TaskListImplemeantation;

public class Test {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            TaskListImplemeantation taskManager = new TaskListImplemeantation();
            boolean exit = false;

            while (!exit) {
                System.out.println("\n========= TASK MANAGER MENU =========");
                System.out.println("1. Add Task");
                System.out.println("2. Delete Task");
                System.out.println("3. Update Task Status");
                System.out.println("4. Display All Pending Tasks");
                System.out.println("5. Display Today's Tasks");
                System.out.println("6. Display All Tasks Sorted by Date");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");

                int choice = sc.nextInt();
                sc.nextLine(); // consumes buffer

                switch (choice) {
                    case 1:
                        System.out.println("Enter Task Name:");
                        String name = sc.nextLine();

                        System.out.println("Enter Description:");
                        String desc = sc.nextLine();

                        System.out.println("Enter Date (yyyy-MM-dd):");
                        String date = sc.nextLine();

                        System.out.println("Enter Status (PENDING / IN_PROGRESS / COMPLETED):");
                        String status = sc.nextLine();

                        taskManager.addTask(name, desc, date, status);
                        System.out.println("Task added successfully!");
                        break;

                    case 2:
                        System.out.println("Enter Task ID to delete:");
                        int delId = sc.nextInt();
                        System.out.println(taskManager.deleteTask(delId));
                        break;

                    case 3:
                        System.out.println("Enter Task ID to update:");
                        int updateId = sc.nextInt();
                        sc.nextLine(); // consume newline

                        System.out.println("Enter New Status (PENDING / IN_PROGRESS / COMPLETED):");
                        String newStatus = sc.nextLine();

                        System.out.println(taskManager.updateTaskStatus(updateId, newStatus));
                        break;

                    case 4:
                        taskManager.displayAllPendingTasks();
                        break;

                    case 5:
                        taskManager.displayAllTaskForToday();
                        break;

                    case 6:
                        taskManager.displayAllSortedByDate();
                        break;

                    case 0:
                        exit = true;
                        System.out.println("Exiting Task Manager. Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
