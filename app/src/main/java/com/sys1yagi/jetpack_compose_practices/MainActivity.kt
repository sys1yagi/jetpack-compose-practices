package com.sys1yagi.jetpack_compose_practices

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.core.setContent
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.VerticalScroller
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.layout.Column
import androidx.ui.layout.LayoutHeight
import androidx.ui.layout.LayoutPadding
import androidx.ui.layout.LayoutWidth
import androidx.ui.material.AppBarIcon
import androidx.ui.material.MaterialTheme
import androidx.ui.material.TopAppBar
import androidx.ui.material.ripple.Ripple
import androidx.ui.material.surface.Card
import androidx.ui.res.stringResource
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainPage()
        }
    }
}

@Preview
@Composable
fun MainPage() {
    MaterialTheme {
        Column(
                modifier = LayoutHeight.Fill
        ) {
            TopAppBar(
                    title = { Text(stringResource(id = R.string.app_name)) },
                    elevation = 2.dp
            )
            PracticeList()
        }
    }
}
fun PracticeList() {
    VerticalScroller {
        Column {
            Ripple(bounded = true) {
                Clickable(onClick = {}) {
                    Card(
                            modifier = LayoutPadding(16.dp) + LayoutWidth.Fill,
                            shape = RoundedCornerShape(4.dp),
                            elevation = 4.dp
                    ) {
                        Text("Clickable Card",
                                modifier = LayoutPadding(16.dp)
                        )
                    }
                }
            }
        }
    }
}
