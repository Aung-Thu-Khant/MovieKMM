package org.example.moviekmm

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.content.MediaType.Companion.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import moviekmm.composeapp.generated.resources.Res
import moviekmm.composeapp.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.jetbrains.compose.ui.tooling.preview.PreviewParameter

private val EMAIL_REGEX = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"

@Composable
fun Login(){
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var navigateToHome by remember { mutableStateOf(false) }

    var emailError by remember { mutableStateOf<String?>(null) }
    var passwordError by remember { mutableStateOf<String?>(null) }

    fun validateEmail(email: String) : Boolean{
        return EMAIL_REGEX.toRegex().matches(email)
    }

    fun validatePassword(password: String) : Boolean{
        return password.length >= 6
    }


    if(navigateToHome){
        HomePage()
    }else{
        Box(
            modifier = Modifier.fillMaxSize()
                .background(Color.White)
        ){
            Column(
                modifier = Modifier.fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(
                    painter = painterResource(Res.drawable.compose_multiplatform),
                    contentDescription = null,
                    modifier = Modifier.padding(top = 24.dp)
                )
                Spacer(modifier = Modifier.height(24.dp))
                OutlinedTextField(
                    value = email,
                    onValueChange = {email = it},
                    label = { Text("Enter your email") },
                    modifier = Modifier.fillMaxWidth(),
                    isError = emailError != null,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                )
                if(emailError != null){
                    Text(
                        text = emailError!!,
                        color = Color.Red,
                        modifier = Modifier.align(Alignment.Start),
                    )
                }
                Spacer(modifier = Modifier.height(24.dp))
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it},
                    label = { Text("Enter your password") },
                    modifier = Modifier.fillMaxWidth(),
                    isError = passwordError != null,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                )
                if(passwordError != null){
                    Text(
                        text = passwordError!!,
                        color = Color.Red,
                        modifier = Modifier.align(Alignment.Start)
                    )
                }
                Spacer(modifier = Modifier.height(24.dp))
                Button(
                    onClick = {
                        if(validateEmail(email) && validatePassword(password)){
                            navigateToHome = true
                        }else{
                            navigateToHome = true
                            //if(!validateEmail(email)){
                                //emailError = "Invalid Email Address"
                            //}
                           // if(!validatePassword(password)){
                               // passwordError = "Password must be at least 6 characters long"
                           // }
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(Color.Blue),
                ){
                    Text(
                        text = "Login",
                        color = Color.White,
                    )
                }
            }
        }
    }


}
