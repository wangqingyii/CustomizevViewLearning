package com.example.drawingbasis.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View

/**
 * save()、restore()函数示例
 *
 * @author WangQingYi
 * @since  2022/3/4
 */
class SaveAndRestore : View {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.apply {
            // 保存的画布大小为全屏幕大小
            save()
            clipRect(Rect(100, 100, 800, 800))
            drawColor(Color.GREEN)
            // 保存的画布大小为Rect(100,100,800,800)
            save()
            clipRect(Rect(200, 200, 700, 700))
            drawColor(Color.BLUE)
            // 保存的画布大小为Rect(200, 200, 700, 700)
            save()
            clipRect(Rect(300, 300, 600, 600))
            drawColor(Color.BLACK)
            // 保存的画布大小为Rect(300, 300, 600, 600)
            save()
            clipRect(Rect(400, 400, 500, 500))
            drawColor(Color.WHITE)

            // 将栈顶的画布状态取出来，作为当前画布，并填充黄色
            restore()
            drawColor(Color.YELLOW)
            // 连续三次出栈，将最后一次出栈的画布状态作为当前画布，并填充为黄色
            restore()
            restore()
            restore()
            drawColor(Color.YELLOW)
        }
    }
}