package SIMS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginUI {
    private JPanel jp1;
    private JLabel jl1;
    private JLabel jl2;
    private JButton jb1;
    private JTextField jtf1;
    private JPasswordField jpf1;

    public loginUI() {
        init();
    }

    public void init() {
        // create window
        JFrame jf = new JFrame();
        // create panel
        jp1 = new JPanel();
        // create label
        jl1 = new JLabel("Account:");
        jl2 = new JLabel("Password:");
        // create text field, during create will write length of String
        jtf1 = new JTextField(15);
        jpf1 = new JPasswordField(15);
        // create button
        jb1 = new JButton("Login");

        jb1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if(jtf1.getText().equals("baizeyv")&&String.valueOf(jpf1.getPassword()).equals("fahaxiki")){
                // close the login window
                jf.dispose();
                new userUI();
                }
                if(!(jtf1.getText().equals("baizeyv")) || !(String.valueOf(jpf1.getPassword()).equals("fahaxiki"))){
                JOptionPane.showMessageDialog(null, "Input Error, Please Try Again!");
                // reset the text field
                jtf1.setText("");
                jpf1.setText("");
                }
            }
        });

        // begin 
        jp1.add(jl1);
        jp1.add(jtf1);
        jp1.add(jl2);
        jp1.add(jpf1);
        jp1.add(jb1);
        // set property of the window
        jf.add(jp1);
        jf.setBounds(880, 450, 220, 130);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setTitle("LOGIN");
        jf.setResizable(true);

    }

    // public static void main(String[] args)
    // {
    //     loginUI lui = new loginUI();
    // }
}
