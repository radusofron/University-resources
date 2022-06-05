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

        // create table name panel
        VersionTwoTableNameInputPanel tableNameInputPanel = new VersionTwoTableNameInputPanel(this);
        add(tableNameInputPanel);

        // create input panel containing teacher's name and name of the subject
        VersionTwoTeacherSubjectInputPanel teachersInputPanel = new VersionTwoTeacherSubjectInputPanel(this);
        add(teachersInputPanel);

        // create input panel containing if is a course, serie and group
        VersionTwoIsCourseSerieGroupInputPanel subjectsInputPanel = new VersionTwoIsCourseSerieGroupInputPanel(this);
        add(subjectsInputPanel);

        // create menu
        VersionTwoMenuPanel versionTwoMenuPanel = new VersionTwoMenuPanel(this);
        add(versionTwoMenuPanel);

        // create output panel
        VersionTwoScheduleOutputPanel versionTwoScheduleOutputPanel = new VersionTwoScheduleOutputPanel(this);
        add(versionTwoScheduleOutputPanel);

        // create  panel with create schedule & exit buttons
        VersionTwoBottomControlPanel optionsPanel = new VersionTwoBottomControlPanel(this);
        add(optionsPanel);
    }
}
