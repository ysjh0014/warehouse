//引入工具类
var util = require("../../utils/util.js");

// pages/index/index.js
Page({
  data:{},
  onLoad:function(options){
    //console.log(options);
    var _this = this;
    // 页面初始化 options为页面跳转所带来的参数
    util.getWeatherData(options.cityName , function(wd){
      _this.setData({wd:wd});
      //console.log(wd);
    });
  },
  onReady:function(){
    // 页面渲染完成
  },
  onShow:function(){
    // 页面显示
  },
  onHide:function(){
    // 页面隐藏
  },
  onUnload:function(){
    // 页面关闭
  }
})