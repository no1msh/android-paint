package woowacourse.paint

import android.view.View
import androidx.annotation.ColorRes
import androidx.databinding.BindingAdapter
import com.google.android.material.slider.RangeSlider

object BindingAdapter {
    @JvmStatic
    @BindingAdapter("isVisible")
    fun isVisible(view: View, isVisible: Boolean) {
        when (isVisible) {
            true -> view.visibility = View.VISIBLE
            false -> view.visibility = View.INVISIBLE
        }
    }

    @JvmStatic
    @BindingAdapter("setBackgroundColorRes")
    fun setBackgroundColorRes(view: View, @ColorRes colorRes: Int) {
        view.setBackgroundResource(colorRes)
    }

    @JvmStatic
    @BindingAdapter("rangeSliderCurrentValue")
    fun setRangeSliderCurrentValue(rangeSlider: RangeSlider, value: Float) {
        rangeSlider.setValues(value)
    }
}