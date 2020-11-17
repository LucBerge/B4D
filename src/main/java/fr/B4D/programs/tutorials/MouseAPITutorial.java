package fr.B4D.programs.tutorials;

import fr.B4D.bot.B4D;
import fr.B4D.bot.B4DException;
import fr.B4D.bot.Person;
import fr.B4D.program.Category;
import fr.B4D.program.Place;
import fr.B4D.program.Program;
import fr.B4D.utils.PointF;

/**
 * The {@code MouseAPI} class contains all the tutorials relative to the mouse API.
 * 
 * Ce tutoriel à pour objectif de mieux comprendre le fonctionnement et l'utilisation de l'API de la souris.<br>
 *  <br>
 *  Fonctionnement :
 *  <ul>
 *  	<li>Clic sur la barre de chat et attend 500 millisecondes.</li>
 *  	<li>Clic gauche avec appui sur Maj et attend 1 seconde.</li>
 *  	<li>Clic droit sans appui sur Maj et attend 700 millisecondes.</li>
 *  	<li>Place la souris au milieu et attend 1.5 secondes.</li>
 *  </ul>
 *
 * @author Lucas
 *
 */
public final class MouseAPITutorial extends Program {

	/**
	 * Constructor of the mouse API tutorial.
	 */
	public MouseAPITutorial() {
		super(Place.Tous, Category.Tutorial, "Souris API", "Tutorial 1", null, null);
	}
	
	@Override
	public void intro(Person person) {}

	@Override
	public void outro(Person person) {}

	@Override
	public void cycle(Person person) throws B4DException {
		B4D.mouse.chatClick();
		B4D.mouse.leftClick(new PointF(0.5, 0.4), true);
		B4D.mouse.rightClick(new PointF(0.5, 0.6), false, 700);
		B4D.mouse.place(new PointF(0.5, 0.5), 1500);
	}
}
