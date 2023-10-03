package woowacourse.paint

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import woowacourse.paint.model.line.Line
import woowacourse.paint.model.line.Lines
import woowacourse.paint.model.pen.Pen

class PaintView(
    context: Context,
    attributeSet: AttributeSet,
) : View(context, attributeSet) {

    private val lines: Lines = Lines()
    var pen: Pen = Pen.createDefaultPenInstance()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        drawCanvas(canvas)
    }

    private fun drawCanvas(canvas: Canvas) {
        lines.value.forEach {
            canvas.drawPath(it.path, it.paint)
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        val pointX: Float = event.x
        val pointY: Float = event.y

        when (event.action) {
            MotionEvent.ACTION_DOWN -> penDown(pointX, pointY)
            MotionEvent.ACTION_MOVE -> penMove(pointX, pointY)
            else -> super.onTouchEvent(event)
        }

        return true
    }

    private fun penDown(pointX: Float, pointY: Float) {
        val addedLine = addLine()
        addedLine.path.moveTo(pointX, pointY)
        penMove(pointX, pointY)
        invalidate()
    }

    private fun penMove(pointX: Float, pointY: Float) {
        lines.last().path.lineTo(pointX, pointY)
        invalidate()
    }

    private fun addLine(): Line {
        val paint = pen.getPaint()
        val addLine = Line(Path(), paint)
        lines.add(addLine)
        return addLine
    }
}
