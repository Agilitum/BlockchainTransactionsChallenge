package com.blockchain.cuvva.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.blockchain.cuvva.PolicyViewModel
import com.blockchain.cuvva.R
import com.blockchain.cuvva.ui.home.adapter.HomeAdapter
import com.blockchain.cuvva.ui.home.policyTransformer.PolicyTransformer
import com.blockchain.cuvva.ui.utils.CustomDividerItemDecoration
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment: Fragment() {

    private val homeAdapter by lazy { HomeAdapter() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        layoutInflater.inflate(R.layout.fragment_home, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initHomeRecyclerView()
    }

    override fun onStart() {
        super.onStart()

        /*
         Created new & validated JSON from the given response:
         */
        // http://www.mocky.io/v2/5cb893314c0000ad1cd3d68f

        val policy = "5cb893314c0000ad1cd3d68f"

        ViewModelProviders
            .of(this)
            .get(PolicyViewModel::class.java)
            .apply {
                fetchPolicy(policy)
                policyLiveData.observe(viewLifecycleOwner, Observer {
                    homeAdapter.vehiclePolicies = PolicyTransformer().transform(it)
                })
            }
    }

    private fun initHomeRecyclerView(){
        val linearLayoutManager = LinearLayoutManager(context)

        fragment_home_recyclerview.apply {
            adapter = homeAdapter
            layoutManager = linearLayoutManager
            addItemDecoration(CustomDividerItemDecoration(context, linearLayoutManager.orientation))
        }
    }
}