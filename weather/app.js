App({
  onLaunch: function () {
    var _this = this;
    //一加载，获取用户的位置信息
    wx.getLocation({
      success: function(res){
        // 成功设置经度和纬度
        _this.latitude = res.latitude;
        _this.longitude = res.longitude;

        //根据经纬度获取城市信息，调用baiduAPI
        var bdAPI = "https://api.map.baidu.com/geocoder/v2/?location="+_this.latitude+","+_this.longitude+"&output=json&pois=1&ak=FE682f52d5170f3f11d267ec0b9ae2f1";

        console.log(res);

        //发送请求加载地址信息
        wx.request({
          url: bdAPI,
          success: function(res){
           //console.log(res.data.result.addressComponent.city);
           _this.city = res.data.result.addressComponent.city;
          }
        })

 
      }
    })
  },
  onShow: function () {
    
  },
  onHide: function () {
    
  },
  onError: function (msg) {
    
  },
  //创建变量保存纬度
  latitude:40.137257,

  //创建变量保存经度
  longitude:116.680165,

  //创建一个变量，保存当前城市信息
  city:"北京市"
})