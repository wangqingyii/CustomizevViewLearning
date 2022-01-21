package com.example.drawingbasis.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

/**
 * 判断手指点击位置是是否在区域内的View
 *
 * @author WangQingYi
 * @since  2022/1/21
 */
class RectPointView : View {

    private var mX: Int = 0

    private var mY: Int = 0

    private val mPaint = Paint().apply {
        style = Paint.Style.STROKE
        strokeWidth = 5F
    }

    private val mRect = Rect(100, 10, 300, 100)

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int)
            : super(context, attrs, defStyleAttr, defStyleRes)

    /**
     * 拦截手指的触屏时间
     * @param event MotionEvent
     */
    override fun onTouchEvent(event: MotionEvent): Boolean {
        // 获取到手指所在的位置
        mX = event.x.toInt()
        mY = event.y.toInt()
        // 判断当前手指是否在矩形区域内
        if (event.action == MotionEvent.ACTION_DOWN) {
            // 重绘控件 只能在主线程调用
            invalidate()
            // 返回true，表示当前控件已经在拦截(消费)这个消息了
            // 后续的ACTION_UP、ACTION_DOWN消息任然继续传过来
            return true
            // 判断用户手指弹起时，还原矩形颜色
        } else if (event.action == MotionEvent.ACTION_UP) {
            // 设为负值，由于矩形不包含坐标为负的点，所以还原了矩形的颜色
            mX = -1
            mY = -1
        }
        // 刷新控件屏幕，让控件重绘；此方法可以在任何线程中执行
        postInvalidate()
        return super.onTouchEvent(event)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // 是否手指在矩形区域内
        if (mRect.contains(mX, mY)) {
            mPaint.color = Color.RED
        } else {
            mPaint.color = Color.GREEN
        }
        canvas.drawRect(mRect, mPaint)
    }
}