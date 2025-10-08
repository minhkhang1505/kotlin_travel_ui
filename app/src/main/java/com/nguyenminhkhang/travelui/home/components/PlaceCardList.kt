package com.nguyenminhkhang.travelui.home.components

import android.R.attr.shape
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nguyenminhkhang.travelui.R
import com.nguyenminhkhang.travelui.ui.theme.FontSizeL
import com.nguyenminhkhang.travelui.ui.theme.FontSizeM
import com.nguyenminhkhang.travelui.ui.theme.FontSizeS
import com.nguyenminhkhang.travelui.ui.theme.IconSizeXL
import com.nguyenminhkhang.travelui.ui.theme.IconSizeXS
import com.nguyenminhkhang.travelui.ui.theme.IconSizeXXS
import com.nguyenminhkhang.travelui.ui.theme.RadiusSmall
import com.nguyenminhkhang.travelui.ui.theme.RadiusXL
import com.nguyenminhkhang.travelui.ui.theme.RadiusXXXL
import com.nguyenminhkhang.travelui.ui.theme.SpaceL
import com.nguyenminhkhang.travelui.ui.theme.SpaceM
import com.nguyenminhkhang.travelui.ui.theme.SpaceS
import com.nguyenminhkhang.travelui.ui.theme.SpaceXL
import com.nguyenminhkhang.travelui.ui.theme.SpaceXS
import com.nguyenminhkhang.travelui.ui.theme.SpaceXXS
import com.nguyenminhkhang.travelui.ui.theme.SpaceXXXS

data class PlaceCardUiState(
    val imageUrl: String,
    val placeName: String,
    val cityName: String,
    val countryName: String,
    val price: String,
    val rating: Float,
)

@Composable
fun PlaceCardList() {

}

@Composable
fun PlaceCardItem( modifier: Modifier, uiState: PlaceCardUiState) {
    Box(
        modifier = modifier
            .clip(
                shape = RoundedCornerShape(RadiusXXXL)
            )
    ) {
        Image(
            painter = painterResource(R.drawable.image_1),
            contentDescription = uiState.placeName,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(
                    shape = RoundedCornerShape(RadiusXXXL)
                )
        )
        Box(
            modifier = Modifier.fillMaxWidth().padding(SpaceM),
            contentAlignment = Alignment.TopEnd
        ) {
            HeartIcon(Modifier.size(IconSizeXL))
        }
        Box(
            modifier = Modifier.fillMaxSize().padding(bottom = SpaceXL),
            contentAlignment = Alignment.BottomCenter
        ) {
            PlaceTag(
                modifier = Modifier
                    .width(224.dp).height(75.dp),
                uiState = uiState
            )
        }
    }
}

@Composable
fun HeartIcon(modifier: Modifier) {
    Box(
        modifier.background(Color(0xFF1D1D1D).copy(alpha = 0.6f), shape = CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_heart),
            contentDescription = "Heart Icon",
            tint = Color.White,
        )
    }
}

@Composable
fun PlaceTag(modifier : Modifier, uiState: PlaceCardUiState) {
    Box(
        modifier = modifier
            .background(Color(0xFF1D1D1D).copy(alpha = 0.6f), shape = RoundedCornerShape(SpaceM))
            .padding(SpaceS),
        contentAlignment = Alignment.Center
    ) {
        Column{
            Row{
                Text(
                    text = uiState.placeName,
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = Color.White,
                        fontSize = FontSizeL,
                        fontFamily = FontFamily(Font(R.font.roboto_medium))
                    )
                )
                Text(
                    text =", ${uiState.cityName}",
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = Color(0xFFCAC8C8),
                        fontSize = FontSizeM,
                        fontFamily = FontFamily(Font(R.font.roboto_medium))
                    )
                )
            }
            Spacer(modifier = Modifier.height(SpaceXXS))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_location),
                    contentDescription = "Location Icon",
                    tint = Color(0xFFCAC8C8),
                    modifier = Modifier.size(IconSizeXS)
                )
                Text(
                    text = " ${uiState.cityName}, ${uiState.countryName} ",
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontFamily = FontFamily(Font(R.font.roboto)),
                        color = Color(0xFFCAC8C8),
                        fontSize = FontSizeM
                    )
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    painter = painterResource(R.drawable.ic_star),
                    contentDescription = "Star Icon",
                    tint = Color(0xFFCAC8C8),
                    modifier = Modifier.size(IconSizeXS)
                )
                Spacer(modifier = Modifier.width(SpaceXXS))
                Text(
                    text = "${uiState.rating}",
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontFamily = FontFamily(Font(R.font.roboto)),
                        color = Color(0xFFCAC8C8),
                        fontSize = FontSizeL
                    )
                )
            }
        }
    }
}

@Preview
@Composable
fun PlaceCardItemPreview() {
    PlaceCardItem(
        modifier = Modifier.width(270.dp).height(405.dp),
        uiState = PlaceCardUiState(
            imageUrl = "",
            placeName = "Mount Fuji",
            cityName = "Tokyo",
            countryName = "Japan",
            price = "$100",
            rating = 4.8f
        )
    )
}