package com.android.ex.photo;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.loader.content.Loader;

import com.android.ex.photo.adapters.PhotoPagerAdapter;
import com.android.ex.photo.fragments.PhotoViewFragment;
import com.android.ex.photo.loaders.PhotoBitmapLoaderInterface.BitmapResult;

public interface PhotoViewCallbacks {

    int BITMAP_LOADER_AVATAR = 1;
    int BITMAP_LOADER_THUMBNAIL = 2;
    int BITMAP_LOADER_PHOTO = 3;

    void addScreenListener(int position, OnScreenListener listener);

    void removeScreenListener(int position);

    void addCursorListener(CursorChangedListener listener);

    void removeCursorListener(CursorChangedListener listener);

    void setViewActivated(int position);

    void onNewPhotoLoaded(int position);

    void onFragmentPhotoLoadComplete(PhotoViewFragment fragment,
                                     boolean success);

    void toggleFullScreen();

    boolean isFragmentActive(Fragment fragment);

    void onFragmentVisible(PhotoViewFragment fragment);

    boolean isFragmentFullScreen(Fragment fragment);

    void onCursorChanged(PhotoViewFragment fragment, Cursor cursor);

    Loader<BitmapResult> onCreateBitmapLoader(int id, Bundle args, String uri);

    /**
     * Returns the adapter associated with this activity.
     */
    PhotoPagerAdapter getAdapter();

    /**
     * Listener to be invoked for screen events.
     */
    interface OnScreenListener {

        /**
         * The full screen state has changed.
         */
        void onFullScreenChanged(boolean fullScreen);

        /**
         * A new view has been activated and the previous view de-activated.
         */
        void onViewActivated();

        /**
         * This view is a candidate for being the next view.
         * <p>
         * This will be called when the view is focused completely on the view immediately before
         * or after this one, so that this view can reset itself if nessecary.
         */
        void onViewUpNext();

        /**
         * Called when a right-to-left touch move intercept is about to occur.
         *
         * @param origX the raw x coordinate of the initial touch
         * @param origY the raw y coordinate of the initial touch
         * @return {@code true} if the touch should be intercepted.
         */
        boolean onInterceptMoveLeft(float origX, float origY);

        /**
         * Called when a left-to-right touch move intercept is about to occur.
         *
         * @param origX the raw x coordinate of the initial touch
         * @param origY the raw y coordinate of the initial touch
         * @return {@code true} if the touch should be intercepted.
         */
        boolean onInterceptMoveRight(float origX, float origY);
    }

    interface CursorChangedListener {
        /**
         * Called when the cursor that contains the photo list data
         * is updated. Note that there is no guarantee that the cursor
         * will be at the proper position.
         *
         * @param cursor the cursor containing the photo list data
         */
        void onCursorChanged(Cursor cursor);
    }
}
