package com.example.drawingbasis.doc

import android.graphics.Rect
import android.graphics.RectF

/**
 * 矩形文档类，用于记录RectF、Rect常用函数
 * 由于Rect无法被继承 就写在这个类中 而又因为两个类的函数基本相同，所以相同部分拿RectF来举例
 *
 * @author WangQingYi
 * @since  2022/1/19
 */
class RectDoc : RectF {

    constructor() : super()
    constructor(r: RectF?) : super(r)
    constructor(r: Rect?) : super(r)

    /**
     *  一般用来构造矩形类实例最常用的还是该构造方法
     * 根据四个点构造除一个矩形
     * @param left Float
     * @param top Float
     * @param right Float
     * @param bottom Float
     */
    constructor(left: Float, top: Float, right: Float, bottom: Float) : super(
        left,
        top,
        right,
        bottom
    )

    /**
     * RectF与Rect的构造函数基本相同，不同的只是RectF所保存的数值类型是Float，而Rect所保存的数值类型是Int
     * 一般而言 构造一个矩形结构，可以通过以下两种方法来实现
     */
    private fun test() {
        // 方法一：直接构造
        val rect = Rect(10, 0, 100, 100)
        // 方法二：间接构造
        val rect2 = Rect()
        rect2.set(10, 10, 100, 100)
    }

    /**
     * 判断是否包含某个点
     * 该函数用于判断某个点是否在当前矩形中，if在返回true else false
     * @param x 需要判断的点的X轴坐标
     * @param y 需要判断的点的Y轴坐标
     * @return Boolean
     */
    override fun contains(x: Float, y: Float): Boolean {
        return super.contains(x, y)
    }

    /**
     * 用于根据矩形的四个点判断是否包含某个矩形
     * @param left Float
     * @param top Float
     * @param right Float
     * @param bottom Float
     * @return Boolean
     */
    override fun contains(left: Float, top: Float, right: Float, bottom: Float): Boolean {
        return super.contains(left, top, right, bottom)
    }

    /**
     * 用于判断当前Rect对象与传入的矩形是否相交
     * 也可以使用Rect的静态方法[Rect.intersects]来判断两个矩形是否相交
     * @param left Float
     * @param top Float
     * @param right Float
     * @param bottom Float
     * @return Boolean
     */
    override fun intersects(left: Float, top: Float, right: Float, bottom: Float): Boolean {
        return super.intersects(left, top, right, bottom)
    }

    /**
     * 使用Rect类中自带的方法来判断当前Rect对象与其他矩形是否相交
     * 也可以使用Rect的静态方法[Rect.intersects]来判断两个矩形是否相交
     * @param left 左边的点
     * @param top  上边的点
     * @param right  右边的点
     * @param bottom 下边的点
     */
    override fun intersect(left: Float, top: Float, right: Float, bottom: Float): Boolean {
        return super.intersect(left, top, right, bottom)
    }

    /**
     * 用于判断当前Rect对象与传入的矩形是否相交
     * 与[intersects]不同的是，该方法不仅会返回是否相交的结果，而且还会把相交部分的矩形赋给当前Rect对象
     * 如果两个矩形不相交，则当前Rect对象的值不变
     * @param r RectF 需要判断的矩形
     * @return Boolean
     */
    override fun intersect(r: RectF): Boolean {
        return super.intersect(r)
    }

    /**
     * 用于合并两个矩形
     * 无论这两个矩形是否相交，取矩形最小左上角的点作为结果矩形的左上角点，取两个矩形最大右下角的点作为结果矩形的右下角点
     * 如果要合并的矩形有一方为空，则将有值的一方作为最终结果
     * @param r RectF 需要合并的矩形
     */
    override fun union(r: RectF) {
        super.union(r)
    }

    /**
     * 用于合并两个矩形
     * 无论这两个矩形是否相交，取矩形最小左上角的点作为结果矩形的左上角点，取两个矩形最大右下角的点作为结果矩形的右下角点
     * 如果要合并的矩形有一方为空，则将有值的一方作为最终结果
     * @param left Float
     * @param top Float
     * @param right Float
     * @param bottom Float
     */
    override fun union(left: Float, top: Float, right: Float, bottom: Float) {
        super.union(left, top, right, bottom)
    }

    /**
    * 合并矩形与某个点
    * 先判断当前矩形与目标合并点的关系，如果不相交，则根据目标点(x,y)的位置，将目标点设置为当前矩形的左上角点或右下角点
    * 如果当前矩形是一个空矩形，则最后的结果矩形为([0,0],[x,y])，即结果矩形的左上角点为[0,0],右下角点为[x,y]
    * @param x Float
    * @param y Float
    */
    override fun union(x: Float, y: Float) {
        super.union(x, y)
    }
}