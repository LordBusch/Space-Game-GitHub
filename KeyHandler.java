import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
    public static boolean up, down, right, left;
    KeyHandler() {
        //Main.frame.addKeyListener(this);
    }
    SecondGameMode panSecondGameMode = new SecondGameMode();

    public void draw() {
        System.out.println("DEBUG");
        if(up) {
            SecondGameMode.yposship = SecondGameMode.yposship - 10;
            new SecondGameMode();
            panSecondGameMode.repaint();
            Main.frame.repaint();
            System.out.println("up");
        }

        if(down) {
            SecondGameMode.yposship = SecondGameMode.yposship + 10;
            new SecondGameMode();
            panSecondGameMode.repaint();
            Main.frame.repaint();
            System.out.println("down");
        }

        if(right) {
            SecondGameMode.xposship = SecondGameMode.xposship + 10;
            new SecondGameMode();
            panSecondGameMode.repaint();
            Main.frame.repaint();
            System.out.println("right");
        }

        if(left) {
            SecondGameMode.xposship = SecondGameMode.xposship - 10;
            new SecondGameMode();
            panSecondGameMode.repaint();
            Main.frame.repaint();
            System.out.println("left");
        }

    }

    public void keyTyped(KeyEvent e) {
        
    }

    public void keyPressed(KeyEvent e) {
        if(Main.GameActive) {
            
            int keyCode = e.getKeyCode();
            switch(keyCode) {
                
                case KeyEvent.VK_D:
                right = true;
                break;

                case KeyEvent.VK_A:
                left = true;
                break;
                
                case KeyEvent.VK_W:
                up = true;
                break;

                case KeyEvent.VK_S:
                down = true;
                break;
            }
            
            draw();
        }
    }

    public void keyReleased(KeyEvent e) {

        if(Main.GameActive) {

            int keyCode = e.getKeyCode();
                switch(keyCode) {
                    
                    case KeyEvent.VK_D:
                    right = false;
                    break;

                    case KeyEvent.VK_A:
                    left = false;
                    break;
                    
                    case KeyEvent.VK_W:
                    up = false;
                    break;

                    case KeyEvent.VK_S:
                    down = false;
                    break;
                }
        }
    }
}