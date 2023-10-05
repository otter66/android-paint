package woowacourse.paint.model.shape

import android.graphics.Paint
import android.graphics.Path

data class Line(
    val path: Path,
    val paint: Paint,
) : Shape {
    constructor(paint: Paint) : this(Path(), paint)
    constructor() : this(Path(), Paint())
}