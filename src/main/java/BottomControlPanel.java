import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class BottomControlPanel extends JPanel {
    final MainFrame frame;
    JButton exitBtn = new JButton("Exit");

    public BottomControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        setLayout(new GridLayout(1,1));
        add(exitBtn);
        exitBtn.addActionListener(this::exitApp);
    }

    private void exitApp(ActionEvent event) {
        frame.dispose();
    }
}
