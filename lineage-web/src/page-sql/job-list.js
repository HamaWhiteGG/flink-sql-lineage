import React,{ useState, useEffect, useRef } from 'react'
import { Outlet, Link, useParams, useNavigate } from 'react-router-dom'
import { Breadcrumb, Tooltip, Table, Badge, Button, Modal, Form, Checkbox, Input } from 'antd'
import { PlusSquareOutlined, SearchOutlined } from '@ant-design/icons';
import Monaco from 'react-monaco-editor'
import "monaco-editor/esm/vs/basic-languages/sql/sql.contribution"
import axios from 'axios'

const AddModal = ({visible, title, onCancel, getJobList}) => {
  const [form] = Form.useForm()
  const onFinish = (values) => {
    console.log('Success:', values)
  }
  const onFinishFailed = (errorInfo) => {
    console.log('Failed:', errorInfo)
  }

  // add job
  const handleOnOk = () => {
    const {validateFields} = form
    validateFields().then(async values => {
      console.log('11', values)
      const res = await axios.post(
        `/tasks`, 
        Object.assign({catalogId: '0', database: 'string'}, {...values})
      )
      if (res) getJobList()
    })
  }

  const modalProps = {
    visible,
    title: "Add Job",
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
        span: 8,
      }}
      wrapperCol={{
        span: 16,
      }}
      style={{
        maxWidth: 600,
      }}
      initialValues={{
        remember: true,
      }}
      onFinish={onFinish}
      onFinishFailed={onFinishFailed}
      autoComplete="off"
    >
      <Form.Item
        label="name"
        name="taskName"
        rules={[
          {
            required: true,
            message: 'Please input your name!',
          },
        ]}
      >
        <Input placeholder="enter" size='small' />
      </Form.Item>

      <Form.Item
        label="desciption"
        name="descr"
        rules={[
          {
            required: true,
            message: 'Please input your desciption!',
          },
        ]}
      >
        <Input placeholder="enter" size='small' />
      </Form.Item>
    </Form>
  </Modal>
}
const Cm = () => {
  const searchRef = useRef(null)
  const [dataSource, setDataSource] = useState([])
  const [visible, setVisible] = useState(false)
  const [inputVisible, setInputVisible] = useState(false)
  
  const columns = [{
    title: 'name',
    dataIndex: 'taskName',
    key: 'taskName',
    ellipsis: true,
    render: (text, record) => <Link to={`/job/sql/${record.taskId}`}>{text}</Link>
  },{
    title: 'Status',
    dataIndex: 'taskStatus',
    key: 'taskStatus',
    align: 'center',
    render: (text) => {
      // let obj = {
      //   ''
      // }
      return <Tooltip title={text}><Badge status="success" /></Tooltip>
    }
  },{
    title: 'describe',
    dataIndex: 'descr',
    key: 'descr',
    ellipsis: true,
  },]

  // get job list
  const getJobList = async (params) => {
    const res = await axios.get(`/tasks`, {
      ...params,
      pageNum: 1,
      pageSize: 10
    })
    console.log('-----analysisSql-----', res)
    setDataSource(res.data.data.list)
  }

  const onCancel = () => {
    setVisible(false)
    
  }
  useEffect(() => {
    getJobList()
  }, [])
  return (
    <div className='left-box'>
      <div className="p16 FBH FBJ">
        <Breadcrumb separator="<">
          <Breadcrumb.Item href="#/job/list">jobs</Breadcrumb.Item>
        </Breadcrumb>
        <Input 
          ref={searchRef} 
          placeholder={inputVisible && `enter keywords`} 
          bordered={false} 
          size='small' 
          disabled={!inputVisible}
          onBlur={(e) => {
            setInputVisible(false)
            // if (e.target.value.trim() === '') {
            //   setDataSource([])
            // }
          }}
          onKeyDown={(e) => {
            getJobList(e)
          }}
        />
        
        <Tooltip title="search job">
          <SearchOutlined className='mr8 fs16 fc7 hand' 
            onClick={async() => {
              await setInputVisible(true)
              searchRef.current.focus()
            }}
          />
        </Tooltip>
        <Tooltip title="add job">
          <PlusSquareOutlined className='fs16 fc7' onClick={() => setVisible(true)} />
        </Tooltip>
      </div>
      <div>
        <Table
          size="small"
          dataSource={dataSource}
          columns={columns}
        />
      </div>
      <AddModal visible={visible} onCancel={onCancel} getJobList={getJobList}/>
    </div>
  )
}

export default Cm