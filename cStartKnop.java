import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartKnop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class cStartKnop extends cKnoppen
{
    public void act() 
    {
        if (Greenfoot.mouseClicked(this))
        {
            Map world = (Map) getWorld();
            world.setPaused(false);
            world.removeStartMenu();
        }
    }
}
