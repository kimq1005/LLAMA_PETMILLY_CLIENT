package com.llama.petmilly_client.presentation.findanimalscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.homescreen.items.BorderCategoryItems
import com.llama.petmilly_client.presentation.homescreen.items.CategoryShelterItems
import com.llama.petmilly_client.presentation.shelterscreen.TitleBar
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun FindAnimalListScreen(navController: NavController, viewModel: FindAnimalViewModel) {
    val scrollState = rememberScrollState()

    Box {
        Column(
            modifier = Modifier
                .fillMaxSize()

        ) {

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                viewModel.setcategory()

                items(viewModel.categorytest) { categorylist ->
                    Row {
                        if (viewModel.categorytest.indexOf(categorylist) == 0) {
                            Spacer(modifier = Modifier.padding(start = 15.dp))
                            BorderCategoryItems(title = categorylist.title) {

                            }


                        } else {
                            BorderCategoryItems(title = categorylist.title) {

                            }
                        }

                        Spacer(modifier = Modifier.width(6.dp))
                    }
                }

            }//LazyRow
            Spacer(modifier = Modifier.height(20.dp))
            LazyColumn(Modifier.padding(horizontal = 7.dp)) {

                val missingAnimalInfoData = listOf(
                    MissingAnimalInfoData(
                        "곰자",
                        "수컷 / 15kg / 믹스/ 귀 한쪽 접혀 있어욥",
                        "23.1.10 10시 - 월계동 뱅뱅사거리 라떼병원 부근",
                        "10시간 전"
                    ),
                    MissingAnimalInfoData(
                        "승현",
                        "수컷 / 15kg / 믹스/ 귀 한쪽 접혀 있어욥",
                        "23.1.10 10시 - 월계동 뱅뱅사거리 라떼병원 부근",
                        "10시간 전"
                    ),
                    MissingAnimalInfoData(
                        "럭키",
                        "수컷 / 15kg / 믹스/ 귀 한쪽 접혀 있어욥",
                        "23.1.10 10시 - 월계동 뱅뱅사거리 라떼병원 부근",
                        "10시간 전"
                    ),

                    MissingAnimalInfoData(
                        "럭키",
                        "수컷 / 15kg / 믹스/ 귀 한쪽 접혀 있어욥",
                        "23.1.10 10시 - 월계동 뱅뱅사거리 라떼병원 부근",
                        "10시간 전"
                    ),
                    MissingAnimalInfoData(
                        "럭키",
                        "수컷 / 15kg / 믹스/ 귀 한쪽 접혀 있어욥",
                        "23.1.10 10시 - 월계동 뱅뱅사거리 라떼병원 부근",
                        "10시간 전"
                    )
                )

                items(missingAnimalInfoData) { item ->
                    FindAnimalItems(
                        name = item.name,
                        animalinfo = item.animalinfo,
                        missinginfo = item.missinginfo,
                        time = item.tiems,
                        onclick = {

                        }
                    )

                    Spacer(modifier = Modifier.height(13.dp))

                }
            }
        }


        Image(
            painter = painterResource(id = R.drawable.img_write),
            contentDescription = null,

            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 40.dp, end = 15.dp)
                .width(50.dp)
                .height(50.dp)
                .clickable {

                },
            contentScale = ContentScale.Crop
        )

    }

}

@Preview
@Composable
fun FindAnimalPreview() {
    val navController = rememberNavController()
    val viewModel: FindAnimalViewModel = hiltViewModel()
    FindAnimalListScreen(navController = navController, viewModel = viewModel)

}

data class MissingAnimalInfoData(
    val name: String,
    val animalinfo: String,
    val missinginfo: String,
    val tiems: String,
)