import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class VersionTwoTeachersInputPanel extends JPanel {
    final VersionTwoFrame versionTwoFrame;
    JLabel teacherLabel;
    static TextField teacherName;
    JLabel subjectsLabel;
    static JSpinner howManySubjects;
    static JButton nextBtn;
    Teacher teacher;
    static int counterForTeachers = 0;
    ArrayList<String> teacherNames = new ArrayList<>();
    static int[] nrOfSubjects  = new int[100];

    public VersionTwoTeachersInputPanel(VersionTwoFrame frameTwo){
        this.versionTwoFrame = frameTwo;
        init();
    }

    private void init(){
        // GUI settings
        setBackground(Color.PINK);
        setMinimumSize (new Dimension (800, 40));
        setPreferredSize (new Dimension (800, 40));
        setMaximumSize (new Dimension (800, 40));
        setBounds(50,75,800,40);
        setBorder(createBorder());

        // create label for teacher name, text field for teacher name, label for teacher's no of subjects & spinner for it, "next" & "done" button
        teacherLabel = new JLabel("Teacher:");
        teacherName = new TextField("");
        teacherName.setColumns(30);
        subjectsLabel = new JLabel("Subjects no.:");
        howManySubjects = new JSpinner(new SpinnerNumberModel(1,1,5,1));
        nextBtn = new JButton("Next field");

        add(teacherLabel);
        add(teacherName);
        add(subjectsLabel);
        add(howManySubjects);
        add(nextBtn);

        nextBtn.addActionListener(this::checkTeacher);
    }

    private Border createBorder() {
        Border border;
        border = BorderFactory.createMatteBorder( 1,2,0,2, Color.BLACK);
        return border;
    }

    private void checkTeacher(ActionEvent event) {
        // check if teacher has a name; it can't be <<"">> or null
        if(!teacherName.getText().isEmpty())
        {
            // user still wants to add another teacher, so "done" option will not be available anymore
            if(VersionTwoSubjectsInputPanel.doneBtn.isEnabled())
                VersionTwoSubjectsInputPanel.doneBtn.setEnabled(false);

            // create an instance of Teacher class and extract input
            teacher = new Teacher();
            teacher.setName(teacherName.getText());
            teacher.setNoOfSubjects((int)howManySubjects.getValue());

            teacherNames.add(teacher.getName());
            nrOfSubjects[counterForTeachers] = teacher.getNoOfSubjects();

            // reinitialise nameField, increment no of rooms
            teacherName.setText("");
            counterForTeachers++;

            // disable options in order to insert another teacher untill its subjects & no of classes for
            // every subject are inserted
            teacherName.setEnabled(false);
            howManySubjects.setEnabled(false);
            nextBtn.setEnabled(false);

            // enable options in order to insert name and how many classes for every subject of the teacher inserted above
            VersionTwoSubjectsInputPanel.subjectName.setEnabled(true);
            VersionTwoSubjectsInputPanel.howManyClasses.setEnabled(true);
            VersionTwoSubjectsInputPanel.nextBtn.setEnabled(true);
        }
    }
}
