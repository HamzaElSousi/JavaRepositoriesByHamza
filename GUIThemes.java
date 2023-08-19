import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIThemes {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Look and Feel Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 200);

            JPanel panel = new JPanel();

            JButton metalButton = new JButton("Metal L&F");
            JButton nimbusButton = new JButton("Nimbus L&F");
            JButton windowsButton = new JButton("Windows L&F");
            JButton motifButton = new JButton("Motif L&F");

            metalButton.addActionListener(new LAFChangeListener("javax.swing.plaf.metal.MetalLookAndFeel", frame));
            nimbusButton.addActionListener(new LAFChangeListener("javax.swing.plaf.nimbus.NimbusLookAndFeel", frame));
            windowsButton.addActionListener(new LAFChangeListener("com.sun.java.swing.plaf.windows.WindowsLookAndFeel", frame));
            motifButton.addActionListener(new LAFChangeListener("com.sun.java.swing.plaf.motif.MotifLookAndFeel", frame));

            panel.add(metalButton);
            panel.add(nimbusButton);
            panel.add(windowsButton);
            panel.add(motifButton);
            frame.add(panel);
            frame.setVisible(true);
        });
    }

    private static class LAFChangeListener implements ActionListener {
        private String lafClassName;
        private JFrame frame;

        public LAFChangeListener(String lafClassName, JFrame frame) {
            this.lafClassName = lafClassName;
            this.frame = frame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                UIManager.setLookAndFeel(lafClassName);
                SwingUtilities.updateComponentTreeUI(frame);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
