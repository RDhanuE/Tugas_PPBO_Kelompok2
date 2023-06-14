package Games;
import javax.swing.JFrame;

public class Games{
    public static void main(String[] args) { 
        JFrame gameWindow = new JFrame();
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.setResizable(false);
        gameWindow.setTitle("A Day On TRPL");
        
        GamePanel gamepanel = new GamePanel();
        gameWindow.add(gamepanel);
        gameWindow.pack();


        gameWindow.setLocationRelativeTo(null );
        gameWindow.setVisible(true);

        gamepanel.startGameThread();
    }
}