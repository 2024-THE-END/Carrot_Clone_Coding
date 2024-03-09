package the.end2024.carrotclone.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import the.end2024.carrotclone.presentation.nav.NavigationManager
import the.end2024.carrotclone.presentation.theme.CarrotCloneTheme
import the.end2024.carrotclone.presentation.theme.gMarket_light

class setLocationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CarrotCloneTheme {
                searchLocation()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun searchLocation() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            upSearchBar()
            currentLocation()
        }
    }
}

@Composable
fun currentLocation() {
    Box(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()

    ){
        Button(
            onClick = {
                NavigationManager.navController.navigate("login")
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFE78111),
            ),
            shape = RoundedCornerShape(12.dp),
        ) {
            Text(
                text = "현재위치로 찾기",
                fontSize = 16.sp,
                fontFamily = gMarket_light,
                color = Color.White
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun upSearchBar() {
    var mylocation by remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(){
            //뒤로 가기 버튼 추가
            val backDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher
            IconButton(
                onClick = {
                    // 이미지 버튼을 클릭했을 때의 동작
                    backDispatcher?.onBackPressed()
                },

            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back",
                    modifier = Modifier.fillMaxWidth()
                )
            }

            TextField(
                modifier = Modifier.fillMaxWidth().padding(0.dp),
                value = mylocation,
                onValueChange = {
                    mylocation = it
                },
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    containerColor = Color.White
                ),
                label = {
                    Row(){
                        Icon(
                            painter = painterResource(org.koin.android.R.drawable.abc_ic_search_api_material),
                            contentDescription = null
                        )

                        Text("동명(읍,면)으로 검색 (ex.서초동)")
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    CarrotCloneTheme {
    }
}