import javax.swing.*;
import java.awt.*;

public class VersionOneFrame extends JFrame {

    public VersionOneFrame() throws InterruptedException {
        super("University Resources App Version 1");
        init();
    }

    private void init() throws InterruptedException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        // GUI settings
        setLayout(null);
        setMinimumSize(new Dimension(800,600));
        setPreferredSize(new Dimension(800,600));
        setMaximumSize(new Dimension(800,600));
        setBounds(225,50,800,600);

        // create configuration panel
        VersionOneTopConfigPanel configPanel = new VersionOneTopConfigPanel(this);
        add(configPanel);

        // create indications panel
        VersionOneIndicationPanel indicationPanel = new VersionOneIndicationPanel(this);
        add(indicationPanel);

        // create  panel with start & exit buttons
        VersionOneAndTwoBottomControlPanel optionsPanel = new VersionOneAndTwoBottomControlPanel(this);
        add(optionsPanel);

        // invoke the layout manager
        pack();
    }
}
