import React,{useState, useEffect, createContext} from 'react'
import { Link } from 'react-router-dom'
import { Typography, Tag, Tooltip, Input, Button, message, Modal, Dropdown } from 'antd'
import { EditOutlined, DeleteOutlined, MoreOutlined } from '@ant-design/icons'
import axios from 'axios'
import io from '@common/io-context'
import CatalogAddModal from './catalog-add-modal'
import HIVE from './img/HIVE.svg'

const { Title, Text } = Typography
const Cm = () => {
  const [modal, contextHolder] = Modal.useModal()
  const ReachableContext = createContext(null);
  const UnreachableContext = createContext(null);
  const [visible, setVisible] = useState(false)
  const [catalogList, setCatalogList] = useState([])
  const [pluginList, setPluginList] = useState([])
  const [curRecord, setCurRecord] = useState(null)
  const [curType, setCurType] = useState('Add')
  const pluginListMap = {}

  const getCatalogList = async () => {
    try {
      const res = await axios.get('/catalogs')
      setCatalogList(res.data.data?.list || [])
    } catch (error) {
      message(error)
    }
  }

  const getPluginList = async () => {
    try {
      const res = await axios.get('/plugins')
      setPluginList(res?.data?.data?.list || [])
    } catch (error) {
      message(error)
    }
  }

  const onCancel = () => {
    setVisible(false)
  }

  useEffect(() => {
    getCatalogList()
    getPluginList()
  }, [])
  
  pluginList.forEach(t => {
    pluginListMap[t.pluginId] = t.pluginName
  })

  const addModalProps = {
    visible,
    onCancel:onCancel,
    getCatalogList,
    type: curType,
    pluginList,
    record: curRecord,
  }

  const getDelConfig = t => {
      return {
      title: 'Delet',
      content: (
        <>
          Do you want to delete this catalog, it well destroy all lineages, and cannot be recovered？
        </>
      ),
      okText: 'Yes',
      cancelText: 'No',
      onOk: async () => {
        try {
          const res = await io.delete(`/catalogs/${t.catalogId}`)
          res && getCatalogList()
        } catch (error) {
          message.error(error)
        }
      }
    }
  }

  const getDefaultConfig = t => {
    return {
      title: 'Confirm',
      content: (
        <>
          Are you sure you want to set this catalog for default？
        </>
      ),
      okText: 'Yes',
      cancelText: 'No',
      onOk: async () => {
        try {
          const res = await io.put(`/catalogs/${t.catalogId}/default`)
          res && getCatalogList()
        } catch (error) {
          message.error(error)
        }
      }
    }
  }
  
  const getItems = (t) => {
    return [{
      key: '1',
      label: (
        <span className='hand' onClick={() => {
          modal.confirm(getDefaultConfig(t))
        }}>
          set default
        </span>
      ),
    }]
  }
  return (
    <div>
      <div className='m8 p16 white-bg'>
        <div className='fs28 mb16'>Catalog Management</div>
        <Text>
          Catalogs provide metadata, such as databases, tables, partitions, views, and functions and information needed to access data stored in a database or other external systems.
        </Text>
      </div>
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
            >Add</Button>
            <CatalogAddModal {...addModalProps} />
          </div>
        </div>
        {/* catalog-list */}
        <div className='catalog-list'>
          {
            catalogList?.map(t => 
              <div className='list-item-wrapper'>
              <Link to={`/catalog/${t.catalogId}`}>
              <div className='list-item FBH FBJS gray-bd r4 p16 mb24'>
                <div className='item-logo pr24'>
                  {/* logo */}
                  <img src={HIVE} />
                </div>
                <div className='item-content'>
                  <div className='item-top FBH FBJ mb16'>
                    <div><Link className='fs24 mr8 fc0' to={`/catalog/${t.catalogId}`}>{t.catalogName}</Link> {t.defaultCatalog && <Tag>default</Tag>}</div>
                    
                  </div>
                  <div className='item-info FBH FBJ'>
                    <span className='i-label'>Type：{t.catalogType}</span>
                    <span className='i-label'>Database：{t.defaultDatabase}</span>
                    <span className='i-label'>Plugin：{pluginListMap[t.pluginId]}</span>
                  </div>
                  <div className='item-info FBH FBJ'>
                    <span className='i-label'>Description：{t.descr}</span>
                  </div>
                </div>
                
              </div>
              </Link>
              <div className='options'>
                <Tooltip title="edit">
                  <EditOutlined className='fc4 mr16 hand' onClick={() => {
                    setCurType('Edit')
                    setVisible(true)
                    setCurRecord(t)
                  }} />
                </Tooltip>
                {
                  !t.defaultCatalog && 
                  <Tooltip title="delete">
                    <DeleteOutlined className='fc4 mr12 hand' onClick={() => {
                      modal.confirm(getDelConfig(t))
                    }} />
                  </Tooltip>
                }
                
                {/* <Tooltip title="more"> */}
                <Dropdown
                  menu={{
                    items: getItems(t)
                  }}
                  placement="bottom"
                  arrow
                >
                  <MoreOutlined className='fc4 hand'  />
                </Dropdown>
                {/* </Tooltip> */}
              </div>
              {contextHolder}
              </div>
            )
          }
          
        </div>
      </div>
    </div>
  )
}
export default Cm