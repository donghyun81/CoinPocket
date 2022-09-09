package com.example.coinpocket.presentation.company_listings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import com.example.coinpocket.domain.model.CompanyListing
import com.example.coinpocket.domain.model.CompanyListingEntity



@Composable
fun CompanyListContent(allCompanies:LazyPagingItems<CompanyListingEntity>){
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ){
        items(
            items = allCompanies,
            key = { movie ->
                    movie.id
            }
        )  { company->
                if (company != null) {
                    CompanyItem(
                        company =company,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    )
                }
        }
}
}


@Composable
fun CompanyItem(
    company:CompanyListingEntity,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = company.itmsNm!!,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = MaterialTheme.colors.onBackground,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    text = company.mrktTotAmt.toString(),
                    fontWeight = FontWeight.Light,
                    color = MaterialTheme.colors.onBackground
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = company.basDt!!,
                fontStyle = FontStyle.Italic,
                color = MaterialTheme.colors.onBackground
            )
        }
    }
}
