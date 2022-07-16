package com.example.navigationapplication.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.example.navigationapplication.Communicator
import com.example.navigationapplication.R
import com.example.navigationapplication.databinding.FragmentHomeBinding
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private lateinit var communicator: Communicator

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    fun EditText.afterTextChanged() {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            homeViewModel.fetchAllMovies("fragment")
        }

        binding.textHome.afterTextChanged()


        fun Circle.perimeter(): Double {
            return 2 * Math.PI * radius
        }

        fun Circle.dummy(): String {
            return "hello dummy"
        }

        val newCircle = Circle(22.00)

        println("Area of the circle is ${newCircle.area()}")
        // invoke extension function
        println("Perimeter of the circle is ${newCircle.perimeter()}")

        println("Perimeter of the circle is ${newCircle.dummy()}")

        homeViewModel.getData()

        homeViewModel.listData.observe(viewLifecycleOwner, Observer {
            val adapter = HomeAdapter(it)

            // Setting the Adapter with the recyclerview
            binding.recyclerview.adapter = adapter
        })

        communicator = activity as Communicator

        afterTextChangeDelayed("helloworld") {
            println("poppers-------> $it")
        }

        inlineFunction {
            println("poppers------> call onsite")
        }

        inlineFunction1 {
            println("poppers------> call onsite without")
            return
        }

        binding.button.setOnClickListener {
            // communicator.onPassData()
            Navigation.findNavController(it)
                .navigate(R.id.action_navigation_home_to_navigation_details2)
        }
    }

    //higher order function
    private fun afterTextChangeDelayed(string1: String, callBack: (result: String) -> Unit) {

        thread {
            Thread.sleep(10000)
            callBack.invoke(string1)
        }

    }

    //inline function with crossline
    private inline fun inlineFunction(crossinline myFun: () -> Unit) {

        myFun()
        println("poppers-----> inline")

    }

    //inline function without crossline
    private inline fun inlineFunction1(myFun: () -> Unit) {
        myFun()
        println("poppers-----> inline without")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}

class Circle(val radius: Double) {
    // member function of class
    fun area(): Double {
        return Math.PI * radius * radius
    }
}