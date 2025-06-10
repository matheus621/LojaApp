import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.lojaapp.domain.model.Product

@Composable
fun ProductDetailScreen(product: Product) {
    var isFavorite by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFF6F6F6))
    ) {
        AsyncImage(
            model = product.imageUrl,
            contentDescription = product.name,
            modifier = Modifier
                .heightIn(max = 360.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(bottom = 96.dp)
        ) {
            Spacer(modifier = Modifier.height(360.dp))

            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(16.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = product.name,
                            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                            color = Color.Black
                        )
                        IconButton(onClick = { isFavorite = !isFavorite }) {
                            Icon(
                                imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                                contentDescription = "Favoritar",
                                tint = if (isFavorite) Color(0xFFFF6F00) else Color.Gray
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        repeat(5) {
                            Icon(
                                Icons.Default.Star,
                                contentDescription = "Star",
                                tint = Color(0xFFFFC107)
                            )
                        }
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("(10)", style = MaterialTheme.typography.bodyMedium)
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = product.description,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = product.price,
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Transparent)
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Button(
                            onClick = { /* Adicionar ao carrinho */ },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF7A00)),
                            shape = RoundedCornerShape(16.dp),
                            modifier = Modifier
                                .weight(1f)
                                .height(56.dp)
                        ) {
                            Text(
                                text = "Adicionar no carrinho",
                                color = Color.White,
                                style = MaterialTheme.typography.titleLarge.copy(
                                    fontWeight = FontWeight.Bold, fontSize = 16.sp
                                )
                            )
                        }

                        Spacer(modifier = Modifier.width(16.dp))

                        IconButton(
                            onClick = { /*Clique aqui*/ },
                            modifier = Modifier
                                .weight(.2f)
                                .height(56.dp)
                                .background(Color.White, shape = RoundedCornerShape(16.dp))
                                .border(1.dp, Color(0xFFFF7A00), shape = RoundedCornerShape(16.dp))
                                .padding(16.dp)
                        ) {
                            Icon(
                                Icons.Default.ShoppingCart,
                                contentDescription = "Carrinho",
                                tint = Color(0xFFFF7A00),
                                modifier = Modifier.size(32.dp)
                            )
                        }
                    }
                }
            }
        }

    }
}
