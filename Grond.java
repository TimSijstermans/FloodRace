import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Grond extends Actor
{
    boolean done = false;
    
    DijkWorld dijkWorld;
    
    Counter zakCounter;
    Counter papierCounter;
    Counter grindCounter;
    Counter kartonCounter;
    Counter cementCounter;
    
    Score score;
    
    /**
     * Check of de dijk doorbroken is.
     */
    public void act() 
    { 
        dijkWorld = (DijkWorld) getWorld();
        if(done == false){
            checkDoorbraak();
        }
    }

    /**
     * Check if the dyke breaks.
     */
    public void checkDoorbraak ()
    {
        Actor grond = getOneObjectAtOffset (0, -1, Water.class);
        
        if (grond != null){
            //Er hoeft niet meer gechecked te worden op een doorbraak.
            done = true;
            //Add score
            addScore();
            
            //Stop the game.
            dijkWorld.setPaused(true);
            dijkWorld.createGameOverMenu();
        }
    }
    
    /**
     * Add the counters to the final score
     */
    public void addScore(){
        int totalScore;
        
        //Counters ophalen
        zakCounter = dijkWorld.getCounter(1);
        papierCounter = dijkWorld.getCounter(2);
        grindCounter = dijkWorld.getCounter(3);
        kartonCounter = dijkWorld.getCounter(4);
        cementCounter = dijkWorld.getCounter(5);

        //Score ophalen
        score = dijkWorld.getScore();
        totalScore = score.getValue();
        
        //Counters bij de score voegen
        totalScore += (zakCounter.getCount() * 5);
        totalScore += (papierCounter.getCount() * 5);
        totalScore += (grindCounter.getCount() * 5);
        totalScore += (kartonCounter.getCount() * 5);
        totalScore += (cementCounter.getCount() * 5);
        
        //Zet de nieuwe score
        score.setValue(totalScore);
    }
}  
