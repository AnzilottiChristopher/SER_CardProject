import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class GUI_Input extends JFrame
{
    private JTextField textField;
    private boolean clearingText = false;

    public GUI_Input() {

        //Most of this class was made possible because of online resources

        //Creates a jframe
        JFrame frame = new JFrame("Read Console Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Setting the text fields and font/size
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

        //Adding the pane to the field and setting visibilty to true
        frame.getContentPane().add(textField, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    //This function takes what the user inputs, returns it, and clears it immediately
    public String handleInput() {
        String input = textField.getText();
        if (input.equals("exit")) {
            System.out.println("Exiting...");
            System.exit(0);
        } else if (!clearingText) {
            SwingUtilities.invokeLater(() -> {
                clearingText = true;
                // Clearing the textField
                textField.setText("");
                clearingText = false;
            });
                return input;
            
            
        }
        // This returns a blank input if necessary
        return input;
    }
    
    // Function to clear the text field if necessary
    public void clearText(){
        textField.setText("");
    }
}



