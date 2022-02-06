package com.example.drawingbasis.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

/**
 * 画一个蜘蛛网状图
 *
 * @author WangQingYi
 * @since  2022/1/24
 */
class SpiderWebView : View {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    /**
     * 绘制网格
     */
    private val mRadarPaint = Paint().apply {
        // 描边
        style = Paint.Style.STROKE
        color = Color.GREEN
        strokeWidth = 2F
    }

    /**
     * 绘制结果图
     */
    private val mValuePaint = Paint().apply {
        // 填充
        style = Paint.Style.FILL
        color = Color.BLUE
    }

    /**
     * 网格最大半径
     */
    private var mRadius: Float = 0F

    /**
     * 中心X
     */
    private var mCenterX: Float = 0F

    /**
     * 中心Y
     */
    private var mCenterY: Float = 0F

    /**
     * 数据个数
     */
    private var mCount = 6

    /**
     * 每个夹角的度数
     */
    private val mAngle = ((Math.PI * 2) / mCount).toFloat()

    /**
     * 数据图数据
     */
    private val mData = arrayOf(2F, 5F, 1F, 6F, 4F, 5F)

    /**
     * 最大值
     */
    private val mMaxValue = 6
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // 画蜘蛛网
        drawPolygon(canvas)
        // 画网格中心线
        drawLines(canvas)
        // 绘制数据图
        drawRegion(canvas)
    }

    /**
     * 重写该函数 根据View的长、宽，获取整个布局的中心坐标
     */
    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        mRadius = Math.min(h, w) / 2 * 0.9f
        // 中心坐标
        mCenterX = w / 2F
        mCenterY = h / 2F
        postInvalidate()
        super.onSizeChanged(w, h, oldw, oldh)
    }

    /**
     * 画蜘蛛网
     */
    private fun drawPolygon(canvas: Canvas) {
        val path = Path()
        // r是蜘蛛丝之间的间距
        val r = mRadius / mCount
        // 中心点不用绘制
        (1..6).forEach { it1 ->
            // 当前半径
            val curR = r * it1
            path.reset()
            (0 until 6).forEach { it2 ->
                if (it2 == 0) {
                    path.moveTo(mCenterX + curR, mCenterY)
                } else {
                    // 根据半径计算出蜘蛛丝上每个点的坐标
                    val x: Float = (mCenterX + curR * Math.cos(mAngle.toDouble() * it2)).toFloat()
                    val y: Float = (mCenterY + curR * Math.sin(mAngle.toDouble() * it2)).toFloat()
                    path.lineTo(x, y)
                }
            }
            // 闭合路径
            path.close()
            canvas.drawPath(path, mRadarPaint)
        }
    }

    /**
     * 画网格中线
     */
    private fun drawLines(canvas: Canvas) {
        val path = Path()
        (1..6).forEach {
            path.reset()
            path.moveTo(mCenterX, mCenterY)
            val x: Float = (mCenterX + mRadius * Math.cos(mAngle.toDouble() * it)).toFloat()
            val y: Float = (mCenterY + mRadius * Math.sin(mAngle.toDouble() * it)).toFloat()
            path.lineTo(x, y)
            canvas.drawPath(path, mRadarPaint)
        }
    }

    /**
     * 画数据图
     */

    private fun drawRegion(canvas: Canvas) {
        val path = Path()
        mValuePaint.alpha = 127
        (0 until mCount).forEach {
            val percent = mData[it] / mMaxValue
            val x = (mCenterX + mRadius * Math.cos(mAngle.toDouble() * it) * percent).toFloat()
            val y = (mCenterY + mRadius * Math.sin(mAngle.toDouble() * it) * percent).toFloat()
            if (it == 0) {
                path.moveTo(x, mCenterY)
            } else {
                path.lineTo(x, y)
            }
            // 绘制小圆点
            canvas.drawCircle(x, y, 10F, mValuePaint)
        }
        // 绘制填充区域
        mValuePaint.style = Paint.Style.FILL_AND_STROKE
        canvas.drawPath(path, mValuePaint)
    }
}