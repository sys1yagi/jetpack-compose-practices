package com.sys1yagi.jetpack_compose_practices.page.practicelist

import android.widget.Toast
import androidx.compose.Composable
import androidx.ui.core.ContextAmbient
import androidx.ui.core.Text
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.Column
import androidx.ui.layout.LayoutHeight
import androidx.ui.layout.LayoutPadding
import androidx.ui.material.MaterialTheme
import androidx.ui.material.TopAppBar
import androidx.ui.res.stringResource
import androidx.ui.unit.dp
import com.sys1yagi.jetpack_compose_practices.MainRoute
import com.sys1yagi.jetpack_compose_practices.R
import com.sys1yagi.jetpack_compose_practices.component.MenuCard

@Composable
fun PracticeListPage(onClick: (MainRoute) -> Unit) {
    val context = ContextAmbient.current
    val notYetImplemented =
            { Toast.makeText(context, "not yet implemented.", Toast.LENGTH_SHORT).show() }
    VerticalScroller {
        Column(modifier = LayoutPadding(top = 8.dp, bottom = 8.dp)) {
            MenuCard("Clickable Card") {
                onClick(MainRoute.ClickableCard)
            }
            MenuCard(
                    "Dialog",
                    notYetImplemented
            )
            MenuCard(
                    "Popup",
                    notYetImplemented
            )
            MenuCard(
                    "AdapterList",
                    notYetImplemented
            )
        }
    }
}