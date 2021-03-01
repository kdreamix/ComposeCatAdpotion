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
package com.example.androiddevchallenge.models

import com.example.androiddevchallenge.R
import java.util.UUID

data class CatModel(
    val id: String = UUID.randomUUID().toString(),
    val catName: String,
    val catBreed: CatBreed,
    val catImage: Int,
)

enum class BreedType(val string: String) {
    Natural("Natural"),
    Mutation("Mutation"),
    Crossbreed("Crossbreed"),
}

enum class CoatLength(val string: String) {
    Short("Short"),
    SemiShort("SemiShort"),
    SemiLong("SemiLong"),
    Rex("Rex"),
    Long("Long"),
}

enum class CoatPattern(val string: String) {
    All("All"),
    TickedTabby("TickedTabby"),
    MultiColor("MultiColor"),
}

sealed class CatBreed(
    val breedName: String,
    val breedType: BreedType,
    val coatLength: CoatLength,
    val coatPattern: CoatPattern,
    val imageRes: Int,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CatBreed

        if (breedName != other.breedName) return false
        if (breedType != other.breedType) return false
        if (coatLength != other.coatLength) return false
        if (coatPattern != other.coatPattern) return false
        if (imageRes != other.imageRes) return false

        return true
    }

    override fun hashCode(): Int {
        var result = breedName.hashCode()
        result = 31 * result + breedType.hashCode()
        result = 31 * result + coatLength.hashCode()
        result = 31 * result + coatPattern.hashCode()
        result = 31 * result + imageRes
        return result
    }
}

object Abyssinian :
    CatBreed(
        breedName = "Abyssinian",
        breedType = BreedType.Natural,
        coatLength = CoatLength.Short,
        coatPattern = CoatPattern.TickedTabby,
        imageRes = R.drawable.img_abyssinian
    )

object Aegean :
    CatBreed(
        breedName = "Aegean",
        breedType = BreedType.Natural,
        coatLength = CoatLength.SemiLong,
        coatPattern = CoatPattern.MultiColor,
        imageRes = R.drawable.img_aegean
    )

object AmericanBobtail :
    CatBreed(
        breedName = "American Bobtail",
        breedType = BreedType.Mutation,
        coatLength = CoatLength.SemiLong,
        coatPattern = CoatPattern.All,
        imageRes = R.drawable.img_american_bobtail
    )

object AmericanCurl :
    CatBreed(
        breedName = "American Curl",
        breedType = BreedType.Mutation,
        coatLength = CoatLength.SemiLong,
        coatPattern = CoatPattern.All,
        imageRes = R.drawable.img_american_curl
    )
