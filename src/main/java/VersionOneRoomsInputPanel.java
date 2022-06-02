import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class VersionOneRoomsInputPanel extends JPanel {
    final VersionOneFrame versionOneFrame;
    static JTextField nameField;
    static JSpinner capacitySpinner;
    static JButton nextBtn;
    int counterOfRooms;
    String roomName = "";
    int roomCapacity;
    int roomIsBusy = 0; // by default they are free
    int roomIndex = 0;
    ArrayList<String> roomNames = new ArrayList<>();
    int[] roomCapacities = new int[20];
    int[] roomsAreBusy = new int[20];
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
       if(!roomName.equals(""))
       {
           //still compare not to be already written - name is primary key...
           nameField.setText("");
           counterOfRooms++;

           // add name, capacity and if it's busy to their correspondent arrays
           System.out.println(roomName);
           System.out.println(roomCapacity);
           System.out.println(roomIsBusy);
           roomNames.add(roomName);
           roomCapacities[roomIndex] = roomCapacity;
           roomsAreBusy[roomIndex] = roomIsBusy;
           roomIndex++;
       }

       // we come to the inputed number of rooms
       if(counterOfRooms == VersionOneConfigurationPanel.numberOfRooms)
       {
           database = new Database(roomNames, roomCapacities, roomsAreBusy);
           nameField.setEnabled(false);
           capacitySpinner.setEnabled(false);
           nextBtn.setEnabled(false);
       }


    }

}
