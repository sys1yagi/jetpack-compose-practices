package com.sys1yagi.jetpack_compose_practices.page.clickablecard

import android.widget.Toast
import androidx.compose.Composable
import androidx.ui.core.ContextAmbient
import androidx.ui.core.Text
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.painter.ImagePainter
import androidx.ui.graphics.painter.Painter
import androidx.ui.layout.Column
import androidx.ui.layout.LayoutHeight
import androidx.ui.layout.LayoutPadding
import androidx.ui.layout.LayoutWidth
import androidx.ui.material.AppBarIcon
import androidx.ui.material.MaterialTheme
import androidx.ui.material.TopAppBar
import androidx.ui.material.ripple.Ripple
import androidx.ui.material.surface.Card
import androidx.ui.res.imageResource
import androidx.ui.res.stringResource
import androidx.ui.res.vectorResource
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.github.zsoltk.compose.backpress.AmbientBackPressHandler
import com.sys1yagi.jetpack_compose_practices.R

@Preview
@Composable
fun ClickableCardPage() {
    val context = ContextAmbient.current
    Ripple(bounded = true) {
        Clickable(onClick = {
            Toast.makeText(context, "click!", Toast.LENGTH_SHORT).show()
        }) {
            Card(
                    modifier = LayoutPadding(
                            left = 16.dp,
                            right = 16.dp,
                            top = 16.dp,
                            bottom = 16.dp
                    ) + LayoutWidth.Fill,
                    shape = RoundedCornerShape(4.dp),
                    elevation = 4.dp
            ) {
                Text(
                        "Clickable!",
                        modifier = LayoutPadding(16.dp)
                )
            }
        }
    }
}