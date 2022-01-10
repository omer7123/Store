package com.ripalay.store

import android.view.LayoutInflater
import com.ripalay.store.core.ui.BaseActivity
import com.ripalay.store.databinding.ActivityMainBinding
import com.ripalay.youtubeapi.core.ui.BaseViewModel

class MainActivity : BaseActivity<BaseViewModel, ActivityMainBinding>() {

    override fun inflateVB(inflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

}