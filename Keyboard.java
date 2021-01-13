import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
public class Keyboard extends JFrame{
    private Container cp;
    private JButton Buttons[] = new JButton[49];
    private JLabel jlb = new JLabel("");
    private JPanel jpn = new JPanel(new GridLayout(7, 7)); // 26 + 12  + 10
    private JPanel jpn1 = new JPanel(new GridLayout(1, 3,3,3));
    private JButton jbtn_EXIT = new JButton("EXIT");
    private JButton jbtn_Shift = new JButton("shift");
    private JButton jbtn_enter = new JButton("enter");
    Random rand = new Random();
    int array[] = new int [123];
    boolean bool = false;

    public Keyboard(){
        init();
    }

    private void init(){
        for(int i=0;i<123;i++){
            array[i] = 0;
        }
        this.setBounds(100,150,1000,400);
        cp = this.getContentPane();
        this.setLayout(null);
        cp.setLayout(new BorderLayout(3,3));
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jlb.setForeground(Color.GREEN);
        jlb.setOpaque(true);
        jlb.setBackground(Color.BLUE); 
        jlb.setSize(1000,50);
        cp.add(jlb,BorderLayout.NORTH);
        jpn1.add(jbtn_Shift);
        jpn1.add(jbtn_EXIT);
        jpn1.add(jbtn_enter);
        cp.add(jpn1,BorderLayout.SOUTH);

        jbtn_EXIT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {   
                Keyboard.this.dispose();
            }
        });

        jbtn_enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {   
                Login.jpf.setText(jlb.getText());
                Keyboard.this.dispose();
            }
        });

        jbtn_Shift.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {   
               bool = true;
            }
        });
        
        for(int i=0;i<48;i++){
            
            int type = rand.nextInt(123);
            if(!(((type>=33 && type<=43) || (type>=47 && type<=57) || (type>=97 && type<=122))&& array[type] == 0)){
                i--;
            }else{
                array[type] = 1;
                if((type>=97 && type<=122 )&& bool == true){
                    type -= 32;
                    bool = false;
                }
                Buttons[i] = new JButton(String.valueOf((char)type));
                jpn.add(Buttons[i]);
                
                
            }
        }

        for(int i=0;i<48;i++){
            Buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {   
                    JButton typejbtn = (JButton) e.getSource();
                    jlb.setText(jlb.getText() + typejbtn.getText());
                }
            });
        }
        
        cp.add(jpn,BorderLayout.CENTER);
        
    }
}