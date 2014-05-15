import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WCabrio here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WCabrio extends WCars
{
    public WCabrio(boolean drivable){
        this.drivable = drivable;
        
        int random = Greenfoot.getRandomNumber(2);
        
        if (random == 0) {
            direction = 0;
            setImage("cabrio.png");
        }
        else{
            direction = 1;
            setImage("cabrio rechts.png");
        }
            
    }
}
