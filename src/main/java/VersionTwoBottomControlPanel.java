import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VersionTwoBottomControlPanel extends JPanel {
    final VersionTwoFrame versionTwoFrame;
    static JButton createBtn = new JButton("Create schedule");
    JButton exitBtn = new JButton("Exit");
    VersionTwoAlgorithm algorithm;

    public VersionTwoBottomControlPanel(VersionTwoFrame frameTwo) {
        this.versionTwoFrame = frameTwo;
        initForVersionTwo();
    }

    private void initForVersionTwo() {
        // GUI settings
        setMinimumSize(new Dimension(800,50));
        setPreferredSize(new Dimension(800,50));
        setMaximumSize(new Dimension(800,50));
        setBounds(50,510, 800, 50);
        setLayout(new GridLayout(1,2));

        createBtn.setEnabled(false);
        add(createBtn);
        add(exitBtn);
        createBtn.addActionListener(this::startAppTwo);
        exitBtn.addActionListener(this::exitAppTwo);
    }

    private void exitAppTwo(ActionEvent event) {
        versionTwoFrame.dispose();
    }

    private void startAppTwo(ActionEvent event) {

        deletePreviousRowsInTable();
        createBtn.setText("Creating schedule...");
        algorithm = new VersionTwoAlgorithm();
        algorithm.startAlgorithm();
        createBtn.setEnabled(false);
    }

    private void deletePreviousRowsInTable() {
        String url = "jdbc:mysql://localhost:3306/university_resources_v_two";
        String username = "radu";
        String password = "mysqlradu";
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "delete from mytable";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.execute();
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to database!", e);
        }
    }
}
