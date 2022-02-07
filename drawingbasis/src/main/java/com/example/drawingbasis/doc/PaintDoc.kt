package com.example.drawingbasis.doc

import android.graphics.Paint
import android.graphics.Typeface

/**
 * 画笔文档类，用于记录Paint主要函数
 *
 * @author WangQingYi
 * @since  2022/1/19
 */
class PaintDoc : Paint() {

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

    /************************************** Paint 与文字相关的设置方法 **********************************/
    /**
     * 设置文字对齐方式
     * [android.graphics.Paint.Align]取值如下：
     * [android.graphics.Paint.Align.CENTER] 居中绘制，即通过drawText()函数指定的起始点在文字中间位置
     * [android.graphics.Paint.Align.LEFT]   居左绘制，即通过drawText()函数指定的起始点的在最左侧，文字从起始点位置开始绘制
     * [android.graphics.Paint.Align.RIGHT]  居右绘制，即通过drawText()函数指定的起始点在文字右侧位置
     */
    override fun setTextAlign(align: Align?) {
        super.setTextAlign(align)
    }

    /**
     * 设置是否为粗体文字
     * @param fakeBoldText 是否为粗体
     */
    override fun setFakeBoldText(fakeBoldText: Boolean) {
        super.setFakeBoldText(fakeBoldText)
    }

    /**
     * 设置下划线
     * @param underlineText 是否设置下划线
     */
    override fun setUnderlineText(underlineText: Boolean) {
        super.setUnderlineText(underlineText)
    }

    /**
     * 设置字体水平倾斜度，普通斜体字设置为-0.25
     * @param skewX Float 默认值为0，取负值时文字向右倾斜，取正值时文字向左倾斜，普通斜体字设置为-0.25
     */
    override fun setTextSkewX(skewX: Float) {
        super.setTextSkewX(skewX)
    }

    /**
     * 设置字体带有删除线效果
     * @param strikeThruText 字体是否设置删除线
     */
    override fun setStrikeThruText(strikeThruText: Boolean) {
        super.setStrikeThruText(strikeThruText)
    }

    /**
     * 设置文本的绘画水平缩放比例
     * @param scaleX Float 默认值为1.0，值 > 1.0会使文本更宽，值 < 1.0将缩小文本范围
     */
    override fun setTextScaleX(scaleX: Float) {
        super.setTextScaleX(scaleX)
    }

    /**
     * 设置字体样式
     * Typeface是专门用来设置字体样式的类
     * @param typeface 字体样式
     * 函数：defaultFromStyle
     * [Typeface.defaultFromStyle] 该函数会根据字体样式获取对应的默认字体，参数style取值如下
     * [Typeface.BOLD_ITALIC] 粗斜体
     * [Typeface.NORMAL] 正常字体
     * [Typeface.ITALIC] 斜体
     * [Typeface.BOLD] 粗体
     * 函数：create
     * [Typeface.create] 该函数直接通过指定字体名来加载系统中自带的字体样式。如果字体样式不存在，则会用系统样式代替并返回
     */
    override fun setTypeface(typeface: Typeface?): Typeface {
        return super.setTypeface(typeface)
    }
}