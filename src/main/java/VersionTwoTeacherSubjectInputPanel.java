import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class VersionTwoTeacherSubjectInputPanel extends JPanel {
    final VersionTwoFrame versionTwoFrame;
    JLabel teacherLabel;
    static TextField teacherName;
    JLabel subjectLabel;
    static TextField subjectName;
    Row teacher;

    public VersionTwoTeacherSubjectInputPanel(VersionTwoFrame frameTwo){
        this.versionTwoFrame = frameTwo;
        init();
    }

    private void init(){
        // GUI settings
        setBackground(Color.PINK);
        setMinimumSize (new Dimension (800, 40));
        setPreferredSize (new Dimension (800, 40));
        setMaximumSize (new Dimension (800, 40));
        setBounds(50,115,800,40);
        setBorder(createBorder());

        // create label for teacher name, text field for teacher name, label for teacher's no of subjects & spinner for it, "next" & "done" button
        teacherLabel = new JLabel("Teacher:");
        teacherName = new TextField("");
        teacherName.setColumns(20);
        teacherName.setEnabled(false);
        subjectLabel = new JLabel("Subject:");
        subjectName = new TextField("");
        subjectName.setColumns(20);
        subjectName.setEnabled(false);

        add(teacherLabel);
        add(teacherName);
        add(subjectLabel);
        add(subjectName);
    }

    private Border createBorder() {
        Border border;
        border = BorderFactory.createMatteBorder( 1,2,0,2, Color.BLACK);
        return border;
    }

}
