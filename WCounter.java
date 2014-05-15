import greenfoot.Actor;
import greenfoot.GreenfootImage;

import java.awt.Color;
// (World, Actor, GreenfootImage, Greenfoot and MouseInfo

public class WCounter extends Actor
{
    private int count;
    private GreenfootImage image;
    
    public WCounter(int aantal) {
        this.count = aantal;
        drawCounter();
    }
    
    public void add() {
        count++;
        
        drawCounter();
    }
    
    public void takeItem() {
        if (count > 0)
            count--;
            
        drawCounter();
    }
    //hier geeft hij de counter weer.
    public void drawCounter(){
        image = new GreenfootImage("" + count, 28, Color.BLACK, Color.GREEN);
        image.setTransparency(35);
        setImage(image);
    }
    
    public int getCount() {
        return count;
    }
}
