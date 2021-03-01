/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
            .fillMaxSize(),
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
