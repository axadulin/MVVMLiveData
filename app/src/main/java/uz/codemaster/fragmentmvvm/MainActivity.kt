
package uz.codemaster.fragmentmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import uz.codemaster.fragmentmvvm.databinding.ActivityMainBinding
import uz.codemaster.fragmentmvvm.fragments.FirstFragment
import uz.codemaster.fragmentmvvm.fragments.SecondFragment

class MainActivity : AppCompatActivity() {
    lateinit var mainBinding: ActivityMainBinding
    private val dataModel:DataModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        fragmentAction(FirstFragment.newInstance(),R.id.frameLayout1)
        fragmentAction(SecondFragment.newInstance(),R.id.frameLayout2)
        dataModel.messageToActivity.observe(this,{
            mainBinding.txtMain.text=it
        })
    }

    private fun fragmentAction(f: Fragment, idHolder:Int ){
        supportFragmentManager
            .beginTransaction()
            .replace(idHolder,f)
            .commit()

    }


}