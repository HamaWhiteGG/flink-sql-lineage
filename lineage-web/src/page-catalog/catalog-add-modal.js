import React, { useState, useEffect } from 'react'
import { Link } from 'react-router-dom'
import { Form, message, Modal, Select, Input, Col, Row, Divider, Upload, Button, Space } from 'antd'
import { EditOutlined, MinusCircleOutlined, PlusOutlined } from '@ant-design/icons'
import axios from 'axios'

const { Option } = Select
const ContrlItem = ({ label, type, options = [], required = false, placeholder }) => {
  let itemContent = <Input placeholder={placeholder} style={{ width: 200 }} />
  switch (type) {
    case 'input':
      itemContent = <Input style={{ width: 200 }} />
      break;
    case 'select':
      itemContent = <Select style={{ width: 200 }}>
        {
          options?.map(t => <Option key={t} value={t}>{t}</Option>)
        }
      </Select>
      break;
    case 'upload':
      itemContent = <Upload />
      break;
    default:
      itemContent = <Input style={{ width: 200 }} />
      break;
  }
  return itemContent
}
const catalogPropMap = {
  'HIVE': [{
    label: 'hive.version',
    name: 'hive-version',
    type: 'select',
    options: ['3.1', '3.2'],
  }, {
    label: 'hive.conf',
    name: 'hive-conf-dir',
    type: 'upload',
  }],
  'JDBC': [{
    label: 'jdbcUrl',
    name: 'base-url',
    type: 'input',
    required: true,
    placeholder: 'mysql/postregsql'
  }, {
    label: 'username',
    name: 'username',
    type: 'input',
    required: true,
  }, {
    label: 'password',
    name: 'password',
    type: 'input',
    required: true,
  }]
}
const Cm = ({ visible, onCancel, getCatalogList, record, type = 'Add', catalogList = [], pluginList = [] }) => {
  const [form] = Form.useForm()
  const [databaseList, setDatabaseList] = useState([])
  const [catalogType, setCatalogType] = useState('HIVE')
  const [catalogProperties, setCatalogProperties] = useState(catalogPropMap['HIVE'])
  const onFinish = (values) => {
    console.log('Success:', values)
  }
  const onFinishFailed = (errorInfo) => {
    console.log('Failed:', errorInfo)
  }
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
    console.log('getValues---', form.getFieldsValue())
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
    console.log('hiveProperList---', hiveProperList, jdbcProperList)
    const listMap = {
      'HIVE': hiveProperList,
      'JDBC': jdbcProperList,
    }
    validateFields()
      .then(async values => {
        const unCustomPropertyList = Object.keys(listMap[catalogType]).map(t => {return {'name': t, 'value': jdbcProperList[t], custom: false}}) || []
        const customPropertyList = values.propertyList.map(t => {return {...t, 'custom': true}})
        values.propertyList = [].concat(unCustomPropertyList, customPropertyList)
        Object.keys(listMap[catalogType]).forEach(t => {delete values[t]})

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
        if (res) {
          onCancel()
          getCatalogList()
        }
      })
      .catch((errorInfo) => { })
  }

  // get database under catalogs
  const getDatabase = async (id) => {
    try {
      const res = await axios.get(`/catalogs/${id}/databases`)
      const resDatabase = res?.data?.data
      console.log('getDatabase---', res, resDatabase[0])

      await setDatabaseList(resDatabase || [])
      // form.setFieldValue('database', 111)
      form.setFieldValue('database', resDatabase[0])
    } catch (e) {
      message.error(e)
    }
  }

  const onChangeCatalog = e => {
    setCatalogType(e)
    setCatalogProperties(catalogPropMap[e])
  }

  useEffect(() => {
    // login()
    if (form && visible && type === 'Edit') {
      form.setFieldsValue({ ...record })
    } else {
      form.resetFields()
    }
  }, [visible])

  const modalProps = {
    visible,
    title: `${type} Catalog`,
    onCancel: () => {
      onCancel()
      form.resetFields()
    },
    onOk: handleOnOk,
    destroyOnClose: true,
    okText: 'save',
    width: 720,
  }



  return <Modal
    {...modalProps}
  >
    <Form
      form={form}
      name="basic"
      labelCol={{
        span: 8,
      }}
      wrapperCol={{
        span: 16,
      }}
      autoComplete="off"
      initialValues={{'catalogType': 'HIVE'}}
    >
      <Divider orientation="left" orientationMargin={0} plain>
        Catalog Overview
      </Divider>
      <Row>
        <Col span={12}>
          <Form.Item
            label="name"
            name="catalogName"
            rules={[
              {
                required: true,
                message: 'Please enter name!',
              },
            ]}
          >
            <Input placeholder='enter' />
          </Form.Item>
          <Form.Item
            label="database"
            name="defaultDatabase"
            rules={[
              {
                required: true,
                message: 'Please enter database!',
              },
            ]}
          >
            <Input placeholder='default database' />
            {/* <Select placeholder='database' onChange={e => onChangeCatalog(e)}>
              {
                pluginList.map(t => <Option key={t.catalogId} value={t.catalogId}>{t.catalogName}</Option>)
              }
            </Select> */}
          </Form.Item>
        </Col>
        <Col span={12}>
          <Form.Item
            label="type"
            name="catalogType"
            rules={[
              {
                required: true,
                message: 'Please enter type!',
              },
            ]}
          >
            <Select placeholder='type' onChange={e => onChangeCatalog(e)}>
              <Option key='MEMORY' value='MEMORY'>MemoryCatalog</Option>
              <Option key='HIVE' value='HIVE'>HiveCatalog</Option>
              <Option key='JDBC' value='JDBC'>JdbcCatalog</Option>
            </Select>
          </Form.Item>
          <Form.Item
            label="plugin"
            name="pluginId"
            rules={[
              {
                required: true,
                message: 'Please enter plugin!',
              },
            ]}
          >
            <Select placeholder='plugin'>
              {
                pluginList.map(t => <Option key={t.pluginId} value={t.pluginId}>{t.pluginName}</Option>)
              }
            </Select>
          </Form.Item>
        </Col>
        <Col span={24}>
          <Form.Item
            label="description"
            name="descr"
            labelCol={{ span: 3, offset: 1 }}
          >
            <Input.TextArea placeholder='description' rows={4} />

          </Form.Item>
        </Col>
      </Row>
      <Divider orientation="left" orientationMargin={0} plain>
        Catalog Properties
      </Divider>
      <Row>
        <Col span={24}>
          {
            catalogProperties?.map(
              (t, i) => <Form.Item
                label=' '
                colon={false}
                labelCol={{ span: 1, offset: 3 }}
                labelAlign='left'
                name={t.name}
                rules={[
                  {
                    required: t.required,
                    message: `Please enter ${t.label}!`,
                  },
                ]}
              >
                <Space>
                  <Input name='' value={t.label} disabled style={{ width: 200 }} />
                  <ContrlItem {...t} />
                </Space>
              </Form.Item>
            )}
        </Col>
      </Row>
      <Row>
        <Col span={24} offset={4}>
          <Form.List name="propertyList">
            {(fields, { add, remove }) => (
              <>
                {fields.map(({ key, name, ...restField }) => (
                  <Space
                    key={key}
                    style={{
                      display: 'flex',
                      marginBottom: 8,
                    }}
                    align="baseline"
                  >
                    <Form.Item
                      {...restField}
                      name={[name, `name`]}
                      rules={[
                        {
                          required: true,
                          message: 'Please enter name!',
                        },
                      ]}
                    >
                      <Input placeholder="Name" style={{ width: 200 }} />
                    </Form.Item>
                    <Form.Item
                      {...restField}
                      name={[name, 'value']}
                      rules={[
                        {
                          required: true,
                          message: 'Please enter value!',
                        },
                      ]}
                    >
                      <Input placeholder="Value" style={{ width: 200 }} />
                    </Form.Item>
                    <MinusCircleOutlined onClick={() => remove(name)} />
                  </Space>
                ))}
                <Form.Item>
                  <Button type="dashed" onClick={() => add()} block icon={<PlusOutlined />}>
                    Add field
                  </Button>
                </Form.Item>
              </>
            )}
          </Form.List>
        </Col>
      </Row>
    </Form>
  </Modal>
}
export default Cm