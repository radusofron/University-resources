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

        // GUI settings
        setLayout(null);
        setMinimumSize(new Dimension(900,600));
        setPreferredSize(new Dimension(900,600));
        setMaximumSize(new Dimension(900,600));
        setBounds(225,50,900,600);

        // create indications panel
        VersionTwoIndicationPanel indicationPanel = new VersionTwoIndicationPanel(this);
        add(indicationPanel);

        // create input panel for teachers
        VersionTwoTeachersInputPanel teachersInputPanel = new VersionTwoTeachersInputPanel(this);
        add(teachersInputPanel);

        // create input panel for teachers' subjects
        VersionTwoSubjectsInputPanel subjectsInputPanel = new VersionTwoSubjectsInputPanel(this);
        add(subjectsInputPanel);

        // create  panel with create schedule & exit buttons
        VersionOneAndTwoBottomControlPanel optionsPanel = new VersionOneAndTwoBottomControlPanel(this);
        add(optionsPanel);
    }
}
