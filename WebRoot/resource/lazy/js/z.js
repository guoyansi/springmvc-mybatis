bg.z={
	phone:/^1(3|4|5|7|8)\d{9}$/,//手机号
	card:/(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/,//身份证号
	china:/[\u4E00-\u9FA5\uF900-\uFA2D]/,//中文
	englisAndNumber:/^[0-9a-zA-Z]*$/g,//只用数字和字母
};