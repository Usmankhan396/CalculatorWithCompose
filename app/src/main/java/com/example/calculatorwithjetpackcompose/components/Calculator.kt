package com.example.calculatorwithjetpackcompose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculatorwithjetpackcompose.CalculatorAction
import com.example.calculatorwithjetpackcompose.CalculatorOperation
import com.example.calculatorwithjetpackcompose.CalculatorState
import com.example.calculatorwithjetpackcompose.ui.theme.LightGray
import com.example.calculatorwithjetpackcompose.ui.theme.Orange

@Composable
fun Calculator(
    state: CalculatorState,
    modifier: Modifier = Modifier,
    buttonSpace: Dp = 8.dp,
    onAction: (CalculatorAction) -> Unit
) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpace)
        ) {
            Text(
                text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 30.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 80.sp,
                color = Color.White,
                maxLines = 2
            )

            TopRow(buttonSpace, onAction)
            FirstDigitsRow(buttonSpace, onAction)
            SecondDigitsRow(buttonSpace, onAction)
            ThirdDigitsRow(buttonSpace, onAction)
            LastDigitsRow(buttonSpace, onAction)

        }
    }
}

@Composable
private fun TopRow(
    buttonSpace: Dp,
    onAction: (CalculatorAction) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(buttonSpace)
    ) {
        CalculatorButton(
            symbol = "AC", modifier = Modifier
                .background(LightGray)
                .aspectRatio(2f)
                .weight(2f),
            onClick = {
                onAction(CalculatorAction.Clear)
            }
        )
        CalculatorButton(
            symbol = "DEL", modifier = Modifier
                .background(LightGray)
                .aspectRatio(1f)
                .weight(1f),
            onClick = {
                onAction(CalculatorAction.Delete)
            }
        )
        CalculatorButton(
            symbol = "/", modifier = Modifier
                .background(LightGray)
                .aspectRatio(1f)
                .weight(1f),
            onClick = {
                onAction(CalculatorAction.Operation(CalculatorOperation.Divide))
            }
        )
    }
}

@Composable
private fun FirstDigitsRow(
    buttonSpace: Dp,
    onAction: (CalculatorAction) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(buttonSpace)
    ) {
        CalculatorButton(
            symbol = "7", modifier = Modifier
                .background(Color.DarkGray)
                .aspectRatio(1f)
                .weight(1f),
            onClick = {
                onAction(CalculatorAction.Number(7))
            }
        )
        CalculatorButton(
            symbol = "8", modifier = Modifier
                .background(Color.DarkGray)
                .aspectRatio(1f)
                .weight(1f),
            onClick = {
                onAction(CalculatorAction.Number(8))
            }
        )
        CalculatorButton(
            symbol = "9", modifier = Modifier
                .background(Color.DarkGray)
                .aspectRatio(1f)
                .weight(1f),
            onClick = {
                onAction(CalculatorAction.Number(9))
            }
        )
        CalculatorButton(
            symbol = "x", modifier = Modifier
                .background(Orange)
                .aspectRatio(1f)
                .weight(1f),
            onClick = {
                onAction(CalculatorAction.Operation(CalculatorOperation.Multiply))
            }
        )
    }
}

@Composable
private fun SecondDigitsRow(
    buttonSpace: Dp,
    onAction: (CalculatorAction) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(buttonSpace)
    ) {
        CalculatorButton(
            symbol = "4", modifier = Modifier
                .background(Color.DarkGray)
                .aspectRatio(1f)
                .weight(1f),
            onClick = {
                onAction(CalculatorAction.Number(4))
            }
        )
        CalculatorButton(
            symbol = "5", modifier = Modifier
                .background(Color.DarkGray)
                .aspectRatio(1f)
                .weight(1f),
            onClick = {
                onAction(CalculatorAction.Number(5))
            }
        )
        CalculatorButton(
            symbol = "6", modifier = Modifier
                .background(Color.DarkGray)
                .aspectRatio(1f)
                .weight(1f),
            onClick = {
                onAction(CalculatorAction.Number(6))
            }
        )
        CalculatorButton(
            symbol = "-", modifier = Modifier
                .background(Orange)
                .aspectRatio(1f)
                .weight(1f),
            onClick = {
                onAction(CalculatorAction.Operation(CalculatorOperation.Subtract))
            }
        )
    }
}

@Composable
private fun ThirdDigitsRow(
    buttonSpace: Dp,
    onAction: (CalculatorAction) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(buttonSpace)
    ) {
        CalculatorButton(
            symbol = "1", modifier = Modifier
                .background(Color.DarkGray)
                .aspectRatio(1f)
                .weight(1f),
            onClick = {
                onAction(CalculatorAction.Number(1))
            }
        )
        CalculatorButton(
            symbol = "2", modifier = Modifier
                .background(Color.DarkGray)
                .aspectRatio(1f)
                .weight(1f),
            onClick = {
                onAction(CalculatorAction.Number(2))
            }
        )
        CalculatorButton(
            symbol = "3", modifier = Modifier
                .background(Color.DarkGray)
                .aspectRatio(1f)
                .weight(1f),
            onClick = {
                onAction(CalculatorAction.Number(3))
            }
        )
        CalculatorButton(
            symbol = "+", modifier = Modifier
                .background(Orange)
                .aspectRatio(1f)
                .weight(1f),
            onClick = {
                onAction(CalculatorAction.Operation(CalculatorOperation.Add))
            }
        )
    }
}

@Composable
private fun LastDigitsRow(
    buttonSpace: Dp,
    onAction: (CalculatorAction) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(buttonSpace)
    ) {
        CalculatorButton(
            symbol = "0", modifier = Modifier
                .background(Color.DarkGray)
                .aspectRatio(2f)
                .weight(2f),
            onClick = {
                onAction(CalculatorAction.Number(0))
            }
        )
        CalculatorButton(
            symbol = ".", modifier = Modifier
                .background(Color.DarkGray)
                .aspectRatio(1f)
                .weight(1f),
            onClick = {
                onAction(CalculatorAction.Decimal)
            }
        )
        CalculatorButton(
            symbol = "=", modifier = Modifier
                .background(Orange)
                .aspectRatio(1f)
                .weight(1f),
            onClick = {
                onAction(CalculatorAction.Calculate)
            }
        )
    }
}
