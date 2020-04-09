/*
 * loader.js用于加载所有js和css
 */
function getRootPath() {
	//获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
	var curWwwPath = window.document.location.href;
	//获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
	var pathName = window.document.location.pathname;
	var pos = curWwwPath.indexOf(pathName);
	//获取主机地址，如： http://localhost:8083
	var localhostPaht = curWwwPath.substring(0, pos);
	//获取带"/"的项目名，如：/uimcardprj
	var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
	return (localhostPaht + projectName);
}
//start 引入CSS样式
document.write('<link rel="stylesheet" href="'+getRootPath()+'/css/homestyle.css"/>');

//bootstrap样式
document.write('<link rel="stylesheet" href="'+getRootPath()+'/css/bootstrap.min.css"/>');
document.write('<link rel="stylesheet" href="'+getRootPath()+'/css/bootstrap-dropdownhover.min.css"/>');
document.write('<link rel="stylesheet" href="'+getRootPath()+'/css/bootstrap-theme.css"/>');
//字体
document.write('<link rel="stylesheet" href="'+getRootPath()+'/css/font-awesome.min.css"/>');
//Google Fonts
document.write('<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,800italic,800,600italic,600,400italic,700,700italic"/>');
document.write('<link rel="stylesheet" href="'+getRootPath()+'/css/animate.css"/>');
document.write('<link rel="stylesheet" href="'+getRootPath()+'/css/owl.carousel.css"/>');

//Home Main Style

//Responsive CSS
document.write('<link rel="stylesheet" href="'+getRootPath()+'/css/responsive.css"/>');
//Switcher Only
document.write('<link rel="stylesheet" id="switcher-css" media="all" href="'+getRootPath()+'/css/switcher.css"/>');
//Switcher Only
//Skins Style
document.write('<link rel="alternate stylesheet" id="switcher-css" title="blue" media="all" href="'+getRootPath()+'/css/blue.css"/>');
document.write('<link rel="alternate stylesheet" id="switcher-css" title="pink" media="all" href="'+getRootPath()+'/css/pink.css"/>');
document.write('<link rel="alternate stylesheet" id="switcher-css" title="purple" media="all" href="'+getRootPath()+'/css/purple.css"/>');
document.write('<link rel="alternate stylesheet" id="switcher-css" title="green" media="all" href="'+getRootPath()+'/css/green.css"/>');
document.write('<link rel="alternate stylesheet" id="switcher-css" title="red" media="all" href="'+getRootPath()+'/css/red.css"/>');
document.write('<link rel="alternate stylesheet" id="switcher-css" title="yellow" media="all" href="'+getRootPath()+'/css/yellow.css"/>');
document.write('<link rel="alternate stylesheet" id="switcher-css" title="orange" media="all" href="'+getRootPath()+'/css/orange.css"/>');
document.write('<link rel="alternate stylesheet" id="switcher-css" title="grey" media="all" href="'+getRootPath()+'/css/grey.css"/>');
//引入js文件
//jQuery
document.write('<script src="'+getRootPath()+'/js/jquery.min.js"></script>');
//bootstrap
document.write('<script src="'+getRootPath()+'/js/bootstrap.min.js"></script>');
//jQuery插件
document.write('<script src="'+getRootPath()+'/js/jquery.plugin.min.js"></script>');
//jquery.isotope对一组页面元素进行排序并创建智能布局的插件
document.write('<script src="'+getRootPath()+'/js/jquery.isotope.min.js"></script>');
//jquery响应式弹出层和对话框插件jquery.magnific-popup.js
document.write('<script src="'+getRootPath()+'/js/jquery.magnific-popup.min.js"></script>');
//
document.write('<script src="'+getRootPath()+'/js/bootstrap-dropdownhover.min.js"></script>');
//页面滚动动画
document.write('<script src="'+getRootPath()+'/js/wow.min.js"></script>');
//jquery滚动监听插件jquery.waypoints.js
document.write('<script src="'+getRootPath()+'/js/waypoints.min.js"></script>');
//jquery轻量级数字动画插件jquery.countup.js
document.write('<script src="'+getRootPath()+'/js/jquery.counterup.min.js"></script>');
//jquery幻灯片插件jquery.carousel.js
document.write('<script src="'+getRootPath()+'/js/owl.carousel.min.js"></script>');
//自定义js
//document.write('<script src="'+getRootPath()+'/js/main.js"></script>');

//消息提示框插件
document.write('<script src="'+getRootPath()+'/js/toastr.js"></script>');
document.write('<link rel="stylesheet" href="'+getRootPath()+'/css/toastr.css"/>');
//弹出框插件（alert、confirm、dialog）
document.write('<script src="'+getRootPath()+'/js/tip.js"></script>');
//rest风格插件（包含表单数据封装）
document.write('<script src="'+getRootPath()+'/js/restful.js"></script>');
//echart图表
document.write('<script src="'+getRootPath()+'/js/echarts.common.min.js"></script>');

//3、初始化提示框
document.write("<script>toastr.options.positionClass = 'toast-top-center'</script>");