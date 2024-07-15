
import java.awt.Image;
import javax.swing.ImageIcon;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author billi
 */
public class Player {
    
    private int tileX, tileY;
        
    private Image playerImage;
    
    
    public Player(String imagePath, int startX, int startY) {
        
        ImageIcon imageIcon = new ImageIcon(imagePath);
        playerImage = imageIcon.getImage();
                
        tileX = startX;
        tileY = startY;
        
        
    }
    
    public Image getPlayer() {
        return playerImage;
    }
    
        
    public int getTileX() {
        return tileX;
    }
    
    public int getTileY() {
        return tileY;
    }
       
    public void move(int dx, int dy) {
        
        
       tileX += dx;
       tileY += dy;
    }
    
    
    
}
