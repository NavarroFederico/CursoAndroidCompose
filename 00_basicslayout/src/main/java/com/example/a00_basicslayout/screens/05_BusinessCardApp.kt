package com.example.a00_basicslayout.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a00_basicslayout.R
import com.example.a00_basicslayout.ui.theme.CursoAndroidComposeTheme

@Composable
fun BusinessCardApp(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        InfoProfile(modifier = Modifier.align(Alignment.Center))
        InfoContact(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 24.dp)
        )
    }
}


@Composable
private fun InfoProfile(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(horizontal = 8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.imagen_de_perfil_navarro_federico),
            contentDescription = "Foto de perfil por defecto",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape),
        )
        Text(
            text = "Navarro Federico",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = "Android Developer ",
            style = MaterialTheme.typography.titleMedium,
            color = Color(0xFF3ddc84)
        )
    }

}

@Composable
fun InfoContact(modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()

    val typeIcon = Icons.Rounded
    val iconCall = typeIcon.Call
    val iconShare = typeIcon.Share
    val iconEmail = typeIcon.Email
    val tintColor = Color
    val urlGithub = "https://github.com/NavarroFederico"

    Column(
        modifier = modifier.verticalScroll(scrollState),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Item(icon = iconCall, info = "+54 (11)23823504", contentDescription = "phone cel")
        Item(icon = iconShare, info = "@navarrofede", contentDescription = "share")
        Item(
            icon = iconEmail,
            info = "navarrofederico14@gmail.com",
            contentDescription = "email"
        )
    }

}

@Composable
fun Item(
    icon: Any,
    info: String,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
) {

    Row() {
        Icon(
            imageVector = icon as ImageVector,
            contentDescription = contentDescription,
            tint = Color(0xFF3ddc84)
        )
        Spacer(modifier = modifier.size(8.dp))
        Text(text = info)
    }

}/*  @Composable
      fun InfoContact(modifier: Modifier = Modifier) {
          var scrollState = rememberScrollState()

          val typeIcon = Icons.Rounded
          val iconCall = typeIcon.Call
          val iconShare = typeIcon.Share
          val iconGitHub = painterResource(id = R.drawable.icon_github)
          val iconEmail = typeIcon.Email

          val urlGithub = "https://github.com/NavarroFederico"

          Column(Modifier.verticalScroll(scrollState)) {
              Item(iconCall, "+54 (11)23823504")
              Item(iconGitHub, "My GitHub")
              Item(iconShare,"@navarrofede")
              Item(icon = iconEmail, info ="" )
          }

      }

      @Composable
      fun Item(icon: Any, info: String, modifier: Modifier = Modifier) {
          var scrollState = rememberScrollState()
          val uriHandler = LocalUriHandler.current

          Row (modifier.horizontalScroll(scrollState)){

              when (icon) {
                  is ImageVector -> {
                      Icon(icon, contentDescription = null)
                      Spacer(Modifier.size(16.dp))
                      Text(text = info)
                  }

                  is Painter -> {
                      Icon(painter = icon, contentDescription = null, modifier = Modifier.size(28.dp))
                      Spacer(Modifier.size(16.dp))
                      ClickableText(
                          text = AnnotatedString(info),
                          onClick = { uriHandler.openUri("https://github.com/NavarroFederico") })
                  }
              }
          }

      }*/

/* @Composable
fun Item(icon: Any, info: String, link: String? = null, modifier: Modifier = Modifier) {
   var scrollState = rememberScrollState()
   val uriHandler = LocalUriHandler.current

   Row(modifier.horizontalScroll(scrollState)) {
       if (link != null) {
           Icon(
               imageVector = if (icon is ImageVector) icon else Icons.Default.Email,
               painter = if (icon is Painter) icon else null,
               contentDescription = null,
               modifier = Modifier.size(28.dp).clickable { uriHandler.openUri(link) }
           )
       } else {
           Icon(
               imageVector = if (icon is ImageVector) icon else Icons.Default.Email,
               painter = if (icon is Painter) icon else null,
               contentDescription = null,
               modifier = Modifier.size(28.dp)
           )
       }

       Spacer(Modifier.size(16.dp))
       if (link != null) {
           ClickableText(
               text = AnnotatedString(info),
               onClick = { uriHandler.openUri(link) }
           )
       } else {
           Text(text = info)
       }
   }
}*/

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    CursoAndroidComposeTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFFDCF2DE)) {
            BusinessCardApp(Modifier.fillMaxSize())
        }
    }

}
