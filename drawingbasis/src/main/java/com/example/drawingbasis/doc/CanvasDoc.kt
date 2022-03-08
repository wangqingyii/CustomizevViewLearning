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

    /******************************************** 文本 ********************************************/

    /**
     * 绘制文字
     * @param text 要绘制的字符串
     * @param x X轴起始点坐标
     * @param y Y轴起始点坐标
     * @param paint 画笔
     */
    override fun drawText(text: String, x: Float, y: Float, paint: Paint) {
        super.drawText(text, x, y, paint)
    }

    /**
     * 绘制文字
     * @param text 要绘制的字符串
     * @param index 指定其实绘制字符所在的位置
     * @param count 指定从起始绘制字符所在字符串中的索引
     * @param x X轴起始点坐标
     * @param y Y轴起始点坐标
     * @param paint 画笔
     */

    override fun drawText(
        text: CharArray,
        index: Int,
        count: Int,
        x: Float,
        y: Float,
        paint: Paint
    ) {
        super.drawText(text, index, count, x, y, paint)
    }

    /**
     * 绘制文字
     * @param text 要绘制的字符串
     * @param start 表示起始绘制字符所在字符串中的索引
     * @param end 表示结束绘制字符所在字符串中的索引
     * @param x X轴起始点坐标
     * @param y Y轴起始点坐标
     * @param paint 画笔
     */
    override fun drawText(text: String, start: Int, end: Int, x: Float, y: Float, paint: Paint) {
        super.drawText(text, start, end, x, y, paint)
    }

    /**
     * 绘制文字
     * @param text 要绘制的字符串
     * @param start 表示起始绘制字符所在字符串中的索引
     * @param end 表示结束绘制字符所在字符串中的索引
     * @param x X轴起始点坐标
     * @param y Y轴起始点坐标
     * @param paint 画笔
     */
    override fun drawText(
        text: CharSequence,
        start: Int,
        end: Int,
        x: Float,
        y: Float,
        paint: Paint
    ) {
        super.drawText(text, start, end, x, y, paint)
    }

    /**
     * 沿路径绘制
     * @param text 要绘制的字符串
     * @param index 指定其实绘制字符所在的位置
     * @param count 指定从起始绘制字符所在字符串中的索引
     * @param path 路径
     * @param hOffset 与路径起始点的水平偏移量
     * @param vOffset 与路径中心的垂直偏移量
     * @param paint 画笔
     */
    override fun drawTextOnPath(
        text: CharArray,
        index: Int,
        count: Int,
        path: Path,
        hOffset: Float,
        vOffset: Float,
        paint: Paint
    ) {
        super.drawTextOnPath(text, index, count, path, hOffset, vOffset, paint)
    }

    /**
     * 沿路径绘制
     * @param text 要绘制的字符串
     * @param path 路径
     * @param hOffset 与路径起始点的水平偏移量
     * @param vOffset 与路径中心的垂直偏移量
     * @param paint 画笔
     */
    override fun drawTextOnPath(
        text: String,
        path: Path,
        hOffset: Float,
        vOffset: Float,
        paint: Paint
    ) {
        super.drawTextOnPath(text, path, hOffset, vOffset, paint)
    }

    /******************************************** Canvas变换 ********************************************/

    /**
     * 平移
     * @param dx 水平方向平移的距离，正数为向正方向(向右)平移的量，负数为负方向(向左)平移的量
     * @param dy 垂直方向平移的距离，正数为向正方向(向下)平移的量，负数为负方向(向上)平移的量
     */
    override fun translate(dx: Float, dy: Float) {
        super.translate(dx, dy)
    }

    /**
     * 旋转
     * 画布的旋转默认是围绕坐标原点来进行的，实际旋转的画布
     * @param degrees 旋转的度数，正式指顺时针旋转，负数指逆时针旋转，它的旋转中心点是原点(0,0)
     */
    override fun rotate(degrees: Float) {
        super.rotate(degrees)
    }
    /**
     * 旋转
     * @param degrees 旋转的度数，正式指顺时针旋转，负数指逆时针旋转，它的旋转中心点是原点(0,0)
     * @param px 中心点X轴坐标
     * @param py 中心点Y轴坐标
     */
//     fun rotate(degrees: Float, px: Float, py: Float) {
//        throw RuntimeException("Stub!")
//    }
    /**
     * 缩放
     * 该函数用于变更坐标轴密度
     * @param sx 水平方向伸缩的比例。假设原坐标轴的比例为n，不变时为1，变更后的X轴密度为n*sx。所以sx是小数表示缩小，sx是整数表示放大
     * @param sy 垂直方向伸缩的比例，同样，sy为小数表示缩小，sy为整数表示放大
     */
    override fun scale(sx: Float, sy: Float) {
        super.scale(sx, sy)
    }

    /**
     * 扭曲
     * @param sx 将画布在X轴方向上倾斜相应的角度，sx为倾斜角度的正切值
     * @param sy 将画布在Y轴方向上倾斜相应的角度，sy为倾斜角度的正切值
     */
    override fun skew(sx: Float, sy: Float) {
        super.skew(sx, sy)
    }

    /**
     * 裁剪画布(clip系列函数)
     * 注意：在使用clip系列函数时，需要禁用硬件加速功能呢
     */
    override fun clipRect(rect: RectF, op: Region.Op): Boolean {
        return super.clipRect(rect, op)
    }

    /**
     * 每次调用save函数，都会先保存当前画布状态，然后将其放入特定的栈中
     * 示例：[SaveAndRestore]
     */
    override fun save(): Int {
        return super.save()
    }

    /**
     * 每次调用restore函数，都会把栈顶中顶层的画布状态取出来，并按照这个状态回复当前的画布，然后在这个画布上作画
     */
    override fun restore() {
        super.restore()
    }

    /**
     * 查找指定画布
     * @param saveCount
     */
    override fun restoreToCount(saveCount: Int) {
        super.restoreToCount(saveCount)
    }


}