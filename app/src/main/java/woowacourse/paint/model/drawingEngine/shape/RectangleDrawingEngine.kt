package woowacourse.paint.model.drawingEngine.shape

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import woowacourse.paint.model.drawingEngine.ShapeDrawingEngin

data class RectangleDrawingEngine(
    override val paint: Paint = Paint(),
    override val rectF: RectF = RectF(),
) : ShapeDrawingEngin() {

    override fun draw(canvas: Canvas) {
        canvas.drawRect(rectF, paint)
    }
}
