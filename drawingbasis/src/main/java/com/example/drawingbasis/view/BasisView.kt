package com.example.drawingbasis.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class BasisView : View {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //  设置画笔颜色置画笔的基本属性
        val paint = Paint().apply {
            // 设置画笔颜色
            color = Color.RED
            // 设置填充样式
            style = Paint.Style.STROKE
            // 设置画笔宽度
            strokeWidth = 50F
            // 打开抗锯齿
            isAntiAlias = true
        }
        // 画圆
        canvas.drawCircle(190F, 200F, 150F, paint)

        // 叠加圆
        val paint2 = Paint().apply {
            color = 0xFFFF0000.toInt()
            style = Paint.Style.FILL
            strokeWidth = 50F
        }
        canvas.drawCircle(190f, 500F, 150F, paint2)
        paint2.color = 0x7EFFFF00.toInt()
        canvas.drawCircle(190F, 500F, 100F, paint2)

        // 画点
        val paint3 = Paint().apply {
            color = Color.BLACK
            strokeWidth = 20f
        }
        canvas.drawPoint(10F, 10F, paint3)
        /**
         * 画矩形
         */
        // 直接构造
        val paint4 = Paint().apply {
            color = Color.RED
            style = Paint.Style.FILL
            strokeWidth = 15F
        }
        canvas.drawRect(10F, 10F, 100F, 100F, paint4)
        // 使用RectF构造
        paint4.style = Paint.Style.FILL
        val rect = RectF(210F, 10F, 300F, 100F)
        canvas.drawRect(rect, paint4)
        /**
         * 圆角矩形
         */
        val paint5 = Paint().apply {
            color = Color.RED
            style = Paint.Style.FILL
            strokeWidth = 15F
        }
        val rect2 = RectF(100F, 10F, 300F, 100F)
        canvas.drawRoundRect(rect2, 20F, 10F, paint5)

        /**
         * 椭圆
         */
        val paint6 = Paint().apply {
            color = Color.RED
            style = Paint.Style.STROKE
            strokeWidth = 5F
        }
        val rect3 = RectF(100F, 10F, 300F, 100F)
        canvas.drawRect(rect3, paint6)
        paint6.color = Color.GREEN
        // 根据同一个矩形画椭圆
        canvas.drawOval(rect3, paint6)
        // 带两边
        val rectF1 = RectF(10F, 10F, 100F, 100F)
        canvas.drawArc(rectF1, 0F, 90F, true, paint6)

        // 不带两边
        val rectF2 = RectF(110F, 10F, 200F, 100F)
        canvas.drawArc(rectF2, 0F, 90F, false, paint6)

        /**
         * 文字
         */
        val paint7 = Paint().apply {
            color = Color.RED
            strokeWidth = 5F
            isAntiAlias = true
            textSize = 30F
            style = Paint.Style.FILL
            // 设置为粗体
            isFakeBoldText = true
            // 设置下划线
            isUnderlineText = true
            // 设置带有删除线效果
            isStrikeThruText = true
            textSkewX = -0.25F
        }
        canvas.drawText("床前明月光", 10F, 100F, paint7)

        /**
         * 沿路径绘制文字
         */
        val paint8 = Paint().apply {
            color = Color.RED
            strokeWidth = 5F
            textSize = 45F
            style = Paint.Style.STROKE
        }
        // 先创建两条相同的圆形路径，并画出两条路径原型
        val circlePath = Path().apply {
            // 逆向绘制
            addCircle(220F, 300F, 150F, Path.Direction.CCW)
        }
        // 绘制出路径原型
        canvas.drawPath(circlePath, paint8)

        val circlePath2 = Path().apply {
            // 逆向绘制
            addCircle(220F, 300F, 150F, Path.Direction.CCW)
        }
        // 绘制出路径原型
        canvas.drawPath(circlePath2, paint8)

        // 绘制原始文字与偏移文字
        val string = "床前明月光，疑是地下霜"
        paint8.color = Color.GREEN
        // 将hOffset、vOffset参数值全部设为0，看原始状态是怎样的
//        canvas.drawTextOnPath(string, circlePath, 0F, 0F, paint8)
        // 第二条路径改变将hOffset、vOffset参数值
        canvas.drawTextOnPath(string, circlePath2, 80F, 30F, paint8)
    }
}