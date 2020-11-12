import java.util.ArrayList;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;

public class ex2 extends BasicGame {
ArrayList<Rectangle> rocks;
Image rock;
    
    
    
public ex2 (String title) {
super(title);
}

public void init(GameContainer gc) throws SlickException {
    rocks = new ArrayList();
    rock = new Image("images/astroid.png");
    for (int i = 0; i < 10; i++) {
        int rx = (int)(Math.random()*750);
        int ry = (int)(Math.random()*750);
        rocks.add(new Rectangle(rx,ry,rock.getWidth(),rock.getHeight()));
    }
}

public void update(GameContainer gc, int i) throws SlickException {
    Input in = gc.getInput();
    
    int mx = in.getMouseX(),my = in.getMouseY();
    for (Rectangle r : rocks) {
        
        if (r.contains(mx,my)&& in.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
            rocks.remove(r);
            return;
        }

    }
    
}

public void render(GameContainer gc, Graphics g) throws SlickException {
    for (Rectangle r : rocks) {
        rock.draw(r.getX(),r.getY());
    }
}

public static void main(String args[]) throws SlickException {
  ex2 game = new ex2("Testing Game");
  AppGameContainer app = new AppGameContainer(game);
  app.setDisplayMode(800, 600, false);
  app.setShowFPS(false);
  app.setTargetFrameRate(100);
  app.start();
}

} 