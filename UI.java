import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI implements ActionListener{

    private double operand1 = 0;
    private double operand2 = 0;
    private String operator = "";

    JTextField textField;
    JFrame frame;
    JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, badd, bsub, bmult, bdiv, beq, bdec, bdel, bclr;

    public UI(){
        //For Frame
        frame = new JFrame();
        frame.setTitle("Calculator");
        frame.setBounds(20, 20, 290, 370);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //For Font
        Font font = new Font("Arial", Font.BOLD, 20);

        //For Text box
        textField = new JTextField();
        textField.setFont(font);
        textField.setBackground(Color.WHITE);
        textField.setBounds(5, 5, 265, 50);
        frame.add(textField);


        
        
        
        b0 = new JButton("0");
        b0.setFont(font);
        b1 = new JButton("1");
        b1.setFont(font);
        b2 = new JButton("2");
        b2.setFont(font);
        b3 = new JButton("3");
        b3.setFont(font);
        b4 = new JButton("4");
        b4.setFont(font);
        b5 = new JButton("5");
        b5.setFont(font);
        b6 = new JButton("6");
        b6.setFont(font);
        b7 = new JButton("7");
        b7.setFont(font);
        b8 = new JButton("8");
        b8.setFont(font);
        b9 = new JButton("9");
        b9.setFont(font);
        badd = new JButton("+");
        badd.setFont(font);
        bsub = new JButton("-");
        bsub.setFont(font);
        bmult = new JButton("*");
        bmult.setFont(font);
        bdiv = new JButton("/");
        bdiv.setFont(font);
        beq = new JButton("=");
        beq.setFont(font);
        bdec = new JButton(".");
        bdec.setFont(font);
        bdel = new JButton("D");
        bdel.setFont(font);
        bclr = new JButton("C");
        bclr.setFont(font);
    //

        //First Row
        bdel.setBounds(203, 70, 65, 50);
        bclr.setBounds(138, 70, 65, 50);

        //Second Row
        bmult.setBounds(203, 120, 65, 50);
        b9.setBounds(138, 120, 65, 50);
        b8.setBounds(73, 120, 65, 50);
        b7.setBounds(8, 120, 65, 50);

        //Thrid Row
        badd.setBounds(203, 170, 65, 50);
        b6.setBounds(138, 170, 65, 50);
        b5.setBounds(73, 170, 65, 50);
        b4.setBounds(8, 170, 65, 50);

        //Fourth Row
        bsub.setBounds(203, 220, 65, 50);
        b3.setBounds(138, 220, 65, 50);
        b2.setBounds(73, 220, 65, 50);
        b1.setBounds(8, 220, 65, 50);

        //Fifth Row
        bdiv.setBounds(203, 270, 65, 50);
        beq.setBounds(138, 270, 65, 50);
        b0.setBounds(73, 270, 65, 50);
        bdec.setBounds(8, 270, 65, 50);



        


        frame.add(b0);
        frame.add(b1);
        frame.add(b2);
        frame.add(b3);
        frame.add(b4);
        frame.add(b5);
        frame.add(b6);
        frame.add(b7);
        frame.add(b8);
        frame.add(b9);
        frame.add(badd);
        frame.add(bsub);
        frame.add(bmult);
        frame.add(bdiv);
        frame.add(beq);
        frame.add(bdec);
        frame.add(bdel);
        frame.add(bclr);

        
        b0.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        badd.addActionListener(this);
        bsub.addActionListener(this);
        bmult.addActionListener(this);
        bdiv.addActionListener(this);
        beq.addActionListener(this);
        bdec.addActionListener(this);
        bdel.addActionListener(this);
        bclr.addActionListener(this);
    

        ImageIcon image = new ImageIcon("calculator.png");
        frame.setIconImage(image.getImage());
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new UI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    if (e.getSource() == bclr)
    {
        textField.setText("");
    }
    if (e.getSource() == bdel)
    {
        String text = textField.getText();
        textField.setText("");
        for(int i=0; i<text.length()-1; i++)
        {
            textField.setText(textField.getText()+text.charAt(i));
        }

    }
    if (e.getSource() == b0 || e.getSource() == b1 || e.getSource() == b2 ||
        e.getSource() == b3 || e.getSource() == b4 || e.getSource() == b5 ||
        e.getSource() == b6 || e.getSource() == b7 || e.getSource() == b8 ||
        e.getSource() == b9 || e.getSource() == bdec) {
        // Handle numeric and decimal buttons
        textField.setText(textField.getText().concat(((JButton) e.getSource()).getText()));
    }

    if (e.getSource() == badd || e.getSource() == bsub ||
        e.getSource() == bmult || e.getSource() == bdiv) {
        // Handle operator buttons
        if (!textField.getText().isEmpty()) {
            operator = ((JButton) e.getSource()).getText();
            operand1 = Double.parseDouble(textField.getText());
            textField.setText(textField.getText() + " " + operator + " ");  // Display the operator
        }
    } 

    if (e.getSource() == beq) {
        // Handle equals button
        if (!textField.getText().isEmpty()) {
            String[] tokens = textField.getText().split(" ");
            if (tokens.length == 3) {
                operand2 = Double.parseDouble(tokens[2]);
                textField.setText(textField.getText() + " = ");
            }
        }
    }
}




}