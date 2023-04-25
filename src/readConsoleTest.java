import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class readConsoleTest extends JFrame
{

    //! Can't find easy way to get immediate input while testing in VSCode (IDE's) which could mean that it only doesn't work within IDE
    
    //Todo Figure out how to get terminal to immediately read input

                                //Or
                                
    //Todo Figure out how to get Swing Working 

    



    //!This is Swing Working to get an input
   
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

    private void handleInput() {
        String input = textField.getText();
        if (input.equals("exit")) {
            System.out.println("Exiting...");
            System.exit(0);
        } else if (!clearingText) {
            System.out.println("Input was: " + input);
        }
        SwingUtilities.invokeLater(() -> {
            clearingText = true;
            textField.setText("");
            clearingText = false;
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(readConsoleTest::new);
    }
}



