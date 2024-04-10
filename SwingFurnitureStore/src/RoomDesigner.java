import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RoomDesigner {
    private JComboBox<String> shapeComboBox;
    private JComboBox<String> sizeComboBox;
    private JButton colorButton;
    private JButton loadButton;

    public RoomDesigner() {
        JFrame frame = new JFrame("Room Designer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setMinimumSize(new Dimension(50,90));

        // Define color palette
        Color foregroundColor = new Color(255, 255, 255);
        Color backgroundColor = new Color(36, 36, 36, 255);
        Font font = new Font("Century Gothic", Font.BOLD, 14);
        Font lblfont = new Font("Century Gothic", Font.BOLD, 14);

        // Bedroom selection
        shapeComboBox = new JComboBox<>(new String[]{"Single BedRoom", "Double BedRoom", "Master BedRoom"});
        shapeComboBox.setBackground(backgroundColor);
        shapeComboBox.setForeground(foregroundColor);
        shapeComboBox.setFont(font);
        shapeComboBox.setSelectedItem("Single BedRoom");
        JLabel shapeLabel = new JLabel("Select Your BedRoom: ");
        shapeLabel.setFont(lblfont);
        frame.add(shapeLabel);
        frame.add(shapeComboBox);

        // Select Room Size selection
        sizeComboBox = new JComboBox<>(new String[]{"Small:3.66 × 5.49 and 12' x 18'", "Medium:4.88 x 6.01 and 16' x 20'", "Large:6.71 x 8.53 and 22' x 28'"});
        sizeComboBox.setBackground(backgroundColor);
        sizeComboBox.setForeground(foregroundColor);
        sizeComboBox.setFont(font);
        sizeComboBox.setSelectedItem("Medium:4.88 x 6.01 and 16' x 20'");
        JLabel sizeLabel = new JLabel("Select Your Room Size(meters and feet): ");
        sizeLabel.setFont(lblfont);
        frame.add(sizeLabel);
        frame.add(sizeComboBox);
        // Color selection
        colorButton = new JButton("Select Color");
        colorButton.setBackground(backgroundColor);
        colorButton.setForeground(foregroundColor);
        colorButton.setFont(font);
        colorButton.addActionListener(e -> {
            Color selectedColor = JColorChooser.showDialog(frame, "Choose Color", Color.WHITE);
            if (selectedColor != null) {
                colorButton.setBackground(selectedColor);
            }
        });
        frame.add(colorButton);

        // Load button
        loadButton = new JButton("Load Design");
        loadButton.setBackground(backgroundColor);
        loadButton.setForeground(foregroundColor);
        loadButton.setFont(font);
        loadButton.addActionListener(e -> {
            loadDesign();
            frame.dispose();
        });
        frame.add(loadButton);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void loadDesign() {
        String selectedShape = (String) shapeComboBox.getSelectedItem();
        String selectedSize = (String) sizeComboBox.getSelectedItem();
        Color selectedColor = colorButton.getBackground();

        // Initialize TwoDViwer form with selected values
        SwingUtilities.invokeLater(() -> {
            TwoDViwer viewer = new TwoDViwer(selectedShape, selectedSize, selectedColor);
            viewer.setVisible(true);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RoomDesigner::new);
    }
}
