import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WCementStack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WCementStack extends WItems
{
    private WCounter count;
    
    public WCementStack() {
        count = new WCounter(3);
    }
   
    public void act() {
        if (count.getCount() == 0)
            setImage(new GreenfootImage("palletleeg.png"));
        else
            setImage(new GreenfootImage("WCementStack.png"));
    }
    
    public int getCount() {
        return count.getCount();
    }
    
    public WCounter getCounter() {
        return count;
    }
}
