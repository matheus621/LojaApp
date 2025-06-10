package com.example.lojaapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.lojaapp.domain.model.Product

@Composable
fun ProductCard(product: Product, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .clickable { onClick() }
            .background(Color.White, shape = RoundedCornerShape(16.dp))
            .border(0.5.dp, Color.Transparent, shape = RoundedCornerShape(16.dp))
            .padding(6.dp)
            .fillMaxWidth()
    ) {
        AsyncImage(
            model = product.imageUrl,
            contentDescription = product.name,
            modifier = Modifier
                .height(240.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(8.dp))
        Text(
            product.name,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Black,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            product.price,
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
            color = Color.Black
        )
    }

}