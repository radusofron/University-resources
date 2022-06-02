import javax.swing.*;
import java.awt.*;

public class VersionTwoFrame extends JFrame {

    public VersionTwoFrame() {
        super("University Resources App Version 2");
        init();
    }

    private void init(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        // set the size of the frame
        setPreferredSize(new Dimension(800,600));

        // create  panel with start & exit buttons
        VersionOneAndTwoBottomControlPanel optionsPanel = new VersionOneAndTwoBottomControlPanel(this);
        add(optionsPanel, BorderLayout.SOUTH);
    }
}
