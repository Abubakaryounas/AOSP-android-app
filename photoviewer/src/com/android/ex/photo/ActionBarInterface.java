package com.android.ex.photo;

import android.graphics.drawable.Drawable;

import androidx.annotation.Nullable;


/**
 * Wrapper activity for an action bar. This wraps either a {@link android.app.ActionBar} or
 * {@link androidx.appcompat.app.ActionBar}.
 */
public interface ActionBarInterface {

    void setDisplayHomeAsUpEnabled(boolean showHomeAsUp);

    void addOnMenuVisibilityListener(OnMenuVisibilityListener listener);

    /**
     * Wrapper for {@code setDisplayOptions(ActionBar.DISPLAY_SHOW_TITLE,
     * ActionBar.DISPLAY_SHOW_TITLE)}.
     */
    void setDisplayOptionsShowTitle();

    @Nullable
    CharSequence getTitle();

    void setTitle(@Nullable CharSequence title);

    void setSubtitle(@Nullable CharSequence subtitle);

    void show();

    void hide();

    void setLogo(@Nullable Drawable logo);

    interface OnMenuVisibilityListener {
        /**
         * Called when an action bar menu is shown or hidden. Applications may want to use
         * this to tune auto-hiding behavior for the action bar or pause/resume video playback,
         * gameplay, or other activity within the main content area.
         *
         * @param isVisible True if an action bar menu is now visible, false if no action bar
         *                  menus are visible.
         */
        void onMenuVisibilityChanged(boolean isVisible);
    }
}
