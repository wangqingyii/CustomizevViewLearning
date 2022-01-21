package com.example.drawingbasis.doc

import android.graphics.*

/**
 * 画布文档类，用于记录Canvas类主要函数
 *
 * @author WangQingYi
 * @since  2022/1/19
 */
class CanvasDoc : Canvas() {
    val mCanvas = Canvas()
    /****************************************** 画布 **********************************************/
    /**
     * 设置画布背景
     * @param color 填充色
     */
    override fun drawColor(color: Int) {
        super.drawColor(color)
    }

    /**
     * 设置画布背景
     * @param a Int Alpha
     * @param r Int Red
     * @param g Int Green
     * @param b Int Blue
     */
    override fun drawARGB(a: Int, r: Int, g: Int, b: Int) {
        super.drawARGB(a, r, g, b)
    }

    /**
     * 用于设置画布背景
     * 透明度Alpha的取值固定为255
     * @param r Int Red
     * @param g Int Green
     * @param b Int Blue
     */
    override fun drawRGB(r: Int, g: Int, b: Int) {
        super.drawRGB(r, g, b)
    }

    /****************************************** 线 ************************************************/
    /**
     * 画直线
     * @param startX 起始点X坐标
     * @param startY 起始点Y坐标
     * @param stopX 终点X坐标
     * @param stopY 终点Y坐标
     * @param paint Paint 画笔
     */
    override fun drawLine(startX: Float, startY: Float, stopX: Float, stopY: Float, paint: Paint) {
        super.drawLine(startX, startY, stopX, stopY, paint)
    }

    /**
     * 画多条直线
     * @param pts 点的集合
     * @param paint Paint 画笔
     */
    override fun drawLines(pts: FloatArray, paint: Paint) {
        super.drawLines(pts, paint)
    }

    /**
     * 画多条直线构造函数二
     * @param offset 集合中跳过的数值个数。注意不是点的个数！一个点有两个数值
     * @param count 参与绘制的数值个数，指pts数组中数值的个数，而不是点的个数，因为一个点有两个数值
     * @param paint Paint 画笔
     */
    override fun drawLines(pts: FloatArray, offset: Int, count: Int, paint: Paint) {
        super.drawLines(pts, offset, count, paint)
    }

    /******************************************** 点 **********************************************/
    /**
     * 画点
     * @param x 点X坐标
     * @param y 点Y坐标
     * @param paint Paint 画笔
     */
    override fun drawPoint(x: Float, y: Float, paint: Paint) {
        super.drawPoint(x, y, paint)
    }

    /**
     * 画多个点
     * @param pts 点的集合
     * @param offset 集合中跳过的数值个数
     * @param count 参与绘制的数值个数
     */
    override fun drawPoints(pts: FloatArray?, offset: Int, count: Int, paint: Paint) {
        super.drawPoints(pts, offset, count, paint)
    }

    /******************************************* 矩形 *********************************************/
    /**
     * 画一个矩形
     * 传入四个点来绘制矩形
     * @param left Float 第一个点的X坐标
     * @param top  Float 第一个点的Y坐标
     * @param right  Float 第二个点的X坐标
     * @param bottom Float 第二个点的Y坐标
     * @param paint  Paint 画笔
     */
    override fun drawRect(left: Float, top: Float, right: Float, bottom: Float, paint: Paint) {
        super.drawRect(left, top, right, bottom, paint)
    }

    /**
     * RectF方式画矩形
     * @param rect RectF实例
     * @param paint 画笔
     */
    override fun drawRect(rect: RectF, paint: Paint) {
        super.drawRect(rect, paint)
    }

    /**
     * Rect方式画矩形
     * @param r Rect实例
     * @param paint 画笔
     */
    override fun drawRect(r: Rect, paint: Paint) {
        super.drawRect(r, paint)
    }

    /******************************************* 圆角矩形 ******************************************/
    /**
     * 圆角矩形
     * Android 在生成矩形的圆角时，其实利用的是椭圆。圆角矩形的圆角其实是有椭圆的一角形成的
     * 与shape标签不同的是，drawRoundRect()函数不能针对没个角设置对应的椭圆，只能统一设置4个角对应的圆角
     * @param rect 要绘制的矩形
     * @param rx 生成圆角的椭圆的X轴半径
     * @param ry 生成圆角椭圆的Y轴半径
     * @param paint 画笔
     */
    override fun drawRoundRect(rect: RectF, rx: Float, ry: Float, paint: Paint) {
        super.drawRoundRect(rect, rx, ry, paint)
    }

    /****************************************** 圆形 **********************************************/
    /**
     * 画圆形
     * @param cx 圆心点的X轴坐标
     * @param cy 圆心点的Y轴坐标
     * @param radius 圆的半径
     * @param paint 画笔
     */
    override fun drawCircle(cx: Float, cy: Float, radius: Float, paint: Paint) {
        super.drawCircle(cx, cy, radius, paint)
    }

    /******************************************** 椭圆 ********************************************/
    /**
     * 画椭圆
     * 椭圆是根据矩形生成的，以矩形的长为椭圆的X轴，以矩形的宽为椭圆的Y轴
     * @param oval 用于生成椭圆的矩形
     * @param paint 画笔
     */
    override fun drawOval(oval: RectF, paint: Paint) {
        super.drawOval(oval, paint)
    }

    /**
     * 用于理解椭圆与矩形的关系
     * 针对同一个矩形，先把它的矩形区域画出来，然后再把根据这个矩形生成的椭圆画出来
     */
    fun ovalTest() {
        val paint6 = Paint().apply {
            color = Color.RED
            style = Paint.Style.STROKE
            strokeWidth = 5F
        }
        val rect3 = RectF(100F, 10F, 300F, 100F)
        mCanvas.drawRect(rect3, paint6)
        paint6.color = Color.GREEN
        // 根据同一个矩形画椭圆
        mCanvas.drawOval(rect3, paint6)
    }

    /********************************************* 弧 *********************************************/
    /**
     * 画弧
     * 弧是椭圆的一部分，而椭圆是根据矩形来生成的，所以弧也是根据矩形来生成的
     * @param oval 生成椭圆的矩形
     * @param startAngle 弧开始的角度，以X轴正方向为0度
     * @param sweepAngle 弧持续的角度
     * @param useCenter 是否有弧的两边。为true时，表示带有两边；为false时，只有一条弧
     * @param paint 画笔
     */
    override fun drawArc(
        oval: RectF,
        startAngle: Float,
        sweepAngle: Float,
        useCenter: Boolean,
        paint: Paint
    ) {
        super.drawArc(oval, startAngle, sweepAngle, useCenter, paint)
    }

    fun arcTest() {
        val paint6 = Paint().apply {
            color = Color.RED
            style = Paint.Style.STROKE
            strokeWidth = 5F
        }
        // 带两边
        val rectF1 = RectF(10F, 10F, 100F, 100F)
        mCanvas.drawArc(rectF1, 0F, 90F, true, paint6)

        // 不带两边
        val rectF2 = RectF(110F, 10F, 200F, 100F)
        mCanvas.drawArc(rectF2, 0F, 90F, false, paint6)
    }
}