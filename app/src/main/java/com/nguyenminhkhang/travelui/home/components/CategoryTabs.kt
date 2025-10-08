package com.nguyenminhkhang.travelui.home.components

import android.view.RoundedCorner
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
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
import com.nguyenminhkhang.travelui.ui.theme.RadiusXS
import com.nguyenminhkhang.travelui.ui.theme.SpaceM
import com.nguyenminhkhang.travelui.R
import com.nguyenminhkhang.travelui.ui.theme.SpaceL

data class CategoryUiState(
    val title: String,
    val isSelected: Boolean,
)

@Composable
fun CategoryTabs(modifier : Modifier, uiState: CategoryUiState) {
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

@Preview
@Composable
fun CategoryTabsPreview() {
    Column() {
        CategoryTabs(
            modifier = Modifier,
            uiState = CategoryUiState(
                title = "Recommended",
                isSelected = true
            )
        )
        CategoryTabs(
            modifier = Modifier,
            uiState = CategoryUiState(
                title = "Popular",
                isSelected = false
            )
        )
    }
}