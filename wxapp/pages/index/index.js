//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    title: "服装专送080901期",
    weight: "1.5-5kg",
    minAmount: "20",
    price: "6",
    progress: 85,
    lackText: 8,
    deadline: "12月18日",
    requireRule1: "1.每日承诺寄件量不低于20件（周六日及法定假期不要求c承诺量）日发件量不足20件或运费不足120元，将按照120元收取最低运作费用。",
    requireRule2: "2.承诺使用周期内提前终止寄件视为违约行为。",
    requireRule3: "3.集货周期内未达到目标则自动取消集货。",
    requireRule4: "4.用户需自行完成打包并贴好面单。",
    requireRule5: "5.每日在约定的事件进行1次收件，不支持随寄随收。",
    requireRule6: "6.按月结算运费，不支持现寄现结。",
    rencentlyNumber: "13",
    userlist: [{}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}],
    isAdd: true,
    groupId:1,
    motto: 'Hello World',
    userInfo: {},
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo')
  },
  //事件处理函数
  bindViewTap: function() {
    wx.navigateTo({
      url: '../logs/logs'
    })
  },
  onLoad: function () {
    //参团 
    var that = this
    wx.request({
      url: "https://s1.dforel.site/sf-application/getMarketGroupDetailByGroupId.html?groupId=" + this.data.groupId,
      success: function (res) {
        console.log(res)
        if (res.data) {
          that.setData({
            title: res.data.groupName,
            weight: res.data.baseWeight +"KG--" + res.data.maxWeight+"KG",
             
            minAmount: res.data.minPackages,
            price: res.data.basePrice,
            progress: Math.ceil( res.data.userIdList.length*1.0 / res.data.groupLimit*100 ),
            lackText: res.data.groupLimit - res.data.userIdList.length,
            deadline: res.data.groupEndDate,
            requireRule1: "1.每日承诺寄件量不低于20件（周六日及法定假期不要求c承诺量）日发件量不足20件或运费不足120元，将按照120元收取最低运作费用。",
            requireRule2: "2.承诺使用周期内提前终止寄件视为违约行为。",
            requireRule3: "3.集货周期内未达到目标则自动取消集货。",
            requireRule4: "4.用户需自行完成打包并贴好面单。",
            requireRule5: "5.每日在约定的事件进行1次收件，不支持随寄随收。",
            requireRule6: "6.按月结算运费，不支持现寄现结。",
            rencentlyNumber: res.data.userIdList.length,
            userlist: res.data.userIdList,
            isAdd: true,
            groupId: res.data.groupId,

          })
        }
      }
    }) 

 
  },
  getUserInfo: function(e) {
    console.log(e)
    app.globalData.userInfo = e.detail.userInfo
    this.setData({
      userInfo: e.detail.userInfo,
      hasUserInfo: true
    })
  },
  joinin:function(e){
    wx.navigateTo({
      url: '../add/add?groupId=' + this.data.groupId
    })
  }
})
