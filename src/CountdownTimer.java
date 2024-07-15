
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import javax.swing.JPanel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author billi
 */
public class CountdownTimer extends JPanel {
    
    private int countdown;
    private Font font;
    
    public CountdownTimer(int countdown, Font font) {
        this.countdown = countdown;
        this.font = font.deriveFont(Font.BOLD, 42f); // Set the font size here
        setOpaque(false);
    }
    
    public void setCountdown(int countdown) {
        this.countdown = countdown;
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.BLUE);
    g.setFont(font);
    String message = Integer.toString(countdown);
    FontMetrics fm = g.getFontMetrics();
    int x = (getWidth() - fm.stringWidth(message)) / 2;
    int y = (getHeight() - fm.getHeight()) / 2 + fm.getAscent();
    g.drawString(message, x, y);
    }
}
