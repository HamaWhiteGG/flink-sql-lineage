import React,{useState, useEffect} from 'react'
import { Link } from 'react-router-dom'
import { Typography, Tag, Tooltip, Input, Button, message, Avatar, Table } from 'antd'
import { EditOutlined, DeleteOutlined, MoreOutlined } from '@ant-design/icons'
import axios from 'axios'
import io from '@common/io-context'
import PluginAddModal from './user-add-modal'
import { Base64 } from 'js-base64'
import dayjs from 'dayjs'

const { Title, Text } = Typography
const Cm = () => {
  const [visible, setVisible] = useState(false)
  const [userList, seUserList] = useState([])
  const [roleList, setRoleList] = useState([])
  const [curRecord, setCurRecord] = useState(null)
  const [curType, setCurType] = useState('Add')
  const pluginListMap = {}

  const getUserList = async () => {
    try {
      const res = await io.get('/users')
      seUserList(res?.list || [])
    } catch (error) {
      message.error(error)
    }
  }

  const getRoleList = async () => {
    try {
      const res = await io.get('/roles')
      setRoleList(res?.list || [])
    } catch (error) {
      message.error(error)
    }
  }

  const onCancel = () => {
    setVisible(false)
  }

  const onChangeDefault = async (checked, e, record) => {
    console.log(checked, e, record)
    try {
      const res = await io.put(`/plugins/${record.pluginId}/default`)
      res && getUserList()
    } catch (error) {
      message.error(error)
    }
  }

  useEffect(() => {
    getRoleList()
    getUserList()
  }, [])
  
  // userList.forEach(t => {
  //   pluginListMap[t.pluginId] = t.pluginName
  // })

  const addModalProps = {
    visible,
    onCancel:onCancel,
    // getCatalogList,
    type: curType,
    userList,
    roleList,
    record: curRecord,
  }

  const columns = [ {
    title: 'Id',
    dataIndex: 'roleId',
    key: 'roleId',
  }, {
    title: 'RoleName',
    dataIndex: 'roleName',
    key: 'roleName',
  },
   {
    title: 'Member',
    dataIndex: 'members',
    key: 'members',
    render: (text) => {
      return text?.map(t => t) || '--'
    }
  }, 
 
  {
    title: 'ModifyTime',
    dataIndex: 'modifyTime',
    key: 'modifyTime',
    render: (text, record) => {
      return <span>{dayjs(text).format('YYYY-MM-DD HH:mm:ss') ||  <Text type="secondary">--</Text>}</span>
    }
  },
  {
    title: 'Permission',
    dataIndex: 'permissionList',
    key: 'permissionList',
    render: (text) => {
      return text?.map(t => t) || '--'
    }
  },
  // {
  //   title: 'Action',
  //   dataIndex: 'action',
  //   key: 'action',
  //   render: () => {
  //     return <div>
  //       <Tooltip title="edit">
  //         <EditOutlined className='fc4 mr16 hand' />
  //       </Tooltip>
  //       <Tooltip title="delete">
  //         <DeleteOutlined className='fc4 mr16 hand' />
  //       </Tooltip>
  //     </div>
  //   }
  // },
]

  return (
    <div>
      <div className='m8 p24 main white-bg'>
        <div className='catalog-top-bar FBH FBJ mb16'>
          <div></div>
          <div>
            {/* <Input.Search placeholder="keywords"  size="small" style={{width: '200px'}} /> */}
            <Button type='primary' size="small" className='ml8'
              onClick={() => {
                setCurType('Add')
                setVisible(true)
              }}
              disabled
            >Add</Button>
            <PluginAddModal {...addModalProps} />
          </div>
        </div>
        <div className='catalog-list'>
          <Table columns={columns} dataSource={roleList} />
        </div>
      </div>
    </div>
  )
}
export default Cm