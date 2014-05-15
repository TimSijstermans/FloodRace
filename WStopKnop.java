import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WStopKnop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WStopKnop extends Actor
{
    public void act() 
    {   //als deze class wordt aangeroepen wordt de speler terug gestuurd naar het menu scherm.
        if (Greenfoot.mouseClicked(this))
        {    
            Greenfoot.setWorld(new MenuWorld());  
        } 
    }    
}
