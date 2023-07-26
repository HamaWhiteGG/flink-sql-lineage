import React,{useState, useEffect} from 'react'
import { Button, Form, Input, message } from 'antd'
import io from '@common/io-context'

const layout = {
  labelCol: {
    span: 8,
  },
  wrapperCol: {
    span: 16,
  },
}
const Cm = (props) => {
  const {catalogId, functionId, databaseName, refresh} = props
  const [form] = Form.useForm()
  const [dataList, setDataList] = useState({})

  const getFunInfos = async () => {
    try {
      const res = await io.get(`/catalogs/${catalogId}/databases/${databaseName}/functions/${functionId}`)
      setDataList({...res})
    } catch (error) {
      message.error(error)
    }
  }

  useEffect(() => {
    functionId && getFunInfos()
  }, [functionId, refresh])

  useEffect(() => {
    form && form.setFieldsValue(dataList)
  }, [dataList])

  return (
    <div className='gray-bg pt8'>
      <div className='white-bg pt24 pb24'>
        <Form
          {...layout}
          form={form}
          name="form"
          style={{
            maxWidth: 600,
          }}
        >
          <Form.Item name="functionPath" label="jar file"><Input disabled /></Form.Item>
          <Form.Item name="functionName" label="name"><Input disabled /></Form.Item>
          <Form.Item name="database" label="database"><Input disabled /></Form.Item>
          <Form.Item name="className" label="classname"><Input disabled /></Form.Item>
          <Form.Item name="invocation" label="invocation"><Input disabled /></Form.Item>
          <Form.Item name="descr" label="description"><Input.TextArea disabled /></Form.Item>
        </Form>
      </div>
    </div>
  )
}
export default Cm