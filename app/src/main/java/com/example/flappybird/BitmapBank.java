package com.example.flappybird;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapBank {
    Bitmap background_game;

    Bitmap [] bird;
    Bitmap topPipe, bottomPipe;


    public BitmapBank(Resources resources)
    {
        background_game = BitmapFactory.decodeResource(resources, R.drawable.background_game);
        background_game = scaleImage(background_game);
        bird = new Bitmap[4];

        bird [0] = BitmapFactory.decodeResource(resources, R.drawable.downflap);
        bird [1] = BitmapFactory.decodeResource(resources, R.drawable.midflap);
        bird [2] = BitmapFactory.decodeResource(resources, R.drawable.upflap);
        bird [3] = BitmapFactory.decodeResource(resources, R.drawable.midflap);

        for (int i = 0; i < bird.length; i++) {
            int width = (int) (bird[i].getWidth() * 2);  // Phóng to chiều rộng
            int height = (int) (bird[i].getHeight() * 2);  // Phóng to chiều cao
            bird[i] = Bitmap.createScaledBitmap(bird[i], width, height, false);  // Thay đổi kích thước
        }
        topPipe = BitmapFactory.decodeResource(resources, R.drawable.pipe_top);
        bottomPipe = BitmapFactory.decodeResource(resources, R.drawable.pipe_bottom);
    }

    public Bitmap getBird(int frame) {
        return bird[frame];
    }
    public int getBirdWidth(){
        return bird[0].getWidth();
    }

    public int getBirdHeight() {
        return bird[0].getHeight();
    }

    public Bitmap getTopPipe() {
        return topPipe;
    }

    public Bitmap getBottomPipe() {
        return bottomPipe;
    }

    public int getPipeWidth() {
        return topPipe.getWidth();
    }

    public int getPipeHeight() {
        return topPipe.getHeight();
    }

    public Bitmap getBackground_game(){
        return background_game;
    }

    public int getBackgroundWidth(){
        return background_game.getWidth();
    }

    public int getBackgroundHeight(){
        return background_game.getHeight();
    }

    public Bitmap scaleImage(Bitmap bitmap){
        float widthHeightRatio = getBackgroundWidth() / getBackgroundHeight();

        int backgroundScaleWidth = (int) widthHeightRatio * AppConstants.SCREEN_HEIGHT;

        return Bitmap.createScaledBitmap(bitmap, backgroundScaleWidth, AppConstants.SCREEN_HEIGHT, false);
    }
}
