package com.example.tim.foodapp.ui.FoodList

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.tim.foodapp.R
import com.example.tim.foodapp.ViewModelProviderFactory
import com.example.tim.foodapp.data.models.FoodList
import com.example.tim.foodapp.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_foodlist.*
import javax.inject.Inject

class FoodListActivity : BaseActivity() {


    @Inject
    lateinit var mViewModelProviderFactory: ViewModelProviderFactory
    private lateinit var mAdapter: ListAdapter
    var mList: ArrayList<FoodList> = ArrayList()
    lateinit var mFoodListViewModel: FoodListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foodlist)
        mFoodListViewModel = ViewModelProviders.of(this, mViewModelProviderFactory).get(FoodListViewModel::class.java)

        initRecyclerView(mList)

        mFoodListViewModel.lists.observe(this,
                Observer {
                    mAdapter.setList(it as ArrayList<FoodList>)
                })

        mFoodListViewModel.getList()
    }

    private fun initRecyclerView(list: ArrayList<FoodList>) {

        mAdapter = ListAdapter()
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.setHasFixedSize(true)
        mAdapter.setList(list)
        recyclerView.adapter = mAdapter
    }


}