import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WGrindStack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WGrindStack extends WItems
{
    private WCounter count;
    
    public WGrindStack() {
        count = new WCounter(5);
    }
    
    public void act() {
        if (count.getCount() == 0)
            setImage(new GreenfootImage("palletleeg.png"));
        else
            setImage(new GreenfootImage("WGrindStack.png"));
    }
   
    public int getCount() {
        return count.getCount();
    }
    
    public WCounter getCounter() {
        return count;
    }
}
