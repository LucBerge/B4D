package fr.B4D.programs;

import java.awt.AWTException;
import java.awt.Point;

import fr.B4D.dofus.B4DCannotFind;
import fr.B4D.dofus.Dofus;
import fr.B4D.program.ProgramInterface;
import fr.B4D.transport.B4DWrongPosition;

public final class Deplacement {
	public static ProgramInterface deplacement = new ProgramInterface() {

		public void run() throws AWTException, B4DCannotFind, B4DWrongPosition {
			Dofus.getWorld().goTo(new Point(4, -18));
			Dofus.getWorld().goTo(new Point(3, -19));
		}
	};
}