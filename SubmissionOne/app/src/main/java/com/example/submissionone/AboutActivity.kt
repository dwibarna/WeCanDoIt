package com.example.submissionone

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.submissionone.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_DATA = "extra_data"
    }
    private lateinit var binding:ActivityAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dataIntent()
        shareIntent()
    }

    private fun shareIntent() {
        binding.btnShare.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, EXTRA_DATA)

            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }
    }

    @SuppressLint("CheckResult")
    private fun dataIntent() {
        val dataMajor = intent.getParcelableExtra<User>(EXTRA_DATA) as User
        Glide.with(this)
            .load(dataMajor.avatarUser)
            .apply(RequestOptions().override(150,150))
            .into(binding.ivAvatarAbout)
        binding.tvUsernameAbout.text = dataMajor.usernameUser
        binding.tvFollowersAbout.text =dataMajor.followersUser
        binding.tvFollowingAbout.text =dataMajor.followingUser
        binding.tvRepositoryAbout.text= dataMajor.repositoryUser
        binding.tvLocationAbout.text = dataMajor.locationUser
        binding.tvCompanyAbout.text = dataMajor.companyUser
    }
}