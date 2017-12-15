const util = require('../../utils/util.js')
// const base64 = require("../images/addr.png");
var address = require('../../utils/city.js')
var animation

// pages/add/add.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    list:[],
    name:"",
    nameValidate:false,
    phone:0,
    phoneValidate:false,
    mailNumber:0,
    mailNumberValidate: false, 
    groudId:0,

    //toast默认不显示  
    isShowToast: false, 
    icon: "../images/addr.png",
    iconMan:"../images/man.png",
    animationAddressMenu: {},
    addressMenuIsShow: false,
    value: [0, 0, 0],
    provinces: [],
    citys: [],
    areas: [],
    areaInfo: '',
    addressValidate:false,

    detailAddressValidate:false,
    detailAddress:"",

    weightValidate: false,
    weights: ["请选择单件平均重量","5kg", "10kg", "15kg"],
    weightIndex: 0,
  },
  onLoad: function (option) {
    // 初始化动画变量
    var animation = wx.createAnimation({
      duration: 500,
      transformOrigin: "50% 50%",
      timingFunction: 'ease',
    })
    this.animation = animation;
    // 默认联动显示北京
    var id = address.provinces[0].id
    this.setData({
      provinces: address.provinces,
      citys: address.citys[id],
      areas: address.areas[address.citys[id][0].id],
    })
    
    // 保存参数
    this.setData({
      groudId: option.groudId 
    });
  },
  /**
  * 生命周期函数--监听页面初次渲染完成
  */
  onReady: function () {

  },
  showToast: function (text,time) {
    var _this = this;
    // toast时间  
    _this.data.count = parseInt(time) ? parseInt(time) : 3000;
    // 显示toast  
    _this.setData({
      isShowToast: true,
      toastText: text
    });
    // 定时器关闭  
    setTimeout(function () {
      _this.setData({
        isShowToast: false
      });
    }, time);
  },
  // 设置详细地址
  setDetailAddress:function(e){
    var value = e.detail.value 
    if(value){
      this.data.detailAddressValidate = value.length > 0 ? true : false 
    } 
    if (!this.data.detailAddressValidate ) {
      value = ""
    }
    
    this.setData({
      detailAddress: value,
      detailAddressValidate: this.data.detailAddress
    })
  },

  setName: function (e) {
    var value = e.detail.value
    this.data.nameValidate = value==""?false:true

    if (!this.data.nameValidate) {
      value = ""
    } 
    this.setData({
      name: value,
      nameValidate: this.data.nameValidate
    })
  },
  setMailNumber: function (e) {
    var value = e.detail.value
    var isnumber = util.isNumber(value)
    this.data.mailNumberValidate = false
    if(isnumber){
      this.data.mailNumberValidate = parseInt(value)>=20?true:false
    }
    if (!this.data.mailNumberValidate) {
      value = ""
    }
    this.setData({
      name: value,
      mailNumberValidate: this.data.mailNumberValidate
    })
  },
  setPhone: function (e) {
    var value = e.detail.value
    this.data.phoneValidate = util.isPhone(value)
   
    if (!this.data.phoneValidate){
      value = 0
    } 
    this.setData({
      phone: e.detail.value,
      phoneValidate: this.data.phoneValidate
    })
    // console.log(this.data.priceValidate )
    
  },
  showSuccessToast:function(isShow){
    this.setData({
      isShowToastSuccess: isShow 
    });
  },

  baoming: function (e) {
    this.showSuccessToast(true);   
    return 
    if (!this.data.addressValidate ){ 
      this.showToast('请选择所在地区',1500);   
      return
    }
    if (!this.data.detailAddressValidate) {
      this.showToast('请填写详细地址', 1500);
      return
    }
    if (!this.data.nameValidate) {
      this.showToast('请填写寄件人姓名', 1500);
      return
    }
    if (!this.data.phoneValidate) {
      this.showToast('请填写正确的手机号', 1500);
      return
    }
    if (!this.data.mailNumberValidate) {
      this.showToast('请填写寄件量，至少20件', 1500);
      return
    }
    if (!this.data.weightValidate) {
      this.showToast('请选择正确的重量', 1500);
      return
    }

    var good = { name: this.data.goodname, price: this.data.goodprice}

    //参团  
    wx.request({
      url: "https://itsc.dforel.site//currency?key=我的appkey&from=CNY&to=" + code,
      success: function (res) {
        console.log(res)
        if(res.success){ 
          this.showSuccessToast(true);   
        }
      }
    }) 
   

  },


  //地址选择部分开始
  // 点击所在地区弹出选择框
  selectDistrict: function (e) {
    var that = this
    // 如果已经显示，不在执行显示动画
    if (that.data.addressMenuIsShow) {
      return
    }
    // 执行显示动画
    that.startAddressAnimation(true)
  },
  // 执行动画
  startAddressAnimation: function (isShow) {
    console.log(isShow)
    var that = this
    if (isShow) {
      // vh是用来表示尺寸的单位，高度全屏是100vh
      console.log(that.animation)
      that.animation.translateY(0 + 'vh').step()
    } else {
      that.animation.translateY(60 + 'vh').step()
    }
    that.setData({
      animationAddressMenu: that.animation.export(),
      addressMenuIsShow: isShow,
    })
  },
  // 点击地区选择取消按钮
  cityCancel: function (e) {
    this.startAddressAnimation(false)
  },
  // 点击地区选择确定按钮
  citySure: function (e) {
    var that = this
    var city = that.data.city
    var value = that.data.value
    that.startAddressAnimation(false)
    // 将选择的城市信息显示到输入框
    this.data.addressValidate = true
    var areaInfo = that.data.provinces[value[0]].name + ',' + that.data.citys[value[1]].name + ',' + that.data.areas[value[2]].name
    that.setData({
      areaInfo: areaInfo, 
      addressValidate: this.data.addressValidate
    })
  },
  // 点击蒙版时取消组件的显示
  hideCitySelected: function (e) {
    console.log(e)
    this.startAddressAnimation(false)
  },
  // 处理省市县联动逻辑
  cityChange: function (e) {
    console.log(e)
    var value = e.detail.value
    var provinces = this.data.provinces
    var citys = this.data.citys
    var areas = this.data.areas
    var provinceNum = value[0]
    var cityNum = value[1]
    var countyNum = value[2]
    // 如果省份选择项和之前不一样，表示滑动了省份，此时市默认是省的第一组数据，
    if (this.data.value[0] != provinceNum) {
      var id = provinces[provinceNum].id
      this.setData({
        value: [provinceNum, 0, 0],
        citys: address.citys[id],
        areas: address.areas[address.citys[id][0].id],
      })
    } else if (this.data.value[1] != cityNum) {
      // 滑动选择了第二项数据，即市，此时区显示省市对应的第一组数据
      var id = citys[cityNum].id
      this.setData({
        value: [provinceNum, cityNum, 0],
        areas: address.areas[citys[cityNum].id],
      })
    } else {
      // 滑动选择了区
      this.setData({
        value: [provinceNum, cityNum, countyNum]
      })
    }
    console.log(this.data)
  },



  bindWeightChange: function (e) {
    // console.log('picker account 发生选择改变，携带值为', e.detail.value);

    var value = e.detail.value 
    this.data.weightValidate = value == 0 ? false : true
    // console.log(e)
    this.setData({
      weightIndex: value,
      weightValidate: this.data.weightValidate
    })
 
  },

  sendFriend: function (e) {
     
  },

  shareFriendGroup: function (e) { 
    wx.navigateTo({
      url: '../qrcode/qrcode'
    })
  },
  closeSuccess:function(e){
    console.log("close!")
    this.showSuccessToast(false)
  }

})