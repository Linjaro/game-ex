   
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;


public class Astroid {
    private Image image;
    private Rectangle hb;
    private int x,y;
    private boolean isChosen;
    
    private static int GAME_WIDTH,GAME_HEIGHT;
    
    public Astroid(int xx,int yy) throws SlickException{
        image = new Image("images/astroid.png");
        hb = new Rectangle(xx,yy,image.getWidth(),image.getHeight());
        isChosen = false;
        
        while(true){
            x = (int)(Math.random()*7-3);
            y = (int)(Math.random()*7-3);
            if (x !=0 && y != 0) {
                break;
            }
        }
        
        
    }
    public boolean hit(int x,int y){
        if (hb.contains(x,y)) return true;
        else return false;
    }
    public static void setGameSize(int x, int y){
        GAME_WIDTH = x;
        GAME_HEIGHT = y;
    }
    public Rectangle getHitBox(){
        return hb;
    }
    public void setChosen(){
        isChosen= true;
    }
    public boolean isChosen(){
        return isChosen;
    }
    public void move(){
        hb.setX(hb.getX()+x);
        hb.setY(hb.getY()+y);
        
        if (hb.getX()<= 0 || hb.getX()> GAME_WIDTH-image.getWidth()) {
            x*=-1;
        }
        if (hb.getY()<= 40 || hb.getY()> GAME_HEIGHT-image.getHeight()) {
            y*=-1;
        }
    }
    public void draw(){
        image.draw(hb.getX(),hb.getY());
    }
}
