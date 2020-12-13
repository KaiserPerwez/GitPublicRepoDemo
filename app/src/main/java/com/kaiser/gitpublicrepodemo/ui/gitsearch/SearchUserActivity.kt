package com.kaiser.gitpublicrepodemo.ui.gitsearch

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.kaiser.gitpublicrepodemo.R
import com.kaiser.gitpublicrepodemo.databinding.ActivitySearchUserBinding
import com.kaiser.gitpublicrepodemo.utils.ApiException
import com.kaiser.gitpublicrepodemo.utils.NoInternetException
import com.kaiser.gitpublicrepodemo.utils.dismissKeyboard
import com.kaiser.gitpublicrepodemo.utils.showSnackbar
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class SearchUserActivity : AppCompatActivity(), KodeinAware {


    override val kodein by kodein()
    private val factory by instance<SearchUserViewModelFactory>()
    private val binding by lazy {
        DataBindingUtil.setContentView<ActivitySearchUserBinding>(
            this,
            R.layout.activity_search_user
        )
    }
    private val viewModel: SearchUserViewModel by lazy {
        ViewModelProvider(this, factory).get(SearchUserViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding?.viewmodel = this@SearchUserActivity.viewModel
        resetSearchStatus()
        initListeners()
    }

    private fun initListeners() {
        binding?.searchBar?.apply {
            btnSearch.setOnClickListener {
                val searchText = txtUsername.text?.toString()?.trim() ?: ""
                if (searchText.isBlank()) return@setOnClickListener
                dismissKeyboard()
                searchForUser(searchText)
            }
        }
    }

    private fun resetSearchStatus() {
        binding?.apply {
            progressBar?.visibility=View.GONE
            status?.visibility = View.VISIBLE
            layoutContent?.root?.visibility = View.GONE
            status?.text = getString(R.string.initial_search_status)
        }
    }

    private fun searchForUser(searchText: String) {
        lifecycleScope.launch {
            try {
                viewModel?.fetchUserDetails(searchText)
               // setSearchSuccess()
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