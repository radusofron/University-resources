import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VersionOneRoomsInputPanel extends JPanel {
    final VersionOneFrame versionOneFrame;
    static JTextField nameField;
    static JSpinner capacitySpinner;
    static JButton nextBtn;
    String roomName = new String();
    int roomCapacity;

    public VersionOneRoomsInputPanel(VersionOneFrame frameOne){
        this.versionOneFrame = frameOne;
        init();
    }

    private void init(){
        // GUI settings
        setMinimumSize (new Dimension (700, 400));
        setPreferredSize (new Dimension (700, 400));
        setMaximumSize (new Dimension (700, 400));
        setBounds(50, 100, 700, 400);
        setBorder(createBorder());

        //create text field for name, spinner for capacity & "next" button
        nameField = new JTextField("");
        nameField.setColumns(30);
        nameField.setEnabled(false);
        capacitySpinner = new JSpinner(new SpinnerNumberModel(30,5,120,5));
        capacitySpinner.setEnabled(false);
        nextBtn = new JButton("Next");
        nextBtn.setEnabled(false);
        add(nameField);
        add(capacitySpinner);
        add(nextBtn);
        nextBtn.addActionListener(this::nextRoom);
    }

    private Border createBorder() {
        Border border;
        border = BorderFactory.createMatteBorder( 2,2,2,2, Color.BLACK);
        return border;
    }

    private void nextRoom(ActionEvent event) {
       // extract input
       roomName = nameField.getText();
       roomCapacity = (int)capacitySpinner.getValue();

       // check if room has a name; it can't be <<"">>
       if(roomName.equals("") == false)
       {
           nameField.setText("");
           VersionOneConfigurationPanel.numberOfRooms--;

           //add room in database
       }

       // correct number of rooms were given as input
       if(VersionOneConfigurationPanel.numberOfRooms == 0)
       {
           nameField.setEnabled(false);
           capacitySpinner.setEnabled(false);
           nextBtn.setEnabled(false);
       }


    }

}
