import javax.swing.*;
import java.awt.*;

public class VersionOneFrame extends JFrame {

    public VersionOneFrame() {
        super("University Resources App Version 1");
        init();
    }

    private void init(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // set the size of the frame
        setPreferredSize(new Dimension(800,600));
    }
}
