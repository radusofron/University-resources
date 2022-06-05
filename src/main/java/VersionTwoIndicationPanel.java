import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class VersionTwoIndicationPanel extends JPanel {
    final VersionTwoFrame versionTwoFrame;
    JLabel indicationNo1;
    JLabel indicationNo2;
    static JLabel indicationNo3;

    public VersionTwoIndicationPanel(VersionTwoFrame frameTwo){
        this.versionTwoFrame = frameTwo;
        init();
    }

    private void init(){
        // GUI settings
        setLayout(new GridLayout(3,1));
        setBackground(Color.PINK);
        setMinimumSize (new Dimension (800, 75));
        setPreferredSize (new Dimension (800, 75));
        setMaximumSize (new Dimension (800, 75));
        setBounds(50, 0, 800, 75);
        setBorder(createBorder());

        // indications on how to use the app
        indicationNo1 = new JLabel("1) You have to insert a teacher and its number of subjects which he/she teaches.");
        indicationNo2 = new JLabel("2) Then, you have to insert a name for every subject which he/she teaches and how many classes he/she has for it.");
        indicationNo3 = new JLabel("3) The process is the same for every teacher untill you click Finish. Finally, the schedule will be displayed in the white box down below.");
        indicationNo1.setHorizontalAlignment(JLabel.CENTER);
        indicationNo2.setHorizontalAlignment(JLabel.CENTER);
        indicationNo3.setHorizontalAlignment(JLabel.CENTER);

        add(indicationNo1);
        add(indicationNo2);
        add(indicationNo3);
    }

    private Border createBorder() {
        Border border;
        border = BorderFactory.createMatteBorder( 2,2,0,2, Color.BLACK);
        return border;
    }
}
