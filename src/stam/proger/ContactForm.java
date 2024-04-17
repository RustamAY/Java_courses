package stam.proger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactForm extends JFrame {

    JTextField name_field, email_field;
    JRadioButton male, female;
    JCheckBox check;

    public ContactForm(){
        super("Contact form");
        super.setBounds(200, 100, 300, 230);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = super.getContentPane();
        container.setLayout(new GridLayout(5, 2, 2 ,10));

        JLabel name = new JLabel("Enter the name:");
        name_field = new JTextField("",1);
        JLabel email = new JLabel("Enter the e-mail:");
        email_field = new JTextField("@",1);

        container.add(name);
        container.add(name_field);
        container.add(email);
        container.add(email_field);

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        check = new JCheckBox("Agre?", false);
        JButton send_button = new JButton("Send");

        male.setSelected(true);
        container.add(male);
        container.add(female);

        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);

        container.add(check);
        container.add(send_button);

        send_button.addActionListener(new ButtonEventManager());
    }

    class ButtonEventManager implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = name_field.getText();
            String email = email_field.getText();

            String isMale = "Male";
            if (!male.isSelected())
                isMale = "Female";

            boolean checkBox = check.isSelected();

            JOptionPane.showMessageDialog(null, "Yur e-mail: " + email +
                    "\nYour sex: " + isMale + "\nAre you agree? " + checkBox, "Hello" + name, JOptionPane.PLAIN_MESSAGE);
        }
    }

}
