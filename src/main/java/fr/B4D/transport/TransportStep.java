package fr.B4D.transport;

import java.awt.AWTException;
import java.awt.Point;
import java.io.Serializable;

import fr.B4D.dofus.CannotFindException;
import fr.B4D.program.CancelProgramException;
import fr.B4D.program.StopProgramException;

/** La classe {@code TransportStep} repr�sente une �tape dans un chemin entre deux point de la carte.
 * Une �tape est d�fini par un transport et une destination.
 */
public class TransportStep implements Serializable{

	private static final long serialVersionUID = 5240292689676673762L;
	
	private Transport transport;
	private Point destination;

	  /*************/
	 /** BUILDER **/
	/*************/

	/** Constructeur de la classe {@code TransportStep}. 
	 * @param transport - Transport utilis� pour l'�tape.
	 * @param destination - Destination du transport.
	 */
	public TransportStep(Transport transport, Point destination) {
		this.transport = transport;
		this.destination = destination;
	}

	  /*************/
	 /** GETTERS **/
	/*************/
	
	/** Retourne le transport de l'�tape.
	 * @return Transport de l'�tape.
	 */
	public Transport getTransport() {
		return transport;
	}
	
	/** Modifi le transport de l'�tape.
	 * @param transport - Nouveau transport de l'�tape.
	 */
	public void setTransport(Transport transport) {
		this.transport = transport;
	}
	
	/** Retourne la destination de l'�tape.
	 * @return Destination de l'�tape.
	 */
	public Point getDestination() {
		return destination;
	}
	
	/** Modifi le destination de l'�tape.
	 * @param destination - Nouvelle destination de l'�tape.
	 */
	public void setDestination(Point destination) {
		this.destination = destination;
	}
	
	  /**************/
	 /** METHODES **/
	/**************/
	
	/** Permet d'utiliser le transport de l'�tape.
	 * @param person - Joueur utilisant le transport.
	 * @throws StopProgramException Si le programme est stopp�.
	 * @throws CancelProgramException Si le programme est annul�.
	 * @throws CannotFindException Si la destination d'une de l'�tape est introuvable.
	 * @throws WrongPositionException Si le joueur est mal plac� pour emprunter le moyen de transport.
	 * @throws AWTException Si un probl�me de souris survient.
	 */
	public void use() throws AWTException, CannotFindException, WrongPositionException, StopProgramException, CancelProgramException {
		transport.goTo(destination);
	}

	  /**************/
	 /** TOSTRING **/
	/**************/
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return transport.getPosition() + " vers " + destination + " via " + transport.getName();
	}
}