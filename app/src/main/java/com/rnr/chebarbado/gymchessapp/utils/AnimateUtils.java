package com.rnr.chebarbado.gymchessapp.utils;

import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

import com.rnr.chebarbado.gymchessapp.helper.SliderHelper;




/**
 * Created by Mete on 23.03.2016.
 */
public class AnimateUtils {

    private final static int mAnimationDuration = 200;
    private static float mAnimationTranslateXPosition;

    public static AnimationSet startSliderAnimation(final View view, SliderHelper.AnimationTypes animeType, float scaleSizeMultipler) {
        view.requestLayout();
        Animation scaleAnimation = null;
        Animation fadeOut = null;
        Animation translateAnimation = null;
        AnimationSet animationSet = new AnimationSet(false);
        switch (animeType) {
            case CENTER_TO_RIGHT:

                // Scale
                scaleAnimation = getScaleAnimation(1f, 1f / scaleSizeMultipler);
                // Translate
                translateAnimation = getTranslateXAnimation(mAnimationTranslateXPosition);
                break;
            case CENTER_TO_LEFT:

                // Scale
                scaleAnimation = getScaleAnimation(1f, 1f / scaleSizeMultipler);
                // Translate
                translateAnimation = getTranslateXAnimation(-1.0f * mAnimationTranslateXPosition);
                break;
            case LEFT_TO_CENTER:

                // Scale
                scaleAnimation = getScaleAnimation(1f, scaleSizeMultipler);
                // Translate
                translateAnimation = getTranslateXAnimation(mAnimationTranslateXPosition);
                break;
            case RIGHT_TO_CENTER:

                // Scale
                scaleAnimation = getScaleAnimation(1f, scaleSizeMultipler);
                // Translate
                translateAnimation = getTranslateXAnimation(-1.0f * mAnimationTranslateXPosition);
                break;
            case DISAPEAR:

                // Scale
                scaleAnimation = getScaleAnimation(1f, 0f);
                // Fade out
                fadeOut = new AlphaAnimation(1, 0);
                fadeOut.setInterpolator(new AccelerateInterpolator()); // and this
                fadeOut.setStartOffset(Animation.RELATIVE_TO_SELF);
                fadeOut.setDuration(Math.round(mAnimationDuration * 0.4f));
                break;
            case ARISE:

                // Scale
                scaleAnimation = getScaleAnimation(0f, 1f);
        }
        if (scaleAnimation != null) {
            animationSet.addAnimation(scaleAnimation);
        }
        if (translateAnimation != null) {
            animationSet.addAnimation(translateAnimation);
        }
        if (fadeOut != null) {
            animationSet.addAnimation(fadeOut);
        }
        animationSet.setFillAfter(true);
        view.setAnimation(animationSet);
        view.startAnimation(animationSet);

        return animationSet;
    }

    public static void startSliderSideButonAnimation(final View view, SliderHelper.ButtonTypes buttonTypes) {
        Animation[] animations;
        if (buttonTypes == SliderHelper.ButtonTypes.ANIMATON_BUTTON_LEFT) {
            animations = new Animation[]{
                    getTranslateXAnimation(-50.5f, 500),
                    getTranslateXAnimation(50.5f, 500)
            };
        } else {
            animations = new Animation[]{
                    getTranslateXAnimation(50.5f, 500),
                    getTranslateXAnimation(-50.5f, 500)
            };
        }

        final AnimationSet animationSet = addAnimations(animations);
        animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.startAnimation(animationSet);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        view.startAnimation(animationSet);
    }

    public static void setmAnimationTranslateXPosition(float animationTranslateXPosition) {
        AnimateUtils.mAnimationTranslateXPosition = animationTranslateXPosition;
    }

    public static void setAnimationDuration(float animationTranslateXPosition) {
        AnimateUtils.mAnimationTranslateXPosition = animationTranslateXPosition;
    }

    private static Animation getScaleAnimation(float from, float to) {
        Animation scale = new ScaleAnimation(from, to, from, to, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scale.setDuration(mAnimationDuration);     // animation duration in milliseconds
        scale.setFillAfter(true);    // If fillAfter is true, the transformation that this animation performed will persist when it is finished.

        return scale;
    }

    private static Animation getTranslateXAnimation(float toXDelta) {
        Animation translateAnimation = new TranslateAnimation(0.0f, toXDelta, 0.0f, 0.0f);
        translateAnimation.setDuration(mAnimationDuration);

        return translateAnimation;
    }

    private static Animation getScaleAnimation(float from, float to, int animationDuration) {
        Animation scale = new ScaleAnimation(from, to, from, to, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scale.setDuration(animationDuration);     // animation duration in milliseconds
        scale.setFillAfter(true);    // If fillAfter is true, the transformation that this animation performed will persist when it is finished.

        return scale;
    }

    private static Animation getTranslateXAnimation(float toXDelta, int animationDuration) {
        Animation translateAnimation = new TranslateAnimation(0.0f, toXDelta, 0.0f, 0.0f);
        translateAnimation.setDuration(animationDuration);

        return translateAnimation;
    }

    private static AnimationSet addAnimations(Animation[] animations) {
        AnimationSet animationSet = new AnimationSet(false);
        long totalAnimationDuration = 0;

        for (int i = 0; i < animations.length; i++) {
           
            Animation a = animations[i];
            a.setStartOffset(totalAnimationDuration);
            totalAnimationDuration += a.getDuration();
            animationSet.addAnimation(a);
        }

        return animationSet;
    }


}





















