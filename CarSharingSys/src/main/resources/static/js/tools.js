function getTime(){
  var weeks = ["星期日","星期一","星期二","星期三","星期四","星期五","星期六"];
  var date = new Date();
  var year = date.getFullYear();
  var month = date.getMonth()+1;
  var da = date.getDate();
  var hour = date.getHours()<10 ? "0"+date.getHours() : date.getHours() ;
  var minute = date.getMinutes()<10 ? "0"+date.getMinutes() : date.getMinutes() ;
  var second = date.getSeconds()<10 ? "0"+date.getSeconds() : date.getSeconds() ;
  var week = date.getDay();
  var time = year+"年"+month+"月"+da+"日 "+hour+":"+minute+":"+second +" "+weeks[week];
  return time;
}