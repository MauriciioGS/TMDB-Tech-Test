package mx.mauriciogs.moviesandtvshows.common

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import mx.mauriciogs.moviesandtvshows.common.extensions.loadingDialog

interface BaseListView {
    fun showProgressDialog()
    fun hideProgressDialog()
}

open class BaseFrag <T : ViewDataBinding>(@LayoutRes private val layoutResId : Int): Fragment(), BaseListView {

    private var _binding: T? = null
    private val binding: T get() = _binding!!
    private var progressDialog : Dialog? = null
    protected var errorDialog : Dialog? = null

    open fun T.initialize(){}

    open fun T.initializeWithContainer(container: ViewGroup?){}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = DataBindingUtil.inflate(inflater, layoutResId, container, false)
        binding.initialize()
        binding.initializeWithContainer(container)
        return binding.root
    }

    override fun showProgressDialog() {
        try {
            progressDialog = loadingDialog()
        }catch (e :Exception){
            e.printStackTrace()
        }
    }

    override fun hideProgressDialog() {
        try {
            progressDialog?.let {
                if(it.isShowing)
                    it.dismiss()
            }
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}