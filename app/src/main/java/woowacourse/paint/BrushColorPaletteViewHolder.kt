package woowacourse.paint

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import woowacourse.paint.databinding.ItemColorPaletteBinding

class BrushColorPaletteViewHolder(
    private val binding: ItemColorPaletteBinding,
    colorClickListener: ColorClickListener,
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.colorClickListener = colorClickListener
    }

    fun bind(brushColorBox: BrushColorBox) {
        binding.brushColorBox = brushColorBox
    }

    companion object {
        fun from(
            parent: ViewGroup,
            onClickProduct: ColorClickListener,
        ): BrushColorPaletteViewHolder {
            val binding =
                ItemColorPaletteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return BrushColorPaletteViewHolder(binding, onClickProduct)
        }
    }
}