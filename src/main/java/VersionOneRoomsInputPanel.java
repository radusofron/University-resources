import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VersionOneRoomsInputPanel extends JPanel {
    final VersionOneFrame versionOneFrame;
    static JTextField nameField;
    static JSpinner capacitySpinner;
    static JButton nextBtn;
    Room[] rooms = new Room[20];
    int roomIndex = 0;
    Database database;

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

        // create text field for name, spinner for capacity & "next" button
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
        nextBtn.addActionListener(this::checkRoom);
    }

    private Border createBorder() {
        Border border;
        border = BorderFactory.createMatteBorder( 2,2,2,2, Color.BLACK);
        return border;
    }

    private void checkRoom(ActionEvent event) {
       // check if room has a name; it can't be <<"">>
       if(!nameField.getText().equals(""))
       {
           // extract input
           rooms[roomIndex].setRoomName(nameField.getText());
           rooms[roomIndex].setRoomCapacity((int)capacitySpinner.getValue());

           //still compare not to be already written - name is primary key...
           // TO DO
           nameField.setText("");

           // display to be sure all it's good
           System.out.println(rooms[roomIndex].getRoomName());
           System.out.println(rooms[roomIndex].getRoomCapacity());
           System.out.println(rooms[roomIndex].getRoomCapacity());

           roomIndex++;
       }

       // we came to the inputed number of rooms
       if(roomIndex == VersionOneConfigurationPanel.numberOfRooms)
       {
           database = new Database(rooms);
           nameField.setEnabled(false);
           capacitySpinner.setEnabled(false);
           nextBtn.setEnabled(false);
       }


    }

}
