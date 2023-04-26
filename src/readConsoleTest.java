import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class readConsoleTest extends JFrame
{
    private JTextField textField;
    private boolean clearingText = false;

    public readConsoleTest() {
        JFrame frame = new JFrame("Read Console Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textField = new JTextField(20);
        textField.setFont(new Font("Arial", Font.PLAIN, 24));
        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                handleInput();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                // Not used
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Not used
            }
        });

        frame.getContentPane().add(textField, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    public String handleInput() {
        String input = textField.getText();
        if (input.equals("exit")) {
            System.out.println("Exiting...");
            System.exit(0);
        } else if (!clearingText) {
            SwingUtilities.invokeLater(() -> {
                clearingText = true;
                textField.setText("");
                clearingText = false;
            });
            //System.out.println(input);
            return input;
        }
        
        //Under assumption we never make it here
        return input;
    }

    // public static void main(String[] args) {
    //     SwingUtilities.invokeLater(readConsoleTest::new);
    // }
}



