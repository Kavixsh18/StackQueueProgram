package com.mycompany.stackqueueprogram;
import java.util.*;

public class StackQueueProgram {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Choose data structure (stack / queue): ");
        String choice = sc.nextLine().toLowerCase();

        System.out.print("Enter array size: ");
        int n = Integer.parseInt(sc.nextLine());

        String[] arr = new String[n];

        if (choice.equals("stack")) {
            runStack(sc, arr);
        } else if (choice.equals("queue")) {
            runQueue(sc, arr);
        } else {
            System.out.println("Invalid choice.");
        }

        sc.close();
    }

    // ================= STACK =================
    static void runStack(Scanner sc, String[] stack) {
        int top = -1;

        System.out.println("\nCommands: push <value>, pop, end");

        while (true) {
            System.out.print("> ");
            String line = sc.nextLine().trim();

            if (line.equalsIgnoreCase("end")) {
                break;
            }

            String[] parts = line.split(" ", 2);
            String cmd = parts[0].toLowerCase();

            if (cmd.equals("push")) {
                if (parts.length < 2) {
                    System.out.println("Missing value for push");
                } else if (top == stack.length - 1) {
                    System.out.println("Stack is FULL");
                } else {
                    stack[++top] = parts[1]; // keeps spaces if any
                    System.out.println("Pushed successfully");
                }

            } else if (cmd.equals("pop")) {
                if (top == -1) {
                    System.out.println("Stack is EMPTY");
                } else {
                    System.out.println("Popped: " + stack[top--]);
                }

            } else {
                System.out.println("Invalid command");
            }
        }

        System.out.println("\nFinal Stack:");
        for (int i = 0; i <= top; i++) {
            System.out.println(stack[i]);
        }
    }

    // ================= CIRCULAR QUEUE =================
    static void runQueue(Scanner sc, String[] queue) {
        int front = 0, rear = -1, count = 0;

        System.out.println("\nCommands: enqueue <value>, dequeue, end");

        while (true) {
            System.out.print("> ");
            String line = sc.nextLine().trim();

            if (line.equalsIgnoreCase("end")) {
                break;
            }

            String[] parts = line.split(" ", 2);
            String cmd = parts[0].toLowerCase();

            if (cmd.equals("enqueue")) {
                if (parts.length < 2) {
                    System.out.println("Missing value for enqueue");
                } else if (count == queue.length) {
                    System.out.println("Queue is FULL");
                } else {
                    rear = (rear + 1) % queue.length;
                    queue[rear] = parts[1];
                    count++;
                    System.out.println("Enqueued successfully");
                }

            } else if (cmd.equals("dequeue")) {
                if (count == 0) {
                    System.out.println("Queue is EMPTY");
                } else {
                    System.out.println("Dequeued: " + queue[front]);
                    front = (front + 1) % queue.length;
                    count--;
                }

            } else {
                System.out.println("Invalid command");
            }
        }

        System.out.println("\nFinal Queue:");
        for (int i = 0; i < count; i++) {
            System.out.println(queue[(front + i) % queue.length]);
        }
    }
}
