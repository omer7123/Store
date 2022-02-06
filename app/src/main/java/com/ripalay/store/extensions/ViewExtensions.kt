package com.ripalay.store.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.load(s: String) {
    Glide.with(this).load(s).centerCrop().into(this)
}
