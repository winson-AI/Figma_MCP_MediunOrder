package com.example.mediunorder

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.rememberScrollState
import mediunorder.composeapp.generated.resources.Res
import mediunorder.composeapp.generated.resources.ic_arrow_left
import mediunorder.composeapp.generated.resources.ic_plus_small
import mediunorder.composeapp.generated.resources.ic_minus_small
import mediunorder.composeapp.generated.resources.ic_search
import mediunorder.composeapp.generated.resources.ic_check_circle
import mediunorder.composeapp.generated.resources.img_hero_burger
import mediunorder.composeapp.generated.resources.img_fries
import mediunorder.composeapp.generated.resources.img_coleslaw
import mediunorder.composeapp.generated.resources.img_salad
import mediunorder.composeapp.generated.resources.img_mozzarella
import mediunorder.composeapp.generated.resources.img_tomato
import mediunorder.composeapp.generated.resources.img_onions
import mediunorder.composeapp.generated.resources.img_pickles
import mediunorder.composeapp.generated.resources.img_bacon
import mediunorder.composeapp.generated.resources.img_cheese
import mediunorder.composeapp.generated.resources.img_mushroom
import mediunorder.composeapp.generated.resources.slider_track
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ProductScreen(modifier: Modifier = Modifier) {
    var portions by remember { mutableIntStateOf(2) }
    Column(
        modifier = modifier
            .background(Color.White)
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        // Top bar
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(Res.drawable.ic_arrow_left),
                contentDescription = "Back",
                modifier = Modifier.size(28.dp)
            )
            Image(
                painter = painterResource(Res.drawable.ic_search),
                contentDescription = "Search",
                modifier = Modifier.size(20.dp)
            )
        }

        Spacer(Modifier.height(12.dp))

        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.Top) {
            Image(
                painter = painterResource(Res.drawable.img_hero_burger),
                contentDescription = null,
                modifier = Modifier.width(217.dp).height(297.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Customize Your Burger to Your Tastes. Ultimate Experience",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF3C2F2F)
                )

                Spacer(Modifier.height(16.dp))
                Text("Spicy", fontSize = 14.sp, fontWeight = FontWeight.Medium, color = Color(0xFF3C2F2F))
                Spacer(Modifier.height(8.dp))
                Image(
                    painter = painterResource(Res.drawable.slider_track),
                    contentDescription = null,
                    modifier = Modifier
                        .height(14.dp)
                        .fillMaxWidth(0.6f),
                    contentScale = ContentScale.FillWidth
                )
                Spacer(Modifier.height(6.dp))
                Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                    Text("Mild", fontSize = 12.sp, fontWeight = FontWeight.Medium, color = Color(0xFF1CC019))
                    Text("Hot", fontSize = 12.sp, fontWeight = FontWeight.Medium, color = Color(0xFFEF2A39))
                }

                Spacer(Modifier.height(20.dp))
                Text("Portion", fontSize = 14.sp, fontWeight = FontWeight.Medium, color = Color(0xFF3C2F2F))
                Spacer(Modifier.height(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(Res.drawable.ic_minus_small),
                        contentDescription = "Decrease",
                        modifier = Modifier
                            .size(40.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .clickable { if (portions > 1) portions -= 1 }
                    )
                    Spacer(Modifier.width(16.dp))
                    Text(portions.toString(), fontSize = 18.sp, color = Color(0xFF3C2F2F))
                    Spacer(Modifier.width(16.dp))
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color(0xFFEF2A39))
                            .clickable { portions += 1 },
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(Res.drawable.ic_plus_small),
                            contentDescription = "Increase",
                            modifier = Modifier.size(10.dp)
                        )
                    }
                }
            }
        }

        Spacer(Modifier.height(24.dp))

        Text("Toppings", fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF3C2F2F))
        Spacer(Modifier.height(12.dp))
        ToppingsRow(items = listOf(
            Res.drawable.img_tomato to "Tomato",
            Res.drawable.img_onions to "Onions",
            Res.drawable.img_pickles to "Pickles",
            Res.drawable.img_bacon to "Bacons",
            Res.drawable.img_cheese to "Cheese",
            Res.drawable.img_mushroom to "Mushroom"
        ))

        Spacer(Modifier.height(16.dp))
        Text("Side options", fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF3C2F2F))
        Spacer(Modifier.height(12.dp))
        ToppingsRow(items = listOf(
            Res.drawable.img_fries to "Fries",
            Res.drawable.img_coleslaw to "Coleslaw",
            Res.drawable.img_salad to "Salad",
            Res.drawable.img_mozzarella to "Mozzarella"
        ))

        Spacer(Modifier.height(24.dp))
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            Column {
                Text("Total", fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF3C2F2F))
                Row(verticalAlignment = Alignment.Bottom) {
                    Text("$", fontSize = 24.sp, color = Color(0xFFEF2A39))
                    Spacer(Modifier.width(4.dp))
                    Text("16.49", fontSize = 36.sp, color = Color(0xFF3C2F2F), fontWeight = FontWeight.SemiBold)
                }
            }
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color(0xFFEF2A39))
                    .height(70.dp)
                    .width(200.dp),
                contentAlignment = Alignment.Center
            ) {
                Text("ORDER NOW", fontSize = 18.sp, color = Color.White, fontWeight = FontWeight.SemiBold)
            }
        }
    }
}

@Preview
@Composable
fun ProductScreenPreview() {
    ProductScreen(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    )
}

@Composable
private fun ToppingsRow(
    items: List<Pair<DrawableResource, String>>,
    modifier: Modifier = Modifier
) {
    val selectedStates = remember(items) { mutableStateListOf<Boolean>().apply { repeat(items.size) { add(false) } } }
    val scrollState = rememberScrollState()
    Row(
        horizontalArrangement = Arrangement.spacedBy(30.dp),
        modifier = modifier.horizontalScroll(scrollState),
    ) {
        items.forEachIndexed { index, (imageRes, label) ->
            val selected = selectedStates[index]
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Box(
                    modifier = Modifier
                        .size(84.dp)
                        .shadow(6.dp, RoundedCornerShape(15.dp))
                        .clip(RoundedCornerShape(15.dp))
                        .background(Color.White)
                        .clickable { selectedStates[index] = !selected },
                    contentAlignment = Alignment.Center
                ) {
                    // faux brown back layer
                    Box(
                        modifier = Modifier
                            .matchParentSize()
                            .padding(top = 47.dp)
                            .clip(RoundedCornerShape(15.dp))
                            .background(Color(0xFF3C2F2F))
                    )
                    Image(
                        painter = painterResource(imageRes),
                        contentDescription = label,
                        modifier = Modifier.size(60.dp),
                        contentScale = ContentScale.Fit
                    )
                    if (selected) {
                        Image(
                            painter = painterResource(Res.drawable.ic_check_circle),
                            contentDescription = null,
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .padding(6.dp)
                                .size(16.dp)
                        )
                    }
                }
                Spacer(Modifier.height(6.dp))
                Text(
                    label,
                    fontSize = 12.sp,
                    color = if (selected) Color.White else Color(0xFF3C2F2F),
                    modifier = Modifier
                        .clip(RoundedCornerShape(4.dp))
                        .background(if (selected) Color(0xFF3C2F2F) else Color.Transparent)
                        .padding(horizontal = 8.dp, vertical = 2.dp)
                )
            }
        }
    }
}


