import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MainMiddlePanel extends JPanel {
    final MainFrame frame;
    JLabel leftTextBox = new JLabel("<html>* If you click on START VERSION 1, you have to enter just the rooms as input. <br><br>* A schedule will be created; it will use the minimum number of rooms in order to be created.</html>");
    JLabel rightTextBox = new JLabel("<html>* If you click on START VERSION 2, you have to all the necessary data as input. <br><br>* A schedule (without rooms) will be created according to the data which you have enetered.</html>");
    public MainMiddlePanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        setLayout(new GridLayout(1,2));
        leftTextBox.setBorder(createRightBorder());
        leftTextBox.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(leftTextBox);
        rightTextBox.setBorder(createLeftBorder());
        rightTextBox.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(rightTextBox);
    }

    private Border createRightBorder() {
        Border border;
        border = BorderFactory.createMatteBorder( 0,0,0,1, Color.BLACK);
        return border;
    }

    private Border createLeftBorder() {
        Border border;
        border = BorderFactory.createMatteBorder( 0,1,0,0, Color.BLACK);
        return border;
    }
}
