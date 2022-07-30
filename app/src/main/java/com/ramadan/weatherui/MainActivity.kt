package com.ramadan.weatherui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramadan.weatherui.ui.theme.DarkBlue
import com.ramadan.weatherui.ui.theme.LightGray
import com.ramadan.weatherui.ui.theme.VeryLightGray
import com.ramadan.weatherui.ui.theme.WeatherUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherUITheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                        .verticalScroll(
                        state = rememberScrollState()
                    ),
                    color = MaterialTheme.colors.background
                ) {
                    WeatherPage()
                }
            }
        }
    }
}

@Composable
fun WeatherPage() {
    Column (modifier = Modifier
        .fillMaxWidth()
        .padding(top = 40.dp, start = 16.dp, end = 16.dp),
    horizontalAlignment = Alignment.CenterHorizontally){
        HeaderImage()
        InfoSection()
        WeatherStatus()
    }

}

@Composable
fun WeatherStatus() {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .background(VeryLightGray)
            .clip(RoundedCornerShape(4.dp))
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)) {
            InfoItem(R.drawable.ic_humadity, "Humidity", "85%" , modifier = Modifier.weight(1f))
            InfoItem(R.drawable.ic_sun, "UV Index", "2 of 10",  modifier = Modifier.weight(1f))
        }
        Divider(color = LightGray , modifier = Modifier.padding(horizontal = 16.dp))
        Row(modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp)) {
            InfoItem(R.drawable.ic_half_sun, "Sunrise", "7:03 AM",  modifier = Modifier.weight(1f))
            InfoItem(R.drawable.ic_half_sun, "Sunset", "4:28 PM",  modifier = Modifier.weight(1f))
        }
    }
}

@Composable
fun InfoItem(@DrawableRes icon: Int, title: String, subTitle: String, modifier: Modifier) {
    Row(modifier = modifier) {
      Image(painter = painterResource(id = icon), contentDescription =  null , modifier = Modifier
          .width(40.dp)
          .padding(8.dp))
        Column {
            Text(text = title , color = Color.Gray)
            Text(text = subTitle , fontWeight = FontWeight.Bold , color = DarkBlue)
        }
    }
}

@Composable
fun InfoSection() {
    Column(modifier = Modifier.padding(top = 20.dp),
    horizontalAlignment = Alignment.CenterHorizontally) {
     Text(text = "11°" , fontSize = 48.sp , color = DarkBlue , fontWeight = FontWeight.Bold)
     Text(text = "New York City , NY" ,  fontSize = 20.sp , color = DarkBlue , fontWeight = FontWeight.Medium)
     Text(text = "Rainy to partly cloud.\n Winds WSW t 10 to 15 km/h" , fontSize = 16.sp , color = Color.Gray ,
         textAlign = TextAlign.Center,
         modifier = Modifier.padding(top = 24.dp)
     )
    }
}

@Composable
fun HeaderImage() {
   Image(painter = painterResource(id = R.drawable.ic_couple),
       contentDescription = null,
   modifier = Modifier.width(200.dp))
}

@Preview(showBackground = true , widthDp = 400 ,  heightDp = 800)
@Composable
fun DefaultPreview() {
    WeatherUITheme {
        WeatherPage()
    }
}