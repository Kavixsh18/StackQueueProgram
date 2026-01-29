package com.mycompany.stackqueueprogram;
import java.util.*;

public class StackQueueProgram {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Choose data structure (stack / queue): ");
        String choice = sc.nextLine().toLowerCase();

        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

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
        boolean running = true;

        while (running) {
            System.out.print("Push or Pop? ");
            String op = sc.next().toLowerCase();

            if (op.equals("push")) {
                if (top == stack.length - 1) {
                    System.out.println("Stack is FULL");
                } else {
                    System.out.print("Enter value: ");
                    String value = sc.next();
                    stack[++top] = value;
                    System.out.println("Pushed successfully");
                }

            } else if (op.equals("pop")) {
                if (top == -1) {
                    System.out.println("Stack is EMPTY");
                } else {
                    System.out.println("Popped: " + stack[top--]);
                }
            }

            System.out.print("Continue or End? ");
            String cont = sc.next().toLowerCase();
            if (cont.equals("end")) {
                running = false;
            }
        }

        System.out.println("\nFinal Stack:");
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    // ================= CIRCULAR QUEUE =================
    static void runQueue(Scanner sc, String[] queue) {
        int front = 0, rear = -1, count = 0;
        boolean running = true;

        while (running) {
            System.out.print("Enqueue or Dequeue? ");
            String op = sc.next().toLowerCase();

            if (op.equals("en")) {
                if (count == queue.length) {
                    System.out.println("Queue is FULL");
                } else {
                    System.out.print("Enter value: ");
                    String value = sc.next();
                    rear = (rear + 1) % queue.length;
                    queue[rear] = value;
                    count++;
                    System.out.println("Enqueued successfully");
                }

            } else if (op.equals("de")) {
                if (count == 0) {
                    System.out.println("Queue is EMPTY");
                } else {
                    System.out.println("Dequeued: " + queue[front]);
                    front = (front + 1) % queue.length;
                    count--;
                }
            }

            System.out.print("Continue or End? ");
            String cont = sc.next().toLowerCase();
            if (cont.equals("end")) {
                running = false;
            }
        }

        System.out.println("\nFinal Queue:");
        for (int i = 0; i < count; i++) {
            System.out.print(queue[(front + i) % queue.length] + " ");
        }
        System.out.println();
    }
}
