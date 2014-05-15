import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wijk1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wijk1 extends Wijken
{
    //De array's waar de coordinaten van de gebouwen staan.
    int[] coordsBuildingX = {176, 339, 503, 176, 339, 503, 219, 275, 14, 14, 0, 290, 578, 169, 730, 169, 197, 4};
    int[] coordsBuildingY = {318, 318, 318, 417, 417, 417, 530, 735, 382, 466, 565, 643, 154, 154, 339, 605, 691, 285};
    //De array's waar de coordinaten van de sloot staat.
    int[] coordsSlootX = {424};
    int[] coordsSlootY = {609};
    
    WCounter cementCounter;
    WCounter grindCounter;
    WCounter zandCounter;
    
        GreenfootSound backGroundMusic = new GreenfootSound("dijkloop.wav");
    
    long currentTime;
    long prevTime;
    long carInterval = 2500;
    
    WGameOver gameOverMenu;
    WWin winMenu;
    boolean gamePaused = false;
    
    private Actor _pause = new WPause();
    private Actor _score = new WScore();
    
    private Actor startScherm;
    private Actor pauzeScherm;
    private Actor startKnop;
    private Actor stopKnop;
    private Actor doorgaanKnop;
    private Actor retryKnop;
    
    /**
     * Constructor for objects of class Wijk1.
     * 
     */
    public Wijk1()
    {       
        setBackground("images/Kaart Wijkgame.png");
        Greenfoot.setSpeed(50);
        addObject(new WPut(), 85, 695);
        //Hier bouwt hij de Dijk en de daarbij behorende collision.     
        WCollidable wDijk = new WDijk();
        wDijk.setDimensions(380, 70);
        
        addObject(wDijk, 380, 70);
        addObject(new WPlayer(), 500, 250);
        
        addObject(new WWater(), 369, 83);
        
        createItems();
        createCars();
        createSloot();
        createBuildings();
        
        
        addObject(new WTree(), 720, 720);
        addObject(new WTree(), 540, 710);   
        addObject(_score, 75, 25);
        
        addObject(_pause, 725, 35);
        
        createStartScherm();
    }
    
    public void act() {
        if (!gamePaused)        
        {
            currentTime = System.currentTimeMillis();
            backGroundMusic.playLoop();
            if (currentTime - prevTime > carInterval)
            {
                //Hier berekent hij de tijd tussen het spawnen van de verschillende auto's.
                prevTime = currentTime;
                createCars(); 
            }
        }
        else{
            backGroundMusic.pause();
        }
    }
    
    public void createBuildings(){
        int i = 0;
        while(i<coordsBuildingX.length){
            WCollidable wBuilding = new WBuilding();
            //Hier bouwt plaatst hij de gebouwen naar de Array die bovenin staan.
            wBuilding.setImage("Huisblok"+i+".png");
            wBuilding.setDimensions(coordsBuildingX[i], coordsBuildingY[i]);
            
            addObject(wBuilding, coordsBuildingX[i], coordsBuildingY[i]);
            i++;
        }
    }   
    
    public void createSloot() {
        int i = 0;
        while(i<coordsSlootX.length){
             WCollidable wSloot = new WSloot();
            
            if( i >= 0){
                //Hier plaatst hij de sloot naar aanleiding van de array die bovenaan staan.
                wSloot.setImage("Sloot"+i+".png");
                wSloot.setDimensions(coordsSlootX[i], coordsSlootY[i]);
            }
            addObject(wSloot, coordsSlootX[i], coordsSlootY[i]);
            i++;
        }
    }
    public void createItems() {
        WGrindStack grindStack = new WGrindStack();
        WZandStack zandStack= new WZandStack();
        WCementStack cementStack = new WCementStack();
        //Hier maakt hij de collision aan voor de pallets van de zakken
        grindStack.setDimensions(690, 545);
        zandStack.setDimensions(690, 610);
        cementStack.setDimensions(690, 680);
        //Hier plaatst hij de pallets
        addObject(grindStack, 690, 545);
        addObject(zandStack, 690, 610);
        addObject(cementStack, 690, 680);
        
        cementCounter = cementStack.getCounter(); 
        grindCounter = grindStack.getCounter(); 
        zandCounter = zandStack.getCounter(); 
        //Dit is de counter voor de pallets.
        addObject(grindCounter, 640, 545);
        addObject(zandCounter, 640, 610);
        addObject(cementCounter, 640, 680);
    }
    
    public void createCars(){
        
        WCars ferrari = new WFerrari(true);
        WCars cabrio = new WCabrio(true);
        WCars limo = new WLimo(true);
        
        int random = Greenfoot.getRandomNumber(3);
        if (random == 0){
            if (ferrari.getDirection() == 1) 
                addObject(ferrari, 75, 495);
            else 
                addObject(ferrari, 760, 470);
        }
        else if (random == 1){
            if (cabrio.getDirection() == 1)
                addObject(cabrio, 75, 495);
            else
                addObject(cabrio, 760, 470);
        }        
        else if (random == 2){
            if (limo.getDirection() == 2)
                addObject(limo, 75, 495);
            else
                addObject(limo, 760, 470);        
        }
    }
    
    public WCounter getCementCounter() {
        return cementCounter;
    }
    
    public WCounter getZandCounter() {
        return zandCounter;
    }
    
    public WCounter getGrindCounter(){
        return grindCounter;
    }
    
    public void createGameOverMenu()
    {
        gameOverMenu = new WGameOver();
        retryKnop = new WRetryKnop();
        stopKnop = new WStopKnop();
        
        addObject(gameOverMenu, getWidth()/2, getHeight()/2);
        addObject(retryKnop, 200, 650 );
        addObject(stopKnop, 550, 650);
        
        gamePaused = true;
    }
    
    public void createWinMenu(){
        winMenu = new WWin();
        stopKnop = new WStopKnop();
        
        addObject(winMenu, getWidth()/2, getHeight()/2);
        addObject(stopKnop, 200, 650 );
        addObject(new WDoorgaanKnop(1), 550, 650);
        
        gamePaused = true;
    }
    
    private void createStartScherm(){
        
        startScherm = new WStartScherm();
        startKnop = new WStartKnop();
        stopKnop = new WStopKnop();
        
        addObject(startScherm, 387, 371);
        addObject(startKnop, 535, 700);
        addObject(stopKnop, 245, 700);
        
        setPaused(true);
    }
    
    public void removeStartScherm(){
        removeObject(startScherm);
        removeObject(startKnop);
        removeObject(stopKnop);
        
        setPaused(false);
    }
    
    public void createPauseScherm() {
        pauzeScherm = new WPauseScherm();
        stopKnop = new WStopKnop();
        doorgaanKnop = new WDoorgaanKnop(0);
        
        addObject(pauzeScherm, 387, 371);
        addObject(doorgaanKnop, 535, 700);
        addObject(stopKnop, 245, 700);
    }
    
    public void removePauseMenu(){
        removeObject(pauzeScherm);
        removeObject(doorgaanKnop);
        removeObject(stopKnop);
    }    
    
    /**
     * Verkrijgt of de game gepauzeerd is of niet
     */
    public boolean getPaused()
    {
        return gamePaused;
    }

    /**
     * true = game op pauze zetten false = game door laten gaan
     */
    public void setPaused(boolean pause)
    {
        gamePaused = pause;
        return;
    }
}


