import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;

import javax.swing.*;
import java.awt.*;

public class ModelViewer {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("View the Model");
            frame.setLayout(new BorderLayout()); // Use BorderLayout

            final JFXPanel fxPanel = new JFXPanel();
            frame.add(fxPanel, BorderLayout.CENTER); // Add JFXPanel at the center

            // Create a panel for buttons
            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Set the layout

            Color backgroundColor = new Color(36, 36, 36); // Define the background color
            Color foregroundColor = new Color(255, 255, 255); // Define the foreground color
            Font buttonFont = new Font("Century Gothic", Font.BOLD, 14); // Define the font

            // Create buttons
            JButton saveButton = new JButton("Save");
            saveButton.setBackground(backgroundColor);
            saveButton.setForeground(foregroundColor);
            saveButton.setFont(buttonFont);
            JButton editButton = new JButton("Edit");
            editButton.setBackground(backgroundColor);
            editButton.setForeground(foregroundColor);
            editButton.setFont(buttonFont);
            JButton deleteButton = new JButton("Delete");
            deleteButton.setBackground(backgroundColor);
            deleteButton.setForeground(foregroundColor);
            deleteButton.setFont(buttonFont);
            JButton returnButton = new JButton("Return");
            returnButton.setBackground(backgroundColor);
            returnButton.setForeground(foregroundColor);
            returnButton.setFont(buttonFont);

            // Add action listeners for the buttons
            saveButton.addActionListener(e -> {
                JOptionPane.showMessageDialog(frame,
                        "Successfully saved to your directory",
                        "Save Successful",
                        JOptionPane.INFORMATION_MESSAGE);
            });

            editButton.addActionListener(e -> frame.dispose());

            deleteButton.addActionListener(e -> {
                int result = JOptionPane.showConfirmDialog(frame,
                        "Are you sure?",
                        "Confirm Delete",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.YES_OPTION) {
                    frame.dispose();
                }
            });

            returnButton.addActionListener(e -> frame.dispose());

            // Add buttons to the panel
            buttonPanel.add(saveButton);
            buttonPanel.add(editButton);
            buttonPanel.add(deleteButton);
            buttonPanel.add(returnButton);

            // Add the panel of buttons to the bottom of the frame
            frame.add(buttonPanel, BorderLayout.SOUTH);

            frame.setSize(900, 700);
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            Platform.runLater(() -> {
                initFX(fxPanel);
            });
        });
    }

    private static void initFX(JFXPanel fxPanel) {
        // This method is invoked on the JavaFX thread
        WebView webView = new WebView();
        webView.getEngine().load("https://sketchfab.com/3d-models/high-poly-bed-716bfa90dca549e8a076f0b4f367accc/embed");

        Scene scene = new Scene(webView);
        fxPanel.setScene(scene);
    }

}