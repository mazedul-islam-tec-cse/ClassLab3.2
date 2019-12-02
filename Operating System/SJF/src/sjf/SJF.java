/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sjf;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class SJF {

    int[] brustTime;
    int[] arrivalTime;
    String[] process;
    Scanner input = new Scanner(System.in);
    int n, temp, total = 0;
    ArrayList<Integer> grantt = new ArrayList<>();

    void GratntChat() {
        System.out.println("Enter your number of process : ");
        n = input.nextInt();

        brustTime = new int[n];
        arrivalTime = new int[n];;
        process = new String[n];

        System.out.println("Enter your arrival time and brust time for each peocess : ");

        for (int i = 0; i < n; i++) {
            arrivalTime[i] = input.nextInt();
            brustTime[i] = input.nextInt();
            process[i] = "p" + i;

        }

        try {

            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < (n - i - 1); ++j) {

                    if (brustTime[j] > brustTime[j + 1]) {
                        temp = brustTime[j];
                        brustTime[j] = brustTime[j + 1];
                        brustTime[j + 1] = temp;

                        temp = arrivalTime[i];
                        arrivalTime[j] = arrivalTime[j + 1];
                        arrivalTime[j + 1] = temp;

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
        System.out.println("Grantt Chart : ");
        for (int i = 0; i < n; i++) {
            System.out.print(" "+process[i]);
            
        }
        System.out.println("");
        for (int g : grantt) {
            System.out.print(g + " ");

        }

    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        SJF ob = new SJF();
        ob.GratntChat();

    }

}
