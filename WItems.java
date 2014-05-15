import java.util.List;
/**
 * Write a description of class WItems here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WItems extends WCollidable
{         
    private int _Weight;
    private int _CollisionTimes = 0;

    public WItems() { }  

    public void move(int direction, int actorX, int actorY) {
       
        // move with the player
        switch(direction) {
            case 0: // RIGHT
            setLocation(actorX + 20, actorY);
            break;
            case 1: // LEFT
            setLocation(actorX - 20, actorY);
            break;

            case 2: // UP
            setLocation(actorX, actorY - 20);
            break;

            case 3: // DOWN
            setLocation(actorX, actorY + 20);
            break;
        }
    }
    
    // check of er een collidable object onder staat
    public boolean checkOffset() {
        if (getOneObjectAtOffset(0, 0, WCollidable.class) != null)
            return true;
        else 
            return false;
    }
    
    // hoe vaak een auto er tegenaan gereden is
    public int getCollisionTimes() {
        return _CollisionTimes;
    }
    
    public void addTime() {
        _CollisionTimes++;
    }
    
    // vervang bewegend water voor stilstaand water
    public void replaceWaters()
    {
        List<WWater> water = getObjectsInRange(21, WWater.class);
        for(WWater w : water)
        {
            w.replace();
        }     
    }
    
    // vervang stilstaand water voor bewegend water
    public void replaceSW()
    {
        List<WStillWater> Swaters = getObjectsInRange(21, WStillWater.class);
        for(WStillWater sw : Swaters)
        {
            sw.replace();
        }   
    }
}
