/**
 * 主页画板操作类
 */
function IndexCanvas() {
	/**
	 * 我的Canvas
	 */
	this.myCanvas = null;
	/**
	 * 2D Context
	 */
	this.ctx = null;
	/**
	 * canvas高
	 */
	this.height = null;
	/**
	 * canvas宽
	 */
	this.width = null;
	/**
	 * 初始化Canvas
	 */
	this.initCanvas = function() {
		this.myCanvas = $('#_canvas')[0];
		this.ctx = this.myCanvas.getContext('2d');
		this.height = this.myCanvas.height;
		this.width = this.myCanvas.width;
	}
	/**
	 * 初始化标尺
	 */
	this.initScale = function() {
		this.ctx.globalAlpha = 0.1;// 全局透明度,1为不透明,0为全透明
		// 画横向的标尺
		for(var i=20;i<this.height;i+=20){
			this.ctx.beginPath();
			this.ctx.moveTo(0, i);
			this.ctx.lineTo(this.width, i);
			this.ctx.stroke();
		}
		// 画纵向的标尺
		for(var i=20;i<this.width;i+=20){
			this.ctx.beginPath();
			this.ctx.moveTo(i, 0);
			this.ctx.lineTo(i, this.height);
			this.ctx.stroke();
		}
		this.ctx.globalAlpha = 1;
		// 右下角挖去一块，用于存放当前坐标
		// 起点x,起点y,宽,高
		this.ctx.clearRect(this.width-99, 
				this.height-59,98,58);
	}
	/**
	 * 初始化事件
	 */
	this.initEvents = function() {
		var _this = this;
		_this.ctx.font="20px Georgia";
		this.myCanvas.onmousemove=function(event){
			var cirX=this.width/2, cirY=this.height/2;// 中心位置0,0
			// 将已写入的坐标信息清除掉
			_this.ctx.clearRect(this.width-99-cirX,this.height-59-cirY,cirY+98,this.height+58);
			// 存放当前鼠标位置坐标信息
			// 文字内容,起点x,起点y
			_this.ctx.fillText((event.offsetX-cirX)+','+(event.offsetY-cirY),
					this.width-80-cirX,this.height-20-cirY);
		}
	}
	/**
	 * 画红色矩形
	 */
	this.paintRect = function() {
		this.ctx.fillStyle = '#FF0000';// 填充红色
		this.ctx.fillRect(0, 0, 150, 75);// 画矩形，坐标(0,0)，宽150,高75
	}
	/**
	 * 画三角形
	 */
	this.paintTriangle = function() {
		this.ctx.moveTo(10, 10);
		this.ctx.lineTo(150, 50);
		this.ctx.lineTo(10, 50);
		this.ctx.stroke();// 画线
	}
	/**
	 * 画红色圆
	 */
	this.paintCircle = function() {
		this.ctx.fillStyle = '#FF0000';
		this.ctx.beginPath();
		this.ctx.arc(70, 18, 15, 0, Math.PI * 2, true);// 画圆
		this.ctx.closePath();
		this.ctx.fill();// 填充
	}
	/**
	 * 画渐变图
	 */
	this.paintGradient = function() {
		var grd = this.ctx.createLinearGradient(0, 0, 175, 50);
		grd.addColorStop(0, '#FF0000');// 从红
		grd.addColorStop(1, '#00FF00');// 到绿
		this.ctx.fillStyle = grd;
		this.ctx.fillRect(0, 0, 175, 50);
	}
	/**
	 * 在画布中添加图片 
	 */
	this.paintImage = function() {
		var _this = this;
		this.preImage('./sources/imgs/love.jpg', function() {
			_this.ctx.drawImage(this, 0, 0);
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
		this.ctx.translate(this.width/2, this.height/2);// 将0,0位置移到100,100这里
		
		// 圆心1x，圆心1y，圆1半径，圆心2x，圆心2y，圆2半径
		var radial = this.ctx.createRadialGradient(-15, -5, 2, -15, -5, 25);//创建放射渐变
		radial.addColorStop(0, '#FFFFFF');//从白
		radial.addColorStop(1, '#E01B13');//到红
		
		// 画苹果的外层
		this.ctx.beginPath();//起始一条路径，或重置当前路径
		this.ctx.fillStyle = radial;//设置颜色
		// 圆心x，圆心y，半径r，起始，画圆周，正向或反向画
		this.ctx.arc(0,0,50,-0.3*Math.PI,1.3* Math.PI);//先画圆
		this.ctx.closePath();//形成路径闭合
		this.ctx.fill();//填充
		
		// 画苹果的心，红色圆环遮盖黑色圆环的结果
		this.ctx.beginPath();//起始一条路径，或重置当前路径
		this.ctx.lineWidth=5;
		this.ctx.strokeStyle='#AD3C2A';
		this.ctx.arc(0,-45,20,0.3*Math.PI,0.7*Math.PI);//再画圆
		this.ctx.stroke();
		
		this.ctx.beginPath();//起始一条路径，或重置当前路径
		this.ctx.lineWidth=5;
		this.ctx.strokeStyle='#E01B13';
		this.ctx.arc(0,-56,27,0.3*Math.PI,0.7*Math.PI);//再画圆
		this.ctx.stroke();

		// 画苹果的把子
		this.ctx.beginPath();//起始一条路径，或重置当前路径
		this.ctx.strokeStyle='#D1742F';//土黄
		this.ctx.arc(60,-26,60,1*Math.PI,1.4*Math.PI);
		this.ctx.stroke();
		
		// 画苹果的叶子
		//贝塞尔控制点的x坐标,贝塞尔控制点的y坐标,结束点的x坐标,结束点的y坐标
		this.ctx.beginPath();//起始一条路径，或重置当前路径
		this.ctx.moveTo(-2,-55);//先画叶子
		this.ctx.quadraticCurveTo(-28,-28,-50,-80);// 二次贝赛尔曲线
		this.ctx.quadraticCurveTo(2,-92,-2,-55);// 二次贝赛尔曲线
		this.ctx.fillStyle='#69B549';//填充绿色
		this.ctx.fill();
		
		// 画苹果叶子的茎
		//开始x,开始y,结束x，结束y
		var linear = this.ctx.createLinearGradient(3,-50,-48,-78);// 创建线性渐变
		linear.addColorStop(0, '#53A43B');//从深绿
		linear.addColorStop(1, '#69B549');//到浅绿
		
		this.ctx.beginPath();//起始一条路径，或重置当前路径
		this.ctx.strokeStyle=linear;
		this.ctx.lineWidth=3;
		this.ctx.moveTo(3,-50);
		this.ctx.lineTo(-48,-78);
		this.ctx.stroke();
		
	}
}

// page onload
$(function() {
	var canvas = new IndexCanvas();
	canvas.initCanvas();//初始化画布
//	canvas.initScale();//初始化标尺
//	canvas.initEvents();//初始化事件
//	canvas.paintRect();//画矩形
//	canvas.paintTriangle();//画三角形
//	canvas.paintCircle();//画圆形
//	canvas.paintGradient();//画渐变
//	canvas.paintImage();//画图片
//	canvas.paintApple();//画苹果
})