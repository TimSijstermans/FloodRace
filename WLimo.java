import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WLimo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WLimo extends WCars
{
    public WLimo(boolean drivable){
        this.drivable = drivable;
        
        int random = Greenfoot.getRandomNumber(2);
        
        if (random == 0) {
            direction = 0;
            setImage("limo links.png");
        }
        else{
            direction = 1;
            setImage("limo.png");
        }
            
    }    
}
