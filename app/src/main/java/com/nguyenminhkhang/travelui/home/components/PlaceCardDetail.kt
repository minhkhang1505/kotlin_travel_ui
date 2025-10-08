package com.nguyenminhkhang.travelui.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nguyenminhkhang.travelui.R
import com.nguyenminhkhang.travelui.ui.theme.FontSizeL
import com.nguyenminhkhang.travelui.ui.theme.FontSizeM
import com.nguyenminhkhang.travelui.ui.theme.FontSizeXL
import com.nguyenminhkhang.travelui.ui.theme.FontSizeXXL
import com.nguyenminhkhang.travelui.ui.theme.FontSizeXXXL
import com.nguyenminhkhang.travelui.ui.theme.FontSizeXXXXL
import com.nguyenminhkhang.travelui.ui.theme.IconSizeL
import com.nguyenminhkhang.travelui.ui.theme.IconSizeM
import com.nguyenminhkhang.travelui.ui.theme.IconSizeS
import com.nguyenminhkhang.travelui.ui.theme.IconSizeXL
import com.nguyenminhkhang.travelui.ui.theme.IconSizeXS
import com.nguyenminhkhang.travelui.ui.theme.IconSizeXXL
import com.nguyenminhkhang.travelui.ui.theme.RadiusMedium
import com.nguyenminhkhang.travelui.ui.theme.RadiusXL
import com.nguyenminhkhang.travelui.ui.theme.SpaceM
import com.nguyenminhkhang.travelui.ui.theme.SpaceS
import com.nguyenminhkhang.travelui.ui.theme.SpaceXS
import com.nguyenminhkhang.travelui.ui.theme.SpaceXXS

data class PlaceCardDetailUiState(
    val placeName: String,
    val cityName: String,
    val countryName: String,
    val price: Double,
)

data class InfoRowItem(
    val icon: Painter,
    val description: String,
)

@Composable
fun TopBarSection(modifier: Modifier) {
    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        CircleIconButton(modifier = Modifier.size(IconSizeXL), painter = painterResource(R.drawable.ic_arrow_left), contentDescription = "Back Button")
        Spacer(Modifier.weight(1f))
        CircleIconButton(modifier = Modifier.size(IconSizeXL), painter = painterResource(R.drawable.ic_archive), contentDescription = "Favorite Button")
    }
}

@Composable
fun ImageHeaderSection(modifier: Modifier, uiState: PlaceCardDetailUiState) {
    Box(
        modifier = modifier
            .background(Color(0xFF1D1D1D).copy(alpha = 0.6f), shape = RoundedCornerShape(SpaceM))
            .padding(SpaceS),
        contentAlignment = Alignment.Center
    ) {
        Column{
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = uiState.placeName,
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = Color.White,
                        fontSize = FontSizeXXXL,
                        fontFamily = FontFamily(Font(R.font.inter_semibold))
                    )
                )
                Spacer(Modifier.weight(1f))
                Text(
                    text ="Price",
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = Color(0xFFCAC8C8),
                        fontSize = FontSizeL,
                        fontFamily = FontFamily(Font(R.font.roboto))
                    )
                )
            }
            Spacer(modifier = Modifier.height(SpaceXS))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_location),
                    contentDescription = "Location Icon",
                    tint = Color(0xFFCAC8C8),
                    modifier = Modifier.size(IconSizeS)
                )
                Text(
                    text = " ${uiState.cityName}, ${uiState.countryName} ",
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontFamily = FontFamily(Font(R.font.roboto)),
                        color = Color(0xFFCAC8C8),
                        fontSize = FontSizeXL
                    )
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    painter = painterResource(R.drawable.ic_dollar),
                    contentDescription = "Star Icon",
                    tint = Color(0xFF434343),
                    modifier = Modifier.size(IconSizeL)
                )
                Text(
                    text = "${uiState.price}",
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontFamily = FontFamily(Font(R.font.roboto_medium)),
                        color = Color(0xFFCAC8C8),
                        fontSize = FontSizeXXXXL
                    )
                )
            }
        }
    }
}

@Composable
fun InfoIcon(modifier: Modifier, painter: Painter, contentDescription: String) {
    Box(
        modifier = modifier.background(Color(0xFFEDEDED), shape = RoundedCornerShape(RadiusMedium)),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painter,
            contentDescription = contentDescription,
            tint = Color(0xFF3F3F3F),
            modifier = Modifier
                .size(IconSizeXS)
        )
    }
}

@Composable
fun InforItem(itemDes: String, painter: Painter, contentDescription: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        InfoIcon(modifier = Modifier.size(IconSizeXXL), painter = painter, contentDescription = contentDescription)
        Spacer(Modifier.width(SpaceXS))
        Text(
            text = itemDes,
            style = MaterialTheme.typography.bodySmall.copy(
                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                color = Color(0xFF7E7E7E),
                fontSize = FontSizeXL
            )
        )
    }
}

@Composable
fun InfoRow(
    modifier: Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        InforItem(
            itemDes = "8 hour",
            painter = painterResource(R.drawable.ic_clock),
            contentDescription = "Clock Icon"
        )
        InforItem(
            itemDes = "16 C",
            painter = painterResource(R.drawable.ic_cloud),
            contentDescription = "Clock Icon"
        )
        InforItem(
            itemDes = "4.5",
            painter = painterResource(R.drawable.ic_star_black),
            contentDescription = "Clock Icon"
        )
    }
}

@Composable
fun IconButton(modifier: Modifier, title: String, painter: Painter, contentDescription: String, onClick: () -> Unit) {
    Row(
        modifier = modifier.background(Color.Black, shape = RoundedCornerShape(RadiusXL)).clickable {onClick},
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodySmall.copy(
                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                color = Color.White,
                fontSize = FontSizeXXL
            ),
        )
        Spacer(Modifier.width(SpaceXS))
        Icon(
            painter = painter,
            contentDescription = contentDescription,
            tint = Color.White,
        )
    }
}