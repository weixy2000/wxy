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
		this.myCanvas.arc(70, 18, 15, 0, Math.PI * 2, true);// 画圆
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
		this.preImage('./sources/imgs/love.jpg', function() {
			_this.myCanvas.drawImage(this, 0, 0);
		});
	}
	/**
	 * 图片预处理
	 */
	this.preImage = function(url, callback) {
		var img = new Image(); //创建一个Image对象，实现图片的预下载  
		img.src = url;

		if (img.complete) { // 如果图片已经存在于浏览器缓存，直接调用回调函数  
			callback.call(img);
			return; // 直接返回，不用再处理onload事件  
		}

		img.onload = function() { //图片下载完毕时异步调用callback函数。  
			callback.call(img);//将回调函数的this替换为Image对象  
		};
	}
	/**
	 * 画苹果
	 */
	this.paintApple = function() {
		this.myCanvas.translate(100, 100);// 将0,0位置移到100,100这里
		
		// 圆心1x，圆心1y，圆1半径，圆心2x，圆心2y，圆2半径
		var grad = this.myCanvas.createRadialGradient(35, 45, 2, 35, 45, 25);//创建放射渐变
		grad.addColorStop(0, 'white');//从白
		grad.addColorStop(1, '#E01B13');//到红
		
		// 画苹果的外层
		this.myCanvas.beginPath();//起始一条路径，或重置当前路径
		this.myCanvas.fillStyle = grad;//设置颜色
		// 圆心x，圆心y，半径r，起始，画圆周，正向或反向画
		this.myCanvas.arc(50,50,50,-0.3*Math.PI,1.3* Math.PI);//先画圆
		this.myCanvas.closePath();
		this.myCanvas.fill();
		
		// 画苹果的心，红色圆环遮盖黑色圆环的结果
		this.myCanvas.beginPath();//起始一条路径，或重置当前路径
		this.myCanvas.lineWidth=5;
		this.myCanvas.strokeStyle='#AD3C2A';
		this.myCanvas.arc(50,5,20,0.3*Math.PI,0.7*Math.PI);//再画圆
		this.myCanvas.stroke();
		
		this.myCanvas.beginPath();//起始一条路径，或重置当前路径
		this.myCanvas.lineWidth=5;
		this.myCanvas.strokeStyle='#E01B13';
		this.myCanvas.arc(50,-6,27,0.3*Math.PI,0.7*Math.PI);//再画圆
		this.myCanvas.stroke();
		
		// 画苹果的把子
		this.myCanvas.beginPath();//起始一条路径，或重置当前路径
		this.myCanvas.strokeStyle='#D1742F';
		this.myCanvas.arc(110,24,60,1*Math.PI,1.4*Math.PI);
		this.myCanvas.stroke();
		
//		this.myCanvas.beginPath();//起始一条路径，或重置当前路径
//		this.myCanvas.arc(50,10,28,0.6*Math.PI,0.4*Math.PI,true);//接着画圆
//		this.myCanvas.stroke();
		

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