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

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.models.Abyssinian
import com.example.androiddevchallenge.models.CatModel
import com.example.androiddevchallenge.routing.RouteCatDetail

@Preview
@Composable
fun CatList(
    list: List<CatModel> = listOf(
        CatModel(catName = "Bobby", catBreed = Abyssinian, catImage = R.drawable.img_abyssinian),
        CatModel(catName = "Bobby", catBreed = Abyssinian, catImage = R.drawable.img_abyssinian),
        CatModel(catName = "Bobby", catBreed = Abyssinian, catImage = R.drawable.img_abyssinian),
        CatModel(catName = "Bobby", catBreed = Abyssinian, catImage = R.drawable.img_abyssinian),
        CatModel(catName = "Bobby", catBreed = Abyssinian, catImage = R.drawable.img_abyssinian),
    ),
    navController: NavController? = null,
) {

    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        items(list) { catModel ->
            CatCard(catModel = catModel, onClick = {
                navController?.navigate(RouteCatDetail.id.format(catModel.id))
            })
        }
    }
}
