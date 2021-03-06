package com.paolovalerdi.abbey.ui.fragments.player.blur

import android.graphics.Color
import android.view.View
import androidx.annotation.ColorInt
import com.paolovalerdi.abbey.R
import com.paolovalerdi.abbey.helper.PlayPauseButtonOnClickHandler
import com.paolovalerdi.abbey.model.Song
import com.paolovalerdi.abbey.ui.fragments.player.base.AbsPlaybackControlsFragment
import com.paolovalerdi.abbey.util.extensions.animateColoChanging
import com.paolovalerdi.abbey.util.extensions.animateColorChanging
import kotlinx.android.synthetic.main.fragment_blur_player_playback_controls.*


/**
 * @author Paolo Valerdi
 */
class BlurPlayerPlaybackControlsFragment : AbsPlaybackControlsFragment() {

    @ColorInt
    private var lastColor = -1

    override val layoutRes = R.layout.fragment_blur_player_playback_controls

    override fun initPlaybackControlsColor(): Int {
        volumeSliderFragment.setUpBaseBackgroundProgressColor()
        return Color.WHITE
    }

    override fun setUpPlayPauseButton(view: View) {
        playerPlayPauseFab.apply {
            setImageDrawable(playPauseDrawable)
            setOnClickListener(PlayPauseButtonOnClickHandler())
        }
    }

    override fun setColors(color: Int) {
        playerPlayPauseFab.animateColoChanging(lastColor, color)
        progressBar.animateColorChanging(lastColor, color)
        volumeSliderFragment.updateColor(lastColor, color)
        songInfo.animateColorChanging(lastColor, color)
        lastColor = color
    }

    override fun onCurrentSongChanged(song: Song) {
        songTitle.text = song.title
        songInfo.text = song.artistName
    }

}