import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WRetryKnop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WRetryKnop extends Actor
{   //als deze class wordt aangeroepen dan herstart de game zich.
    public void act() 
    {
        if (Greenfoot.mouseClicked(this))
        {    
            Greenfoot.setWorld(new Wijk1());  
        } 
    } 
}
