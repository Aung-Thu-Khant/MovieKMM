package org.example.moviekmm

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import moviekmm.composeapp.generated.resources.Res
import moviekmm.composeapp.generated.resources.compose_multiplatform
import moviekmm.composeapp.generated.resources.movie1
import moviekmm.composeapp.generated.resources.movie2
import org.example.moviekmm.model.MovieData
import org.example.moviekmm.view.MovieItemView

@Composable
fun HomePage(){
    var searchQuery = remember { mutableStateOf("") }
    val items = listOf(
        MovieData("Title1","Description One", Res.drawable.movie1),
        MovieData("Title2","Description Two",Res.drawable.movie2),
        MovieData("Title3","Description Three",Res.drawable.movie1),
        MovieData("Title4","Description Four",Res.drawable.movie2),
        MovieData("Title5","Description Five",Res.drawable.movie1),
        MovieData("Title6","Description Six",Res.drawable.movie2),
    )

    Box(
        modifier = Modifier.fillMaxSize()
            .background(Color.Black)
    ){
        LazyColumn (
            modifier = Modifier.fillMaxWidth(),
        ){
            item {
                BasicTextField(
                    value = searchQuery.value,
                    onValueChange = {searchQuery.value = it},
                    modifier = Modifier.fillMaxWidth()
                        .padding(8.dp)
                        .height(50.dp)
                        .background(Color.White, RoundedCornerShape(8.dp))
                        .border(1.dp, Color.White, RoundedCornerShape(8.dp))
                        .padding(12.dp)
                )
            }
            item {
                Text(
                    text = "Popular Movies",
                    color = Color.White,
                    fontSize = 18.sp,
                    modifier = Modifier.fillMaxWidth()
                        .padding(start = 8.dp, top = 8.dp, end = 8.dp)
                )
            }
            item{
                CustomMovieListViewHorizontal(items)
            }
            item{
                Spacer(modifier = Modifier.height(10.dp))
            }
            item{
                Text(
                    text = "Upcoming Movies",
                    color = Color.White,
                    fontSize = 18.sp,
                    modifier = Modifier.fillMaxWidth()
                        .padding(start = 8.dp, top = 8.dp, end = 8.dp)
                )
            }
            item{
                CustomMovieListViewHorizontal(items)
            }
            item{
                Spacer(modifier = Modifier.height(10.dp))
            }
            item{
                Text(
                    text = "Top Related Movies",
                    color = Color.White,
                    fontSize = 18.sp,
                    modifier = Modifier.fillMaxWidth()
                        .padding(start = 8.dp, top = 8.dp, end = 8.dp)
                )
            }
            item{
                CustomMovieListViewHorizontal(items)
            }
            item{
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }

}

@Composable
fun CustomMovieListViewHorizontal(movie: List<MovieData>){
    LazyRow {
        items(movie){
            MovieItemView(it)
        }
    }
}

@Composable
fun CustomMovieListViewVertical(movie: List<MovieData>){
    LazyColumn {
        items(movie){
            MovieItemView(it)
        }
    }
}