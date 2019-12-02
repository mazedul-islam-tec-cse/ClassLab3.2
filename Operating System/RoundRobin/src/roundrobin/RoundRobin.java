/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roundrobin;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class RoundRobin {

    /**
     * @param args the command line arguments
     */
    static int[] brustTime;
    static int timeQuantam;
    static int[] temp;
    static int n;
    static int total = 0;
    static ArrayList<Integer> gnt = new ArrayList<>();
    static ArrayList<String> pro = new ArrayList<>();
    static int avgT = 0, avgW = 0, avgR = 0;

    static int granttChart() {
        gnt.add(0);
        int i = 0;

        int totalBrustTime = 0;

        for (int j = 0; j < n; j++) {
            totalBrustTime += brustTime[j];

        }

        while (true) {

            if (i == n) {
                i = 0;
            }

            if (totalBrustTime == total) {
                break;
            }

            if (brustTime[i] >= timeQuantam) {
                total += timeQuantam;
                gnt.add(total);
                brustTime[i] = brustTime[i] - timeQuantam;
                pro.add("p" + (i + 1));

            } else if (brustTime[i] > 0) {
                total += brustTime[i];
                gnt.add(total);
                brustTime[i] = 0;
                pro.add("p" + (i + 1));

            }
            i++;

        }

        System.out.println("Grantt Chart : ");
        for (String p : pro) {
            System.out.print("|" + p);

        }
        System.out.println("|");

        for (int g : gnt) {
            System.out.print("|" + g);

        }
        System.out.println("|\n\n");

        return 0;

    }

    static int turnAroundTime() {
        int processIndex = 0;
        for (int i = 0; i < n; i++) {
            processIndex = pro.lastIndexOf("p" + (i + 1));
            avgT += gnt.get(processIndex + 1) - 0;
            avgW += gnt.get(processIndex + 1) - 0 - temp[i];
            System.out.println("p" + (i + 1) + " = " + gnt.get(processIndex + 1));

        }
        return avgT;
    }

    static int responseTime() {
        int processIndex = 0;
        for (int i = 0; i < n; i++) {
            processIndex = pro.indexOf("p" + (i + 1));
            avgR += gnt.get(processIndex) - 0;
            System.out.println("p" + (i + 1) + " = " + gnt.get(processIndex));

        }
        return avgR;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of process : ");
        n = input.nextInt();
        brustTime = new int[n];
        temp = new int[n];

        System.out.println("Enter your brust time for each process : ");
        for (int i = 0; i < n; i++) {
            brustTime[i] = input.nextInt();
            temp[i] = brustTime[i];

        }
        System.out.println("Enter time quantam : ");
        timeQuantam = input.nextInt();

        granttChart();

        System.out.println("Avg Turn Around Time : " + (float) turnAroundTime() / n + " ms\n");
        System.out.println("Avg Response Time : " + (float) responseTime() / n + " ms");
        System.out.println("Avg waiting Time : " + (float) avgW / n + " ms");

    }

}
