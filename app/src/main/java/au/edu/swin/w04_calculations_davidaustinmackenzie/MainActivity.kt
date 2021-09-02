package au.edu.swin.w04_calculations_davidaustinmackenzie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    //Used to store the output calculation
    private var outputResult = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("LIFECYCLE_CALL","This onCreate method was called")

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        //Get input elements
        val number1 = findViewById<EditText>(R.id.number1)
        val number2 = findViewById<EditText>(R.id.number2)
        val equals = findViewById<Button>(R.id.equals)
        val radioAdd = findViewById<RadioButton>(R.id.radioAdd)

        //Get output elements
        val answer = findViewById<TextView> (R.id.answer)

        //Check whether we're recreating a previously destroyed instance
        if(savedInstanceState!=null){
            with(savedInstanceState){
                outputResult = getInt(RESULT)
                if(outputResult!=0) {
                    answer.text = outputResult.toString()
                }
            }
        }

        //Check to see if Add or multiply is selected
        equals.setOnClickListener {
            outputResult = if(radioAdd.isChecked){
                add(number1.text.toString(), number2.text.toString())
            }else{
                multiply(number1.text.toString(), number2.text.toString())
            }

            // Show result on the screen
            answer.text = outputResult.toString()
        }
    }

    //onStart method is called
    override fun onStart(){
        super.onStart()
        Log.i("LIFECYCLE_CALL","This onStart method was called")
    }

    //onResume method is called
    override fun onResume(){
        super.onResume()
        Log.i("LIFECYCLE_CALL","This onResume method was called")
    }

    //onPause method is called
    override fun onPause(){
        super.onPause()
        Log.i("LIFECYCLE_CALL","This onPause method was called")
    }

    //onStop method is called
    override fun onStop(){
        super.onStop()
        Log.i("LIFECYCLE_CALL","This onStop method was called")
    }

    //onDestroy method is called
    override fun onDestroy() {
        super.onDestroy()
        Log.i("LIFECYCLE_CALL","This onDestroy method was called")
    }

    //override the savedInstanceState function
    override fun onSaveInstanceState(outState: Bundle) {
        // Save the user's current game state
        outState.run {
            putInt(RESULT, outputResult)
        }

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(outState)
    }

    companion object {
        val RESULT = "outputResult"
    }

    //Restore the saved calculation value
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        //Restore state members from saved instance
        savedInstanceState.run{
            outputResult = getInt(RESULT)
        }
    }

    // adds two numbers together
    private fun add(number1: String, number2: String) = number1.toInt() + number2.toInt()

    //multiple two numbers together
    private fun multiply(number1: String, number2: String) = number1.toInt() * number2.toInt()
}