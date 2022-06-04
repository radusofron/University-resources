import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class VersionOneScheduleOutputPanel extends JPanel{
    final VersionOneFrame versionOneFrame;
    JScrollPane scrollPane;
    static JLabel label;

    public VersionOneScheduleOutputPanel(VersionOneFrame frameOne){
        this.versionOneFrame = frameOne;
        init();
    }

    private void init(){
        // GUI settings
        setBackground(Color.GRAY);
        setMinimumSize (new Dimension(700, 370));
        setPreferredSize (new Dimension (700, 370));
        setMaximumSize (new Dimension (700, 370));
        setBounds(50, 130, 700, 370);
        setBorder(createBorder());

        // add JScrollPane for the panel
        label = new JLabel("The output should be right hereeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
        scrollPane = new JScrollPane(label);
        scrollPane.setMinimumSize(new Dimension(650, 355));
        scrollPane.setPreferredSize(new Dimension(650, 355));
        scrollPane.setMaximumSize(new Dimension(650, 355));
        scrollPane.setBounds(75, 140, 650, 355);
        add(scrollPane);
    }

    private Border createBorder() {
        Border border;
        border = BorderFactory.createMatteBorder( 2,2,2,2, Color.BLACK);
        return border;
    }
}
