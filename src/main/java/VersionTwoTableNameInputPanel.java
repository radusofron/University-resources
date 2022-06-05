import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VersionTwoTableNameInputPanel extends JPanel {
    final VersionTwoFrame versionTwoFrame;
    JLabel label;
    static TextField tableName;
    static String tableNameKeeped;
    static JButton doneBtn;

    public VersionTwoTableNameInputPanel(VersionTwoFrame frameTwo){
        this.versionTwoFrame = frameTwo;
        init();
    }

    private void init(){
        // GUI settings
        setBackground(Color.PINK);
        setMinimumSize (new Dimension (800, 40));
        setPreferredSize (new Dimension (800, 40));
        setMaximumSize (new Dimension (800, 40));
        setBounds(50, 75, 800, 40);
        setBorder(createBorder());

        // create label for indication and a text field for the name of the table
        label = new JLabel("Table name:");
        tableName = new TextField("");
        tableName.setColumns(30);
        tableName.setEnabled(true);
        doneBtn = new JButton("Done");

        add(label);
        add(tableName);
        add(doneBtn);

        doneBtn.addActionListener(this::startInsertRows);
    }

    private Border createBorder() {
        Border border;
        border = BorderFactory.createMatteBorder( 1,2,0,2, Color.BLACK);
        return border;
    }

    private void startInsertRows(ActionEvent event) {
        // table name inserted
        if(!tableName.getText().equals(""))
        {
            tableNameKeeped = tableName.getText();

            // from now on, user starts to write rows
            tableName.setEnabled(false);
            doneBtn.setEnabled(false);
            VersionTwoTeacherSubjectInputPanel.teacherName.setEnabled(true);
            VersionTwoTeacherSubjectInputPanel.subjectName.setEnabled(true);
            VersionTwoIsCourseSerieGroupInputPanel.isCourse.setEnabled(true);
            VersionTwoIsCourseSerieGroupInputPanel.serie.setEnabled(true);
            VersionTwoIsCourseSerieGroupInputPanel.group.setEnabled(true);
            VersionTwoMenuPanel.nextBtn.setEnabled(true);
        }
    }
}
