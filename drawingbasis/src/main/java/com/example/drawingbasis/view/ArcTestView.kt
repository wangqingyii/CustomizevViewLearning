package com.example.drawingbasis.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.graphics.Path
import android.graphics.RectF

/**
 * 画弧线
 *
  * @author WangQingYi
 * @since  2022/1/21
 */
class ArcTestView : View {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private val mPath = Path().apply {
        // 画起始点
        moveTo(10F, 10F)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val paint = Paint()
        val rectF = RectF(100F, 10F, 200F, 100F)
        mPath.arcTo(rectF, 0F, 90F)

        canvas.drawPath(mPath, paint)
    }
}