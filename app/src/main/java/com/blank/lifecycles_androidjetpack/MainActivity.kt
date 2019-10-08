package com.blank.lifecycles_androidjetpack

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders


class MainActivity : AppCompatActivity(), MainNavigator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var factory = MainViewModel.Factory(this)
        var viewModel = ViewModelProviders.of(this, factory).get(MainViewModel::class.java)
        lifecycle.addObserver(viewModel)
        viewModel.getData().observe(this, Observer {

        })
    }

    override fun showMsg(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show()
    }
}
