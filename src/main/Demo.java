import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Demo extends JFrame {

    private JButton button = new JButton("Click Me!");
    private JButton button2 = new JButton("Apply text");
    private JLabel label = new JLabel("Button wasn't clicked!");
    private JLabel label2 = new JLabel("");
    private JTextField textField = new JTextField();
    private static int count =0;
    
    public Demo() {
        this.getContentPane().setLayout( new GridLayout( 4, 2 ));
        this.getContentPane().add(button);
        this.getContentPane().add(label);
        this.getContentPane().add(textField);
        this.getContentPane().add(button2);
        this.getContentPane().add(label2);

        button.setName("myButton");
        button2.setName("myButton2");
        label.setName("myLabel");
        label2.setName("myLabel2");
        textField.setName("myTextField");

        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                label.setText("Button was clicked! " + ++count);
            }
        });

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label2.setText(textField.getText());
            }
        });

        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {

        new Demo();
    }
}