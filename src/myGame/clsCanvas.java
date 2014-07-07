package myGame;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.lcdui.game.Sprite;
import java.io.InputStream;
import java.util.Random;

/**
 * @author Jairo Vadillo
 */
public class clsCanvas extends GameCanvas implements Runnable {
private boolean isRunning = true;
private Graphics g;
private solarWolf fParent;

private Image imgMonsterP;
private Image imgTitulo;

private Image imgMenuBg;
private Image imgStartOff;
private Image imgStartOn;
private Image imgSetupOff;
private Image imgSetupOn;
private Image imgCredsOff;
private Image imgCredsOn;
private Image imgCredsTxt;
private Image imgQuitOff;
private Image imgQuitOn;

private Image imgBala;
private Sprite Bala;
private Image imgBarraP;
private Image imgMaloAr;
private Image imgMaloAb;
private Image imgMaloDe;
private Image imgMaloIz;
private Image imgMina;
private Sprite Mina;
private Image imgRoca;
private Sprite Roca;
private Image imgCuboV;
private Sprite CuboV;
private Image imgCuboA;
private Sprite CuboA;
private Image imgCuboR;
private Sprite CuboR;
private Image imgPopCubo;
private Sprite PopCubo;

private Image imgVidas;
private Image imgNacer;
private Sprite Nacer;
private Image imgNave;
private Sprite Nave;
private Image imgExpl;
private Sprite Expl;

public clsCanvas(solarWolf m) {
     super(true);
     fParent = m;
     setFullScreenMode(true);
}

public void start(){
     Thread runner = new Thread(this);
     runner.start();
}

public void load(){
     try{
         imgMonsterP = Image.createImage("/images/braveboar.png");
         imgTitulo = Image.createImage("/images/titulo.png");

         imgStartOff = Image.createImage("/images/start_off.png");
         imgStartOn = Image.createImage("/images/start_on.png");
         imgSetupOff = Image.createImage("/images/setup_off.png");
         imgSetupOn = Image.createImage("/images/setup_on.png");
         imgCredsOff = Image.createImage("/images/creds_off.png");
         imgCredsOn = Image.createImage("/images/creds_on.png");
         imgCredsTxt = Image.createImage("/images/creds_txt.png");
         imgQuitOff = Image.createImage("/images/quit_off.png");
         imgQuitOn = Image.createImage("/images/quit_on.png");
         imgMenuBg = Image.createImage("/images/galaxy.png");

         imgNacer = Image.createImage("/images/navenace.png");
         imgNave = Image.createImage("/images/navesprite.png");
         imgExpl = Image.createImage("/images/explosion.png");
         imgVidas = Image.createImage("/images/vidas.png");

         imgPopCubo = Image.createImage("/images/popbox.png");
         imgCuboV = Image.createImage("/images/cubospriteV.png");
         imgCuboA = Image.createImage("/images/cubospriteA.png");
         imgCuboR = Image.createImage("/images/cubospriteR.png");
         imgMina = Image.createImage("/images/minas.png");

         imgRoca = Image.createImage("/images/roca.png");
         imgBarraP = Image.createImage("/images/barrapuntos.png");

         imgBala = Image.createImage("/images/bala.png");
         imgMaloAr = Image.createImage("/images/maloarriva.png");
         imgMaloAb = Image.createImage("/images/maloabajo.png");
         imgMaloIz = Image.createImage("/images/maloizquierda.png");
         imgMaloDe = Image.createImage("/images/maloderecha.png");

         Nacer = new Sprite(imgNacer,imgNacer.getWidth()/15,imgNacer.getHeight());
         Nacer.setFrame(0);
         Nave = new Sprite(imgNave,imgNave.getWidth()/4,imgNave.getHeight());
         Nave.setFrame(0);
         Expl = new Sprite(imgExpl,imgExpl.getWidth()/16,imgExpl.getHeight());
         Expl.setFrame(0);
         PopCubo = new Sprite(imgPopCubo,imgPopCubo.getWidth()/5,imgPopCubo.getHeight());
         PopCubo.setFrame(0);
         CuboV = new Sprite(imgCuboV,imgCuboV.getWidth()/15,imgCuboV.getHeight());
         CuboV.setFrame(0);
         CuboA = new Sprite(imgCuboA,imgCuboA.getWidth()/15,imgCuboA.getHeight());
         CuboA.setFrame(0);
         CuboR = new Sprite(imgCuboR,imgCuboR.getWidth()/15,imgCuboR.getHeight());
         CuboR.setFrame(0);
         Mina = new Sprite(imgMina,imgMina.getWidth()/12,imgMina.getHeight());
         Mina.setFrame(0);
         Roca = new Sprite(imgRoca,imgRoca.getWidth()/24,imgRoca.getHeight());
         Roca.setFrame(0);
         Bala = new Sprite(imgBala,imgBala.getWidth()/8,imgBala.getHeight());
         Bala.setFrame(0);

     }catch(Exception ex){
         isRunning = false;
         return;
     }
 }

public void unload(){
    imgNave = null;
    Nave =null;
    imgCuboA = null;
    CuboA = null;
    imgCuboR = null;
    CuboR = null;
    imgCuboV = null;
    CuboV = null;
    imgBarraP = null;
    imgMaloAr = null;
    imgMaloAb = null;
    imgMaloIz = null;
    imgMaloDe = null;
    imgMina =null;
    Mina = null;
    imgMonsterP = null;
    imgTitulo = null;
    imgVidas = null;
    imgStartOff = null;
    imgStartOn = null;
    imgSetupOff = null;
    imgSetupOn = null;
    imgCredsOff = null;
    imgCredsOn = null;
    imgQuitOff = null;
    imgQuitOn = null;
    imgMenuBg = null;
    imgExpl = null;
    Expl = null;
    Roca =null;
    imgRoca =null;
    imgBala = null;
    Bala = null;
    imgPopCubo = null;
    PopCubo = null;
    imgNacer = null;
    Nacer = null;
    imgCredsTxt = null;
}

public void run() {
    int x =1, y=1;
    int dir=4, vidas=3;
    int maloVer1 = 150;
    int maloVer2 = 150;
    int maloHor1 = 120;
    int maloHor2 = 120;
    int movVer = 0;
    int movHor = 0;
    int i=0,j;
    int cubos = 1;
    int nivel = 1;
    int indexMenu = 0;
    int opcion = 7;
    int tecla =0;
    int teclaant=0;
    final int NUP = 0;
    final int NDOWN = 1;
    final int NLEFT = 2;
    final int NRIGHT = 3;
    int VEL =5;
    int nbalas=2;
    int rocaIndex=0;
    int nrocas=0;
    int nminas=0;
    Random rand = new Random();

    boolean salir = false;
    boolean viva= false;
    boolean aparecer = true;
    boolean acabar = false;
    boolean esperar = false;
    boolean nacer = true;
    boolean random= false;

    int nacerIndex=0;
    int balaIndex=0;
    int popIndex=0;
    int explIndex=0;
    long lDelay2=60;
    long lStart2=0;
    int minaIndex=0;
    int cubeIndex=0; //frame actual del cubo
    long lDelay=75;            //retardo entre frames
    long lStart=0;              //tiempo transcurrido desde el ultimo cambio de frame
    long lCurrTick=0;           //tiempo actual del sistema


    load();
    g = getGraphics();

//mostramos banner
    g.setColor(0x000000);
    g.fillRect(0, 0, getWidth(), getHeight());
    g.drawImage(imgMonsterP, 0, 0, Graphics.LEFT | Graphics.TOP);
    flushGraphics();
    try{
            Thread.sleep(2000);
        } catch (Exception ex){

        }
//mostramos el titulo
    g.drawImage(imgTitulo, 0, 0, Graphics.LEFT | Graphics.TOP);
    flushGraphics();
    try{
            Thread.sleep(2000);
        } catch (Exception ex){
            
        }
        getKeyStates();
    while (!salir){
        acabar=false;
        opcion=7;
        g.drawImage(imgMenuBg, 0, 0, Graphics.LEFT | Graphics.TOP);
        if (indexMenu==0){
            g.drawImage(imgStartOn, 40, 5, Graphics.LEFT | Graphics.TOP);
        }else{
            g.drawImage(imgStartOff, 40, 5, Graphics.LEFT | Graphics.TOP);
        }
        if (indexMenu==1){
            g.drawImage(imgSetupOn, 40, 5 + imgStartOff.getHeight(), Graphics.LEFT | Graphics.TOP);
        }else{
            g.drawImage(imgSetupOff, 40, 5 + imgStartOff.getHeight(), Graphics.LEFT | Graphics.TOP);
        }
        if (indexMenu==2){
            g.drawImage(imgCredsOn, 40, 5 + imgStartOff.getHeight() + imgSetupOff.getHeight(), Graphics.LEFT | Graphics.TOP);
        }else{
            g.drawImage(imgCredsOff, 40, 5 + imgStartOff.getHeight() + imgSetupOff.getHeight(), Graphics.LEFT | Graphics.TOP);
        }
        if (indexMenu==3){
            g.drawImage(imgQuitOn, 40, 5 + imgStartOff.getHeight() + imgSetupOff.getHeight() + imgCredsOff.getHeight(), Graphics.LEFT | Graphics.TOP);
        }else{
            g.drawImage(imgQuitOff, 40, 5 + imgStartOff.getHeight() + imgSetupOff.getHeight() + imgCredsOff.getHeight(), Graphics.LEFT | Graphics.TOP);
        }

        tecla=getKeyStates();
        if ((tecla==teclaant)){
            i++;
        }
        if (tecla!=teclaant | i>3){
            i=0;
            switch(tecla){
                case GameCanvas.UP_PRESSED: if (indexMenu>0){
                                                indexMenu--;
                                            }else{
                                                indexMenu=3;
                                            }
                break;
                case GameCanvas.DOWN_PRESSED: if (indexMenu<3){
                                                indexMenu++;
                                              }else{
                                                indexMenu=0;
                                            }
                break;
                case GameCanvas.FIRE_PRESSED: if (indexMenu==0){
                                                opcion=0;
                                                vidas=3;
                                                viva=false;
                                                aparecer=true;
                                                if(nivel>1){
                                                    indexMenu=0;
                                                }else indexMenu=1;
                                                acabar=false;
                                                tecla=0;
                                                teclaant=GameCanvas.FIRE_PRESSED;
                                                i=0;
                                                
                                                while (!acabar){
                                                    g.setColor(0x000000);
                                                    g.fillRect(0, 0, getWidth(), getHeight());
                                                    g.setColor(0xffffff);
                                                    if(nivel>1){
                                                        g.drawString("Continue Game", 50, 40, Graphics.LEFT | Graphics.TOP);
                                                    }
                                                    g.drawString("New game", 50, 60, Graphics.LEFT | Graphics.TOP);
                                                    g.drawString("Random game", 50, 80, Graphics.LEFT | Graphics.TOP);
                                                    g.drawString("Quit", 50, 100, Graphics.LEFT | Graphics.TOP);
                                                    Nave.setPosition(10, indexMenu*20+38);
                                                    Nave.setFrame(3);
                                                    Nave.paint(g);
                                                    getKeyStates();
                                                    tecla=getKeyStates();
                                                    if ((tecla==teclaant)){
                                                        i++;
                                                    }
                                                    if (tecla!=teclaant | i>2){
                                                        i=0;
                                                        switch(tecla){
                                                            case GameCanvas.DOWN_PRESSED:if(nivel>1){
                                                                                            if (indexMenu<3){
                                                                                                indexMenu++;
                                                                                            }else{
                                                                                                indexMenu=0;
                                                                                            }
                                                                                        }else{
                                                                                            if (indexMenu<3){
                                                                                                indexMenu++;
                                                                                            }else{
                                                                                                indexMenu=1;
                                                                                            }
                                                                                        }
                                                            break;
                                                            case GameCanvas.UP_PRESSED:if(nivel>1){
                                                                                            if (indexMenu>0){
                                                                                                indexMenu--;
                                                                                            }else{
                                                                                                indexMenu=3;
                                                                                            }
                                                                                        }else{
                                                                                            if (indexMenu>1){
                                                                                                indexMenu--;
                                                                                            }else{
                                                                                                indexMenu=3;
                                                                                            }
                                                                                        }
                                                            break;
                                                            case GameCanvas.FIRE_PRESSED: if (indexMenu==0){
                                                                                                //dejamos el nivel anterior
                                                                                                acabar=true;
                                                                                                indexMenu=0;
                                                                                                opcion=0;
                                                                                                random=false;
                                                                                            }
                                                                                            if (indexMenu==1){
                                                                                                nivel=1;
                                                                                                acabar=true;
                                                                                                indexMenu=0;
                                                                                                opcion=0;
                                                                                            }
                                                                                            if (indexMenu==2){
                                                                                                nivel=18;
                                                                                                acabar=true;
                                                                                                indexMenu=0;
                                                                                                opcion=0;
                                                                                                random=true;
                                                                                            }
                                                                                            if (indexMenu==2){
                                                                                                acabar=true;
                                                                                                indexMenu=0;
                                                                                                opcion=7;
                                                                                            }
                                                            break;

                                                        }
                                                    }
                                                    teclaant = tecla;
                                                    flushGraphics();
                                                    try{
                                                        Thread.sleep(50);
                                                    } catch (Exception ex){
                                                                            }
                                                }
                                                acabar=false;
                                                }
                                                if (indexMenu==1){
                                                    opcion=1;
                                                }
                                                if (indexMenu==2){
                                                    opcion=2;
                                                }
                                                if (indexMenu==3){
                                                    salir=true;
                                                }
                break;
            }
        }

        teclaant = tecla;
        try{
            Thread.sleep(50);
        } catch (Exception ex){
        }
        flushGraphics();

        switch(opcion){
            case 0:
                while (vidas>=0 & !acabar){
                    InputStream is = getClass().getResourceAsStream("/res/"+ Integer.toString(nivel)+".txt");
                    StringBuffer sb = new StringBuffer();

//cosas de cubos y de ficheros
                    int[][] basecubos = {
                        {0 , 0 , 0 , 0 , 0 },
                        {1 , 0 , 7 , 0 , 1 },
                        {0 , 2 , 0 , 2 , 0 },
                        {0 , 0 , 3 , 0 , 0 },
                        {0 , 2 , 0 , 2 , 0 },
                        {1 , 0 , 0 , 0 , 1 },
                        {0 , 0 , 0 , 0 , 0 }
                    };
                    nminas=0;
                    for(i=0;i<=6;i++){
                        for(j=0;j<=4;j++){
                            if(nminas<6){
                                basecubos[i][j] = Math.abs((rand.nextInt()>>>1) % 7);
                                if(basecubos[i][j]>=4){
                                    nminas++;
                                }
                            }else{
                                basecubos[i][j] = Math.abs((rand.nextInt()>>>1) % 4);
                        }
                        }
                    }
                    basecubos[3][4]=7;
                    nrocas++;
                    nbalas +=2;
                    try{
                    int chars;
                    for (i = 0; i <= 6;i++){
                        for (j = 0; j <= 4; j++){
                            chars=is.read();
                            basecubos[i][j] = ((int)chars)-48;
                        }
                    }
                    nrocas=(int)is.read()-48;
                    nbalas=(int)is.read()-48;
                    nbalas*=10;
                    nbalas+=(int)is.read()-48;
                    }catch(Exception ex){}

//cosas de rocas : D

                        int[] rmov= new int[nrocas];
                        int[] avelx= new int[nrocas];
                        int[] avely= new int[nrocas];
                        int[] rpos= new int[nrocas];
                        int[] ax= new int[nrocas];
                        int[] ay= new int[nrocas];
                        boolean[] rcreada= new boolean[nrocas];

                        for (i=0;i<nrocas;i++){
                            rmov[i]=0;
                            avelx[i]=0;
                            avely[i]=0;
                            rpos[i]=0;
                            ax[i]=0;
                            ay[i]=0;
                            rcreada[i]=false;
                        }

//cosas de balas : D
                        int[] bx = new int[nbalas];
                        int[] by = new int[nbalas];
                        int[] bpos = new int[nbalas];
                        int[] bmov = new int[nbalas];
                        boolean[] bcreada = new boolean[nbalas];

                        for (i=0;i<nbalas;i++){
                            bx[i]=0;
                            by[i]=0;
                            bpos[i]=0;
                            bmov[i]=0;
                            bcreada[i]=false;
                        }

                        int[] fx = new int[100];
                        int[] fy = new int[100];
                        for (i=0;i<100;i++){
                            fx[i]= (Math.abs((rand.nextInt()>>>1) % (getWidth())));
                            fy[i]= (Math.abs((rand.nextInt()>>>1) % (getHeight()-imgBarraP.getHeight())));
                            
                        }
                        g.setColor(0x000000);
                        g.fillRect(0, 0, getWidth(), getHeight());
                        g.setColor(0xffffff);
                        for (i=0; i<100; i++){
                            g.drawLine(fx[i], fy[i], fx[i], fy[i]);
                        }
                        if (random){
                            g.drawString("Level R"+Integer.toString(nivel-17), 20, 100, Graphics.LEFT | Graphics.TOP);
                        }else{
                            g.drawString("Level"+Integer.toString(nivel), 20, 100, Graphics.LEFT | Graphics.TOP);
                        }

                        flushGraphics();
                        try{
                        Thread.sleep(650);
                        } catch (Exception ex){
                        }



//inicialización de variables al principio del nivel
                    cubos=1;        //el minimo para entrar en el bucle de juego : D
                    dir=4;
                    viva=false;
                    i=0;
                    x=0;
                    y=0;
                    Nave.setFrame(0);
                    esperar=false;
                    getKeyStates();
                    nacer=true;
                    
                    try{
                        Thread.sleep(30);
                    } catch (Exception ex){
                    }

                    while(cubos>0 & vidas>=0 & !acabar){
//teclas(), recojemos la tecla apretada y modificamos la direccion
                        if(viva){
                        tecla=0;
                        tecla = getKeyStates();
                        switch(tecla){
                            case GameCanvas.UP_PRESSED:
                                Nave.setFrame(0);
                                dir=NUP;
                            break;
                            case GameCanvas.DOWN_PRESSED:
                                Nave.setFrame(1);
                                dir=NDOWN;
                            break;
                            case GameCanvas.LEFT_PRESSED:
                                Nave.setFrame(2);
                                dir=NLEFT;
                            break;
                            case GameCanvas.RIGHT_PRESSED:
                                Nave.setFrame(3);
                                dir=NRIGHT;
                            break;
                            case GameCanvas.FIRE_PRESSED:viva=false;
                                                         vidas=-1;
                                                         aparecer=false;

                            break;
                        }
                        
//direccion(), segun la direccion movemos la nave a un lado o a otro
                        switch(dir){
                            case NUP: if (y>30){
                                        y -= VEL;
                                    }
                            break;
                            case NDOWN: if (y<(getHeight()-imgBarraP.getHeight()-imgNave.getHeight()-imgMaloAr.getHeight())){
                                            y += VEL;
                                        }
                            break;
                            case NLEFT: if (x>20){
                                            x -= VEL;
                            }
                            break;
                            case NRIGHT: if (x<(getWidth()-imgNave.getHeight()-imgMaloDe.getHeight()+6)){
                                        x += VEL;
                            }
                            break;
                        }
                        }
//malosmov(), movemos los malos
                        if(movHor == 0) {
                            if(maloHor1 >= 200){
                                maloHor1 = 200;
                                maloHor2 = 40;
                                movHor = 1;
                            }
                            maloHor1 +=3;
                            maloHor2 -=3;
                            }else {
                                if(maloHor2 >= 200){
                                maloHor1 = 40;
                                maloHor2 = 200;
                                movHor = 0 ;
                                }
                                maloHor1 -=3;
                                maloHor2 +=3;
                            }
                        if(movVer == 0) {
                            if(maloVer1 >= 245){
                                maloVer1 = 245;
                                maloVer2 = 40;
                                movVer = 1;
                            }
                            maloVer1 +=3;
                            maloVer2 -=3;
                        }else {
                            if(maloVer2 >= 245){
                            maloVer1 = 40;
                            maloVer2 = 245;
                            movVer = 0 ;
                            }
                            maloVer1 -=3;
                            maloVer2 +=3;
                        }

//cubos(), ponemos y animamos los cubos y minas
                        lCurrTick = System.currentTimeMillis();
                        if ((lCurrTick - lStart)>= lDelay){
                            lStart=lCurrTick;
                            if (cubeIndex<14){
                                cubeIndex++;
                            }else{
                                cubeIndex=0;
                            }
                            if (minaIndex<11){
                                minaIndex++;
                            }else{
                                minaIndex=0;
                            }
                            if (rocaIndex<23){
                                rocaIndex++;
                            }else{
                                rocaIndex=0;
                            }
                            if (balaIndex<7){
                                balaIndex++;
                            }else{
                                balaIndex=0;
                            }
                            if (popIndex<4){
                                popIndex++;
                            }else{
                                popIndex=0;
                            }
                            if(nacer){
                                if (nacerIndex<14){
                                    nacerIndex++;
                                }else{
                                    nacerIndex=0;
                                    nacer=false;
                                }
                            }
                        }
//dibujar fondo
                        g.setColor(0x000000);
                        g.fillRect(0, 0, getWidth(), getHeight());
                        g.setColor(0xffffff);
                        for (i=0; i<100; i++){
                            g.drawLine(fx[i], fy[i], fx[i], fy[i]);
                        }

//dibujar cubos

                        cubos = 0;

                        for (i = 0; i <= 4;i++){
                            for (j = 0; j <= 6; j++){
                                switch (basecubos[j][i]){
                                    case 1: CuboV.setPosition(48+(i*32), 44+(j*32));
                                            CuboV.setFrame(cubeIndex);
                                            CuboV.paint(g);
                                            if (CuboV.collidesWith(Nave, true) & viva){
                                                basecubos[j][i] = 10;
                                            }
                                            cubos++;
                                    break;
                                    case 2: CuboA.setPosition(48+(i*32), 44+(j*32));
                                            CuboA.setFrame(cubeIndex);
                                            CuboA.paint(g);
                                            if (CuboA.collidesWith(Nave, true) & viva){
                                                basecubos[j][i] += 10;
                                            }
                                            cubos++;
                                    break;
                                    case 3:  CuboR.setPosition(48+(i*32), 44+(j*32));
                                            CuboR.setFrame(cubeIndex);
                                            CuboR.paint(g);
                                            if (CuboR.collidesWith(Nave, true & viva)){
                                                basecubos[j][i] +=10;
                                            }
                                            cubos++;
                                    break;
                                    case 4:  Mina.setPosition(48+(i*32), 44+(j*32));
                                            Mina.setFrame(minaIndex);
                                            Mina.paint(g);
                                            if (Mina.collidesWith(Nave, true) & viva){
                                                basecubos[j][i] = 0;
                                                vidas--;
                                                viva = false;
                                                aparecer = false;
                                                getKeyStates();
                                                dir=7;
                                            }
                                    break;
                                    case 5:  CuboA.setPosition(48+(i*32), 44+(j*32));
                                            CuboA.setFrame(cubeIndex);
                                            CuboA.paint(g);
                                            if (CuboA.collidesWith(Nave, true) & viva){
                                                basecubos[j][i] +=10;
                                            }
                                            cubos++;
                                    break;
                                    case 6:  CuboR.setPosition(48+(i*32), 44+(j*32));
                                            CuboR.setFrame(cubeIndex);
                                            CuboR.paint(g);
                                            if (CuboR.collidesWith(Nave, true) & viva){
                                                basecubos[j][i] +=10;
                                            }
                                            cubos++;
                                    break;
                                    case 7:  if (!viva & vidas >= 0 & aparecer & !nacer){
                                                x= 48+(i*32);
                                                y = 44+(j*32);
                                                viva = true;
                                                dir=7;
                                                VEL=5;
                                                Nave.setFrame(0);
                                            }
                                            if (nacer){
                                                viva=true;
                                                x= 48+(i*32);
                                                y = 44+(j*32);
                                                Nacer.setPosition(x,y);
                                                Nacer.setFrame(nacerIndex);
                                                Nacer.paint(g);
                                                getKeyStates();
                                            }
                                    break;
                                    case 10:PopCubo.setPosition(48+(i*32), 44+(j*32));
                                            if(Nave.collidesWith(PopCubo, true) & viva){
                                                PopCubo.setFrame(popIndex);
                                                PopCubo.paint(g);
                                             }else{
                                                    basecubos[j][i] = 0;
                                             }
                                    break;
                                    case 12: CuboV.setPosition(48+(i*32), 44+(j*32));
                                            CuboV.setFrame(cubeIndex);
                                            CuboV.paint(g);
                                            if (CuboV.collidesWith(Nave, true) & viva){
                                            }else{
                                                basecubos[j][i] -= 11;
                                            }
                                            cubos++;
                                    break;
                                    case 13: CuboA.setPosition(48+(i*32), 44+(j*32));
                                            CuboA.setFrame(cubeIndex);
                                            CuboA.paint(g);
                                            if (CuboA.collidesWith(Nave, true) & viva){
                                            }else{
                                                basecubos[j][i] -= 11;
                                            }
                                            cubos++;
                                            break;
                                    case 15: CuboA.setPosition(48+(i*32), 44+(j*32));
                                            CuboA.setFrame(cubeIndex);
                                            CuboA.paint(g);
                                            if (CuboA.collidesWith(Nave, true) & viva){
                                            }else{
                                                basecubos[j][i] -= 11;
                                            }
                                    break;
                                    case 16: CuboR.setPosition(48+(i*32), 44+(j*32));
                                             CuboR.setFrame(cubeIndex);
                                             CuboR.paint(g);
                                             if (CuboR.collidesWith(Nave, true) & viva){
                                             }else{
                                                basecubos[j][i] -= 12;
                                            }
                                    break;
                                }
                            }
                        }

//dibujamos los meteoritos
                        for (i=0;i<nrocas;i++){
                            if (!rcreada[i]){
                            rpos[i] = (Math.abs((rand.nextInt()>>>1) % (4)));
                            switch(rpos[i]){
                                case 0: ax[i]=-Roca.getWidth()+2;
                                        ay[i]=-Roca.getHeight()+2;
                                        rcreada[i]=true;
                                        rmov[i]=0;
                                break;
                                case 1: ax[i]=getWidth();
                                        ay[i]=-Roca.getHeight();
                                        rcreada[i]=true;
                                        rmov[i]=1;
                                break;
                                case 2: ax[i]=-Roca.getWidth();
                                        ay[i]=getHeight();
                                        rcreada[i]=true;
                                        rmov[i]=2;
                                break;
                                case 3: ax[i]=getWidth();
                                        ay[i]=getHeight();
                                        rcreada[i]=true;
                                        rmov[i]=3;
                                break;

                            }
                            avelx[i] = (Math.abs((rand.nextInt()>>>1) % (2))+1);
                            avely[i] = (Math.abs((rand.nextInt()>>>1) % (2))+1);
                            }
                            switch (rmov[i]){
                                case 0: if (ax[i]<(getWidth()+5) & ay[i]<(getHeight()+5)){
                                            ax[i] += avelx[i];
                                            ay[i] += avely[i];
                                        }else{
                                            rcreada[i]=false;
                                    }
                                break;
                                case 1: if (ax[i]>-5-Roca.getWidth() & ay[i]<(getHeight()+Roca.getHeight()+5)){
                                            ax[i] -= avelx[i];
                                            ay[i] += avely[i];
                                        }else{
                                            rcreada[i]=false;
                                        }
                                break;
                                case 2: if (ax[i]<(getWidth()+5) & ay[i]>-5-Roca.getHeight()){
                                            ax[i] += avelx[i];
                                            ay[i] -= avely[i];
                                        }else{
                                            rcreada[i]=false;
                                        }
                                break;
                                case 3: if (ax[i]>-5-Roca.getWidth() & ay[i]>-5-Roca.getHeight()){
                                            ax[i] -= avelx[i];
                                            ay[i] -= avely[i];
                                        }else{
                                            rcreada[i]=false;
                                        }
                                break;
                            }
                        }

//crear bolas de fuegoou! yiiiiha!
                        for (j=0;j<nbalas;j++){
                            if (!bcreada[j]){
                                bpos[j] = (Math.abs((rand.nextInt()>>>1) % (4)));
                                switch (bpos[j]){
                                    case 0: bx[j]=maloHor1;
                                            by[j]=20;
                                            bcreada[j]=true;
                                            bmov[j]=0;
                                    break;
                                    case 1: bx[j]=maloHor2;
                                            by[j]=getHeight()-imgBarraP.getHeight()-(imgMaloAr.getHeight()/2)-5 ;
                                            bcreada[j]=true;
                                            bmov[j]=1;
                                    break;
                                    case 2: bx[j]=10;
                                            by[j]=maloVer1;
                                            bcreada[j]=true;
                                            bmov[j]=2;
                                    break;
                                    case 3: bx[j]=getWidth()-10;
                                            by[j]=maloVer2;
                                            bcreada[j]=true;
                                            bmov[j]=3;
                                    break;
                                }
                            }
                            switch (bmov[j]){
                                case 0: if (by[j]<getHeight()-imgBarraP.getHeight()){
                                            by[j]+=3;
                                        }else{
                                            bcreada[j]=false;
                                        }
                                break;
                                case 1: if (by[j]>(-imgBala.getHeight())){
                                            by[j]-=3;
                                        }else{
                                            bcreada[j]=false;
                                        }
                                break;
                                case 2: if (bx[j]<getWidth()){
                                            bx[j]+=3;
                                        }else{
                                            bcreada[j]=false;
                                        }
                                break;
                                case 3: if (bx[j]>(-imgBala.getWidth())){
                                            bx[j]-=3;
                                        }else{
                                            bcreada[j]=false;
                                        }
                                break;
                            }
                        }
//colisiones Roca-nave, bala-nave, bala-roca y dibujarlo todo!

                        for (j=0;j<nbalas;j++){
                            Bala.setPosition(bx[j], by[j]);
                            Bala.setFrame(balaIndex);
                            Bala.paint(g);
                            if (Bala.collidesWith(Nave, true) & viva & !nacer){
                                    viva=false;
                                    vidas--;
                                    aparecer=false;
                                    getKeyStates();
                                    dir=7;
                            }

                            for (i=0;i<nrocas;i++){
                                Roca.setPosition(ax[i], ay[i]);
                                Roca.setFrame(rocaIndex);
                                Roca.paint(g);
                                
                                if (Roca.collidesWith(Nave, true) & viva & !nacer){
                                    vidas--;
                                    viva = false;
                                    aparecer = false;
                                    getKeyStates();
                                    dir=7;
                                }
                                if(Bala.collidesWith(Roca, true)){
                                    bcreada[j]=false;
                                }
                        }
                        }


//dibujamos los malos
                        g.drawImage(imgMaloAr, maloHor2, getHeight()-imgBarraP.getHeight()-(imgMaloAr.getHeight()/2)-2 ,Graphics.VCENTER | Graphics.HCENTER);
                        g.drawImage(imgMaloAb, maloHor1,10,Graphics.VCENTER | Graphics.HCENTER);
                        g.drawImage(imgMaloDe, 10,maloVer1,Graphics.VCENTER | Graphics.HCENTER);
                        g.drawImage(imgMaloIz, getWidth()-10, maloVer2,Graphics.VCENTER | Graphics.HCENTER);

//si los cubos son =0 incrementamos nivel (y mientras escondemos la nave)
                        if (cubos==0){
                            nivel++;
                            x=-30;
                            y=-30;
//si la nave esta viva la dibujamos en su posicion
//y la ultima vez que muere esperamos a que explote para mostrar el menu
                        }
                        if (viva & !nacer){
                            Nave.setPosition(x, y);
                            Nave.paint(g);
                            }
                            if (vidas<0 & !viva){
                                vidas=0;
                                esperar=true;
                            }
//si la nave no esta viva no la ponemos sino que ponemos la explosión!
                        if (!viva){
                            lCurrTick = System.currentTimeMillis();
                            if ((lCurrTick - lStart2)>= lDelay2){
                                lStart2=lCurrTick;
                                if (explIndex<15){
                                    explIndex++;
                                }else{
                                    explIndex=0;
                                    aparecer = true;
                                    nacer = true;
                                }
                            }
                            Expl.setFrame(explIndex);
                            Expl.setPosition(x, y);
                            Expl.paint(g);
                            getKeyStates();
                        }
//una vez se ha gastado la ultima vida y ha explotado la nave acabamos y vamos al menu
                        if(vidas==0 & esperar & explIndex==15){
                            acabar=true;
                        }

//barra con las vidas y nivel
                        g.drawImage(imgBarraP, 0, getHeight()-imgBarraP.getHeight(), Graphics.TOP | Graphics.LEFT);
                        for (i=0; i< vidas;i++){
                            g.drawImage(imgVidas,3+imgVidas.getWidth()*i,getHeight()-imgBarraP.getHeight()+((imgBarraP.getHeight()-imgVidas.getHeight())/2), Graphics.TOP | Graphics.LEFT);
                        }
                        g.setColor(0xffffff);
                        g.drawString("   Level: "+Integer.toString(nivel), getWidth()/2, getHeight()-imgBarraP.getHeight(), Graphics.TOP | Graphics.LEFT);

                        flushGraphics();

                        try{
                            Thread.sleep(30);
                        } catch (Exception ex){
                        }
                    }
                }
            break;
//Mostramos el setup
            case 1: tecla=0;
                    teclaant=GameCanvas.FIRE_PRESSED;
                    i=0;
                    g.drawImage(imgMenuBg, 0, 0, Graphics.LEFT | Graphics.TOP);
                    g.drawImage(imgSetupOn, 5, 10, Graphics.LEFT | Graphics.TOP);
                    g.setColor(0xffffff);
                    g.drawString("       Solar Wolf ME", 10, imgCredsOn.getHeight()+10, Graphics.LEFT | Graphics.TOP);
                    g.drawString("No tengo tiempo para un setup", 10, imgCredsOn.getHeight()+30, Graphics.LEFT|Graphics.TOP);
                    while (!acabar){
                        getKeyStates();
                        tecla=getKeyStates();
                        if ((tecla==teclaant)){
                            i++;
                        }
                        if (tecla!=teclaant | i>2){
                            i=0;
                            if (tecla==GameCanvas.FIRE_PRESSED){
                                acabar=true;
                            }
                        }
                        teclaant = tecla;
                        flushGraphics();
                        try{
                            Thread.sleep(50);
                        } catch (Exception ex){
                            }
                    }
                    acabar=false;
            break;
//Mostramos los creditos
            case 2: tecla=0;
                    teclaant=GameCanvas.FIRE_PRESSED;
                    i=0;
                    g.drawImage(imgMenuBg, 0, 0, Graphics.LEFT | Graphics.TOP);
                    g.drawImage(imgCredsOn, 5, 10, Graphics.LEFT | Graphics.TOP);
                    g.drawImage(imgCredsTxt, 5, imgCredsOn.getHeight()+5, Graphics.LEFT | Graphics.TOP);
                    g.setColor(0xffffff);
                    while (!acabar){
                        getKeyStates();
                        tecla=getKeyStates();
                        if ((tecla==teclaant)){
                            i++;
                        }
                        if (tecla!=teclaant | i>2){
                            i=0;
                            if (tecla==GameCanvas.FIRE_PRESSED){
                                acabar=true;
                            }
                        }
                        teclaant = tecla;
                        flushGraphics();
                        try{
                            Thread.sleep(50);
                        } catch (Exception ex){
                            }
                    }
                    acabar=false;
            break;
            }
    }
    g = null;
    unload();
    fParent.destroyApp(false);
    fParent = null;
 }
}
