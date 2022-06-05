import jdk.swing.interop.SwingInterOpUtils;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VersionTwoSubjectsInputPanel extends JPanel{
    final VersionTwoFrame versionTwoFrame;
    JLabel subjectLabel;
    static TextField subjectName;
    JLabel howManyLabel;
    static JSpinner howManyClasses;
    static JButton nextBtn;
    static JButton doneBtn;

    int counterForSubjects = 0;

    public VersionTwoSubjectsInputPanel(VersionTwoFrame versionTwo){
        this.versionTwoFrame = versionTwo;
        init();
    }

    private void init(){
        // GUI settings
        setBackground(Color.PINK);
        setMinimumSize (new Dimension (800, 40));
        setPreferredSize (new Dimension (800, 40));
        setMaximumSize (new Dimension (800, 40));
        setBounds(50, 115, 800, 40);
        setBorder(createBorder());

        // create label for subject name, text field for teacher name, label for its no of classes & spinner for it, "next" button
        subjectLabel = new JLabel("Subject name:");
        subjectName = new TextField("");
        subjectName.setColumns(30);
        subjectName.setEnabled(false);
        howManyLabel = new JLabel("Classes no.:");
        howManyClasses = new JSpinner(new SpinnerNumberModel(3,1,40,1));
        howManyClasses.setEnabled(false);
        nextBtn = new JButton("Next");
        nextBtn.setEnabled(false);
        doneBtn = new JButton("Finish");
        doneBtn.setEnabled(false);

        add(subjectLabel);
        add(subjectName);
        add(howManyLabel);
        add(howManyClasses);
        add(nextBtn);
        add(doneBtn);

        nextBtn.addActionListener(this::nextSubject);
        doneBtn.addActionListener(this::finishInserting);
    }

    private Border createBorder() {
        Border border;
        border = BorderFactory.createMatteBorder( 1,2,0,2, Color.BLACK);
        return border;
    }

    private void nextSubject(ActionEvent event) {
        // user still has subjects to insert
        if(counterForSubjects < VersionTwoTeachersInputPanel.nrOfSubjects[VersionTwoTeachersInputPanel.counterForTeachers - 1])
        {
            // check if subject has a name; it can't be <<"">> or null
            if(!subjectName.getText().equals(""))
            {
                System.out.println("\n\tNume materie " + subjectName.getText());
                System.out.println("\tNr de sedinte pt materie avute " + (int)howManyClasses.getValue());

                // reinitialise subjectName, increment no of subjects
                subjectName.setText("");
                counterForSubjects++;
            }
        }

        // all the necessary subjects were inserted
        if(counterForSubjects == VersionTwoTeachersInputPanel.nrOfSubjects[VersionTwoTeachersInputPanel.counterForTeachers - 1])
        {
            // reinitialise counterForSubjects
            counterForSubjects = 0;

            // user can now add another teacher or stop -- inserting is over
            subjectName.setEnabled(false);
            howManyClasses.setEnabled(false);
            nextBtn.setEnabled(false);
            doneBtn.setEnabled(true);
            VersionTwoTeachersInputPanel.teacherName.setEnabled(true);
            VersionTwoTeachersInputPanel.howManySubjects.setEnabled(true);
            VersionTwoTeachersInputPanel.nextBtn.setEnabled(true);
        }
    }

    private void finishInserting(ActionEvent event) {
        // disable all the buttons
        VersionTwoTeachersInputPanel.teacherName.setEnabled(false);
        VersionTwoTeachersInputPanel.howManySubjects.setEnabled(false);
        VersionTwoTeachersInputPanel.nextBtn.setEnabled(false);
        doneBtn.setEnabled(false);
    }
}
