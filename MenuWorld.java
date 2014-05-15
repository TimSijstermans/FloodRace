import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MenuWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuWorld extends World
{
    /**
     * Constructor for objects of class MenuWorld.
     * 
     */
    public MenuWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(38, 38, 20); 
        
        Greenfoot.start();
        
        zandZakGameButton();
        controleKamerGameButton();
        jumpGameButton();
        wijkGameButton();
    }

    public void zandZakGameButton()
    {
        ZandZakGame zandZakGame = new ZandZakGame();
        addObject(zandZakGame, 21, 15);
    }

    public void controleKamerGameButton()
    {
        ControleKamerGame controleKamerGame = new ControleKamerGame();
        addObject(controleKamerGame, 8, 15);
    }

    public void wijkGameButton()
    {
        WijkGame wijkGame = new WijkGame();
        addObject(wijkGame, 8, 21);
    }
    
    public void jumpGameButton()
    {
        JumpGame jumpGame = new JumpGame();
        addObject(jumpGame, 21, 21);
    }
}
