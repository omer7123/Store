package com.ripalay.store.ui.profile.orders

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ripalay.store.R
import com.ripalay.store.core.ui.BaseFragment
import com.ripalay.store.databinding.FragmentOrdersBinding
import com.ripalay.store.data.remote.models.Order
import com.ripalay.store.ui.account_fragment.orders.OrdersAdapter

class OrdersFragment : BaseFragment<OrdersViewModel, FragmentOrdersBinding>(R.layout.fragment_orders) {

    private lateinit var navController: NavController
    override val viewModel: OrdersViewModel by viewModels()
    override val binding: FragmentOrdersBinding by viewBinding()
    private lateinit var adapter: OrdersAdapter

    private var list = mutableListOf<Order>()

    override fun initObservers() {

        list.add(Order(89547543, "02.04.2022", "В пути"))
        list.add(Order(89546412, "24.03.2022", "В пути"))
        list.add(Order(89535745, "11.02.2022", "Доставлен"))
        list.add(Order(89009328, "11.10.2021", "Доставлен"))
        list.add(Order(89009328, "11.10.2021", "Доставлен"))
        list.add(Order(89009328, "11.10.2021", "Доставлен"))

        adapter = OrdersAdapter(list, this::clickListener)
        binding.rvOrders.adapter = adapter


    }

    override fun initListeners() {
        binding.fabBack.setOnClickListener {
            activity?.onBackPressed()
        }
    }

    private fun clickListener(order: Order) {
        val bundle = Bundle()
        bundle.putSerializable("order", order)
        navController.navigate(R.id.orderDetailsFragment, bundle)
    }

    override fun initNavController() {
        navController = findNavController()
    }
}