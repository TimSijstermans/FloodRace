import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Objecten here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Objecten extends Actor
{
    private Actor _DraggableFake;
    
    private int _RealX;
    private int _RealY;
    
    protected boolean _isSelected = false;
    protected boolean _isFake;
    protected int _Type;
    
    int size = 0;
    
    /**
     * Act - do whatever the Objecten wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        DijkWorld dijkWorld = (DijkWorld) getWorld();
        Counter counter = dijkWorld.getCounter(_Type);
        
        if (_isFake)
        {
            if (!_isSelected && Greenfoot.mousePressed(this))
            {
                _isSelected = true;
                
                _RealX = getX();
                _RealY = getY();
                
                _DraggableFake = getObject();
                getWorld().addObject(_DraggableFake, _RealX, _RealY);
                
                return;
            }
            
            if (_isSelected && Greenfoot.mouseDragged(this)) 
            {
                MouseInfo mi = Greenfoot.getMouseInfo(); // gets mouse information
                setLocation(mi.getX(), mi.getY()); // sets location of piece at location of mouse
                return;
            }
            
            if (_isSelected && Greenfoot.mouseDragEnded(this))
            {
                _isSelected = false;
                
                getWorld().removeObject(_DraggableFake);
                
                MouseInfo info = Greenfoot.getMouseInfo();
                
                if(counter.getCount() > 0){
                    if ( info.getY() > 9 && info.getY() < 28)
                        {
                            Actor water1;
                            Actor water2;
                            Actor water3;
                            Actor water4;
                            Actor water5;
                            switch (size)
                            {
                                case 1: water1 = getOneObjectAtOffset (0,0,Water.class);
                                        if ( water1 == null )
                                        {
                                            getWorld().addObject(getObject(),info.getX(),info.getY()); 
                                            counter.bumpCount(-1);
                                        }
                                        break;
                                case 3: water1 = getOneObjectAtOffset (0,0,Water.class);
                                        water2 = getOneObjectAtOffset (-1,0,Water.class);
                                        water3 = getOneObjectAtOffset (1,0,Water.class);
                                        if ( water1 == null && water2 == null && water3 == null )
                                        {
                                            getWorld().addObject(getObject(),info.getX(),info.getY()); 
                                            counter.bumpCount(-1);
                                        }
                                        break;
                                case 5: water1 = getOneObjectAtOffset (0,0,Water.class);
                                        water2 = getOneObjectAtOffset (-1,0,Water.class);
                                        water3 = getOneObjectAtOffset (1,0,Water.class);
                                        water4 = getOneObjectAtOffset (-2,0,Water.class);
                                        water5 = getOneObjectAtOffset (2,0,Water.class);
                                        if ( water1 == null && water2 == null && water3 == null && water4 == null && water5 == null )
                                        {
                                            getWorld().addObject(getObject(),info.getX(),info.getY()); 
                                            counter.bumpCount(-1);
                                        }
                                        break;
                            }
                        }
                    }
                
                setLocation(_RealX, _RealY);   
            }
        }
    }    

    public Actor getObject() {
        Actor object = new Objecten();
        switch(_Type)
            {
                case 1:
                    object = new Zandzak(false);
                    size = 3;
                    break; 
                case 2:
                    object = new Papier(false);
                    size = 1;
                    break;
                case 3: 
                    object = new Grind(false);
                    size = 3;
                    break;
                case 4: 
                    object = new Karton(false);
                    size = 1;
                    break;
                case 5: 
                    object = new Cement(false);
                    size = 5;
                    break;
            }
            
            return object;
    }   
}
