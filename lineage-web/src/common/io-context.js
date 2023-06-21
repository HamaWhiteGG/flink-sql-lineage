import axios from 'axios'
import { message } from 'antd'

const y_io = {}
y_io.get = async function (url, params) {
  try {
    const response = await axios.get(url, {...params})
    switch (response.status) {
      case 200:
        if (response.data.code === 200) {
          
        } else {
          // debugger
          message.error(response.data.message)
        }
        return response.data.data
        break;
      case 504:
        message.error('Gateway Timeout')
      case 500:
        message.error('Internal Server Error')
      default:
        break;
    }
    
  } catch (error) {
    message.error(error)
  }
}

y_io.post = async function (url, params) {
  try {
    const response = await axios.post(url, {...params})
    if (response.data.code === 200) {
      response.data.data && message.success(response.data.message)
      return response.data.data
    } else {
      message.error(response.data.message)
    }
  } catch (error) {
    message.error(error)
  }
}

y_io.put = async function (url, params) {
  try {
    const response = await axios.put(url, {...params})
    if (response.data.code === 200) {
      response.data.data && message.success(response.data.message)
      return response.data.data
    } else {
      message.error(response.data.message)
    }
  } catch (error) {
    message.error(error)
  }
}

y_io.delete = async function (url, params) {
  try {
    const response = await axios.delete(url, {...params})
    if (response.data.code === 200) {
      response.data.data && message.success(response.data.message)
      return response.data.data
    } else {
      message.error(response.data.message)
    }
  } catch (error) {
    message.error(error)
  }
}

export default y_io 