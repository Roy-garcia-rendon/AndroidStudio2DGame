package com.example.a2dgame;

import android.graphics.Canvas;
import android.view.SurfaceHolder;


class GameLoop extends Thread{
    private final Game game;
    private final SurfaceHolder surfaceHolder;
    private boolean isRunning = false;




    public GameLoop(Game game, SurfaceHolder surfaceHolder) {
       this.game = game;
       this.surfaceHolder = surfaceHolder;
    }

    public double getAverageUPS() {
        return 0;
    }

    public double getAverageFPS() {
        return 0;
    }

    public void startLoop() {
        isRunning = true;
        start();
    }

    @Override
    public void run() {
        super.run();

        //game loop
        Canvas canvas;
        while (isRunning){
            //try to update and render game
            try {
                canvas = surfaceHolder.lockCanvas();
                game.update();
                game.draw(canvas);
                surfaceHolder.unlockCanvasAndPost(canvas);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }


            //Pause game loop to not exceed target ups

            //skip frames to keep upo with target UPS

            //Calculate average UPS and FPS


        }
    }
}
