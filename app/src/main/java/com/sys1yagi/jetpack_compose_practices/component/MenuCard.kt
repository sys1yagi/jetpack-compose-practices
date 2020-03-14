package com.sys1yagi.jetpack_compose_practices.component

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.layout.LayoutPadding
import androidx.ui.layout.LayoutWidth
import androidx.ui.material.ripple.Ripple
import androidx.ui.material.surface.Card
import androidx.ui.unit.dp

@Composable
fun MenuCard(title: String, onClick: () -> Unit) {
    Ripple(bounded = true) {
        Clickable(onClick = onClick) {
            Card(
                modifier = LayoutPadding(
                    left = 16.dp,
                    right = 16.dp,
                    top = 8.dp,
                    bottom = 8.dp
                ) + LayoutWidth.Fill,
                shape = RoundedCornerShape(4.dp),
                elevation = 4.dp
            ) {
                Text(
                    title,
                    modifier = LayoutPadding(16.dp)
                )
            }
        }
    }
}