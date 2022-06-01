import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class VersionOneConfigPanel extends JPanel {
    final VersionOneFrame versionOneFrame;
    JLabel howManyRoomsLabel;
    JSpinner howManyRoomsSpinner;
    JButton createNrOfRoomsBtn;
    int numberOfRooms = 0;
    JLabel indication;

    public VersionOneConfigPanel(VersionOneFrame frameOne) throws InterruptedException {
        this.versionOneFrame = frameOne;
        init();
    }

    private void init() throws InterruptedException {
        setLayout(new GridLayout(27,5));
        // how many rooms menu
        howManyRoomsLabel = new JLabel("Insert number of rooms:");
        howManyRoomsSpinner = new JSpinner(new SpinnerNumberModel(10,1,25,1));
        createNrOfRoomsBtn = new JButton("Create rooms");
        add(howManyRoomsLabel);
        add(howManyRoomsSpinner);
        add(createNrOfRoomsBtn);

        createNrOfRoomsBtn.addActionListener(this::createRooms);

        // short indication on how to use the app
        indication = new JLabel("Insert a name and a capacity for every room:");
        this.add(indication);

        // start creating labels & text fields for every room
        for (int index = 0; index < 25; index++)
        {
            add(new JLabel("Room"));
        }
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
