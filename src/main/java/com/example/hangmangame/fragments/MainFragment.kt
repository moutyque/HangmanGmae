package com.example.hangmangame.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.hangmangmae.R
//Generated class that manage the viewbinding
import com.example.hangmangmae.databinding.FragmentMainBinding

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {

    private lateinit var _binding: FragmentMainBinding

    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMainBinding.inflate(inflater, container, false)
        _binding.buttonRules.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_mainFragment_to_rulesFragment) }

        _binding.buttonScore.setOnClickListener { view :View ->
            view.findNavController().navigate(R.id.action_mainFragment_to_scoreFragment)
        }

        _binding.buttonNewGame.setOnClickListener { view :View ->
            view.findNavController().navigate(R.id.action_mainFragment_to_newGameFragment)
        }

        // Inflate the layout for this fragment
        return _binding.root
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *

         * @return A new instance of fragment MainFragment.
         */
        // TODO: Rename and change types and number of parameters

    }
}