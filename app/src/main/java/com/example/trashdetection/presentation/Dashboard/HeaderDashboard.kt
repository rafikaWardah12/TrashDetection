package com.example.trashdetection.presentation.Dashboard

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.trashdetection.R
import com.example.trashdetection.ui.theme.PrimaryBlue200
import com.example.trashdetection.ui.theme.PrimaryBlue300
import com.example.trashdetection.ui.theme.TextPrimary
import com.example.trashdetection.ui.theme.TrashDetectionTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeaderDashboard(
    modifier: Modifier = Modifier,
    title: String,
    navigateToNotification: () -> Unit,
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(bottomStart = 40.dp, bottomEnd = 40.dp))
            .background(PrimaryBlue300)
            .fillMaxWidth()
            .padding(top = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 1.dp),
        ) {
            Column {
                Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {
                    IconButton(
                        onClick = { navigateToNotification() },
                        colors = IconButtonDefaults.filledIconButtonColors(PrimaryBlue200),
                        modifier = Modifier
                            .size(36.dp)
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_notifications),
                            contentDescription = "Notification",
                            tint = TextPrimary,
                            modifier = Modifier.size(25.dp)
                        )
                    }
                }
                Text(
                    text = title,
                    style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Black),
                    color = TextPrimary,
//                        modifier = Modifier.align(Alignment.Start)
//                        modifier = Modifier.weight(0.1f)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row {
                    Text(text = "Mulai",
                            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Medium),
                            modifier = Modifier
                                .padding(top = 20.dp)
                                .clip(RoundedCornerShape(50))
                                .background(Color.White)
                                .padding(vertical = 5.dp, horizontal = 40.dp)
                            ,color = TextPrimary

                            )
                    Image(
                        painter = painterResource(id = R.drawable.bg_beranda),
                        contentDescription = "Gambar Ilustrasi",
                        modifier = Modifier
                            .weight(0.7f)
                            .size(150.dp)
//
                    )
//                    Spacer(modifier = Modifier.height(20.dp))
                }
            }
        }
    }
}


@Preview
@Composable
private fun TopBarPreview() {
    TrashDetectionTheme {
        HeaderDashboard(
            title = "Solusi untuk Deteksi Objek Sampah. Experience Baru",
            navigateToNotification = {},
        )
    }
}