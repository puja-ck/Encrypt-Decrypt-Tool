
import java.awt.*;

import javax.swing.*;

public class Tab {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("TabbedPane");
                frame.getContentPane().add(new TabView());
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setMinimumSize(new Dimension(800, 450));
                // Point location = new Point(20, 20);
                // frame.setLocation(location); // Center
                frame.setLocation(100, 100);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    static class TabView extends JPanel {

        private JTabbedPane tabbedPane;

        TabView() {
            createComponents();
            makeLayout();
        }

        private void createComponents() {
            tabbedPane = new JTabbedPane();
            tabbedPane.addTab("Hello", new JLabel("World"));


            JLabel inputLableEnc = new JLabel("Input:");
            inputLableEnc.setLocation(20, 20);

            JTextField inputEnc = new JTextField();
            inputEnc.setBounds(50, 20, 100, 25);

            
            tabbedPane.addTab("Goodbye", inputLableEnc);
            tabbedPane.setLocation(20, 20);
        }

        private void makeLayout() {
            setLayout(new BorderLayout());

            // Alternative placements: JTabbedPane.TOP, JTabbedPane.RIGHT, JTabbedPane.LEFT JTabbedPane.BOTTOM.
            tabbedPane.setTabPlacement(JTabbedPane.TOP);
            // Alternative layout policies: JTabbedPane.WRAP_TAB_LAYOUT or JTabbedPane.SCROLL_TAB_LAYOUT.
            tabbedPane.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);

            add(tabbedPane, BorderLayout.CENTER);
        }
    }
}
