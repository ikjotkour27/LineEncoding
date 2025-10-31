
import java.awt.*;
import javax.swing.*;

public class WaveformDisplay extends JPanel {
    private final String[] signal; // e.g. {"+V", "0", "-V", "+V"}

    public WaveformDisplay(String encodedSignal) {
        this.signal = encodedSignal.trim().split("\\s+");
        setPreferredSize(new Dimension(1000, 400));
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int x = 50;             // Start X position
        int bitWidth = 60;      // Width for each bit
        int midY = 200;         // Baseline Y
        int highY = midY - 80;  // Y position for +V
        int lowY = midY + 80;   // Y position for -V

        g.setColor(Color.BLACK);
        g.setFont(new Font("Consolas", Font.BOLD, 16));
        g.drawString("Digital Signal Output Waveform", 300, 40);

        // Draw horizontal baseline
        g.setColor(Color.GRAY);
        g.drawLine(40, midY, 950, midY);
        g.setColor(Color.BLACK);

        int prevY = midY;
        if (signal[0].contains("+")) prevY = highY;
        else if (signal[0].contains("-")) prevY = lowY;

        // Start line
        g.setColor(Color.BLUE);

        for (int i = 0; i < signal.length; i++) {
            int currentY = midY;

            if (signal[i].contains("+")) currentY = highY;
            else if (signal[i].contains("-")) currentY = lowY;

            // Draw vertical transition if level changes
            if (i > 0 && currentY != prevY) {
                g.drawLine(x, prevY, x, currentY);
            }

            // Draw horizontal line for this bit
            g.drawLine(x, currentY, x + bitWidth, currentY);

            // Label the bit below waveform
            g.setColor(Color.DARK_GRAY);
            g.drawString(signal[i], x + 15, midY + 120);
            g.setColor(Color.BLUE);

            prevY = currentY;
            x += bitWidth;
        }

        // Axis labels
        g.setColor(Color.BLACK);
        g.drawString("+V", 10, highY);
        g.drawString("0",  10, midY);
        g.drawString("-V", 10, lowY);
    }

    // Show the waveform in a window
    public static void showWaveform(String encodedSignal) {
        JFrame frame = new JFrame("Digital Signal Output");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new WaveformDisplay(encodedSignal));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
