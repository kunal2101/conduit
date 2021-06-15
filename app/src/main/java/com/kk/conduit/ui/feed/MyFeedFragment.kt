
package com.kk.conduit.ui.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.kk.conduit.R
import kotlinx.android.synthetic.main.fragment_feed.*
import kotlinx.android.synthetic.main.fragment_feed.view.*

class MyFeedFragment: Fragment (){

    //private  var _binding: FragmentFeedBinding? = null
    private lateinit var  _feedviewmodel : FeedViewModel
   private  lateinit var  feedAdapter: ArticleFeedAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         _feedviewmodel = ViewModelProvider(this).get(FeedViewModel::class.java)
         feedAdapter = ArticleFeedAdapter({openArticle()})
        val root = inflater.inflate(R.layout.fragment_feed
            , container, false)

      // _binding = FragmentFeedBinding.inflate(inflater,container,false)

       // val root :View =  _binding.root
        root.feed_recycler_view.layoutManager  = LinearLayoutManager(context)
        root.feed_recycler_view.adapter = feedAdapter


        return root
    }
    fun openArticle() {
        findNavController().navigate(R.id.action_nav_feed_to_articleFragment)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _feedviewmodel.fetchMyFeed()
        _feedviewmodel.feed.observe({lifecycle}){
            feedAdapter.submitList(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
      //  _binding = null
    }
}