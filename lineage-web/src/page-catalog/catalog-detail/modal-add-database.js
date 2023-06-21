import React,{useState, useEffect} from 'react'
import { Modal, Form, Select, Input, message} from 'antd'
import io from '@common/io-context'

const {Option} = Select
const layout = {
  labelCol: {
    span: 6,
  },
  wrapperCol: {
    span: 16,
  },
}
const Cm = (props) => {
  const {catalogId, switchVisible, callback} = props
  const [form] = Form.useForm()

  const addDatabase = () => {
    try {
      form.validateFields().then(async (values) => {
        const res = await io.post(`/catalogs/${catalogId}/databases`, {...values})
        res && switchVisible(false)
        callback()
      }).catch((error) => {
        message.error(error)
      })
    } catch (error) {
      message.error(error)
    }
  }

  return (
    <Modal
      {...props}
      onOk={() => {addDatabase()}}
      onCancel={() => switchVisible(false)}
      title="Create Database"
    >
      <Form
        {...layout}
        form={form}
        name="control-hooks"
        style={{
          maxWidth: 600,
        }}
      >
        <Form.Item
          name="database"
          label="database"
          rules={[
            {
              required: true,
            },
          ]}
        >
          <Input />
        </Form.Item>
        <Form.Item
          name="comment"
          label="comment"
        >
          <Input.TextArea />
        </Form.Item>
      </Form>
    </Modal>
  )
}
export default Cm