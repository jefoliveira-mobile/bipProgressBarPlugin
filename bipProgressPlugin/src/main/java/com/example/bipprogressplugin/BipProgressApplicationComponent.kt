package com.example.bipprogressplugin

import com.intellij.ide.ui.LafManagerListener
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.util.Disposer
import javax.swing.UIManager


class BipProgressApplicationComponent constructor() {

    init {
        ApplicationManager.getApplication().messageBus.connect(Disposer.newDisposable())
            .subscribe(LafManagerListener.TOPIC, LafManagerListener {
                updateBipProgressBar()
            })
    }
    private fun updateBipProgressBar() {
        UIManager.put("ProgressBarUI", BasicBipProgress::class.java.name)
        UIManager.getDefaults()[BasicBipProgress::class.java.name] = BasicBipProgress::class.java
    }
}

