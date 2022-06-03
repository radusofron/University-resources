import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VersionOneConfigurationPanel extends JPanel{
    final VersionOneFrame versionOneFrame;
    JLabel howManyRoomsLabel;
    JSpinner howManyRoomsSpinner;
    JButton createNrOfRoomsBtn;
    static int numberOfRooms = 0;

    public VersionOneConfigurationPanel(VersionOneFrame frameOne) {
        this.versionOneFrame = frameOne;
        init();
    }

    private void init(){
        // GUI settings
        setBackground(Color.ORANGE);
        setMinimumSize (new Dimension (700, 40));
        setPreferredSize (new Dimension (700, 40));
        setMaximumSize (new Dimension (700, 40));
        setBounds(50,0,700,40);
        setBorder(createBorder());

        // how many rooms menu
        howManyRoomsLabel = new JLabel("Insert number of rooms:");
        howManyRoomsSpinner = new JSpinner(new SpinnerNumberModel(10,1,20,1));
        createNrOfRoomsBtn = new JButton("Done");
        add(howManyRoomsLabel);
        add(howManyRoomsSpinner);
        add(createNrOfRoomsBtn);

        createNrOfRoomsBtn.addActionListener(this::createRooms);
    }

    private Border createBorder() {
        Border border;
        border = BorderFactory.createMatteBorder( 2,2,0,2, Color.BLACK);
        return border;
    }

    private void createRooms(ActionEvent event) {
        // user can't use create rooms button or the spinner anymore
        createNrOfRoomsBtn.setEnabled(false);
        howManyRoomsSpinner.setEnabled(false);

        // extract the number of rooms inserted
        numberOfRooms = (int)howManyRoomsSpinner.getValue();
        System.out.println("S-au introdus " + numberOfRooms + " sali.");

        // enable next things
        VersionOneRoomsInputPanel.nameField.setEnabled(true);
        VersionOneRoomsInputPanel.capacitySpinner.setEnabled(true);
        VersionOneRoomsInputPanel.nextBtn.setEnabled(true);
    }
}
