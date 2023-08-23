package com.github.novicezk.midjourney.enums;


public enum TaskAction {
	/**
	 * 生成图片.
	 */
	IMAGINE,
	/**
	 * 选中放大.
	 */
	UPSCALE,
	/**
	 * 选中其中的一张图，生成四张相似的.
	 */
	VARIATION,
	/**
	 * 重新执行.
	 */
	REROLL,
	/**
	 * 图转prompt.
	 */
	DESCRIBE,
	/**
	 * 多图混合.
	 */
	BLEND,

	/**
	 * 放大1.5X
	 */
	ZOOM_1,
	/**
	 * 放大2
	 */
	ZOOM_2,

	/**
	 * high_variation
	 */
	VARY_HIGH,
	/**
	 * low_variation
	 */
	VARY_LOW,

	/**
	 * up down left right
	 */
	MOVE_UP,
	MOVE_DOWN,
	MOVE_LEFT,
	MOVE_RIGHT



}
