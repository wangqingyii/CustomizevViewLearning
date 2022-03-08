package com.example.drawingbasis.view

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import com.example.drawingbasis.R

/**
 * 示例圆形头像
 *
 * @author WangQingYi
 * @since  2022/3/4
 */
class CustomCircleView : View {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        init()
    }
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private val mBmp = BitmapFactory.decodeResource(resources, R.drawable.android_kotlin)

    private val mPaint = Paint()

    private val mPath = Path()

    private fun init() {
        // 在使用clip系列函数时，要禁用硬件加速功能
        setLayerType(LAYER_TYPE_SOFTWARE, null)
        val width = mBmp.width
        val height = mBmp.height
        // 添加圆形路径
        mPath.addCircle(width / 2F, height / 2F, width / 2F, Path.Direction.CCW)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.run {
            // 先保存画布的状态
            save()
            // 将画布裁切成圆形
            clipPath(mPath)
            // 将位图画上去
            drawBitmap(mBmp, 0F, 0F, mPaint)
            // 将画布复原
            // 由于我们后续没有对画布进行其他的操作  所以这里的restore()也可以不调用
            restore()
        }
    }
}