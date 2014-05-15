import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Message here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Message extends Actor
{
    int getekend = 0;
    public Message(String message)
    {
        if (getekend == 0){
            greenfoot.GreenfootImage gi;
            gi=new greenfoot.GreenfootImage(620,250);
            gi.drawString(message,0,50);
            this.setImage(gi);

            getekend =+ 1;
        }
    } 
}    
