import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainTopPanel extends JPanel {
    final MainFrame frame;
    JButton versionOneBtn = new JButton("Start Version 1");
    JButton versionTwoBtn = new JButton("Start Version 2");

    public MainTopPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init(){
        setLayout(new GridLayout(1,2));
        add(versionOneBtn);
        add(versionTwoBtn);
        versionOneBtn.addActionListener(this::startVersionOne);
        versionTwoBtn.addActionListener(this::startVersionTwo);
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
