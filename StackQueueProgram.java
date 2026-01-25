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

        System.out.print("Choose data structure (stack/queue): ");
        String choice = sc.nextLine().toLowerCase();

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] array = new int[n];

        if (choice.equals("stack")) {
            int top = -1;
            boolean running = true;

            while (running) {
                System.out.print("\nPush or Pop? ");
                String action = sc.next().toLowerCase();

                if (action.equals("push")) {
                    if (top == n - 1) {
                        System.out.println("Stack Overflow!");
                    } else {
                        System.out.print("Enter value to push: ");
                        int value = sc.nextInt();
                        array[++top] = value;
                        System.out.println("Pushed: " + value);
                    }

                } else if (action.equals("pop")) {
                    if (top == -1) {
                        System.out.println("Stack Underflow!");
                    } else {
                        System.out.println("Popped: " + array[top--]);
                    }
                }

                System.out.print("Continue or End? ");
                String cont = sc.next().toLowerCase();

                if (cont.equals("end")) {
                    running = false;
                }
            }

            System.out.println("\nFinal Stack Elements:");
            for (int i = 0; i <= top; i++) {
                System.out.print(array[i] + " ");
            }

        } else if (choice.equals("queue")) {
            int front = 0, rear = -1, count = 0;
            boolean running = true;

            while (running) {
                System.out.print("\nEnqueue or Dequeue? ");
                String action = sc.next().toLowerCase();

                if (action.equals("enqueue")) {
                    if (count == n) {
                        System.out.println("Queue Overflow!");
                    } else {
                        System.out.print("Enter value to enqueue: ");
                        int value = sc.nextInt();
                        array[++rear] = value;
                        count++;
                        System.out.println("Enqueued: " + value);
                    }

                } else if (action.equals("dequeue")) {
                    if (count == 0) {
                        System.out.println("Queue Underflow!");
                    } else {
                        System.out.println("Dequeued: " + array[front++]);
                        count--;
                    }
                }

                System.out.print("Continue or End? ");
                String cont = sc.next().toLowerCase();

                if (cont.equals("end")) {
                    running = false;
                }
            }

            System.out.println("\nFinal Queue Elements:");
            for (int i = front; i <= rear; i++) {
                System.out.print(array[i] + " ");
            }

        } else {
            System.out.println("Invalid choice!");
        }

        sc.close();
    }
}