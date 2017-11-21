/*工具*/
//获取app
var app = getApp();

/*
    创建方法，用来根据城市获取天气信息 
    参数：
        cityName 城市名    
        callback 回调函数返回数据  
        
*/
function getWeatherData(cityName, callback) {

    //判断cityName是否存在
    if (!cityName) {
        //如果不存在，则使用定位到的城市信息
        cityName = app.city
    }


    //调用天气API查询气象信息
    var weApi = "https://free-api.heweather.com/v5/weather";

    //发送请求加载信息
    wx.request({
        url: weApi,
        data: {
            city: cityName,
            key: "8971dbd46ef44708a62f0ce8cf6ff012"
        },

        success: function (res) {
            //console.log(res.data);
            //加载成功，获取需要的数据
            /*
                需要的数据
                    1.城市名
                    2.当前日期
                    3.更新日期
                    4.当前天气情况
                        - 气温
                        - 描述
                    5.各种生活指数
             */

            var hw = res.data.HeWeather5[0];

            //console.log(hw);

            var weatherData = { status: "error" };

            if (hw.status == "ok") {
                weatherData = {
                    city: hw.basic.city, //城市
                    upTime: hw.basic.update.loc.slice(-5), //更新时间
                    now: formatTime(), // 当前日期
                    temp: 　hw.now.tmp, // 当前温度
                    desc: hw.now.cond.txt, //描述
                    status: "ok", //状态
                    suggestion:hw.suggestion //气象指数
                };
            }

            //console.log(weatherData);
            //信息封装完毕，调用回调函数发回信息
            callback && callback(weatherData);

        }
    })
}

/*创建一个数组，表示星期 */
var dayArr = ["周日","周一","周二","周三","周四","周五","周六"];

/* 格式化时间 
    传递一个时间对象，返回月日星期
*/
function formatTime(dt){
    //判断对象是否存在
    if(!dt){
        //若没传对象
        //创建一个当前日期对象
        dt = new Date();
    }

    //对日期进行格式化并返回
    //期望格式 2月12日 周日

    //获取月份
    var m = dt.getMonth()+1;
    //获取日
    var date = dt.getDate();
    //获取星期
    var day = dayArr[dt.getDay()];

    return m + "月" + date +"日 "+day;

}


//设置到处信息
module.exports = {
    getWeatherData: getWeatherData
};