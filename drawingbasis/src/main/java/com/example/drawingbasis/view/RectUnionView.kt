package com.example.drawingbasis.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View

/**
 * 合并两个矩形
 *
 * @author WangQingYi
 * @since  2022/1/21
 */
class RectUnionView : View {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

   private val mPaint = Paint().apply {
        color = Color.BLUE
        strokeWidth = 10F
        style = Paint.Style.STROKE
    }

   private val mRect1 = Rect(10, 10, 20, 20)

   private val mRect2 = Rect(100, 100, 110, 110)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // 分别画出源矩形
        canvas.drawRect(mRect1, mPaint)
        canvas.drawRect(mRect2, mPaint)

        // 画出合并之后的结果mRect1
        mPaint.color = Color.YELLOW
        mRect1.union(mRect2)
        canvas.drawRect(mRect1, mPaint)
    }
}