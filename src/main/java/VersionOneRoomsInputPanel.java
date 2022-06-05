import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class VersionOneRoomsInputPanel extends JPanel {
    final VersionOneFrame versionOneFrame;
    JLabel label;
    static JTextField nameField;
    static JSpinner capacitySpinner;
    static JButton nextBtn;
    int counterForRooms = 0;
    ArrayList<String> roomNames = new ArrayList<>();
    int[] roomCapacities = new int[20];
    int[] roomsAreBusy = new int[20];
    int[] roomsId = new int[20];
    VersionOneDatabaseWriteRooms database;

    public VersionOneRoomsInputPanel(VersionOneFrame frameOne){
        this.versionOneFrame = frameOne;
        init();
    }

    private void init(){
        // GUI settings
        setBackground(Color.ORANGE);
        setMinimumSize (new Dimension (700, 40));
        setPreferredSize (new Dimension (700, 40));
        setMaximumSize (new Dimension (700, 40));
        setBounds(50, 115, 700, 40);
        setBorder(createBorder());

        // create label for indications, text field for name, spinner for capacity & "next" button
        label = new JLabel("Insert room:");
        nameField = new JTextField("");
        nameField.setColumns(30);
        nameField.setEnabled(false);
        capacitySpinner = new JSpinner(new SpinnerNumberModel(30,5,120,5));
        capacitySpinner.setEnabled(false);
        nextBtn = new JButton("Next");
        nextBtn.setEnabled(false);
        add(label);
        add(nameField);
        add(capacitySpinner);
        add(nextBtn);
        nextBtn.addActionListener(this::checkRoom);
    }

    private Border createBorder() {
        Border border;
        border = BorderFactory.createMatteBorder( 1,2,0,2, Color.BLACK);
        return border;
    }

    private void checkRoom(ActionEvent event) {
       // check if room has a name; it can't be <<"">> or null
       if(!nameField.getText().isEmpty())
       {
           // create an instance of Room class and extract input
           Room room = new Room();
           room.setRoomName(nameField.getText());
           room.setRoomCapacity((int)capacitySpinner.getValue());
           room.setRoomIsBusy(0);
           room.setId(counterForRooms);

           roomNames.add(room.getRoomName());
           roomCapacities[counterForRooms] = room.getRoomCapacity();
           roomsAreBusy[counterForRooms] = room.getRoomIsBusy();
           roomsId[counterForRooms] = room.getId();

           // reinitialise nameField, increment no of rooms
           nameField.setText("");
           counterForRooms++;
       }

       // all the necessary rooms were inserted
       if(counterForRooms == VersionOneConfigurationPanel.numberOfRooms)
       {
           database = new VersionOneDatabaseWriteRooms(roomNames, roomCapacities, roomsAreBusy, roomsId);
           nameField.setEnabled(false);
           capacitySpinner.setEnabled(false);
           nextBtn.setEnabled(false);
       }
    }

}
