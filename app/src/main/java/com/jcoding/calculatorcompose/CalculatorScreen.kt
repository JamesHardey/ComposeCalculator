package com.jcoding.calculatorcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jcoding.calculatorcompose.ui.theme.PurpleGrey80
import kotlin.math.pow


@Preview(showBackground = true)
@Composable
fun CalculatorScreen() {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {


        var textValue by remember{ mutableStateOf("") }
        var result by remember{ mutableStateOf("") }
        var reset by remember{ mutableStateOf(true) }

        val action:()->Unit = { }

        Display(text = textValue, result = result)

        Column(modifier = Modifier
            .weight(1f)){
            Row(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 2.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                CalculatorButtonItem(
                    value = "0",
                    modifier = Modifier
                        .weight(1f),
                    onClicked = {
                        if (reset) {
                            textValue = "0"
                            reset = false
                        }
                        else if(textValue == "0") textValue = "0"
                        else textValue += "0"
                    }
                )

                CalculatorButtonItem(
                    value = "+",
                    modifier = Modifier
                        .weight(1f),
                    onClicked = {
                        if (!reset){
                            textValue += "+"
                        }
                    }
                )


                CalculatorButtonItem(
                    value = "-",
                    modifier = Modifier
                        .weight(1f),
                    onClicked = {
                        if (!reset) textValue += "-"
                    }
                )


                CalculatorButtonItem(
                    value = "C",
                    modifier = Modifier
                        .weight(1f),
                    onClicked = {
                        textValue = "0"
                        result = ""
                        reset = true
                    }
                )
            }

            Row(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 2.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                CalculatorButtonItem(
                    value = "7",
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(),
                    onClicked = {
                        if(reset) {
                            textValue = "7"
                            reset = false
                        }
                        else textValue += "7"
                    }
                )

                CalculatorButtonItem(
                    value = "8",
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(),
                    onClicked = {
                        if(reset) {
                            textValue = "8"
                            reset = false
                        }
                        else textValue += "8"
                    }
                )


                CalculatorButtonItem(
                    value = "9",
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(),
                    onClicked = {
                        if(reset){
                            textValue = "9"
                            reset = false
                        }
                        else textValue += "9"
                    }
                )


                CalculatorButtonItem(
                    value = "/",
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(),
                    onClicked = {
                        if(!reset) textValue += "/"
                    }
                )
            }

            Row(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 2.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                CalculatorButtonItem(
                    value = "4",
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(),
                    onClicked = {
                        if(reset) {
                            textValue = "4"
                            reset = false
                        }
                        else textValue += "4"
                    }
                )

                CalculatorButtonItem(
                    value = "5",
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(),
                    onClicked = {
                        if(reset) {
                            textValue = "5"
                            reset = false
                        }
                        else textValue += "5"
                    }
                )


                CalculatorButtonItem(
                    value = "6",
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(),
                    onClicked = {
                        if(reset) {
                            textValue = "6"
                            reset = false
                        }
                        else textValue += "6"
                    }
                )


                CalculatorButtonItem(
                    value = "X",
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(),
                    onClicked = {
                        if (!reset) textValue += "x"
                    }
                )
            }


            Row(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 2.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                CalculatorButtonItem(
                    value = "1",
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(),
                    onClicked = {
                        if (reset) {
                            textValue = "1"
                            reset = false
                        }
                        else textValue += "1"
                    }
                )

                CalculatorButtonItem(
                    value = "2",
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(),
                    onClicked = {
                        if (reset) {
                            textValue = "2"
                            reset = false
                        }
                        else textValue += "2"
                    }
                )


                CalculatorButtonItem(
                    value = "3",
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(),
                    onClicked = {
                        if (reset){
                            textValue = "3"
                            reset = false
                        }
                        else textValue += "3"
                    }
                )


                CalculatorButtonItem(
                    value = "=",
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(),
                    onClicked = {
                        result = try {
                            eval(textValue).toString()
                        } catch (e: Exception) {
                            "Error"
                        }
                    }
                )
            }
        }

    }
}


/* Compose Display Screen*/

@Composable
fun Display(
    text: String,
    result: String
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .background(color = Color.Black)
            .padding(16.dp)
    ){  
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Center
        ){
            Text(
                text= text,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
            )

            Spacer(modifier = Modifier.padding(10.dp))

            Text(
                text= result,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier

            )

        }


    }
}



/* Calculator Button Item*/

@Composable
fun CalculatorButtonItem(
    value: String,
    modifier: Modifier = Modifier,
    onClicked: () -> Unit
) {
    Button(
        modifier = modifier
            .fillMaxHeight()
            .padding(1.dp),
        shape = RectangleShape,
        onClick = onClicked
    ){
        Text(
            text = value,
            style = MaterialTheme.typography.headlineMedium
        )
    }
}


fun eval(str: String): Double {
    return object : Any() {
        var pos = -1
        var ch: Char = ' '
        fun nextChar() {
            val size = str.length
            ch = if (++pos < size) str[pos] else (-1).toChar()
        }

        fun eat(charToEat: Char): Boolean {
            while (ch == ' ') nextChar()
            if (ch == charToEat) {
                nextChar()
                return true
            }
            return false
        }

        fun parse(): Double {
            nextChar()
            val x = parseExpression()
            if (pos < str.length) throw Exception("Unexpected: $ch")
                return x
        }

        fun parseExpression(): Double {
            var x = parseTerm()
            while (true) {
                if (eat('+')) x += parseTerm()
                else if (eat('-')) x -= parseTerm()
                else return x
            }
        }

        fun parseTerm(): Double {
            var x = parseFactor()
            while (true) {
                if (eat('x')) x *= parseFactor()
                else if (eat('/')) x /= parseFactor()
                else return x
            }
        }

        fun parseFactor(): Double {
            if (eat('+')) return parseFactor()
            if (eat('-')) return -parseFactor()
            var x: Double
            val startPos = this.pos
            if (eat('(')) {
                x = parseExpression()
                eat(')')
            } else if ((ch in '0'..'9') || ch == '.') {
                while ((ch in '0'..'9') || ch == '.') nextChar()
                x = java.lang.Double.parseDouble(str.substring(startPos, this.pos))
            } else throw Exception("Unexpected: $ch")
            if (eat('^')) x = x.pow(parseFactor())
            return x
        }
    }.parse()
}



