pakage guipractice;
import java.awt.*;
import java.awt.event.*;
class EventHandling Extends Frame implements ActionListener{
    TextField tf;
    EventHandling() {
        addWindowListener(new WindowAdaptew()){
            public void windowClosing(WindowEvent e) {
                dispose(0);
            }
                
            }
        }
    }
} 
tf=new TextField();
tf.setBounds(60,50,170,20);
Button b=new button("click mw");
b.setBounds(100,120,80,30);
b.addActionListener(this);
add(b);add(tf);
         
        setSize(400,400);  
        setLayout(null);  
        setVisible(true);  
    }  
public static void main(String[] args) {  
    new WindowExample();  
} 
public static void main(String args[]) {
     new EventHandling();
     
}