package sg.edu.rp.c346.id19020125.p13_my_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.core.text.isDigitsOnly
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.abs

class MainActivity : AppCompatActivity() {
    var outEquation = ""
    var equation = ""
    var stringNum = ""
    var total = 0.00
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnOnClick(view: View) {
        var selectedButton = view as Button
        var selected = selectedButton.text
        if((selected.isDigitsOnly() && equation=="") || (equation=="" && selected == ".")) {
            stringNum += selected
            total = stringNum.toDouble()
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
            total = 0.00
            equation = ""
        }
        else if(selected == "%") {
            stringNum += ""
            equation = "percent"
        }
        else if(selected == "+/-") {
            stringNum += ""
            equation = "plus minus"
        }
        else {
            if(selected.isDigitsOnly() || selected == ".") {
                stringNum += selected
            }
        }

        Log.d("MainActivity", "strNum $stringNum $equation")

        if(stringNum != "" && selected == "=") {
            if (equation == "plus") {
                total += stringNum.toDouble()
            } else if (equation == "minus") {
                total -= stringNum.toDouble()
            } else if (equation == "divide") {
                total /= stringNum.toDouble()
            } else if (equation == "multiply") {
                total *= stringNum.toDouble()
            } else if (equation == "percent") {
                total = stringNum.toDouble() / 100
            }  else if (equation == "plus minus") {
                total = abs(total)
            }
        }
        Log.d("MainActivity", "total$total")
        Log.d("MainActivity",outEquation)
        if(selected != "AC") {
            outEquation += selected
        }
        textView.text = outEquation
        tvTotal.text = total.toString()
    }
}