package be.cetic.simqri.cockpit.util;

import javax.swing.JOptionPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;


/**
 * 
 * @author Hovecraft Full Of Eels
 * This class has been found on the internet at http://stackoverflow.com/questions/11093326/restricting-jtextfield-input-to-integers
 * Its goal is to disable the encoding of chars in JTextFields
 */
public class IntFilter extends DocumentFilter {
	   @Override
	   public void insertString(FilterBypass fb, int offset, String string,
	         AttributeSet attr) throws BadLocationException {

	      Document doc = fb.getDocument();
	      StringBuilder sb = new StringBuilder();
	      sb.append(doc.getText(0, doc.getLength()));
	      sb.insert(offset, string);

	      if (test(sb.toString())) {
	         super.insertString(fb, offset, string, attr);
	      } else {
	         JOptionPane.showMessageDialog(null,  "STOP ! You're only allowed to encode numbers !", "Warning", JOptionPane.ERROR_MESSAGE);
	      }
	   }

	   private boolean test(String text) {
	      try {
	         Integer.parseInt(text);
	         return true;
	      } catch (NumberFormatException e) {
	         return false;
	      }
	   }

	   @Override
	   public void replace(FilterBypass fb, int offset, int length, String text,
	         AttributeSet attrs) throws BadLocationException {

	      Document doc = fb.getDocument();
	      StringBuilder sb = new StringBuilder();
	      sb.append(doc.getText(0, doc.getLength()));
	      sb.replace(offset, offset + length, text);

	      if (test(sb.toString())) {
	         super.replace(fb, offset, length, text, attrs);
	      } else {
	    	  	 JOptionPane.showMessageDialog(null,  "STOP ! You're only allowed to encode numbers !", "Warning", JOptionPane.ERROR_MESSAGE);
	      }

	   }
	}