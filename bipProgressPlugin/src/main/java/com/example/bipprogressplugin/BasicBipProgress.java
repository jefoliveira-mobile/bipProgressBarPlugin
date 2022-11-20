package com.example.bipprogressplugin;



import com.audiodemo.main.AudioBipHelper;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.metal.MetalProgressBarUI;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


public class BasicBipProgress extends MetalProgressBarUI {

    AudioBipHelper mAudioBipHelper = new AudioBipHelper();

    public BasicBipProgress() {
        super();
    }

    @SuppressWarnings({"MethodOverridesStaticMethodOfSuperclass", "UnusedDeclaration"})
    public static ComponentUI createUI(JComponent c) {
        return new BasicBipProgress();
    }

    @Override
    public void paintDeterminate(Graphics g, JComponent c) {
        super.paintDeterminate(g, c);
        mAudioBipHelper.registerProgressThread();
    }

    @Override
    public void paintIndeterminate(Graphics g, JComponent c) {
        super.paintIndeterminate(g, c);
        mAudioBipHelper.registerProgressThread();
    }


    @Override
    protected void installListeners() {
        super.installListeners();
        progressBar.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
            }

            @Override
            public void componentHidden(ComponentEvent e) {
                super.componentHidden(e);
            }
        });
    }


}
