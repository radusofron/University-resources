import javax.swing.*;
import java.awt.*;

public class VersionOneFrame extends JFrame {

    public VersionOneFrame() throws InterruptedException {
        super("University Resources App Version 1");
        init();
    }

    private void init() throws InterruptedException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // set the size of the frame
        setPreferredSize(new Dimension(800,600));

        // create configuration panel
        VersionOneConfigPanel configPanel = new VersionOneConfigPanel(this);
        add(configPanel, BorderLayout.NORTH);

        // create  panel with start & exit buttons
        VersionOneAndTwoBottomControlPanel optionsPanel = new VersionOneAndTwoBottomControlPanel(this);
        add(optionsPanel, BorderLayout.SOUTH);
    }
}
