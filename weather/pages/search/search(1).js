// pages/search/search.js
Page({
  data:{
    cityName:"北京"
  },
  onLoad:function(options){
    // 页面初始化 options为页面跳转所带来的参数
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
  },
  getCity:function(event){

    //console.log(event.detail.value);
    this.setData({cityName:event.detail.value});

  },

  searchWt:function(){
    wx.navigateTo({
      url: '/pages/info/info?cityName='+this.data.cityName
    })
  }
})