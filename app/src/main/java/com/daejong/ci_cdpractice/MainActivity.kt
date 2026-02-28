package com.daejong.ci_cdpractice

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.daejong.ci_cdpractice.databinding.ActivityMainBinding
import kotlinx.coroutines.newSingleThreadContext
import kotlin.getValue

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        mBinding.btnA.setOnClickListener { Toast.makeText(this, "테스트 토스트", Toast.LENGTH_SHORT).show() }

        mBinding.btnB.setOnClickListener { startActivity(Intent(this, SubActivity::class.java)) }
    }
}