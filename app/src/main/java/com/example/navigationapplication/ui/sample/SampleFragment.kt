package com.example.navigationapplication.ui.sample

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.navigationapplication.R

class SampleFragment : Fragment() {

    companion object {
        fun newInstance() = SampleFragment()
    }

    private lateinit var viewModel: SampleViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.sample_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SampleViewModel::class.java)
        // TODO: Use the ViewModel
    }

}