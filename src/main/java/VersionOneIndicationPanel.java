import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class VersionOneIndicationPanel extends JPanel {
    final VersionOneFrame versionOneFrame;
    JLabel indicationNo1;
    JLabel indicationNo2;

    public VersionOneIndicationPanel(VersionOneFrame frameOne){
        this.versionOneFrame = frameOne;
        init();
    }

    private void init(){
        // GUI settings
        setLayout(new GridLayout(2,1));
        setBackground(Color.ORANGE);
        setMinimumSize (new Dimension (700, 50));
        setPreferredSize (new Dimension (700, 50));
        setMaximumSize (new Dimension (700, 50));
        setBounds(50, 40, 700, 50);
        setBorder(createBorder());

        // indications on how to use the app
        indicationNo1 = new JLabel("First, you have to insert the number of rooms.");
        indicationNo2 = new JLabel("Then, you have to insert a name and a capacity for every room.");
        indicationNo1.setHorizontalAlignment(JLabel.CENTER);
        indicationNo2.setHorizontalAlignment(JLabel.CENTER);
        add(indicationNo1);
        add(indicationNo2);
    }

    private Border createBorder() {
        Border border;
        border = BorderFactory.createMatteBorder( 1,2,0,2, Color.BLACK);
        return border;
    }

}
