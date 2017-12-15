var sliderWidth = 96; // 需要设置slider的宽度，用于计算中间位置

Page({
    data: {
        tabs: ["选项一", "选项二", "选项三"],
        activeIndex: 0,
        sliderOffset: 0,
        sliderLeft: 0
    },
    onLoad: function () {
        var that = this;
        wx.getSystemInfo({
            success: function(res) {
                that.setData({
                    sliderLeft: (res.windowWidth / that.data.tabs.length - sliderWidth) / 2,
                    sliderOffset: res.windowWidth / that.data.tabs.length * that.data.activeIndex
                });
            }
        });
    },
    tabClick: function (e) {
      // console.log(e.currentTarget.offsetLeft)
        this.setData({
            sliderOffset: e.currentTarget.offsetLeft,
            activeIndex: e.currentTarget.id
        });
    },
    linkTo: function (e) {
      // console.log(e.currentTarget.offsetLeft)
      wx.navigateTo({
        url: '../index'
      })
    },
    linkToIndex: function(){
      wx.navigateTo({
        url: '../../pages/index/index'
      })
    },
    addGroupBuy:function(e){
      wx.navigateTo({
        url: '../../pages/add/add?groudId=9250'
      })
    }
});