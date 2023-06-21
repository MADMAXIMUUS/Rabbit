package ru.rabbit.persian.avatars

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import ru.rabbit.persian.foundation.PersianTheme
import ru.rabbit.persian.foundation.icons

object PersianAvatars {

    @OptIn(ExperimentalGlideComposeApi::class)
    @Composable
    fun Round(
        modifier: Modifier = Modifier,
        imageUrl: String,
        isEdit: Boolean = false,
        size: AvatarSize = PersianAvatarsSizes.medium()
    ) {
        Box(
            modifier = modifier
                .size(size.boxSizes)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.surface)
                .border(1.dp, MaterialTheme.colorScheme.outlineVariant),
            contentAlignment = Alignment.Center
        ) {
            GlideImage(
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop,
                loading = placeholder {
                    Icon(
                        modifier = Modifier
                            .size(size.boxSizes),
                        painter = MaterialTheme.icons.personOutlined,
                        contentDescription = ""
                    )
                },
                failure = placeholder {
                    Icon(
                        modifier = Modifier
                            .size(size.boxSizes),
                        painter = MaterialTheme.icons.personOutlined,
                        contentDescription = ""
                    )
                },
                model = imageUrl,
                contentDescription = ""
            )
            if (isEdit) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.6f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = MaterialTheme.icons.add, contentDescription = ""
                    )
                }
            }
        }
    }

    @OptIn(ExperimentalGlideComposeApi::class)
    @Composable
    fun Square(
        modifier: Modifier = Modifier,
        imageUrl: String,
        isEdit: Boolean = false,
        size: AvatarSize = PersianAvatarsSizes.medium()
    ) {
        Box(
            modifier = modifier
                .size(size.boxSizes)
                .clip(MaterialTheme.shapes.large)
                .background(MaterialTheme.colorScheme.surface)
                .border(1.dp, MaterialTheme.colorScheme.outlineVariant),
            contentAlignment = Alignment.Center
        ) {
            GlideImage(
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop,
                loading = placeholder {
                    Icon(
                        modifier = Modifier
                            .size(size.boxSizes),
                        painter = MaterialTheme.icons.personOutlined,
                        contentDescription = ""
                    )
                },
                failure = placeholder {
                    Icon(
                        modifier = Modifier
                            .size(size.boxSizes),
                        painter = MaterialTheme.icons.personOutlined,
                        contentDescription = ""
                    )
                },
                model = imageUrl,
                contentDescription = ""
            )
            if (isEdit) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.6f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = MaterialTheme.icons.add, contentDescription = ""
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun AvatarPreview() {
    PersianTheme {
        Surface {
            PersianAvatars
                .Round(
                    imageUrl = "https://picsum.photos/200/300"
                )
        }
    }
}