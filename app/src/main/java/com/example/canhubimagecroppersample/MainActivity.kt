package com.example.canhubimagecroppersample

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.canhub.cropper.CropImageView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bitmap = BitmapFactory.decodeResource(
            resources,
            R.drawable.canhub_logo_horizontal_transparent
        )

        val imageView = findViewById<CropImageView>(R.id.cropImageView)
        imageView.setOnCropImageCompleteListener { _: CropImageView,
                                                   result: CropImageView.CropResult ->

            Log.d("bitmap", result.bitmap.toString())
        }
        imageView.setImageBitmap(bitmap)
        imageView.croppedImageAsync()
    }
}