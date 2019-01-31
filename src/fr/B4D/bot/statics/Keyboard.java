package fr.B4D.bot.statics;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.IOException;

import fr.B4D.modules.B4DWait;

public final class Keyboard{
	
	private static Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	
	  /****************/
	 /** SINGLE KEY **/
	/****************/
	
	public void sendKey(int keyEvent, int time) throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(keyEvent);
		robot.keyRelease(keyEvent);
		B4DWait.wait(time);
	}
	public void sendKey(int keyEvent) throws AWTException {
		sendKey(keyEvent, 100);
	}
	
	  /********************/
	 /** WRITE KEYBOARD **/
	/********************/
	
	public void writeKeyboard(String text, int time) throws AWTException {
		setClipboard(text);
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		B4DWait.wait(time);
	}
	public void writeKeyboard(String text) throws AWTException {
		writeKeyboard(text, 500);
	}
	
	  /***************/
	 /** CLIPBOARD **/
	/***************/
	
	public void setClipboard(String text) throws AWTException {
		clipboard.setContents(new StringSelection(text), null);
	}
	public String getClipboard() throws AWTException, UnsupportedFlavorException, IOException{
        return (String) clipboard.getData(DataFlavor.stringFlavor);
	}
}