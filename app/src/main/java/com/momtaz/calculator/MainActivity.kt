package com.momtaz.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.momtaz.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var lastnumber:Double =0.0
    var cruntopretoin : opretoin? =null
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addcallback()
    }

    private fun addcallback() {
        binding.ButtonC.setOnClickListener {
            clearinput()
        }
        binding.ButtonPlus.setOnClickListener {
            preparopretoin(opretoin.Plus)

        }
        binding.ButtonMinus.setOnClickListener {
            preparopretoin(opretoin.Minus)
        }
        binding.ButtonMulti.setOnClickListener {
            preparopretoin(opretoin.Mul)
        }
        binding.ButtonDiv.setOnClickListener {
            preparopretoin(opretoin.Div)
        }
        binding.ButtonEqual.setOnClickListener {
           var result = docurrntopratoin()
            binding.textViewResule.text = result.toString()
        }
    }

    private fun docurrntopratoin() : Double {
        var sacndnumber = binding.textViewOpretion.text.toString().toDouble()
       return when (cruntopretoin)
        {
            opretoin.Plus -> lastnumber + sacndnumber
            opretoin.Minus -> lastnumber - sacndnumber
            opretoin.Mul -> lastnumber * sacndnumber
            opretoin.Div -> lastnumber / sacndnumber
            null -> 0.0
        }
    }

    fun clearinput()
    {
     binding.textViewOpretion.text =""
        binding.textViewResule.text =""
    }
    fun preparopretoin(opretoin: opretoin)
    {
        lastnumber = binding.textViewOpretion.text.toString().toDouble()
        clearinput()
        cruntopretoin = opretoin
    }
    fun onclicknumber(v : View)
    {
      var new_digit = (v as Button).text.toString()
      var old_digit = binding.textViewOpretion.text.toString()
      var newtextnumber = old_digit + new_digit
        binding.textViewOpretion.text = newtextnumber
    }
}