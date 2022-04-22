package com.example.canhubimagecroppersample

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.widget.Button
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
            Log.d("error", result.error.toString())
            Log.d("isSuccessful", result.isSuccessful.toString())
        }
        imageView.setImageBitmap(bitmap)

        val okButton = findViewById<Button>(R.id.okButton)
        okButton.setOnClickListener {
            imageView.croppedImageAsync()
        }
    }
}