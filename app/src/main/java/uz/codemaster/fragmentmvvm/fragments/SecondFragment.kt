package uz.codemaster.fragmentmvvm.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import uz.codemaster.fragmentmvvm.DataModel
import uz.codemaster.fragmentmvvm.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private val dataModel: DataModel by activityViewModels()
    lateinit var fragBinding2: FragmentSecondBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragBinding2 = FragmentSecondBinding.inflate(inflater)
        return fragBinding2.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataModel.messageToFrag2.observe(activity as LifecycleOwner,{
            fragBinding2.txtMessage.text=it

        })

        fragBinding2.btnSendFragment.setOnClickListener {
            dataModel.messageToFrag1.value="Message from 2nd fragment!"
        }
        fragBinding2.btnSendActivity.setOnClickListener {
            dataModel.messageToActivity.value="Message to Activity from 2nd fragment!"
        }


    }
    companion object {

        @JvmStatic
        fun newInstance() =
            SecondFragment()
    }
}