import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainTopPanel extends JPanel {
    final MainFrame frame;
    JButton versionOneBtn;
    JButton versionTwoBtn;

    public MainTopPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init(){
        setLayout(new GridLayout(1,2));

        // style first button
        versionOneBtn = styleLeftBtn();

        //style second button
        versionTwoBtn = styleRightBtn();
        add(versionOneBtn);
        add(versionTwoBtn);
        versionOneBtn.addActionListener(this::startVersionOne);
        versionTwoBtn.addActionListener(this::startVersionTwo);
    }

    private JButton styleLeftBtn() {
        JButton jButton = new JButton("Start Version 1");
        jButton.setBackground(Color.ORANGE);
        jButton.setBorder(createLeftBtnBorder());
        Cursor cursorBtnOne = jButton.getCursor();
        jButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jButton.setFont(new Font("Arial", Font.PLAIN, 25));
        return jButton;
    }

    private JButton styleRightBtn() {
        JButton jButton = new JButton("Start Version 2");
        jButton.setBackground(Color.PINK);
        jButton.setBorder(createRightBtnBorder());
        Cursor cursorBtnOne = jButton.getCursor();
        jButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jButton.setFont(new Font("Arial", Font.PLAIN, 25));
        return jButton;
    }

    private Border createLeftBtnBorder() {
        Border border;
        border = BorderFactory.createMatteBorder( 2,2,2,1, Color.BLACK);
        return border;
    }

    private Border createRightBtnBorder() {
        Border border;
        border = BorderFactory.createMatteBorder( 2,1,2,2, Color.BLACK);
        return border;
    }

    private void startVersionOne(ActionEvent event) {
        versionTwoBtn.setEnabled(false);
        versionOneBtn.setText("Version 1 has been selected");
        FramesController.versionOneSelected = true;
        FramesController.versionTwoSelected = false;
    }

    private void startVersionTwo(ActionEvent event) {
        versionOneBtn.setEnabled(false);
        versionTwoBtn.setText("Version 2 has been selected");
        FramesController.versionOneSelected = false;
        FramesController.versionTwoSelected = true;
    }
}
