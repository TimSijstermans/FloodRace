import greenfoot.Actor;


public class Intervention {

	private Actor _Actor;
	private String _Text;
	public Intervention(Actor actor, String text){
		_Actor = actor;
		_Text = text;
	}
	
	public Actor getActor() {
		return _Actor;
	}
	
	public String getText() {
		return _Text;
	}
}