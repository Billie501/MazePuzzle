
import javax.swing.JFrame;



public class Maze extends JFrame {
    
    public static void main(String[] args) {
        new Maze();
    }
    
    public Maze() {
        JFrame frame = new JFrame();
        frame.setTitle("Maze Game");
        frame.add(new Board());
        frame.setSize(608, 634);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
}
