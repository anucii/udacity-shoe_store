package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewModels.ShoeListViewModel
import kotlinx.android.synthetic.main.shoe_item.view.*

/**
 * A simple [Fragment] subclass.
 * Use the [ShoeListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeListFragment : Fragment() {

    private val model : ShoeListViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentShoeListBinding>(
            inflater,
            R.layout.fragment_shoe_list,
            container,
            false
        )
        val shoeListObserver = Observer<MutableList<Shoe>>(){
            it?.map { shoe ->
                addItemViewFromShoe(shoe, binding.shoeItemsContainer)
            }
        }
        model.shoeList.observe(viewLifecycleOwner, shoeListObserver)
        val shoeListToDetailAction = ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment()
        binding.shoelistToDetail.setOnClickListener(){
            it.findNavController().navigate(shoeListToDetailAction)
        }
        return binding.root
    }

    private fun addItemViewFromShoe(shoe: Shoe, shoeItemsContainer: LinearLayout): Unit {
        val itemView = View.inflate(context, R.layout.shoe_item, null)
        if (itemView != null)
        {
            itemView.item_name.text = shoe.name
            itemView.item_company.text = shoe.company
            itemView.item_size.text = shoe.size.toString()
            shoeItemsContainer.addView(itemView, 1)
        }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment ShoeListFragment.
         */
        @JvmStatic
        fun newInstance() =
            ShoeListFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_logout, menu)
    }
}