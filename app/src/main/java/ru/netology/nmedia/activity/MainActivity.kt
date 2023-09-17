package ru.netology.nmedia.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import ru.netology.nmedia.R
import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.functions.*
import ru.netology.nmedia.viewmodel.PostViewModel

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel: PostViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        subscribe()
        setupListeners()
    }

    private fun subscribe() {
        viewModel.data.observe(this) { post ->
            with(binding) {
                author.text = post.author
                content.text = post.content
                published.text = post.published
                likesAmount.text = formatBigNumber(post.likes)
                sharesAmount.text = formatBigNumber(post.shares)
                viewsAmount.text = formatBigNumber(post.views)
                avatar.setImageResource(R.drawable.post_avatar_drawable)

                likeButton.setImageResource(
                    if (post.likedByMe) R.drawable.ic_liked_24 else R.drawable.ic_like_24
                )
            }
        }
    }

    private fun setupListeners() {
        binding.likeButton.setOnClickListener {
            viewModel.like()
        }

        binding.shareButton.setOnClickListener {
            viewModel.share()
        }
    }
}