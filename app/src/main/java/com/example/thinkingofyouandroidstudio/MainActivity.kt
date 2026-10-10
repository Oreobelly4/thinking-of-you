package com.example.thinkingofyouandroidstudio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thinkingofyouandroidstudio.ui.theme.THINKINGOFYOUANDROIDSTUDIOTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            THINKINGOFYOUANDROIDSTUDIOTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF10080D)
                ) {
                    WidgetGuideScreen()
                }
            }
        }
    }
}

@Composable
fun WidgetGuideScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF1E0A12),
                        Color(0xFF10080D),
                        Color(0xFF080406)
                    )
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "✦", color = Color(0xFFFF3B5C), fontSize = 36.sp)
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Thinking of You Multi-Device Routing",
                color = Color(0xFFFFB4BC),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Check out the interactive 3-Phone Routing Preview below!",
                color = Color(0xFFD9B9BF),
                fontSize = 13.sp
            )
        }
    }
}

@Preview(name = "Three-Phone Routing Simulation", showBackground = true, widthDp = 1100, heightDp = 500)
@Composable
fun ThreePhoneSimulationPreview() {
    THINKINGOFYOUANDROIDSTUDIOTheme {
        var activeMomSparkle by remember { mutableStateOf(false) }
        var activeBabeSparkle by remember { mutableStateOf(false) }
        val coroutineScope = rememberCoroutineScope()

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF120A0F))
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // --- PHONE 1: SENDER ---
                PhoneMockup(title = "Phone 1: Sender Home Screen") {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            StandardAppIcon("Phone", Color(0xFF34C759))
                            StandardAppIcon("Messages", Color(0xFF007AFF))
                            StandardAppIcon("Camera", Color(0xFFFF9500))
                            StandardAppIcon("Browser", Color(0xFF5856D6))
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            WidgetAppIcon(
                                label = "Mom",
                                onClick = {
                                    activeMomSparkle = true
                                    coroutineScope.launch {
                                        delay(1800)
                                        activeMomSparkle = false
                                    }
                                }
                            )

                            WidgetAppIcon(
                                label = "Babe",
                                onClick = {
                                    activeBabeSparkle = true
                                    coroutineScope.launch {
                                        delay(1800)
                                        activeBabeSparkle = false
                                    }
                                }
                            )

                            StandardAppIcon("Photos", Color(0xFFFF2D55))
                            StandardAppIcon("Music", Color(0xFFAF52DE))
                        }
                    }
                }

                // --- PHONE 2: MOM'S PHONE ---
                PhoneMockup(title = "Phone 2: Mom's Device") {
                    RecipientScreenContent(
                        screenTitle = "Reading Book",
                        bodyText = "Chapter 4: Quiet Connections\n\nA gentle breeze stirs the curtains. Without a word spoken or a notification demanding attention...",
                        isSparkling = activeMomSparkle
                    )
                }

                // --- PHONE 3: BABE'S PHONE ---
                PhoneMockup(title = "Phone 3: Babe's Device") {
                    RecipientScreenContent(
                        screenTitle = "Browsing Recipe / Map",
                        bodyText = "Searching for local coffee shops nearby...\n\nQuietly discovering new corners of the city while holding you in thought.",
                        isSparkling = activeBabeSparkle
                    )
                }
            }
        }
    }
}

@Composable
fun PhoneMockup(
    title: String,
    content: @Composable ColumnScope.() -> Unit
) {
    Box(
        modifier = Modifier
            .width(340.dp)
            .fillMaxHeight()
            .clip(RoundedCornerShape(32.dp))
            .background(Color(0xFF1E161C))
            .border(3.dp, Color(0xFF402631), RoundedCornerShape(32.dp))
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "9:41", color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                Box(
                    modifier = Modifier
                        .width(50.dp)
                        .height(5.dp)
                        .background(Color(0xFF332028), CircleShape)
                )
                Text(text = "5G 🔋", color = Color.White, fontSize = 10.sp)
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = title,
                color = Color(0xFFFFB4BC),
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(16.dp))

            content()
        }
    }
}

@Composable
fun RecipientScreenContent(
    screenTitle: String,
    bodyText: String,
    isSparkling: Boolean
) {
    val alpha by animateFloatAsState(
        targetValue = if (isSparkling) 1f else 0f,
        animationSpec = tween(durationMillis = if (isSparkling) 400 else 600)
    )
    val scale by animateFloatAsState(
        targetValue = if (isSparkling) 1.25f else 0.7f,
        animationSpec = tween(durationMillis = if (isSparkling) 400 else 600)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xFFF7F4EF))
            .padding(14.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = screenTitle, color = Color(0xFF8C7378), fontSize = 11.sp, fontWeight = FontWeight.Medium)

                // Ephemeral Red Sparkling Stars in Top Right Corner (Smooth Fade & Scale Animation, Zero text)
                Box(
                    modifier = Modifier.size(36.dp),
                    contentAlignment = Alignment.Center
                ) {
                    if (alpha > 0.01f) {
                        Text(
                            text = "✦ ✦",
                            fontSize = 22.sp,
                            color = Color(0xFFB8A2E6),
                            modifier = Modifier
                                .graphicsLayer(
                                    alpha = alpha,
                                    scaleX = scale,
                                    scaleY = scale
                                )


                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = bodyText,
                color = Color(0xFF663399),
                fontSize = 13.sp,
                lineHeight = 18.sp
            )
        }
    }
}

@Composable
fun StandardAppIcon(name: String, color: Color) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier.width(56.dp)
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .background(color, RoundedCornerShape(12.dp))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(14.dp)
                    .background(Color.White.copy(alpha = 0.3f), CircleShape)
            )
        }
        Text(
            text = name,
            color = Color.White,
            fontSize = 10.sp,
            maxLines = 1,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun WidgetAppIcon(
    label: String,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier
            .width(56.dp)
            .clickable(onClick = onClick)
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .background(Color(0xFF26121B), RoundedCornerShape(12.dp))
                .border(1.dp, Color(0xFFFF3B5C).copy(alpha = 0.6f), RoundedCornerShape(12.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "✦", fontSize = 28.sp, color = Color(0xFFFF3B5C))
        }
        Text(
            text = label,
            color = Color.White,
            fontSize = 10.sp,
            fontWeight = FontWeight.SemiBold,
            maxLines = 1,
            textAlign = TextAlign.Center
        )
    }
}
