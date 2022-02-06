package com.example.drawingbasis.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

/**
 * 画一个三角形
 *
 * @author WangQingYi
 * @since  2022/1/21
 */
class TriangleView : View {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private val mPaint = Paint().apply {
        color = Color.RED
        // 填充样式设置为描边
        style = Paint.Style.STROKE
        strokeWidth = 5F
    }

    private val mPath = Path().apply {
        // 设置起始点
        moveTo(10F, 10F)
        // 第一条直线的终点，也是第二条直线的起始点
        lineTo(10F, 100F)
        // 画第二条直线
        lineTo(300F, 100F)
        // 闭环
        close()
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawPath(mPath, mPaint)
    }
}