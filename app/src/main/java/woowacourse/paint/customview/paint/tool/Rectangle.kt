package woowacourse.paint.customview.paint.tool

import android.graphics.Paint
import android.graphics.Path
import woowacourse.paint.customview.paint.Painting
import java.lang.Float.max
import java.lang.Float.min

class Rectangle(private val rectangleColor: Int) : PaintTool {

    override val painting: Painting = Painting(Path(), initPaint())

    private var startPointX = 0f
    private var startPointY = 0f
    private var currentPointX = 0f
    private var currentPointY = 0f

    private fun initPaint(): Paint {
        return Paint().apply {
            this.color = rectangleColor
            style = Paint.Style.FILL
        }
    }

    override fun prepare(pointX: Float, pointY: Float) {
        painting.path.moveTo(pointX, pointY)
        startPointX = pointX
        startPointY = pointY
    }

    override fun use(pointX: Float, pointY: Float) {
        painting.path.reset()
        currentPointX = pointX
        currentPointY = pointY

        val left = min(startPointX, currentPointX)
        val right = max(startPointX, currentPointX)
        val top = min(startPointY, currentPointY)
        val bottom = max(startPointY, currentPointY)

        painting.path.addRect(
            left,
            top,
            right,
            bottom,
            Path.Direction.CW,
        )
    }
}
