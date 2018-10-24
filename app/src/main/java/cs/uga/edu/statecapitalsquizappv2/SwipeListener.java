package cs.uga.edu.statecapitalsquizappv2;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class SwipeListener implements View.OnTouchListener {

    private GestureDetector gestureDetector;

    public SwipeListener(Context context){
        gestureDetector = new GestureDetector(context, new GestureListener());
    }

    public void onSwipeLeft(){

    }

    public void onSwipeRight(){

    }

    public boolean onTouch(View v, MotionEvent event){
        return gestureDetector.onTouchEvent(event);
    }

    private final class GestureListener extends GestureDetector.SimpleOnGestureListener {

        private static final int swipeDistanceMax = 100;
        private static final int swipeSpeedMax = 100;

        @Override
        public boolean onDown(MotionEvent e){
            return true;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY){
            float distanceX = e2.getX() - e1.getX();
            float distanceY = e2.getY() - e1.getY();
            if(Math.abs(distanceX) > Math.abs(distanceY) && Math.abs(distanceX) > swipeDistanceMax && Math.abs(velocityX) > swipeSpeedMax){
                if(distanceX > 0){
                    onSwipeRight();
                }else {
                    onSwipeLeft();
                }
                return true;
            }
            return false;
        }

    }

}
