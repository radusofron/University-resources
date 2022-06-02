import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VersionOneTopConfigPanel extends JPanel{
    final VersionOneFrame versionOneFrame;
    JLabel howManyRoomsLabel;
    JSpinner howManyRoomsSpinner;
    JButton createNrOfRoomsBtn;
    int numberOfRooms = 0;

    public VersionOneTopConfigPanel(VersionOneFrame frameOne) {
        this.versionOneFrame = frameOne;
        init();
    }

    private void init(){
        // GUI settings
        setBackground(Color.ORANGE);
        setMinimumSize (new Dimension (700, 50));
        setPreferredSize (new Dimension (700, 50));
        setMaximumSize (new Dimension (700, 50));
        setBounds(50,0,700,50);
        setBorder(createBorder());

        // how many rooms menu
        howManyRoomsLabel = new JLabel("Insert number of rooms:");
        howManyRoomsSpinner = new JSpinner(new SpinnerNumberModel(10,1,25,1));
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
    }
}
