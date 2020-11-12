
import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;

public class ex1 extends BasicGame {

    Shape s1, s2;
    int cx = 20, cy = 20;
    Color bc;
    Image rock;
    Rectangle hb;

    public ex1(String title) {
        super(title);
    }

    public void init(GameContainer gc) throws SlickException {
        s1 = new Circle(cx, cy, 20);
        s2 = new Rectangle(100, 300, 200, 75);
        bc = Color.red;
        rock = new Image("images/astroid.png");
        hb = new Rectangle(300,200,rock.getWidth(),rock.getHeight());
    }

    public void update(GameContainer gc, int i) throws SlickException {

        Input in = gc.getInput();

        if (in.isKeyDown(Input.KEY_W)) {
            cy--;
        }
        if (in.isKeyDown(Input.KEY_D)) {
            cx++;
        }
        if (in.isKeyDown(Input.KEY_A)) {
            cx--;
        }
        if (in.isKeyDown(Input.KEY_S)) {
            cy++;
        }
        int mx = in.getMouseX();
        int my = in.getMouseY();
        if (hb.contains(mx,my)){
            if(in.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)){
                cx = (int)(Math.random()*700+50);
                cy = (int)(Math.random()*500+50);
            }
        }
        s1.setX(cx);
        s1.setY(cy);
        
        if (s1.contains(s2)) {
            bc = Color.orange;
        }
        else if(s2.intersects(s1)){
            bc = Color.green;
        } 
        else{
            bc = Color.red;
        }
    }

    public void render(GameContainer gc, Graphics g) throws SlickException {
        g.setColor(bc);
        g.fill(s2);
        g.setColor(Color.red);
        g.fill(s1);
        rock.draw(300,200);
    }

    public static void main(String args[]) throws SlickException {
        ex1 game = new ex1("Testing Game");
        AppGameContainer app = new AppGameContainer(game);
        app.setDisplayMode(800, 600, false);
        app.setShowFPS(true);
        app.setTargetFrameRate(500);
        app.start();
    }

}
