package com.example.dicerrollerapp

import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dicerrollerapp.ui.theme.DicerRollerAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DicerRollerAppTheme {
                DiceRollerApp()
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DiceRollerAppPreview() {
        DiceRollerApp()
    }

    @Composable
    fun DiceRollerApp() {
        DiceWithButtonAndImage(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        )
    }

    @Composable
    fun DiceWithButtonAndImage(
        modifier: Modifier = Modifier,
        viewModel: DiceViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
    ) {
        val diceState by viewModel.diceState.collectAsState()
        val context = LocalContext.current

        val imageResource = when (diceState.result) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Animations
        val rotation by animateFloatAsState(
            targetValue = if (diceState.isRolling) 360f else 0f,
            animationSpec = tween(durationMillis = 500)
        )
        val scale by animateFloatAsState(
            targetValue = if (diceState.isRolling) 1.2f else 1f,
            animationSpec = tween(durationMillis = 300)
        )
        val alpha by animateFloatAsState(
            targetValue = if (diceState.isRolling) 0.5f else 1f,
            animationSpec = tween(durationMillis = 300)
        )

        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Dice Image
            Image(
                painter = painterResource(imageResource),
                contentDescription = "Dice side ${diceState.result}",
                modifier = Modifier
                    .size(128.dp)
                    .graphicsLayer(
                        rotationZ = rotation,
                        scaleX = scale,
                        scaleY = scale,
                        alpha = alpha
                    )
            )
            Spacer(modifier = Modifier.height(16.dp))
            // Roll Button
            Button(onClick = {
                if (!diceState.isRolling) {
                    viewModel.rollDice()

                    // Play dice roll sound
                    val mediaPlayer = MediaPlayer.create(context, R.raw.dice_roll)
                    mediaPlayer.setOnCompletionListener { it.release() }
                    mediaPlayer.start()
                }
            }) {
                Text(text = "Roll Dice")
            }
        }
    }
}