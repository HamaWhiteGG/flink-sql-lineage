import React,{ useState, useEffect, useRef } from 'react'
import { Outlet, Link, useOutletContext, useNavigate, useLocation } from 'react-router-dom'
import { Breadcrumb, Tooltip, Table, Badge, Button, Modal, Form, Checkbox, Input, Select, message } from 'antd'
import { BranchesOutlined, EditOutlined, DeleteOutlined, PlusSquareOutlined, SearchOutlined, ExclamationCircleOutlined } from '@ant-design/icons';
import Monaco from 'react-monaco-editor'
import "monaco-editor/esm/vs/basic-languages/sql/sql.contribution"
import axios from 'axios'

const { Option } = Select
const { confirm } = Modal
const AddModal = ({visible, onCancel, getJobList, record, type='Add', catalogList=[]}) => {
  const [form] = Form.useForm()
  const [databaseList, setDatabaseList] = useState([])
  const onFinish = (values) => {
    console.log('Success:', values)
  }
  const onFinishFailed = (errorInfo) => {
    console.log('Failed:', errorInfo)
  }

  // add job || edit job
  const handleOnOk = () => {
    const {validateFields} = form
    validateFields().then(async values => {
      let res = null
      switch (type) {
        case 'Add':
          res = await axios.post(
            `/tasks`, 
            {...values}
          )
          break;
        case 'Edit':
          res = await axios.put(
            `/tasks/${record.taskId}`, 
            {...values}
          )
          break;
        default:
          res = await axios.post(
            `/tasks`, 
            {...values}
          )
          break;
      }
      
      if (res) {
        onCancel()
        getJobList()
      }
    })
  }

  // get database under catalogs
  const getDatabase = async (id) => {
    try {
      const res = await axios.get(`/catalogs/${id}/databases`)
      const resDatabase = res?.data?.data
      await setDatabaseList(resDatabase || [])
      form.setFieldValue('database', resDatabase[0])
    } catch (e) {
      message.error(e)
    }
  }

  const onChangeCatalog = e => {
    getDatabase(e)
  }

  useEffect(() => {
    if (form && visible && type === 'Edit') {
      form.setFieldsValue({...record})
    } else {
      form.resetFields()
    }
  }, [visible])

  const modalProps = {
    visible,
    title: `${type} Job`,
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
        label="catalog"
        name="catalogId"
        rules={[
          {
            required: true,
            message: 'Please input your catalog!',
          },
        ]}
      >
        <Select placeholder='catalog' onChange={e => onChangeCatalog(e)}>
          {
            catalogList.map(t => <Option key={t.catalogId} value={t.catalogId}>{t.catalogName}</Option>)
          }
        </Select>
      </Form.Item>
      <Form.Item
        label="database"
        name="database"
        rules={[
          {
            required: true,
            message: 'Please input your database!',
          },
        ]}
      >
        <Select placeholder='database'>
          {
            databaseList?.map(t => <Option key={t} value={t}>{t}</Option>)
          }
        </Select>
      </Form.Item>
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
  const navigation = useNavigate()
  const location = useLocation()
  const { analysisSql, catalogList } = useOutletContext()
  const searchRef = useRef(null)
  const [dataSource, setDataSource] = useState([])
  const [visible, setVisible] = useState(false)
  const [inputVisible, setInputVisible] = useState(false)
  const [curTaskId, setCurTaskId] = useState(null)
  const [curRecord, setCurRecord] = useState(null)
  const [curType, setCurType] = useState('add')
  
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
      let obj = {
        'FAILED': 'error', 
        'INIT': 'default', 
        'MODIFIED': 'warning', 
        'RUNNING': 'processing', 
        'SUCCESS': 'success'
      }
      return <Tooltip title={text}><Badge status={obj[text]} /></Tooltip>
    }
  },{
    title: 'describe',
    dataIndex: 'descr',
    key: 'descr',
    ellipsis: true,
  },{
    title: '',
    dataIndex: 'action',
    key: 'action',
    width: 80,
    render: (text, record) => {
      const { taskId } = record
      return taskId === curTaskId && <span>
        <Tooltip title=''><BranchesOutlined className='fc-pr hand mr8' onClick={() => analysisSql(taskId)} /></Tooltip>
        <Tooltip title=''>
          <EditOutlined className='fc-pr hand mr8' onClick={() => {
            setVisible(true)
            setCurType('Edit')
          }} />
        </Tooltip>
        <Tooltip title=''><DeleteOutlined className='fc-pr hand' onClick={() => deletConfirm(taskId)} /></Tooltip>
      </span>
    },
    shouldCellUpdate: (record, prevRecord) => {
      return record !== curTaskId || prevRecord?.taskId === curTaskId
    }
  },]

  // get job list
  const getJobList = async (params) => {
    const res = await axios.get(`/tasks`, {
      ...params,
      pageNum: 1,
      pageSize: 10
    })
    const {list} = res.data.data
    setDataSource(list)
    // if url from login
    if(location.state.pageUrl === 'login') {
      navigation(`/job/sql/${list[0].taskId}`)
    }
  }

  // delet job confirm
  const deletConfirm = id => {
    confirm({
      title: 'Do you Want to delete these items?',
      icon: <ExclamationCircleOutlined />,
      // content: 'Some descriptions',
      onOk: () => deletJob(id)
    })
  }

  // delet job
  const deletJob = async id => {
    try {
      const res = await axios.delete(`/tasks/${id}`)
      if (res?.data?.data) getJobList()
    } catch (e) {
      message.error(e)
    }
  }

  const onCancel = () => {
    setVisible(false)
  }

  useEffect(() => {
    getJobList()
  }, [])

  const addModalProps = {
    visible,
    onCancel:onCancel,
    getJobList,
    record: curRecord,
    type: curType,
    catalogList
  }

  return (
    <div className='left-box'>
      <div className="p16 FBH FBJ">
        <Breadcrumb separator="<">
          <Breadcrumb.Item>Job</Breadcrumb.Item>
        </Breadcrumb>
        <Input 
          ref={searchRef} 
          placeholder={inputVisible && `enter keywords`} 
          bordered={false} 
          size='small' 
          disabled={!inputVisible}
          onBlur={(e) => {
            setInputVisible(false)
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
          <PlusSquareOutlined 
            className='fs16 fc7' 
            onClick={() => {
              setVisible(true)
              setCurType('Add')
            }}
          />
        </Tooltip>
      </div>
      <div className='m16 p8 gray-bd r4'>
        <Table
          size="small"
          dataSource={dataSource}
          columns={columns}
          onRow={(record) => {
            return {
              onMouseEnter: (event) => {
                setCurTaskId(record?.taskId)
                setCurRecord(record)
              },
              onMouseLeave: (event) => setCurTaskId(null),
            };
          }}
          
        />
      </div>
      <AddModal {...addModalProps}/>
    </div>
  )
}

export default Cm