package stategame;
import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

public class Gamelauncher extends StateBasedGame {

    public Gamelauncher(String title) {
        super(title);
    }
    
    public void initStatesList(GameContainer gc) throws SlickException {
       
       this.addState(new StartScrean());
       
       this.addState(new MainGame());
       this.addState(new EndScreen());
    }

    public static void main(String args[]) throws SlickException {
        Gamelauncher game = new Gamelauncher("Testing Game");
        AppGameContainer app = new AppGameContainer(game);
        app.setDisplayMode(800, 600, false);
        app.setShowFPS(false);
        app.setTargetFrameRate(100);
        app.start();
    }

}