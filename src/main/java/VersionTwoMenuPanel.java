import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class VersionTwoMenuPanel extends JPanel {
    final VersionTwoFrame versionTwoFrame;
    static JButton nextBtn;
    static JButton doneBtn;
    Row row;
    static int counterForRows = 0;
    static ArrayList<Row> rows = new ArrayList<>();

    public VersionTwoMenuPanel(VersionTwoFrame versionTwo){
        this.versionTwoFrame = versionTwo;
        init();
    }

    private void init() {
        // GUI settings
        setBackground(Color.PINK);
        setMinimumSize (new Dimension (800, 40));
        setPreferredSize (new Dimension (800, 40));
        setMaximumSize (new Dimension (800, 40));
        setBounds(50, 195, 800, 40);
        setBorder(createBorder());

        // create next teacher button & finish button
        nextBtn = new JButton("Next row");
        nextBtn.setEnabled(false);
        doneBtn = new JButton("Finish");
        doneBtn.setEnabled(false);

        add(nextBtn);
        add(doneBtn);

        nextBtn.addActionListener(this::nextRow);
        doneBtn.addActionListener(this::stopInsert);
    }

    private Border createBorder() {
        Border border;
        border = BorderFactory.createMatteBorder( 1,2,0,2, Color.BLACK);
        return border;
    }

    private void nextRow(ActionEvent event) {
        if(!VersionTwoTeacherSubjectInputPanel.teacherName.getText().equals("") &&
                !VersionTwoTeacherSubjectInputPanel.subjectName.getText().equals("") &&
                !VersionTwoIsCourseSerieGroupInputPanel.serie.getText().equals("") &&
                !VersionTwoIsCourseSerieGroupInputPanel.group.getText().equals(""))
        {
            // create a new instance for Row class and initalise it
            row = new Row();
            row.setTeacher(VersionTwoTeacherSubjectInputPanel.teacherName.getText());
            row.setSubject(VersionTwoTeacherSubjectInputPanel.subjectName.getText());
            if(VersionTwoIsCourseSerieGroupInputPanel.isCourse.isSelected())
                row.setIsCourse(1);
            else
                row.setIsCourse(0);
            row.setSerie(VersionTwoIsCourseSerieGroupInputPanel.serie.getText());
            row.setGroup(VersionTwoIsCourseSerieGroupInputPanel.group.getText());

            // add row & increment no of rows
            rows.add(row);
            counterForRows++;

            // make empty every text field
            VersionTwoTeacherSubjectInputPanel.teacherName.setText("");
            VersionTwoTeacherSubjectInputPanel.subjectName.setText("");
            VersionTwoIsCourseSerieGroupInputPanel.serie.setText("");
            VersionTwoIsCourseSerieGroupInputPanel.group.setText("");

            // at least on row is inserted -> done options becomes possible
            doneBtn.setEnabled(true);
        }

    }

    private void stopInsert(ActionEvent event) {
        VersionTwoTeacherSubjectInputPanel.teacherName.setText("");
        VersionTwoTeacherSubjectInputPanel.subjectName.setText("");
        VersionTwoIsCourseSerieGroupInputPanel.serie.setText("");
        VersionTwoIsCourseSerieGroupInputPanel.group.setText("");

        // disable every button, text field or checkbox -> inserted options are not available anymore
        doneBtn.setEnabled(false);
        nextBtn.setEnabled(false);
        VersionTwoTeacherSubjectInputPanel.teacherName.setEnabled(false);
        VersionTwoTeacherSubjectInputPanel.subjectName.setEnabled(false);
        VersionTwoIsCourseSerieGroupInputPanel.isCourse.setEnabled(false);
        VersionTwoIsCourseSerieGroupInputPanel.serie.setEnabled(false);
        VersionTwoIsCourseSerieGroupInputPanel.group.setEnabled(false);

        VersionTwoBottomControlPanel.createBtn.setEnabled(true);

    }
}
