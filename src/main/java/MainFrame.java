import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        super("University Resources Setup");
        init();
    }

    private void init(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // set the size of the frame
        setPreferredSize(new Dimension(800,600));

        // create a panel with 2 buttons, one for every version of the application
        MainTopPanel versionsPanel = new MainTopPanel(this);
        versionsPanel.setPreferredSize(new Dimension(400, 200));
        add(versionsPanel, BorderLayout.NORTH);

        // create 2 text boxes with explanations for those 2 version of the app
        MainMiddlePanel infoPanel = new MainMiddlePanel(this);
        add(infoPanel, BorderLayout.CENTER);

        // invoke the layout manager
        pack();
    }
}
