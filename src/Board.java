
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author billi
 */
public class Board extends JPanel implements ActionListener {
    
    private Timer timer;
    
    private Map map;
    
    private Player player1;
    
    private Player player2;
        
    private boolean win = false;
    
    private String message = "";
    
    private Font font = new Font("Serif", Font.BOLD,62);
    
    private Image winnerIcon;
    
    private int currentMapIndex = 0;
    private String[] mapFiles = {
        "C:\\Users\\billi\\OneDrive\\Documents\\NetBeansProjects\\FirstJavaApplication\\src\\Images\\Map4.txt",
        "C:\\Users\\billi\\OneDrive\\Documents\\NetBeansProjects\\FirstJavaApplication\\src\\Images\\Map.txt",
        "C:\\Users\\billi\\OneDrive\\Documents\\NetBeansProjects\\FirstJavaApplication\\src\\Images\\Map1.txt",
        "C:\\Users\\billi\\OneDrive\\Documents\\NetBeansProjects\\FirstJavaApplication\\src\\Images\\Map2.txt",
        "C:\\Users\\billi\\OneDrive\\Documents\\NetBeansProjects\\FirstJavaApplication\\src\\Images\\Map3.txt"   
    };
    
    private Timer delayTimer;
    private final int delayTime = 1000;
    private CountdownTimer countdownTimer;
    
    public Board() {
        setLayout(new BorderLayout()); 
        loadMap();
        addKeyListener(new AL());
        setFocusable(true);
        timer = new Timer(25, this);
        timer.start();
        countdownTimer = new CountdownTimer(3, font);
        add(countdownTimer, BorderLayout.CENTER);
        countdownTimer.setVisible(true);
        
    }
    
    private void loadMap() {
        map = new Map();
        map.loadMap(mapFiles[currentMapIndex]);
        player1 = new Player("C:\\Users\\billi\\OneDrive\\Documents\\NetBeansProjects\\FirstJavaApplication\\src\\Images\\hearteyes.png", 1, 1);
        player2 = new Player("C:\\Users\\billi\\OneDrive\\Documents\\NetBeansProjects\\FirstJavaApplication\\src\\Images\\cool2.png", 12, 12);
        win = false;
        winnerIcon = null;
    }
    
     public void actionPerformed(ActionEvent e) {
        if (map.getMap(player1.getTileX(), player1.getTileY()).equals("f") && !win) {
            message = "Player 1 Wins!";
            winnerIcon = player1.getPlayer();
            win = true;
            startDelayTimer();
        } else if (map.getMap(player2.getTileX(), player2.getTileY()).equals("f") && !win) {
            message = "Player 2 Wins!";
            winnerIcon = player2.getPlayer();
            win = true;
            startDelayTimer();
        }
        repaint();
       // if (win) {
         //   nextMap();
        //}
    }
     
     private void startDelayTimer() {
        delayTimer = new Timer(delayTime, new ActionListener() {
            private int countdown = 3;
   
            @Override
            public void actionPerformed(ActionEvent e) {
                if (countdown > 0) {
                    countdownTimer.setCountdown(countdown);
                    countdownTimer.setVisible(true);
                    countdown--;
                } else {
                    countdownTimer.setVisible(false);
                    nextMap();
                    delayTimer.stop();
                }
            }
        });
        delayTimer.setInitialDelay(delayTime); // Start after the winner is displayed
        delayTimer.setRepeats(true); // Repeat every second
        delayTimer.start();
    }
     
     private void nextMap() {
        currentMapIndex++;
        if (currentMapIndex < mapFiles.length) {
            loadMap();
        } else {
            System.out.println("All maps completed!");
        }
    }
    
    public void paint(Graphics g) {
        super.paint(g);
        if (!win) {
            for (int y = 0; y < 14; y++) {
                for (int x = 0; x < 14; x++) {
                    if (map.getMap(x, y).equals("f")) {
                        g.drawImage(map.getFinish(), x * 42, y * 42, null);
                    } else if (map.getMap(x, y).equals("w")) {
                        g.drawImage(map.getGrass(), x * 42, y * 42, null);
                    } else if (map.getMap(x, y).equals("g")) {
                        g.drawImage(map.getWall(), x * 42, y * 42, null);
                    }
                }
            }
            g.drawImage(player1.getPlayer(), player1.getTileX() * 42, player1.getTileY() * 42, null);
            g.drawImage(player2.getPlayer(), player2.getTileX() * 42, player2.getTileY() * 42, null);
        } else {
            g.setColor(Color.GREEN);
            g.setFont(font);
            g.drawString(message, 100, 270);
            if (winnerIcon != null) {
                g.drawImage(winnerIcon, 200, 350, null);
            }
        }
    }
    
    public class AL extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
           int keycode = e.getKeyCode();
           
           if(keycode == KeyEvent.VK_UP) {
               if(!map.getMap(player1.getTileX(), player1.getTileY()- 1).equals("g")) {
                    player1.move(0, -1);
               }
           }
           if(keycode == KeyEvent.VK_DOWN) {
               if(!map.getMap(player1.getTileX(), player1.getTileY()+ 1).equals("g")) {
                    player1.move(0, 1);
               }
           }
           if(keycode == KeyEvent.VK_LEFT) {
               if(!map.getMap(player1.getTileX()-1, player1.getTileY()).equals("g")) {
                    player1.move(-1, 0);
               }
           }
           if(keycode == KeyEvent.VK_RIGHT) {
               if(!map.getMap(player1.getTileX()+1, player1.getTileY()).equals("g")) {
                    player1.move(1, 0);
               }
           }
           
           if(keycode == KeyEvent.VK_W) {
               if(!map.getMap(player2.getTileX(), player2.getTileY()- 1).equals("g")) {
                    player2.move(0, -1);
               }
           }
           if(keycode == KeyEvent.VK_S) {
               if(!map.getMap(player2.getTileX(), player2.getTileY()+ 1).equals("g")) {
                    player2.move(0, 1);
               }
           }
           if(keycode == KeyEvent.VK_A) {
               if(!map.getMap(player2.getTileX()-1, player2.getTileY()).equals("g")) {
                    player2.move(-1, 0);
               }
           }
           if(keycode == KeyEvent.VK_D) {
               if(!map.getMap(player2.getTileX()+1, player2.getTileY()).equals("g")) {
                    player2.move(1, 0);
               }
           }
        }
        
        @Override
        public void keyReleased(KeyEvent e) {
            
        }
        
        @Override
        public void keyTyped(KeyEvent e) {
            
            
            
        }
    }
    
    
}
