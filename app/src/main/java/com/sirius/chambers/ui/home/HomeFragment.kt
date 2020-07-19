package com.sirius.chambers.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.sirius.chambers.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cardList = generateCardList(100)
        home_recycler_view.adapter =
            HomeCardAdapter(cardList)
        home_recycler_view.layoutManager = LinearLayoutManager(this.context)
        home_recycler_view.setHasFixedSize(true)
    }

    private fun generateCardList(size: Int): List<HomeCardItem> {
        val list = ArrayList<HomeCardItem>()

        for (i in 0 until size) {
            val item = HomeCardItem(
                R.drawable.home_card_person_image,
                "Person $i",
                "Description of Person $i"
            )
            list += item
        }
        return list
    }
}
