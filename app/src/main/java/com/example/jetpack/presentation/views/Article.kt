package com.example.jetpack.presentation.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.jetpack.R
import com.example.jetpack.domain.entities.Article
import com.example.jetpack.domain.entities.Source

class SampleArticleProvider : PreviewParameterProvider<Article> {
    override val values: Sequence<Article>
        get() = sequenceOf(
            Article(
                id = "1",
                title = "Tesla's Bitcoin investment Fell \$1 Billion last Q",
                description = "Topline someday after posting blowout second-quarter revenue, electric carmaker Tesla published in a public submitting Tuesday that the value of its bitcoin holdings plummeted more than \$1 billion remaining quarter from \$2.5 billion at the end of March as the…",
                urlToImage = "https://cdn.cnn.com/cnnnext/dam/assets/210816053221-02-haiti-earthquake-0815-file-super-169.jpg",
                publishedAt = "2021-08-15T02:30:30Z",
                source = Source("id", "name", "description", "url", "category"),
                content = "content",
                author = "author",
                url = "url"
            )
        )
    override val count: Int
        get() = values.count()
}

@Preview
@Composable
fun ArticleItem(@PreviewParameter(SampleArticleProvider::class) article: Article) {
    Row(Modifier.fillMaxWidth()) {
        Image(
            painter = rememberImagePainter(
                data = article.urlToImage,
                builder = {
                    placeholder(R.drawable.ic_article_place_holder)
                }
            ),
            contentDescription = null,
            modifier = Modifier.size(128.dp),
            contentScale = ContentScale.FillHeight
        )
        Column(
            Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                text = article.title,
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.h6
            )
            Text(
                text = article.description,
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.body2,
                maxLines = 2
            )
            Text(
                text = article.publishedAt,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp),
                style = MaterialTheme.typography.caption,
                textAlign = TextAlign.End
            )
        }
    }
}