import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RetryKnop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RetryKnop extends Knoppen
{
    /**
     * Act - do whatever the RetryKnop wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.mouseClicked(this))
        {    
            Greenfoot.setWorld(new DijkWorld());  
        } 
    }    
}
