/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.stackqueueprogram;
import java.util.*;
/**
 *
 * @author readi
 */

public class StackQueueProgram {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Choose data structure (stack / queue): ");
        String choice = sc.nextLine().toLowerCase();

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

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
    static void runStack(Scanner sc, int[] stack) {
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
                    int value = sc.nextInt();
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

    // ================= QUEUE =================
    static void runQueue(Scanner sc, int[] queue) {
        int front = 0, rear = -1, count = 0;
        boolean running = true;

        while (running) {
            System.out.print("Enqueue or Dequeue? ");
            String op = sc.next().toLowerCase();

            if (op.equals("enqueue")) {
                if (count == queue.length) {
                    System.out.println("Queue is FULL");
                } else {
                    System.out.print("Enter value: ");
                    int value = sc.nextInt();
                    rear++;
                    queue[rear] = value;
                    count++;
                    System.out.println("Enqueued successfully");
                }

            } else if (op.equals("dequeue")) {
                if (count == 0) {
                    System.out.println("Queue is EMPTY");
                } else {
                    System.out.println("Dequeued: " + queue[front]);
                    front++;
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
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }
}