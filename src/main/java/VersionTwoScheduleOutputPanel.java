import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VersionTwoScheduleOutputPanel extends JPanel{
    final VersionTwoFrame versionTwoFrame;
    JScrollPane scrollPane;
    static DefaultTableModel model = new DefaultTableModel();
    JTable schedule = new JTable(model);

    public VersionTwoScheduleOutputPanel(VersionTwoFrame frameTwo){
        this.versionTwoFrame = frameTwo;
        init();
    }

    private void init(){
        // GUI settings
        setBackground(Color.GRAY);
        setMinimumSize (new Dimension(800, 275));
        setPreferredSize (new Dimension (800, 275));
        setMaximumSize (new Dimension (800, 275));
        setBounds(50, 235, 800, 275);
        setBorder(createBorder());

        model.addColumn("NAME");
        model.addColumn("TEACHER");
        model.addColumn("DAYOFWEEK");
        model.addColumn("STARTTIME");
        model.addColumn("SERIE");
        model.addColumn("GROUP");

        // add JScrollPane for the panel
        scrollPane = new JScrollPane(schedule);
        scrollPane.setMinimumSize(new Dimension(650, 260));
        scrollPane.setPreferredSize(new Dimension(650, 260));
        scrollPane.setMaximumSize(new Dimension(650, 260));
        scrollPane.setBounds(75, 220, 650, 260);
        add(scrollPane);
    }

    private Border createBorder() {
        Border border;
        border = BorderFactory.createMatteBorder( 2,2,2,2, Color.BLACK);
        return border;
    }
}
