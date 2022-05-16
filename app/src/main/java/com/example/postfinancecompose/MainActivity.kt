package com.example.postfinancecompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.postfinancecompose.payment.presentation.PaymentsScreen
import com.example.postfinancecompose.ui.theme.PostfinanceComposeTheme
import com.plcoding.calorytracker.navigation.Route
import dagger.hilt.android.AndroidEntryPoint

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PostfinanceComposeTheme {
                val navController = rememberNavController()
                val scaffoldState = rememberScaffoldState()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    scaffoldState = scaffoldState
                ) {  _ ->
                    NavHost(
                        navController = navController,
                        startDestination = Route.PAYMENTS
                    ) {
                        composable(Route.PAYMENTS) {
                            PaymentsScreen(scaffoldState = scaffoldState)
                        }
                    }
                }
            }
        }
    }
}

