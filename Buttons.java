import java.util.ArrayList;
import java.util.List;

import greenfoot.Actor;
import greenfoot.Greenfoot;


public class Buttons extends Actor{
    
    protected BuildInterventionList _ListBuilder;
    private List<Actor> _Items = new ArrayList<Actor>();
    private Map _World;
    
    private int _MenuXCoord = 625;
    private int _MenuXTextCoord = _MenuXCoord + 70;
    private int _MenuYCoord = 150;
    private int _MenuRowHeight = 30;

    public Buttons(){
        
    }
    
    public void act() {
        if (_World == null){
            _World = (Map) getWorld();  
            _Items = _World.getItems();
            if (!_World.isPaused())
                showInterventions();
        }
        
        if(!_World.isPaused()){
        	_Items = _World.getItems();
            
            if (Greenfoot.mouseClicked(this)) {
                showInterventions();
            }
        }
        
        
    }
    
    protected void showInterventions() {
        InterventionList list = _ListBuilder.getList(); 
        int aantalInterventions = list.getAantalInterventions();
        
        if (getWorld().getObjectsAt(_MenuXTextCoord, _MenuYCoord, InterventionText.class).isEmpty())
        {
            for (int i = 0; i < aantalInterventions; i++) {
                Actor actor = list.getIntervention(i + 1).getActor();
                Actor text = new InterventionText(list.getIntervention(i + 1).getText());
                
                getWorld().addObject(actor, _MenuXCoord, _MenuYCoord + (i * _MenuRowHeight));
                getWorld().addObject(text, _MenuXTextCoord, _MenuYCoord + (i * _MenuRowHeight));
                
                _Items.add(actor);
                _Items.add(text);
                }
            
            _World.setItems(_Items);
        }
        else
        {
            _World.removeObjects(_Items);   
            _Items.clear();
            _World.setItems(_Items);
            this.act();
        }
    }
}
