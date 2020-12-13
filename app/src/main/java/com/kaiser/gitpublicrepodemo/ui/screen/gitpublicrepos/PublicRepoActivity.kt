package com.kaiser.gitpublicrepodemo.ui.screen.gitpublicrepos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.kaiser.gitpublicrepodemo.R
import com.kaiser.gitpublicrepodemo.databinding.ActivityPublicRepoBinding
import com.kaiser.gitpublicrepodemo.ui.viewmodelfactory.PublicRepoViewModelFactory
import com.kaiser.gitpublicrepodemo.utils.ApiException
import com.kaiser.gitpublicrepodemo.utils.NoInternetException
import com.kaiser.gitpublicrepodemo.utils.showSnackbar
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class PublicRepoActivity : AppCompatActivity() , KodeinAware{
    override val kodein by kodein()
    private val factory by instance<PublicRepoViewModelFactory>()
    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityPublicRepoBinding>(
            this,
            R.layout.activity_public_repo
        )
    }
    private val viewModel: PublicRepoViewModel by lazy {
        ViewModelProvider(this, factory).get(PublicRepoViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initUiAndListeners()
    }


    private fun initUiAndListeners() {
        //toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Public Repositories"
        binding?.toolbar?.setNavigationOnClickListener {
            finish()
        }

        //viewmodel
        binding?.viewmodel = this@PublicRepoActivity.viewModel
        resetSearchStatus()
        intent?.getStringExtra("user_name")?.also { userName ->
            searchForPublicRepo(userName)
        }
    }
    private fun resetSearchStatus() {
        binding?.apply {
            progressBar?.visibility= View.GONE
            layoutContentRepo?.root?.visibility = View.GONE
        }
    }

    private fun searchForPublicRepo(userName: String) {
        lifecycleScope.launch {
            try {
                viewModel?.fetchPublicRepo(userName)
            } catch (e: ApiException) {
                e.printStackTrace()
                resetSearchStatus()
                binding?.root?.showSnackbar(e.message.toString())
            } catch (e: NoInternetException) {
                e.printStackTrace()
                resetSearchStatus()
                binding?.root?.showSnackbar(e.message.toString())
            }
        }
    }
}