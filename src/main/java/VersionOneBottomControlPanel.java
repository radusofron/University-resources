import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VersionOneBottomControlPanel extends JPanel {
    final VersionOneFrame versionOneFrame;
    JButton createBtn = new JButton("Create schedule");
    JButton exitBtn = new JButton("Exit");
    VersionOneAlgorithm algorithm;

    public VersionOneBottomControlPanel(VersionOneFrame frameOne) {
        this.versionOneFrame = frameOne;
        initForVersionOne();
    }

    private void initForVersionOne() {
        // GUI settings
        setMinimumSize(new Dimension(700,50));
        setPreferredSize(new Dimension(700,50));
        setMaximumSize(new Dimension(700,50));
        setBounds(50,500, 700, 50);
        setLayout(new GridLayout(1,2));

        add(createBtn);
        add(exitBtn);
        createBtn.addActionListener(this::startAppOne);
        exitBtn.addActionListener(this::exitAppOne);
    }

    private void exitAppOne(ActionEvent event) {
        versionOneFrame.dispose();
    }

    private void startAppOne(ActionEvent event) {
        if(!VersionOneRoomsInputPanel.nextBtn.isEnabled())
        {
            createBtn.setText("Creating schedule...");
            algorithm = new VersionOneAlgorithm();
            algorithm.startAlgorithm();
            createBtn.setEnabled(false);

        }
        else{
            createBtn.setText("Not enough data inserted");
        }
    }
}
