import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StudentInfoSystem extends JFrame implements ActionListener {

    private final JTextField nameField;
    private final JTextField rollField, courseField;
    private final JTextArea displayArea;
    private final JButton submitBtn, clearBtn;

    public StudentInfoSystem() {
        setTitle("Student Information System");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        inputPanel.add(new JLabel("Student Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Roll Number:"));
        rollField = new JTextField();
        inputPanel.add(rollField);

        inputPanel.add(new JLabel("Course:"));
        courseField = new JTextField();
        inputPanel.add(courseField);

        submitBtn = new JButton("Submit");
        clearBtn = new JButton("Clear");

        inputPanel.add(submitBtn);
        inputPanel.add(clearBtn);

        add(inputPanel, BorderLayout.NORTH);

        // Display Area
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        displayArea.setBorder(BorderFactory.createTitledBorder("Student Information"));
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        // Action Listeners
        submitBtn.addActionListener(this);
        clearBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitBtn) {
            String name = nameField.getText();
            String roll = rollField.getText();
            String course = courseField.getText();

            if (name.isEmpty() || roll.isEmpty() || course.isEmpty()) {
                displayArea.setText("Please fill in all fields.");
            } else {
                displayArea.setText("Student Name: " + name + "\n"
                                  + "Roll Number : " + roll + "\n"
                                  + "Course      : " + course);
            }
        } else if (e.getSource() == clearBtn) {
            nameField.setText("");
            rollField.setText("");
            courseField.setText("");
            displayArea.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new StudentInfoSystem().setVisible(true);
        });
    }
}
