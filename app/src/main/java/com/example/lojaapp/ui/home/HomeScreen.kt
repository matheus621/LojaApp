package com.example.lojaapp.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.lojaapp.navigation.Screen
import com.example.lojaapp.ui.components.ProductCard
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(navController: NavHostController, viewModel: HomeViewModel = koinViewModel()) {
    val state by viewModel.state.collectAsState()

    HomeContent(
        state = state,
        onSearch = { viewModel.onIntent(HomeIntent.Search(it)) },
        onSelectCategory = { viewModel.onIntent(HomeIntent.SelectCategory(it)) },
        onProductClick = { productName ->
            navController.navigate("${Screen.ProductDetail.route}/$productName")
        }
    )
}

@Composable
fun HomeContent(
    state: HomeState,
    onSearch: (String) -> Unit,
    onSelectCategory: (String) -> Unit,
    onProductClick: (Int) -> Unit
) {
    val categories = listOf("Todos", "Tênis", "Botas", "Chuteiras", "Sapatênis")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(18.dp))
        Text(
            text = "Olá, Cleyton",
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            TextField(
                value = state.searchQuery,
                onValueChange = onSearch,
                placeholder = { Text("Pesquisar") },
                modifier = Modifier
                    .weight(1f)
                    .height(56.dp),
                shape = MaterialTheme.shapes.medium,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFF6F6F6),
                    unfocusedContainerColor = Color(0xFFF6F6F6),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
            Spacer(modifier = Modifier.width(8.dp))
            IconButton(
                onClick = { onSearch(state.searchQuery) },
                modifier = Modifier
                    .size(56.dp)
                    .background(Color(0xFFFF7A00), shape = MaterialTheme.shapes.medium)
            ) {
                Icon(Icons.Default.Search, contentDescription = "Buscar", tint = Color.White)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))


        LazyRow {
            items(categories) { category ->
                val selected = state.selectedCategory == category
                FilterChip(
                    selected = selected,
                    onClick = { onSelectCategory(category) },
                    label = {
                        Text(
                            text = category,
                            color = if (selected) Color.White else Color.Black
                        )
                    },
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = Color(0xFFFF7A00),
                        containerColor = Color(0xFFF6F6F6)
                    ),
                    modifier = Modifier.padding(end = 8.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (state.filteredProducts.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Nada para exibir em ${state.selectedCategory}",
                    color = Color.Gray,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        } else {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(4.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(state.filteredProducts) { product ->
                    ProductCard(
                        product = product,
                        onClick = {
                            onProductClick(product.id)
                        }
                    )
                }
            }
        }
    }
}
