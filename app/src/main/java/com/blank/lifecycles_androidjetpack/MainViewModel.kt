package com.blank.lifecycles_androidjetpack

import androidx.lifecycle.*

/**
 * Created by GhoziMahdi on 08/10/2019.
 * Email : -
 * No Tpln : -
 * Profesi : Mobile Engineer Development
 */
class MainViewModel(var navigator: MainNavigator) : ViewModel(), LifecycleObserver {
    private var data: MutableLiveData<List<String>>? = null
    fun getData(): LiveData<List<String>> {
        if (data == null) {
            data = MutableLiveData()
            loadData()
        }
        return data as MutableLiveData<List<String>>
    }

    private fun loadData() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun create() {
        navigator.showMsg("On Create")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun start() {
        navigator.showMsg("On Start")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun resume() {
        navigator.showMsg("On Resume")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun pause() {
        navigator.showMsg("On Pause")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun stop() {
        navigator.showMsg("On Stop")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun destroy() {
        navigator.showMsg("On Destroy")
    }

    class Factory(var navigator: MainNavigator) : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
                return MainViewModel(navigator) as T
            }
            return super.create(modelClass)
        }
    }
}