package the.end2024.carrotclone.presentation.ui

import android.os.Bundle
import android.provider.CalendarContract.Colors
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import the.end2024.carrotclone.R
import the.end2024.carrotclone.presentation.theme.CarrotCloneTheme

class mainPageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CarrotCloneTheme {

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun mainPage(){
    Scaffold(
        topBar = { MyTopBar() },
        floatingActionButton = { MyFloatingActionButton() },
        bottomBar = {MyBottomBar() }
    ) { paddingValues ->
        Surface(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues))
        {
            Column(modifier = Modifier.fillMaxSize()) {
                // Column 내용
                Divider(color = Color.Gray, thickness = 0.5.dp)

                Card() {
                    Row(
                        modifier = Modifier
                            .background(Color.White)
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // 왼쪽에 그림
                        Image(
                            painter = painterResource(id = R.drawable.icon_carrot),
                            contentDescription = null,
                            modifier = Modifier.size(80.dp),
                            contentScale = ContentScale.Crop
                        )

                        // 오른쪽에 제목, 설명, 가격
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .padding(horizontal = 16.dp)
                        ) {
                            Text(text = "의자팜")
                            Text(text = "섡제요")
                            Text(text = "30000")
                        }

                        // 오른쪽 끝에 아이콘
                        IconButton(
                            onClick = { /* 아이콘 클릭 시 동작 */ },
                            modifier = Modifier.align(Alignment.Bottom)
                        ) {
                            Icon(Icons.Filled.MailOutline, contentDescription = null)
                        }
                    }
                }

                Divider(color = Color.Gray, thickness = 0.5.dp)
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar(){
    TopAppBar(
        title = {
            Text(text = "역삼동")
        },
        actions = {
            Row() {
                IconButton(
                    onClick = { /* 검색 아이콘 클릭 시 동작 */ }) {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
                }

                IconButton(onClick = { /* 카테고리 아이콘 클릭 시 동작 */ }) {
                    Icon(imageVector = Icons.Default.Build, contentDescription = "Category")
                }

                IconButton(onClick = { /* 알림 아이콘 클릭 시 동작 */ }) {
                    Icon(imageVector = Icons.Default.Notifications, contentDescription = "Notifications")
                }
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(Color.White)
    )

}

@Composable
fun MyFloatingActionButton() {
    FloatingActionButton(
        onClick = {

        },
        modifier = Modifier.background(color = Color.White)
    ) {
        Icon(
            Icons.Default.Add,
            contentDescription = "Menu",
            tint = Color(0xFFE78111)
        )
    }


}

@Composable
fun MyBottomBar(){
    BottomAppBar(
        containerColor = Color.White
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            //horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = {

                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White
                    ),
                ) {
                    Icon(Icons.Default.Home, contentDescription = "home",tint = Color.Black)
                }
                Text(
                    text = "홈",
                    color = Color.Black
                )
            }

            Spacer(modifier = Modifier.width(8.dp)) // 공간 추가

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = {

                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White
                    ),
                ) {
                    Icon(Icons.Default.MailOutline, contentDescription = "Settings",tint = Color.Black)
                }
                Text(
                    text = "채팅",
                    color = Color.Black
                )
            }

            Spacer(modifier = Modifier.width(8.dp)) // 공간 추가

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = {

                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White
                    ),
                )  {
                    Icon(Icons.Default.Person, contentDescription = "Favorite",tint = Color.Black)
                }
                Text(
                    text = "나의 당근",
                    color = Color.Black
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview5() {
    CarrotCloneTheme {
        mainPage()
    }
}