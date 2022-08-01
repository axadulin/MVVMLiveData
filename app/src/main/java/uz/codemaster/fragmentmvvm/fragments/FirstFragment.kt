package uz.codemaster.fragmentmvvm.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import uz.codemaster.fragmentmvvm.DataModel
import uz.codemaster.fragmentmvvm.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private val dataModel: DataModel by activityViewModels()
    lateinit var fragBinding1: FragmentFirstBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragBinding1= FragmentFirstBinding.inflate(inflater)
        return fragBinding1.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataModel.messageToFrag1.observe(activity as LifecycleOwner,{
            fragBinding1.txtMessage.text=it

        })
        fragBinding1.btnSendFragment.setOnClickListener {
            dataModel.messageToFrag2.value="Message from 1st fragment!"
        }
        fragBinding1.btnSendActivity.setOnClickListener {
            dataModel.messageToActivity.value="Message to Activity from 1st fragment!"
        }

    }
    companion object {

        @JvmStatic
        fun newInstance() =  FirstFragment()
    }
}