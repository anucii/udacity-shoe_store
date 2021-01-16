package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.FOCUS_DOWN
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewModels.ShoeListViewModel
import com.udacity.shoestore.viewModels.ShoeViewModel
import kotlinx.android.synthetic.main.fragment_shoe_detail.view.*

/**
 * A simple [Fragment] subclass.
 * Use the [shoeDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class shoeDetailFragment : Fragment() {

    private val model : ShoeListViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentShoeDetailBinding>(
            inflater,
            R.layout.fragment_shoe_detail,
            container,
            false)
        binding.detailModel = ShoeViewModel()
        val shoeDetailToListAction = shoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment()
        binding.shoedetailCancel.setOnClickListener(){
            it.findNavController().navigate(shoeDetailToListAction)
        }
        binding.shoedetailSave.setOnClickListener(){
            addShoeToList(binding)
            it.findNavController().navigate(shoeDetailToListAction)
        }
        return binding.root
    }

    private fun addShoeToList(it: FragmentShoeDetailBinding) {
        val name = it.detailModel?.getShoeName()
        if (name.isNullOrBlank()) { return }
        val shoe = it.detailModel?.newShoe?.value
        if (shoe != null){
            model.shoeList.value?.add(shoe)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment shoeDetailFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
                shoeDetailFragment().apply {
                    arguments = Bundle().apply {
                    }
                }
    }
}