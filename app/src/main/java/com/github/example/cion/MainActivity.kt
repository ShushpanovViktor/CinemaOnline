package com.github.example.cion

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.example.cion.base.nav.MoviesNavigator
import com.github.example.cion.base.nav.Screens
import com.github.example.cion.base.nav.listeners.BackButtonListener
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router

import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private val navigatorHolder by inject<NavigatorHolder>()
    private val navigator: Navigator = MoviesNavigator(this, R.id.fragmentContainerView)
    private val router by inject<Router>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigatorHolder.setNavigator(navigator)
        router.newRootScreen(Screens.movieListScreen())
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        val fragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView)
        if (fragment != null && fragment is BackButtonListener
            && (fragment as BackButtonListener).onBackPressed()
        ) {
            return
        } else {
            super.onBackPressed()
        }
    }
}