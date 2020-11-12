
import java.util.ArrayList;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;

public class Astroidfield extends BasicGame {

    ArrayList<Astroid> rocks;
    double timer, timer2;
    Image rock;

    public Astroidfield(String title) {
        super(title);
    }

    public void init(GameContainer gc) throws SlickException {
        rocks = new ArrayList();
        timer = timer2 = 0;
        Astroid.setGameSize(800, 600);

        for (int i = 0; i < 10; i++) {
            int rx = (int) (Math.random() * 750);
            int ry = (int) (Math.random() * 510+40);
            rocks.add(new Astroid(rx, ry));
        }
        rocks.get(0).setChosen();
    }

    public void update(GameContainer gc, int i) throws SlickException {
        Input in = gc.getInput();
        int mx = in.getMouseX();
        int my = in.getMouseY();
        if (rocks.size() > 0) {
            rocks.get(0).setChosen();
            for (Astroid r : rocks) {
                r.move();
                if (r.hit(mx, my) && in.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) && r.isChosen()) {
                    rocks.remove(r);
                    break;
                }
            }

            timer++;
            timer2++;
            if (timer >= 500) {
                timer = 0;
                int rx = (int) (Math.random() * 750);
                int ry = (int) (Math.random() * 510+40);
                rocks.add(new Astroid(rx, ry));
            }
        }
    }

    public void render(GameContainer gc, Graphics g) throws SlickException {
        Color dark = new Color(50,130,50);
        g.setColor(dark);
        g.fill(new Rectangle(0,0,800,40));
        g.setColor(Color.red);
        
        for (Astroid r : rocks) {
            if (r.isChosen()) {
                g.fill(r.getHitBox());
            }
            r.draw();
        }
        g.setColor(Color.yellow);
        g.drawString(String.format("Time: %.2f", timer2/100), 10, 10);
        g.drawString("Rocks Remaining: "+ rocks.size(),600,10);

    }

    public static void main(String args[]) throws SlickException {
        Astroidfield game = new Astroidfield("Testing Game");
        AppGameContainer app = new AppGameContainer(game);
        app.setDisplayMode(800, 600, false);
        app.setShowFPS(false);
        app.setTargetFrameRate(100);
        app.start();
    }

}
