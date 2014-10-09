// MainActivity.java
// Calculates bills using 15% and custom percentage tips.
package com.deitel.tipcalculator;

import java.text.NumberFormat; // for currency formatting
import java.lang.Math;

import android.app.Activity; // base class for activities
import android.os.Bundle; // for saving state information
import android.text.Editable; // for EditText event handling
import android.text.TextWatcher; // EditText listener
import android.widget.EditText; // for bill amount input
import android.widget.SeekBar; // for changing custom tip percentage
import android.widget.SeekBar.OnSeekBarChangeListener; // SeekBar listener
import android.widget.TextView; // for displaying text

// MainActivity class for the Tip Calculator app
public class MainActivity extends Activity 
{
   // currency and percent formatters 
   private static final NumberFormat numberFormat =
		   NumberFormat.getNumberInstance();

   private Integer age = 0; // default age
   private TextView amountDisplayTextViewAge; // shows Age
   private TextView amountEditTextAge; //inputs age
   private TextView amountTextViewHR; //displays max heart rate
   private TextView amountDisplayTextViewTargetLow; //displays target rate low
   private TextView amountDisplayTextViewTargetHigh; //displays target heart rate high
   private int maxHeartRate = 0;
   private int targetHeartRateLow = 0;
   private int targetHeartRateHigh = 0;
   
  

   // called when the activity is first created
   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState); // call superclass's version
      setContentView(R.layout.activity_main); // inflate the GUI

      // get references to the TextViews 
      // that MainActivity interacts with programmatically
      amountDisplayTextViewAge = 
         (TextView) findViewById(R.id.amountDisplayTextViewAge);  
      amountTextViewHR = 
    	         (TextView) findViewById(R.id.amountTextViewMaxHR); 
      amountDisplayTextViewTargetLow = 
    		  (TextView) findViewById(R.id.amountDisplayTextViewTargetLow);
      amountDisplayTextViewTargetHigh =
    		  (TextView) findViewById(R.id.amountDisplayTextViewTargetHigh);
      
            
      // update GUI based on billAmount and customPercent 
      amountDisplayTextViewAge.setText(
         numberFormat.format(age));
      amountTextViewHR.setText(numberFormat.format(maxHeartRate));
      amountDisplayTextViewTargetLow.setText(numberFormat.format(targetHeartRateLow));
      amountDisplayTextViewTargetHigh.setText(numberFormat.format(targetHeartRateHigh));

      // set amountEditText's TextWatcher
      EditText amountEditTextAge = 
         (EditText) findViewById(R.id.amountEditTextAge);
      	amountEditTextAge.addTextChangedListener(amountEditTextWatcherAge);    
   } // end method onCreate

   
// calcualtes Maximum Heart Rate and target heart rates
   private void updateStandard() 
   {
	   //calculates max heart rate
	   maxHeartRate = 220 - age;
	   amountTextViewHR.setText(numberFormat.format(maxHeartRate));
	   
	   //calculates target heart rate low
	   double targetHRL = (double)maxHeartRate * 0.5;
	   targetHeartRateLow = (int)targetHRL;
	   amountDisplayTextViewTargetLow.setText(numberFormat.format(targetHeartRateLow));
	   
	   //calculates target heart rate high
	   double targetHRH = (double)maxHeartRate * 0.85;
	   targetHeartRateHigh = (int)targetHRH;
	   amountDisplayTextViewTargetHigh.setText(numberFormat.format(targetHeartRateHigh));
	  
   } // end method updateStandard

   
   // event-handling object that responds to amountEditTextViewAge events
   private TextWatcher amountEditTextWatcherAge = new TextWatcher() 
   {
	// called when the user enters a number
	      @Override
	      public void onTextChanged(CharSequence s, int start, 
	         int before, int count) 
	      {          
	         // convert amountEditText's text to a double
	         try
	         {
	            age = Integer.parseInt(s.toString());
	         } // end try
	         catch (NumberFormatException e)
	         {
	            age = 0; // default if an exception occurs
	         } // end catch 

	         // display currency formatted bill amount
	         amountDisplayTextViewAge.setText(numberFormat.format(age));
	         updateStandard(); // update 10 and 20 year monthly payments  
	      } // end method onTextChanged

      @Override
      public void afterTextChanged(Editable s) 
      {
      } // end method afterTextChanged

      @Override
      public void beforeTextChanged(CharSequence s, int start, int count,
         int after) 
      {
      } // end method beforeTextChanged
   }; // end amountEditTextWatcherPP

} // end class MainActivity


/*************************************************************************
* (C) Copyright 1992-2014 by Deitel & Associates, Inc. and               *
* Pearson Education, Inc. All Rights Reserved.                           *
*                                                                        *
* DISCLAIMER: The authors and publisher of this book have used their     *
* best efforts in preparing the book. These efforts include the          *
* development, research, and testing of the theories and programs        *
* to determine their effectiveness. The authors and publisher make       *
* no warranty of any kind, expressed or implied, with regard to these    *
* programs or to the documentation contained in these books. The authors *
* and publisher shall not be liable in any event for incidental or       *
* consequential damages in connection with, or arising out of, the       *
* furnishing, performance, or use of these programs.                     *
*************************************************************************/
