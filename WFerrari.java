import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WFerrari here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WFerrari extends WCars 
{ 
    public WFerrari(boolean drivable){
        this.drivable = drivable;
        
        int random = Greenfoot.getRandomNumber(2);
        
        if (random == 0) {
            direction = 0;
            setImage("Ferrari links.png");
        }
        else{
            direction = 1;
            setImage("ferrari rechts.png");
        }
            
    }
    
}
