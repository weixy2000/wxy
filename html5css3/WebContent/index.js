/**
 * 主页画板操作类
 */
function IndexCanvas() {
	/**
	 * 我的Canvas
	 */
	this.myCanvas = null;
	/**
	 * 初始化Canvas
	 */
	this.initCanvas = function() {
		this.myCanvas = $('#_canvas')[0].getContext('2d');
	}
	/**
	 * 画红色矩形
	 */
	this.paintRect = function() {
		this.myCanvas.fillStyle = '#FF0000';// 填充红色
		this.myCanvas.fillRect(0, 0, 150, 75);// 画矩形，坐标(0,0)，宽150,高75
	}
	/**
	 * 画三角形
	 */
	this.paintTriangle = function() {
		this.myCanvas.moveTo(10, 10);
		this.myCanvas.lineTo(150, 50);
		this.myCanvas.lineTo(10, 50);
		this.myCanvas.stroke();
	}
	/**
	 * 画红色圆
	 */
	this.paintCircle = function() {
		this.myCanvas.fillStyle = '#FF0000';
		this.myCanvas.beginPath();
		this.myCanvas.arc(70, 18, 15, 0, Math.PI*2, true);
		this.myCanvas.closePath();
		this.myCanvas.fill();
	}
	/**
	 * 画渐变图
	 */
	this.paintGradient = function() {
		var grd = this.myCanvas.createLinearGradient(0, 0, 175, 50);
		grd.addColorStop(0, '#FF0000');
		grd.addColorStop(1, '#00FF00');
		this.myCanvas.fillStyle = grd;
		this.myCanvas.fillRect(0, 0, 175, 50);
	}
	/**
	 * 在画布中添加图片 
	 */
	this.paintImage = function() {
		var _this = this;
		this.preImage('./sources/imgs/love.jpg',function(){
			_this.myCanvas.drawImage(this, 0, 0);
	    });
	}
	/**
	 * 图片预处理
	 */
	this.preImage = function (url,callback){  
	     var img = new Image(); //创建一个Image对象，实现图片的预下载  
	     img.src = url;  
	     
	    if (img.complete) { // 如果图片已经存在于浏览器缓存，直接调用回调函数  
	         callback.call(img);  
	        return; // 直接返回，不用再处理onload事件  
	     }  
	  
	     img.onload = function () { //图片下载完毕时异步调用callback函数。  
	         callback.call(img);//将回调函数的this替换为Image对象  
	     };  
	}
	/**
	 * 画苹果
	 */
	this.paintApple = function() {
		this.myCanvas.beginPath();//开始路线
		this.myCanvas.fillStyle = 'red';//设置颜色
		this.myCanvas.arc(100, 75, 50, 0, 2 * Math.PI);//先画圆
		this.myCanvas.fill();//填充
	}
}

// page onload
$(function() {
	var canvas = new IndexCanvas();
	canvas.initCanvas();
//	canvas.paintRect();
//	canvas.paintTriangle();
//	canvas.paintCircle();
//	canvas.paintGradient();
//	canvas.paintImage();
	canvas.paintApple();
})