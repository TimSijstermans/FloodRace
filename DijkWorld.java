import greenfoot.*;  // imports Actor, World, Greenfoot, GreenfootImage

public class DijkWorld extends World
{
    //population ints
    private int waterRows;
    private int dijkRows;
    private int buitenDijk1Rows;
    private int buitenDijk2Rows;
    private int grondRows;

    public boolean isPaused = false;  
    
    GreenfootSound backGroundMusic = new GreenfootSound("backgroundloop_wijk.mp3");

    //Counter
    private Counter zakCounter;
    private Counter papierCounter;
    private Counter grindCounter;
    private Counter kartonCounter;
    private Counter cementCounter;
    //Score
    private Score score;
    private PauseKnop pauseButton;

    //Menu items
    private Actor startScherm;
    private Actor pauseMenu;
    private Actor gameOverMenu;

    private Actor startKnop;
    private Actor doorgaanKnop;
    private Actor stopKnop;
    private Actor retryKnop;

    private Actor moeilijkheidsScherm;
    private Actor makkelijk;
    private Actor gemiddeld;
    private Actor moeilijk;

    /**
     * World Constructor
     */
    public DijkWorld() 
    {
        super(38, 38, 20);   

        // hoeveelheden instellen 
        waterRows = 10;
        buitenDijk1Rows = waterRows +1;
        dijkRows = buitenDijk1Rows +16;
        buitenDijk2Rows = dijkRows +1;
        grondRows = buitenDijk2Rows + 9;

        //Initiate
        populate();
        dragObjecten();
        karakters();
        objectCounters();
        scoreLabel();
        pauzeButton();
        omgevingObjecten();

        createMoeilijkheidsScherm();
    }

    public void act()
    {
        if (!isPaused){
            backGroundMusic.playLoop();
        }
        else{
            backGroundMusic.pause();
        }
    }
    /**
     * Dijkelementen (water, buitendijk, dijk & grond)
     */    
    public void populate()
    {
        //Water
        for(int hoogte = waterRows-1; hoogte<waterRows; hoogte++){

            for(int breedte = 0; breedte<getWidth(); breedte++){

                Water water = new Water();
                addObject(water, breedte, hoogte);
            }

        }

        //Buitendijk boven
        for(int hoogte = waterRows; hoogte<buitenDijk1Rows; hoogte++){

            for(int breedte = 0; breedte<getWidth(); breedte++){

                Buitendijk buitendijk = new Buitendijk();
                addObject(buitendijk, breedte, hoogte);
            }
        }

        //Dijk
        for(int hoogte = buitenDijk1Rows; hoogte<dijkRows ; hoogte++){

            for(int breedte = 0; breedte<getWidth(); breedte++){

                Dijk dijk = new Dijk();
                addObject(dijk, breedte, hoogte);
            }
        }

        //Buitendijk onder
        for(int hoogte = dijkRows; hoogte<buitenDijk2Rows; hoogte++){

            for(int breedte = 0; breedte<getWidth(); breedte++){

                Buitendijk buitendijk = new Buitendijk();
                addObject(buitendijk, breedte, hoogte);
            }
        }

        //Grond
        for(int hoogte = buitenDijk2Rows; hoogte<=grondRows ; hoogte++){

            for(int breedte = 0; breedte<getWidth(); breedte++){

                Grond grond = new Grond();
                addObject(grond, breedte, hoogte);
            }
        }

    }

    /**
     * Objecten uit de legenda die draggable zijn
     */
    public void dragObjecten()
    {
        //Zandzak
        Zandzak zandzakLegenda = new Zandzak(true);
        addObject(zandzakLegenda, (getWidth()/2), buitenDijk2Rows + 5);

        //Papierzak
        Papier papierLegenda = new Papier(true);
        addObject(papierLegenda, (getWidth()/2)-4, buitenDijk2Rows + 5);

        //Grindzak
        Grind grindLegenda = new Grind(true);
        addObject(grindLegenda, (getWidth()/2)+4, buitenDijk2Rows + 5);

        //Kartonnen doos
        Karton kartonLegenda = new Karton(true);
        addObject(kartonLegenda, (getWidth()/2)-4, buitenDijk2Rows + 2);

        //Cementzak
        Cement cementLegenda = new Cement(true);
        addObject(cementLegenda, (getWidth()/2)+4, buitenDijk2Rows + 2);
    }

    /**
     * Karakters uit de legenda
     */
    public void karakters()
    {
        //Burger

        Burger burgerLegenda = new Burger();
        addObject(burgerLegenda, (getWidth()/2)-4, buitenDijk2Rows + 9);

        //Politieagent

        PolitieAgent politieAgentLegenda = new PolitieAgent();
        addObject(politieAgentLegenda, (getWidth()/2), buitenDijk2Rows + 9);

        //Genie

        Genie genieLegenda = new Genie();
        addObject(genieLegenda, (getWidth()/2)+4, buitenDijk2Rows + 9);

    }

    /**
     * Counters neerzetten van de objecten
     */
    public void objectCounters()
    {
        //Zandzak counter
        zakCounter = new Counter(8);
        addObject(zakCounter, (getWidth()/2), buitenDijk2Rows + 6);
        //Papier counter
        papierCounter = new Counter(10);
        addObject(papierCounter, (getWidth()/2)-4, buitenDijk2Rows + 6);
        //Grindzak counter
        grindCounter = new Counter(5);
        addObject(grindCounter, (getWidth()/2)+4, buitenDijk2Rows + 6);
        //Kartonnen doos counter
        kartonCounter = new Counter(10);
        addObject(kartonCounter, (getWidth()/2)-4, buitenDijk2Rows + 3);
        //Cement counter
        cementCounter = new Counter(3);
        addObject(cementCounter, (getWidth()/2)+4, buitenDijk2Rows + 3);
    }

    public void omgevingObjecten(){
        int koeien = Greenfoot.getRandomNumber(5);
        int schapen = Greenfoot.getRandomNumber(5);
        for(int i = 0;i < koeien;i++) {
            Actor koe = new Koe();
            addObject(koe, Greenfoot.getRandomNumber(38), buitenDijk2Rows + Greenfoot.getRandomNumber(4));
        }
        for(int i = 0;i < schapen;i++) {
            Actor schaap = new Schaap();
            addObject(schaap, Greenfoot.getRandomNumber(38), buitenDijk2Rows + Greenfoot.getRandomNumber(4));
        }
    }

    /**
     * Score neerzetten
     */
    public void scoreLabel()
    {
        score = new Score();
        addObject(score,2,2);
    }

    /**
     * Pauze knop neerzetten
     */
    public void pauzeButton()
    {
        pauseButton = new PauseKnop();
        addObject(pauseButton,35,2);
    }

    /**
     * Haalt de counter op (afhankelijk van welke je nodig hebt)
     */
    public Counter getCounter(int counterSwitch)
    {
        switch(counterSwitch){
            case 1:
            return zakCounter;
            case 2:
            return papierCounter;
            case 3:
            return grindCounter;
            case 4:
            return kartonCounter;
            case 5:
            return cementCounter;
        } 
        return null;
    }

    /**
     * Verkrijgt de current score
     */
    public Score getScore(){
        return score;
    }

    /**
     * Verkrijgt of de game gepauzeerd is of niet
     */
    public boolean getPaused(){
        return isPaused;
    }

    /**
     * true = game op pauze zetten
     * false = game door laten gaan
     */
    public void setPaused(boolean ToF){
        isPaused = ToF;
        return;
    }

    /**
     * het moeilijkheidsscherm neerzetten
     */
    public void createMoeilijkheidsScherm(){

        moeilijkheidsScherm = new MoeilijkheidScherm();
        makkelijk = new Makkelijk();
        gemiddeld = new Gemiddeld();
        moeilijk = new Moeilijk();

        addObject(moeilijkheidsScherm, getWidth()/2, getHeight()/2);
        addObject(makkelijk, 18, 10);
        addObject(gemiddeld, 18, 17);
        addObject(moeilijk, 18, 24);
        setPaused(true);
    }

    /**
     * Het moeilijkheidsscherm weghalen
     */
    public void removeMoeilijkheidsScherm(){
        removeObject(moeilijkheidsScherm);
        removeObject(makkelijk);
        removeObject(gemiddeld);
        removeObject(moeilijk);
        createStartMenu();
    }

    /**
     * Start menu neerzetten
     */
    public void createStartMenu(){
        startScherm = new StartScherm();
        startKnop = new StartKnop();
        stopKnop = new StopKnop();

        addObject(startScherm, 18, 19);
        addObject(startKnop, 10, 34);
        addObject(stopKnop, 28, 34);
        setPaused(true);
    }

    /**
     * Start menu weghalen
     */
    public void removeStartMenu()
    {
        removeObject(startScherm);
        removeObject(startKnop);
        removeObject(stopKnop);
    }

    /**
     * Pauze menu neerzetten
     */
    public void createPauseMenu()
    {
        doorgaanKnop = new DoorgaanKnop(0);
        pauseMenu = new Pause();
        stopKnop = new StopKnop();

        addObject(pauseMenu, 18, 19 );
        addObject(doorgaanKnop, 10, 34 );
        addObject(stopKnop, 28, 34);
    }

    /**
     * Pauze menu weghalen
     */
    public void removePauseMenu()
    {
        removeObject(doorgaanKnop);
        removeObject(pauseMenu);
        removeObject(stopKnop);
    }

    /**
     * Game over menu maken
     */
    public void createGameOverMenu()
    {
        gameOverMenu = new GameOver();
        retryKnop = new RetryKnop();
        stopKnop = new StopKnop();

        addObject(gameOverMenu, 18, 19 );
        addObject(retryKnop, 10, 34 );
        addObject(stopKnop, 28, 34);
    }

    /**
     * Game over menu weghalen
     */
    public void removeGameOverMenu()
    {
        removeObject(retryKnop);
        removeObject(gameOverMenu);
        removeObject(stopKnop);
    }

    /**
     * Game succes menu maken
     */
    public void createSuccessMenu(){
        addObject(new SuccesMenu(), 18,19);
        addObject(new DoorgaanKnop(1), 18 , 34);
    }
}
