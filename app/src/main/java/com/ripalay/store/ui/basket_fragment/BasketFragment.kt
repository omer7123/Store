package com.ripalay.store.ui.basket_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.ripalay.store.R
import com.ripalay.store.databinding.FragmentBasketBinding
import org.koin.android.ext.android.bind

class BasketFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentBasketBinding
    private lateinit var navController: NavController
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navController = findNavController()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentBasketBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    private fun initListeners() {
        binding.ivClose.setOnClickListener {
            this.dismiss()
        }
        binding.btnIncrement.setOnClickListener {
            count++
            binding.tvDisplay.text = count.toString()
        }
        binding.btnDecrement.setOnClickListener {
            count--
            when {
                count >= 0 -> {
                    binding.tvDisplay.text = count.toString()
                }
                count < 0 -> {
                    count = 0
                    binding.tvDisplay.text = count.toString()
                }
                count > 10 -> {
                    count = 10
                    binding.tvDisplay.text = count.toString()
                }
            }
        }

        binding.ivDelete.setOnClickListener {
            binding.constLay1.isVisible = false
            binding.constLay2.isVisible = false
            binding.tvSize.isVisible = false
            binding.divider.isVisible = false
            binding.btnPurchase.isVisible = false
            binding.tvDeleted.isVisible = true
        }

        binding.btnPurchase.setOnClickListener {
//            this.dismiss()
            navController.navigate(R.id.basketPurchasedFragment)
        }
    }

    override fun getTheme(): Int = R.style.BottomSheetDialogTheme
}