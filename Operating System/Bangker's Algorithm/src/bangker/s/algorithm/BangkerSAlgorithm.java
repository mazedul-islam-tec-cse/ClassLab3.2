/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bangker.s.algorithm;

import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class BangkerSAlgorithm {

    static int process;
    static int[][] alloc;
    static int[][] max;
    static int[] avail;
    static int[][] need;
    static int n, m;
    static boolean[] finish;
    static int[] work;
    static ArrayList<Integer> sequence = new ArrayList<>();

    static boolean checkNeedWork(int i) {
   
        for (int j = 0; j < m; j++) {
            System.out.print(need[i][j] + " ");

        }
        System.out.print(" < ");
        for (int j = 0; j < m; j++) {
            System.out.print(work[j] + " ");

        }

        for (int j = 0; j < j; j++) {
            if (need[i][j] > work[j]) {
                return false;
            }

        }
        return true;
    }

    static void setWork(int i) {
        
        System.out.print("\nwork = ");
        for (int j = 0; j < m; j++) {
            work[j] = work[j] + alloc[i][j];
            System.out.print(work[j]+" ");
        }
        System.out.println("");
    }

    static void findSafeSequence() {
        int i = 0;
        int count = 0;
        while (true) {
            count++;
            if(count == 20){
                break;
            }
            System.out.println("For i = "+i+"\n");
            if (finish[i] == false && checkNeedWork(i)) {

                sequence.add(i);
                finish[i] = true;
                setWork(i);
                boolean check = true;
                for (Boolean b : finish) {
                    System.out.print(b + " ");
                    if (b == false) {
                        check = false;
                    }
                }
                System.out.println("\nP"+i +" must be kept in safe sequence\n");
                if (check == true) {
                    lastStep();
                }
                System.out.println("\n");
                i++;
            } else {
                
                 for (Boolean b : finish) {
                    System.out.print(b + " ");
                    
                }
                 System.out.println("/nP"+i +"must wait\n");
                
                i++;
                if (i == m) {
                    i = 0;
                }
            }

        }
    }

    static void lastStep() {
        System.out.println("The Sequence is ");
        for (Integer sq : sequence) {
            System.out.print("p" + sq + " ");
        }
        System.out.println("");
        exit(1);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of process : ");
        n = input.nextInt();
        System.out.println("Enter the number of column");
        m = input.nextInt();
        alloc = new int[n][m];
        max = new int[n][m];
        need = new int[n][m];
        avail = new int[m];
        finish = new boolean[n];
        work = new int[m];

        System.out.println("Enter Allocation matrix : ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                alloc[i][j] = input.nextInt();
            }

        }

        System.out.println("\nEnter Max matrix : ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max[i][j] = input.nextInt();
            }

        }

        System.out.println("\nEnter available : ");
        for (int i = 0; i < m; i++) {
            avail[i] = input.nextInt();
            work[i] = avail[i];

        }

        System.out.println("\nNeed matrix : ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                need[i][j] = max[i][j] - alloc[i][j];
                System.out.print(need[i][j] + " ");
            }
            System.out.println("");

        }

        findSafeSequence();

    }

}

/*Enter Allocation matrix : 
 2 0 0 1
 3 1 2 1
 2 1 0 3
 1 3 1 2
 1 4 3 2

 Enter Max matrix : 
 4 2 1 2
 5 2 5 2
 2 3 1 6
 1 4 2 4
 3 6 6 5

 Enter available :
 3 3 2 1
 */
