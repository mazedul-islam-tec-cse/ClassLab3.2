/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineclipping;

/**
 *
 * @ M A Mazedul Islam
 */
import java.applet.*;
import java.awt.*;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LineClipper extends JFrame {

    static Scanner sc = new Scanner(System.in);
    static int xmax, ymax, xmin, ymin;

    public LineClipper() {
        setSize(600, 600);
    }

    public int[] set(int x, int y) {
        int a[] = new int[4];
        if (x < xmin) {
            a[3] = 1;
        } else {
            a[3] = 0;
        }
        if (x > xmax) {
            a[2] = 1;
        } else {
            a[2] = 0;
        }
        if (y < ymin) {
            a[0] = 1;
        } else {
            a[0] = 0;
        }
        if (y > ymax) {
            a[1] = 1;
        } else {
            a[1] = 0;
        }
        return a;
    }

    boolean check(int a[]) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1) {
                return false;
            }
        }
        return true;
    }

    int[] produceXY(int i, int x1, int y1, float m) {
        int a[] = new int[2];
        float x = 0, y = 0;
        switch (i) {
            case 0:
                x = xmin;
                y = y1 + m * (x - x1);
                break;

            case 1:
                x = xmax;
                y = y1 + m * (x - x1);
                break;
            case 3:
                y = ymin;
                x = x1 + (y - y1) / m;
                break;
            case 2:
                y = ymax;
                x = x1 + (y - y1) / m;
                break;
        }
        a[0] = (int) x;
        a[1] = (int) y;
        return a;
    }

    boolean doAnd(int a[], int b[]) {
        for (int i = 0; i < a.length; i++) {
            int k = a[i] & b[i];
            if (k == 1) {
                return false;
            }
        }
        return true;
    }

    public void paint(Graphics g) {
        
        g.setColor(Color.black);
//        g.drawString("Fig-1 : Before clipping ", xmin, ymax + 20);
//        g.drawString("Fig-2 : After clipping ", xmin + 300, ymax + 20);
        g.setColor(Color.BLUE);
        g.drawRect(xmin, ymin, xmax - xmin, ymax - ymin);

        g.setColor(Color.RED);
        g.drawRect(xmin + 300, ymin, xmax - xmin, ymax - ymin);

        int a[][] = new int[2][4];
        int b[][] = new int[2][4];
        int c[] = new int[2];
        int c1 = 20;
        int x1, y1, x2, y2;
        System.out.println("Enter x1 of the line");
        String tm = JOptionPane.showInputDialog("Enter x1 of the line");
        x1 = Integer.parseInt(tm.toString());

        tm = JOptionPane.showInputDialog("Enter y1 of the line");
        y1 = Integer.parseInt(tm.toString());

        tm = JOptionPane.showInputDialog("Enter x2 of the line");
        x2 = Integer.parseInt(tm.toString());

        tm = JOptionPane.showInputDialog("Enter y2 of the line");
        y2 = Integer.parseInt(tm.toString());

        float m = (y2 - y1) * 1.0f / (x2 - x1);

        g.setColor(Color.GREEN);
        g.drawLine(x1, y1, x2, y2);
        a[0] = set(x1, y1);
        a[1] = set(x2, y2);
        if (check(a[0]) && check(a[1])) {
            g.drawLine(x1, y1, x2, y2);
        } else {
            if (doAnd(a[0], b[1])) {
                for (int i = a[0].length - 1; i >= 0; i--) {
                    if (a[0][i] == 1) {
                        c = produceXY(a[0].length - 1 - i, x1, y1, m);
                        b[0] = set(c[0], c[1]);

                        if (check(b[0])) {
                            x1 = c[0];
                            y1 = c[1];
                            break;
                        }
                        c1 += 20;
                    }
                }
                for (int i = a[0].length - 1; i >= 0; i--) {
                    if (a[1][i] == 1) {
                        c = produceXY(a[0].length - 1 - i, x1, y1, m);
                        b[1] = set(c[0], c[1]);

                        if (check(b[1])) {
                            x2 = c[0];
                            y2 = c[1];
                            break;
                        }
                        c1 += 20;
                    }
                }
                g.setColor(Color.BLUE);
                g.drawLine(x1 + 300, y1, x2 + 300, y2);
            }
        }
    }

    public static void main(String[] args) {

        String tm = JOptionPane.showInputDialog("Enter xmax of the Rectangle");
        xmax = Integer.parseInt(tm.toString());

        tm = JOptionPane.showInputDialog("Enter ymax of the Rectangle");
        ymax = Integer.parseInt(tm.toString());

        tm = JOptionPane.showInputDialog("Enter xmin of the Rectangle");
        xmin = Integer.parseInt(tm.toString());

        tm = JOptionPane.showInputDialog("Enter ymin of the Rectangle");
        ymin = Integer.parseInt(tm.toString());

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LineClipper ob = new LineClipper();
                ob.setVisible(true);
                ob.paint(null);
            }
        });
    }
}
/*

 200
 300
 50
 50
 10
 70
 250
 260
 */
