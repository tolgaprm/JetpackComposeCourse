package com.prmto.profilecardlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.prmto.profilecardlayout.ui.theme.ProfileCardLayoutTheme
import com.prmto.profilecardlayout.ui.theme.ligthGreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileCardLayoutTheme {
                UserListScreen(userProfileList)
            }
        }
    }
}


@Composable
fun UserListScreen(userProfileList: List<UserProfile>) {

    Scaffold(
        topBar = { AppBar() }
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.LightGray
        ) {
            LazyColumn {
                items(userProfileList) { userProfile ->
                    ProfileCard(userProfile = userProfile)
                }
            }

        }
    }
}


@Composable
fun AppBar() {
    TopAppBar(
        navigationIcon = {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "",
                modifier = Modifier.padding(horizontal = 12.dp)
            )
        },
        title = { Text(text = "Messaging Application Users") },
    )
}

@Composable
fun ProfileCard(userProfile: UserProfile) {
    Card(
        modifier = Modifier
            .padding(top = 8.dp, bottom = 4.dp, start = 16.dp, end = 16.dp)
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.Top)
            .clip(
                RoundedCornerShape(8.dp)
            ),
        elevation = 8.dp,
        backgroundColor = Color.White
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            ProfilePicture(userProfile.pictureUrl, userProfile.status)
            ProfileContent(userProfile.name, userProfile.status, aligment = Alignment.Start)
        }
    }
}

@Composable
fun ProfilePicture(profileUrl: String, onlineStatus: Boolean, imageSize: Dp = 72.dp) {

    val borderColor = if (onlineStatus) MaterialTheme.colors.ligthGreen else Color.Red
    Card(
        shape = CircleShape,
        border = BorderStroke(2.dp, color = borderColor),
        modifier = Modifier.padding(16.dp),
        elevation = 4.dp,

        ) {

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(profileUrl)
                .crossfade(true)
                .build(),
            contentDescription = null,
            modifier = Modifier
                .size(imageSize),
            contentScale = ContentScale.Crop
        )

//        Image(
//            painter = painterResource(id = drawableId),
//            contentDescription = null,
//            modifier = Modifier
//                .size(72.dp),
//            contentScale = ContentScale.Crop
//        )
    }

}

@Composable
fun ProfileContent(name: String, onlineStatus: Boolean, aligment: Alignment.Horizontal) {

    Column(
        modifier = Modifier
            .padding(8.dp),
        horizontalAlignment = aligment
    ) {

        val alpha = if (onlineStatus) 1f else ContentAlpha.medium
        CompositionLocalProvider(LocalContentAlpha provides alpha) {
            Text(
                text = name,
                style = MaterialTheme.typography.h5
            )
        }

        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Text(
                text = if (onlineStatus) "Active Now" else "Offline",
                style = MaterialTheme.typography.body2,

                )
        }


    }
}

@Composable
fun ProfileDetailScreen(userProfile: UserProfile = userProfileList[0]) {

    Scaffold(
        topBar = { AppBar() }
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.LightGray
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                ProfilePicture(userProfile.pictureUrl, userProfile.status, imageSize = 240.dp)
                ProfileContent(
                    userProfile.name,
                    userProfile.status,
                    aligment = Alignment.CenterHorizontally
                )
            }
        }


    }
}


@Preview(showBackground = true)
@Composable
fun UserProfileDetailScreenPreview() {
    ProfileCardLayoutTheme {
        ProfileDetailScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun UserListPreview() {
    ProfileCardLayoutTheme {
        UserListScreen(userProfileList)
    }
}