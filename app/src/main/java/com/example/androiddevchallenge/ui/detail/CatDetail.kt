package com.example.androiddevchallenge.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.models.Abyssinian
import com.example.androiddevchallenge.models.CatModel
import com.example.androiddevchallenge.ui.theme.typography

@Preview("Cat Detail")
@Composable
fun CatDetail(
    catModel: CatModel = CatModel(
        catImage = 0,
        catBreed = Abyssinian,
        id = "",
        catName = "Bobby"
    ),
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
    ) {
        Image(
            painter = painterResource(catModel.catBreed.imageRes),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .clip(shape = RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop,
        )
        Spacer(Modifier.width(16.dp))
        Column {
            Text(text = catModel.catName, style = typography.h6)
            Text(
                text = "Breed: ${catModel.catBreed.breedName}",
                style = typography.body1,
                color = Color.Gray
            )
            Text(
                text = "Type: ${catModel.catBreed.breedType.string}",
                style = typography.body1,
                color = Color.Gray
            )
            Text(
                text = "Coat length: ${catModel.catBreed.coatLength.string}",
                style = typography.body1,
                color = Color.Gray
            )
            Text(
                text = "Coat pattern: ${catModel.catBreed.coatPattern.string}",
                style = typography.body1,
                color = Color.Gray
            )
        }
    }
}