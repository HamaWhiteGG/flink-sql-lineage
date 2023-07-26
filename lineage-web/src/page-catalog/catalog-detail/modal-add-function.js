import React,{useState, useEffect} from 'react'
import { Modal, Form, Select, Input, Upload, Button, message } from 'antd'
import { UploadOutlined } from '@ant-design/icons'
import io from '@common/io-context'

const { TextArea } = Input
const layout = {
  labelCol: {
    span: 6,
  },
  wrapperCol: {
    span: 16,
  },
}
const {Option} = Select
const Cm = (props) => {
  const {type='add', catalogDetail, curDatabase, databaseList, formValues, switchApplyFunVisible, analysisCallback, switchVisible, getDetail=() => {}} = props
  const [form] = Form.useForm()
  const [functionUrl, setFunctionUrl] = useState('')

  const uploadProps = {
    name: 'file',
    action: '/storages/upload',
    headers: {
      authorization: 'authorization-text',
    },
    maxCount: 1,
    data: file =>{
      return {
        storageType: 'FUNCTION'
      }
    },
    onChange(info) {
      if (info.file.status !== 'uploading') {
        console.log(info.file, info.fileList);
      }
      if (info.file.status === 'done') {
        console.log('info-----',info)
        setFunctionUrl(info.fileList[0].response.data)
        message.success(`${info.file.name} file uploaded successfully`);
      } else if (info.file.status === 'error') {
        message.error(`${info.file.name} file upload failed.`);
      }
    },
  }

  const analysis = async () => {
    try {
      io.post(`/functions/parse`, {
        functionPath: functionUrl,
        pluginId: 1
      }).then(res => {
        if (res.length > 0 ) {
          switchApplyFunVisible(true)
          analysisCallback({functionList: res})
        } else {
          message.warning('no functions, please check!')
        }
      })
    } catch (error) {
      message.error(error)
    }
  }

  const confirmAddFunction = async (params) => {
    try {
      const res = await io.post(`/catalogs/${catalogDetail.catalogId}/databases/${curDatabase || form.getFieldValue('database')}/functions`, {...params})
    } catch (error) {
      message.error(error)
    }
  }

  const confirmUpdateFunction = async (params) => {
    try {
      const res = await io.put(`/catalogs/${catalogDetail.catalogId}/databases/${curDatabase || form.getFieldValue('database')}/functions/${formValues.functionId}`, {...params})
      res && getDetail()
    } catch (error) {
      message.error(error)
    }
  }

  useEffect(() => {
    formValues.database = curDatabase
    form && form.setFieldsValue({...formValues})
    form && form.setFieldValue('functionPath', functionUrl)
  }, [curDatabase, formValues])

  return (
    <Modal
      {...props}
      title={`${type === 'add' ? 'Create' : 'Edit'} Function`}
      maskClosable={false}
      onOk={() => {
        type === 'add' && confirmAddFunction(form.getFieldsValue())
        type === 'edit' && confirmUpdateFunction(form.getFieldsValue())
        switchVisible(false)
      }}
      onCancel={() => {
        switchVisible(false)
        form.resetFields()
      }}
    >
      <Form
        {...layout}
        form={form}
        style={{
          maxWidth: 600,
        }}
      >
        <Form.Item
          name="jar"
          label="jar"
        >
          <div className='FBH'>
            <Upload {...uploadProps}>
              <Button icon={<UploadOutlined />}>Click to upload</Button>
            </Upload>
            {
              functionUrl.length > 0 &&
              <Button type='primary' className='ml8'
                onClick={analysis}
              >Analysis</Button>
            }
          </div>
        </Form.Item>
        <Form.Item
          name="functionPath"
          style={{height: 0, opacity: 0, margin: 0}}
        >
          <Input />
        </Form.Item>
        <Form.Item
          name="functionName"
          label="name"
          rules={[
            {
              required: true,
            },
          ]}
        >
          <Input />
        </Form.Item>
        <Form.Item
          name="database"
          label="database"
          rules={[
            {
              required: true,
            },
          ]}
        >
          <Select disabled={type !== 'add'}>
            {databaseList.map(t => <Option key={t} value={t}>{t}</Option>)}
          </Select>
        </Form.Item>
        <Form.Item
          name="className"
          label="classname"
        >
          <Input />
        </Form.Item>
        <Form.Item
          name="invocation"
          label="Invocation"
        >
          <Input />
        </Form.Item>
        <Form.Item
          name="descr"
          label="description"
        >
          <TextArea />
        </Form.Item>
      </Form>
    </Modal>
  )
}
export default Cm