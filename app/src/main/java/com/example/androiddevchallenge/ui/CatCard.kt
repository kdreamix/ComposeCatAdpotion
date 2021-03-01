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
package com.example.androiddevchallenge.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.models.Abyssinian
import com.example.androiddevchallenge.models.CatModel

@Preview("Cat card")
@Composable
fun CatCard(
    catModel: CatModel = CatModel(
        catImage = 0,
        catBreed = Abyssinian,
        id = "",
        catName = "Bobby"
    )
) {
    Card(elevation = 12.dp) {
        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(catModel.catBreed.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .height(180.dp)
                    .width(180.dp)
                    .clip(shape = CircleShape),
                contentScale = ContentScale.Crop,
            )
            Spacer(Modifier.height(16.dp))
            Text(text = catModel.catName)
        }
    }
}
