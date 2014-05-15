
public class InterventionList {

	private Intervention _I1, _I2, _I3, _I4;
	private int _AantalInterventions;
	
	public InterventionList(Intervention inter1) {
		_I1 = inter1;
		
		_AantalInterventions = 1;
	}
	
	public InterventionList(Intervention inter1,Intervention inter2) {
		_I1 = inter1;
		_I2 = inter2;
		
		_AantalInterventions = 2;
	}
	
	public InterventionList(Intervention inter1,Intervention inter2, Intervention inter3) {
		_I1 = inter1;
		_I2 = inter2;
		_I3 = inter3;	
		
		_AantalInterventions = 3;
	}
	
	public InterventionList(Intervention inter1,Intervention inter2, Intervention inter3, Intervention inter4) {
		_I1 = inter1;
		_I2 = inter2;
		_I3 = inter3;
		_I4 = inter4;
		
		_AantalInterventions = 4;
	}
	
	public Intervention getIntervention(int inter) {
		
		if (inter == 1)
			return _I1;
		
		if (inter == 2)
			return _I2;
		
		if (inter == 3)
			return _I3;
		
		if (inter == 4)
			return _I4;
		
		return null;
	}
	
	public int getAantalInterventions() {
		return _AantalInterventions;
	}
}
