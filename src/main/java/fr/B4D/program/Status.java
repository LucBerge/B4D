package fr.B4D.program;

import java.awt.AWTException;

import fr.B4D.bot.B4D;
import fr.B4D.utils.PointF;

/** La classe {@code Status} repr�sente un status de jeu.<br><br>
 * Un status est d�fini par un nom et une position relative au menu status.
 */
public class Status {
	
	  /****************/
	 /** COLLECTION **/
	/****************/
	
	public final static Status AVAILABLE = new Status("Disponible", new PointF(0.0131, -0.1008 + 0*0.0216));
	public final static Status ABSENT = new Status("Absent", new PointF(0.0131, -0.1008 + 1*0.0216));
	public final static Status PRIVATE = new Status("Priv�", new PointF(0.0131, -0.1008 + 3*0.0216));
	public final static Status SOLO = new Status("Solo", new PointF(0.0131, -0.1008 + 4*0.0216));
	
	  /**************/
	 /** ATRIBUTS **/
	/**************/
	
	private final PointF statusMenuPosition = new PointF(0.28,0.989);
	
	private String name;
	private PointF relativPosition;
	
	  /*************/
	 /** BUILDER **/
	/*************/
	
	/** Constructeur de la classe {@code Message}. 
	 * @param name - Nom du status.
	 * @param relativPosition - Position relative du status par rapport au menu status.
	 */
	public Status(String name, PointF relativPosition) {
		this.name = name;
		this.relativPosition = relativPosition;
	}
	
	  /*************/
	 /** GETTERS **/
	/*************/ 
	
	/** Retourne le nom du status.
	 * @return Nom du status.
	 */
	public String getName() {
		return this.name;
	}
	
	  /************/
	 /** STATIC **/
	/************/
	
	/** Active le status pour le joueur en cours.
	 * @throws StopProgramException Si le programme est stopp�.
	 * @throws CancelProgramException Si le bot programme est annul�.
	 * @throws AWTException Si un probl�me de souris survient.
	 */
	public void setStatus() throws AWTException, StopProgramException, CancelProgramException {
		B4D.mouse.leftClick(statusMenuPosition, false, 200);		//Ouvre le menu des status
		PointF checkPosition = new PointF(statusMenuPosition.x + relativPosition.x, statusMenuPosition.y + relativPosition.y);		
		B4D.mouse.leftClick(checkPosition, false, 100);
	}
}
