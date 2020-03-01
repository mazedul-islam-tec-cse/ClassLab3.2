/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package priority;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class PriorityNOnP {

    int[] brustTime;
    int[] priority;
    String[] process;
    Scanner input = new Scanner(System.in);
    int n, temp, total = 0;
    ArrayList<Integer> grantt = new ArrayList<>();

    void GratntChat() {
        System.out.println("Enter your number of process : ");
        n = input.nextInt();

        brustTime = new int[n];
        priority = new int[n];;
        process = new String[n];

        System.out.println("Enter brust time and priority for each peocess : ");

        for (int i = 0; i < n; i++) {
            brustTime[i] = input.nextInt();
            priority[i] = input.nextInt();

            process[i] = "p" + i;

        }

        try {

            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < (n - i - 1); ++j) {

                    if (priority[j] > priority[j + 1]) {
                        temp = priority[j];
                        priority[j] = priority[j + 1];
                        priority[j + 1] = temp;

                        temp = brustTime[j];
                        brustTime[j] = brustTime[j + 1];
                        brustTime[j + 1] = temp;

                        String temp1 = " ";
                        temp1 = process[j];
                        process[j] = process[j + 1];
                        process[j + 1] = temp1;

                    }
                }

            }
        } catch (Exception e) {

        }
        grantt.add(0);
        for (int i = 0; i < n; i++) {

            total += brustTime[i];
            grantt.add(total);

        }
        System.out.println("\nGrantt Chart : ");
        for (int i = 0; i < n; i++) {
            System.out.print(" " + process[i]);

        }
        System.out.println("");
        for (int g : grantt) {
            System.out.print(g + " ");

        }

    }
    
    void waitTime(){
        float avgWait = 0;
        for (int i = 0; i < n; i++) {
            avgWait += grantt.get(i) - 0;
            
        }
        System.out.println("\n\nAvg Waiting Time : "+(float)avgWait/n);
    }
    
    void turnAroundTime(){
        float avgT = 0;
        for (int i = 0; i < n; i++) {
            avgT += grantt.get(i+1) - 0;
            
        }
        System.out.println("Avg Turn Around Time : "+(float)avgT/n);
    }
    
    void responseTime(){
        float avgRes = 0;
        for (int i = 0; i < n; i++) {
            avgRes += grantt.get(i) - 0;
            
        }
        System.out.println("Avg Response Time : "+(float)avgRes/n);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        PriorityNOnP ob = new PriorityNOnP();
        ob.GratntChat();  
        ob.waitTime();
        ob.turnAroundTime();
        ob.responseTime();

    }

}
