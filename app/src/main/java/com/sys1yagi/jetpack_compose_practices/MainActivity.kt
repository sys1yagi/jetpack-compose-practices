package com.sys1yagi.jetpack_compose_practices

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.Providers
import androidx.ui.core.Text
import androidx.ui.core.setContent
import androidx.ui.graphics.painter.ImagePainter
import androidx.ui.layout.Column
import androidx.ui.layout.LayoutHeight
import androidx.ui.material.AppBarIcon
import androidx.ui.material.MaterialTheme
import androidx.ui.material.TopAppBar
import androidx.ui.res.imageResource
import androidx.ui.res.stringResource
import androidx.ui.unit.dp
import com.github.zsoltk.compose.backpress.AmbientBackPressHandler
import com.github.zsoltk.compose.backpress.BackPressHandler
import com.github.zsoltk.compose.router.Router
import com.sys1yagi.jetpack_compose_practices.page.clickablecard.ClickableCardPage
import com.sys1yagi.jetpack_compose_practices.page.practicelist.PracticeListPage

class MainActivity : AppCompatActivity() {
    private val backPressHandler = BackPressHandler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Providers(
                    AmbientBackPressHandler provides backPressHandler
            ) {
                MainPage()
            }
        }
    }

    override fun onBackPressed() {
        println(backPressHandler)
        if (!backPressHandler.handle()) {
            super.onBackPressed()
        }
    }
}

sealed class MainRoute {
    object PracticeList : MainRoute()
    object ClickableCard : MainRoute()
}

@Composable
fun MainPage() {
    val rootBackPressHandler = AmbientBackPressHandler.current
    MaterialTheme {
        Column(
                modifier = LayoutHeight.Fill
        ) {
            Router<MainRoute>(defaultRouting = MainRoute.PracticeList) { backStack ->
                val routing = backStack.last()
                TopAppBar(
                        title = { Text(stringResource(id = R.string.app_name)) },
                        elevation = 2.dp,
                        navigationIcon = backButtonOrNull(routing, rootBackPressHandler)
                )
                when (routing) {
                    is MainRoute.PracticeList -> {
                        PracticeListPage { route ->
                            backStack.push(route)
                        }
                    }
                    is MainRoute.ClickableCard -> {
                        ClickableCardPage()
                    }
                }
            }
        }
    }
}

fun backButtonOrNull(routing: MainRoute, rootBackPressHandler: BackPressHandler): (@Composable() () -> Unit)? {
    return when (routing) {
        is MainRoute.PracticeList -> null
        else -> {
            {
                AppBarIcon(icon = ImagePainter(imageResource(id = R.drawable.ic_action_back)), onClick = {
                    rootBackPressHandler.handle()
                })
            }
        }
    }
}