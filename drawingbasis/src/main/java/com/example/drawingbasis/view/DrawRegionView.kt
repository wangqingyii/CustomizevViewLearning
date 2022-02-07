package com.example.drawingbasis.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.drawingbasis.doc.RegionIteratorDoc

/**
 * 展示自定义的绘制区域的View
 *
 * @author WangQingYi
 * @since  2022/2/7
 */
class DrawRegionView(context: Context, attrs: AttributeSet) : View(context, attrs) {

    private val mPaint = Paint().apply {
        color = Color.RED
        // 设置为描边，效果更好
        style = Paint.Style.STROKE
    }

    // 构建一条椭圆路径
    private val mOvalPath = Path().apply {
        val rect = RectF(50F, 50F, 200F, 500F)
        // 添加椭圆路径，逆时针方向
        addOval(rect, Path.Direction.CCW)
    }

    // 构造椭圆区域
    private val mRegion = Region().apply {
        setPath(mOvalPath, Region(50, 50, 200, 500))
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // 进行绘制
        // 从效果图中可以看出，在绘制Region对象时，先将其转换成矩形集，然后利用画笔将每个矩形画出来
        drawRegion(canvas, mRegion, mPaint)
    }

    /**
     * 自定义的,用于绘制区域的函数
     * 通过[RegionIteratorDoc]类构造矩形集来逼近显示区域
     * @param canvas 画布
     * @param region 区域
     * @param paint 画笔
     */
    private fun drawRegion(canvas: Canvas, region: Region, paint: Paint) {
        // 1.构造出区域的矩形集
        val regionIterator = RegionIteratorDoc(region)
        val rect = Rect()
        // 2.利用next()函数来逐个获取所有矩形并绘制出来
        while (regionIterator.next(rect)) {
            canvas.drawRect(rect, paint)
        }
    }
}