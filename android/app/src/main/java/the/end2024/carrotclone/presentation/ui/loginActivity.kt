package the.end2024.carrotclone.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.koin.android.R
import the.end2024.carrotclone.presentation.nav.NavigationManager
import the.end2024.carrotclone.presentation.theme.CarrotCloneTheme
import the.end2024.carrotclone.presentation.theme.gMarket_light
import the.end2024.carrotclone.presentation.theme.gMarket_medium

class loginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CarrotCloneTheme {

            }
        }
    }
}

@Composable
fun loginPage() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            upBar()
            inputInfo()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun inputInfo() {
    var id by remember {
        mutableStateOf("")
    }

    var pw by remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier
            .padding(24.dp)
    ){
        Column {
            TextField(
                value = id,
                onValueChange = {
                    id = it
                },
                Modifier
                    .border(
                        BorderStroke(1.dp, Color.Black),
                        shape = RoundedCornerShape(15)
                    )
                    .fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    containerColor = Color.White
                ),
                label = {
                    Text(text = "아이디 입력")
                }
            )

            Spacer(modifier = Modifier.padding(4.dp))

            TextField(
                value = pw,
                onValueChange = {
                    id = pw
                },
                Modifier
                    .border(
                        BorderStroke(1.dp, Color.Black),
                        shape = RoundedCornerShape(15)
                    )
                    .fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    containerColor = Color.White
                ),
                label = {
                    Text(text = "비밀번호 입력")
                }
            )

            Spacer(modifier = Modifier.padding(4.dp))

            Box(
                modifier = Modifier.fillMaxWidth()
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
                        text = "로그인",
                        fontSize = 16.sp,
                        fontFamily = gMarket_medium,
                        color = Color.White
                    )
                }
            }


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = "회원가입",
                    fontFamily = gMarket_light,
                    modifier = Modifier
                        .clickable(onClick = {
                            NavigationManager.navController.navigate("signUp")
                        })
                        .padding(16.dp),
                    color = Color.Black // 버튼 텍스트 색상
                )
            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun upBar() {
    var mylocation by remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ){
            val backDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher
            IconButton(
                onClick = {
                    backDispatcher?.onBackPressed()
                },

                ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back",
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Spacer(modifier = Modifier.width(80.dp))

            Text(
                text = "로그인/가입",
                fontFamily = gMarket_medium,
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    CarrotCloneTheme {
        loginPage()
    }
}