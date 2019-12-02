/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fcfs;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class FCFS {

    ArrayList<Integer> arrivalTime = new ArrayList<>();
    ArrayList<Integer> brustTime = new ArrayList<>();
    ArrayList<Integer> startingTime = new ArrayList<>();
    int pro, count = 0;

    void grantChart() {

        int firstArrivalTime = 0;

        Scanner input = new Scanner(System.in);

        System.out.println("Enter number of process");
        pro = input.nextInt();

        System.out.println("Enter your arrival time and brust time for each process");
        for (int i = 0; i < pro; i++) {
            arrivalTime.add(input.nextInt());
            brustTime.add(input.nextInt());
        }

        System.out.println("Process  Arrival_time  Brust_time");
        for (int i = 0; i < pro; i++) {
            System.out.println("  p" + (i + 1) + "\t\t" + arrivalTime.get(i) + "  \t" + brustTime.get(i));

        }

        System.out.print("\nGrantt Chart : ");
        startingTime.add(firstArrivalTime);
        System.out.print(" " + firstArrivalTime);

        for (Integer bt : brustTime) {
            firstArrivalTime += bt;
            startingTime.add(firstArrivalTime);
            System.out.print(" " + firstArrivalTime);

        }
    }

    void totalWaitingTime() {

        float waitTime = 0;
        for (int item = 0; item < pro; item++) {
            waitTime += startingTime.get(item) - arrivalTime.get(item);
        }
        System.out.println("\nAvg Waiting time is : " + (waitTime / pro) + " ms");
    }

    void totalTurnarountTime() {

        float turaAroundTime = 0;
        for (int item = 0; item < pro; item++) {
            turaAroundTime += startingTime.get(item + 1) - arrivalTime.get(item);
        }
        System.out.println("Avg Turnaround time is : " + (turaAroundTime / pro) + " ms");
    }

    void totalResponseTime() {

        float responseTime = 0;
        for (int item = 0; item < pro; item++) {
            responseTime += startingTime.get(item) - arrivalTime.get(item);
        }
        System.out.println("Avg Response  time is : " + (responseTime / pro) + " ms");
    }

    public static void main(String[] args) {
        // TODO code application logic here

        FCFS ob = new FCFS();
        ob.grantChart();
        ob.totalWaitingTime();
        ob.totalTurnarountTime();
        ob.totalResponseTime();

    }

}
