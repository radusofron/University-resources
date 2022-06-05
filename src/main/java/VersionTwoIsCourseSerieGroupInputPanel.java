import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class VersionTwoIsCourseSerieGroupInputPanel extends JPanel{
    final VersionTwoFrame versionTwoFrame;
    JLabel isCourseLabel;
    static JCheckBox isCourse;
    JLabel serieLabel;
    static TextField serie;
    JLabel groupLabel;
    static TextField group;

    public VersionTwoIsCourseSerieGroupInputPanel(VersionTwoFrame versionTwo){
        this.versionTwoFrame = versionTwo;
        init();
    }

    private void init(){
        // GUI settings
        setBackground(Color.PINK);
        setMinimumSize (new Dimension (800, 40));
        setPreferredSize (new Dimension (800, 40));
        setMaximumSize (new Dimension (800, 40));
        setBounds(50, 155, 800, 40);
        setBorder(createBorder());

        // create label for subject name, text field for teacher name, label for its no of classes & spinner for it, "next" button
        // create labels, checkbox for course option, input for serie and group
        isCourseLabel = new JLabel("Is couse:");
        isCourse = new JCheckBox();
        isCourse.setEnabled(false);
        serieLabel = new JLabel("Serie:");
        serie = new TextField("");
        serie.setColumns(15);
        serie.setEnabled(false);
        groupLabel = new JLabel("Group:");
        group = new TextField("");
        group.setColumns(15);
        group.setEnabled(false);

        add(isCourseLabel);
        add(isCourse);
        add(serieLabel);
        add(serie);
        add(groupLabel);
        add(group);
    }

    private Border createBorder() {
        Border border;
        border = BorderFactory.createMatteBorder( 0,2,0,2, Color.BLACK);
        return border;
    }

//    private void nextSubject(ActionEvent event) {
//        // user still has subjects to insert
//        if(counterForSubjects < VersionTwoTeachersInputPanel.nrOfSubjects[VersionTwoTeachersInputPanel.counterForTeachers - 1])
//        {
//            // check if subject has a name; it can't be <<"">> or null
//            if(!subjectName.getText().equals(""))
//            {
//                System.out.println("\n\tNume materie " + subjectName.getText());
//                System.out.println("\tNr de sedinte pt materie avute " + (int)howManyClasses.getValue());
//
//                // reinitialise subjectName, increment no of subjects
//                subjectName.setText("");
//                counterForSubjects++;
//            }
//        }
//
//        // all the necessary subjects were inserted
//        if(counterForSubjects == VersionTwoTeachersInputPanel.nrOfSubjects[VersionTwoTeachersInputPanel.counterForTeachers - 1])
//        {
//            // reinitialise counterForSubjects
//            counterForSubjects = 0;
//
//            // user can now add another teacher or stop -- inserting is over
//            subjectName.setEnabled(false);
//            howManyClasses.setEnabled(false);
//            nextBtn.setEnabled(false);
//            /* to be move in classinputpanel */
////            VersionTwoTeachersInputPanel.teacherName.setEnabled(true);
////            VersionTwoTeachersInputPanel.howManySubjects.setEnabled(true);
////            VersionTwoTeachersInputPanel.nextBtn.setEnabled(true);
//        }
//    }
}
