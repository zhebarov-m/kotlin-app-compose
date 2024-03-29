import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import kotlin.random.Random

@Composable
@Preview
fun App() {
    var text by remember { mutableStateOf("Изменить цвет") }
    var textInBox by remember { mutableStateOf("XARCHO") }
    var buttonChangeColor by remember { mutableStateOf(Color.Red)}
    println(buttonChangeColor)

    MaterialTheme {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.size(200.dp).background(buttonChangeColor),
            ) {
                Text(
                    textInBox,
                    fontWeight = FontWeight(700)
                )
            }
            Button(onClick = {
                text = "Изменить цвет"
                buttonChangeColor = Color(Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))
            },
                colors = ButtonDefaults.buttonColors(backgroundColor = buttonChangeColor),
                modifier = Modifier.padding(21.dp)
            ) {
                Text(text)
            }
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
