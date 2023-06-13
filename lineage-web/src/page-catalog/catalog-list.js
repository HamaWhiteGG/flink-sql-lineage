import React,{useState, useEffect} from 'react'
import { Link } from 'react-router-dom'
import { Typography, Tag, Tooltip, Input, Button, message } from 'antd'
import { EditOutlined, DeleteOutlined, MoreOutlined } from '@ant-design/icons'
import axios from 'axios'
import CatalogAddModal from './catalog-add-modal'

const { Title, Text } = Typography
const Cm = () => {
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

  return (
    <div>
      <div className='m8 p16 white-bg'>
        <div className='fs28 mb16'>Catalog</div>
        <Text>
          Catalogs provide metadata, such as databases, tables, partitions, views, and functions and information needed to access data stored in a database or other external systems.
        </Text>
      </div>
      <div className='m8 p24 main white-bg'>
        <div className='catalog-top-bar FBH FBJ mb16'>
          <div></div>
          <div>
            <Input.Search placeholder="keywords"  size="small" style={{width: '200px'}} />
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
              <div className='list-item FBH FBJS gray-bd r4 p16 mb24'>
                <div className='item-logo pr24'>
                  logo
                </div>
                <div className='item-content'>
                  <div className='item-top FBH FBJ mb16'>
                    <div><Link className='fs24 mr8 fc0' to={`/catalog/${t.catalogId}`}>{t.catalogName}</Link> {t.defaultCatalog && <Tag>default</Tag>}</div>
                    <div className='options'>
                      <Tooltip title="edit">
                        <EditOutlined className='fc4 mr16 hand' onClick={() => {
                          setCurType('Edit')
                          setVisible(true)
                          setCurRecord(t)
                        }} />
                      </Tooltip>
                      <Tooltip title="delete">
                        <DeleteOutlined className='fc4 mr12 hand' />
                      </Tooltip>
                      <Tooltip title="more">
                        <MoreOutlined className='fc4 hand' />
                      </Tooltip>
                    </div>
                  </div>
                  <div className='item-info FBH FBJ'>
                    <span className='i-label'>CatalogType：{t.catalogType}</span>
                    <span className='i-label'>DefaultDatabase：{t.defaultDatabase}</span>
                    <span className='i-label'>plugin：{pluginListMap[t.pluginId]}</span>
                  </div>
                  <div className='item-info FBH FBJ'>
                    <span className='i-label'>Describe：{t.descr}</span>
                  </div>
                </div>
                
              </div>
            )
          }
          
        </div>
      </div>
    </div>
  )
}
export default Cm