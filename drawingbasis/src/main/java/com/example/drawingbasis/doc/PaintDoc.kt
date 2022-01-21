package com.example.drawingbasis.doc

import android.graphics.Paint

/**
 * 画笔文档类，用于记录Paint主要函数
 *
 * @author WangQingYi
 * @since  2022/1/19
 */
class PaintDoc :Paint(){

    /**
     * 表示是否打开抗锯齿
     * 抗锯齿是依赖算法的，一般在绘制不规则的图形时使用
     * @param aa 是否打开
     */
    override fun setAntiAlias(aa: Boolean) {
        super.setAntiAlias(aa)
    }

    /**
     * 设置画笔颜色
     * A 代表透明度
     * R 代表红色值
     * G 代表绿色值
     * B 代表蓝色值
     * @param color 颜色值
     */
    override fun setColor(color: Int) {
        super.setColor(color)
    }

    /**
     * 设置填充样式
     * 对于文字和几何图形都有效
     * [android.graphics.Paint.Style] 取值如下:
     * [android.graphics.Paint.Style.FILL]: 仅填充内部
     * [android.graphics.Paint.Style.FILL_AND_STROKE]: 填充内部和描边
     * [android.graphics.Paint.Style.STROKE]: 仅描边
     * @param style 样式
     */
    override fun setStyle(style: Style?) {
        super.setStyle(style)
    }

    /**
     * 设置描边宽度
     * 用于设置描边宽度值，单位是px。当画笔的样式是STROKE和FILL_AND_STROKE时有效
     */
    override fun setStrokeWidth(width: Float) {
        super.setStrokeWidth(width)
    }
}