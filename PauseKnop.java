import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class PauseKnop extends Knoppen
{
    /**
     * Werkt ATM alleen nog maar op het midden van de button.
     * Moet nog zo gemaakt worden dat hij de hele button kan detecten
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
        {  
            DijkWorld world = (DijkWorld) getWorld();

            //Check of het spel op pauze staat
            if(world.getPaused()){
                //Zo ja, unpause
                world.setPaused(false);
                world.removePauseMenu();
            }else{
                //Zo nee, pause.
                world.setPaused(true);
                world.createPauseMenu();
            }
        }  
    }    
}
