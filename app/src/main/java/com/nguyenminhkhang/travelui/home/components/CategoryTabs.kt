package com.nguyenminhkhang.travelui.home.components

import android.view.RoundedCorner
import androidx.annotation.ColorRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nguyenminhkhang.travelui.ui.theme.RadiusXS
import com.nguyenminhkhang.travelui.ui.theme.SpaceM
import com.nguyenminhkhang.travelui.R
import com.nguyenminhkhang.travelui.ui.theme.SpaceL
import com.nguyenminhkhang.travelui.ui.theme.SpaceS
import com.nguyenminhkhang.travelui.ui.theme.SpaceXL

data class CategoryUiState(
    val title: String,
    val isSelected: Boolean,
)

private val sampleCategories = listOf(
    CategoryUiState("Most viewed", true),
    CategoryUiState("Nearby", false),
    CategoryUiState("Lastest", false),
)

@Composable
fun CategoryTabs() {
    Box(
        modifier = Modifier.fillMaxSize().background(Color.White).padding(SpaceM)

    ) {
        LazyRow {
            items(sampleCategories.size) {index ->
                CategoryItem(
                    modifier = Modifier
                        .padding(start = if (index == 0) 0.dp else SpaceXL, end = if (index == sampleCategories.size - 1) SpaceM else 0.dp),
                    uiState = sampleCategories[index]
                )
            }
        }
    }

}

@Composable
fun CategoryItem(modifier: Modifier, uiState: CategoryUiState) {
    Box(
        modifier = modifier.background(if (uiState.isSelected) Color.Black else Color(0xFFFBFBFB), shape = RoundedCornerShape(SpaceL)).padding(SpaceL)
    ) {
        Text(
            text = uiState.title,
            color = if (uiState.isSelected) Color.White else Color(0xFFC5C5C5),
            style = MaterialTheme.typography.labelLarge.copy(
                fontFamily = FontFamily(Font(R.font.roboto_medium))
            ),
        )
    }
}
