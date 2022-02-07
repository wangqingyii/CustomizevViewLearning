package com.example.drawingbasis.doc

import android.graphics.*

/**
 * Region(区域)的文档类 用于展示其主要函数
 * Region主要作用不是用来绘图的，最重要的功能在区域的相交操作中
 * Region构造分为两种方式直接构造与简介构造
 * 直接构造使用Region的三个构造函数，间接构造主要是通过public Region()的空构造函数与set系列函数相结合来实现的
 * 注意：
 * 无论调用set系列函数的Region是不是有区域值，当
 * @author WangQingYi
 * @since  2022/1/19
 */
class RegionDoc : Region {

    constructor() : super()
    /****************************************** 直接构造 ******************************************/

    /**
     * 复制一个Region的范围
     * @param region Region 需要被复制的Region
     */
    constructor(region: Region) : super(region)

    /**
     * 创建一个矩形区域
     * @param r Rect 需要被创建的矩形
     * @constructor
     */
    constructor(r: Rect) : super(r)

    /**
     * 创建一个矩形区域
     * @param left Int
     * @param top Int
     * @param right Int
     * @param bottom Int
     */
    constructor(left: Int, top: Int, right: Int, bottom: Int) : super(left, top, right, bottom)

    /****************************************** 间接构造 ******************************************/
    /**
     * 置空
     * 从某种意义上讲，置空也是一个构造函数，即将原来的一个区域变量变成空变量，再利用其他的set函数重新构造区域
     */
    override fun setEmpty() {
        super.setEmpty()
    }

    /**
     * 利用新的区域替换原来的区域
     * @param region 区域
     */
    override fun set(region: Region): Boolean {
        return super.set(region)
    }

    /**
     * 利用矩形所代表的区域替换原来的区域
     * @param r 矩形
     */
    override fun set(r: Rect): Boolean {
        return super.set(r)
    }

    /**
     * 根据矩形的两个角点构造出矩形区域来替换来的区域
     */
    override fun set(left: Int, top: Int, right: Int, bottom: Int): Boolean {
        return super.set(left, top, right, bottom)
    }

    /**
     * 根据路径的区域与某区域的交际构造出新的区域
     * @param path 路径
     * @param clip 与上面的path所有成的路径取交集，并将该交集设置为最终的区域
     */
    override fun setPath(path: Path, clip: Region): Boolean {
        return super.setPath(path, clip)
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
    /****************************************** 区域相交 ******************************************/

    /**
     * 用于指定矩形取并集，将Rect所指定的矩形加入当前区域中
     */
    private fun unionTest(r: Rect) = this.union(r)

    /**
     * 区域操作方法系列一
     * 用于用当前的Region对象与指定的一个Rect对象或者Region对象执行相交操作
     * 并将结果赋给当前的Region对象，最重要的参数就是Op op
     * 如果计算成功就返回true
     * @param r 矩形
     * @param op Op
     * [Region.Op.DIFFERENCE] 最终区域为region1 与 region2不同的区域 补集
     * [Region.Op.INTERSECT] 最终区域为region1 与 region2 相交的区域 交集
     * [Region.Op.UNION] 最终区域为region1 与 region2 组合在一起的区域 并集
     * [Region.Op.XOR] 最终区域为region1 与 region2 相交之外的区域 异并集
     * [Region.Op.REVERSE_DIFFERENCE] 最终区域为region2 与 region1 不同的区域 反转补集
     * [Region.Op.REPLACE] 最终区域为region2的区域 替换
     */
    override fun op(r: Rect, op: Op): Boolean {
        return super.op(r, op)
    }

    /**
     * 区域操作方法系列一
     */
    override fun op(left: Int, top: Int, right: Int, bottom: Int, op: Op): Boolean {
        return super.op(left, top, right, bottom, op)
    }

    /**
     * 区域操作方法系列一
     */
    override fun op(region: Region, op: Op): Boolean {
        return super.op(region, op)
    }

    /**
     * 区域操作系列方法二
     * 传入两个Region对象进行区域操作，并将操作结果赋给当前的Region对象
     * @return Boolean
     */
    override fun op(rect: Rect, region: Region, op: Op): Boolean {
        return super.op(rect, region, op)
    }

    /**
     * 区域操作系列方法二
     */
    override fun op(region1: Region, region2: Region, op: Op): Boolean {
        return super.op(region1, region2, op)
    }

    /****************************************** 其他函数 ******************************************/
    /**
     * 判断该区域是否为空
     * @return Boolean
     */
    override fun isEmpty(): Boolean {
        return super.isEmpty()
    }

    /**
     * 判断该区域是否是一个矩阵
     * @return Boolean
     */
    override fun isRect(): Boolean {
        return super.isRect()
    }

    /**
     * 判断该区域是否是多个矩阵组合
     * @return Boolean
     */
    override fun isComplex(): Boolean {
        return super.isComplex()
    }

    /**
     * 返回能够包裹当前路径的最小矩形
     */
    override fun getBounds(): Rect {
        return super.getBounds()
    }

    /**
     * 返回能够包裹当前路径的最小矩形
     * @return r Rect
     */
    override fun getBounds(r: Rect): Boolean {
        return super.getBounds(r)
    }

    /**
     * 判断该区域是否包含某个点
     */
    override fun contains(p0: Int, p1: Int): Boolean {
        return super.contains(p0, p1)
    }

    /**
     * 判断区域是否包含某个矩形
     */
    override fun quickContains(r: Rect): Boolean {
        return super.quickContains(r)
    }

    /**
     * 判断区域是否包含某个矩形
     */
    override fun quickContains(p0: Int, p1: Int, p2: Int, p3: Int): Boolean {
        return super.quickContains(p0, p1, p2, p3)
    }

    /**
     * 判断该区域是否没有和指定矩形相交
     */
    override fun quickReject(r: Rect): Boolean {
        return super.quickReject(r)
    }

    /**
     * 判断该区域是否没有和指定矩形相交
     */
    override fun quickReject(p0: Int, p1: Int, p2: Int, p3: Int): Boolean {
        return super.quickReject(p0, p1, p2, p3)
    }


    /**
     * 判断该区域是否没有和指定区域相交
     */
    override fun quickReject(p0: Region?): Boolean {
        return super.quickReject(p0)
    }

    /**
     * 平移变换
     * 该函数用于将Region对象向X轴平移dx距离，向Y轴平移dy距离，并将结果赋给当前的Region对象。X轴向右是正方向，Y轴向下是正方向
     */
    override fun translate(dx: Int, dy: Int) {
        super.translate(dx, dy)
    }

    /**
     * 平移替换
     * 该函数用于将Region对象向X轴平移dx距离，向Y轴平移dy距离，该函数将结果赋给dst对象，而当前Region的值保持不变
     */
    override fun translate(dx: Int, dy: Int, dst: Region) {
        super.translate(dx, dy, dst)
    }
}