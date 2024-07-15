
import java.awt.Image;
import java.io.*;
import java.util.Scanner;
import javax.swing.ImageIcon;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author billi
 */
public class Map {
    
    private Scanner scan;
    
    private String Map[] = new String[14];
    
    private Image grass, finish, wall;
    
    
    public Map() {
        loadImages();
        loadMap("C:\\Users\\billi\\OneDrive\\Documents\\NetBeansProjects\\FirstJavaApplication\\src\\Images\\Map.txt");
    }
    
    private void loadImages() {
        grass = new ImageIcon("C:\\Users\\billi\\OneDrive\\Documents\\NetBeansProjects\\FirstJavaApplication\\src\\Images\\grass.png").getImage();
        wall = new ImageIcon("C:\\Users\\billi\\OneDrive\\Documents\\NetBeansProjects\\FirstJavaApplication\\src\\Images\\wall.png").getImage();
        finish = new ImageIcon("C:\\Users\\billi\\OneDrive\\Documents\\NetBeansProjects\\FirstJavaApplication\\src\\Images\\finish.png").getImage();
    }

    public void loadMap(String path) {
        try {
            scan = new Scanner(new File(path));
            for (int i = 0; i < 14; i++) {
                Map[i] = scan.next();
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error Loading Map: " + path);
        }
    }
    
    public Image getGrass() {
        return grass;
    }
    
    public Image getWall() {
        return wall;
    }
    
    public Image getFinish() {
        return finish;
    }
    
    public String getMap(int x, int y) {
        String index = Map[y].substring(x, x+1);
        return index;
    }
    
    
}
