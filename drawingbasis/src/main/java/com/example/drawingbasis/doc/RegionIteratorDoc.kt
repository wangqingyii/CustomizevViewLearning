package com.example.drawingbasis.doc

import android.graphics.Rect
import android.graphics.Region
import android.graphics.RegionIterator

/**
 * RegionIterator(枚举区域)的文档类 用于展示其主要函数
 *
 * @author WangQingYi
 * @since  2022/2/7
 */
class RegionIteratorDoc : RegionIterator {

    /**
     * 构造函数：根据区域构建对应的矩形集
     */
    constructor(region: Region) : super(region)


    /**
     * 获取下一个矩形，将结果保存在参数Rect r中
     * @param r Rect
     * @return Boolean
     */
    fun test(r: Rect): Boolean = this.next(Rect())

}