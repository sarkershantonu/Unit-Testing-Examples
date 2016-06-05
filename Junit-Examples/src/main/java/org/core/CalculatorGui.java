package org.core;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CalculatorGui {

  // Define action listener for numeric buttons
   
   
// Calculator Program Part 3 

  // Define action listener for Clear button
  
  // Declare class variables for class Calculator 

  private static Frame calcFrame;   // Interface frame
  private static Label register;    // Result shown on screen
  private static TextField inputField;
  private static double result;     // Keeps current value
 
// Calculator Program Part 4

  public static void main( String[ ] args )   {
     Label resultLabel;  		// Indicates output area
     Label entryLabel; 		// Label for input field
     Button add;		    	// Add button
     Button subtract;		// Subtract button
     Button clear;		    	// Clear  button
     NumericHandler operation;   // Declare numeric listener
     ClearHandler clearOperation; // Declare clear listener

     // Instantiate event handlers

     operation = new NumericHandler( );
     clearOperation = new ClearHandler( );
     result = 0.0;

     
     
// Calculator Program Part 5
   
     // Instantiate labels and initialize input field

     calcFrame = new Frame( );
     calcFrame.setLayout(new GridLayout(4, 2));
     resultLabel = new Label("Result:");
     register = new Label("0.0", Label.RIGHT); 
     entryLabel = new Label("Enter #:");
     inputField = new TextField("", 10);

     // Instantiate button objects
     add = new Button("+");	
     subtract = new Button("-");
     clear = new Button("Clear");

     // Name button events
     add.setActionCommand("add"); 
     subtract.setActionCommand("subtract");  
     clear.setActionCommand("clear");            
// Calculator Program Part 6
 
     // Register the button listeners
     add.addActionListener(operation); 
     subtract.addActionListener(operation); 
     clear.addActionListener(clearOperation);
 
     // Add components to calcFrame
     calcFrame.add(resultLabel);
     calcFrame.add(register);	
     calcFrame.add(entryLabel);
     calcFrame.add(inputField);		
     calcFrame.add(add);
     calcFrame.add(subtract); 		
     calcFrame.add(clear);     
     calcFrame.pack( );
     calcFrame.show( );	
     
	
     calcFrame.addWindowListener( new WindowAdapter( )
     // Declare window closing event handler
        {
           public void windowClosing (WindowEvent event)
           {
              calcFrame.dispose( );     // Remove frame
              System.exit( 0 );	       // Quit program
           }
        });
  }
  
  private static class ClearHandler implements ActionListener
  {    
     public void actionPerformed(ActionEvent event)   
     // Handles events from Clear button in calcFrame
     {
        result = 0.0;               // Set back to zero
        register.setText("0.0");    // Reset register
        inputField.setText("");     // Clear input
     }
  }
  private static class NumericHandler implements ActionListener
  {    
     public void actionPerformed(ActionEvent event)   
     // Handles events from numeric buttons in calcFrame
     {
        double secondOperand;     // Holds an input value 
        String whichButton;       // Holds buttons name 
// Calculator Program Part 2

        // Get the operand
        secondOperand =  Double.valueOf(inputField.getText())
      					          .doubleValue();
   
        whichButton = event.getActionCommand( ); // Get name		 	
        if (whichButton.equals("add"))		
           result = result + secondOperand;
        else
           result = result - secondOperand; 

        register.setText("" + result); 	// Display result
        inputField.setText(""); 		// Clear input
     }
  }
}

