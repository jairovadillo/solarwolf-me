package myGame;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
/**
 * @author Jairo Vadillo
 */
public class solarWolf extends MIDlet {
    clsCanvas myCanvas;

    public void startApp() {
        Display d = Display.getDisplay(this);
        myCanvas = new clsCanvas(this);
        myCanvas.start();
        d.setCurrent(myCanvas);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
        myCanvas = null;
        notifyDestroyed();
    }
}
