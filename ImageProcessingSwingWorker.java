import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ImageProcessingSwingWorker {
    private static BufferedImage originalImage;
    private static BufferedImage processedImage;

    private static float brightnessFactor = 1.0f;
    private static float contrastFactor = 1.0f;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Image Processing Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            JPanel panel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    if (processedImage != null) {
                        g.drawImage(processedImage, 0, 0, null);
                    }
                }
            };
            frame.add(panel);

            JButton loadButton = new JButton("Load Image");
            loadButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFileChooser fileChooser = new JFileChooser();
                    int result = fileChooser.showOpenDialog(frame);
                    if (result == JFileChooser.APPROVE_OPTION) {
                        File selectedFile = fileChooser.getSelectedFile();
                        try {
                            originalImage = ImageIO.read(selectedFile);
                            processedImage = deepCopy(originalImage);
                            panel.repaint();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            });

            JButton brightnessButton = new JButton("Adjust Brightness");
            brightnessButton.addActionListener(e -> {
                String input = JOptionPane.showInputDialog(frame, "Enter brightness factor (e.g., 0.5, 1.5):");
                if (input != null) {
                    try {
                        brightnessFactor = Float.parseFloat(input);
                        applyImageProcessing();
                        panel.repaint();
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Invalid input. Please enter a valid number.");
                    }
                }
            });

            JButton contrastButton = new JButton("Adjust Contrast");
            contrastButton.addActionListener(e -> {
                String input = JOptionPane.showInputDialog(frame, "Enter contrast factor (e.g., 0.5, 1.5):");
                if (input != null) {
                    try {
                        contrastFactor = Float.parseFloat(input);
                        applyImageProcessing();
                        panel.repaint();
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Invalid input. Please enter a valid number.");
                    }
                }
            });

            JButton applyFilterButton = new JButton("Apply Color Filter");
            applyFilterButton.addActionListener(e -> {
                String[] filterOptions = {"Original", "Sepia", "Negative", "Grayscale"};
                String selectedOption = (String) JOptionPane.showInputDialog(
                        frame,
                        "Select a color filter:",
                        "Color Filter",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        filterOptions,
                        filterOptions[0]);

                if (selectedOption != null) {
                    applyColorFilter(selectedOption);
                    panel.repaint();
                }
            });

            JPanel buttonPanel = new JPanel();
            buttonPanel.add(loadButton);
            buttonPanel.add(brightnessButton);
            buttonPanel.add(contrastButton);
            buttonPanel.add(applyFilterButton);
            frame.add(buttonPanel, BorderLayout.SOUTH);

            frame.setVisible(true);
        });
    }

    private static void applyImageProcessing() {
        if (originalImage != null) {
            processedImage = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_INT_RGB);

            for (int y = 0; y < originalImage.getHeight(); y++) {
                for (int x = 0; x < originalImage.getWidth(); x++) {
                    int rgb = originalImage.getRGB(x, y);
                    int red = (int) ((rgb >> 16) & 0xFF);
                    int green = (int) ((rgb >> 8) & 0xFF);
                    int blue = (int) (rgb & 0xFF);

                    red = applyBrightnessContrast(red);
                    green = applyBrightnessContrast(green);
                    blue = applyBrightnessContrast(blue);

               

                    int processedRGB = (red << 16) | (green << 8) | blue;
                    processedImage.setRGB(x, y, processedRGB);
                }
            }
        }
    }

    private static int applyBrightnessContrast(int channel) {
        float adjustedChannel = (channel - 128) * contrastFactor + 128 + (brightnessFactor * 255);
        return Math.min(255, Math.max(0, (int) adjustedChannel));
    }

    private static void applyColorFilter(String filterOption) {
        for (int y = 0; y < originalImage.getHeight(); y++) {
            for (int x = 0; x < originalImage.getWidth(); x++) {
                int rgb = originalImage.getRGB(x, y);
                int red = (int) ((rgb >> 16) & 0xFF);
                int green = (int) ((rgb >> 8) & 0xFF);
                int blue = (int) (rgb & 0xFF);

                switch (filterOption) {
                    case "Sepia":
                        int sepiaR = (int) (0.393 * red + 0.769 * green + 0.189 * blue);
                        int sepiaG = (int) (0.349 * red + 0.686 * green + 0.168 * blue);
                        int sepiaB = (int) (0.272 * red + 0.534 * green + 0.131 * blue);
                        red = Math.min(255, sepiaR);
                        green = Math.min(255, sepiaG);
                        blue = Math.min(255, sepiaB);
                        break;
                    case "Negative":
                        red = 255 - red;
                        green = 255 - green;
                        blue = 255 - blue;
                        break;
                    case "Grayscale":
                        int gray = (int) (0.3 * red + 0.59 * green + 0.11 * blue);
                        red = gray;
                        green = gray;
                        blue = gray;
                        break;
                    // case "Original": // No change needed for the original option
                    default:
                        // Do nothing for the "Original" option
                        break;
                }

                int processedRGB = (red << 16) | (green << 8) | blue;
                processedImage.setRGB(x, y, processedRGB);
            }
        }
    }

    private static BufferedImage deepCopy(BufferedImage original) {
        BufferedImage copy = new BufferedImage(original.getWidth(), original.getHeight(), original.getType());
        Graphics2D g = copy.createGraphics();
        g.drawImage(original, 0, 0, null);
        g.dispose();
        return copy;
    }
}
