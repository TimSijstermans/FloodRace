import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WijkGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WijkGame extends MenuButtons
{
    /**
     * Act - do whatever the WijkGame wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.mouseClicked(this))  
        {  
            Greenfoot.setWorld(new Wijk1());  
        } 
    }    
}
