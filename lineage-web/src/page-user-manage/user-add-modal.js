import React, { useState, useEffect } from 'react'
import { Link } from 'react-router-dom'
import { Form, message, Modal, Select, Input, Switch } from 'antd'
import { UploadOutlined, MinusCircleOutlined, PlusOutlined } from '@ant-design/icons'
import axios from 'axios'

const { Option } = Select

const Cm = ({visible, onCancel, getCatalogList, record, type = 'Add', catalogList = [], roleList = []}) => {
  const [form] = Form.useForm()
  const [catalogType, setCatalogType] = useState('HIVE')

  // login
  const login = async () => {
    try {
      const res = await axios.post('/login', {
        username: 'admin', password: 'admin'
      }, {
        headers: {
          'Content-Type': 'multipart/form-data'
        }
      })
    } catch (error) {
      message(error)
    }
  }

  // add || edit 
  const handleOnOk = () => {
    const { validateFields } = form
    const hiveProperList = {
      'hive-version': '',
      'hive-conf-dir': '',
    }
    const jdbcProperList = {
      'base-url': '',
      'username': '',
      'password': '',
    }
    const val = form.getFieldsValue()
    Object.keys(hiveProperList).forEach((t => hiveProperList[t] = val[t]))
    Object.keys(jdbcProperList).forEach((t => jdbcProperList[t] = val[t]))
    const listMap = {
      'HIVE': hiveProperList,
      'JDBC': jdbcProperList,
    }
    validateFields()
      .then(async values => {
        const unCustomPropertyList = Object.keys(listMap[catalogType] || {})?.map(t => {return {'name': t, 'value': listMap[catalogType][t], custom: false}}) || []
        const customPropertyList = values.propertyList?.map(t => {return {...t, 'custom': true}}) || []
        values.propertyList = [].concat(unCustomPropertyList, customPropertyList)
        Object.keys(listMap[catalogType] || {}).forEach(t => {delete values[t]})

        let res = null
        switch (type) {
          case 'Add':
            res = await axios.post(
              `/catalogs`,
              { ...values }
            )
            break;
          case 'Edit':
            res = await axios.put(
              `/catalogs/${record.catalogId}`,
              { ...values }
            )
            break;
          default:
            res = await axios.post(
              `/catalogs`,
              { ...values }
            )
            break;
        }
        console.log('res---', res)
        const {code, message: msg} = res.data
        if (code === 200) {
          onCancel()
          getCatalogList()
        } else {
          message.error(msg)
        }
      })
      .catch((error) => {
        message.error(error)
      })
  }

  useEffect(() => {
    login()
    if (form && visible && type === 'Edit') {
      // const {propertyList} = record
      // const unCustomPropertyList = propertyList.filter(t => !t.custom)
      // record.propertyList = propertyList.filter(t => t.custom)
      // const unCustomTmp = {}
      // Object.keys(unCustomPropertyList).forEach((t) => {
      //   unCustomTmp[`${unCustomPropertyList[t].name}`] = unCustomPropertyList[t].value
      // })
      // form.setFieldsValue({ ...record, ...unCustomTmp })
    } else {
      form.resetFields()
    }
  }, [visible])

  const modalProps = {
    visible,
    title: `${type} User`,
    onCancel: () => {
      onCancel()
      form.resetFields()
    },
    onOk: handleOnOk,
    destroyOnClose: true,
    okText: 'save',
  }

  return <Modal
    {...modalProps}
  >
    <Form
      form={form}
      name="basic"
      labelCol={{
        span: 6,
      }}
      wrapperCol={{
        span: 16,
      }}
      autoComplete="off"
    >
      <Form.Item
        label="username"
        name="username"
        rules={[
          {
            required: true,
            message: 'Please enter username!',
          },
        ]}
      >
        <Input placeholder='enter' />
      </Form.Item>
      <Form.Item
        label="password"
        name="password"
        rules={[
          {
            required: true,
            message: 'Please enter password!',
          },
        ]}
      >
        <Input placeholder='default password' />
      </Form.Item>
      {/* <Form.Item
        label="role"
        name="role"
        rules={[
          {
            required: true,
            message: 'Please enter role!',
          },
        ]}
      >
        <Select placeholder='role' >
          {
            roleList?.map(t => <Option key={t.roleId} value={t.roleId}>{t.roleName}</Option>)
          }
        </Select>
      </Form.Item>
      <Form.Item
        label="Status"
        name="locked"
        rules={[
          {
            required: true,
            message: 'Please enter status!',
          },
        ]}
      >
        <Select placeholder='status'>
        <Option key='MEMORY' value='MEMORY'>MemoryCatalog</Option>
          <Option key='HIVE' value='HIVE'>HiveCatalog</Option>
          <Option key='JDBC' value='JDBC'>JdbcCatalog</Option>
          
        </Select>
      </Form.Item> */}
    </Form>
  </Modal>
}
export default Cm