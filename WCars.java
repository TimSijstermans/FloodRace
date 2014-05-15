

/**
 * Write a description of class WCars here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WCars extends WCollidable
{
    protected boolean drivable;
    protected int direction;
    protected int health; 
    
    long currentTime;
    long prevTime = 0;
    int interval = 25;
    
    Wijk1 _World;
    
    public WCars() { }  
    
    public void act() {
        
        _World = (Wijk1) getWorld();
        currentTime = System.currentTimeMillis();
        
        if (!_World.gamePaused)
        {
            
            if (currentTime - prevTime > interval){
                prevTime = currentTime;
                
                if(drivable){
                    if (direction == 0){  
                        
                        WItems item = (WItems) getOneObjectAtOffset(-getWidth()/2, 0, WItems.class);
                        
                        // als de auto met de voorkant een player hit, gameover
                        if (getOneObjectAtOffset(-getWidth()/2, 0, WPlayer.class) != null)
                            _World.createGameOverMenu();
                            // als de auto met een item in aanraking komt, wordt deze beschadigd en de auto verwijderd. Als het item 4x aangereden wordt verwijderd het item ook.
                        else if (item != null && item.getCollisionTimes() < 4 && item.isPlaced()){
                            item.addTime();
                            _World.removeObject(this);
                        }
                        else if (item != null && item.getCollisionTimes() == 4 && item.isPlaced()){
                            _World.removeObject(this);
                            item.replaceSW();
                            
                            _World.removeObject(item);
                            addCounter(item);
                        }
                        else
                        {
                            setDimensions(getX(), getY());
                            move(-4);
                            
                            if (checkBorder())
                                getWorld().removeObject(this);  
                        }
                    }     
                    // zelfde als hierboven, alleen dan andere kant op.
                    else if (direction == 1){
                        WItems item = (WItems) getOneObjectAtOffset(getWidth()/2, 0, WItems.class);
                        
                        if (getOneObjectAtOffset(getWidth()/2, 0, WPlayer.class) != null)
                            _World.createGameOverMenu();
                        else if (item != null && item.getCollisionTimes() < 4 && item.isPlaced()){
                            item.addTime();
                            _World.removeObject(this);
                        }
                        else if (item != null && item.getCollisionTimes() == 4 && item.isPlaced()){
                            _World.removeObject(this);
                            _World.removeObject(item);
                            
                            addCounter(item);
                        }
                        else
                        {
                            setDimensions(getX(), getY());
                            move(4);
                            
                            if (checkBorder())
                                getWorld().removeObject(this);  
                        }
                    }
                    
                   
               
                       
                }
            }
        }
    }
    
    public int getDirection() {
        return direction;
    }
    
    public boolean checkBorder() {
        if (direction == 0) {
            if(getX() - 100 < 0)
                return true;
            else
                return false;
        }
        else {
            if(getX() + 15 > getWorld().getWidth())
                    return true;
                else
                    return false;
        }
    }
    
    public void addCounter(WItems item) {
        if (item.getClass().equals(WCement.class))
            _World.getCementCounter().add();
        else if (item.getClass().equals(WGrind.class))
            _World.getGrindCounter().add();
        else if (item.getClass().equals(WZand.class))
            _World.getZandCounter().add();
   }
}
