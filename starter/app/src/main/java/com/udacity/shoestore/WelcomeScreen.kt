package com.udacity.shoestore

import android.database.DatabaseUtils
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentWelcomeScreenBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [WelcomeScreen.newInstance] factory method to
 * create an instance of this fragment.
 */
class WelcomeScreen : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentWelcomeScreenBinding>(
                inflater,
                R.layout.fragment_welcome_screen,
                container,
                false
        )
        val welcomeToInstructionAction = WelcomeScreenDirections.actionWelcomeScreenToInstructionFragment()
        binding.welcomeToInstructions.setOnClickListener(){
            it.findNavController().navigate(welcomeToInstructionAction)
        }
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment WelcomeScreen.
         */
        @JvmStatic
        fun newInstance() =
            WelcomeScreen().apply {
                arguments = Bundle().apply {
                }
            }
    }
}