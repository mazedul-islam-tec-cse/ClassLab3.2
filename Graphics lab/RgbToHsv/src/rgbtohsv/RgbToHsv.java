/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rgbtohsv;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class RgbToHsv {

    /**
     * @param args the command line arguments
     */
    static void convRgbToHsv(int r, int g, int b) {
        double h = -1,s = -1,v = -1;
        double R = r / 255.0;
        double G = g / 255.0;
        double B = b / 255.0;
        
        double cmax = Math.max(B,Math.max(R,G));
        double cmin = Math.min(B,Math.min(R,G));
        
        double df = cmax - cmin;
        
        
        if(cmax == 0 &&  cmin == 0){
            h = 0;
        }
        
        else if(cmax == R){
           h = (60 * ((G - B) / df) + 360) % 360; 
        }
        else if(cmax == G){
            h = (60 * ((B - R) / df) + 120) % 360;
        }
        else if(cmax == R){
             h = (60 * ((R - G) / df) + 240) % 360; 
        }
        
        if (cmax == 0) 
            s = 0; 
        else if(cmax != 0){
             s = (df/cmax)*100;
        }
        
        v =  cmax * 100; 
        
        System.out.println("The corresponding HSV color code : "+h+"  "+s+" , "+v);
    }

    public static void main(String[] args) {
        // TODO code application logic here
        int r, g, b;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the RGB color code : ");
        r = input.nextInt();
        g = input.nextInt();
        b = input.nextInt();
        convRgbToHsv(r, g, b);

    }

}
