
public class BuildInterventionList {

	private String _Button;
	private InterventionList _List;
	
	public BuildInterventionList(String button){
		_Button = button;
		
		_List = BuildInterventionList();
	}
	
	private InterventionList BuildInterventionList() {
		InterventionList list = null;
		
		if (_Button.equals("Firemen"))
		{
			Intervention inter1 = new Intervention(new actBlussen(true), "Brand Blussen");
			Intervention inter2 = new Intervention(new actWaterpomp(true), "Water wegpompen");
			Intervention inter3 = new Intervention(new actElectraBrand(true), "Electra brand");
			
			list = new InterventionList(inter1, inter2, inter3);
		}
		else if (_Button.equals("Hospital")) 
		{
			Intervention inter1 = new Intervention(new actZorg(true), "Verzorgen");
			Intervention inter2 = new Intervention(new actEhbo(true), "EHBO");
			
			list = new InterventionList(inter1, inter2);
		}
		else if (_Button.equals("Police")) 
		{
			Intervention inter1 = new Intervention(new actArrest(true), "Arresteren");
			Intervention inter2 = new Intervention(new actStuurME(true), "Stuur ME");
			
			list = new InterventionList(inter1, inter2);
		}
		
		return list;
	}
	
	public InterventionList getList() {
		return _List;
	}
}
