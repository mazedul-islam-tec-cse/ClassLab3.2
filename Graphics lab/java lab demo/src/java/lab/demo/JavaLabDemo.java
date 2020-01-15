
 
package java.lab.demo;

/**
 *
 * @author user
 */
import java.awt.*;  
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;  
public class JavaLabDemo extends Frame{  
   JavaLabDemo(){  
        addWindowListener(new WindowAdapter(){  
            public void windowClosing(WindowEvent e) {  
                dispose();  
            }  
        });  
        setSize(400,400);  
        setLayout(null);  
        setVisible(true);  
    }  
public static void main(String[] args) {  
  new JavaLabDemo();  
}
}
