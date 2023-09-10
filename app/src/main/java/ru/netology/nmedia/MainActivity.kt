package ru.netology.nmedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.dto.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root) //это view в созданном биндинге

        val post = Post(
            1,
            "Нетология. Университет интернет-профессий будущего",
            "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
            "21 мая в 18:36",
            false,
            0,
            5,
            100000
        )
        with(binding) {
            author.text = post.author
            content.text = post.content
            published.text = post.published
            likesAmount.text = formatBigNumber(post.likes)
            sharesAmount.text = formatBigNumber(post.shares)
            viewsAmount.text = formatBigNumber(post.views)
            avatar.setImageResource(R.drawable.post_avatar_drawable)

            if (post.likedByMe) {
                likeButton.setImageResource(R.drawable.ic_liked_24)
            } else {
                likeButton.setImageResource(R.drawable.ic_like_24)
            }
            likeButton.setOnClickListener {
                post.likedByMe = !post.likedByMe
                   likeButton.setImageResource(
                       if (post.likedByMe) R.drawable.ic_liked_24 else R.drawable.ic_like_24
                   )
                if (post.likedByMe) post.likes++ else post.likes--
                likesAmount.text = formatBigNumber(post.likes)
            }

            shareButton.setOnClickListener {
                post.shares++
                sharesAmount.text = formatBigNumber(post.shares)
            }
        }
    }
}