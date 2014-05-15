import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WZandStack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WZandStack extends WItems
{
	private WCounter count;
    
    public WZandStack() {
        count = new WCounter(10);
    }
    
    public void act() {
        if (count.getCount() == 0)
            setImage(new GreenfootImage("palletleeg.png"));
        else
            setImage(new GreenfootImage("WZandStack.png"));
    }
   
    public int getCount() {
        return count.getCount();
    }
    
    public WCounter getCounter() {
        return count;
    }
}
