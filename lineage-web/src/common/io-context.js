import axios from 'axios'
import { message } from 'antd'

const y_io = {}
y_io.get = async function (url, params) {
  try {
    const response = await axios.get(url, {params: params})
    if (response.data.code === 200) {
      return response.data.data
    } else {
      message.error(response.data.message)
    }
  } catch (error) {
    message.error(error)
  }
}

y_io.post = async function (url, params) {
  try {
    const response = await axios.post(url, {params: params})
    if (response.data.code === 200) {
      return response.data.data
    } else {
      message.error(response.data.message)
    }
  } catch (error) {
    message.error(error)
  }
}

export default y_io 