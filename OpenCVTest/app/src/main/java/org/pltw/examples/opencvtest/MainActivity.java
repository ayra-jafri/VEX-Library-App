package org.pltw.examples.opencvtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.opencv.android.CameraBridgeViewBase;
import org.opencv.core.Mat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import java.io.*;
import java.lang.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity implements CameraBridgeViewBase.CvCameraViewListener2 {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public Mat onCameraFrame(CameraBridgeViewBase.CvCameraViewFrame inputFrame) {
        return null;
    }

    @Override
    public void onCameraViewStopped() {

    }

    @Override
    public void onCameraViewStarted(int width, int height) {

    }
}
