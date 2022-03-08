package com.example.drawingbasis.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View

/**
 * 屏幕与Canvas的关系
 * 知识点：P51
 *
 * @author WangQingYi
 * @since  2022/3/3
 */
class ScreenWithCanvasRelationshipView : View {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // 构造两个画笔，一个红色，一个绿色
        val paintGreen = generatePaint(Color.GREEN, Paint.Style.STROKE, 3)
        val paintRed = generatePaint(Color.RED, Paint.Style.STROKE, 3)
        // 构造一个矩形
        val rect1 = Rect(0, 0, 400, 200)
        // 平移画布前用绿色画笔画下边框
        canvas.drawRect(rect1, paintGreen)
        // 在平移画布后，再用红色画笔重新画下边框
        canvas.translate(100F, 100F)
        canvas.drawRect(rect1, paintRed)
    }

    private fun generatePaint(color: Int, style: Paint.Style, width: Int): Paint {
        return Paint().apply {
            setColor(color)
            setStyle(style)
            // 设置描边宽度
            strokeWidth = width.toFloat()
        }
    }

}