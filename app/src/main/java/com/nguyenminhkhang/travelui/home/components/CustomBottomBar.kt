package com.nguyenminhkhang.travelui.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nguyenminhkhang.travelui.R
import com.nguyenminhkhang.travelui.ui.theme.FontSizeL
import com.nguyenminhkhang.travelui.ui.theme.IconSizeL
import com.nguyenminhkhang.travelui.ui.theme.RadiusXL
import com.nguyenminhkhang.travelui.ui.theme.RadiusXXL
import com.nguyenminhkhang.travelui.ui.theme.RadiusXXXL
import com.nguyenminhkhang.travelui.ui.theme.SpaceL
import com.nguyenminhkhang.travelui.ui.theme.SpaceXS

@Composable
fun CustomBottomBar() {
    NavigationBar(
        containerColor = Color.White,
        modifier = Modifier.fillMaxWidth()
    ) {
        NavigationBarItem(
            selected = true,
            onClick = {  },
            icon = { Icon(
                painter = painterResource(R.drawable.ic_home),
                contentDescription = "Home",
            ) },
        )
        NavigationBarItem(
            selected = false,
            onClick = {  },
            icon = { Icon(
                painter = painterResource(R.drawable.ic_clock),
                contentDescription = "Home",
            ) },
        )
        NavigationBarItem(
            selected = false,
            onClick = {  },
            icon = { Icon(
                painter = painterResource(R.drawable.ic_heart_navbar),
                contentDescription = "Home",
            ) },
        )
        NavigationBarItem(
            selected = false,
            onClick = {  },
            icon = { Icon(
                painter = painterResource(R.drawable.ic_user),
                contentDescription = "Home",
            ) },
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomSearchBar(modifier: Modifier) {
    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        placeholder = {
            Text(
                text = "Search places",
                color = Color(0xFFC4C4C4),
                fontSize = FontSizeL,
                fontFamily = FontFamily(Font(R.font.roboto_medium))
            )
        },
        trailingIcon = {
            Icon(
                painter = painterResource(R.drawable.ic_setting),
                contentDescription = null,
                tint = Color(0xFF888888),
                modifier = Modifier.size(IconSizeL)
            )
        },
        shape = RoundedCornerShape(RadiusXL),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color(0xFFD2D2D2),
            unfocusedBorderColor = Color(0xFFD2D2D2),
            disabledBorderColor = Color(0xFFD2D2D2),
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            cursorColor = Color.Black
        ),
        modifier = modifier.padding()
            .background(
                Color.White, shape = RoundedCornerShape(
                    RadiusXL
                )
            )
            .border(
                width = 2.dp,
                color = Color(0xFFD2D2D2),
                shape = androidx.compose.foundation.shape.RoundedCornerShape(RadiusXL)
            ),
    )
}