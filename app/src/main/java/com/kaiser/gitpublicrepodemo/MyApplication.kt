package com.kaiser.gitpublicrepodemo

import android.app.Application
import com.kaiser.gitpublicrepodemo.data.remote.ApiInterceptor
import com.kaiser.gitpublicrepodemo.data.remote.GitHubApi
import com.kaiser.gitpublicrepodemo.data.repository.GithubRepository
import com.kaiser.gitpublicrepodemo.ui.gitsearch.SearchUserViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MyApplication:Application(), KodeinAware {

    override val kodein: Kodein= Kodein.lazy {
        import(androidXModule(this@MyApplication))
        bind() from singleton { ApiInterceptor(instance()) }
        bind() from singleton { GitHubApi(instance()) }
        bind() from singleton { GithubRepository(instance()) }
        bind() from provider { SearchUserViewModelFactory(instance()) }
    }

}