import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.*;

import java.util.List;
/**
 * Write a description of class WPlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WPlayer extends Actor
{
    //Alle verschillende richtingen
    private static final int EAST = 0;
    private static final int WEST = 1;
    private static final int NORTH = 2;
    private static final int SOUTH = 3;
    private static final int STOP = 4;
    
    // Zwaardtes van items
    private static final int HEAVY = 5;
    private static final int MIDHEAVY = 6;
    private static final int LIGHT = 7;
    
    private int walkspeed = 8;
    
    private int _WheightPlayer,
                _WwidthPlayer,
                _heightPlayer,
                _widthPlayer,
                _outerPlayerRight,
                _outerPlayerBottom,
                _outerPlayerLeft,
                _outerPlayerTop;
    
    private int interval = 30;         
    private long prevTime = 0;
    private int prevImage = 1;
    private WCollidable collidingObject;
    private Wijk1 _World;
    private WItems holdingItem;
    
    private boolean spaceKeyPressed = false;
    
    public WPlayer() {
        setImage("WPlayer1.png");  
        GreenfootImage image = getImage();
        image.scale(22, 22);
        
        holdingItem = new WItems();        
    }
    
    public void act() {
        _World = (Wijk1) getWorld();
        
        if (!_World.gamePaused)
            {
            playerInit();
            //Als de speler tegen het water aan loopt stopt het spel.
            if (getOneObjectAtOffset(-10, 0, WWater.class) != null || getOneObjectAtOffset(10, 0, WWater.class) != null 
            || getOneObjectAtOffset(0, 10, WWater.class) != null || getOneObjectAtOffset(0, -10, WWater.class) != null){
                _World.createGameOverMenu();    
            }
            
            checkDirection();
            
            
            if (Greenfoot.isKeyDown("space"))
            {
                if (!spaceKeyPressed)
                {
                    // Wanneer je geen item vast hebt
                    if (holdingItem.getClass().equals(WItems.class))
                        checkStack(collidingObject);
                    else if (!holdingItem.checkOffset())
                    {
                        // Wanneer je een object vast hebt zet hem neer. 
                       holdingItem.setDimensions(holdingItem.getX(), holdingItem.getY());
                       
                       holdingItem = new WItems();
                       
                       walkspeed = 8;
                    } 
                    spaceKeyPressed = true;
                }  
            }
            else
                spaceKeyPressed = false;
        } 
    }   
    
    public void playerInit()
    {
         //Hier berekent hij de buitenste kanten van de speler.
         _WheightPlayer = getImage().getHeight();
         _WwidthPlayer = getImage().getWidth();
         _heightPlayer = _WheightPlayer / 2;
         _widthPlayer = _WwidthPlayer / 2;
         _outerPlayerRight = getX() + _widthPlayer;
         _outerPlayerBottom = getY() + _heightPlayer;
         _outerPlayerLeft = getX() - _widthPlayer;
         _outerPlayerTop = getY() - _heightPlayer;
    }
    
    public void checkDirection() {
            if(Greenfoot.isKeyDown("d")){
                long currentTime = System.currentTimeMillis();
                                            
                if (currentTime - prevTime > interval)
                {
                    prevTime = currentTime;
                    
                    if (prevImage == 16)
                        prevImage = 1;
                    
                    prevImage++;
                    //hier maakt hij van het mannetje een lopend mannetje door verschillende plaatsen.
                    setImage("images/WPlayer" + prevImage +".png");
                    GreenfootImage image = getImage();
                    image.scale(22, 22);                        
                    getImage().rotate(90);
                    checkCollidable(EAST);

                }
                
                if (!holdingItem.getClass().equals(WItems.class))
                    holdingItem.move(EAST, getX(), getY());
            }
            else if(Greenfoot.isKeyDown("a")){
                long currentTime = System.currentTimeMillis();
                
                if (currentTime - prevTime > interval)
                {
                    prevTime = currentTime;
                    
                    if (prevImage == 16)
                        prevImage = 1;
                    
                    prevImage++;
                    //hier maakt hij van het mannetje een lopend mannetje door verschillende plaatsen.
                    setImage("images/WPlayer" + prevImage +".png");
                    GreenfootImage image = getImage();
                    image.scale(22, 22);                                
                    getImage().rotate(270);
                    checkCollidable(WEST);
                    
                }
                
                if (!holdingItem.getClass().equals(WItems.class))
                    holdingItem.move(WEST, getX(), getY());
            }
            
            else if(Greenfoot.isKeyDown("s")){
                long currentTime = System.currentTimeMillis();
                
                if (currentTime - prevTime > interval)
                {
                    prevTime = currentTime;
                    
                    if (prevImage == 16)
                        prevImage = 1;
                    
                    prevImage++;
                    //hier maakt hij van het mannetje een lopend mannetje door verschillende plaatsen.
                    setImage("images/WPlayer" + prevImage +".png");  
                    GreenfootImage image = getImage();
                    image.scale(22, 22);  
                    getImage().rotate(180);
                    checkCollidable(SOUTH);
                    
                }
                
                if (!holdingItem.getClass().equals(WItems.class))
                    holdingItem.move(SOUTH, getX(), getY()); 
            }
            else if(Greenfoot.isKeyDown("w")){
                long currentTime = System.currentTimeMillis();
                
                if (currentTime - prevTime > interval)
                {
                    prevTime = currentTime;
                    
                    if (prevImage == 16)
                        prevImage = 1;
                    
                    prevImage++;
                    //hier maakt hij van het mannetje een lopend mannetje door verschillende plaatsen.
                    setImage("images/WPlayer" + prevImage +".png");
                    GreenfootImage image = getImage();
                    image.scale(22, 22);  
                    checkCollidable(NORTH);
                }
                
                if (!holdingItem.getClass().equals(WItems.class))
                    holdingItem.move(NORTH, getX(), getY()); 
            }
    }    
    
    private void checkCollidable(int direction){
    
        @SuppressWarnings("unchecked")
        List<WCollidable> collidables = null;

        collidables = getObjectsInRange(200, WCollidable.class);
            
        int marge = 20;
        boolean collide = false;
        collidingObject = new WCollidable();
        
        switch(direction) {
        case EAST:
             _outerPlayerRight += 1;
             _outerPlayerBottom += 1; 
             _outerPlayerLeft += 1;
             _outerPlayerTop += 1;
             
             // Loop voor alle collidables in de buurt
             for (WCollidable collidable : collidables)
             {
                 // Kijkt of het object ook daadwerkelijk ernaast zit. en zet het in variable
                 WCollidable atOffsetPlayerHeight = (WCollidable) getOneObjectAtOffset(marge, -_heightPlayer, collidable.getClass());
                 WCollidable atOffsetPlayerY = (WCollidable) getOneObjectAtOffset(marge, 0, collidable.getClass());
                 
                 if ( 
                             collidable.isPlaced() // Kijkt of de collidable geplaatst is op het scherm. 
                         &&  
                             (        // Hoogte van player vergelijken met de hoogte van het object
                                     ( _outerPlayerTop >= collidable.getOuterTop() && _outerPlayerTop <= collidable.getOuterBottom() )
                                 ||  // Middelpunt Y van player vergelijken met de hoogte van het object
                                     ( getY() < collidable.getOuterBottom() && getY() > collidable.getOuterTop() ) 
                             ) 
                         && 
                             _outerPlayerRight > (collidable.getOuterLeft() - marge)  // De linkermarge    
                         &&  
                             ( 
                                    (atOffsetPlayerHeight != null && atOffsetPlayerHeight.isPlaced()) // Kijkt of object geplaatst is
                                 ||  
                                    (atOffsetPlayerY != null && atOffsetPlayerY.isPlaced()) // Kijkt of object geplaatst is
                             )
                   
                         ||// Kijkt of object geplaatst is
                            collidable.isPlaced() 
                         &&
                             (// Kijkt of onderkant player binnen hoogte van Bovenkant object en onderkant object bevind
                                            (_outerPlayerBottom >= collidable.getOuterTop() && _outerPlayerBottom <= collidable.getOuterBottom() ) 
                                      || // Kijkt of middelpunt player binnen hoogte van Bovenkant object en onderkant object bevind
                                            (getY() < collidable.getOuterBottom() && getY() > collidable.getOuterTop() ) 
                              )
                         && 
                              _outerPlayerRight > (collidable.getOuterLeft() - marge) // De linkermarge            
                        && 
                             (  
                                        ( atOffsetPlayerHeight != null && atOffsetPlayerHeight.isPlaced() )// Kijkt of object geplaatst is
                                    ||  
                                        ( atOffsetPlayerY != null && atOffsetPlayerY.isPlaced() )// Kijkt of object geplaatst is
                             )
                       ) {

                             collide = true;
                             collidingObject = collidable;
                             break;
                 }
             }
             
             if (collide) 
             {
                 if(Greenfoot.isKeyDown("d"))
                     walk(STOP);
                 else if(Greenfoot.isKeyDown("a"))
                     walk(WEST);
                 else if(Greenfoot.isKeyDown("s"))
                     walk(SOUTH);
                 else if(Greenfoot.isKeyDown("w"))
                     walk(NORTH);
             }
             else 
             {
                 if (Greenfoot.isKeyDown("d"))
                     walk(EAST);
                 else if (Greenfoot.isKeyDown("a"))
                     walk(WEST);
                 else if (Greenfoot.isKeyDown("s"))
                     walk(SOUTH);    
                 else if (Greenfoot.isKeyDown("w"))
                     walk(NORTH);
            }
            break;
        case WEST:
             _outerPlayerRight -= 4;
             _outerPlayerBottom -= 4; 
             _outerPlayerLeft -= 4;
             _outerPlayerTop -= 4;

             for (WCollidable collidable : collidables)
             {
                 WCollidable atOffsetPlayerHeight = (WCollidable) getOneObjectAtOffset(-marge, -_heightPlayer, collidable.getClass());
                 WCollidable atOffsetPlayerY = (WCollidable) getOneObjectAtOffset(-marge, 0, collidable.getClass());
                 
                 if(
                         collidable.isPlaced() 
                         && 
                         (
                                 (_outerPlayerTop >= collidable.getOuterTop() && _outerPlayerTop <= collidable.getOuterBottom() 
                            || 
                                 (getY() < collidable.getOuterBottom() && getY() > collidable.getOuterTop()) 
                         ) 
                         &&
                                 _outerPlayerLeft < (collidable.getOuterRight() + marge)
                         &&
                             (
                                        ( atOffsetPlayerHeight != null && atOffsetPlayerHeight.isPlaced() )
                                    ||  
                                        ( atOffsetPlayerY != null && atOffsetPlayerY.isPlaced() )
                             )
                     ||
                        (
                                    (_outerPlayerBottom >= collidable.getOuterTop() && _outerPlayerBottom <= collidable.getOuterBottom())
                                || 
                                    (getY() < collidable.getOuterBottom() && getY() > collidable.getOuterTop())
                        ) 
                        &&
                            _outerPlayerLeft < (collidable.getOuterRight() + marge) 
                        && 
                            (
                                        ( atOffsetPlayerHeight != null && atOffsetPlayerHeight.isPlaced() )
                                    ||  
                                        ( atOffsetPlayerY != null && atOffsetPlayerY.isPlaced() )
                            )
                        )){

                     collide = true;
                     collidingObject = collidable;
                     break;
                 }
             }
             
             
             if (collide)
             {
                 if(Greenfoot.isKeyDown("d"))
                     walk(WEST);
                 else if(Greenfoot.isKeyDown("a"))
                     walk(STOP);
                 else if(Greenfoot.isKeyDown("s"))
                     walk(SOUTH);
                 else if(Greenfoot.isKeyDown("w"))
                     walk(NORTH);
             }
             else
             {
                 if (Greenfoot.isKeyDown("d"))
                     walk(EAST);
                 else if (Greenfoot.isKeyDown("a"))
                     walk(WEST);
                 else if (Greenfoot.isKeyDown("s"))
                     walk(SOUTH);    
                 else if (Greenfoot.isKeyDown("w"))
                     walk(NORTH);
             }
            break;
        case SOUTH:
            _outerPlayerRight += 1;
            _outerPlayerBottom += 1; 
            _outerPlayerLeft += 1;
            _outerPlayerTop += 1;        

            for (WCollidable collidable : collidables)
            {
                WCollidable atOffsetPlayerHeight = (WCollidable) getOneObjectAtOffset(-_widthPlayer, marge, collidable.getClass());
                WCollidable atOffsetPlayerY = (WCollidable) getOneObjectAtOffset(0, marge, collidable.getClass());
                
                if(
                            collidable.isPlaced() 
                        && 
                            (
                                        (_outerPlayerLeft >= collidable.getOuterLeft() && _outerPlayerLeft <= collidable.getOuterRight())
                                    || 
                                        (getX() > collidable.getOuterLeft() && getX() < collidable.getOuterRight())
                            ) 
                        && 
                            _outerPlayerBottom > (collidable.getOuterTop() - marge) 
                        && 
                            (
                                        ( atOffsetPlayerHeight != null && atOffsetPlayerHeight.isPlaced() )
                                    ||  
                                        ( atOffsetPlayerY != null && atOffsetPlayerY.isPlaced() )
                            )
                        ||
                            (   
                                        (_outerPlayerRight >=  collidable.getOuterLeft() && _outerPlayerRight <= collidable.getOuterRight()) 
                                    || 
                                        (getX() > collidable.getOuterLeft() && getX() < collidable.getOuterRight()) 
                            )
                        &&  
                            _outerPlayerBottom > (collidable.getOuterTop() - marge) 
                        && 
                            (
                                        ( atOffsetPlayerHeight != null && atOffsetPlayerHeight.isPlaced() )
                                    ||  
                                        ( atOffsetPlayerY != null && atOffsetPlayerY.isPlaced() )
                            )
                    ){
    
                        collide = true;
                        collidingObject = collidable;
                        break;
                }
            }
            
            if (collide)
            {
                if(Greenfoot.isKeyDown("d"))
                    walk(EAST);
                else if(Greenfoot.isKeyDown("a"))
                    walk(WEST);
                else if(Greenfoot.isKeyDown("s"))
                    walk(STOP);
                else if(Greenfoot.isKeyDown("w"))
                    walk(NORTH);
            }
            else 
            {
                if (Greenfoot.isKeyDown("d"))
                    walk(EAST);
                else if (Greenfoot.isKeyDown("a"))
                    walk(WEST);
                else if (Greenfoot.isKeyDown("s"))
                    walk(SOUTH);    
                else if (Greenfoot.isKeyDown("w"))
                    walk(NORTH);
            }
            break;
        case NORTH:

            for (WCollidable collidable : collidables)
            {
                WCollidable atOffsetPlayerHeight = (WCollidable) getOneObjectAtOffset(-_widthPlayer, -marge,collidable.getClass());
                WCollidable atOffsetPlayerY = (WCollidable) getOneObjectAtOffset(0, -marge, collidable.getClass());
                
                if(
                        collidable.isPlaced() 
                        &&  
                            (
                                    (_outerPlayerLeft >= collidable.getOuterLeft() && _outerPlayerLeft <= collidable.getOuterRight())
                                || 
                                    (getX() > collidable.getOuterLeft() && getX() < collidable.getOuterRight())
                            ) 
                        && 
                                _outerPlayerTop < (collidable.getOuterBottom() + marge) 
                        && 
                            (
                                        ( atOffsetPlayerHeight != null && atOffsetPlayerHeight.isPlaced() )
                                    ||  
                                        ( atOffsetPlayerY != null && atOffsetPlayerY.isPlaced() ) 
                            )
                        ||                                                                                         
                        (
                                (_outerPlayerRight >= collidable.getOuterLeft() && _outerPlayerRight <= collidable.getOuterRight()) 
                            || 
                                (getX() > collidable.getOuterLeft() && getX() < collidable.getOuterRight())
                        ) 
                        &&  
                            _outerPlayerTop < (collidable.getOuterBottom() + marge) 
                        && 
                           (
                                        ( atOffsetPlayerHeight != null && atOffsetPlayerHeight.isPlaced() )
                                    ||  
                                        ( atOffsetPlayerY != null && atOffsetPlayerY.isPlaced() )
                           )
               ){
        
                        collide = true;
                        collidingObject = collidable;
                        break;
                }
            }
            
            if (collide)
            {
                if(Greenfoot.isKeyDown("d")){
                    walk(EAST); 
                }
                else if(Greenfoot.isKeyDown("a")){
                    walk(WEST);
                }
                else if(Greenfoot.isKeyDown("s")){
                    walk(SOUTH);
                }
                else if(Greenfoot.isKeyDown("w")){
                    walk(STOP);
                }
            }
            else
            {
                if (Greenfoot.isKeyDown("d")){
                    walk(EAST);
                }
                else if (Greenfoot.isKeyDown("a")){
                    walk(WEST);
                }
                else if (Greenfoot.isKeyDown("s")){
                    walk(SOUTH);
                }
                else if (Greenfoot.isKeyDown("w")){
                    walk(NORTH);
                }  
            }            
            break;
        }     
    }
    
    // De beweeg methode naar een bepaalde richting
    private void walk(int direction) {
        switch(direction) {//Hier loopt hij daadwerkelijk als er geen collision in die richting is.
            case EAST:
                if (!checkCollisionBorder(EAST))
                    setLocation(getX() + walkspeed, getY());   
                break;
            case WEST:
                if (!checkCollisionBorder(WEST))
                    setLocation(getX() - walkspeed, getY());
                break;
           case SOUTH:
                if (!checkCollisionBorder(SOUTH))
                    setLocation(getX(), getY() + walkspeed);
                break;
            case NORTH:
                if (!checkCollisionBorder(NORTH))
                    setLocation(getX(), getY() - walkspeed);
                break;
            case STOP:
                if (!checkCollisionBorder(STOP))
                    setLocation(getX(), getY());
                break;                
        }
    }
    
    // Check of object binnen de border is of er tegen aan
    private boolean checkCollisionBorder(int direction) {
        int xWorld = getWorld().getWidth();
        int yWorld = getWorld().getHeight();
        
        int x = getX();
        int y = getY();
        // hier checkt hij of de speler niet uit de wereld kan lopen.
        if (getX() >= xWorld || getY() >= yWorld || getX() <= 0 || getY() <= 0)
            return false;

        switch(direction) {
            case EAST:
                x += 15;
                break;
            case WEST:
                x -= 15;
                break;
                case NORTH:
                y -= 15;
                break;
            case SOUTH:
                y += 15;
                break;
            case STOP:
                y += 0;
                x += 0;
                break;                
        }
        
        if (x > xWorld || y > yWorld)
            return true;
        
        if (x < 0 || y < 0)
            return true;
        
        return false;
    }
    
    // Kijkt tegen welke stack de player staat. En bepaalt daarna wel item hij moet dragen
    private void checkStack(WCollidable stack) {
        _World = (Wijk1) getWorld();
        //hier pakt de speler een zak en gaat er 1 van de counter af.
        if (stack.getClass().equals(WCementStack.class)) {
            if (holdingItem.getClass().equals(WItems.class)) {
                if (_World.getCementCounter().getCount() > 0){
                    WItems cement = new WCement(false);
                    getWorld().addObject(cement, getX(), getY() - 20);
                    
                    _World.getCementCounter().takeItem();
                    
                    holdingItem = cement;
                    
                    walkspeed = HEAVY;
                }
            }
        }
            
        if (stack.getClass().equals(WZandStack.class)) {
            if (holdingItem.getClass().equals(WItems.class)) {
                if (_World.getZandCounter().getCount() > 0){
                    WItems zand = new WZand(false);
                    getWorld().addObject(zand, getX(), getY() - 20);
                    
                    _World.getZandCounter().takeItem();
                    
                    holdingItem = zand;
                    
                    walkspeed = LIGHT;
                }
                
            }
        }
        
        if (stack.getClass().equals(WGrindStack.class)) {
            if (holdingItem.getClass().equals(WItems.class)) {
                if (_World.getGrindCounter().getCount() > 0) {
                    WItems grind = new WGrind(false);
                    getWorld().addObject(grind, getX(), getY() - 20);
                    
                    _World.getGrindCounter().takeItem();
                    
                    holdingItem = grind;
                    
                    walkspeed = MIDHEAVY;
                }
                
            }
        }
    }
}
