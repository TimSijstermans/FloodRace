import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import greenfoot.*;

public class Map extends World {

    /*
     * Hier worden private variablen gedeclareert. 1 van het type
     * ScenarioBuilder en 1 van Scanario
     */
    private ScenarioBuilder _ScenarioBuilder;
    private Scenario _Scenario;
    private cScore _Score;
    private Timer _Timer;
    private Information _Information = null;

    GreenfootSound backGroundMusic = new GreenfootSound("loopmusic.wav");

    private List<Actor> _Items = new ArrayList<Actor>();
    private Actor [] _InfoMessage;
    private Actor [] _InfoCount;
    private Integer _CountCalimiteiten;

    private cPauseknop pauseButton;
    public boolean isPaused = false;  

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

    public Map() {
    	/*
    	 * Hier wordt de frame van 760x760 gemaakt
    	 * met de achtergrond image "map.png"
    	 * Knoppen van de eenheden worden rechtsbovenin geplaatst
    	 */
        super(760, 760, 1);
        setBackground("images/map.png");

        addObject(new btnPolice(), 630, 100);
        addObject(new btnHospital(), 680, 100);
        addObject(new btnFiremen(), 730, 100);
        /*
         * Hier wordt de ScenarioBuilder geinstantieerd. Hier worden ook gelijk
         * alle mogelijke calimiteiten geladen
         */
        _ScenarioBuilder = new ScenarioBuilder();

        // Toevoegen van de weergave Score
        _Score = new cScore();
        addObject(_Score, 670, 40);

        // 
        _Information = new Information();
        _InfoMessage = new Actor[3];
        _InfoCount = new Actor[3];

        _CountCalimiteiten = 0;

        // Standaard bericht als er geen calimiteiten plaatsvinden
        _InfoMessage[2] = new cMessage("Er zijn momenteel geen problemen", 16, Color.green);
        addObject(_InfoMessage[2], 290, 730);
        pauzeButton();

        // Voegt Timer in de achtergrond toe
        _Timer = new Timer(60);
        addObject(_Timer, 670, 15);

        createMoeilijkheidsScherm();
    }

    public void act() {
        /*
         * Als game niet op pauze staat, wordt muziek afgespeeld
         * en wordt het toevoegen van calimiteiten uitgevoerd
         */
        if (!isPaused) 
        {
            backGroundMusic.playLoop();
            if (_Scenario == null || _Scenario.isCompleted() == true) {
                int random = Greenfoot.getRandomNumber(5);

                while (random <= 1) {
                    random = Greenfoot.getRandomNumber(5);
                }
                // Hier wordt er een scenario gemaakt met een random aantal. 2 t/m 4
                _Scenario = _ScenarioBuilder.buildScenario(random);
            } else {
                // Wanneer er een scenario loopt wordt dit deel aangeroepen
                int aantalCalimiteiten = _ScenarioBuilder.getAantalCalimiteiten();

                for (int i = 1; i <= aantalCalimiteiten; i++) {
                    // Kijkt of de calimiteit al geplaats is
                    if (!_Scenario.getCalimiteit(i).isPlaced()) {
                        // Zo niet wordt er gekeken of het de eerste is
                        if (i != 1) {
                            /* Zo niet wordt er gekeken of de vorige al afgelopen is */
                            if (_Scenario.getCalimiteit(i - 1).isCompleted()) {
                                addObject(_Scenario.getCalimiteit(i).getActor(), _Scenario.getCalimiteit(i).getXcoord(), _Scenario.getCalimiteit(i).getYcoord());
                                _Scenario.getCalimiteit(i).setPlaced(true);

                                _CountCalimiteiten++;
                                _Information.add(_Scenario.getCalimiteit(i).getInformation());
                                showInformation();
                            }
                        } else {
                            /*
                             * Als het de eerste calimiteit binnen het scenario is
                             * maakt hij deze zoiezo aan
                             */
                            addObject(_Scenario.getCalimiteit(i).getActor(),_Scenario.getCalimiteit(i).getXcoord(), _Scenario.getCalimiteit(i).getYcoord());
                            _Scenario.getCalimiteit(i).setPlaced(true);

                            _CountCalimiteiten++;
                            _Information.add(_Scenario.getCalimiteit(i).getInformation());
                            showInformation();
                        }
                    }
                }

                _Scenario.checkCompletion(aantalCalimiteiten);
            }
        }
        else{
            backGroundMusic.pause();
        }
    }

    public List<Actor> getItems() {
        return _Items;
    }

    public void setItems(List<Actor> items) {
        _Items = items;
    }

    public void addScore(int value) {
        _Score.add(value);
    }

    public boolean isPaused(){
        return isPaused;
    }

    /**
     * true = game op pauze zetten
     * false = game door laten gaan
     */
    public void setPaused(boolean value){
        isPaused = value;
    }

    /**
     * Pauze knop neerzetten
     */
    public void pauzeButton()
    {
        pauseButton = new cPauseknop();
        addObject(pauseButton,720,720);
    }

    private void showInformation() {
        String old = _Information.getOldInformation();
        String newest = _Information.getNewInformation();

        if (_InfoMessage[2] != null){
            removeObject(_InfoMessage[2]);
            _InfoMessage[2] = null;
        }

        if (old != null)
        {
            if (_InfoMessage[0] != null){
                removeObject(_InfoMessage[0]);
                removeObject(_InfoCount[0]);
            }

            _InfoMessage[0] = new cMessage(old, 16, Color.gray);
            Integer oldCount = _CountCalimiteiten - 1;

            _InfoCount[0] =  new cMessage(oldCount.toString(), 16, Color.gray);
            addObject(_InfoMessage[0], 290, 725);
            addObject(_InfoCount[0], 500, 725);
        }

        if (newest != null)
        {
            if (_InfoMessage[1] != null){
                removeObject(_InfoMessage[1]);
                removeObject(_InfoCount[1]);    
            }

            _InfoMessage[1] = new cMessage(newest, 16, Color.green);
            _InfoCount[1] =  new cMessage(_CountCalimiteiten.toString(), 16, Color.green);

            addObject(_InfoMessage[1], 290, 740);
            addObject(_InfoCount[1], 500, 740);
        }
    }

    public void createMoeilijkheidsScherm(){

        moeilijkheidsScherm = new MoeilijkheidScherm();
        makkelijk = new cMakkelijk();
        gemiddeld = new cGemiddeld();
        moeilijk = new cMoeilijk();

        addObject(moeilijkheidsScherm, getWidth()/2, getHeight()/2);
        addObject(makkelijk, 350, 200);
        addObject(gemiddeld, 350, 350);
        addObject(moeilijk, 350, 500);
        setPaused(true);
    }

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
        startScherm = new cStartScherm();
        startKnop = new cStartKnop();
        stopKnop = new cStopKnop();

        addObject(startScherm, getWidth()/2, getHeight()/2);
        addObject(startKnop, 550, 650);
        addObject(stopKnop, 200, 650);
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
        doorgaanKnop = new cDoorgaanKnop(0);
        pauseMenu = new cPause();
        stopKnop = new cStopKnop();

        addObject(pauseMenu, getWidth()/2, getHeight()/2);
        addObject(doorgaanKnop, 550, 650 );
        addObject(stopKnop, 200, 650);
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
        gameOverMenu = new cGameOver();
        retryKnop = new cRetryKnop();
        stopKnop = new cStopKnop();

        addObject(gameOverMenu, getWidth()/2, getHeight()/2);
        addObject(retryKnop, 200, 650 );
        addObject(stopKnop, 550, 650);

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
        addObject(new cSuccesMenu(), getWidth()/2, getHeight()/2);
        addObject(new cDoorgaanKnop(1), getWidth()/2, (getHeight()/2) + 50);
    }
}
