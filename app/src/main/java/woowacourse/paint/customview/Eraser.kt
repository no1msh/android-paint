package woowacourse.paint.customview

import android.graphics.Paint
import android.graphics.Path
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode

class Eraser(private val thickness: Float) : PaintTool {
    override val stroke: Stroke = Stroke(Path(), initPaint())

    private fun initPaint(): Paint {
        return Paint().apply {
            xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
            strokeWidth = thickness
            strokeJoin = Paint.Join.ROUND
            strokeCap = Paint.Cap.ROUND
            style = Paint.Style.STROKE
        }
    }

    override fun prepare(pointX: Float, pointY: Float) {
        stroke.path.moveTo(pointX, pointY)
    }

    override fun use(pointX: Float, pointY: Float) {
        stroke.path.lineTo(pointX, pointY)
    }
}
