const formatTime = date => {
  const year = date.getFullYear()
  const month = date.getMonth() + 1
  const day = date.getDate()
  const hour = date.getHours()
  const minute = date.getMinutes()
  const second = date.getSeconds()

  return [year, month, day].map(formatNumber).join('/') + ' ' + [hour, minute, second].map(formatNumber).join(':')
}

const formatNumber = n => {
  n = n.toString()
  return n[1] ? n : '0' + n
}

const isNumber= value =>{
  //判断用户输入的是否为数字  
  var regNum = new RegExp(/^[0-9]*$/);
  return regNum.test(value);
}

const isPhone = value => {
  //判断用户输入的是否为数字  
  var regPhone = new RegExp(/^1[3|4|5|7|8][0-9]{9}$/);
  return regPhone.test(value);
}



module.exports = {
  formatTime: formatTime,
  isNumber:isNumber,
  isPhone: isPhone
}
