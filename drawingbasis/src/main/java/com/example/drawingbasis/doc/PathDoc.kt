package com.example.drawingbasis.doc

import android.graphics.Path
import android.graphics.RectF

/**
 * 路径文档类，用于记录Path常用函数
 *
 * @author WangQingYi
 * @since  2022/1/21
 */
class PathDoc :Path(){

    /**
     * 画一条直线路径所用到的函数
     * @param x 直线X轴起点
     * @param y 直线Y轴起点
     */
    override fun moveTo(x: Float, y: Float) {
        super.moveTo(x, y)
    }

    /**
     * 画一条直线路径所用到的函数
     * xy是直线的终点，又是下一次绘制直线路径的起点，lineTo函数可以一直使用
     * @param x
     * @param y
     */
    override fun lineTo(x: Float, y: Float) {
        super.lineTo(x, y)
    }

    /**
     * 画弧线路径的函数
     * @param oval 生成椭圆的矩形
     * @param startAngle 弧开始的角度，以X轴正方向为0度
     * @param sweepAngle 弧持续的角度
     */
    override fun arcTo(oval: RectF, startAngle: Float, sweepAngle: Float) {
        super.arcTo(oval, startAngle, sweepAngle)
    }

    /**
     * 画弧线路径的函数
     * @param left Float
     * @param top Float
     * @param right Float
     * @param bottom Float
     * @param startAngle Float 弧开始的角度，以X轴正方向为0度
     * @param sweepAngle Float 弧持续的角度
     * @param forceMoveTo Boolean 是否强制将弧的起始点作为绘制起始位置
     */
    override fun arcTo(
        left: Float,
        top: Float,
        right: Float,
        bottom: Float,
        startAngle: Float,
        sweepAngle: Float,
        forceMoveTo: Boolean
    ) {
        super.arcTo(left, top, right, bottom, startAngle, sweepAngle, forceMoveTo)
    }

    /**
     * 添加一个矩形路径
     * @param rect RectF 矩形
     * @param dir Direction [Direction.CCW] 创建逆时针方向的矩形/[Direction.CW]创建顺时针方向的矩形路径
     */
    override fun addRect(rect: RectF, dir: Direction) {
        super.addRect(rect, dir)
    }

    /**
     * 添加矩形路径
     * @param left Float
     * @param top Float
     * @param right Float
     * @param bottom Float
     * @param dir Direction [Direction.CCW] 创建逆时针方向的矩形/[Direction.CW]创建顺时针方向的矩形路径
     */
    override fun addRect(left: Float, top: Float, right: Float, bottom: Float, dir: Direction) {
        super.addRect(left, top, right, bottom, dir)
    }

    /**
     * 添加圆角矩形路径
     * @param rect RectF
     * @param radii FloatArray 必须传入8个数值，分4组，分别对应每个角所使用的椭圆的横轴半径和纵轴半径
     * @param dir Direction 方向
     */
    override fun addRoundRect(rect: RectF, radii: FloatArray, dir: Direction) {
        super.addRoundRect(rect, radii, dir)
    }

    /**
     * 添加圆角矩形路径
     * 该函数只能构建统一的圆角大小
     * @param rect RectF
     * @param rx Float 生成圆角的椭圆的横轴半径
     * @param ry Float 生成圆角的椭圆的纵轴半径
     * @param dir Direction
     */
    override fun addRoundRect(rect: RectF, rx: Float, ry: Float, dir: Direction) {
        super.addRoundRect(rect, rx, ry, dir)
    }

    /**
     * 添加圆形路径
     * @param x Float 圆心X轴坐标
     * @param y Float 圆心Y轴坐标
     * @param radius Float 圆半径
     * @param dir Direction 方向
     */
    override fun addCircle(x: Float, y: Float, radius: Float, dir: Direction) {
        super.addCircle(x, y, radius, dir)
    }

    /**
     * 添加椭圆路径
     * @param oval RectF 生成椭圆的矩形
     * @param dir Direction 方向
     */
    override fun addOval(oval: RectF, dir: Direction) {
        super.addOval(oval, dir)
    }

    /**
     * 添加弧形路径
     * @param oval RectF 生成椭圆的矩形
     * @param startAngle Float 弧开始的角度，以X轴正方向为0度
     * @param sweepAngle Float 弧持续的角度
     */
    override fun addArc(oval: RectF, startAngle: Float, sweepAngle: Float) {
        super.addArc(oval, startAngle, sweepAngle)
    }

    /**
     * 添加弧形路径
     * @param left Float
     * @param top Float
     * @param right Float
     * @param bottom Float
     * @param startAngle Float
     * @param sweepAngle Float
     */
    override fun addArc(
        left: Float,
        top: Float,
        right: Float,
        bottom: Float,
        startAngle: Float,
        sweepAngle: Float
    ) {
        super.addArc(left, top, right, bottom, startAngle, sweepAngle)
    }

    /**
     * Path的填充模式
     * 是指填充Path的哪部份
     */
    private fun test() {
        // 默认值，当两个图形相交时，取相交部分显示
        FillType.WINDING
        // 取path所在并不相交的区域
        FillType.EVEN_ODD
        // 取path的外部区域
        FillType.INVERSE_WINDING
        // 取path的外部和相交区域
        FillType.INVERSE_EVEN_ODD
    }


    /**
     * 重置路径的方法
     * 类似于新建一个路径对象吗，它的左右数据空间都会被回收并重新分配，但不会清除FillType
     * 总结:不会清除内存，但会清除FillType
     */
    override fun reset() {
        super.reset()
    }

    /**
     * 重置路径的方法
     * 清除FilType以及所有的直线、曲线、点的数据等，但是会保留数据结构；可以实现快速重用，提高一定的性能。
     * 注意：只有在重复绘制相同的路径时，这些数据结构才是可以复用的
     * 总结:清除内存，但不会清除FillType
     */
    override fun rewind() {
        super.rewind()
    }



}