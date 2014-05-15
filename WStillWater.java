import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class WStillWater extends WWaterTypes
{

    
    public WStillWater()
    {
            int random = Greenfoot.getRandomNumber(2);
            switch(random)
            {
                case 1:     setImage("water5.png");
                            break;
                default:    setImage("Wwater.png");
                            break;
            }
    }
    
    public void replace()
    {
        getWorld().addObject(new WWater(),getX(),getY());
        getWorld().removeObject(this);
    } 
}
