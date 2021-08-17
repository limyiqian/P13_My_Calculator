package sg.edu.rp.c346.id19020125.p13_my_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.core.text.isDigitsOnly
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var outEquation = ""
    var equation = ""
    var stringNum = ""
    var total = 0
    var holdTotal = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnOnClick(view: View) {
        var selectedButton = view as Button
        var selected = selectedButton.text
        if(selected.isDigitsOnly() && equation=="") {
            stringNum += selected
            total = stringNum.toInt()
        }
        else if(selected == "+") {
            equation = "plus"
            stringNum = ""
        }
        else if(selected == "-") {
            equation = "minus"
            stringNum = ""
        }
        else if(selected == "/") {
            equation = "divide"
            stringNum = ""
        }
        else if(selected == "*") {
            equation = "multiply"
            stringNum = ""
        }
        else if(selected == "AC") {
            outEquation = ""
            stringNum = ""
            total = 0
        }
        else if(selected == ".") {
            stringNum += "."
            equation = "decimal"
        }
        else {
            if(selected.isDigitsOnly()) {
                stringNum += selected
            }
            if(equation == "plus") {
                total += stringNum.toInt()
            }
            else if(equation == "minus") {
                total -= stringNum.toInt()
            }
            else if(equation == "divide") {
                total /= stringNum.toInt()
            }
            else if(equation == "multiply") {
                total *= stringNum.toInt()
            }
        }
        Log.d("MainActivity", "Str num $stringNum")
        Log.d("MainActivity", "Total $total")
        if(selected != "AC") {
            outEquation += selected
        }
        textView.text = outEquation
        tvTotal.text = total.toString()
    }
}