import greenfoot.Greenfoot;

import java.util.Arrays;

public class ScenarioBuilder
{

	/*
	 * Hier worden 2 private variablen geladen. Het aantal Calimiteiten voor een
	 * scenario. En een Array van het Type Calimiteit. Hier worden alle
	 * calimiteiten in opgeslagen
	 */
	private int _AantalCalimiteiten;
	private Calimiteit[] _Calimiteiten;

	public ScenarioBuilder()
	{
		/* Hier wordt de array aangemaakt; */
		_Calimiteiten = new Calimiteit[25];
	}

	/*
	 * In deze methode worden er de random calimiteiten gekozen op basis van
	 * _AantalCalimiteiten voor het scenario dat hij gaat samenstellen.
	 */
	private Calimiteit[] chooseCalimiteiten()
	{

		Calimiteit[] calimiteiten = new Calimiteit[_AantalCalimiteiten];

		int[] choosenValues = new int[_AantalCalimiteiten];

		for (int i = 0; i < _AantalCalimiteiten; i++) {
			int random = Greenfoot.getRandomNumber(25);

			/*
			 * Kijkt of het gekozen getal al gekozen is. Zo ja blijft hij een
			 * random getal genereren totdat hij een getal heeft dat nog niet
			 * gekozen is
			 */
			while (Arrays.asList(choosenValues).contains(random) == true) {
				random = Greenfoot.getRandomNumber(25);
			}

			choosenValues[i] = random;
			calimiteiten[i] = _Calimiteiten[random];
		}

		return calimiteiten;
	}

	/* Hier worden alle calimiteiten in de globale Array _Calimiteiten gestopt. */
	private void fillCalimiteiten()
	{

		_Calimiteiten[0] = new Calimiteit(new Brand(false), 80, 108, new actBlussen(true));
		_Calimiteiten[1] = new Calimiteit(new Brand(false), 557, 284, new actBlussen(true));
		_Calimiteiten[2] = new Calimiteit(new Brand(false), 557, 284, new actBlussen(true));
		_Calimiteiten[3] = new Calimiteit(new Brand(false), 557, 284, new actBlussen(true));
		_Calimiteiten[4] = new Calimiteit(new Brand(false), 415, 86, new actBlussen(true));
		_Calimiteiten[5] = new Calimiteit(new Evacuatie(false), 201, 590, new actZorg(true));
		_Calimiteiten[6] = new Calimiteit(new Evacuatie(false), 47, 669, new actZorg(true));
		_Calimiteiten[7] = new Calimiteit(new Evacuatie(false), 128, 666, new actZorg(true));
		_Calimiteiten[8] = new Calimiteit(new Evacuatie(false), 145, 601, new actZorg(true));
		_Calimiteiten[9] = new Calimiteit(new Evacuatie(false), 507, 540, new actZorg(true));
		_Calimiteiten[10] = new Calimiteit(new Autoongeluk(false), 280, 140, new actEhbo(true));
		_Calimiteiten[11] = new Calimiteit(new Autoongeluk(false), 395, 375, new actEhbo(true));
		_Calimiteiten[12] = new Calimiteit(new Autoongeluk(false), 305, 615, new actEhbo(true));
		_Calimiteiten[13] = new Calimiteit(new Elek_Brand(false), 275, 185, new actElectraBrand(true));
		_Calimiteiten[14] = new Calimiteit(new Elek_Brand(false), 460, 390, new actElectraBrand(true));
		_Calimiteiten[15] = new Calimiteit(new Elek_Brand(false), 155, 530, new actElectraBrand(true));
		_Calimiteiten[16] = new Calimiteit(new Overstroming(false), 240, 465, new actWaterpomp(true));
		_Calimiteiten[17] = new Calimiteit(new Overstroming(false), 425, 575, new actWaterpomp(true));
		_Calimiteiten[18] = new Calimiteit(new Overstroming(false), 415, 415, new actWaterpomp(true));
		_Calimiteiten[19] = new Calimiteit(new Rellen(false), 300, 115, new actStuurME(true));
		_Calimiteiten[20] = new Calimiteit(new Rellen(false), 265, 420, new actStuurME(true));
		_Calimiteiten[21] = new Calimiteit(new Rellen(false), 420, 635, new actStuurME(true));
		_Calimiteiten[22] = new Calimiteit(new Overval(false), 300, 350, new actArrest(true));
		_Calimiteiten[23] = new Calimiteit(new Overval(false), 450, 230, new actArrest(true));
		_Calimiteiten[24] = new Calimiteit(new Overval(false), 210, 200, new actArrest(true));

		/*
		 * Hier zorgt hij ervoor dat er in de Actor class ook de gemaakte
		 * calimiteit mee geeft.
		 */
		for (Calimiteit calimiteit : _Calimiteiten) {
			String actorStr = calimiteit.getActor().toString();
			actorStr = actorStr.substring(0, actorStr.indexOf("@"));

			if (actorStr.equals("Brand")) {
				Brand actor = (Brand) calimiteit.getActor();
				actor.setCalimiteit(calimiteit);
			}
			else if (actorStr.equals("Evacuatie")) {
				Evacuatie actor = (Evacuatie) calimiteit.getActor();
				actor.setCalimiteit(calimiteit);
			}
			else if (actorStr.equals("Autoongeluk")) {
				Autoongeluk actor = (Autoongeluk) calimiteit.getActor();
				actor.setCalimiteit(calimiteit);
			}
			else if (actorStr.equals("Elek_Brand")) {
				Elek_Brand actor = (Elek_Brand) calimiteit.getActor();
				actor.setCalimiteit(calimiteit);
			}
			else if (actorStr.equals("Overstroming")) {
				Overstroming actor = (Overstroming) calimiteit.getActor();
				actor.setCalimiteit(calimiteit);
			}
			else if (actorStr.equals("Rellen")) {
				Rellen actor = (Rellen) calimiteit.getActor();
				actor.setCalimiteit(calimiteit);
			}
			else if (actorStr.equals("Overval")) {
				Overval actor = (Overval) calimiteit.getActor();
				actor.setCalimiteit(calimiteit);
			}
		}
	}

	/*
	 * Hier wordt de uiteindelijke Scenario gemaakt. Hier wordt ook de
	 * aantalCalimiteiten mee gegeven.
	 */
	public Scenario buildScenario(int aantalCalimiteiten)
	{

		fillCalimiteiten();

		_AantalCalimiteiten = aantalCalimiteiten;

		/* De calimiteiten worden gekozen voor dit scenario */
		Calimiteit[] calimiteiten = chooseCalimiteiten();
		Scenario scenario = null;

		/*
		 * Hier wordt via de contructor van de sceanrio classe aangeroepen op
		 * basis van de hoeveelheid calimiteiten.
		 */
		if (_AantalCalimiteiten == 2) {
			scenario = new Scenario(calimiteiten[0], calimiteiten[1]);
		}

		if (_AantalCalimiteiten == 3) {
			scenario = new Scenario(calimiteiten[0], calimiteiten[1],
					calimiteiten[2]);
		}

		if (_AantalCalimiteiten == 4) {
			scenario = new Scenario(calimiteiten[0], calimiteiten[1],
					calimiteiten[2], calimiteiten[3]);
		}

		return scenario;
	}

	/* Getter voor het aantal Calimiteiten */
	public int getAantalCalimiteiten()
	{
		return _AantalCalimiteiten;
	}
}
