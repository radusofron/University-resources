import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class VersionOneIndicationPanel extends JPanel {
    final VersionOneFrame versionOneFrame;
    JLabel indicationNo1;
    JLabel indicationNo2;
    static JLabel indicationNo3;

    public VersionOneIndicationPanel(VersionOneFrame frameOne){
        this.versionOneFrame = frameOne;
        init();
    }

    private void init(){
        // GUI settings
        setLayout(new GridLayout(3,1));
        setBackground(Color.ORANGE);
        setMinimumSize (new Dimension (700, 75));
        setPreferredSize (new Dimension (700, 75));
        setMaximumSize (new Dimension (700, 75));
        setBounds(50, 0, 700, 75);
        setBorder(createBorder());

        // indications on how to use the app
        indicationNo1 = new JLabel("1) First, you have to insert the number of rooms.");
        indicationNo2 = new JLabel("2) Then, you have to insert a name and a capacity for every room.");
        indicationNo3 = new JLabel("3) The schedule will be displayed in the white box down below.");
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
