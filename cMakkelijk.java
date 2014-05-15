import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class cMakkelijk extends MoeilijkheidScherm {

    public void act() {
        
        if(Greenfoot.mouseClicked(this)){
            Map world = (Map) getWorld();
//             Greenfoot.setSpeed(40); 
            zetSnelheid(40);
            world.setPaused(false);
            world.removeMoeilijkheidsScherm();
        }
        
    }
}
