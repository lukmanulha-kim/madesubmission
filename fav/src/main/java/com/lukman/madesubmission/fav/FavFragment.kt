package com.lukman.madesubmission.fav

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.lukman.madesubmission.core.ui.GameAdapter
import com.lukman.madesubmission.databinding.FragmentFavoriteBinding
import com.lukman.madesubmission.detail.DetailActivity
import com.lukman.madesubmission.favourite.FavouriteViewModel
import com.lukman.madesubmission.favourite.databinding.FragmentFavBinding
import dagger.hilt.android.AndroidEntryPoint

//@AndroidEntryPoint
class FavFragment : Fragment() {

//    private val favoriteViewModel: FavouriteViewModel by viewModels()

    private var _binding: FragmentFavBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavBinding.inflate(inflater, container, false)
        return binding.root
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        if (activity != null) {
//
//            val tourismAdapter = GameAdapter()
//            tourismAdapter.onItemClick = { selectedData ->
//                val intent = Intent(activity, DetailActivity::class.java)
//                intent.putExtra(DetailActivity.EXTRA_DATA, selectedData)
//                startActivity(intent)
//            }
//
//            favoriteViewModel.favoriteGame.observe(viewLifecycleOwner) { dataTourism ->
//                tourismAdapter.setData(dataTourism)
//                binding.viewEmpty.root.visibility =
//                    if (dataTourism.isNotEmpty()) View.GONE else View.VISIBLE
//            }
//
//            with(binding.rvGame) {
//                layoutManager = LinearLayoutManager(context)
//                setHasFixedSize(true)
//                adapter = tourismAdapter
//            }
//        }
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }

}