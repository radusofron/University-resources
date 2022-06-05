import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VersionTwoBottomControlPanel extends JPanel {
    final VersionTwoFrame versionTwoFrame;
    static JButton createBtn = new JButton("Create schedule");
    JButton exitBtn = new JButton("Exit");
    VersionOneAlgorithm algorithm;

    public VersionTwoBottomControlPanel(VersionTwoFrame frameTwo) {
        this.versionTwoFrame = frameTwo;
        initForVersionOne();
    }

    private void initForVersionOne() {
        // GUI settings
        setMinimumSize(new Dimension(800,50));
        setPreferredSize(new Dimension(800,50));
        setMaximumSize(new Dimension(800,50));
        setBounds(50,510, 800, 50);
        setLayout(new GridLayout(1,2));

        createBtn.setEnabled(false);
        add(createBtn);
        add(exitBtn);
        createBtn.addActionListener(this::startAppTwo);
        exitBtn.addActionListener(this::exitAppTwo);
    }

    private void exitAppTwo(ActionEvent event) {
        versionTwoFrame.dispose();
    }

    private void startAppTwo(ActionEvent event) {
        createBtn.setEnabled(false);
        createBtn.setText("Creating schedule...");

        /* display rows to see if it's all okay */
        for(int index = 0; index < VersionTwoMenuPanel.counterForRows; index++)
            System.out.println(VersionTwoMenuPanel.rows.get(index).toString());


    }
}
