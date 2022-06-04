import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VersionOneScheduleOutputPanel extends JPanel{
    final VersionOneFrame versionOneFrame;
    JScrollPane scrollPane;
    static DefaultTableModel model = new DefaultTableModel();
    JTable schedule = new JTable(model);

    public VersionOneScheduleOutputPanel(VersionOneFrame frameOne){
        this.versionOneFrame = frameOne;
        init();
    }

    private void init(){
        // GUI settings
        setBackground(Color.GRAY);
        setMinimumSize (new Dimension(700, 345));
        setPreferredSize (new Dimension (700, 345));
        setMaximumSize (new Dimension (700, 345));
        setBounds(50, 155, 700, 345);
        setBorder(createBorder());

        model.addColumn("NAME");
        model.addColumn("TEACHER");
        model.addColumn("DAYOFWEEK");
        model.addColumn("STARTTIME");
        model.addColumn("SERIE");
        model.addColumn("GROUP");
        model.addColumn("ROOM");

        // add JScrollPane for the panel
        scrollPane = new JScrollPane(schedule);
        scrollPane.setMinimumSize(new Dimension(650, 330));
        scrollPane.setPreferredSize(new Dimension(650, 330));
        scrollPane.setMaximumSize(new Dimension(650, 330));
        scrollPane.setBounds(75, 140, 650, 330);
        add(scrollPane);
    }

    private Border createBorder() {
        Border border;
        border = BorderFactory.createMatteBorder( 2,2,2,2, Color.BLACK);
        return border;
    }
}
