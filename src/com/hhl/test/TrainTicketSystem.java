/**
 * @author BOOM
 * @create 2023-07-24 10:00
 */
package com.hhl.test;

/**
 @author boom
 @create 2023-07-24 10:00
 */
import java.util.*;
import java.io.*;

import java.util.Scanner;

public class TrainTicketSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt(); // 站点数
        int N = scanner.nextInt(); // 座位数
        int Q = scanner.nextInt(); // 操作次数

        int[] seats = new int[M]; // 每个站点的余票数量

        for (int i = 0; i < Q; i++) {
            char operation = scanner.next().charAt(0);
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c;

            if (operation == 'Q') {
                int availableSeats = 0;
                for (int j = a; j < b; j++) {
                    availableSeats += seats[j];
                }
                System.out.println(availableSeats);
            } else if (operation == 'B') {
                c = scanner.nextInt();
                boolean success = true;
                for (int j = a; j < b; j++) {
                    if (seats[j] < c) {
                        success = false;
                        break;
                    }
                }
                if (success) {
                    for (int j = a; j < b; j++) {
                        seats[j] -= c;
                    }
                    System.out.println("OK!");
                } else {
                    System.out.println("Fail!");
                }
            } else if (operation == 'R') {
                c = scanner.nextInt();
                int soldTickets = 0;
                for (int j = a; j < b; j++) {
                    soldTickets += c - seats[j];
                }
                if (soldTickets >= c) {
                    for (int j = a; j < b; j++) {
                        seats[j] += c;
                    }
                    System.out.println("OK!");
                } else {
                    System.out.println("Fail!");
                }
            }
        }
    }
}
