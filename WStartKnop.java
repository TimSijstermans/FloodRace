import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WStartKnop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WStartKnop extends Actor
{   //als deze class wordt aangeroepen dan start het spel.
    public void act() 
    {
        if (Greenfoot.mouseClicked(this))
        {
            Wijk1 world = (Wijk1) getWorld();
            world.setPaused(false);
            world.removeStartScherm();
        }
    }  
}
